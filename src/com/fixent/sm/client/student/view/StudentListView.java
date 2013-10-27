/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fixent.sm.client.student.view;

/**
 *
 * @author Mathan
 */
public class StudentListView extends javax.swing.JPanel {

    /**
     * Creates new form StudentListView
     */
    public StudentListView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        studentListTable = new javax.swing.JTable();
        modifyButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        viewButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        studentListTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        studentListTable.setFillsViewportHeight(true);
        jScrollPane1.setViewportView(studentListTable);

        modifyButton.setBackground(new java.awt.Color(61, 86, 109));
        modifyButton.setForeground(new java.awt.Color(255, 255, 255));
        modifyButton.setText("Modify");

        deleteButton.setBackground(new java.awt.Color(61, 86, 109));
        deleteButton.setForeground(new java.awt.Color(255, 255, 255));
        deleteButton.setText("Delete");

        cancelButton.setBackground(new java.awt.Color(61, 86, 109));
        cancelButton.setForeground(new java.awt.Color(255, 255, 255));
        cancelButton.setText("Cancel");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Student List View");

        viewButton.setBackground(new java.awt.Color(61, 86, 109));
        viewButton.setForeground(new java.awt.Color(255, 255, 255));
        viewButton.setText("View");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(deleteButton)
                        .addComponent(cancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(modifyButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(viewButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(8, 8, 8)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(viewButton)
                .addGap(10, 10, 10)
                .addComponent(modifyButton)
                .addGap(10, 10, 10)
                .addComponent(deleteButton)
                .addGap(10, 10, 10)
                .addComponent(cancelButton)
                .addGap(19, 19, 19))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton modifyButton;
    private javax.swing.JTable studentListTable;
    private javax.swing.JButton viewButton;
    // End of variables declaration//GEN-END:variables
	public javax.swing.JTable getStudentListTable() {
		return studentListTable;
	}

	public void setStudentListTable(javax.swing.JTable studentListTable) {
		this.studentListTable = studentListTable;
	}

	public javax.swing.JButton getViewBtn() {
		return viewButton;
	}

	public void setViewBtn(javax.swing.JButton viewBtn) {
		this.viewButton = viewBtn;
	}

	public javax.swing.JButton getCancelButton() {
		return cancelButton;
	}

	public void setCancelButton(javax.swing.JButton cancelButton) {
		this.cancelButton = cancelButton;
	}

	public javax.swing.JButton getDeleteButton() {
		return deleteButton;
	}

	public void setDeleteButton(javax.swing.JButton deleteButton) {
		this.deleteButton = deleteButton;
	}

	public javax.swing.JLabel getjLabel1() {
		return jLabel1;
	}

	public void setjLabel1(javax.swing.JLabel jLabel1) {
		this.jLabel1 = jLabel1;
	}

	public javax.swing.JScrollPane getjScrollPane1() {
		return jScrollPane1;
	}

	public void setjScrollPane1(javax.swing.JScrollPane jScrollPane1) {
		this.jScrollPane1 = jScrollPane1;
	}

	public javax.swing.JButton getModifyButton() {
		return modifyButton;
	}

	public void setModifyButton(javax.swing.JButton modifyButton) {
		this.modifyButton = modifyButton;
	}

	public javax.swing.JButton getViewButton() {
		return viewButton;
	}

	public void setViewButton(javax.swing.JButton viewButton) {
		this.viewButton = viewButton;
	}
    
}
