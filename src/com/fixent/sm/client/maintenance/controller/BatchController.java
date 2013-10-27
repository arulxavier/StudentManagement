package com.fixent.sm.client.maintenance.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JDialog;

import com.fixent.sm.client.common.BaseController;
import com.fixent.sm.client.common.ClientConstants;
import com.fixent.sm.client.maintenance.view.BatchListView;
import com.fixent.sm.client.maintenance.view.BatchPopUP;
import com.fixent.sm.server.model.Batch;
import com.fixent.sm.server.service.impl.ConfigurationServiceImpl;

public class BatchController extends BaseController {

	public BatchListView view;
	JDialog batchPopUp;
	List<Batch> batches;
	Batch batch;
	String screedMode;

	public BatchController() {

		view = new BatchListView();
		view.getBatchTable().addMouseListener(new BatchTableClickAction());
		view.getAddButton().addActionListener(new AddButtonAction());
		view.getDeleteButton().addActionListener(new DeleteButtonAction());
		setView();

	}

	private void setView() {

		setSubjectView();
	}

	private void setSubjectView() {

		ConfigurationServiceImpl impl = new ConfigurationServiceImpl();
		batches = impl.getAllBatchs();
		BatchListDataTable model = new BatchListDataTable(batches);
		view.getBatchTable().setModel(model);
		view.getBatchTable().getColumnModel().getColumn(0)
				.setPreferredWidth(55);
		view.getBatchTable().getColumnModel().getColumn(0).setMaxWidth(55);
	}

	class AddButtonAction implements ActionListener {

		public AddButtonAction() {
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			setErrorMsg("");
			screedMode = ClientConstants.ADD;
			BatchPopUP view = new BatchPopUP();
			view.getSaveButton().addActionListener(new SavePopUPAction(view));
			view.getCancelButton().addActionListener(new CancelBatchAction());
			batchPopUp = new JDialog();
			batchPopUp.add(view);
			batchPopUp.setSize(425, 300);
			batchPopUp.setResizable(false);
			batchPopUp.setLocationRelativeTo(null);
			batchPopUp.setVisible(true);

		}
	}

	class SavePopUPAction implements ActionListener {

		BatchPopUP view = null;

		public SavePopUPAction(BatchPopUP view) {
			this.view = view;
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			setErrorMsg("");
			ConfigurationServiceImpl impl = new ConfigurationServiceImpl();
			if (batch == null) {

				batch = new Batch();
				batch.setYear(Integer.parseInt(view.getYearTxt().getText()));
				batch.setType(view.getYearTypeComboBox().getSelectedItem()
						.toString());
				boolean status = checkForDuplciates(batch);
				if (status) {
					setErrorMsg("Duplicate Batch Entry");
				} else {
					impl.createBatch(batch);
					setSubjectView();
				}
			} else {

				Batch locBatch = new Batch();
				locBatch.setId(batch.getId());
				locBatch.setYear(Integer.parseInt(view.getYearTxt().getText()));
				locBatch.setType(view.getYearTypeComboBox().getSelectedItem()
						.toString());
				boolean status = checkForDuplciates(locBatch);
				if (status) {
					setErrorMsg("Duplicate Batch Entry");
				} else {
					impl.modifyBatch(locBatch);
					setSubjectView();
				}
			}

			batch = null;
			batchPopUp.dispose();
		}

		private boolean checkForDuplciates(Batch paramBatch) {

			boolean status = false;
			if (batches != null && !batches.isEmpty()) {

				for (Batch localBatch : batches) {

					if (paramBatch.getType() != null
							&& localBatch.getType() != null
							&& localBatch.getType().equalsIgnoreCase(
									paramBatch.getType())
							&& localBatch.getYear() == paramBatch.getYear()) {
						if (ClientConstants.MODIFY.equalsIgnoreCase(screedMode)
								&& localBatch.getId() != paramBatch.getId()) {
							status = true;
							break;
						} else if (ClientConstants.ADD
								.equalsIgnoreCase(screedMode)) {
							status = true;
							break;
						}
					}
				}
			}
			return status;
		}
	}

	class CancelBatchAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			setErrorMsg("");
			batch = null;
			batchPopUp.dispose();
		}

	}

	class DeleteButtonAction implements ActionListener {

		public DeleteButtonAction() {
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			setErrorMsg("");
			final int row = view.getBatchTable().getSelectedRow();
			Batch deleteObject = batches.get(row);
			ConfigurationServiceImpl impl = new ConfigurationServiceImpl();
			if (!impl.deleteBatch(deleteObject.getId())) {

				setErrorMessages(view.getParent(),
						"Cannot delete batch  when it is associated with student");
			}

			setSubjectView();

		}

	}

	class BatchTableClickAction extends MouseAdapter {

		public void mouseClicked(MouseEvent e) {

			setErrorMsg("");
			if (e.getClickCount() == 2) {
				screedMode = ClientConstants.MODIFY;
				BatchPopUP popUP = new BatchPopUP();
				popUP.getSaveButton().addActionListener(
						new SavePopUPAction(popUP));
				popUP.getCancelButton().addActionListener(
						new CancelBatchAction());
				final int row = view.getBatchTable().getSelectedRow();
				batch = batches.get(row);
				popUP.getYearTxt().setText(String.valueOf(batch.getYear()));
				popUP.getYearTypeComboBox().setSelectedItem(batch.getType());
				batchPopUp = new JDialog();
				batchPopUp.add(popUP);
				batchPopUp.setSize(400, 400);
				batchPopUp.setLocationRelativeTo(null);
				batchPopUp.setVisible(true);
			}
		}
	}

	private void setErrorMsg(String msg) {
		setErrorMessages(view.getParent(), msg);
	}

}