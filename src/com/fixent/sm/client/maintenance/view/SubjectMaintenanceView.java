/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fixent.sm.client.maintenance.view;

/**
 *
 * @author Mathan
 */
public class SubjectMaintenanceView extends javax.swing.JPanel {

    /**
     * Creates new form Maintenance
     */
    public SubjectMaintenanceView() {
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
        jScrollPane1 = new javax.swing.JScrollPane();
        subjectCategoryTable = new javax.swing.JTable();
        subjectCategoryAddButton = new javax.swing.JButton();
        subjectCategoryDeleteButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        subjectTable = new javax.swing.JTable();
        subjectAddButton = new javax.swing.JButton();
        subjectDeleteButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setAutoscrolls(true);

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel1.setText("Subject");

        subjectCategoryTable.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        subjectCategoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Subject Category Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        subjectCategoryTable.setGridColor(new java.awt.Color(204, 204, 204));
        jScrollPane1.setViewportView(subjectCategoryTable);

        subjectCategoryAddButton.setBackground(new java.awt.Color(61, 86, 109));
        subjectCategoryAddButton.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        subjectCategoryAddButton.setForeground(new java.awt.Color(255, 255, 255));
        subjectCategoryAddButton.setText("Add");

        subjectCategoryDeleteButton.setBackground(new java.awt.Color(61, 86, 109));
        subjectCategoryDeleteButton.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        subjectCategoryDeleteButton.setForeground(new java.awt.Color(255, 255, 255));
        subjectCategoryDeleteButton.setText("Delete");

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel2.setText("Subject Category");

        subjectTable.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        subjectTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Category Name", "Subject Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        subjectTable.setGridColor(new java.awt.Color(204, 204, 204));
        jScrollPane2.setViewportView(subjectTable);

        subjectAddButton.setBackground(new java.awt.Color(61, 86, 109));
        subjectAddButton.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        subjectAddButton.setForeground(new java.awt.Color(255, 255, 255));
        subjectAddButton.setText("Add");

        subjectDeleteButton.setBackground(new java.awt.Color(61, 86, 109));
        subjectDeleteButton.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        subjectDeleteButton.setForeground(new java.awt.Color(255, 255, 255));
        subjectDeleteButton.setText("Delete");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(subjectCategoryAddButton)
                        .addGap(10, 10, 10)
                        .addComponent(subjectCategoryDeleteButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(subjectAddButton)
                                .addGap(10, 10, 10)
                                .addComponent(subjectDeleteButton))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addGap(2, 2, 2)))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subjectCategoryAddButton)
                    .addComponent(subjectCategoryDeleteButton))
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subjectAddButton)
                    .addComponent(subjectDeleteButton))
                .addContainerGap(30, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton subjectAddButton;
    private javax.swing.JButton subjectCategoryAddButton;
    private javax.swing.JButton subjectCategoryDeleteButton;
    private javax.swing.JTable subjectCategoryTable;
    private javax.swing.JButton subjectDeleteButton;
    private javax.swing.JTable subjectTable;
    // End of variables declaration//GEN-END:variables
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

	public javax.swing.JScrollPane getjScrollPane1() {
		return jScrollPane1;
	}

	public void setjScrollPane1(javax.swing.JScrollPane jScrollPane1) {
		this.jScrollPane1 = jScrollPane1;
	}

	public javax.swing.JScrollPane getjScrollPane2() {
		return jScrollPane2;
	}

	public void setjScrollPane2(javax.swing.JScrollPane jScrollPane2) {
		this.jScrollPane2 = jScrollPane2;
	}

	public javax.swing.JButton getSubjectAddButton() {
		return subjectAddButton;
	}

	public void setSubjectAddButton(javax.swing.JButton subjectAddButton) {
		this.subjectAddButton = subjectAddButton;
	}

	public javax.swing.JButton getSubjectCategoryAddButton() {
		return subjectCategoryAddButton;
	}

	public void setSubjectCategoryAddButton(
			javax.swing.JButton subjectCategoryAddButton) {
		this.subjectCategoryAddButton = subjectCategoryAddButton;
	}

	public javax.swing.JButton getSubjectCategoryDeleteButton() {
		return subjectCategoryDeleteButton;
	}

	public void setSubjectCategoryDeleteButton(
			javax.swing.JButton subjectCategoryDeleteButton) {
		this.subjectCategoryDeleteButton = subjectCategoryDeleteButton;
	}

	public javax.swing.JTable getSubjectCategoryTable() {
		return subjectCategoryTable;
	}

	public void setSubjectCategoryTable(javax.swing.JTable subjectCategoryTable) {
		this.subjectCategoryTable = subjectCategoryTable;
	}

	public javax.swing.JButton getSubjectDeleteButton() {
		return subjectDeleteButton;
	}

	public void setSubjectDeleteButton(javax.swing.JButton subjectDeleteButton) {
		this.subjectDeleteButton = subjectDeleteButton;
	}

	public javax.swing.JTable getSubjectTable() {
		return subjectTable;
	}

	public void setSubjectTable(javax.swing.JTable subjectTable) {
		this.subjectTable = subjectTable;
	}
    
}
