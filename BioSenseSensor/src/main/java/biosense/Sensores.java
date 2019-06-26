/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biosense;

import biosense.util.DataUtils;
import biosense.util.ObjectListCellRenderer;
import biosense.util.StringUtils;
import biosensews.ws.BioSenseWS;
import biosensews.ws.BioSenseWS_Service;
import biosensews.ws.Leitura;
import biosensews.ws.Planta;
import biosensews.ws.Usuario;
import java.awt.event.ItemEvent;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas Leandro
 */
public class Sensores extends javax.swing.JFrame {

    /**
     * Creates new form Simulador
     */
    private Usuario selectedUsuario;
    private Planta selectedPlanta;
    private boolean simulacao = false;
    private final BioSenseWS port;
    private Timer timer;
    private Leitura ultimaLeitura = null;
    private final Random random;

    public Sensores() {
        initComponents();

        this.random = new Random();
        BioSenseWS_Service service = new BioSenseWS_Service();
        this.port = service.getBioSenseWSPort();

        List<Usuario> usuarios = port.todosUsuario();
        usuarios.forEach(usuario -> cbUsuarios.addItem(usuario));
        cbUsuarios.setRenderer(new ObjectListCellRenderer());
        cbPlantas.setRenderer(new ObjectListCellRenderer());

        rbModoAuto.setSelected(true);
        rbModoAuto.setActionCommand("auto");
        rbModoCresc.setActionCommand("cresc");
        rbModoDec.setActionCommand("dec");
    }

    public class GeraLeituraTask extends TimerTask {

        @Override
        public void run() {
            if (simulacao) {
                Leitura novaLeitura = new Leitura();
                novaLeitura.setData(DataUtils.GetTodayDate());
                novaLeitura.setPlanta(selectedPlanta);
                float taxaSoma;
                int sinal;
                if (ultimaLeitura == null) {
                    novaLeitura.setIrrigacao(Float.parseFloat(txtIrrigacao.getText()));
                    novaLeitura.setTemperatura(Float.parseFloat(txtTemp.getText()));
                    novaLeitura.setUmidade(Float.parseFloat(txtUmidade.getText()));
                    novaLeitura.setPh(Float.parseFloat(txtPh.getText()));
                    novaLeitura.setSolo(Float.parseFloat(txtSolo.getText()));
                } else {
                    sinal = calculaSinal();
                    taxaSoma = Float.parseFloat(txtTaxaIrrigacao.getText()) * sinal;
                    novaLeitura.setIrrigacao(ultimaLeitura.getIrrigacao() + taxaSoma);

                    sinal = calculaSinal();
                    taxaSoma = Float.parseFloat(txtTaxaTemp.getText()) * sinal;
                    novaLeitura.setTemperatura(ultimaLeitura.getTemperatura() + taxaSoma);

                    sinal = calculaSinal();
                    taxaSoma = Float.parseFloat(txtTaxaUmidade.getText()) * sinal;
                    novaLeitura.setUmidade(ultimaLeitura.getUmidade() + taxaSoma);

                    sinal = calculaSinal();
                    taxaSoma = Float.parseFloat(txtTaxaPh.getText()) * sinal;
                    novaLeitura.setPh(ultimaLeitura.getPh() + taxaSoma);

                    sinal = calculaSinal();
                    taxaSoma = Float.parseFloat(txtTaxaSolo.getText()) * sinal;
                    novaLeitura.setSolo(ultimaLeitura.getSolo() + taxaSoma);
                }

                port.cadastrarLeitura(novaLeitura);
                ultimaLeitura = novaLeitura;

            } else {
                timer.cancel();
            }
        }
    }

