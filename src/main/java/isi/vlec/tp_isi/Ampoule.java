/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package isi.vlec.tp_isi;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author vaal
 */
public class Ampoule extends javax.swing.JPanel {

    private Color color;
    private boolean switchedON;

    /**
     * Creates new form Ampoule
     */
    public Ampoule() {
        initComponents();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        if (switchedON) {
            g.setColor(color);
            g.fillOval(0, 0, getWidth(), getHeight());
        } else {
            g.setColor(Color.DARK_GRAY);
            g.fillOval(0, 0, getWidth(), getHeight());
        }
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void turnON() {
        switchedON = true;
        repaint();
    }

    public void turnOFF() {
        switchedON = false;
        repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
