package controle;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * @author afonso gonczoroski
 * data 14-03-2022
 */

public class Principal extends javax.swing.JFrame {
    ArrayList<Departamento> ListaDepartamento;
    ArrayList<Funcionario>  ListaFuncionario;
    ArrayList<Tarefas>      ListaTarefas;
    String modoDepartamento;
    String modoFuncionario;
    String modoTarefas;

    public void LoadTableDepartamento(){
        DefaultTableModel modelo = new DefaultTableModel(new Object[]{"Código","Nome"},0);
        for(int i=0;i<ListaDepartamento.size();i++){
            Object linha[] = new Object[]{ListaDepartamento.get(i).getCodigo(),
                                          ListaDepartamento.get(i).getNome()};
            modelo.addRow(linha);
        }
        tabelaDepartamentos.setModel(modelo);
        tabelaDepartamentos.getColumnModel().getColumn(0).setPreferredWidth(50);
        tabelaDepartamentos.getColumnModel().getColumn(1).setPreferredWidth(200);
        LoadSelectDepartamento();
    }

    public void LoadTableFuncionario(){
        DefaultTableModel modelo = new DefaultTableModel(new Object[]{"Matrícula","Nome","Departamento"},0);
        for(int i=0;i<ListaFuncionario.size();i++){
            Object linha[] = new Object[]{ListaFuncionario.get(i).getMatricula(),
                                          ListaFuncionario.get(i).getNome(),
                                          ListaFuncionario.get(i).getDepartamento().getNome()};
            modelo.addRow(linha);
        }
        tabelaFuncionarios.setModel(modelo);
        tabelaFuncionarios.getColumnModel().getColumn(0).setPreferredWidth(100);
        tabelaFuncionarios.getColumnModel().getColumn(1).setPreferredWidth(150);
        tabelaFuncionarios.getColumnModel().getColumn(2).setPreferredWidth(150);
        LoadSelectFuncionario();
    }

    public void LoadTableTarefas(){
        DefaultTableModel modelo = new DefaultTableModel(new Object[]{"ID","Titulo","Descricao","Prazo","Departamento","Duracao","Pessoas","Finalizado"},0);
        for(int i=0;i<ListaTarefas.size();i++){
            Object linha[] = new Object[]{ListaTarefas.get(i).getID(),
                                          ListaTarefas.get(i).getnomeTitulo(),
                                          ListaTarefas.get(i).getnomeDescricao(),
                                          ListaTarefas.get(i).getnomePrazo(),
                                          ListaTarefas.get(i).getduracao(),
                                          ListaTarefas.get(i).getFuncionario(),
                                          ListaTarefas.get(i).getfinalizado()};
            modelo.addRow(linha);
        }
        tabelaTarefas.setModel(modelo);
        tabelaTarefas.getColumnModel().getColumn(0).setPreferredWidth(500);
        tabelaTarefas.getColumnModel().getColumn(1).setPreferredWidth(100);
        tabelaTarefas.getColumnModel().getColumn(2).setPreferredWidth(200);
        tabelaTarefas.getColumnModel().getColumn(3).setPreferredWidth(100);
        tabelaTarefas.getColumnModel().getColumn(4).setPreferredWidth(70);
        tabelaTarefas.getColumnModel().getColumn(5).setPreferredWidth(150);
        tabelaTarefas.getColumnModel().getColumn(6).setPreferredWidth(50);
        LoadSelectTarefas();
    }
    
    public void LoadSelectDepartamento(){
        departamentoFuncionario.removeAllItems();
        departamentoFuncionario.addItem("Selecione");
        for(int i=0;i<ListaDepartamento.size();i++){
            departamentoFuncionario.addItem(ListaDepartamento.get(i).getNome());
        }
    }

    public void LoadSelectFuncionario(){
        pessoas.removeAllItems();
        pessoas.addItem("Selecione");
        for(int i=0;i<ListaFuncionario.size();i++){
            pessoas.addItem(ListaFuncionario.get(i).getNome());
        }
    }
    
    public void LoadSelectTarefas(){
        departamentoFuncionario.removeAllItems();
        departamentoFuncionario.addItem("Selecione");
        for(int i=0;i<ListaDepartamento.size();i++){
            departamentoFuncionario.addItem(ListaDepartamento.get(i).getNome());
        }
    }

