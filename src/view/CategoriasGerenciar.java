package view;

import dao.CategoriaDao;
import java.util.List;
import javax.swing.JOptionPane;
import model.entidades.Categoria;
import model.tablemodels.CategoriasTable;

public class CategoriasGerenciar extends javax.swing.JFrame {

    CategoriasTable table;
    CategoriaDao categoriaDao;
    List<Categoria> listCategoria;

    public CategoriasGerenciar() {
        initComponents();
        categoriaDao = new CategoriaDao();
        lerTableInicial();
        lerLbl();
        tblTabela.setModel(table);
    }

    public void lerTableInicial() {
        int qtdPaginas = Integer.parseInt(String.valueOf(jcbQtdPaginas.getSelectedItem()));
        listCategoria = categoriaDao.pesquisarTodos();
        table = new CategoriasTable(listCategoria, qtdPaginas);
        verificarBotoes();
    }

    public void lerTableEditado() {
        int qtdPaginas = Integer.parseInt(String.valueOf(jcbQtdPaginas.getSelectedItem()));
        listCategoria = categoriaDao.pesquisarTodos();
        table = new CategoriasTable(listCategoria, qtdPaginas, table.getPaginaAtual());
        verificarBotoes();
    }

    public void lerLbl() {
        String lblPaginaAtual = "Página: " + this.table.getPaginaAtual() + " de " + this.table.getTotalDePagina();
        this.lblPaginaAtual.setText(lblPaginaAtual);
        String lblMostrando = "Mostrando: " + this.table.getListCategorias().size() + " de " + this.table.getListCategoriasTotal().size();
        this.lblMostrando.setText(lblMostrando);
    }

    private void verificarBotoes() {
        if (table.verificarExistenciaAnterior()) {
            btnAnterior.setEnabled(true);
        } else {
            btnAnterior.setEnabled(false);
        }

        if (table.verificarExistenciaProxima()) {
            btnProximo.setEnabled(true);
        } else {
            btnProximo.setEnabled(false);
        }

        if (table.verificarPrimeiraPagina()) {
            btnPrimeiro.setEnabled(false);
        } else {
            btnPrimeiro.setEnabled(true);
        }
        if (table.verificarUltimaPagina()) {
            btnUltimo.setEnabled(true);
        } else {
            btnUltimo.setEnabled(false);
        }
        if (tblTabela.getSelectedRow() != -1) {
            btnDeletar.setEnabled(true);
            btnAlterar.setEnabled(true);
        } else {
            btnDeletar.setEnabled(false);
            btnAlterar.setEnabled(false);
        }
        lerLbl();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jtfNome = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTabela = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jcbQtdPaginas = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        lblPaginaAtual = new javax.swing.JLabel();
        lblMostrando = new javax.swing.JLabel();
        btnPrimeiro = new javax.swing.JButton();
        btnAnterior = new javax.swing.JButton();
        btnProximo = new javax.swing.JButton();
        btnUltimo = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnDeletar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Gerenciamento de categorias de produtos");

        jtfNome.setEnabled(false);

        btnSalvar.setText("Salvar");
        btnSalvar.setEnabled(false);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        tblTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTabela);

        jLabel2.setText("Itens por págna:");

