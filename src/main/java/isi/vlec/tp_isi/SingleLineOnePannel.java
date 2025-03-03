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
public class SingleLineOnePannel extends javax.swing.JPanel {

    private enum STATE {
        NOT_DRAWING,
        DRAWING
    }

    private STATE state;

    private void initStateMachine() {
        // Pas d'état initial car nous avons des actions impossible
        state = STATE.NOT_DRAWING;
    }

    private int x0 = -1, y0 = -1, x1 = -1, y1 = -1;

    /**
     * Creates new form SingleLineOnePannel
     */
    public SingleLineOnePannel() {
        initComponents();
        initStateMachine();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });

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

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        switch (state) {
            case NOT_DRAWING:
                state = STATE.DRAWING;
                createLine(evt.getX(), evt.getY(), evt.getX(), evt.getY());
                break;
            case DRAWING:
                // impossible
                break;
        }
    }//GEN-LAST:event_formMousePressed

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        switch (state) {
            case NOT_DRAWING:
                // impossible
                break;
            case DRAWING:
                state = STATE.NOT_DRAWING;
                updateLine(evt.getX(), evt.getY());
                break;
        }
    }//GEN-LAST:event_formMouseReleased

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        switch (state) {
            case NOT_DRAWING:
                // impossible
                break;
            case DRAWING:
                state = STATE.DRAWING;
                updateLine(evt.getX(), evt.getY());
                break;
        }
    }//GEN-LAST:event_formMouseDragged

    private void createLine(int x0, int y0, int x1, int y1) {
        this.x0 = x0;
        this.y0 = y0;
        this.x1 = x1;
        this.y1 = y1;
        repaint();
    }

    private void updateLine(int x1, int y1) {
        this.x1 = x1;
        this.y1 = y1;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        switch (state) {
            case NOT_DRAWING:
                g.setColor(Color.BLACK);
                g.drawLine(x0, y0, x1, y1);
                break;
            case DRAWING:
                g.setColor(Color.RED);
                g.drawLine(x0, y0, x1, y1);
                break;
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
