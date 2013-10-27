package com.fixent.sm.client.changeyear.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import com.fixent.sm.client.changeyear.view.ChangeYearView;
import com.fixent.sm.client.common.BaseController;
import com.fixent.sm.server.model.info.ChangeYearInfo;
import com.fixent.sm.server.service.impl.StudentServiceImpl;

public class ChangeYearControler extends BaseController {

	public ChangeYearView view;

	public ChangeYearControler() {
		
		view = new ChangeYearView();
		view.getFromYearComboBox().setModel(getYears());
		view.getSaveButton().addActionListener(new SaveAction(view));
		view.getFromYearComboBox().addItemListener(new FromYearListener());
		view.getFromTypeComboBox().addItemListener(new FromTypeListener());
	}

	class FromYearListener implements ItemListener {

		public FromYearListener() {
		}

		@Override
		public void itemStateChanged(ItemEvent e) {

			setErrorMsg("");
			if (e.getStateChange() == ItemEvent.SELECTED) {
				String selectedItem = (String) view.getFromYearComboBox()
						.getSelectedItem();
				if (selectedItem == null || selectedItem.equals("Select One")) {
					return;
				} else {
					int toYear = Integer.parseInt(selectedItem);
					view.getToYearComboBox().addItem(toYear + 1);
					view.getToYearComboBox().setSelectedItem(toYear + 1);
				}
			}
		}
	}

	class FromTypeListener implements ItemListener {

		public FromTypeListener() {
		}

		@Override
		public void itemStateChanged(ItemEvent e) {

			setErrorMsg("");
			if (e.getStateChange() == ItemEvent.SELECTED) {
				String selectedItem = (String) view.getFromTypeComboBox()
						.getSelectedItem();
				if (selectedItem == null || selectedItem.equals("Select One")) {
					return;
				} else {
					int toType = Integer.parseInt(selectedItem);
					view.getToTypeComboBox().addItem(toType + 1);
					view.getToTypeComboBox().setSelectedItem(toType + 1);
				}
			}
		}
	}

	class SaveAction implements ActionListener {

		ChangeYearView view;

		public SaveAction(ChangeYearView view) {
			this.view = view;
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			setErrorMsg("");
			if (!"Select One".equalsIgnoreCase(view.getFromYearComboBox()
					.getSelectedItem().toString())
					&& !"Select One"
							.equalsIgnoreCase(view.getFromTypeComboBox()
									.getSelectedItem().toString())) {
				int fromYear = Integer.parseInt(view.getFromYearComboBox()
						.getSelectedItem().toString());
				int fromType = Integer.parseInt(view.getFromTypeComboBox()
						.getSelectedItem().toString());
				int toYear = Integer.parseInt(view.getToYearComboBox()
						.getSelectedItem().toString());
				int toType = Integer.parseInt(view.getToTypeComboBox()
						.getSelectedItem().toString());
				ChangeYearInfo info = new ChangeYearInfo();
				info.setFromYear(fromYear);
				info.setFromType(fromType);
				info.setToYear(toYear);
				info.setToType(toType);
				StudentServiceImpl serviceImpl = new StudentServiceImpl();
				boolean result = serviceImpl.changeYear(info);
				if (result) {
					setErrorMsg("Records updated successfully");
				}
			}
		}

	}

	private void setErrorMsg(String msg) {

		view.getMsgLable().setText(msg);
	}

}