        jcbQtdPaginas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15" }));
        jcbQtdPaginas.setSelectedIndex(4);
        jcbQtdPaginas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbQtdPaginasItemStateChanged(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true), "Controle", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(102, 102, 102))); // NOI18N

        lblPaginaAtual.setText("Página: [ATUAL] de [TOTAL]");

        lblMostrando.setText("Mostrando: [ATUAL_LISTAGEM] de [TOTAL_REGISTRO]");

        btnPrimeiro.setText("Primeiro");
        btnPrimeiro.setEnabled(false);
        btnPrimeiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrimeiroActionPerformed(evt);
            }
        });

        btnAnterior.setText("Anterior");
        btnAnterior.setEnabled(false);
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });

        btnProximo.setText("Próximo");
        btnProximo.setEnabled(false);
        btnProximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProximoActionPerformed(evt);
            }
        });

        btnUltimo.setText("Último");
        btnUltimo.setEnabled(false);
        btnUltimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUltimoActionPerformed(evt);
            }
        });

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnAlterar.setText("Alterar");
        btnAlterar.setEnabled(false);
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnDeletar.setText("Deletar");
        btnDeletar.setEnabled(false);
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnPrimeiro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAnterior)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnProximo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUltimo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDeletar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblPaginaAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblMostrando)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMostrando)
                    .addComponent(lblPaginaAtual))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrimeiro)
                    .addComponent(btnAnterior)
                    .addComponent(btnProximo)
                    .addComponent(btnUltimo)
                    .addComponent(btnNovo)
                    .addComponent(btnAlterar)
                    .addComponent(btnDeletar))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 520, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbQtdPaginas, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 393, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jtfNome))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtfNome, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcbQtdPaginas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        if (!jtfNome.isEnabled()) {
            jtfNome.setEnabled(true);
            btnSalvar.setEnabled(true);
            btnNovo.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, termine de alterar a categoria!", "AVISO", JOptionPane.DEFAULT_OPTION);
        }
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnProximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProximoActionPerformed
        table.proximaPagina();
        verificarBotoes();
    }//GEN-LAST:event_btnProximoActionPerformed

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        table.anteriorPagina();
        verificarBotoes();
    }//GEN-LAST:event_btnAnteriorActionPerformed

    private void jcbQtdPaginasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbQtdPaginasItemStateChanged
        table.alterarLimite(Integer.parseInt(String.valueOf(jcbQtdPaginas.getSelectedItem())));
        verificarBotoes();
    }//GEN-LAST:event_jcbQtdPaginasItemStateChanged

    private void btnPrimeiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrimeiroActionPerformed
        table.paginaInicial();
        verificarBotoes();
    }//GEN-LAST:event_btnPrimeiroActionPerformed

    private void btnUltimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUltimoActionPerformed
        table.paginaFinal();
        verificarBotoes();
    }//GEN-LAST:event_btnUltimoActionPerformed

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        if (!jtfNome.isEnabled()) {
            if (tblTabela.getSelectedRow() != -1) {
                categoriaDao.deletar(table.getRow(tblTabela.getSelectedRow()));
            } else {
                JOptionPane.showMessageDialog(null, "SELECIONA UMA LINHA", "AVISO", JOptionPane.DEFAULT_OPTION);
            }
            lerTableEditado();
            tblTabela.setModel(table);
            verificarBotoes();
        } else {
            JOptionPane.showMessageDialog(null, "  Não é possível remover uma Categoria \nenquanto estiver editando ou adicionando!", "AVISO", JOptionPane.DEFAULT_OPTION);
        }
    }//GEN-LAST:event_btnDeletarActionPerformed

    private void tblTabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTabelaMouseClicked
        if (jtfNome.isEnabled()) {
            if (tblTabela.getSelectedRow() != -1) {
                jtfNome.setText((String) table.getValueAt(tblTabela.getSelectedRow(), 1));
            }
        }
        verificarBotoes();
    }//GEN-LAST:event_tblTabelaMouseClicked

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        if (btnNovo.isEnabled()) {
            jtfNome.setEnabled(true);
            btnSalvar.setEnabled(true);
            verificarBotoes();
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, termine a criação de uma nova categoria", "AVISO", JOptionPane.DEFAULT_OPTION);
        }
        lerTableInicial();

    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (btnNovo.isEnabled()) {
            Categoria categoria = new Categoria();
            categoria.setId((int) table.getValueAt(tblTabela.getSelectedRow(), 0));
            categoria.setNome(jtfNome.getText());
            categoriaDao.alterar(categoria);
        } else {
            if (jtfNome.getText().length() > 0) {
                Categoria categoria = new Categoria();
                categoria.setNome(jtfNome.getText());
                table.addRow(categoriaDao.buscarPorId(categoriaDao.cadastrar(categoria)));
            }
        }
        btnSalvar.setEnabled(false);
        jtfNome.setEnabled(false);
        jtfNome.setText("");
        tblTabela.clearSelection();
        btnNovo.setEnabled(true);
        lerTableInicial();
        tblTabela.setModel(table);
        verificarBotoes();

    }//GEN-LAST:event_btnSalvarActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CategoriasGerenciar.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CategoriasGerenciar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPrimeiro;
    private javax.swing.JButton btnProximo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnUltimo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcbQtdPaginas;
    private javax.swing.JTextField jtfNome;
    private javax.swing.JLabel lblMostrando;
    private javax.swing.JLabel lblPaginaAtual;
    private javax.swing.JTable tblTabela;
    // End of variables declaration//GEN-END:variables
}
