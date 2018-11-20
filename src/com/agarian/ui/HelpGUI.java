/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agarian.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.Timer;

/**
 *
 * @author crysi
 */
public class HelpGUI extends javax.swing.JFrame implements MouseListener, ActionListener {

    /**
     * Creates new form HelpGUI
     */
    public HelpGUI() {
        initComponents();
        timer.start();
    }
    private final Timer timer = new Timer(5, this);

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelHeader = new javax.swing.JPanel();
        jPanelExit = new javax.swing.JPanel();
        jLabelXIcon = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabelLong = new javax.swing.JLabel();
        jLabelShort = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        jPanelHeader.setBackground(new java.awt.Color(51, 51, 51));

        jPanelExit.setBackground(new java.awt.Color(255, 255, 255));
        jPanelExit.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jPanelExit.addMouseListener(this);

        jLabelXIcon.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelXIcon.setText("X");

        javax.swing.GroupLayout jPanelExitLayout = new javax.swing.GroupLayout(jPanelExit);
        jPanelExit.setLayout(jPanelExitLayout);
        jPanelExitLayout.setHorizontalGroup(
            jPanelExitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelExitLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelXIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelExitLayout.setVerticalGroup(
            jPanelExitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelXIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("HELP and INFO");

        javax.swing.GroupLayout jPanelHeaderLayout = new javax.swing.GroupLayout(jPanelHeader);
        jPanelHeader.setLayout(jPanelHeaderLayout);
        jPanelHeaderLayout.setHorizontalGroup(
            jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 395, Short.MAX_VALUE)
                .addComponent(jPanelExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelHeaderLayout.setVerticalGroup(
            jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("1. To place turrets you click on a highlighted block.\n2. Enemies will have different resistances and health based on level.\n3. Each turret has a different color(Green for long and orange for short)\n4. The game will save ALL info for your profile.\n5. Usernames are not case-sensitive.\n");
        jScrollPane1.setViewportView(jTextArea1);

        jLabelLong.setText("Long Range");

        jLabelShort.setText("Short Range");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabelLong)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelShort)
                .addGap(52, 52, 52))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelLong)
                    .addComponent(jLabelShort))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 147, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        pack();
    }

    // Code for dispatching events from components to event handlers.

    public void mouseClicked(java.awt.event.MouseEvent evt) {
        if (evt.getSource() == jPanelExit) {
            HelpGUI.this.jPanelExitMouseClicked(evt);
        }
    }

    public void mouseEntered(java.awt.event.MouseEvent evt) {
        if (evt.getSource() == jPanelExit) {
            HelpGUI.this.jPanelExitMouseEntered(evt);
        }
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        if (evt.getSource() == jPanelExit) {
            HelpGUI.this.jPanelExitMouseExited(evt);
        }
    }

    public void mousePressed(java.awt.event.MouseEvent evt) {
    }

    public void mouseReleased(java.awt.event.MouseEvent evt) {
    }// </editor-fold>//GEN-END:initComponents

    private void jPanelExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelExitMouseClicked
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jPanelExitMouseClicked

    private void jPanelExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelExitMouseEntered
        // TODO add your handling code here:
        jPanelExit.setBackground(Color.red);
        jLabelXIcon.setForeground(Color.WHITE);
    }//GEN-LAST:event_jPanelExitMouseEntered

    private void jPanelExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelExitMouseExited
        // TODO add your handling code here:
        jPanelExit.setBackground(Color.WHITE);
        jLabelXIcon.setForeground(Color.BLACK);
    }//GEN-LAST:event_jPanelExitMouseExited

    @Override
    public void paint(Graphics grphcs) {
        super.paint(grphcs);

        Graphics2D graphic = (Graphics2D) grphcs;
        graphic.setColor(Color.ORANGE);
        graphic.fillOval(jLabelLong.getX() + 15 + 30, jLabelLong.getY() + 15 + 30, 20, 20);

        graphic.setColor(Color.GREEN);
        graphic.fillOval(jLabelShort.getX() + 15 + 30, jLabelShort.getY() + 15 + 30, 20, 20);

        graphic.setColor(Color.BLACK);
        graphic.fillOval(jLabelLong.getX() + 20 + 30, jLabelLong.getY() + 20 + 30, 10, 10);
        graphic.fillOval(jLabelShort.getX() + 20 + 30, jLabelShort.getY() + 20 + 30, 10, 10);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelLong;
    private javax.swing.JLabel jLabelShort;
    private javax.swing.JLabel jLabelXIcon;
    private javax.swing.JPanel jPanelExit;
    private javax.swing.JPanel jPanelHeader;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent ae) {
        repaint();
    }
}