    private int calculaSinal() {
        String modo = btgModo.getSelection().getActionCommand();
        switch (modo) {
            case "cresc":
                return 1;
            case "dec":
                return -1;
            default:
                return (random.nextInt(10) <= 4) ? -1 : 1;
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

        btgModo = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        lblUsuarios = new javax.swing.JLabel();
        cbUsuarios = new javax.swing.JComboBox<>();
        lblPlantas = new javax.swing.JLabel();
        cbPlantas = new javax.swing.JComboBox<>();
        lblValorInicial = new javax.swing.JLabel();
        lblTemp = new javax.swing.JLabel();
        lblPh = new javax.swing.JLabel();
        lblIrrigacao = new javax.swing.JLabel();
        lblUmidade = new javax.swing.JLabel();
        lblSolo = new javax.swing.JLabel();
        txtTemp = new javax.swing.JTextField();
        txtUmidade = new javax.swing.JTextField();
        txtIrrigacao = new javax.swing.JTextField();
        txtSolo = new javax.swing.JTextField();
        txtPh = new javax.swing.JTextField();
        lblValorInicial1 = new javax.swing.JLabel();
        lbllTaxaPh = new javax.swing.JLabel();
        lblTaxaTemp = new javax.swing.JLabel();
        lbllTaxaIrrigacao = new javax.swing.JLabel();
        lbllTaxaSolo = new javax.swing.JLabel();
        lbllTaxaUmidade = new javax.swing.JLabel();
        txtTaxaTemp = new javax.swing.JTextField();
        txtTaxaUmidade = new javax.swing.JTextField();
        txtTaxaIrrigacao = new javax.swing.JTextField();
        txtTaxaSolo = new javax.swing.JTextField();
        txtTaxaPh = new javax.swing.JTextField();
        btSimulacao = new javax.swing.JButton();
        rbModoAuto = new javax.swing.JRadioButton();
        lblPerfil = new javax.swing.JLabel();
        rbModoCresc = new javax.swing.JRadioButton();
        rbModoDec = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/bioSense-logo_menor.png"))); // NOI18N

        lblUsuarios.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblUsuarios.setText("Usuários");

        cbUsuarios.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbUsuariosItemStateChanged(evt);
            }
        });

        lblPlantas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPlantas.setText("Plantas");

        cbPlantas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbPlantasItemStateChanged(evt);
            }
        });

        lblValorInicial.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblValorInicial.setText("Valor Inicial dos Sensores");

        lblTemp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTemp.setText("Temperatura");

        lblPh.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPh.setText("PH");

        lblIrrigacao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblIrrigacao.setText("Irrigação");

        lblUmidade.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblUmidade.setText("Umidade");

        lblSolo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblSolo.setText("Solo");

        lblValorInicial1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblValorInicial1.setText("Taxa de Alteração dos Sensores");

        lbllTaxaPh.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbllTaxaPh.setText("PH");

        lblTaxaTemp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTaxaTemp.setText("Temperatura");

        lbllTaxaIrrigacao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbllTaxaIrrigacao.setText("Irrigação");

        lbllTaxaSolo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbllTaxaSolo.setText("Solo");

        lbllTaxaUmidade.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbllTaxaUmidade.setText("Umidade");

        btSimulacao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btSimulacao.setText("Iniciar Simulação");
        btSimulacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSimulacaoActionPerformed(evt);
            }
        });

        btgModo.add(rbModoAuto);
        rbModoAuto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rbModoAuto.setText("Modo Automático");

        lblPerfil.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPerfil.setText("Perfil de Simulação");

        btgModo.add(rbModoCresc);
        rbModoCresc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rbModoCresc.setText("Modo Crescente");

        btgModo.add(rbModoDec);
        rbModoDec.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rbModoDec.setText("Modo Decrescente");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblUsuarios)
                        .addGap(18, 18, 18)
                        .addComponent(cbUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblPlantas)
                        .addGap(18, 18, 18)
                        .addComponent(cbPlantas, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(70, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rbModoAuto)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btSimulacao)
                                .addGap(165, 165, 165))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(rbModoCresc)
                                .addGap(18, 18, 18)
                                .addComponent(rbModoDec)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(lblTemp)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtTemp, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(17, 17, 17))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblUmidade)
                                            .addComponent(lblPh))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtPh, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtUmidade, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblIrrigacao)
                                    .addComponent(lblSolo))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSolo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtIrrigacao, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(lblTaxaTemp)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtTaxaTemp, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(17, 17, 17))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbllTaxaUmidade)
                                            .addComponent(lbllTaxaPh))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtTaxaPh, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtTaxaUmidade, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbllTaxaIrrigacao)
                                    .addComponent(lbllTaxaSolo))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTaxaSolo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTaxaIrrigacao, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblValorInicial)
                        .addGap(148, 148, 148))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblValorInicial1)
                        .addGap(126, 126, 126))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblPerfil)
                        .addGap(174, 174, 174))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsuarios)
                    .addComponent(cbUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPlantas)
                    .addComponent(cbPlantas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblValorInicial)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTemp)
                    .addComponent(lblIrrigacao)
                    .addComponent(txtTemp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIrrigacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUmidade)
                    .addComponent(lblSolo)
                    .addComponent(txtUmidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSolo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPh)
                    .addComponent(txtPh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblValorInicial1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTaxaTemp)
                    .addComponent(lbllTaxaIrrigacao)
                    .addComponent(txtTaxaTemp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTaxaIrrigacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbllTaxaUmidade)
                    .addComponent(lbllTaxaSolo)
                    .addComponent(txtTaxaUmidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTaxaSolo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbllTaxaPh)
                    .addComponent(txtTaxaPh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblPerfil)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbModoAuto)
                    .addComponent(rbModoCresc)
                    .addComponent(rbModoDec))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(btSimulacao)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbUsuariosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbUsuariosItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            Object item = evt.getItem();
            if (item instanceof Usuario) {
                this.selectedUsuario = (Usuario) item;
                List<Planta> plantas = port.todasPlantaPorUsuario(this.selectedUsuario.getId());
                plantas.forEach(planta -> cbPlantas.addItem(planta));
            } else {
                this.selectedUsuario = null;
            }
        }
    }//GEN-LAST:event_cbUsuariosItemStateChanged

    private boolean validaCampos() {
        if (this.selectedUsuario == null) {
            JOptionPane.showMessageDialog(null, "Selecione um Usuário");
            return false;
        } else if (this.selectedPlanta == null) {
            JOptionPane.showMessageDialog(null, "Selecione uma Planta");
            return false;
        } else if (StringUtils.IsNullOrEmpty(txtTemp.getText()) || StringUtils.IsNullOrEmpty(txtTaxaTemp.getText())) {
            JOptionPane.showMessageDialog(null, "Preencha a Temperatura Inicial e sua Taxa de Variação");
            return false;
        } else if (StringUtils.IsNullOrEmpty(txtIrrigacao.getText()) || StringUtils.IsNullOrEmpty(txtTaxaIrrigacao.getText())) {
            JOptionPane.showMessageDialog(null, "Preencha a Irrigação Inicial e sua Taxa de Variação");
            return false;
        } else if (StringUtils.IsNullOrEmpty(txtPh.getText()) || StringUtils.IsNullOrEmpty(txtTaxaPh.getText())) {
            JOptionPane.showMessageDialog(null, "Preencha o PH Inicial e sua Taxa de Variação");
            return false;
        } else if (StringUtils.IsNullOrEmpty(txtTaxaUmidade.getText()) || StringUtils.IsNullOrEmpty(txtTaxaUmidade.getText())) {
            JOptionPane.showMessageDialog(null, "Preencha a Umidade Inicial e sua Taxa de variação");
            return false;
        } else if (StringUtils.IsNullOrEmpty(txtTaxaSolo.getText()) || StringUtils.IsNullOrEmpty(txtTaxaSolo.getText())) {
            JOptionPane.showMessageDialog(null, "Preencha a Qualidade do Solo Inicial e sua Taxa de variação");
            return false;
        }

        return true;
    }

    private void btSimulacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSimulacaoActionPerformed
        // TODO add your handling code here:
        if (!simulacao) {
            if (validaCampos()) {
                simulacao = true;
                alterarComponentesAtivos(false);
                btSimulacao.setText("Parar Simulação");
                timer = new Timer();
                timer.schedule(new GeraLeituraTask(), 0, 5000);
            }
        } else {
            simulacao = false;
            alterarComponentesAtivos(true);
            btSimulacao.setText("Iniciar Simulação");
            timer.cancel();
        }
    }//GEN-LAST:event_btSimulacaoActionPerformed

    private void alterarComponentesAtivos(boolean enabled) {
        cbPlantas.setEnabled(enabled);
        cbUsuarios.setEnabled(enabled);
        txtTaxaIrrigacao.setEnabled(enabled);
        txtTaxaPh.setEnabled(enabled);
        txtTaxaSolo.setEnabled(enabled);
        txtTaxaTemp.setEnabled(enabled);
        txtTaxaUmidade.setEnabled(enabled);
        /*
        txtIrrigacao.setEnabled(enabled);
        txtPh.setEnabled(enabled);
        txtSolo.setEnabled(enabled);
        txtTemp.setEnabled(enabled);
        txtUmidade.setEnabled(enabled);
        rbModoAuto.setEnabled(enabled);
        rbModoCresc.setEnabled(enabled);
        rbModoDec.setEnabled(enabled);
         */
    }

    private void cbPlantasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbPlantasItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            Object item = evt.getItem();
            if (item instanceof Planta) {
                this.selectedPlanta = (Planta) item;
            } else {
                this.selectedPlanta = null;
            }
        }
    }//GEN-LAST:event_cbPlantasItemStateChanged

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
            java.util.logging.Logger.getLogger(Sensores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sensores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sensores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sensores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sensores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSimulacao;
    private javax.swing.ButtonGroup btgModo;
    private javax.swing.JComboBox<Planta> cbPlantas;
    private javax.swing.JComboBox<Usuario> cbUsuarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblIrrigacao;
    private javax.swing.JLabel lblPerfil;
    private javax.swing.JLabel lblPh;
    private javax.swing.JLabel lblPlantas;
    private javax.swing.JLabel lblSolo;
    private javax.swing.JLabel lblTaxaTemp;
    private javax.swing.JLabel lblTemp;
    private javax.swing.JLabel lblUmidade;
    private javax.swing.JLabel lblUsuarios;
    private javax.swing.JLabel lblValorInicial;
    private javax.swing.JLabel lblValorInicial1;
    private javax.swing.JLabel lbllTaxaIrrigacao;
    private javax.swing.JLabel lbllTaxaPh;
    private javax.swing.JLabel lbllTaxaSolo;
    private javax.swing.JLabel lbllTaxaUmidade;
    private javax.swing.JRadioButton rbModoAuto;
    private javax.swing.JRadioButton rbModoCresc;
    private javax.swing.JRadioButton rbModoDec;
    private javax.swing.JTextField txtIrrigacao;
    private javax.swing.JTextField txtPh;
    private javax.swing.JTextField txtSolo;
    private javax.swing.JTextField txtTaxaIrrigacao;
    private javax.swing.JTextField txtTaxaPh;
    private javax.swing.JTextField txtTaxaSolo;
    private javax.swing.JTextField txtTaxaTemp;
    private javax.swing.JTextField txtTaxaUmidade;
    private javax.swing.JTextField txtTemp;
    private javax.swing.JTextField txtUmidade;
    // End of variables declaration//GEN-END:variables
}
