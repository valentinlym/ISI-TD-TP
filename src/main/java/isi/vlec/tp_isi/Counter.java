/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package isi.vlec.tp_isi;

/**
 *
 * @author vaal
 */
public class Counter extends javax.swing.JFrame {
    
    private enum STATE{
        START_AVAIL(true, false, false),
        STOP_ADD_AVAIL(false, true, true);
    
        private boolean cbStart, cbStop, cbAdd;

        private STATE(boolean cbStart, boolean cbStop, boolean cbAdd) {
            this.cbStart = cbStart;
            this.cbStop = cbStop;
            this.cbAdd = cbAdd;
        }

        public boolean isCbStart() {
            return cbStart;
        }
        public boolean isCbStop() {
            return cbStop;
        }
        public boolean isCbAdd() {
            return cbStop;
        }
    }
    
    private STATE state;
    public int count;
    
    /**
     * Creates new form FourButton
     */
    public Counter() {
        initComponents();
        initStateMachine();
    }
    
    public void initStateMachine(){
        state = STATE.START_AVAIL;
        count = 0;
        activateState(state);
    }
    
    public void activateState(STATE currentState){
        cbStart.setEnabled(currentState.isCbStart());
        cbStop.setEnabled(currentState.isCbStop());
        cbAdd.setEnabled(currentState.isCbAdd());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbStart = new javax.swing.JButton();
        cbStop = new javax.swing.JButton();
        cbAdd = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Counter");

        cbStart.setText("Start");
        cbStart.setToolTipText("");
        cbStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbStartActionPerformed(evt);
            }
        });

        cbStop.setText("Stop");
        cbStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbStopActionPerformed(evt);
            }
        });

        cbAdd.setText("+1");
        cbAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAddActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("0");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(cbStart, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbStop, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(cbStart)
                    .addComponent(cbStop)
                    .addComponent(cbAdd))
                .addGap(144, 144, 144))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbStartActionPerformed
        switch (state) {
            case START_AVAIL:
                // 1. ETAT
                // 2. ACTIVATION (ETAT)
                // 3. RENDU (ACTION)
                state = STATE.STOP_ADD_AVAIL;
                activateState(state);
                initCounter();
                displayCounter();
                break;
            case STOP_ADD_AVAIL:
                throw new IllegalStateException("Button start cannot be pressed in state " + state);
        }
    }//GEN-LAST:event_cbStartActionPerformed

    private void cbStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbStopActionPerformed
        switch (state) {
            case START_AVAIL:
                throw new IllegalStateException("Button stop cannot be pressed in state " + state);
            case STOP_ADD_AVAIL:
                state = STATE.START_AVAIL;
                activateState(state);
                displayPouf();
                break;
        }
    }//GEN-LAST:event_cbStopActionPerformed

    private void cbAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAddActionPerformed
        switch (state) {
            case START_AVAIL:
                throw new IllegalStateException("Button add cannot be pressed in state " + state);
            case STOP_ADD_AVAIL:
                if (this.count < 3) {
                    state = STATE.STOP_ADD_AVAIL;
                    activateState(state);
                    increment();
                    displayCounter();
                } else if (this.count == 3) {
                    state = STATE.START_AVAIL;
                    activateState(state);
                    displayCounter();
                }
                break;
        }
    }//GEN-LAST:event_cbAddActionPerformed

    private void initCounter() {
        this.count = 0;
    }

    private void increment() {
        this.count ++;
    }
    
    private void displayPouf() {
       jLabel1.setText("Pouf !");
    }
    
    private void displayCounter() {
        jLabel1.setText(Integer.toString(this.count));
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
            java.util.logging.Logger.getLogger(Counter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Counter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Counter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Counter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Counter().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cbAdd;
    private javax.swing.JButton cbStart;
    private javax.swing.JButton cbStop;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