    public Principal() {
        initComponents();
        setLocationRelativeTo(null);
        ListaDepartamento = new ArrayList();
        ListaFuncionario = new ArrayList();
        ListaTarefas = new ArrayList();
        modoDepartamento = "Iniciar";
        modoFuncionario = "Iniciar";
        modoTarefas = "Iniciar";
        interfaceDepartamento();
        interfaceFuncionario();
        interfaceTarefas();
    }
    
    public void interfaceDepartamento(){
        switch(modoDepartamento){
            case "Iniciar":
                btnDepartamentoSalvar.setEnabled(false);
                btnDepartamentoCancelar.setEnabled(false);
                codigoDepartamento.setEnabled(false);
                nomeDepartamento.setEnabled(false);
                btnDepartamentoNovo.setEnabled(true);
                btnDepartamentoEditar.setEnabled(false);
                btnDepartamentoExcluir.setEnabled(false);
                break;
            
            case "Novo":
                btnDepartamentoSalvar.setEnabled(true);
                btnDepartamentoCancelar.setEnabled(true);
                codigoDepartamento.setEnabled(true);
                nomeDepartamento.setEnabled(true);
                btnDepartamentoNovo.setEnabled(false);
                btnDepartamentoEditar.setEnabled(false);
                btnDepartamentoExcluir.setEnabled(false);
                break;
                
            case "Editar":
                btnDepartamentoSalvar.setEnabled(true);
                btnDepartamentoCancelar.setEnabled(true);
                codigoDepartamento.setEnabled(true);
                nomeDepartamento.setEnabled(true);
                btnDepartamentoNovo.setEnabled(true);
                btnDepartamentoEditar.setEnabled(false);
                btnDepartamentoExcluir.setEnabled(false);
                break;
                
            case "Excluir":
                btnDepartamentoSalvar.setEnabled(false);
                btnDepartamentoCancelar.setEnabled(false);
                codigoDepartamento.setEnabled(false);
                nomeDepartamento.setEnabled(false);
                btnDepartamentoNovo.setEnabled(true);
                btnDepartamentoEditar.setEnabled(false);
                btnDepartamentoExcluir.setEnabled(false);
                break;
                
            case "Selecao":
                btnDepartamentoSalvar.setEnabled(false);
                btnDepartamentoCancelar.setEnabled(false);
                codigoDepartamento.setEnabled(false);
                nomeDepartamento.setEnabled(false);
                btnDepartamentoNovo.setEnabled(true);
                btnDepartamentoEditar.setEnabled(true);
                btnDepartamentoExcluir.setEnabled(true);
                break;
            default: System.out.println("Modo inválido");
        }
    }
    
    public void interfaceFuncionario(){
        switch(modoFuncionario){
            case "Iniciar":
                btnFuncionarioSalvar.setEnabled(false);
                btnFuncionarioCancelar.setEnabled(false);
                matriculaFuncionario.setEnabled(false);
                nomeFuncionario.setEnabled(false);
                btnFuncionarioNovo.setEnabled(true);
                btnFuncionarioEditar.setEnabled(false);
                btnFuncionarioExcluir.setEnabled(false);
                departamentoFuncionario.setEnabled(false);
                break;
            
            case "Novo":
                btnFuncionarioSalvar.setEnabled(true);
                btnFuncionarioCancelar.setEnabled(true);
                matriculaFuncionario.setEnabled(true);
                nomeFuncionario.setEnabled(true);
                departamentoFuncionario.setEnabled(true);
                btnFuncionarioNovo.setEnabled(false);
                btnFuncionarioEditar.setEnabled(false);
                btnFuncionarioExcluir.setEnabled(false);
                break;
                
            case "Editar":
                btnFuncionarioSalvar.setEnabled(true);
                btnFuncionarioCancelar.setEnabled(true);
                matriculaFuncionario.setEnabled(true);
                nomeFuncionario.setEnabled(true);
                departamentoFuncionario.setEnabled(true);
                btnFuncionarioNovo.setEnabled(true);
                btnFuncionarioEditar.setEnabled(false);
                btnFuncionarioExcluir.setEnabled(false);
                break;
                
            case "Excluir":
                btnFuncionarioSalvar.setEnabled(false);
                btnFuncionarioCancelar.setEnabled(false);
                matriculaFuncionario.setEnabled(false);
                nomeFuncionario.setEnabled(false);
                departamentoFuncionario.setEnabled(false);
                btnFuncionarioNovo.setEnabled(true);
                btnFuncionarioEditar.setEnabled(false);
                btnFuncionarioExcluir.setEnabled(false);
                break;
                
            case "Selecao":
                btnFuncionarioSalvar.setEnabled(false);
                btnFuncionarioCancelar.setEnabled(false);
                matriculaFuncionario.setEnabled(false);
                nomeFuncionario.setEnabled(false);
                departamentoFuncionario.setEnabled(false);
                btnFuncionarioNovo.setEnabled(true);
                btnFuncionarioEditar.setEnabled(true);
                btnFuncionarioExcluir.setEnabled(true);
                break;
            default: System.out.println("Modo inválido");
        }
    }
    
