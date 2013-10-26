package com.fixent.sm.client.maintenance.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.List;

import javax.swing.JDialog;

import com.fixent.sm.client.maintenance.view.CongregationView;
import com.fixent.sm.client.maintenance.view.DioceseView;
import com.fixent.sm.client.maintenance.view.DiocesecongregationView;
import com.fixent.sm.server.model.Congregation;
import com.fixent.sm.server.model.Diocese;
import com.fixent.sm.server.service.impl.ConfigurationServiceImpl;

public class DioceseCongregationController {

	public DiocesecongregationView view;
	JDialog diocesePopup;
	JDialog congregationPopup;
	Diocese diocese;
	Congregation congregation;
	List<Diocese> dioceses;
	List<Congregation> congregations;

	public DioceseCongregationController() {

		view = new DiocesecongregationView();

		view.getDioceseAddButton().addActionListener(new AddDioceseAction());
		view.getDioceseDeleteButton().addActionListener(
				new DeleteDioceseAction());

		view.getCongregationAddButton().addActionListener(
				new AddCongregationAction());
		view.getCongregationDeleteButton().addActionListener(
				new DeleteCongregationAction());
		view.getDioceseTable().addMouseListener(
				new DioceseTableClickAction());
		view.getCongregationTable().addMouseListener(
				new CongregationTableClickAction());
		setView();
	}

	private void setView() {

		setCongregationView();
		setDioceseView();
	}

	private void setDioceseView() {

		ConfigurationServiceImpl impl = new ConfigurationServiceImpl();
		dioceses = impl.getDioceses();
		DioceseListDataTable model1 = new DioceseListDataTable(dioceses);
		view.getDioceseTable().setModel(model1);
		view.getDioceseTable().getColumnModel().getColumn(0)
				.setPreferredWidth(35);
		view.getDioceseTable().getColumnModel().getColumn(0).setMaxWidth(35);

	}

	private void setCongregationView() {

		ConfigurationServiceImpl impl = new ConfigurationServiceImpl();
		congregations = impl.getCongregations();
		CongregationListDataTable model = new CongregationListDataTable(
				congregations);
		view.getCongregationTable().setModel(model);
		view.getCongregationTable().getColumnModel().getColumn(0)
				.setPreferredWidth(35);
		view.getCongregationTable().getColumnModel().getColumn(0)
				.setMaxWidth(35);

	}

	class AddDioceseAction implements ActionListener {

		public AddDioceseAction() {
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			DioceseView dioceseView = new DioceseView();
			dioceseView.getSaveButton().addActionListener(
					new SaveDioceseAction(dioceseView));
			dioceseView.getCancelButton().addActionListener(
					new CancelDioceseAction());
			diocesePopup = new JDialog();
			diocesePopup.add(dioceseView);
			diocesePopup.setSize(400, 300);
			diocesePopup.setLocationRelativeTo(null);
			diocesePopup.setVisible(true);

		}
	}

	class SaveDioceseAction implements ActionListener {

		DioceseView view = null;

		public SaveDioceseAction(DioceseView view) {
			this.view = view;
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			ConfigurationServiceImpl impl = new ConfigurationServiceImpl();
			if (diocese == null) {
				diocese = new Diocese();
				diocese.setName(view.getDioceseNameTextField().getText());
				diocese.setCreatedBy("Admin");
				diocese.setCreatedDate(new Date());
				impl.createDioceses(diocese);
			} else {
				diocese.setName(view.getDioceseNameTextField().getText());
				diocese.setUpdatedBy("Admin");
				diocese.setUpdatedDate(new Date());
				impl.modifyDiocese(diocese);
			}
			setDioceseView();
			diocesePopup.dispose();

		}

	}

	class CancelDioceseAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			diocesePopup.dispose();
		}

	}

	class DeleteDioceseAction implements ActionListener {

		public DeleteDioceseAction() {
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			final int row = view.getDioceseTable().getSelectedRow();
			Diocese deletedObject = dioceses.get(row);
			ConfigurationServiceImpl impl = new ConfigurationServiceImpl();
			impl.deleteDiocese(deletedObject.getId());
			setDioceseView();

		}

	}

	class AddCongregationAction implements ActionListener {

		public AddCongregationAction() {
			// TODO Auto-generated constructor stub
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			CongregationView congregationView = new CongregationView();
			congregationView.getSaveButton().addActionListener(
					new SaveCongregationAction(congregationView));
			congregationView.getCancelButton().addActionListener(
					new CancelCongregationAction());
			congregationPopup = new JDialog();
			congregationPopup.add(congregationView);
			congregationPopup.setSize(400, 300);
			congregationPopup.setLocationRelativeTo(null);
			congregationPopup.setVisible(true);

		}
	}

	class SaveCongregationAction implements ActionListener {

		CongregationView view = null;

		public SaveCongregationAction(CongregationView view) {
			this.view = view;
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			ConfigurationServiceImpl impl = new ConfigurationServiceImpl();
			if (congregation == null)
			{
				congregation = new Congregation();
				congregation.setName(view.getCongrgationNameTextField().getText());
				congregation.setCreatedBy("Admin");
				congregation.setCreatedDate(new Date());
				impl.createCongregation(congregation);
			} else {
				congregation.setName(view.getCongrgationNameTextField().getText());
				congregation.setUpdatedBy("Admin");
				congregation.setUpdatedDate(new Date());
				impl.modifyCongregation(congregation);
			}
			setCongregationView();
			congregationPopup.dispose();

		}

	}

	class CancelCongregationAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			congregationPopup.dispose();
		}

	}

	class DeleteCongregationAction implements ActionListener {

		public DeleteCongregationAction() {
			// TODO Auto-generated constructor stub
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			final int row = view.getCongregationTable().getSelectedRow();
			Congregation deletedObject = congregations.get(row);
			ConfigurationServiceImpl impl = new ConfigurationServiceImpl();
			impl.deleteCongregation(deletedObject.getId());
			setCongregationView();
		}
	}

	class DioceseTableClickAction extends MouseAdapter {

		public void mouseClicked(MouseEvent e) {

			if (e.getClickCount() == 2) {
				final int row = view.getDioceseTable().getSelectedRow();
				diocese = dioceses.get(row);
				DioceseView dioceseView = new DioceseView();
				dioceseView.getSaveButton().addActionListener(
						new SaveDioceseAction(dioceseView));
				dioceseView.getCancelButton().addActionListener(
						new CancelDioceseAction());
				dioceseView.getDioceseNameTextField().setText(diocese.getName());
				diocesePopup = new JDialog();
				diocesePopup.add(dioceseView);
				diocesePopup.setSize(400, 300);
				diocesePopup.setLocationRelativeTo(null);
				diocesePopup.setVisible(true);
			}
		}
	}
	
	class CongregationTableClickAction extends MouseAdapter {

		public void mouseClicked(MouseEvent e) {

			if (e.getClickCount() == 2) {
				final int row = view.getCongregationTable().getSelectedRow();
				congregation = congregations.get(row);
				CongregationView congregationView = new CongregationView();
				congregationView.getSaveButton().addActionListener(
						new SaveCongregationAction(congregationView));
				congregationView.getCancelButton().addActionListener(
						new CancelCongregationAction());
				congregationView.getCongrgationNameTextField().setText(congregation.getName());
				congregationPopup = new JDialog();
				congregationPopup.add(congregationView);
				congregationPopup.setSize(400, 300);
				congregationPopup.setLocationRelativeTo(null);
				congregationPopup.setVisible(true);
			}
		}
	}


}
