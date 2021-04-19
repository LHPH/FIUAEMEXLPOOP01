package catch_me;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**Clase que funciona como pantalla principal del juego */

public class Pantalla_Principal extends JFrame {
    List l = new ArrayList<String>();
    /**Atributos de la clase*/
    private JLabel jLabel = new JLabel();
    private TreeMap tm = new TreeMap();
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
    private JPanel jPanel1 = new JPanel();
    public int fondo=0;
    public boolean aviso=true;

    /**Constructor del Frame*/
    
    public Pantalla_Principal() {
        try {
            jbInit();
            cargar1();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**Metodo que inicializa los componentes graficos del frame*/
    private void jbInit() throws Exception {
        this.getContentPane().setLayout( null );
        this.setSize(new Dimension(698, 351));
        this.getContentPane().setBackground(new Color(61, 204, 95));
        jLabel.setText("Catch Me!!");
        jLabel.setBounds(new Rectangle(240, 0, 225, 55));
        jLabel.setFont(new Font("Comic Sans MS", 2, 40));
        
        jLabel1.setText("Bienvenido");
        jLabel1.setBounds(new Rectangle(300, 55, 205, 30));
        jLabel1.setFont(new Font("Andalus", 0, 21));
        
        jLabel2.setText("1.- Entrar");
        jLabel2.setBounds(new Rectangle(230, 85, 280, 30));
        jLabel2.setFont(new Font("Andalus", 0, 21));

        jLabel2.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    entraryVrC(e);
                }
            });
        
