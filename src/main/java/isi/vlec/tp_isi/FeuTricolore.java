/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package isi.vlec.tp_isi;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author vaal
 */
public class FeuTricolore extends javax.swing.JFrame {
    
    private enum STATE{
        ON(true, false, false, false, false, false, false, false),
        RED(false, true, true, true, false, false, false, false),
        GREEN(false, true, true, false, true, false, false, false),
        ORANGE(false, true, true, false, false, true, false, false),
        FAILED_ON(true, true, false, false, false, false, true, false),
        FAILED_OFF(true, true, false, false, false, false, false, true);
    
        private boolean cbMarche, cbArret, cbPanne, timerRedToGreen, timerGreenToOrange, timerOrangeToRed, timerFailedOrangeOn, timerFailedOrangeOff;

        private STATE(boolean cbMarche, boolean cbArret, boolean cbPanne, boolean timerRedToGreen, boolean timerGreenToOrange, boolean timerOrangeToRed, boolean timerFailedOrangeOn, boolean timerFailedOrangeOff) {
            this.cbMarche = cbMarche;
            this.cbArret = cbArret;
            this.cbPanne = cbPanne;
            this.timerRedToGreen = timerRedToGreen;
            this.timerGreenToOrange = timerGreenToOrange;
            this.timerOrangeToRed = timerOrangeToRed;
            this.timerFailedOrangeOn = timerFailedOrangeOn;
            this.timerFailedOrangeOff = timerFailedOrangeOff;
        }

        public boolean isCbMarche() {
            return cbMarche;
        }
        public boolean isCbArret() {
            return cbArret;
        }
        public boolean isCbPanne() {
            return cbPanne;
        }
        public boolean isTimerRedToGreen() {
            return timerRedToGreen;
        }
        public boolean isTimerGreentoOrange() {
            return timerGreenToOrange;
        }
        public boolean isTimeOrangeToRed() {
            return timerOrangeToRed;
        }
        public boolean isTimerFailedOrangeOn() {
            return timerFailedOrangeOn;
        }
        public boolean isTimerFailedOrangeOff() {
            return timerFailedOrangeOff;
        }
    }

    private STATE state;
    private Timer timerRedToGreen, timerGreenToOrange, timerOrangeToRed, timerFailedOrangeOn, timerFailedOrangeOff;
    
    /**
     * Creates new form FeuTricolore
     */
    public FeuTricolore() {
        initComponents();
        initLights();
        initTimer();
        initStateMachine();
    }

    private void initLights() {
        this.redLight.setColor(Color.RED);
        this.orangeLight.setColor(Color.ORANGE);
        this.greenLight.setColor(Color.GREEN);
    }
    
    private void initStateMachine() {
        state = STATE.ON;
        activateState(state);
    }
    
    public void activateState(FeuTricolore.STATE toActivate){
        cdMarche.setEnabled(toActivate.isCbMarche());
        cdArret.setEnabled(toActivate.isCbArret());
        cdPanne.setEnabled(toActivate.isCbPanne());
        
        if (toActivate.timerRedToGreen){
            timerRedToGreen.start();
        } else {
            timerRedToGreen.stop();
        }
        
        if (toActivate.timerGreenToOrange){
            timerGreenToOrange.start();
        } else {
            timerGreenToOrange.stop();
        }
        
        if (toActivate.timerOrangeToRed){
            timerOrangeToRed.start();
        } else {
            timerOrangeToRed.stop();
        }
        
        if (toActivate.timerFailedOrangeOn){
            timerFailedOrangeOn.start();
        } else {
            timerFailedOrangeOn.stop();
        }
        
        if (toActivate.timerFailedOrangeOff){
            timerFailedOrangeOff.start();
        } else {
            timerFailedOrangeOff.stop();
        }
    }
    
