/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fixent.sm.client.syllabus.view;

/**
 *
 * @author Mathan
 */
public class SyllabusDashboardView extends javax.swing.JPanel {

    /**
     * Creates new form SyllabusDashboardView
     */
    public SyllabusDashboardView() {
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
        typeComboBox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        semasterComboBox = new javax.swing.JComboBox();
        searchButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel1.setText("Syllabus Dashboard");

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel2.setText("Year");

        yearComboBox.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        yearComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select One", "2013", "2014", "2015", "2016" }));

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel3.setText("Type");

        typeComboBox.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        typeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select One", "First Year", "Second Year", "Third Year" }));

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel4.setText("Semaster");

        semasterComboBox.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        semasterComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select One", "1", "2", "3" }));

        searchButton.setBackground(new java.awt.Color(61, 86, 109));
        searchButton.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        searchButton.setForeground(new java.awt.Color(255, 255, 255));
        searchButton.setText("Search");

        addButton.setBackground(new java.awt.Color(61, 86, 109));
        addButton.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        addButton.setForeground(new java.awt.Color(255, 255, 255));
        addButton.setText("Add");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(yearComboBox, 0, 113, Short.MAX_VALUE)
                            .addComponent(typeComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(semasterComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(addButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(searchButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(295, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel1)
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(yearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(typeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(semasterComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(searchButton)
                .addGap(10, 10, 10)
                .addComponent(addButton)
                .addContainerGap(189, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton searchButton;
    private javax.swing.JComboBox semasterComboBox;
    private javax.swing.JComboBox typeComboBox;
    private javax.swing.JComboBox yearComboBox;
    // End of variables declaration//GEN-END:variables
	public javax.swing.JButton getAddButton() {
		return addButton;
	}

	public void setAddButton(javax.swing.JButton addButton) {
		this.addButton = addButton;
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

	public javax.swing.JButton getSearchButton() {
		return searchButton;
	}

	public void setSearchButton(javax.swing.JButton searchButton) {
		this.searchButton = searchButton;
	}

	public javax.swing.JComboBox getSemasterComboBox() {
		return semasterComboBox;
	}

	public void setSemasterComboBox(javax.swing.JComboBox semasterComboBox) {
		this.semasterComboBox = semasterComboBox;
	}

	public javax.swing.JComboBox getTypeComboBox() {
		return typeComboBox;
	}

	public void setTypeComboBox(javax.swing.JComboBox typeComboBox) {
		this.typeComboBox = typeComboBox;
	}

	public javax.swing.JComboBox getYearComboBox() {
		return yearComboBox;
	}

	public void setYearComboBox(javax.swing.JComboBox yearComboBox) {
		this.yearComboBox = yearComboBox;
	}
    
    
}
