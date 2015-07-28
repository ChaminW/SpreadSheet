
package GUI;
//import sem_proj.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import java.io.File;
import java.io.IOException;

import java.util.Date;

import javax.swing.DefaultCellEditor;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.*;
import javax.swing.text.BadLocationException;
import Spread_Sheet.DTseparater;
import Spread_Sheet.IO;
import Spread_Sheet.cell;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Form extends javax.swing.JFrame {

    /**
     *
     */
    public Form() {
        // constructor of the GUI form
        
        initComponents();
        
        //setting the intial form size
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(dim.width, dim.height);
        // setting the application icon
        try{
        this.setIconImage(new ImageIcon(getClass().getResource("main.png")).getImage());
        }
        catch (Exception e){
            //do nothing. default icon will set
        }
       
        // set a method to the default exit button window lisntner
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                this.addWindowListener( new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent we) {
                        exit();// call exit method
                    }
                } );
        
        // run a thread to clear the status bar
        Thread threadSB  = new Thread(){
            @Override
            public void run(){
                while(true){
                    try {
                        statusPane.setText("");
                        //let thread sleep
                        Thread.sleep(3000);
                    } catch (InterruptedException ex) {
                        statusBarUpdater("Interrupted to status bar updating thread ");
                    }
                }
            }
        };
        threadSB.start();
        
        // thread for auto saving process
        Thread threadAS;
        threadAS = new Thread(){
            private Timer t;
            @Override
            public void run(){
                while(true){
                    
                    try {
                        statusBarUpdater("Auto saving mode run ");
                        //using  timer to action of progress bar
                        t = new Timer(100, new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                boolean added = false;
                                progressBar.setValue(progressBar.getValue() + 5);
                                if (progressBar.getValue() == 10) {
                                    statusPane.setText("Saving");
                                }
                                
                                if (progressBar.getValue() == 100) {
                                    // call auto save method
                                    autoSave();
                                    String time =new Date().toString();
                                    lblBackupTime.setText(time.substring(4, 11)+" -  "+time.substring(12, 20));
                                    
                                    added=true;
                                    if (added) {
                                        statusPane.setText("Saved Completely");
                                        t.stop();
                                        progressBar.setValue(0);
                                    }
                                }else{
                                    
                                }
                                
                            }
                        });

                        t.start();
                        // let thread to sleep some time  
                        Thread.sleep(90000);
                        
                    } catch (InterruptedException ex) {
                        statusBarUpdater("Interrupted to the auto saving thread ");
                    }
                    
                    
                }
            }
        };
        threadAS.start();
        
        // implementation for real time update the formula text field using document listener
        
        ((JTextField) ((DefaultCellEditor) table.getDefaultEditor(Object.class)).getComponent()).getDocument().addDocumentListener(
        new DocumentListener() {

        @Override
        public void insertUpdate(DocumentEvent de) {
            try {
                txtForm.setText(de.getDocument().getText(0, de.getDocument().getLength()));
            } 
            catch (BadLocationException ex) {
                //do nothing
            }
        }

        @Override
        public void removeUpdate(DocumentEvent de) {
            try {
                txtForm.setText(de.getDocument().getText(0, de.getDocument().getLength()));
            }
            catch (BadLocationException ex) {
               //do nothing
            }
        }

        @Override
        public void changedUpdate(DocumentEvent de) {
            try {
                txtForm.setText(de.getDocument().getText(0, de.getDocument().getLength()));
            } 
            catch (BadLocationException ex) {
            //do nothing
            }
        }

        }
        );
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtForm = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        rows = new javax.swing.JTable();
        txtDT = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnClearAll = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        statusPane = new javax.swing.JEditorPane();
        progressBar = new javax.swing.JProgressBar();
        jLabel4 = new javax.swing.JLabel();
        btnClearAll1 = new javax.swing.JButton();
        btnClearAll2 = new javax.swing.JButton();
        btnBackup = new javax.swing.JButton();
        lblBackupTime = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        itmNew = new javax.swing.JMenuItem();
        itmOpen = new javax.swing.JMenuItem();
        itmSave = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        itmExit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        itmCopy = new javax.swing.JMenuItem();
        itmCut = new javax.swing.JMenuItem();
        itmPaste = new javax.swing.JMenuItem();
        itmDelete = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        itnAbout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Spread Sheet");
        setIconImages(null);
        setUndecorated(true);

        txtForm.setEditable(false);
        txtForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFormActionPerformed(evt);
            }
        });

        jLabel1.setText("Formula");

        txtAddress.setToolTipText("Enter Cell Address as \"A13\"");
        txtAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddressActionPerformed(evt);
            }
        });
        txtAddress.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAddressKeyPressed(evt);
            }
        });

        jLabel2.setText("Cell Address");

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);

        jScrollPane1.setVerticalScrollBar(jScrollPane2.getVerticalScrollBar());

        table.setForeground(new java.awt.Color(0, 0, 0));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        table.setAlignmentX(1.0F);
        table.setAlignmentY(1.0F);
        table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        table.setAutoscrolls(false);
        table.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        table.setName(""); // NOI18N
        table.setSelectionBackground(new java.awt.Color(255, 255, 153));
        table.setSelectionForeground(new java.awt.Color(204, 204, 255));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        table.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tableKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tableKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tableKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        rows.setBorder(jLabel1.getBorder());
        rows.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1"},
                {"2"},
                {"3"},
                {"4"},
                {"5"},
                {"6"},
                {"7"},
                {"8"},
                {"9"},
                {"10"},
                {"11"},
                {"12"},
                {"13"},
                {"14"},
                {"15"},
                {"16"},
                {"17"},
                {"18"},
                {"19"},
                {"20"},
                {"21"},
                {"22"},
                {"23"},
                {"24"},
                {"25"},
                {"26"},
                {"27"},
                {"28"},
                {"29"},
                {"30"},
                {"31"},
                {"32"},
                {"33"},
                {"34"},
                {"35"},
                {"36"},
                {"37"},
                {"38"},
                {"39"},
                {"40"}
            },
            new String [] {
                " "
            }
        ));
        rows.setAlignmentX(1.0F);
        rows.setAlignmentY(1.0F);
        rows.setAutoscrolls(false);
        rows.setEnabled(false);
        rows.setFocusable(false);
        rows.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(rows);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 847, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Sheet 1", jPanel1);

        txtDT.setEditable(false);
        txtDT.setToolTipText("");
        txtDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDTActionPerformed(evt);
            }
        });
        txtDT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDTKeyPressed(evt);
            }
        });

        jLabel3.setText("Data Type");

        btnClearAll.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        btnClearAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Trash-Can1-01.png"))); // NOI18N
        btnClearAll.setText("Clear All");
        btnClearAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearAllActionPerformed(evt);
            }
        });

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setToolTipText("Status Bar");
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        statusPane.setEditable(false);
        statusPane.setFont(new java.awt.Font("Dialog", 1, 8)); // NOI18N
        statusPane.setForeground(new java.awt.Color(153, 153, 153));
        jScrollPane3.setViewportView(statusPane);

        progressBar.setForeground(new java.awt.Color(204, 255, 0));

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 8)); // NOI18N
        jLabel4.setText("Auto saving progress");

        btnClearAll1.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        btnClearAll1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Document1-01.png"))); // NOI18N
        btnClearAll1.setText("Save");
        btnClearAll1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnClearAll1.setMaximumSize(new java.awt.Dimension(110, 35));
        btnClearAll1.setMinimumSize(new java.awt.Dimension(110, 35));
        btnClearAll1.setPreferredSize(new java.awt.Dimension(110, 35));
        btnClearAll1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearAll1ActionPerformed(evt);
            }
        });

        btnClearAll2.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        btnClearAll2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Plus1.png"))); // NOI18N
        btnClearAll2.setText("New");
        btnClearAll2.setIconTextGap(2);
        btnClearAll2.setMaximumSize(new java.awt.Dimension(110, 35));
        btnClearAll2.setMinimumSize(new java.awt.Dimension(110, 35));
        btnClearAll2.setPreferredSize(new java.awt.Dimension(110, 35));
        btnClearAll2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearAll2ActionPerformed(evt);
            }
        });

        btnBackup.setFont(new java.awt.Font("Dialog", 1, 8)); // NOI18N
        btnBackup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/loading2.gif"))); // NOI18N
        btnBackup.setText("Back Up Temp");
        btnBackup.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Untitled-1.gif"))); // NOI18N
        btnBackup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackupActionPerformed(evt);
            }
        });

        lblBackupTime.setFont(new java.awt.Font("Dialog", 0, 8)); // NOI18N
        lblBackupTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBackupTime.setText(" ");

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/copy.png"))); // NOI18N
        jButton3.setToolTipText("Copy");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Cut.png"))); // NOI18N
        jButton1.setToolTipText("Cut");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/past.png"))); // NOI18N
        jButton2.setToolTipText("Past");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/delete.png"))); // NOI18N
        jButton4.setToolTipText("Past");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4)
                    .addComponent(jButton2)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenu1.setText("File");

        itmNew.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        itmNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Plus1.png"))); // NOI18N
        itmNew.setText("New");
        itmNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmNewActionPerformed(evt);
            }
        });
        jMenu1.add(itmNew);

        itmOpen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        itmOpen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Folder1.png"))); // NOI18N
        itmOpen.setText("Open");
        itmOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmOpenActionPerformed(evt);
            }
        });
        jMenu1.add(itmOpen);

        itmSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        itmSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Document1-01.png"))); // NOI18N
        itmSave.setText("Save");
        itmSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmSaveActionPerformed(evt);
            }
        });
        jMenu1.add(itmSave);
        jMenu1.add(jSeparator1);

        itmExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        itmExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Close1.png"))); // NOI18N
        itmExit.setText("Exit");
        itmExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmExitActionPerformed(evt);
            }
        });
        jMenu1.add(itmExit);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        itmCopy.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        itmCopy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/copy.png"))); // NOI18N
        itmCopy.setText("Copy");
        itmCopy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmCopyActionPerformed(evt);
            }
        });
        jMenu2.add(itmCopy);

        itmCut.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        itmCut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Cut.png"))); // NOI18N
        itmCut.setText("Cut");
        itmCut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmCutActionPerformed(evt);
            }
        });
        jMenu2.add(itmCut);

        itmPaste.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        itmPaste.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/past.png"))); // NOI18N
        itmPaste.setText("Paste");
        itmPaste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmPasteActionPerformed(evt);
            }
        });
        jMenu2.add(itmPaste);

        itmDelete.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        itmDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/delete.png"))); // NOI18N
        itmDelete.setText("Delete");
        itmDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmDeleteActionPerformed(evt);
            }
        });
        jMenu2.add(itmDelete);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Help");

        itnAbout.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        itnAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Person1-01.png"))); // NOI18N
        itnAbout.setText("About");
        itnAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itnAboutActionPerformed(evt);
            }
        });
        jMenu3.add(itnAbout);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtForm)
                        .addGap(22, 22, 22))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDT, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                            .addComponent(txtAddress))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(btnClearAll1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClearAll2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnClearAll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBackup))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblBackupTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(progressBar, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(47, 47, 47))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)))
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnClearAll, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnClearAll2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnClearAll1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBackup, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBackupTime, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(progressBar, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    // create a 2D array included cell objects
    cell cellArr[][] = new cell[40][26];
    // create and initialse the cell object to clip board uses 
    cell clipBoardCell =null;
    
    
    private void txtFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFormActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFormActionPerformed

    private void itmOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmOpenActionPerformed
        // action of open
        
        int dialogResult = JOptionPane.showConfirmDialog (null, "Would You Like to Save your Previous Sheet before open a file?","Warning",JOptionPane.YES_NO_CANCEL_OPTION);
        if(dialogResult == JOptionPane.YES_OPTION){
            itmSave.doClick();
            //used a file chooser for choose a open file
            JFileChooser fChooser =new JFileChooser("c:/");
            fChooser.addChoosableFileFilter(new FileNameExtensionFilter("Spread Sheet Type","spd"));
            int returnVal = fChooser.showOpenDialog(null);
            if(returnVal == JFileChooser.APPROVE_OPTION){
                File openfile = fChooser.getSelectedFile();
                //got the file path for opening
                String Ofile =openfile+"";
                statusBarUpdater("File saving in path of "+ Ofile);
                try {
                    // call ftile load static method for deserialize
                    cellArr=IO.fileLoad(table.getRowCount(),  table.getColumnCount(),Ofile);
                    statusBarUpdater("File loded successfully ");
                } catch (IOException eio) {
                    JOptionPane.showMessageDialog(null,"File couldn't load! Ther is problem in file input.","Load",JOptionPane.ERROR_MESSAGE);
                } catch (NullPointerException enp) {
                    JOptionPane.showMessageDialog(null,"File couldn't load! there is a problem in saved file.","Load",JOptionPane.ERROR_MESSAGE);
                } catch (ClassNotFoundException ecnf) {
                    JOptionPane.showMessageDialog(null,"File couldn't load! There is no class type such that in file","Load",JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,"File couldn't load!","Load",JOptionPane.ERROR_MESSAGE);
                }
            }
            // call fileLoadder method to update table
            fileLoader(table.getRowCount(), table.getColumnCount());
            
        }
        else if(dialogResult == JOptionPane.NO_OPTION){
            //used a file chooser for choose a open file
            JFileChooser fChooser =new JFileChooser("c:/");
            fChooser.addChoosableFileFilter(new FileNameExtensionFilter("Spread Sheet Type","spd"));
            int returnVal = fChooser.showOpenDialog(null);
            if(returnVal == JFileChooser.APPROVE_OPTION){
                File openfile = fChooser.getSelectedFile();
                //got the file path for opening
                String Ofile =openfile+"";
                statusBarUpdater("File saving in path of "+ Ofile);
                try {
                    // call ftile load static method for deserialize
                    cellArr=IO.fileLoad(table.getRowCount(),  table.getColumnCount(),Ofile);
                    statusBarUpdater("File loded successfully ");
                } catch (IOException eio) {
                    JOptionPane.showMessageDialog(null,"File couldn't load! Ther is problem in file input.","Load",JOptionPane.ERROR_MESSAGE);
                } catch (NullPointerException enp) {
                    JOptionPane.showMessageDialog(null,"File couldn't load! there is a problem in saved file.","Load",JOptionPane.ERROR_MESSAGE);
                } catch (ClassNotFoundException ecnf) {
                    JOptionPane.showMessageDialog(null,"File couldn't load! There is no class type such that in file","Load",JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,"File couldn't load!","Load",JOptionPane.ERROR_MESSAGE);
                }
            }
            // call fileLoadder method to update table
            fileLoader(table.getRowCount(), table.getColumnCount());

        }
       
        
    }//GEN-LAST:event_itmOpenActionPerformed

    private void itmExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmExitActionPerformed
        
       exit();// call exit method
    }//GEN-LAST:event_itmExitActionPerformed

    private void itmSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmSaveActionPerformed
        // action of save
        
        //used a file chooser for choose a save file
        JFileChooser fChooser =new JFileChooser("c:/");
        fChooser.addChoosableFileFilter(new FileNameExtensionFilter("Spread Sheet Type","spd"));
        int returnVal = fChooser.showSaveDialog(this);
        
        if(returnVal == JFileChooser.APPROVE_OPTION){
            File savefile = fChooser.getSelectedFile();
            // got the file path oe saving
            final String Sfile =savefile+".spd";
            
            // run a thread for saving 
            Thread threadSave = new Thread(){
            @Override
            public void run(){
                
                try {
                    //call fileSave method for sserialization
                    IO.fileSave(cellArr,  table.getRowCount(),  table.getColumnCount(),Sfile);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null,"File couldn't save!","Save",JOptionPane.ERROR_MESSAGE);
                }
                
            }
        };
        threadSave.start();
           
        } 
    }//GEN-LAST:event_itmSaveActionPerformed

    private void itmNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmNewActionPerformed
        // action for new document
        // use the clear all method
        
        int dialogResult = JOptionPane.showConfirmDialog (null, "Would You Like to Save your Previous Sheet First?","Warning",JOptionPane.YES_NO_CANCEL_OPTION);
        if(dialogResult == JOptionPane.YES_OPTION){
            itmSave.doClick();
            clear_All();
            this.setVisible(false);
            this.setVisible(true);
        }
        else if(dialogResult == JOptionPane.NO_OPTION){
            clear_All();
            this.setVisible(false);
            this.setVisible(true);
        }
        
    }//GEN-LAST:event_itmNewActionPerformed

    private void txtAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddressActionPerformed

    private void txtAddressKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAddressKeyPressed
        // action when set he address text field
        
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            // action when enter key pressed
            String address = txtAddress.getText();
            
            int column = (int)(address.charAt(0))-65;
            int row;
            switch(address.length()){
                case 2:
                    row = (int)address.charAt(1)-49;
                    break;
                case 3:
                    row = (((int)address.charAt(1)-48)*10) + ((int)address.charAt(2)-49);
                    break;
                default:
                    row=-1;
            }
            if(row > -1 && row < table.getRowCount() && column > -1 && column < table.getColumnCount()){
                //setting focus the cursor to valid cell
                table.requestFocus();
                table.changeSelection(row,column,false, false);
            }
        }
    }//GEN-LAST:event_txtAddressKeyPressed

    private void txtDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDTActionPerformed

    private void txtDTKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDTKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDTKeyPressed

    private void tableKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableKeyTyped

    }//GEN-LAST:event_tableKeyTyped

    private void tableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableKeyReleased
        // call method real time upddater
        realTimeUpdater();

        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            // call cellUpdate method if enter key prssed
            cellUpdate();
        }

        if(evt.getKeyCode()== KeyEvent.VK_UP || evt.getKeyCode()== KeyEvent.VK_LEFT || evt.getKeyCode()== KeyEvent.VK_DOWN || evt.getKeyCode()== KeyEvent.VK_RIGHT ){
            // call cursorMoveUpdater if arrow keys pressed
            cursorMoveUpdater();
        }
    }//GEN-LAST:event_tableKeyReleased

    private void tableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableKeyPressed

    }//GEN-LAST:event_tableKeyPressed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        // call cursorMoveUpdater if mouse click on table
        cursorMoveUpdater();
    }//GEN-LAST:event_tableMouseClicked

    private void btnClearAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearAllActionPerformed
        // action for clear all
        
        int dialogResult = JOptionPane.showConfirmDialog (null, "This will delete your data. Are you sure to do this action ? ","Warning!",JOptionPane.YES_NO_OPTION);
        if(dialogResult == JOptionPane.YES_OPTION){
            
            clear_All();
        }
        
        
    }//GEN-LAST:event_btnClearAllActionPerformed

    private void itmDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmDeleteActionPerformed
        // action for cell delete
        
        int selectedColumn = table.getSelectedColumn();
        int selectedRow = table.getSelectedRow();
        //set null to selected cell
        delete(selectedRow, selectedColumn);
        
    }//GEN-LAST:event_itmDeleteActionPerformed

    private void itmCopyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmCopyActionPerformed
        // action for cell copy
        
        int selectedColumn = table.getSelectedColumn();
        int selectedRow = table.getSelectedRow();
        // call the copy method
        copy(selectedRow, selectedColumn);
        
        
        
    }//GEN-LAST:event_itmCopyActionPerformed

    private void itnAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itnAboutActionPerformed
        // sey visible true about form
        new About().setVisible(true);
        
    }//GEN-LAST:event_itnAboutActionPerformed

    private void itmCutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmCutActionPerformed
        // action for cut
        
        int selectedColumn = table.getSelectedColumn();
        int selectedRow = table.getSelectedRow();
        // call for cut method
        cut(selectedRow, selectedColumn);
    }//GEN-LAST:event_itmCutActionPerformed

    private void btnClearAll1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearAll1ActionPerformed
        itmSave.doClick();
    }//GEN-LAST:event_btnClearAll1ActionPerformed

    private void btnClearAll2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearAll2ActionPerformed
        itmNew.doClick();
    }//GEN-LAST:event_btnClearAll2ActionPerformed

    private void btnBackupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackupActionPerformed
        // action for backup button
        if(!lblBackupTime.getText().equals(" ")){ // check whether is there a backup
            int dialogResult = JOptionPane.showConfirmDialog(null,"Last auto updated time is "+lblBackupTime.getText()+" Do you want to back up tha temporary file? ","Backup",JOptionPane.YES_NO_OPTION);
            if(dialogResult == JOptionPane.YES_OPTION){
                try {
                    // call fileLoad static method using backup file path
                    cellArr=IO.fileLoad(table.getRowCount(),  table.getColumnCount(),"tempFile.tmp");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null,"Backup file couldn't load! Temperory file can't find ","Backup",JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,"Backup file couldn't load! ","Backup",JOptionPane.ERROR_MESSAGE);
                }
                // call fileLoader method
                fileLoader(table.getRowCount(), table.getColumnCount());
            }
        }
        else{
            //give err msg if ther is no backup
            JOptionPane.showMessageDialog(null,"There is no backuped file!","Backup",JOptionPane.ERROR_MESSAGE);    
        }
        
        
    }//GEN-LAST:event_btnBackupActionPerformed

    private void itmPasteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmPasteActionPerformed
        // action for the paste
        
        int selectedColumn = table.getSelectedColumn();
        int selectedRow = table.getSelectedRow();
        //call paste method
        paste(selectedRow, selectedColumn); // call paste method
    }//GEN-LAST:event_itmPasteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        itmCut.doClick();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        itmPaste.doClick();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        itmCopy.doClick();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        itmDelete.doClick();
    }//GEN-LAST:event_jButton4ActionPerformed

   
        
    
    public static void main(String args[]) {
       
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBackup;
    private javax.swing.JButton btnClearAll;
    private javax.swing.JButton btnClearAll1;
    private javax.swing.JButton btnClearAll2;
    private javax.swing.JMenuItem itmCopy;
    private javax.swing.JMenuItem itmCut;
    private javax.swing.JMenuItem itmDelete;
    private javax.swing.JMenuItem itmExit;
    private javax.swing.JMenuItem itmNew;
    private javax.swing.JMenuItem itmOpen;
    private javax.swing.JMenuItem itmPaste;
    private javax.swing.JMenuItem itmSave;
    private javax.swing.JMenuItem itnAbout;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblBackupTime;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JTable rows;
    private javax.swing.JEditorPane statusPane;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtDT;
    private javax.swing.JTextField txtForm;
    // End of variables declaration//GEN-END:variables

    void cellUpdate(){
        // method implementation of cellUpdate
        // this method evaluate and separate the selected cell values
        // then update the cell array , formula bar , datat type bar
        
        statusBarUpdater("Cell Updating");
        int selectedColumn = table.getSelectedColumn();
        int selectedRow = table.getSelectedRow();
       
        String aChar = new Character((char)(selectedColumn+65)).toString();
        aChar += (selectedRow+1) + "";
        txtAddress.setText(aChar);
        
        try{
            if (!"".equals(table.getModel().getValueAt(selectedRow, selectedColumn).toString())){
                String selectedValue = table.getModel().getValueAt(selectedRow, selectedColumn)+"";

                // callig tothe separater method for evaluation and separate process
                DTseparater e1 = new DTseparater();
                e1.separater(selectedValue);

                switch (e1.getCalculatedValue().getDataType()){
                    case "Number":
                        if(e1.getCalculatedValue().getFormulaDT()==null){ // check is ther e a formula in cell
                            txtForm.setText(e1.getCalculatedValue().getNumberDT()+"");
                        }  
                        else{
                            txtForm.setText(e1.getCalculatedValue().getFormulaDT()+"");
                        }
                        cellArr[selectedRow][selectedColumn]=e1.getCalculatedValue();
                        
                        txtDT.setText("Number");
                        table.setValueAt(e1.getCalculatedValue().getNumberDT()+"", selectedRow, selectedColumn);
                        
                        break;
                    case "Float":
                        if(e1.getCalculatedValue().getFormulaDT()==null){ // check is ther e a formula in cell
                            txtForm.setText(e1.getCalculatedValue().getFloatDT()+"");
                        }  
                        else{
                            txtForm.setText(e1.getCalculatedValue().getFormulaDT()+"");
                        }
                        cellArr[selectedRow][selectedColumn]=e1.getCalculatedValue();
                        
                        txtDT.setText("Float");
                        table.setValueAt(e1.getCalculatedValue().getFloatDT()+"", selectedRow, selectedColumn);
                        
                        break;
                    case "Date":
                        cellArr[selectedRow][selectedColumn]=e1.getCalculatedValue();
                        txtForm.setText(e1.getCalculatedValue().getDateDT()+"");
                        txtDT.setText("Date");
                        table.setValueAt(e1.getCalculatedValue().getDateDT()+"", selectedRow, selectedColumn);
                        
                        break;
                    case "Time":
                        cellArr[selectedRow][selectedColumn]=e1.getCalculatedValue();
                        txtForm.setText(e1.getCalculatedValue().getTimeDT()+"");
                        txtDT.setText("Time");
                        table.setValueAt(e1.getCalculatedValue().getTimeDT()+"", selectedRow, selectedColumn);
                        
                        break;
                    case "Currency":
                        cellArr[selectedRow][selectedColumn]=e1.getCalculatedValue();
                        txtForm.setText(e1.getCalculatedValue().getCurrencyDT()+"");
                        txtDT.setText("Currency");
                        table.setValueAt(e1.getCalculatedValue().getCurrencyDT()+"", selectedRow, selectedColumn);
                        
                        break;
                    case "Text":
                        cellArr[selectedRow][selectedColumn]=e1.getCalculatedValue();
                        txtForm.setText(e1.getCalculatedValue().getTextDT()+"");
                        txtDT.setText("Text");
                        table.setValueAt(e1.getCalculatedValue().getTextDT()+"", selectedRow, selectedColumn);
                        
                        break;
                }
            }
            else{
                // update for the null cell
                cellArr[selectedRow][selectedColumn]=null;
                txtForm.setText("");
                txtDT.setText("");
                
            }
        }
        catch(NullPointerException npe){
            // update for the null cell
            cellArr[selectedRow][selectedColumn]=null;
            txtForm.setText("");
            txtDT.setText("");
            
        }
        
    }     
    
    void realTimeUpdater(){
        // method implementation for realTimeUpdater
        // this method go throug the whole table and update cells with evaluation
        // run a thread  to do updating
        Thread threadRTU =new Thread(){
            @Override
            public void run(){
        
                statusBarUpdater("Real time updating");
                int rowCount = table.getRowCount();
                int columnCount = table.getColumnCount(); 
                // go through the table using 2 for loops
                for (int selectedRow = 0 ; selectedRow < rowCount; selectedRow++){
                        for(int selectedColumn = 0 ; selectedColumn < columnCount;selectedColumn++){
                            
                            try{
                                if (!"".equals(table.getModel().getValueAt(selectedRow, selectedColumn).toString())){
                                    String selectedValue = null;
                                    try {
                                        try {
                                            
                                            if((table.getModel().getValueAt(selectedRow, selectedColumn)+"").equals(cellArr[selectedRow][selectedColumn].getNumberDT()+"") )
                                                // when cell is not updated
                                                selectedValue=cellArr[selectedRow][selectedColumn].getFormulaDT();
                                            else{
                                                // when cell is updated
                                                selectedValue= table.getModel().getValueAt(selectedRow, selectedColumn)+"";
                                            }
                                        } 
                                        catch (NullPointerException enp) {
                                            if((table.getModel().getValueAt(selectedRow, selectedColumn)+"").equals(cellArr[selectedRow][selectedColumn].getFloatDT()+"") )
                                                selectedValue=cellArr[selectedRow][selectedColumn].getFormulaDT();
                                            else{
                                                selectedValue= table.getModel().getValueAt(selectedRow, selectedColumn)+"";
                                            }
                                        }                                     
                                    } 
                                    catch (NullPointerException enp) {
                                        
                                        selectedValue= table.getModel().getValueAt(selectedRow, selectedColumn)+"";
                                        
                                    }
                                    
                                    DTseparater e1 = new DTseparater();
                                    e1.separater(selectedValue);

                                    switch (e1.getCalculatedValue().getDataType()){
                                        case "Number":
                                            cellArr[selectedRow][selectedColumn]=e1.getCalculatedValue();

                                            table.setValueAt(e1.getCalculatedValue().getNumberDT()+"", selectedRow, selectedColumn);
                                            //System.out.println(e1.getCalculatedValue().getNumberDT()+"");
                                            break;
                                        case "Float":
                                            cellArr[selectedRow][selectedColumn]=e1.getCalculatedValue();

                                            table.setValueAt(e1.getCalculatedValue().getFloatDT()+"", selectedRow, selectedColumn);
                                            //System.out.println(e1.getCalculatedValue().getFloatDT()+"");
                                            break;
                                        case "Date":
                                            cellArr[selectedRow][selectedColumn]=e1.getCalculatedValue();

                                            table.setValueAt(e1.getCalculatedValue().getDateDT()+"", selectedRow, selectedColumn);
                                            //System.out.println(e1.getCalculatedValue().getFloatDT()+"");
                                            break;
                                        case "Time":
                                            cellArr[selectedRow][selectedColumn]=e1.getCalculatedValue();

                                            table.setValueAt(e1.getCalculatedValue().getTimeDT()+"", selectedRow, selectedColumn);
                                            //System.out.println(e1.getCalculatedValue().getFloatDT()+"");
                                            break;
                                        case "Currency":
                                            cellArr[selectedRow][selectedColumn]=e1.getCalculatedValue();

                                            table.setValueAt(e1.getCalculatedValue().getCurrencyDT()+"", selectedRow, selectedColumn);
                                            //System.out.println(e1.getCalculatedValue().getFloatDT()+"");
                                            break;
                                        case "Text":
                                            cellArr[selectedRow][selectedColumn]=e1.getCalculatedValue();

                                            table.setValueAt(e1.getCalculatedValue().getTextDT()+"", selectedRow, selectedColumn);
                                            //System.out.println(e1.getCalculatedValue().getFloatDT()+"");
                                            break;
                                    }
                                }
                                else{
                                    cellArr[selectedRow][selectedColumn]=null;

                                }
                            }
                            catch(NullPointerException npe){
                                cellArr[selectedRow][selectedColumn]=null;
                                
                                
                            }

                        }
                }
            }
        };
        threadRTU.start();
        
    } 
    void cursorMoveUpdater(){
        // method implementation of cursorMoveUpdater 
        // this method update the address bar  and datat type bar
        // and update selected table cell using cell 2d array. no evaluation or separation
        
        statusBarUpdater("Cursor move updater running");
        int selectedColumn = table.getSelectedColumn();
        int selectedRow = table.getSelectedRow();
        
        // update the address bar
        String aChar = new Character((char)(selectedColumn+65)).toString();
        aChar += (selectedRow+1) + "";
        txtAddress.setText(aChar);
        
        try{

            switch (cellArr[selectedRow][selectedColumn].getDataType()){
                 case "Number":
                    if(cellArr[selectedRow][selectedColumn].getFormulaDT()==null){
                        txtForm.setText(cellArr[selectedRow][selectedColumn].getNumberDT()+"");
                    }  
                    else{
                        txtForm.setText(cellArr[selectedRow][selectedColumn].getFormulaDT()+"");
                    }
                    table.setValueAt(cellArr[selectedRow][selectedColumn].getNumberDT()+"", selectedRow, selectedColumn);
                    txtDT.setText("Number");
                    
                     break;
                 case "Float":
                    if(cellArr[selectedRow][selectedColumn].getFormulaDT()==null){
                        txtForm.setText(cellArr[selectedRow][selectedColumn].getFloatDT()+"");
                    }  
                    else{
                        txtForm.setText(cellArr[selectedRow][selectedColumn].getFormulaDT()+"");
                    }
                    
                    table.setValueAt(cellArr[selectedRow][selectedColumn].getFloatDT()+"", selectedRow, selectedColumn);
                    txtDT.setText("Float");
                    
                    break;
                 case "Date":
                    txtForm.setText(cellArr[selectedRow][selectedColumn].getDateDT()+"");
                    table.setValueAt(cellArr[selectedRow][selectedColumn].getDateDT()+"", selectedRow, selectedColumn);
                    txtDT.setText("Date");
                    
                     break;
                 case "Time":
                    txtForm.setText(cellArr[selectedRow][selectedColumn].getTimeDT()+"");
                    table.setValueAt(cellArr[selectedRow][selectedColumn].getTimeDT()+"", selectedRow, selectedColumn);
                    txtDT.setText("Time");
                    
                     break;
                 case "Currency":
                    txtForm.setText(cellArr[selectedRow][selectedColumn].getCurrencyDT()+"");
                     table.setValueAt(cellArr[selectedRow][selectedColumn].getCurrencyDT()+"", selectedRow, selectedColumn);
                     txtDT.setText("Currency");
                    
                     break;
                case "Text":
                    txtForm.setText(cellArr[selectedRow][selectedColumn].getTextDT()+"");
                    table.setValueAt(cellArr[selectedRow][selectedColumn].getTextDT()+"", selectedRow, selectedColumn);
                    txtDT.setText("Text");
                     
                    break;
            }
        }
        catch(NullPointerException e1){
            // update when cell is null
            txtDT.setText("");
            txtForm.setText("");
        }
        
            
                
        
    }
    
    void fileLoader(int rowCount,int columnCount){
        // method implementation of fileLoder
        // this method go through the 2 loops and update the table using cell 2D array
        // just set the table value
        
        statusBarUpdater("File loader running");
        
        for (int selectedRow = 0 ; selectedRow < rowCount; selectedRow++){
            for(int selectedColumn = 0 ; selectedColumn < columnCount;selectedColumn++){
                try {
                    switch (cellArr[selectedRow][selectedColumn].getDataType()){
                        case "Number":

                           table.setValueAt(cellArr[selectedRow][selectedColumn].getNumberDT()+"", selectedRow, selectedColumn);
                       
                            break;
                        case "Float":
                           
                           table.setValueAt(cellArr[selectedRow][selectedColumn].getFloatDT()+"", selectedRow, selectedColumn);
                           
                            break;
                        case "Date":
                          
                            table.setValueAt(cellArr[selectedRow][selectedColumn].getDateDT()+"", selectedRow, selectedColumn);

                            break;
                        case "Time":
                           
                            table.setValueAt(cellArr[selectedRow][selectedColumn].getTimeDT()+"", selectedRow, selectedColumn);
                           
                            break;
                        case "Currency":
                           
                            table.setValueAt(cellArr[selectedRow][selectedColumn].getCurrencyDT()+"", selectedRow, selectedColumn);
                           
                            break;
                        case "Text":
                            
                            table.setValueAt(cellArr[selectedRow][selectedColumn].getTextDT()+"", selectedRow, selectedColumn);
                           
                            break;
                    }
                } catch (NullPointerException npe) {
                        table.setValueAt("", selectedRow, selectedColumn);  
                }
                   
            }
        }
        statusBarUpdater("File loaded successfully"); //status updating
    }
    
    void  exit(){
        // method of exit
        // exit the app safely. ask question before exit the window .
        // can select save
        
        int dialogResult = JOptionPane.showConfirmDialog (null, "Would You Like to Save your Previous Sheet First?","Warning",JOptionPane.YES_NO_CANCEL_OPTION);
        if(dialogResult == JOptionPane.YES_OPTION){
            itmSave.doClick();
        }
        else if(dialogResult == JOptionPane.NO_OPTION){
            System.exit(0);
        }
        
    }
    void copy(int selectedRow,int selectedColumn){
        // method of copy
        // it copy the cell object to the clip board cell reference
        
        try { // check whether a cell is selected to do action
            clipBoardCell =cellArr[selectedRow][selectedColumn];
            statusBarUpdater("Cell is copied to clipboard");
        } catch (ArrayIndexOutOfBoundsException e) {
            statusBarUpdater("Select a cell to do COPY action");
        }
    }
    
    void cut(int selectedRow,int selectedColumn){
        // method of cut
        // it copy the cell object to the clip board cell reference and delete the selected reference
        
        try { // check whether a cell is selected to do action
            clipBoardCell =cellArr[selectedRow][selectedColumn];
            cellArr[selectedRow][selectedColumn]=null;
            table.setValueAt("", selectedRow, selectedColumn);
            statusBarUpdater("Cell is CUT to clipboard");
        } catch (ArrayIndexOutOfBoundsException e) {
            statusBarUpdater("Select a cell to do CUT action");
        }
    }
    void paste(int selectedRow,int selectedColumn){
        // method of paste
        // it copy the object in clip board to the selected cell
        // and update the selected table value from object
        
        if (clipBoardCell!=null){
            try {
                cellArr[selectedRow][selectedColumn]=clipBoardCell;
            } catch (ArrayIndexOutOfBoundsException e) {
                statusBarUpdater("Select a cell to do PASTE action");
            }
   
            try {
                switch (cellArr[selectedRow][selectedColumn].getDataType()){
                    case "Number":

                        table.setValueAt(cellArr[selectedRow][selectedColumn].getNumberDT()+"", selectedRow, selectedColumn);            
                        break;
                    case "Float":

                        table.setValueAt(cellArr[selectedRow][selectedColumn].getFloatDT()+"", selectedRow, selectedColumn);
                       break;
                    case "Date":

                        table.setValueAt(cellArr[selectedRow][selectedColumn].getDateDT()+"", selectedRow, selectedColumn);
                        break;
                    case "Time":

                        table.setValueAt(cellArr[selectedRow][selectedColumn].getTimeDT()+"", selectedRow, selectedColumn);
                        break;
                    case "Currency":

                        table.setValueAt(cellArr[selectedRow][selectedColumn].getCurrencyDT()+"", selectedRow, selectedColumn);
                        break;
                    case "Text":

                        table.setValueAt(cellArr[selectedRow][selectedColumn].getTextDT()+"", selectedRow, selectedColumn);
                        break;
                }
            } catch (NullPointerException npe) {
                    table.setValueAt("", selectedRow, selectedColumn);  
            }
        }
        else{
            statusBarUpdater("There is no object to COPY");
        }
        
        
    }
    void delete(int selectedRow,int selectedColumn){
        try {
            cellArr[selectedRow][selectedColumn]=null;
            table.setValueAt("", selectedRow, selectedColumn);
            
        } catch (ArrayIndexOutOfBoundsException e) {
            statusBarUpdater("Select a cell to do DELETE action");
        }
        
    }
   
    void clear_All (){
        // method for clear the table
        //in this method fist initialise new object to the cell array 
        // and go through the whole table by 2 loops and update tabe as null
        
        int rowCount = table.getRowCount();
        int columnCount = table.getColumnCount();
        cellArr=new cell[40][40];
        for (int selectedRow = 0 ; selectedRow < rowCount; selectedRow++){
            for(int selectedColumn = 0 ; selectedColumn < columnCount;selectedColumn++){
                table.setValueAt("", selectedRow, selectedColumn);  
            }
        }
        realTimeUpdater();
        txtDT.setText("");
        txtForm.setText("");
        statusBarUpdater("Cleared the table");
    }
    
    void autoSave(){
        // method for auto saving
        // save the object using serialization to the temp file
        // use fileSave static method
        
        try {
                IO.fileSave(cellArr,  table.getRowCount(),  table.getColumnCount(),"tempFile.tmp");
            } catch (IOException ex) {
                statusBarUpdater("Auto saving mode has a problem");
            }
        
    }
    
    void statusBarUpdater(String text){
        // Update the status bar for user view
        
        statusPane.setText(text+"   ");
    }


}
