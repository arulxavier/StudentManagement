/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fixent.sm.client.changeyear.view;

/**
 *
 * @author Mathan
 */
public class ChangeYearView extends javax.swing.JPanel {

    /**
     * Creates new form ChangeYear
     */
    public ChangeYearView() {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        fromYearComboBox = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        fromTypeComboBox = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        toYearComboBox = new javax.swing.JComboBox();
        toTypeComboBox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();
        msgLable = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "From", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel1.setText("Year");

        fromYearComboBox.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        fromYearComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select One", "2013", "2014", "2015" }));

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel2.setText("Type");

        fromTypeComboBox.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        fromTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select One", "1", "2", "3" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(fromYearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(fromTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(fromYearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(fromTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "To", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel3.setText("Year");

        toYearComboBox.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        toYearComboBox.setEnabled(false);

        toTypeComboBox.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        toTypeComboBox.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel4.setText("Type");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(toYearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(toTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(toYearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(toTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        saveButton.setBackground(new java.awt.Color(61, 86, 109));
        saveButton.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        saveButton.setForeground(new java.awt.Color(255, 255, 255));
        saveButton.setText("Save");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(saveButton)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(msgLable, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(msgLable)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(saveButton)
                .addContainerGap(44, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox fromTypeComboBox;
    private javax.swing.JComboBox fromYearComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel msgLable;
    private javax.swing.JButton saveButton;
    private javax.swing.JComboBox toTypeComboBox;
    private javax.swing.JComboBox toYearComboBox;
    // End of variables declaration//GEN-END:variables


	public javax.swing.JComboBox getFromTypeComboBox() {
		return fromTypeComboBox;
	}


	public void setFromTypeComboBox(javax.swing.JComboBox fromTypeComboBox) {
		this.fromTypeComboBox = fromTypeComboBox;
	}


	public javax.swing.JComboBox getFromYearComboBox() {
		return fromYearComboBox;
	}


	public void setFromYearComboBox(javax.swing.JComboBox fromYearComboBox) {
		this.fromYearComboBox = fromYearComboBox;
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


	public javax.swing.JPanel getjPanel1() {
		return jPanel1;
	}


	public void setjPanel1(javax.swing.JPanel jPanel1) {
		this.jPanel1 = jPanel1;
	}


	public javax.swing.JPanel getjPanel2() {
		return jPanel2;
	}


	public void setjPanel2(javax.swing.JPanel jPanel2) {
		this.jPanel2 = jPanel2;
	}


	public javax.swing.JButton getSaveButton() {
		return saveButton;
	}


	public void setSaveButton(javax.swing.JButton saveButton) {
		this.saveButton = saveButton;
	}


	public javax.swing.JComboBox getToTypeComboBox() {
		return toTypeComboBox;
	}


	public void setToTypeComboBox(javax.swing.JComboBox toTypeComboBox) {
		this.toTypeComboBox = toTypeComboBox;
	}


	public javax.swing.JComboBox getToYearComboBox() {
		return toYearComboBox;
	}


	public void setToYearComboBox(javax.swing.JComboBox toYearComboBox) {
		this.toYearComboBox = toYearComboBox;
	}


	public javax.swing.JLabel getMsgLable() {
		return msgLable;
	}


	public void setMsgLable(javax.swing.JLabel msgLable) {
		this.msgLable = msgLable;
	}
    
}
