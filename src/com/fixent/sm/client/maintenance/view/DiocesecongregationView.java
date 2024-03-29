/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fixent.sm.client.maintenance.view;

/**
 *
 * @author Mathan
 */
public class DiocesecongregationView extends javax.swing.JPanel {

    /**
     * Creates new form DiocesecongregationView
     */
    public DiocesecongregationView() {
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
        dioceseTable = new javax.swing.JTable();
        dioceseAddButton = new javax.swing.JButton();
        dioceseDeleteButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        congregationTable = new javax.swing.JTable();
        congregationDeleteButton = new javax.swing.JButton();
        congregationAddButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel1.setText("Diocese");

        dioceseTable.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        dioceseTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Diocese Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        dioceseTable.setFillsViewportHeight(true);
        dioceseTable.setGridColor(new java.awt.Color(204, 204, 204));
        jScrollPane1.setViewportView(dioceseTable);

        dioceseAddButton.setBackground(new java.awt.Color(61, 86, 109));
        dioceseAddButton.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        dioceseAddButton.setForeground(new java.awt.Color(255, 255, 255));
        dioceseAddButton.setText("Add");

        dioceseDeleteButton.setBackground(new java.awt.Color(61, 86, 109));
        dioceseDeleteButton.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        dioceseDeleteButton.setForeground(new java.awt.Color(255, 255, 255));
        dioceseDeleteButton.setText("Delete");

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel2.setText("Congregation");

        congregationTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Congregation Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        congregationTable.setFillsViewportHeight(true);
        congregationTable.setGridColor(new java.awt.Color(204, 204, 204));
        jScrollPane2.setViewportView(congregationTable);

        congregationDeleteButton.setBackground(new java.awt.Color(61, 86, 109));
        congregationDeleteButton.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        congregationDeleteButton.setForeground(new java.awt.Color(255, 255, 255));
        congregationDeleteButton.setText("Delete");

        congregationAddButton.setBackground(new java.awt.Color(61, 86, 109));
        congregationAddButton.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        congregationAddButton.setForeground(new java.awt.Color(255, 255, 255));
        congregationAddButton.setText("Add");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(dioceseAddButton)
                                .addGap(10, 10, 10)
                                .addComponent(dioceseDeleteButton))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(congregationAddButton)
                                .addGap(10, 10, 10)
                                .addComponent(congregationDeleteButton)))))
                .addGap(66, 66, 66))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dioceseAddButton)
                    .addComponent(dioceseDeleteButton))
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(congregationDeleteButton)
                    .addComponent(congregationAddButton))
                .addGap(25, 25, 25))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton congregationAddButton;
    private javax.swing.JButton congregationDeleteButton;
    private javax.swing.JTable congregationTable;
    private javax.swing.JButton dioceseAddButton;
    private javax.swing.JButton dioceseDeleteButton;
    private javax.swing.JTable dioceseTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
	public javax.swing.JButton getCongregationAddButton() {
		return congregationAddButton;
	}

	public void setCongregationAddButton(javax.swing.JButton congregationAddButton) {
		this.congregationAddButton = congregationAddButton;
	}

	public javax.swing.JButton getCongregationDeleteButton() {
		return congregationDeleteButton;
	}

	public void setCongregationDeleteButton(
			javax.swing.JButton congregationDeleteButton) {
		this.congregationDeleteButton = congregationDeleteButton;
	}

	public javax.swing.JTable getCongregationTable() {
		return congregationTable;
	}

	public void setCongregationTable(javax.swing.JTable congregationTable) {
		this.congregationTable = congregationTable;
	}

	public javax.swing.JButton getDioceseAddButton() {
		return dioceseAddButton;
	}

	public void setDioceseAddButton(javax.swing.JButton dioceseAddButton) {
		this.dioceseAddButton = dioceseAddButton;
	}

	public javax.swing.JButton getDioceseDeleteButton() {
		return dioceseDeleteButton;
	}

	public void setDioceseDeleteButton(javax.swing.JButton dioceseDeleteButton) {
		this.dioceseDeleteButton = dioceseDeleteButton;
	}

	public javax.swing.JTable getDioceseTable() {
		return dioceseTable;
	}

	public void setDioceseTable(javax.swing.JTable dioceseTable) {
		this.dioceseTable = dioceseTable;
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
    
}
