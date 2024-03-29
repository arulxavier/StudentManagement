/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fixent.sm.client.syllabus.view;


/**
 *
 * @author Mathan
 */
public class SyllabusView extends javax.swing.JPanel {

    /**
     * Creates new form SyllabusView
     */
    public SyllabusView() {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        yearComboBox = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        yearTypeComboBox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        semasterComboBox = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        subjectTable = new javax.swing.JTable();
        addButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        mainDeleteButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel1.setText("Syllabus View");

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel2.setText("Year");

        yearComboBox.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel3.setText("Year Type");

        yearTypeComboBox.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        yearTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select One", "First Year", "Second Year", "Third Year", "Fourth Year" }));

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel4.setText("Semester");

        semasterComboBox.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        semasterComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select One", "1", "2", "3" }));

        subjectTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Subject ID", "Subject Name", "Subject Category"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        subjectTable.setFillsViewportHeight(true);
        jScrollPane1.setViewportView(subjectTable);

        addButton.setBackground(new java.awt.Color(61, 86, 109));
        addButton.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        addButton.setForeground(new java.awt.Color(255, 255, 255));
        addButton.setText("Add");

        deleteButton.setBackground(new java.awt.Color(61, 86, 109));
        deleteButton.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        deleteButton.setForeground(new java.awt.Color(255, 255, 255));
        deleteButton.setText("Delete");

        saveButton.setBackground(new java.awt.Color(61, 86, 109));
        saveButton.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        saveButton.setForeground(new java.awt.Color(255, 255, 255));
        saveButton.setText("Save");

        cancelButton.setBackground(new java.awt.Color(61, 86, 109));
        cancelButton.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cancelButton.setForeground(new java.awt.Color(255, 255, 255));
        cancelButton.setText("Cancel");

        mainDeleteButton.setBackground(new java.awt.Color(61, 86, 109));
        mainDeleteButton.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        mainDeleteButton.setForeground(new java.awt.Color(255, 255, 255));
        mainDeleteButton.setText("Delete");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(mainDeleteButton)
                        .addGap(18, 18, 18)
                        .addComponent(cancelButton)
                        .addGap(18, 18, 18)
                        .addComponent(saveButton))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(14, 14, 14)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(addButton)
                                    .addGap(10, 10, 10)
                                    .addComponent(deleteButton))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel2))
                                        .addGap(51, 51, 51)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(yearComboBox, 0, 106, Short.MAX_VALUE)
                                            .addComponent(semasterComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(63, 63, 63)
                                        .addComponent(jLabel3)
                                        .addGap(28, 28, 28)
                                        .addComponent(yearTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(yearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(yearTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(semasterComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(deleteButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(cancelButton)
                    .addComponent(mainDeleteButton))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton mainDeleteButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JComboBox semasterComboBox;
    private javax.swing.JTable subjectTable;
    private javax.swing.JComboBox yearComboBox;
    private javax.swing.JComboBox yearTypeComboBox;
    // End of variables declaration//GEN-END:variables
	public javax.swing.JButton getAddButton() {
		return addButton;
	}

	public void setAddButton(javax.swing.JButton addButton) {
		this.addButton = addButton;
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

	public javax.swing.JLabel getjLabel2() {
		return jLabel2;
	}

	public void setjLabel2(javax.swing.JLabel jLabel2) {
		this.jLabel2 = jLabel2;
	}

	public javax.swing.JLabel getjLabel3() {
		return jLabel3;
	}

	public void setjLabel3(javax.swing.JLabel jLabel3) {
		this.jLabel3 = jLabel3;
	}

	public javax.swing.JLabel getjLabel4() {
		return jLabel4;
	}

	public void setjLabel4(javax.swing.JLabel jLabel4) {
		this.jLabel4 = jLabel4;
	}

	public javax.swing.JScrollPane getjScrollPane1() {
		return jScrollPane1;
	}

	public void setjScrollPane1(javax.swing.JScrollPane jScrollPane1) {
		this.jScrollPane1 = jScrollPane1;
	}


	public javax.swing.JButton getSaveButton() {
		return saveButton;
	}

	public void setSaveButton(javax.swing.JButton saveButton) {
		this.saveButton = saveButton;
	}

	public javax.swing.JComboBox getSemasterComboBox() {
		return semasterComboBox;
	}

	public void setSemasterComboBox(javax.swing.JComboBox semasterComboBox) {
		this.semasterComboBox = semasterComboBox;
	}

	public javax.swing.JTable getSubjectTable() {
		return subjectTable;
	}

	public void setSubjectTable(javax.swing.JTable subjectTable) {
		this.subjectTable = subjectTable;
	}

	public javax.swing.JComboBox getYearComboBox() {
		return yearComboBox;
	}

	public void setYearComboBox(javax.swing.JComboBox yearComboBox) {
		this.yearComboBox = yearComboBox;
	}

	public javax.swing.JComboBox getYearTypeComboBox() {
		return yearTypeComboBox;
	}

	public void setYearTypeComboBox(javax.swing.JComboBox yearTypeComboBox) {
		this.yearTypeComboBox = yearTypeComboBox;
	}

	public javax.swing.JButton getCancelButton() {
		return cancelButton;
	}

	public void setCancelButton(javax.swing.JButton cancelButton) {
		this.cancelButton = cancelButton;
	}

	public javax.swing.JButton getMainDeleteButton() {
		return mainDeleteButton;
	}

	public void setMainDeleteButton(javax.swing.JButton mainDeleteButton) {
		this.mainDeleteButton = mainDeleteButton;
	}
}
