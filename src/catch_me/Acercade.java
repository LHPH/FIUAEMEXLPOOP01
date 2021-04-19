package catch_me;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;

import java.awt.Rectangle;

import javax.swing.JDialog;
import javax.swing.JLabel;

/**Clase Acercade
 * clase que mostrara la informacion del juego Catch Me y de los desarrolladores*/

public class Acercade extends JDialog {
    private JLabel jLabel1 = new JLabel();
    private JLabel jLabel2 = new JLabel();
    private JLabel jLabel3 = new JLabel();
    private JLabel jLabel4 = new JLabel();
    private JLabel jLabel5 = new JLabel();
    private JLabel jLabel6 = new JLabel();
    private JLabel jLabel7 = new JLabel();
    private JLabel jLabel8 = new JLabel();
    private JLabel jLabel9 = new JLabel();
    private JLabel jLabel10 = new JLabel();
    private JLabel jLabel11 = new JLabel();
    private JLabel jLabel12 = new JLabel();
    private JLabel jLabel13 = new JLabel();

    public Acercade() {
        this(null, "", false);
    }

    public Acercade(Frame parent, String title, boolean modal) {
        super(parent, title, modal);
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    /**metodo que mostrara la informacion del juego, la version, e informacion de los
     * desarrolladores del juego*/

    private void jbInit() throws Exception {
        this.setSize(new Dimension(468, 413));
        this.getContentPane().setLayout( null );
        this.setTitle("Informacion");
        this.getContentPane().setBackground(new Color(154, 154, 154));
        jLabel1.setText("Catch Me: Juego de Memorama");
        jLabel1.setBounds(new Rectangle(95, 10, 290, 20));
        jLabel1.setFont(new Font("Andalus", 2, 19));
        jLabel2.setText("----------------------------------------------------------------------------------------------------------------------");
        jLabel2.setBounds(new Rectangle(0, 40, 465, 15));
        jLabel2.setFont(new Font("Andalus", 0, 11));
        jLabel3.setText("Catch Me es un Memorama que cuenta con diversos modalidades");
        jLabel3.setBounds(new Rectangle(20, 65, 430, 20));
        jLabel3.setFont(new Font("Andalus", 0, 15));
        jLabel4.setText("como jugar contra la computadora, contra otro usuario, contrareloj");
        jLabel4.setBounds(new Rectangle(20, 90, 435, 25));
        jLabel4.setFont(new Font("Andalus", 0, 15));
        jLabel5.setText(" o personalizar la modalidad de juego, en tres diferentes dificultades");
        jLabel5.setBounds(new Rectangle(20, 120, 440, 20));
        jLabel5.setFont(new Font("Andalus", 0, 15));
        jLabel6.setText("Desarrollado Por:");
        jLabel6.setBounds(new Rectangle(20, 155, 170, 20));
        jLabel6.setFont(new Font("Andalus", 0, 18));
        jLabel7.setText("Luis Humberto Ponce Hermosillo");
        jLabel7.setBounds(new Rectangle(105, 180, 235, 20));
        jLabel7.setFont(new Font("Andalus", 0, 15));
        jLabel8.setText("Luis Ernesto Sierra Alva");
        jLabel8.setBounds(new Rectangle(105, 205, 175, 25));
        jLabel8.setFont(new Font("Andalus", 0, 15));
        jLabel9.setText("Año De Creacion: 2012");
        jLabel9.setBounds(new Rectangle(20, 235, 205, 20));
        jLabel9.setFont(new Font("Andalus", 0, 17));
        jLabel10.setText("Version: 2.0");
        jLabel10.setBounds(new Rectangle(20, 260, 125, 25));
        jLabel10.setFont(new Font("Andalus", 0, 17));
        jLabel11.setText("Contacto:");
        jLabel11.setBounds(new Rectangle(20, 285, 105, 25));
        jLabel11.setFont(new Font("Andalus", 0, 17));
        jLabel12.setText("luislyly@hotmail.com");
        jLabel12.setBounds(new Rectangle(110, 310, 185, 20));
        jLabel12.setFont(new Font("Andalus", 0, 15));
        jLabel13.setText("darkdraco2008@hotmail.com");
        jLabel13.setBounds(new Rectangle(110, 335, 205, 25));
        jLabel13.setFont(new Font("Andalus", 0, 15));
        this.getContentPane().add(jLabel13, null);
        this.getContentPane().add(jLabel12, null);
        this.getContentPane().add(jLabel11, null);
        this.getContentPane().add(jLabel10, null);
        this.getContentPane().add(jLabel9, null);
        this.getContentPane().add(jLabel8, null);
        this.getContentPane().add(jLabel7, null);
        this.getContentPane().add(jLabel6, null);
        this.getContentPane().add(jLabel5, null);
        this.getContentPane().add(jLabel4, null);
        this.getContentPane().add(jLabel3, null);
        this.getContentPane().add(jLabel2, null);
        this.getContentPane().add(jLabel1, null);
    }
}