    public void interfaceTarefas(){
        switch(modoTarefas){
            case "Iniciar":
                btnTarefasNovo.setEnabled(true);
                btnTarefasEditar.setEnabled(false);
                btnTarefasExcluir.setEnabled(false);
                ID.setEnabled(false);
                nomeTitulo.setEnabled(false);
                nomePrazo.setEnabled(false);
                nomeDescricao.setEnabled(false);
                nomeDuracao.setEnabled(false);
                pessoas.setEnabled(false);
                nomeFinalizado.setEnabled(false);
                btnTarefasSalvar.setEnabled(false);
                btnTarefasCancelar.setEnabled(false);
                break;
            case "Novo":
                btnTarefasNovo.setEnabled(true);
                btnTarefasEditar.setEnabled(false);
                btnTarefasExcluir.setEnabled(false);
                ID.setEnabled(true);
                nomeTitulo.setEnabled(true);
                nomePrazo.setEnabled(true);
                nomeDescricao.setEnabled(true);
                nomeDuracao.setEnabled(true);
                pessoas.setEnabled(true);
                nomeFinalizado.setEnabled(true);
                btnTarefasSalvar.setEnabled(true);
                btnTarefasCancelar.setEnabled(true);
                break;
            case "Editar":
                btnTarefasNovo.setEnabled(false);
                btnTarefasEditar.setEnabled(true);
                btnTarefasExcluir.setEnabled(false);
                ID.setEnabled(true);
                nomeTitulo.setEnabled(true);
                nomePrazo.setEnabled(true);
                nomeDescricao.setEnabled(true);
                nomeDuracao.setEnabled(true);
                pessoas.setEnabled(true);
                nomeFinalizado.setEnabled(true);
                btnTarefasSalvar.setEnabled(true);
                btnTarefasCancelar.setEnabled(true);
                break;
            case "Excluir":
                btnTarefasNovo.setEnabled(false);
                btnTarefasEditar.setEnabled(false);
                btnTarefasExcluir.setEnabled(true);
                ID.setEnabled(false);
                nomeTitulo.setEnabled(false);
                nomePrazo.setEnabled(false);
                nomeDescricao.setEnabled(false);
                nomeDuracao.setEnabled(false);
                pessoas.setEnabled(false);
                nomeFinalizado.setEnabled(false);
                btnTarefasSalvar.setEnabled(false);
                btnTarefasCancelar.setEnabled(true);
                break;
            case "Selecao":
                btnTarefasNovo.setEnabled(true);
                btnTarefasEditar.setEnabled(true);
                btnTarefasExcluir.setEnabled(true);
                ID.setEnabled(true);
                nomeTitulo.setEnabled(true);
                nomePrazo.setEnabled(true);
                nomeDescricao.setEnabled(true);
                nomeDuracao.setEnabled(true);
                pessoas.setEnabled(true);
                nomeFinalizado.setEnabled(true);
                btnTarefasSalvar.setEnabled(true);
                btnTarefasCancelar.setEnabled(true);
                break;
            default: System.out.println("Modo inválido");
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaDepartamentos = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        codigoDepartamento = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        nomeDepartamento = new javax.swing.JTextField();
        btnDepartamentoSalvar = new javax.swing.JButton();
        btnDepartamentoCancelar = new javax.swing.JButton();
        btnDepartamentoNovo = new javax.swing.JButton();
        btnDepartamentoEditar = new javax.swing.JButton();
        btnDepartamentoExcluir = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnFuncionarioEditar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaFuncionarios = new javax.swing.JTable();
        btnFuncionarioExcluir = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        matriculaFuncionario = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        nomeFuncionario = new javax.swing.JTextField();
        btnFuncionarioSalvar = new javax.swing.JButton();
        btnFuncionarioCancelar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        departamentoFuncionario = new javax.swing.JComboBox();
        btnFuncionarioNovo = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        btnTarefasEditar = new javax.swing.JButton();
        btnTarefasExcluir = new javax.swing.JButton();
        btnTarefasNovo = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaTarefas = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        Codigo = new javax.swing.JLabel();
        ID = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        nomeTitulo = new javax.swing.JTextField();
        btnTarefasSalvar = new javax.swing.JButton();
        btnTarefasCancelar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        pessoas = new javax.swing.JComboBox();
        Descricao = new javax.swing.JLabel();
        nomeDescricao = new javax.swing.JTextField();
        Prazo = new javax.swing.JLabel();
        nomePrazo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        nomeDuracao = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        nomeFinalizado = new javax.swing.JTextField();
        titulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabelaDepartamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaDepartamentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaDepartamentosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaDepartamentos);
        if (tabelaDepartamentos.getColumnModel().getColumnCount() > 0) {
            tabelaDepartamentos.getColumnModel().getColumn(0).setResizable(false);
            tabelaDepartamentos.getColumnModel().getColumn(0).setPreferredWidth(100);
            tabelaDepartamentos.getColumnModel().getColumn(1).setPreferredWidth(150);
        }

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Departamento"));

        jLabel1.setText("Código:");

        jLabel2.setText("Nome:");

        btnDepartamentoSalvar.setText("Salvar");
        btnDepartamentoSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDepartamentoSalvarActionPerformed(evt);
            }
        });

        btnDepartamentoCancelar.setText("Cancelar");
        btnDepartamentoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDepartamentoCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(codigoDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(nomeDepartamento)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnDepartamentoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDepartamentoCancelar)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(codigoDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nomeDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDepartamentoSalvar)
                    .addComponent(btnDepartamentoCancelar))
                .addContainerGap())
        );

        btnDepartamentoNovo.setText("Novo");
        btnDepartamentoNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDepartamentoNovoActionPerformed(evt);
            }
        });

        btnDepartamentoEditar.setText("Editar");
        btnDepartamentoEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDepartamentoEditarActionPerformed(evt);
            }
        });

        btnDepartamentoExcluir.setText("Excluir");
        btnDepartamentoExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDepartamentoExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(btnDepartamentoNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDepartamentoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDepartamentoExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDepartamentoNovo)
                    .addComponent(btnDepartamentoEditar)
                    .addComponent(btnDepartamentoExcluir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Departamentos", jPanel1);

        btnFuncionarioEditar.setText("Editar");
        btnFuncionarioEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFuncionarioEditarActionPerformed(evt);
            }
        });

        tabelaFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Matrícula", "Nome", "Departamento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaFuncionarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaFuncionariosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelaFuncionarios);
        if (tabelaFuncionarios.getColumnModel().getColumnCount() > 0) {
            tabelaFuncionarios.getColumnModel().getColumn(0).setResizable(false);
            tabelaFuncionarios.getColumnModel().getColumn(0).setPreferredWidth(50);
            tabelaFuncionarios.getColumnModel().getColumn(1).setPreferredWidth(100);
            tabelaFuncionarios.getColumnModel().getColumn(2).setPreferredWidth(100);
        }

        btnFuncionarioExcluir.setText("Excluir");
        btnFuncionarioExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFuncionarioExcluirActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Funcionário"));

        jLabel3.setText("Matrícula:");

        jLabel4.setText("Nome:");

        btnFuncionarioSalvar.setText("Salvar");
        btnFuncionarioSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFuncionarioSalvarActionPerformed(evt);
            }
        });

        btnFuncionarioCancelar.setText("Cancelar");
        btnFuncionarioCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFuncionarioCancelarActionPerformed(evt);
            }
        });

        jLabel5.setText("Dep:");

        departamentoFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                departamentoFuncionarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnFuncionarioSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnFuncionarioCancelar))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nomeFuncionario)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(matriculaFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(departamentoFuncionario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(matriculaFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(nomeFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(departamentoFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFuncionarioSalvar)
                    .addComponent(btnFuncionarioCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnFuncionarioNovo.setText("Novo");
        btnFuncionarioNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFuncionarioNovoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(btnFuncionarioNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFuncionarioEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFuncionarioExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFuncionarioNovo)
                    .addComponent(btnFuncionarioEditar)
                    .addComponent(btnFuncionarioExcluir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Funcionários", jPanel2);

        btnTarefasEditar.setText("Editar");
        btnTarefasEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTarefasEditarActionPerformed(evt);
            }
        });

        btnTarefasExcluir.setText("Excluir");
        btnTarefasExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTarefasExcluirActionPerformed(evt);
            }
        });

        btnTarefasNovo.setText("Novo");
        btnTarefasNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTarefasNovoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(btnTarefasNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTarefasEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTarefasExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTarefasNovo)
                    .addComponent(btnTarefasEditar)
                    .addComponent(btnTarefasExcluir))
                .addContainerGap(196, Short.MAX_VALUE))
        );

        tabelaTarefas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Título", "Descrição", "Prazo", "Departamento", "Duração", "Funcionario", "Finalizado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true, false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaTarefas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaTarefasMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabelaTarefas);
        if (tabelaTarefas.getColumnModel().getColumnCount() > 0) {
            tabelaTarefas.getColumnModel().getColumn(0).setResizable(false);
            tabelaTarefas.getColumnModel().getColumn(0).setPreferredWidth(50);
            tabelaTarefas.getColumnModel().getColumn(1).setPreferredWidth(100);
            tabelaTarefas.getColumnModel().getColumn(2).setPreferredWidth(150);
            tabelaTarefas.getColumnModel().getColumn(3).setPreferredWidth(50);
            tabelaTarefas.getColumnModel().getColumn(4).setPreferredWidth(100);
            tabelaTarefas.getColumnModel().getColumn(5).setPreferredWidth(50);
            tabelaTarefas.getColumnModel().getColumn(6).setPreferredWidth(100);
            tabelaTarefas.getColumnModel().getColumn(7).setPreferredWidth(70);
        }

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Tarefas"));

        Codigo.setText("Codigo ID:");

        jLabel7.setText("Título:");

        btnTarefasSalvar.setText("Salvar");
        btnTarefasSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTarefasSalvarActionPerformed(evt);
            }
        });

        btnTarefasCancelar.setText("Cancelar");
        btnTarefasCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTarefasCancelarActionPerformed(evt);
            }
        });

        jLabel8.setText("Funcionario:");

        pessoas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pessoasActionPerformed(evt);
            }
        });

        Descricao.setText("Descrição:");

        nomeDescricao.setText("Descreva tarefa");

        Prazo.setText("Prazo:");

        jLabel10.setText("Duração:");

        jLabel9.setText("Finalizado:");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Descricao)
                    .addComponent(Codigo)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(nomeDescricao, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nomeTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Prazo))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(nomeDuracao, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pessoas, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addGap(6, 6, 6)))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nomeFinalizado, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomePrazo, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(85, 85, 85))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnTarefasSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTarefasCancelar)
                .addGap(33, 33, 33))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Codigo)
                    .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(nomeTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomePrazo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Prazo))
                .addGap(9, 9, 9)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Descricao)
                    .addComponent(nomeDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(pessoas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)
                        .addComponent(nomeDuracao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(nomeFinalizado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTarefasCancelar)
                    .addComponent(btnTarefasSalvar))
                .addGap(29, 29, 29))
        );

        Codigo.getAccessibleContext().setAccessibleName("Codigo:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 666, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel7.getAccessibleContext().setAccessibleName("Tarefas");

        jTabbedPane1.addTab("Tarefas", jPanel5);

        titulo.setText("CONTROLE");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(321, 321, 321)
                .addComponent(titulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDepartamentoNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDepartamentoNovoActionPerformed
        codigoDepartamento.setText("");
        nomeDepartamento.setText("");
        modoDepartamento = "Novo";
        interfaceDepartamento();
    }//GEN-LAST:event_btnDepartamentoNovoActionPerformed

    private void btnDepartamentoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDepartamentoCancelarActionPerformed
        codigoDepartamento.setText("");
        nomeDepartamento.setText("");
        modoDepartamento = "Iniciar";
        interfaceDepartamento();
    }//GEN-LAST:event_btnDepartamentoCancelarActionPerformed

    private void btnDepartamentoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDepartamentoSalvarActionPerformed
        int cod = Integer.parseInt(codigoDepartamento.getText());
        if(modoDepartamento.equals("Novo")){  
            Departamento D = new Departamento(cod, nomeDepartamento.getText());
            ListaDepartamento.add(D);
        }else if(modoDepartamento.equals("Editar")){
            int index = tabelaDepartamentos.getSelectedRow();
            ListaDepartamento.get(index).setCodigo(cod);
            ListaDepartamento.get(index).setNome(nomeDepartamento.getText());
        }
        LoadTableDepartamento();
        modoDepartamento = "Iniciar";
        interfaceDepartamento();
        codigoDepartamento.setText("");
        nomeDepartamento.setText("");
    }//GEN-LAST:event_btnDepartamentoSalvarActionPerformed

    private void tabelaDepartamentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaDepartamentosMouseClicked
        int index = tabelaDepartamentos.getSelectedRow();
        if(index>=0 && index<ListaDepartamento.size()){
            Departamento D = ListaDepartamento.get(index);
            codigoDepartamento.setText(String.valueOf(D.getCodigo()));
            nomeDepartamento.setText(D.getNome());
            modoDepartamento = "Selecao";
            interfaceDepartamento();
        }
    }//GEN-LAST:event_tabelaDepartamentosMouseClicked

    private void btnDepartamentoEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDepartamentoEditarActionPerformed
        modoDepartamento = "Editar";
        interfaceDepartamento();
    }//GEN-LAST:event_btnDepartamentoEditarActionPerformed

    private void btnDepartamentoExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDepartamentoExcluirActionPerformed
        int index = tabelaDepartamentos.getSelectedRow();
        if(index>=0 && index<ListaDepartamento.size()){
            ListaDepartamento.remove(index);
        }
        LoadTableDepartamento();
        modoDepartamento = "Iniciar";
        interfaceDepartamento();
    }//GEN-LAST:event_btnDepartamentoExcluirActionPerformed

    private void btnFuncionarioEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFuncionarioEditarActionPerformed
        modoFuncionario = "Editar";
        interfaceFuncionario();
    }//GEN-LAST:event_btnFuncionarioEditarActionPerformed

    private void tabelaFuncionariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaFuncionariosMouseClicked
        int index = tabelaFuncionarios.getSelectedRow();
        if(index>=0 && index<ListaFuncionario.size()){
            Funcionario F = ListaFuncionario.get(index);
            matriculaFuncionario.setText(String.valueOf(F.getMatricula()));
            nomeFuncionario.setText(F.getNome());
            modoFuncionario = "Selecao";
            interfaceFuncionario();
        }
    }//GEN-LAST:event_tabelaFuncionariosMouseClicked

    private void btnFuncionarioExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFuncionarioExcluirActionPerformed
        modoFuncionario = "Iniciar";
        interfaceFuncionario();
    }//GEN-LAST:event_btnFuncionarioExcluirActionPerformed

    private void btnFuncionarioSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFuncionarioSalvarActionPerformed
        int index = departamentoFuncionario.getSelectedIndex();
        if(index==0){
            JOptionPane.showMessageDialog(this,"Você deve selecionar um departamento");
        }else{
            Funcionario F = new Funcionario();
            F.setMatricula(Integer.parseInt(matriculaFuncionario.getText()));
            F.setNome(nomeFuncionario.getText());
            F.setDepartamento(ListaDepartamento.get(index-1));
            ListaFuncionario.add(F);
            ListaDepartamento.get(index-1).addFuncionario(F);
        }
        LoadTableFuncionario();
        modoFuncionario = "Iniciar";
        interfaceFuncionario();
    }//GEN-LAST:event_btnFuncionarioSalvarActionPerformed

    private void btnFuncionarioCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFuncionarioCancelarActionPerformed
        modoFuncionario = "Iniciar";
        interfaceFuncionario();
    }//GEN-LAST:event_btnFuncionarioCancelarActionPerformed

    private void btnFuncionarioNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFuncionarioNovoActionPerformed
        modoFuncionario = "Novo";
        interfaceFuncionario();
    }//GEN-LAST:event_btnFuncionarioNovoActionPerformed

    private void btnTarefasEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTarefasEditarActionPerformed
        modoTarefas = "Editar";
        interfaceTarefas();
    }//GEN-LAST:event_btnTarefasEditarActionPerformed

    private void tabelaTarefasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaTarefasMouseClicked
        int index = tabelaTarefas.getSelectedRow();
        if(index>=0 && index<ListaTarefas.size()){
            Tarefas T = ListaTarefas.get(index);
            ID.setText(String.valueOf(T.getID()));
            nomeTitulo.setText(T.getnomeTitulo());
            modoTarefas = "Selecao";
            interfaceFuncionario();
        }    
    }//GEN-LAST:event_tabelaTarefasMouseClicked

    private void btnTarefasExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTarefasExcluirActionPerformed
        int index = tabelaTarefas.getSelectedRow();
        if(index>=0 && index<ListaTarefas.size()){
            ListaTarefas.remove(index);
        }
        LoadTableTarefas();
        modoTarefas = "Excluir";
        interfaceTarefas();
    }//GEN-LAST:event_btnTarefasExcluirActionPerformed

    private void btnTarefasSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTarefasSalvarActionPerformed
        
        int index = pessoas.getSelectedIndex();
        if(index==0){
            JOptionPane.showMessageDialog(this,"Você deve selecionar um funcionario");
        }else{
            Funcionario F = new Funcionario();
            F.setMatricula(Integer.parseInt(matriculaFuncionario.getText()));
            F.setNome(nomeFuncionario.getText());
            F.setDepartamento(ListaDepartamento.get(index-1));
            ListaFuncionario.add(F);
            ListaDepartamento.get(index-1).addFuncionario(F);
        }
        LoadTableTarefas();
        modoTarefas = "Iniciar";
        interfaceTarefas();
    }//GEN-LAST:event_btnTarefasSalvarActionPerformed

    private void btnTarefasCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTarefasCancelarActionPerformed
        modoTarefas = "Iniciar";
        interfaceTarefas();
    }//GEN-LAST:event_btnTarefasCancelarActionPerformed

    private void btnTarefasNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTarefasNovoActionPerformed
        modoTarefas = "Novo";
        interfaceTarefas();
    }//GEN-LAST:event_btnTarefasNovoActionPerformed

    private void pessoasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pessoasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pessoasActionPerformed

    private void departamentoFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_departamentoFuncionarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_departamentoFuncionarioActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Codigo;
    private javax.swing.JLabel Descricao;
    private javax.swing.JTextField ID;
    private javax.swing.JLabel Prazo;
    private javax.swing.JButton btnDepartamentoCancelar;
    private javax.swing.JButton btnDepartamentoEditar;
    private javax.swing.JButton btnDepartamentoExcluir;
    private javax.swing.JButton btnDepartamentoNovo;
    private javax.swing.JButton btnDepartamentoSalvar;
    private javax.swing.JButton btnFuncionarioCancelar;
    private javax.swing.JButton btnFuncionarioEditar;
    private javax.swing.JButton btnFuncionarioExcluir;
    private javax.swing.JButton btnFuncionarioNovo;
    private javax.swing.JButton btnFuncionarioSalvar;
    private javax.swing.JButton btnTarefasCancelar;
    private javax.swing.JButton btnTarefasEditar;
    private javax.swing.JButton btnTarefasExcluir;
    private javax.swing.JButton btnTarefasNovo;
    private javax.swing.JButton btnTarefasSalvar;
    private javax.swing.JTextField codigoDepartamento;
    private javax.swing.JComboBox departamentoFuncionario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField matriculaFuncionario;
    private javax.swing.JTextField nomeDepartamento;
    private javax.swing.JTextField nomeDescricao;
    private javax.swing.JTextField nomeDuracao;
    private javax.swing.JTextField nomeFinalizado;
    private javax.swing.JTextField nomeFuncionario;
    private javax.swing.JTextField nomePrazo;
    private javax.swing.JTextField nomeTitulo;
    private javax.swing.JComboBox pessoas;
    private javax.swing.JTable tabelaDepartamentos;
    private javax.swing.JTable tabelaFuncionarios;
    private javax.swing.JTable tabelaTarefas;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}



