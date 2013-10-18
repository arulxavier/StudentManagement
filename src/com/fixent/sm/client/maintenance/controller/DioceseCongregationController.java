package com.fixent.sm.client.maintenance.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	
	
	public DioceseCongregationController() {
		
		view = new DiocesecongregationView();
		
		view.getDioceseAddButton().addActionListener(new AddDioceseAction());
		view.getDioceseDeleteButton().addActionListener(new DeleteDioceseAction());
		
		view.getCongregationAddButton().addActionListener(new AddCongregationAction());
		view.getCongregationDeleteButton().addActionListener(new DeleteCongregationAction());
		setView();
	}

	private void setView() {
		
		setCongregationView();
		setDioceseView();
	}
	
	private void setDioceseView() {

		ConfigurationServiceImpl impl = new ConfigurationServiceImpl();
		List<Diocese> dioceses = impl.getDioceses();
		DioceseListDataTable model1 = new DioceseListDataTable(dioceses);
		view.getDioceseTable().setModel(model1);
		
	}

	private void setCongregationView() {
		
		ConfigurationServiceImpl impl = new ConfigurationServiceImpl();
		List<Congregation> congregations = impl.getCongregations();
		CongregationListDataTable model = new CongregationListDataTable(congregations);
		view.getCongregationTable().setModel(model);
		
	}

	class AddDioceseAction
	implements ActionListener {
		
		public AddDioceseAction() {
			// TODO Auto-generated constructor stub
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			DioceseView view = new DioceseView();
			view.getSaveButton().addActionListener(new SaveDioceseAction(view));
			view.getCancelButton().addActionListener(new CancelDioceseAction());
			
			diocesePopup = new JDialog();
			diocesePopup.add(view);
			diocesePopup.setSize(400, 300);
			diocesePopup.setLocationRelativeTo(null);
			diocesePopup.setVisible(true);
			
		}
	}
	
	class SaveDioceseAction
	implements ActionListener {
		
		DioceseView view = null;
		public SaveDioceseAction(DioceseView view) {
			this.view = view;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			Diocese diocese = new Diocese();
			diocese.setName(view.getDioceseNameTextField().getText());
			diocese.setCreatedBy("Admin");
			diocese.setCreatedDate(new Date());
			ConfigurationServiceImpl impl = new ConfigurationServiceImpl();
			impl.createDioceses(diocese);
			setDioceseView();
			diocesePopup.dispose();
			
		}
		
		
	}
	
	class CancelDioceseAction
	implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			diocesePopup.dispose();
		}
		
		
	}
	
	class DeleteDioceseAction
	implements ActionListener {

		public DeleteDioceseAction() {
			// TODO Auto-generated constructor stub
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
	          final int row = view.getDioceseTable().getSelectedRow();
//	          final int column = view.getSubjectCategoryTable().getSelectedColumn();
	          System.out.println(view.getDioceseTable().getValueAt(row, 0));
	          ConfigurationServiceImpl impl = new ConfigurationServiceImpl();
	          impl.deleteDiocese(Integer.parseInt(view.getDioceseTable().getValueAt(row, 0).toString()));
	          setDioceseView();
			
		}
		
	}
	
	class AddCongregationAction
	implements ActionListener {
		
		public AddCongregationAction() {
			// TODO Auto-generated constructor stub
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			CongregationView view = new CongregationView();
			view.getSaveButton().addActionListener(new SaveCongregationAction(view));
			view.getCancelButton().addActionListener(new CancelCongregationAction());
			congregationPopup = new JDialog();
			congregationPopup.add(view);
			congregationPopup.setSize(400, 300);
			congregationPopup.setLocationRelativeTo(null);
			congregationPopup.setVisible(true);
			
		}
	}
	
	class SaveCongregationAction
	implements ActionListener {
		
		CongregationView view = null;
		public SaveCongregationAction(CongregationView view) {
			this.view = view;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			System.out.println("Save Action");
			Congregation congregation = new Congregation();
			congregation.setName(view.getCongrgationNameTextField().getText());
			congregation.setCreatedBy("Admin");
			congregation.setCreatedDate(new Date());
			ConfigurationServiceImpl impl = new ConfigurationServiceImpl();
			impl.createCongregation(congregation);
			setCongregationView();
			congregationPopup.dispose();
			
		}

	}
	
	class CancelCongregationAction
	implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			congregationPopup.dispose();
		}
		
		
	}
	
	class DeleteCongregationAction
	implements ActionListener {

		public DeleteCongregationAction() {
			// TODO Auto-generated constructor stub
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
	          final int row = view.getCongregationTable().getSelectedRow();
//	          final int column = view.getSubjectTable().getSelectedColumn();
	          System.out.println(view.getCongregationTable().getValueAt(row, 0));
	          ConfigurationServiceImpl impl = new ConfigurationServiceImpl();
	          impl.deleteCongregation(Integer.parseInt(view.getCongregationTable().getValueAt(row, 0).toString()));
	          setCongregationView();
			
		}
		
	}

}
