/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fixent.sm.client.mark.view;

/**
 *
 * @author Mathan
 */
public class MarkDashboardView extends javax.swing.JPanel {

    /**
     * Creates new form MarkDashboardView
     */
    public MarkDashboardView() {
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
        addButton = new javax.swing.JButton();
        modifyButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel1.setText("Mark Dashboard");

        addButton.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        addButton.setText("Add");

        modifyButton.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        modifyButton.setText("Modify");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(addButton)
                        .addGap(32, 32, 32)
                        .addComponent(modifyButton)))
                .addContainerGap(424, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 360, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(modifyButton))
                .addGap(84, 84, 84))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton modifyButton;
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

	public javax.swing.JButton getModifyButton() {
		return modifyButton;
	}

	public void setModifyButton(javax.swing.JButton modifyButton) {
		this.modifyButton = modifyButton;
	}
    
    
}