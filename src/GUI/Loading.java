
package GUI;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JRootPane;
import javax.swing.Timer;


public class Loading extends javax.swing.JFrame {
    // class for the loading GUI
    
    private final Timer t;

    public Loading() {
        // constructor of the claaa
        
        initComponents();
        
        //set the initial position to midle of the destop
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getWidth()/2, dim.height/2-this.getHeight()/2);
        try{
        this.setIconImage(new ImageIcon(getClass().getResource("main.png")).getImage());
        }
        catch (Exception e){
            //do nothing. default icon will set
        }
       
        //using timer to keep loading view
        t = new Timer(100, new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                progressBar.setVisible(false);
                                progressBar.setValue(progressBar.getValue() + 2);

                                if (progressBar.getValue() == 100) {
                                    Loading.this.setVisible(false);
                                    Form form = new Form();  //load main jframe
                                    form.setVisible(true);
                                    t.stop();
                                   
                                }  
                            }
                        });
        t.start();//strat timer

                      
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblLoading = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Spread Sheet");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(0, 204, 204));
        setLocationByPlatform(true);
        setModalExclusionType(null);
        setUndecorated(true);
        setResizable(false);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Chamin\\Desktop\\Sem_Proj\\LIB\\cool-loading-animated-gif-1.gif")); // NOI18N

        lblLoading.setBackground(new java.awt.Color(0, 255, 255));
        lblLoading.setFont(new java.awt.Font("FangSong", 1, 12)); // NOI18N
        lblLoading.setForeground(new java.awt.Color(0, 255, 255));
        lblLoading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLoading.setText("Loading");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(207, 207, 207)
                        .addComponent(lblLoading, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(progressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblLoading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
      
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblLoading;
    private javax.swing.JProgressBar progressBar;
    // End of variables declaration//GEN-END:variables
}
