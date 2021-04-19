package catch_me;

import catch_me.JuegoFacil.j;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class JuegoMedio extends JPanel {
    private JLabel jLabel11 = new JLabel();
    private JLabel jLabel12 = new JLabel();
    final String fondo="FondoDefault\\fondo.png";
    private JLabel label1 = new JLabel(new ImageIcon(fondo));
    private JLabel label2 = new JLabel(new ImageIcon(fondo));
    private JLabel label3 = new JLabel(new ImageIcon(fondo));
    private JLabel label4 = new JLabel(new ImageIcon(fondo));
    private JLabel label5 = new JLabel(new ImageIcon(fondo));
    private JLabel label6 = new JLabel(new ImageIcon(fondo));
    private JLabel label7 = new JLabel(new ImageIcon(fondo));
    private JLabel label8 = new JLabel(new ImageIcon(fondo));
    private JLabel label9 = new JLabel(new ImageIcon(fondo));
    private JLabel label10 = new JLabel(new ImageIcon(fondo));
    private JLabel label11 = new JLabel(new ImageIcon(fondo));
    private JLabel label12 = new JLabel(new ImageIcon(fondo));
    private JLabel label13 = new JLabel(new ImageIcon(fondo));
    private JLabel label14 = new JLabel(new ImageIcon(fondo));
    private JLabel label15 = new JLabel(new ImageIcon(fondo));
    private JLabel label16 = new JLabel(new ImageIcon(fondo));
    private JLabel label17 = new JLabel(new ImageIcon(fondo));
    private JLabel label18 = new JLabel(new ImageIcon(fondo));
    public ArrayList cartas = new ArrayList();
    public int[] contenedor = {-1,-1,-1,-1,-1,-1,-1,-1,-1};
    public int [][] matriz = new int[3][6];
    public int [] cartasocupadas = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    Random r = new Random(new Date().getTime());
    int turnojugado=1;
    public ArrayList guia = new ArrayList();
    int pj1=0;
    int pj2=0;
    int contj=0;
    public JLabel auxiliar;
    public JLabel aux1;
    /**Referencia a la clase interna*/
    JuegoMedio.j juego1 = new j();
    private JLabel jLabel1 = new JLabel();
    int fond;

    /**Clase interna que realiza las comprobacion de cada jugada realizada ademas de llevar el control de los turnos*/
    class j{
        /**Metodo que cambia el turno del jugador*/
        public void jugador(){
            if(contj==2){
                if(turnojugado==1){
                    aux1.setText("Turno: Jugador 2");
                    turnojugado=2;
                    contj=0;
                }
                else{
                    aux1.setText("Turno: Jugador 1");
                    turnojugado=1;
                    contj=0;
                }
            }
        }
        
        /**Metodo que analiza la jugada cada dos turnos*/
        public void jugada(){
            int i,aux1=-1,aux2=-1,num1=0,num2=0,aux3=0;
            if(contj==2){
                for(i=0;i<18;i++){  
                    if(cartasocupadas[i]==1){
                        if(aux1!=1 && aux3==0){
                            aux1=i;
                            aux3=1;
                        }
                        else{
                            aux2=i;
                        }
                    }
                }
                switch(aux1){
                    case 0:
                    num1=matriz[0][0];
                    break;
                    case 1:
                    num1=matriz[0][1];
                    break;
                    case 2:
                    num1=matriz[0][2];
                    break;
                    case 3:
                    num1=matriz[0][3];
                    break;
                    case 4:
                    num1=matriz[0][4];
                    break;
                    case 5:
                    num1=matriz[0][5];
                    break;
                    case 6:
                    num1=matriz[1][0];
                    break;
                    case 7:
                    num1=matriz[1][1];
                    break;
                    case 8:
                    num1=matriz[1][2];
                    break;
                    case 9:
                    num1=matriz[1][3];
                    break;
                    case 10:
                    num1=matriz[1][4];
                    break;
                    case 11:
                    num1=matriz[1][5];
                    break;
                    case 12:
                    num1=matriz[2][0];
                    break;
                    case 13:
                    num1=matriz[2][1];
                    break;
                    case 14:
                    num1=matriz[2][2];
                    break;
                    case 15:
                    num1=matriz[2][3];
                    break;
                    case 16:
                    num1=matriz[2][4];
                    break;
                    case 17:
                    num1=matriz[2][5];
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Ocurrio algo insperado", "Error",JOptionPane.ERROR_MESSAGE); 
                    break;
                }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
               
                    switch(aux2){
                    case 0:
                    num2=matriz[0][0];
                    break;
                    case 1:
                    num2=matriz[0][1];
                    break;
                    case 2:
                    num2=matriz[0][2];
                    break;
                    case 3:
                    num2=matriz[0][3];
                    break;
                    case 4:
                    num2=matriz[0][4];
                    break;
                    case 5:
                    num2=matriz[0][5];
                    break;
                    case 6:
                    num2=matriz[1][0];
                    break;
                    case 7:
                    num2=matriz[1][1];
                    break;
                    case 8:
                    num2=matriz[1][2];
                    break;
                    case 9:
                    num2=matriz[1][3];
                    break;
                    case 10:
                    num2=matriz[1][4];
                    break;
                    case 11:
                    num2=matriz[1][5];
                    break;
                    case 12:
                    num2=matriz[2][0];
                    break;
                    case 13:
                    num2=matriz[2][1];
                    break;
                    case 14:
                    num2=matriz[2][2];
                    break;
                    case 15:
                    num2=matriz[2][3];
                    break;
                    case 16:
                    num2=matriz[2][4];
                    break;
                    case 17:
                    num2=matriz[2][5];
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Ocurrio algo insperado", "Error",JOptionPane.ERROR_MESSAGE); 
                    break;
                }
                System.out.println("num1= "+num1); 
                System.out.println("num2= "+num2);
                if(num1==num2){
                    jLabel1.setForeground(new Color(0, 66, 198));
                    jLabel1.setText("Encontro un par"); 
                  
                    if(turnojugado==1){
                        pj1=pj1+1;
                    }
                    else{
                        pj2=pj2+1;
                    }
                    cartasocupadas[aux1]=-1;
                    cartasocupadas[aux2]=-1;
                    num1=0;
                    num2=0;
                }
                else{
                    jLabel1.setForeground(new Color(211, 0, 0));
                    jLabel1.setText("No son par");
                    JOptionPane.showMessageDialog(null, "No son par", "Lo Sentimos",JOptionPane.ERROR_MESSAGE); 

                    try {
                    Thread.sleep(500);
                    } catch (InterruptedException ex) {
                    // aquí tratamos la excepción como queramos, haciendo nada, sacando por pantalla el error, ...
                    }
                    num1=0;
                    num2=0;
                    cartasocupadas[aux1]=0;
                    cartasocupadas[aux2]=0; 
                        switch(aux1){
                            case 0:
                            label1.setIcon(new ImageIcon("FondoDefault\\fondo.png"));
                            break;
                            case 1:
                            label2.setIcon(new ImageIcon("FondoDefault\\fondo.png"));
                            break;
                            case 2:
                            label3.setIcon(new ImageIcon("FondoDefault\\fondo.png"));
                            break;
                            case 3:
                            label4.setIcon(new ImageIcon("FondoDefault\\fondo.png"));
                            break;
                            case 4:
                            label5.setIcon(new ImageIcon("FondoDefault\\fondo.png"));
                            break;
                            case 5:
                            label6.setIcon(new ImageIcon("FondoDefault\\fondo.png"));
                            break;
                            case 6:
                            label7.setIcon(new ImageIcon("FondoDefault\\fondo.png"));
                            break;
                            case 7:
                            label8.setIcon(new ImageIcon("FondoDefault\\fondo.png"));
                            break;
                            case 8:
                            label9.setIcon(new ImageIcon("FondoDefault\\fondo.png"));
                            break;
                            case 9:
                            label10.setIcon(new ImageIcon("FondoDefault\\fondo.png"));
                            break;
                            case 10:
                            label11.setIcon(new ImageIcon("FondoDefault\\fondo.png"));
                            break;
                            case 11:
                            label12.setIcon(new ImageIcon("FondoDefault\\fondo.png"));
                            break;
                            case 12:
                            label13.setIcon(new ImageIcon("FondoDefault\\fondo.png"));
                            break;
                            case 13:
                            label14.setIcon(new ImageIcon("FondoDefault\\fondo.png"));
                            break;
                            case 14:
                            label15.setIcon(new ImageIcon("FondoDefault\\fondo.png"));
                            break;
                            case 15:
                            label16.setIcon(new ImageIcon("FondoDefault\\fondo.png"));
                            break;
                            case 16:
                            label17.setIcon(new ImageIcon("FondoDefault\\fondo.png"));
                            break;
                            case 17:
                            label18.setIcon(new ImageIcon("FondoDefault\\fondo.png"));
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Ocurrio algo insperado", "Error",JOptionPane.ERROR_MESSAGE);
                            break;
                        }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                        switch(aux2){
                            case 0:
                            label1.setIcon(new ImageIcon("FondoDefault\\fondo.png"));
                            break;
                            case 1:
                            label2.setIcon(new ImageIcon("FondoDefault\\fondo.png"));
                            break;
                            case 2:
                            label3.setIcon(new ImageIcon("FondoDefault\\fondo.png"));
                            break;
                            case 3:
                            label4.setIcon(new ImageIcon("FondoDefault\\fondo.png"));
                            break;
                            case 4:
                            label5.setIcon(new ImageIcon("FondoDefault\\fondo.png"));
                            break;
                            case 5:
                            label6.setIcon(new ImageIcon("FondoDefault\\fondo.png"));
                            break;
                            case 6:
                            label7.setIcon(new ImageIcon("FondoDefault\\fondo.png"));
                            break;
                            case 7:
                            label8.setIcon(new ImageIcon("FondoDefault\\fondo.png"));
                            break;
                            case 8:
                            label9.setIcon(new ImageIcon("FondoDefault\\fondo.png"));
                            break;
                            case 9:
                            label10.setIcon(new ImageIcon("FondoDefault\\fondo.png"));
                            break;
                            case 10:
                            label11.setIcon(new ImageIcon("FondoDefault\\fondo.png"));
                            break;
                            case 11:
                            label12.setIcon(new ImageIcon("FondoDefault\\fondo.png"));
                            break;
                            case 12:
                            label13.setIcon(new ImageIcon("FondoDefault\\fondo.png"));
                            break;
                            case 13:
                            label14.setIcon(new ImageIcon("FondoDefault\\fondo.png"));
                            break;
                            case 14:
                            label15.setIcon(new ImageIcon("FondoDefault\\fondo.png"));
                            break;
                            case 15:
                            label16.setIcon(new ImageIcon("FondoDefault\\fondo.png"));
                            break;
                            case 16:
                            label17.setIcon(new ImageIcon("FondoDefault\\fondo.png"));
                            break;
                            case 17:
                            label18.setIcon(new ImageIcon("FondoDefault\\fondo.png"));
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Ocurrio algo insperado", "Error",JOptionPane.ERROR_MESSAGE);
                            break;
                        }                
                }
            }
        }
        
        public void marcador(){
            jLabel11.setText("Jugador 1: "+pj1+" puntos");
            jLabel12.setText("Jugador 2: "+pj2+" puntos");
        }
        
        public void FinJuego(){
            boolean ban=false;
            int i;
            for(i=0;i<18;i++){
                if(cartasocupadas[i]!=-1){
                    ban=true;
                }
            }
            if(ban==false){
                if(pj1==pj2){
                    JOptionPane.showMessageDialog(null, "Empate", "Fin del juego",JOptionPane.INFORMATION_MESSAGE); 
                }
                if(pj1>pj2){
                    JOptionPane.showMessageDialog(null, "Gana Jugador 1", "Fin del juego",JOptionPane.INFORMATION_MESSAGE); 
                }
                if(pj1<pj2){
                    JOptionPane.showMessageDialog(null, "Gana Jugador 2", "Fin del juego",JOptionPane.INFORMATION_MESSAGE); 
                }
            }
        }
    }

    /**Constructor de la clase Principal*/
    public JuegoMedio(JLabel aux, JLabel au, int fon) {
        try {
            auxiliar=aux;
            aux1=au;
            fond=fon;
            jbInit();
            Cargar();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setLayout( null );
        this.setSize(new Dimension(713, 408));
        label1.setBounds(new Rectangle(20, 50, 100, 100));
        label1.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    jugada(1);
                }
            });
        label2.setBounds(new Rectangle(135, 50, 100, 100));
        label2.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        label2.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    jugada(2);
                }
            });
        label3.setBounds(new Rectangle(250, 50, 100, 100));
        label3.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        label3.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    jugada(3);
                }
            });
        label4.setBounds(new Rectangle(365, 50, 100, 100));
        label4.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        label4.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    jugada(4);
                }
            });
        label5.setBounds(new Rectangle(480, 50, 100, 100));
        label5.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        label5.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    
                    jugada(5);
                }
            });
        label6.setBounds(new Rectangle(595, 50, 100, 100));
        label6.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        label6.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    jugada(6);
                }
            });
        label7.setBounds(new Rectangle(20, 165, 100, 100));
        label7.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        label7.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    jugada(7);
                }
            });
        label8.setBounds(new Rectangle(135, 165, 100, 100));
        label8.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        label8.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    jugada(8);
                }
            });
        label9.setBounds(new Rectangle(250, 165, 100, 100));
        label9.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        label9.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    jugada(9);
                }
            });
        label10.setBounds(new Rectangle(365, 165, 100, 100));
        label10.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        label10.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    jugada(10);
                }
            });
        
        label11.setBounds(new Rectangle(480, 165, 100, 100));
        label11.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        label11.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    jugada(11);
                }
            });
        
        
        label12.setBounds(new Rectangle(595, 165, 100, 100));
        label12.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        label12.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    jugada(12);
                }
            });
        
        label13.setBounds(new Rectangle(20, 280, 100, 100));
        label13.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        label13.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    jugada(13);
                }
            });
        
        label14.setBounds(new Rectangle(135, 280, 100, 100));
        label14.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        label14.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    jugada(14);
                }
            });
        
        label15.setBounds(new Rectangle(250, 280, 100, 100));
        label15.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        label15.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    jugada(15);
                }
            });
        
        label16.setBounds(new Rectangle(365, 280, 100, 100));
        label16.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        label16.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    jugada(16);
                }
            });
        
        label17.setBounds(new Rectangle(480, 280, 100, 100));
        label17.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        label17.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    jugada(17);
                }
            });
        
        label18.setBounds(new Rectangle(595, 280, 100, 100));
        label18.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        label18.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    jugada(18);
                }
            });
        
        auxiliar.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    remover(e);
                }
            });

        jLabel1.setBounds(new Rectangle(275, 15, 130, 25));
        jLabel1.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setHorizontalTextPosition(SwingConstants.CENTER);
        jLabel11.setText("Jugador 1: 0 puntos");
        jLabel11.setBounds(new Rectangle(25, 10, 130, 25));
        jLabel12.setText("Jugador 2: 0 puntos");
        jLabel12.setBounds(new Rectangle(560, 10, 125, 25));

        this.add(jLabel1, null);
        this.add(label18, null);
        this.add(label17, null);
        this.add(label16, null);
        this.add(label15, null);
        this.add(label14, null);
        this.add(label13, null);
        this.add(label12, null);
        this.add(label11, null);
        this.add(jLabel12, null);
        this.add(jLabel11, null);
        this.add(label10, null);
        this.add(label9, null);
        this.add(label8, null);
        this.add(label7, null);
        this.add(label6, null);
        this.add(label5, null);
        this.add(label4, null);
        this.add(label3, null);
        this.add(label2, null);
        this.add(label1, null);
    }
    
    /**Se ingresan todas las imagenes posibles para usarse*/
    public void Asignar(){
            if(fond==0){
                cartas.add(new ImageIcon("FondoDefault\\1.png"));
                cartas.add(new ImageIcon("FondoDefault\\2.png"));
                cartas.add(new ImageIcon("FondoDefault\\3.png"));
                cartas.add(new ImageIcon("FondoDefault\\4.png"));
                cartas.add(new ImageIcon("FondoDefault\\5.png"));
                cartas.add(new ImageIcon("FondoDefault\\6.png"));
                cartas.add(new ImageIcon("FondoDefault\\7.png"));
                cartas.add(new ImageIcon("FondoDefault\\8.png"));
                cartas.add(new ImageIcon("FondoDefault\\9.png"));
                cartas.add(new ImageIcon("FondoDefault\\10.png"));
                cartas.add(new ImageIcon("FondoDefault\\11.png"));
                cartas.add(new ImageIcon("FondoDefault\\12.png"));
                cartas.add(new ImageIcon("FondoDefault\\13.png"));
                cartas.add(new ImageIcon("FondoDefault\\14.png"));
            }
            if(fond==1){
                cartas.add(new ImageIcon("Carros\\1.png"));
                cartas.add(new ImageIcon("Carros\\2.png"));
                cartas.add(new ImageIcon("Carros\\3.png"));
                cartas.add(new ImageIcon("Carros\\4.png"));
                cartas.add(new ImageIcon("Carros\\5.png"));
                cartas.add(new ImageIcon("Carros\\6.png"));
                cartas.add(new ImageIcon("Carros\\7.png"));
                cartas.add(new ImageIcon("Carros\\8.png"));
                cartas.add(new ImageIcon("Carros\\9.png"));
                cartas.add(new ImageIcon("Carros\\10.png"));
                cartas.add(new ImageIcon("Carros\\11.png"));
                cartas.add(new ImageIcon("Carros\\12.png"));
                cartas.add(new ImageIcon("Carros\\13.png"));
                cartas.add(new ImageIcon("Carros\\14.png"));
            }
            if(fond==2){
                cartas.add(new ImageIcon("ResidentEvil\\1.png"));
                cartas.add(new ImageIcon("ResidentEvil\\2.png"));
                cartas.add(new ImageIcon("ResidentEvil\\3.png"));
                cartas.add(new ImageIcon("ResidentEvil\\4.png"));
                cartas.add(new ImageIcon("ResidentEvil\\5.png"));
                cartas.add(new ImageIcon("ResidentEvil\\6.png"));
                cartas.add(new ImageIcon("ResidentEvil\\7.png"));
                cartas.add(new ImageIcon("ResidentEvil\\8.png"));
                cartas.add(new ImageIcon("ResidentEvil\\9.png"));
                cartas.add(new ImageIcon("ResidentEvil\\10.png"));
                cartas.add(new ImageIcon("ResidentEvil\\11.png"));
                cartas.add(new ImageIcon("ResidentEvil\\12.png"));
                cartas.add(new ImageIcon("ResidentEvil\\13.png"));
                cartas.add(new ImageIcon("ResidentEvil\\14.png"));
            }
            if(fond==3){
                cartas.add(new ImageIcon("Perros\\1.png"));
                cartas.add(new ImageIcon("Perros\\2.png"));
                cartas.add(new ImageIcon("Perros\\3.png"));
                cartas.add(new ImageIcon("Perros\\4.png"));
                cartas.add(new ImageIcon("Perros\\5.png"));
                cartas.add(new ImageIcon("Perros\\6.png"));
                cartas.add(new ImageIcon("Perros\\7.png"));
                cartas.add(new ImageIcon("Perros\\8.png"));
                cartas.add(new ImageIcon("Perros\\9.png"));
                cartas.add(new ImageIcon("Perros\\10.png"));
                cartas.add(new ImageIcon("Perros\\11.png"));
                cartas.add(new ImageIcon("Perros\\12.png"));
                cartas.add(new ImageIcon("Perros\\13.png"));
                cartas.add(new ImageIcon("Perros\\14.png"));
            }
        }
    
    /**Este metodo relaciona aleatoriamente cada imagen con un numero */
    public void array(){
        int i=0;
        int j=0;
        boolean f;
        int aux;
        while(i<9){
            f=false;
            aux=(int)(r.nextDouble()*14);
            for(j=0;j<9;j++){
                if(contenedor[j]== aux){
                    f=true;
                }
            }
            if(f==false){
                contenedor[i]=aux;
                i=i+1;
            }
        }
        System.out.println("Vector asociado a las imagenes");
        for(i=0;i<9;i++){
            System.out.printf("%d\t",contenedor[i]+1);
        }
        System.out.println("");
    }
    
    /**Este metodo guarda en el array guia las 10 cartas posibles*/
    public void Guia(){
        int i;
        for(i=0;i<9;i++){
            guia.add(cartas.get(contenedor[i]));
        }
    }
    
    
    /**Se llena una matriz con los valores posibles del contenedor*/
    public void matriz(){
        int i=0;
        inicializar();
        while(i<contenedor.length){
            int n=(int)(r.nextDouble()*3);
            int n1=(int)(r.nextDouble()*6);
            int n2=(int)(r.nextDouble()*3);
            int n3=(int)(r.nextDouble()*6);
            String aux="",aux1="";
            aux=""+n+""+n1;
            aux1=""+n2+""+n3;
                if(matriz[n][n1]==0 && matriz[n2][n3]==0 && aux.equals(aux1)==false){
                    matriz[n][n1]=contenedor[i];
                    matriz[n2][n3]=contenedor[i];
                    i++;
                }
        }
        System.out.println("Matriz Asociada al Juego");
        int j;
        for(i=0;i<3;i++){
            for(j=0;j<6;j++){
                System.out.printf("%d\t", matriz[i][j]+1);
            }
            System.out.println("");
        }
            
    }
    
    /**Se inicializa la matriz en 0*/
    public void inicializar(){
        int r;
        int c;
        for(r=0;r<3;r++){
            for(c=0;c<6;c++){
                matriz[r][c]=0;
            }
        }
    }
    
    /**Metodo que carga cada nuevo juego */
    public void Cargar(){
        Asignar();
        array();
        Guia();
        matriz();
    }
    
    /**Metodo que realiza todos los movimientos de las tarjetas*/
    private void jugada(int n){
        int i;
        switch(n){
            case 1:
                if(cartasocupadas[0]==0){
                    cartasocupadas[0]=1;
                    for(i=0;i<9;i++){
                        if(contenedor[i]==matriz[0][0]){
                            label1.setIcon((Icon)guia.get(i));
                        }
                    }
                    JuegoMedio.j j1= juego1;
                    contj=contj+1;
                    j1.jugada();
                    j1.jugador();
                    j1.marcador();
                    j1.FinJuego();
                }else{
                    JOptionPane.showMessageDialog(this, "Movimiento Invalido", "Error",JOptionPane.ERROR_MESSAGE);   
                }
                break;
            case 2:
                if(cartasocupadas[1]==0){
                    cartasocupadas[1]=1;
                    for(i=0;i<9;i++){
                        if(contenedor[i]==matriz[0][1]){
                            label2.setIcon((Icon)guia.get(i));
                        }
                    }
                    JuegoMedio.j j1= juego1;
                    contj=contj+1;
                    j1.jugada();
                    j1.jugador();
                    j1.marcador();
                    j1.FinJuego();
                }else{
                    JOptionPane.showMessageDialog(this, "Movimiento Invalido", "Error",JOptionPane.ERROR_MESSAGE);  
                }
                break;        
            case 3:
            if(cartasocupadas[2]==0){
                cartasocupadas[2]=1;
                for(i=0;i<9;i++){
                    if(contenedor[i]==matriz[0][2]){
                        label3.setIcon((Icon)guia.get(i));
                    }
                }
                JuegoMedio.j j1= juego1;
                contj=contj+1;
                j1.jugada();
                j1.jugador();
                j1.marcador();
                j1.FinJuego();
            }else{
                JOptionPane.showMessageDialog(this, "Movimiento Invalido", "Error",JOptionPane.ERROR_MESSAGE);  
            }
                break;        
            case 4:
            if(cartasocupadas[3]==0){
                cartasocupadas[3]=1;
                for(i=0;i<9;i++){
                    if(contenedor[i]==matriz[0][3]){
                        label4.setIcon((Icon)guia.get(i));
                    }
                }
                JuegoMedio.j j1= juego1;
                contj=contj+1;
                j1.jugada();
                j1.jugador();
                j1.marcador();
                j1.FinJuego();
            }else{
                JOptionPane.showMessageDialog(this, "Movimiento Invalido", "Error",JOptionPane.ERROR_MESSAGE); 
            }
                break;        
            case 5:
            if(cartasocupadas[4]==0){
                cartasocupadas[4]=1;
                for(i=0;i<9;i++){
                    if(contenedor[i]==matriz[0][4]){
                        label5.setIcon((Icon)guia.get(i));
                    }
                }
                JuegoMedio.j j1= juego1;
                contj=contj+1;
                j1.jugada();
                j1.jugador();
                j1.marcador();
                j1.FinJuego();
            }else{
                JOptionPane.showMessageDialog(this, "Movimiento Invalido", "Error",JOptionPane.ERROR_MESSAGE);  
            }
                break;        
            case 6:
            if(cartasocupadas[5]==0){
                cartasocupadas[5]=1;
                for(i=0;i<9;i++){
                    if(contenedor[i]==matriz[0][5]){
                        label6.setIcon((Icon)guia.get(i));
                    }
                }
                JuegoMedio.j j1= juego1;
                contj=contj+1;
                j1.jugada();
                j1.jugador();
                j1.marcador();
                j1.FinJuego();
            }else{
                JOptionPane.showMessageDialog(this, "Movimiento Invalido", "Error",JOptionPane.ERROR_MESSAGE);  
            }
                break;        
            case 7:
            if(cartasocupadas[6]==0){
                cartasocupadas[6]=1;
                for(i=0;i<9;i++){
                    if(contenedor[i]==matriz[1][0]){
                        label7.setIcon((Icon)guia.get(i));
                    }
                }
                JuegoMedio.j j1= juego1;
                contj=contj+1;
                j1.jugada();
                j1.jugador();
                j1.marcador();
                j1.FinJuego();
            }else{
                JOptionPane.showMessageDialog(this, "Movimiento Invalido", "Error",JOptionPane.ERROR_MESSAGE);  
            }
                break;        
            case 8:
            if(cartasocupadas[7]==0){
                cartasocupadas[7]=1;
                for(i=0;i<9;i++){
                    if(contenedor[i]==matriz[1][1]){
                        label8.setIcon((Icon)guia.get(i));
                    }
                }
                JuegoMedio.j j1= juego1;
                contj=contj+1;
                j1.jugada();
                j1.jugador();
                j1.marcador();
                j1.FinJuego();
            }else{
                JOptionPane.showMessageDialog(this, "Movimiento Invalido", "Error",JOptionPane.ERROR_MESSAGE);  
            }
                break;        
            case 9:
            if(cartasocupadas[8]==0){
                cartasocupadas[8]=1;
                for(i=0;i<9;i++){
                    if(contenedor[i]==matriz[1][2]){
                        label9.setIcon((Icon)guia.get(i));
                    }
                }
                //
                JuegoMedio.j j1= juego1;
                contj=contj+1;
                j1.jugada();
                j1.jugador();
                j1.marcador();
                j1.FinJuego();
            }else{
                JOptionPane.showMessageDialog(this, "Movimiento Invalido", "Error",JOptionPane.ERROR_MESSAGE);  
            }   
                break;        
            case 10:
            if(cartasocupadas[9]==0){
                cartasocupadas[9]=1;
                for(i=0;i<9;i++){
                    if(contenedor[i]==matriz[1][3]){
                        label10.setIcon((Icon)guia.get(i));
                    }
                }
                //
                JuegoMedio.j j1= juego1;
                contj=contj+1;
                j1.jugada();
                j1.jugador();
                j1.marcador();
                j1.FinJuego();
            }else{
                JOptionPane.showMessageDialog(this, "Movimiento Invalido", "Error",JOptionPane.ERROR_MESSAGE);  
            }   
                break;        
            case 11:
            if(cartasocupadas[10]==0){
                cartasocupadas[10]=1;
                for(i=0;i<9;i++){
                    if(contenedor[i]==matriz[1][4]){
                        label11.setIcon((Icon)guia.get(i));
                    }
                }
                JuegoMedio.j j1= juego1;
                contj=contj+1;
                j1.jugada();
                j1.jugador();
                j1.marcador();
                j1.FinJuego();
            }else{
                JOptionPane.showMessageDialog(this, "Movimiento Invalido", "Error",JOptionPane.ERROR_MESSAGE);  
            }
                break;        
            case 12:
            if(cartasocupadas[11]==0){
                cartasocupadas[11]=1;
                for(i=0;i<9;i++){
                    if(contenedor[i]==matriz[1][5]){
                        label12.setIcon((Icon)guia.get(i));
                    }
                }
                JuegoMedio.j j1= juego1;
                contj=contj+1;
                j1.jugada();
                j1.jugador();
                j1.marcador();
                j1.FinJuego();
            }else{
                JOptionPane.showMessageDialog(this, "Movimiento Invalido", "Error",JOptionPane.ERROR_MESSAGE);  
            }
                break;        
            case 13:
            if(cartasocupadas[12]==0){
                cartasocupadas[12]=1;
                for(i=0;i<9;i++){
                    if(contenedor[i]==matriz[2][0]){
                        label13.setIcon((Icon)guia.get(i));
                    }
                }
                JuegoMedio.j j1= juego1;
                contj=contj+1;
                j1.jugada();
                j1.jugador();
                j1.marcador();
                j1.FinJuego();
            }else{
                JOptionPane.showMessageDialog(this, "Movimiento Invalido", "Error",JOptionPane.ERROR_MESSAGE);  
            }
                break;        
            case 14:
            if(cartasocupadas[13]==0){
                cartasocupadas[13]=1;
                for(i=0;i<9;i++){
                    if(contenedor[i]==matriz[2][1]){
                        label14.setIcon((Icon)guia.get(i));
                    }
                }
                JuegoMedio.j j1= juego1;
                contj=contj+1;
                j1.jugada();
                j1.jugador();
                j1.marcador();
                j1.FinJuego();
            }else{
                JOptionPane.showMessageDialog(this, "Movimiento Invalido", "Error",JOptionPane.ERROR_MESSAGE);  
            }
                break;        
            case 15:
            if(cartasocupadas[14]==0){
                cartasocupadas[14]=1;
                for(i=0;i<9;i++){
                    if(contenedor[i]==matriz[2][2]){
                        label15.setIcon((Icon)guia.get(i));
                    }
                }
                JuegoMedio.j j1= juego1;
                contj=contj+1;
                j1.jugada();
                j1.jugador();
                j1.marcador();
                j1.FinJuego();
            }else{
                JOptionPane.showMessageDialog(this, "Movimiento Invalido", "Error",JOptionPane.ERROR_MESSAGE);  
            }
                break;        
            case 16:
            if(cartasocupadas[15]==0){
                cartasocupadas[15]=1;
                for(i=0;i<9;i++){
                    if(contenedor[i]==matriz[2][3]){
                        label16.setIcon((Icon)guia.get(i));
                    }
                }
                JuegoMedio.j j1= juego1;
                contj=contj+1;
                j1.jugada();
                j1.jugador();
                j1.marcador();
                j1.FinJuego();
            }else{
                JOptionPane.showMessageDialog(this, "Movimiento Invalido", "Error",JOptionPane.ERROR_MESSAGE);  
            }
                break;        
            case 17:
            if(cartasocupadas[16]==0){
                cartasocupadas[16]=1;
                for(i=0;i<9;i++){
                    if(contenedor[i]==matriz[2][4]){
                        label17.setIcon((Icon)guia.get(i));
                    }
                }
                //
                JuegoMedio.j j1= juego1;
                contj=contj+1;
                j1.jugada();
                j1.jugador();
                j1.marcador();
                j1.FinJuego();
            }else{
                JOptionPane.showMessageDialog(this, "Movimiento Invalido", "Error",JOptionPane.ERROR_MESSAGE);  
            }
                break;        
            case 18:
            if(cartasocupadas[17]==0){
                cartasocupadas[17]=1;
                for(i=0;i<9;i++){
                    if(contenedor[i]==matriz[2][5]){
                        label18.setIcon((Icon)guia.get(i));
                    }
                }
                //
                JuegoMedio.j j1= juego1;
                contj=contj+1;
                j1.jugada();
                j1.jugador();
                j1.marcador();
                j1.FinJuego();
            }else{
                JOptionPane.showMessageDialog(this, "Movimiento Invalido", "Error",JOptionPane.ERROR_MESSAGE);  
            }   
                break; 
            default:
                JOptionPane.showMessageDialog(this, "Movimiento Invalido", "Error",JOptionPane.ERROR_MESSAGE);  
                break;
        }
        
        }
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**Reinicia el tablero*/
    private void remover(MouseEvent e) {
        label1.setIcon(new ImageIcon("FondoDefault\\fondo.png"));
        label2.setIcon(new ImageIcon("FondoDefault\\fondo.png"));
        label3.setIcon(new ImageIcon("FondoDefault\\fondo.png"));
        label4.setIcon(new ImageIcon("FondoDefault\\fondo.png"));
        label5.setIcon(new ImageIcon("FondoDefault\\fondo.png"));
        label6.setIcon(new ImageIcon("FondoDefault\\fondo.png"));
        label7.setIcon(new ImageIcon("FondoDefault\\fondo.png"));
        label8.setIcon(new ImageIcon("FondoDefault\\fondo.png"));
        label9.setIcon(new ImageIcon("FondoDefault\\fondo.png"));
        label10.setIcon(new ImageIcon("FondoDefault\\fondo.png"));
        label11.setIcon(new ImageIcon("FondoDefault\\fondo.png"));
        label12.setIcon(new ImageIcon("FondoDefault\\fondo.png"));
        label13.setIcon(new ImageIcon("FondoDefault\\fondo.png"));
        label14.setIcon(new ImageIcon("FondoDefault\\fondo.png"));
        label15.setIcon(new ImageIcon("FondoDefault\\fondo.png"));
        label16.setIcon(new ImageIcon("FondoDefault\\fondo.png"));
        label17.setIcon(new ImageIcon("FondoDefault\\fondo.png"));
        label18.setIcon(new ImageIcon("FondoDefault\\fondo.png"));
        jLabel11.setText("Jugador 1: 0 puntos");
        jLabel12.setText("Jugador 2: 0 puntos");
        for(int i=0;i<9;i++){
            contenedor[i]=-1;
        }
        for(int i=0;i<18;i++){
            cartasocupadas[i]=0;
        }
        guia.clear();
        cartas.clear();
        aux1.setText("Turno: Jugador 1");
        turnojugado=1;
        pj1=0;
        pj2=0;
        contj=0;
        Cargar();
    }    
}
