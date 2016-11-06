/*
 * Copyright 2016 Patrik Karlsson.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.nbgames.gunu;

import java.util.Random;
import java.util.prefs.PreferenceChangeEvent;
import java.util.prefs.PreferenceChangeListener;
import javax.swing.border.BevelBorder;
import org.nbgames.core.NbGames;
import org.nbgames.core.base.GamePanel;
import org.openide.util.NbBundle;

/**
 *
 * @author Patrik Karlsson <patrik@trixon.se>
 */
@NbBundle.Messages({
    "CTL_StatusEquals=Congratulations!",
    "CTL_StatusHigh=To high...",
    "CTL_StatusLow=To low..."
})

public class GunuPanel extends GamePanel {

//    Gunu mGunuController;
    private long mValue;
    private int mCounter;
    private final Random mRandom = new Random();

    /**
     * Creates new form GunuPanel
     */
    public GunuPanel() {
        initComponents();
        setVisible(false);
        setBorder(new BevelBorder(BevelBorder.RAISED));
        setBackground(Options.INSTANCE.getColorBackground());
        Options.INSTANCE.getPreferences().addPreferenceChangeListener(new PreferenceChangeListener() {

            @Override
            public void preferenceChange(PreferenceChangeEvent evt) {
                if (evt.getKey().equals(Options.KEY_COLOR_BACKGROUND)) {
                    setBackground(Options.INSTANCE.getColorBackground());
                }
            }
        });

    }

//    public GunuPanel(Gunu gunuController) {
//        this();
//
//        mGunuController = gunuController;
//    }
    String getGameTitle() {
        return "Gunu";
    }

    void newGame() {
        NbGames.outln(Gunu.TAG, "newGame");
        setVisible(true);

        long min = Options.INSTANCE.getMin();
        long max = Options.INSTANCE.getMax();

        String info = NbBundle.getMessage(GunuPanel.class, "GunuPanel.infoLabel.text", min, max);
        infoLabel.setText(info);
        valueTextField.setText(Long.toString(min));
        valueTextField.setValue(min);
        valueTextField.setEnabled(true);
        valueTextField.selectAll();

        guessButton.setEnabled(true);
        statusLabel.setText(NbBundle.getMessage(this.getClass(), "GunuPanel.statusLabel.text", Options.INSTANCE.getPlayer()));

        mValue = min + mRandom.nextInt((int) (max - min + 1));
        mCounter = 0;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        centerPanel = new javax.swing.JPanel();
        guessButton = new javax.swing.JButton();
        statusLabel = new javax.swing.JLabel();
        infoLabel = new javax.swing.JLabel();
        valueTextField = new javax.swing.JFormattedTextField();

        setBackground(new java.awt.Color(204, 204, 204));
        setLayout(new java.awt.GridBagLayout());

        centerPanel.setPreferredSize(new java.awt.Dimension(390, 280));

        guessButton.setFont(new java.awt.Font("DejaVu Sans", 0, 48)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(guessButton, org.openide.util.NbBundle.getMessage(GunuPanel.class, "GunuPanel.guessButton.text")); // NOI18N
        guessButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guessButtonActionPerformed(evt);
            }
        });

        statusLabel.setFont(new java.awt.Font("DejaVu Sans", 0, 48)); // NOI18N
        statusLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        org.openide.awt.Mnemonics.setLocalizedText(statusLabel, org.openide.util.NbBundle.getMessage(GunuPanel.class, "GunuPanel.statusLabel.text")); // NOI18N

        infoLabel.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        infoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        org.openide.awt.Mnemonics.setLocalizedText(infoLabel, org.openide.util.NbBundle.getMessage(GunuPanel.class, "GunuPanel.infoLabel.text")); // NOI18N

        valueTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        valueTextField.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        valueTextField.setText("0"); // NOI18N
        valueTextField.setFont(new java.awt.Font("DejaVu Sans", 0, 48)); // NOI18N
        valueTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valueTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout centerPanelLayout = new javax.swing.GroupLayout(centerPanel);
        centerPanel.setLayout(centerPanelLayout);
        centerPanelLayout.setHorizontalGroup(
            centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(centerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(valueTextField)
                    .addComponent(guessButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(infoLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(statusLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        centerPanelLayout.setVerticalGroup(
            centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(centerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(infoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(valueTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(guessButton)
                .addGap(18, 18, 18)
                .addComponent(statusLabel)
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 125;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(centerPanel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void guessButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guessButtonActionPerformed
        mCounter++;
        long value = (Long) valueTextField.getValue();
        String status = null;
        if (value == mValue) {
            status = Bundle.CTL_StatusEquals();
            valueTextField.setEnabled(false);
            guessButton.setEnabled(false);
        } else if (value > mValue) {
            status = Bundle.CTL_StatusHigh();
        } else if (value < mValue) {
            status = Bundle.CTL_StatusLow();
        }
        statusLabel.setText(String.format("(%d) %s", mCounter, status));
    }//GEN-LAST:event_guessButtonActionPerformed

    private void valueTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valueTextFieldActionPerformed
        guessButton.doClick();
        valueTextField.selectAll();
    }//GEN-LAST:event_valueTextFieldActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel centerPanel;
    private javax.swing.JButton guessButton;
    private javax.swing.JLabel infoLabel;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JFormattedTextField valueTextField;
    // End of variables declaration//GEN-END:variables
}