        jLabel3.setText("Pendiente");
        jLabel3.setBounds(new Rectangle(230, 115, 290, 30));
        jLabel3.setFont(new Font("Andalus", 0, 21));
        jLabel3.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    vrsJugador(e);
                }
            });
        
        
        jLabel4.setText("2.- Acerca de...");
        jLabel4.setBounds(new Rectangle(230, 140, 295, 35));
        jLabel4.setFont(new Font("Andalus", 0, 21));
        jLabel4.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    AcercadeyVrsR(e);
                }
            });
        
        


        jLabel6.setText("3.- Salir");
        jLabel6.setBounds(new Rectangle(230, 205, 270, 25));
        jLabel6.setFont(new Font("Andalus", 0, 21));
        jLabel6.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    SalirySF(e);
                }
            });
        
        
        jLabel7.setText("Pendiente");
        jLabel7.setBounds(new Rectangle(230, 240, 355, 25));
        jLabel7.setFont(new Font("Andalus", 0, 21));

        jLabel7.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    regresar(e);
                }
            });
        jLabel8.setText("Seleccione una Opcion");
        jLabel8.setBounds(new Rectangle(115, 270, 205, 30));
        jLabel8.setFont(new Font("Andalus", 0, 21));

        jLabel9.setText("<---  Regresar");
        jLabel9.setBounds(new Rectangle(30, 15, 120, 30));
        jLabel9.setFont(new Font("Andalus", 0, 18));
        jLabel9.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    regrersar(e);
                }
            });
        jLabel9.setVisible(false);
        
        jLabel10.setText("Turno: Jugador 1");
        jLabel10.setBounds(new Rectangle(495, 15, 165, 35));
        jLabel10.setFont(new Font("Andalus", 0, 18));
        jLabel10.setVisible(false);
        jPanel1.setBounds(new Rectangle(15, 55, 665, 265));
        jPanel1.setLayout(null);

        this.getContentPane().add(jLabel5,null);
        this.getContentPane().add(jPanel1, null);
        this.getContentPane().add(jLabel10, null);
        this.getContentPane().add(jLabel9, null);
        this.getContentPane().add(jLabel8, null);
        this.getContentPane().add(jLabel7, null);
        this.getContentPane().add(jLabel6, null);
        this.getContentPane().add(jLabel4, null);
        this.getContentPane().add(jLabel3, null);
        this.getContentPane().add(jLabel2, null);
        this.getContentPane().add(jLabel1, null);
        this.getContentPane().add(jLabel, null);
        jPanel1.setVisible(false);
    }
    
    /**Metodo que muestra en el frame el menu de acceso*/
    
    private void cargar1(){
        this.setTitle("Menu Principal");
        jLabel5.setVisible(false);
        /**Borramos los elementos que se hayan encontrado ingresados*/
        tm.clear();
        /** Coloca elementos del menu en el mapa */
        tm.put(1, "Bienvenido"); 
        tm.put(2, "Entrar" ); 
        tm.put(3, ""); 
        tm.put(4, "Acerca de ..."); 
        tm.put(5, "");
        tm.put(6, "Salir"); 
        tm.put(7, ""); 
        tm.put(8, "Seleccione una Opcion"); 
        /** Se les asigna a las labels*/
        jLabel1.setText((String)tm.get(1));
        jLabel2.setText("1.- "+(String)tm.get(2));
        jLabel3.setText((String)tm.get(3));
        jLabel4.setText("2.- "+(String)tm.get(4));
        jLabel6.setText("3.- "+(String)tm.get(6));
        jLabel7.setText((String)tm.get(7));
        jLabel8.setText((String)tm.get(8));
    }
    
    /** Metodo que muestra el menu principal de la aplicacicon */
    
    private void cargar2(){
        jLabel7.setVisible(true);
        jLabel5.setVisible(true);
        this.setTitle("Menu de Opciones");
        /**Borramos los elementos que habian antes en la coleccion */ 
        tm.clear();
        /** Coloca elementos del menu en el mapa */
        tm.put(1, "Menu de Opciones"); 
        tm.put(2, "Jugar Contra Computadora" ); 
        tm.put(3, "Jugar Contra Jugador"); 
        tm.put(4, "Jugar Contra Reloj"); 
        tm.put(5,"Drag And Drop");
        tm.put(6, "Seleccionar Tema"); 
        tm.put(7, "Regresar al Menu Principal"); 
        tm.put(8, "Seleccione una Opcion"); 
        /** Se les asigna a las labels*/
        jLabel1.setText((String)tm.get(1));
        jLabel2.setText("1.- "+(String)tm.get(2));
        jLabel2.setLocation(235,89);
        jLabel3.setText("2.- "+(String)tm.get(3));
        jLabel3.setLocation(235,119);
        jLabel4.setText("3.- "+(String)tm.get(4));
        jLabel4.setLocation(235,149 );
        jLabel5.setText("4.- "+(String)tm.get(5));
        jLabel5.setBounds(235,180,200,30);
       // jLabel5.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        jLabel5.setFont(new Font("Andalus", 0, 21));
        jLabel5.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    DragDrop();
                }
            });
        
        jLabel6.setText("5.- "+(String)tm.get(6));
        jLabel6.setLocation(235,210 );
        
        jLabel7.setText("6.- "+(String)tm.get(7));
        jLabel7.setLocation(235,240 );
        jLabel8.setText((String)tm.get(8));
        jLabel8.setLocation(235,260 );
    }
    
    public static void main (String args[]){
        Pantalla_Principal pp = new Pantalla_Principal();
        pp.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        pp.setLocationRelativeTo(null);
        pp.setVisible(true);
    }
        
    /**Metodo que despliega la ventana de informacion e Ingresa a la seccion ContraReloj*/
    private void AcercadeyVrsR(MouseEvent e) {
        if(jLabel4.getText().equals("2.- Acerca de ...")){
            Acercade ad = new Acercade();
            ad.setLocationRelativeTo(null);
            ad.setVisible(true);
        }
        else{
            Object seleccion = JOptionPane.showInputDialog(this,"Seleccione una Dificultad","Menu de Opciones",JOptionPane.QUESTION_MESSAGE,null, new Object[] { "Facil", "Media", "Dificil" }, "Facil");
            if(seleccion!=null){
                jLabel5.setVisible(false);
                    if(seleccion.equals("Facil")){
                        ContraRelojG crRG= new ContraRelojG(30,0,jLabel9,fondo);
                        this.setSize(new Dimension(655, 360));
                        this.setLocationRelativeTo(null);
                        this.setTitle("Contra Reloj Dificultad: Facil");
                        jLabel9.setVisible(true);
                        //jLabel10.setVisible(true);
                        jPanel1.removeAll();
                        jPanel1.add(crRG,null);
                        jPanel1.setSize(new Dimension(610, 320));
                        jPanel1.updateUI();
                        jPanel1.setVisible(true);
                    }
                    if(seleccion.equals("Media")){
                        ContraRelojG2 crRG2= new ContraRelojG2(30,1,jLabel9,fondo);
                        this.setSize(new Dimension(750, 490));
                        this.setLocationRelativeTo(null);
                        this.setTitle("Contra Reloj Dificultad: Media");
                        jLabel9.setVisible(true);
                        //jLabel10.setVisible(true);
                        jPanel1.removeAll();
                        jPanel1.add(crRG2,null);
                        jPanel1.setSize(new Dimension(700, 400));
                        jPanel1.updateUI();
                        jPanel1.setVisible(true);
                    }
                if(seleccion.equals("Dificil")){
                    ContraRelojG3 crRG3= new ContraRelojG3(30,2,jLabel9,fondo);
                    this.setSize(new Dimension(870, 570));
                    this.setLocationRelativeTo(null);
                    this.setTitle("Contra Reloj Dificultad: Dificil");
                    jLabel9.setVisible(true);
                    //jLabel10.setVisible(true);
                    jLabel.setLocation(310,1);
                    jPanel1.removeAll();
                    jPanel1.add(crRG3,null);
                    jPanel1.setSize(new Dimension(830, 500));
                    jPanel1.updateUI();
                    jPanel1.setVisible(true);
                    
                }
                if(seleccion==null){
                    jLabel5.setVisible(true);
                }
            }
        }
    }
    
    
    /**Metodo que colocar el menu central de la aplicacion e Ingresa a la seccion Vr Computadora*/
    private void entraryVrC(MouseEvent e) {
        if(jLabel2.getText().equals("1.- Entrar")){
            cargar2();
        }
        else{
            jLabel5.setVisible(false);
            Object seleccion = JOptionPane.showInputDialog(this,"Seleccione una Dificultad","Menu de Opciones",JOptionPane.QUESTION_MESSAGE,null, new Object[] { "Facil", "Media", "Dificil" }, "Facil");
            if(seleccion!=null){
                if(seleccion.equals("Facil")){
                    VrComputadoraG vcg= new VrComputadoraG(fondo);
                    this.setSize(new Dimension(650, 380));
                    this.setLocationRelativeTo(null);
                    this.setTitle("Vrs Computadora Dificultad: Facil");
                    jLabel9.setVisible(true);
                    //jLabel10.setVisible(true);
                    jPanel1.removeAll();
                    jPanel1.add(vcg,null);
                    jPanel1.setSize(new Dimension(610, 300));
                    jPanel1.updateUI();
                    jPanel1.setVisible(true);
                }
                if(seleccion.equals("Media")){
                    VrComputadoraG2 vcg= new VrComputadoraG2(fondo);
                    this.setSize(new Dimension(753, 488));
                    this.setLocationRelativeTo(null);
                    this.setTitle("Vrs Computadora Dificultad: Media");
                    jLabel9.setVisible(true);
                    jPanel1.removeAll();
                    jPanel1.add(vcg,null);
                    jPanel1.setSize(new Dimension(713, 408));
                    jPanel1.updateUI();
                    jPanel1.setVisible(true);
                }
                if(seleccion.equals("Dificil")){
                    VrComputadoraG3 vcg= new VrComputadoraG3(fondo);
                    this.setSize(new Dimension(885, 609));
                    this.setLocationRelativeTo(null);
                    this.setTitle("Vrs Computadora Dificultad: Dificil");
                    jLabel9.setVisible(true);
                    //jLabel10.setVisible(true);
                    jLabel.setLocation(310,1);
                    jPanel1.removeAll();
                    jPanel1.add(vcg,null);
                    jPanel1.setSize(new Dimension(835, 569));
                    jPanel1.updateUI();
                    jPanel1.setVisible(true);
                    
                }
                if(seleccion==null){
                    jLabel5.setVisible(true);
                }
            }
        }
    }
    
    /**Regresa al menu principal desde el menu de opciones*/
    private void regresar(MouseEvent e) {
        cargar1();
        jLabel7.setVisible(false);
        jLabel6.setBounds(new Rectangle(235, 210, 270, 25));
    }

    /** Metodo que ingresa a la seccion Vr Jugador*/
    private void vrsJugador(MouseEvent e) {
        jLabel5.setVisible(false);
        if(jLabel3.getText().equals("2.- Jugar Contra Jugador")){
            Object seleccion = JOptionPane.showInputDialog(this,"Seleccione una Dificultad","Menu de Opciones",JOptionPane.QUESTION_MESSAGE,null, new Object[] { "Facil", "Media", "Dificil" }, "Facil");
            if(seleccion!=null){
                if(seleccion.equals("Facil")){
                    JuegoFacil jvjf= new JuegoFacil(jLabel9,jLabel10,fondo);
                    this.setSize(new Dimension(655, 360));
                    this.setLocationRelativeTo(null);
                    this.setTitle("Vrs Jugador Dificultad: Facil");
                    jLabel9.setVisible(true);
                    jLabel10.setVisible(true);
                    jPanel1.removeAll();
                    jPanel1.add(jvjf,null);
                    jPanel1.setSize(new Dimension(610, 320));
                    jPanel1.updateUI();
                    jPanel1.setVisible(true);
                }
                if(seleccion.equals("Media")){
                    JuegoMedio jvjm= new JuegoMedio(jLabel9,jLabel10,fondo);
                    this.setSize(new Dimension(750, 490));
                    this.setLocationRelativeTo(null);
                    this.setTitle("Vrs Jugador Dificultad: Media");
                    jLabel9.setVisible(true);
                    jLabel10.setVisible(true);
                    jPanel1.removeAll();
                    jPanel1.add(jvjm,null);
                    jPanel1.setSize(new Dimension(700, 400));
                    jPanel1.updateUI();
                    jPanel1.setVisible(true);
                }
                if(seleccion.equals("Dificil")){
                    JuegoDificil jvjd= new JuegoDificil(jLabel9,jLabel10,fondo);
                    this.setSize(new Dimension(870, 570));
                    this.setLocationRelativeTo(null);
                    this.setTitle("Vrs Jugador Dificultad: Dificil");
                    jLabel9.setVisible(true);
                    jLabel10.setVisible(true);
                    jLabel10.setLocation(600,15);
                    jLabel.setLocation(310,1);
                    jPanel1.removeAll();
                    jPanel1.add(jvjd,null);
                    jPanel1.setSize(new Dimension(830, 500));
                    jPanel1.updateUI();
                    jPanel1.setVisible(true);
                    
                }
                if(seleccion==null){
                    jLabel5.setVisible(true);
                }
            }
        }        
    }

    
    /**Metodo que saca de la aplicacion pidiendo una confirmacion antes de hacerlo y Entra a la seccion de Personalizado */
    private void SalirySF(MouseEvent e) {
        if(jLabel6.getText().equals("3.- Salir")){
            int confirmacion = JOptionPane.showConfirmDialog (null, "Esta saliendo de la aplicacion desea continuar?","Advertencia", JOptionPane.OK_CANCEL_OPTION);
            if(confirmacion == JOptionPane.YES_OPTION){
                JOptionPane.showMessageDialog(this, "Gracias Por Jugar", "Adios",JOptionPane.INFORMATION_MESSAGE);
                System.exit(1);
            }
        }
        else{
            Object seleccion = JOptionPane.showInputDialog(this,"Seleccione un Fondo para las tarjetas del juego","Menu de Opciones",JOptionPane.QUESTION_MESSAGE,null, new Object[] { "Predeterminado", "Automoviles", "Videojuegos", "Perros" }, "Predeterminado");
            if(seleccion!=null){
                if(seleccion.equals("Predeterminado")){
                    fondo=0;
                    this.getContentPane().setBackground(new Color(61, 204, 95));
                }
                if(seleccion.equals("Automoviles")){
                    fondo=1;
                    this.getContentPane().setBackground(new Color(188, 188, 0));
                }
                if(seleccion.equals("Videojuegos")){
                    fondo=2;                    
                    this.getContentPane().setBackground(new Color(82, 82, 255));
                }
                if(seleccion.equals("Perros")){
                    fondo=3;
                    this.getContentPane().setBackground(new Color(255, 222, 115));
                }
                if(seleccion==null){
                    return;
                }
            }
        }
    }

    private void regrersar(MouseEvent e) {
        aviso=false;
        jPanel1.removeAll();
        jPanel1.updateUI();
        jPanel1.setVisible(false);
        jLabel9.setVisible(false);
        jLabel10.setVisible(false);
        jLabel.setLocation(239,1);
        jLabel10.setLocation(495,15);
        jLabel5.setVisible(true);
        this.setSize(new Dimension(698, 351));
        this.setLocationRelativeTo(null);
        this.setTitle("Menu de Opciones");
        aviso=true;
    }
    
    private void DragDrop(){
        DragDrop drag= new DragDrop(jLabel9,aviso);
        this.setSize(new Dimension(640, 650));
        this.setLocationRelativeTo(null);
        this.setTitle("Drag And Drop");
        jLabel5.setVisible(false);
        jLabel9.setVisible(true);
        jPanel1.removeAll();
        jPanel1.add(drag,null);
        jPanel1.setSize(new Dimension(587, 587));
        jPanel1.updateUI();
        jPanel1.setVisible(true);
        
    }
}
