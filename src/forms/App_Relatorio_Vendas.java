package forms;

import classes.RelatorioPrintable;
import com.formdev.flatlaf.IntelliJTheme;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.StringJoiner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;

public class App_Relatorio_Vendas extends javax.swing.JFrame {

    private String cliente;
    private String produtos;
    private String condicoesPagamento;

    public App_Relatorio_Vendas() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField_Cliente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea_Produtos = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea_CondicoesPagamento = new javax.swing.JTextArea();
        jButton_Imprimir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("App Relatorio Vendas");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Cliente");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("Produtos");

        jTextArea_Produtos.setColumns(20);
        jTextArea_Produtos.setRows(5);
        jScrollPane1.setViewportView(jTextArea_Produtos);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setText("Condições de Pagamento");

        jTextArea_CondicoesPagamento.setColumns(20);
        jTextArea_CondicoesPagamento.setRows(5);
        jScrollPane2.setViewportView(jTextArea_CondicoesPagamento);

        jButton_Imprimir.setText("Imprimir");
        jButton_Imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ImprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField_Cliente)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(150, 150, 150)
                                        .addComponent(jLabel1))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(158, 158, 158)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane2)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton_Imprimir)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton_Imprimir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void jButton_ImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ImprimirActionPerformed
        cliente = jTextField_Cliente.getText();
        produtos = jTextArea_Produtos.getText();
        condicoesPagamento = jTextArea_CondicoesPagamento.getText();

        try {
            // Chamar o método de geração do relatório de venda
            gerarRelatorioVenda();
        } catch (PrinterException ex) {
            Logger.getLogger(App_Relatorio_Vendas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton_ImprimirActionPerformed

    private void gerarRelatorioVenda() throws PrinterException {
        StringJoiner joiner = new StringJoiner(System.lineSeparator());
        joiner.add("RELATÓRIO DE VENDA");
        joiner.add("Cliente: " + cliente);
        joiner.add("Produtos:");
        joiner.add(produtos);
        joiner.add("Condições de Pagamento:");
        joiner.add(condicoesPagamento);

        String relatorio = joiner.toString();

        // Imprimir o relatório
        imprimirRelatorio(relatorio);
    }

    private void imprimirRelatorio(String relatorio) throws PrinterException {
        // Obter a impressora padrão ou uma impressora específica
        PrintService impressora = PrintServiceLookup.lookupDefaultPrintService(); // Ou substitua por uma impressora específica

        if (impressora == null) {
            System.err.println("Nenhuma impressora disponível.");
            return;
        }

        // Criar um trabalho de impressão
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintService(impressora);

        // Definir o conteúdo a ser impresso
        job.setPrintable(new RelatorioPrintable(relatorio));

        // Iniciar a impressão
        try {
            job.print();
        } catch (PrinterException e) {
            System.err.println("Erro ao imprimir: " + e.getMessage());
        }
    }

    public static void main(String args[]) {
        try {
            IntelliJTheme.setup(App_Relatorio_Vendas.class.getResourceAsStream("/Visual_Studio_2019_Dark_Theme.theme.json"));
        } catch (Exception e) {
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new App_Relatorio_Vendas().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Imprimir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea_CondicoesPagamento;
    private javax.swing.JTextArea jTextArea_Produtos;
    private javax.swing.JTextField jTextField_Cliente;
    // End of variables declaration//GEN-END:variables
}