    private void initTimer() {
        timerRedToGreen = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timerRedToGreenActionPerformed(e);
            }
        });
        timerGreenToOrange = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timerGreenToOrangeActionPerformed(e);
            }
        });
        timerOrangeToRed = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timerOrangeToRedActionPerformed(e);
            }
        });
        timerFailedOrangeOn = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timerFailedOrangeOnActionPerformed(e);
            }
        });
        timerFailedOrangeOff = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timerFailedOrangeOffActionPerformed(e);
            }
        });
    }
    
    private void timerRedToGreenActionPerformed(ActionEvent e) {
        System.out.println("timerRedToGreen");
        switch (state) {
            case ON:
                throw new IllegalStateException("timerRedToGreenActionPerformed cannot be pressed in state " + state);
            case RED:
                state = STATE.GREEN;
                activateState(state);
                greenLightOn();
                break;
            case GREEN:
            case ORANGE:
            case FAILED_ON:
            case FAILED_OFF:
                throw new IllegalStateException("timerRedToGreenActionPerformed cannot be pressed in state " + state);
        }
    }
    private void timerGreenToOrangeActionPerformed(ActionEvent e) {
        System.out.println("timerGreenToOrange");
        switch (state) {
            case ON:
                // impossible
                break;
            case RED:
                // impossible
                break;
            case GREEN:
                state = STATE.ORANGE;
                activateState(state);
                orangeLightOn();
                break;
            case ORANGE: 
                // impossible
                break;
            case FAILED_ON:
                // impossible
                break;
            case FAILED_OFF:
                // impossible
                break;
        }
    }
    private void timerOrangeToRedActionPerformed(ActionEvent e) {
        System.out.println("timerOrangeToRed");
        switch (state) {
            case ON:
                // impossible
                break;
            case RED:
                // impossible
                break;
            case GREEN:
                // impossible
                break;
            case ORANGE:
                state = STATE.RED;
                activateState(state);
                redLightOn();
                break;
            case FAILED_ON:
                // impossible
                break;
            case FAILED_OFF:
                // impossible
                break;
        }
    }
    private void timerFailedOrangeOnActionPerformed(ActionEvent e) {
        System.out.println("timerFailedOrangeOn");
        switch (state) {
            case ON:
                // impossible
                break;
            case RED:
                // impossible
                break;
            case GREEN:
                // impossible
                break;
            case ORANGE:
                // impossible
                break;
            case FAILED_ON:
                state = STATE.FAILED_OFF;
                activateState(state);
                allLightOff();
                break;
            case FAILED_OFF:
                // impossible
                break;
        }
    }
    private void timerFailedOrangeOffActionPerformed(ActionEvent e) {
        System.out.println("timerFailedOrangeOff");
        switch (state) {
            case ON:
                // impossible
                break;
            case RED:
                // impossible
                break;
            case GREEN:
                // impossible
                break;
            case ORANGE:
                // impossible
                break;
            case FAILED_ON:
                // impossible
                break;
            case FAILED_OFF:
                state = STATE.FAILED_ON;
                activateState(state);
                orangeLightOn();
                break;
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cdMarche = new javax.swing.JButton();
        cdArret = new javax.swing.JButton();
        cdPanne = new javax.swing.JButton();
        redLight = new isi.vlec.tp_isi.Ampoule();
        orangeLight = new isi.vlec.tp_isi.Ampoule();
        greenLight = new isi.vlec.tp_isi.Ampoule();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Feu tricolore");

        cdMarche.setText("Marche");
        cdMarche.setMaximumSize(new java.awt.Dimension(80, 23));
        cdMarche.setMinimumSize(new java.awt.Dimension(80, 23));
        cdMarche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cdMarcheActionPerformed(evt);
            }
        });

        cdArret.setText("Arrêt");
        cdArret.setMaximumSize(new java.awt.Dimension(80, 23));
        cdArret.setMinimumSize(new java.awt.Dimension(80, 23));
        cdArret.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cdArretActionPerformed(evt);
            }
        });

        cdPanne.setText("Panne");
        cdPanne.setMaximumSize(new java.awt.Dimension(80, 23));
        cdPanne.setMinimumSize(new java.awt.Dimension(80, 23));
        cdPanne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cdPanneActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout redLightLayout = new javax.swing.GroupLayout(redLight);
        redLight.setLayout(redLightLayout);
        redLightLayout.setHorizontalGroup(
            redLightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        redLightLayout.setVerticalGroup(
            redLightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout orangeLightLayout = new javax.swing.GroupLayout(orangeLight);
        orangeLight.setLayout(orangeLightLayout);
        orangeLightLayout.setHorizontalGroup(
            orangeLightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        orangeLightLayout.setVerticalGroup(
            orangeLightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout greenLightLayout = new javax.swing.GroupLayout(greenLight);
        greenLight.setLayout(greenLightLayout);
        greenLightLayout.setHorizontalGroup(
            greenLightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        greenLightLayout.setVerticalGroup(
            greenLightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(redLight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(orangeLight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(greenLight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cdMarche, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(cdArret, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cdPanne, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cdMarche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cdArret, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cdPanne, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(redLight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(orangeLight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(greenLight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cdPanneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cdPanneActionPerformed
        switch (state) {
            case ON:
                // impossible
                break;
            case RED:
                state = STATE.FAILED_ON;
                activateState(state);
                break;
            case GREEN:
                state = STATE.FAILED_ON;
                activateState(state);
                break;
            case ORANGE:
                state = STATE.FAILED_ON;
                activateState(state);
                break;
            case FAILED_ON:
                // impossible
                break;
            case FAILED_OFF:
                // impossible
                break;
        }
    }//GEN-LAST:event_cdPanneActionPerformed

    private void cdMarcheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cdMarcheActionPerformed
        switch (state) {
            case ON:
                state = STATE.RED;
                activateState(state);
                redLightOn();
                break;
            case RED:
                // impossible
                break;
            case GREEN:
                // impossible
                break;
            case ORANGE:
                // impossible
                break;
            case FAILED_ON:
                state = STATE.RED;
                activateState(state);
                redLightOn();
                break;
            case FAILED_OFF:
                state = STATE.RED;
                activateState(state);
                redLightOn();
                break;
        }
    }//GEN-LAST:event_cdMarcheActionPerformed

    private void cdArretActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cdArretActionPerformed
        switch (state) {
            case ON:
                // impossible
                break;
            case RED:
                state = STATE.ON;
                activateState(state);
                allLightOff();
                break;
            case GREEN:
                state = STATE.ON;
                activateState(state);
                allLightOff();
                break;
            case ORANGE:
                state = STATE.ON;
                activateState(state);
                allLightOff();
                break;
            case FAILED_ON:
                state = STATE.ON;
                activateState(state);
                allLightOff();
                break;
            case FAILED_OFF:
                state = STATE.ON;
                activateState(state);
                allLightOff();
                break;
        }
    }//GEN-LAST:event_cdArretActionPerformed

    private void allLightOff() {
        this.redLight.turnOFF();
        this.orangeLight.turnOFF();
        this.greenLight.turnOFF();
    }
    
    private void redLightOn() {
        this.redLight.turnON();
        this.orangeLight.turnOFF();
        this.greenLight.turnOFF();
    }
    
    private void orangeLightOn() {
        this.redLight.turnOFF();
        this.orangeLight.turnON();
        this.greenLight.turnOFF();
    }
    
    private void greenLightOn() {
        this.redLight.turnOFF();
        this.orangeLight.turnOFF();
        this.greenLight.turnON();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FeuTricolore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FeuTricolore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FeuTricolore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FeuTricolore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FeuTricolore().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cdArret;
    private javax.swing.JButton cdMarche;
    private javax.swing.JButton cdPanne;
    private isi.vlec.tp_isi.Ampoule greenLight;
    private isi.vlec.tp_isi.Ampoule orangeLight;
    private isi.vlec.tp_isi.Ampoule redLight;
    // End of variables declaration//GEN-END:variables
}
