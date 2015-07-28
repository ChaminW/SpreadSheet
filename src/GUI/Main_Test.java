package GUI;


import com.jtattoo.plaf.hifi.HiFiLookAndFeel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;



public class Main_Test {
    public static void main(String[] args) {
      
        try {
            UIManager.setLookAndFeel(new HiFiLookAndFeel());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Main_Test.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // set loading GUI set visible
        new Loading().setVisible(true);
        
         
    }
    
    
}
