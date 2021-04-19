package catch_me;

/**Luis Ernesto Sierra Alva y Luis Humberto Ponce Hermosillo*/


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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


/**Clase que funge como tablero del nivel facil*/
public class JuegoFacil extends JPanel {
    private JLabel jLabel1 = new JLabel(new ImageIcon("FondoDefault\\fondo.png"));
    private JLabel jLabel2 = new JLabel(new ImageIcon("FondoDefault\\fondo.png"));
    private JLabel jLabel3 = new JLabel(new ImageIcon("FondoDefault\\fondo.png"));
    private JLabel jLabel4 = new JLabel(new ImageIcon("FondoDefault\\fondo.png"));
    private JLabel jLabel5 = new JLabel(new ImageIcon("FondoDefault\\fondo.png"));
    private JLabel jLabel6 = new JLabel(new ImageIcon("FondoDefault\\fondo.png"));
    private JLabel jLabel7 = new JLabel(new ImageIcon("FondoDefault\\fondo.png"));
    private JLabel jLabel8 = new JLabel(new ImageIcon("FondoDefault\\fondo.png"));
    private JLabel jLabel9 = new JLabel(new ImageIcon("FondoDefault\\fondo.png"));
    private JLabel jLabel10 = new JLabel(new ImageIcon("FondoDefault\\fondo.png"));
    public ArrayList cartas = new ArrayList();
    public int[] contenedor = {-1,-1,-1,-1,-1};
    public int [][] matriz = new int[2][5];
    public int [] cartasocupadas = {0,0,0,0,0,0,0,0,0,0};
    Random r = new Random(new Date().getTime());
    int turnojugado=1;
    public ArrayList guia = new ArrayList();
    int pj1=0;
    int pj2=0;
    int contj=0;
    public JLabel auxiliar;
    public JLabel aux1;
    /**Referencia a la clase interna*/
    JuegoFacil.j juego1 = new j();
    private JLabel jLabel11 = new JLabel();
    private JLabel jLabel12 = new JLabel();
    private JLabel jLabel13 = new JLabel();
    int fondo;

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

                for(i=0;i<10;i++){  
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
                       num1=matriz[1][0];
                       break;
                       case 6:
                       num1=matriz[1][1];
                       break;
                       case 7:
                       num1=matriz[1][2];
                       break;
                       case 8:
                       num1=matriz[1][3];
                       break;
                       case 9:
                       num1=matriz[1][4];
                       break;
                        default:
                        JOptionPane.showMessageDialog(null, "Ocurrio algo insperado", "Error",JOptionPane.ERROR_MESSAGE); 
                        break;
                }
                
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
                num2=matriz[1][0];
                break;
                case 6:
                num2=matriz[1][1];
                break;
                case 7:
                num2=matriz[1][2];
                break;
                case 8:
                num2=matriz[1][3];
                break;
                case 9:
                num2=matriz[1][4];
                break;
                default:
                JOptionPane.showMessageDialog(null, "Ocurrio algo insperado", "Error",JOptionPane.ERROR_MESSAGE); 
                break;
                }
                if(num1==num2){
                    jLabel13.setForeground(new Color(0, 66, 198));
                    jLabel13.setText("Encontro un par");
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
                    jLabel13.setForeground(new Color(211, 0, 0));
                    jLabel13.setText("No son par");
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
                        jLabel1.setIcon(new ImageIcon("FondoDefault\\fondo.png"));
                        break;
                        case 1:
                        jLabel2.setIcon(new ImageIcon("FondoDefault\\fondo.png"));
                        break;
                        case 2:
                        jLabel3.setIcon(new ImageIcon("FondoDefault\\fondo.png"));
                        break;
                        case 3:
                        jLabel4.setIcon(new ImageIcon("FondoDefault\\fondo.png"));
                        break;
                        case 4:
                        jLabel5.setIcon(new ImageIcon("FondoDefault\\fondo.png"));
                        break;
                        case 5:
                        jLabel6.setIcon(new ImageIcon("FondoDefault\\fondo.png"));
                        break;
                        case 6:
                        jLabel7.setIcon(new ImageIcon("FondoDefault\\fondo.png"));
                        break;
                        case 7:
                        jLabel8.setIcon(new ImageIcon("FondoDefault\\fondo.png"));
                        break;
                        case 8:
                        jLabel9.setIcon(new ImageIcon("FondoDefault\\fondo.png"));
                        break;
                        case 9:
                        jLabel10.setIcon(new ImageIcon("FondoDefault\\fondo.png"));
                        break;
                        default:
                        JOptionPane.showMessageDialog(null, "Ocurrio algo insperado", "Error",JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    
                    switch(aux2){
                        case 0:
                        jLabel1.setIcon(new ImageIcon("FondoDefault\\fondo.png"));
                        break;
                        case 1:
                        jLabel2.setIcon(new ImageIcon("FondoDefault\\fondo.png"));
                        break;
                        case 2:
                        jLabel3.setIcon(new ImageIcon("FondoDefault\\fondo.png"));
                        break;
                        case 3:
                        jLabel4.setIcon(new ImageIcon("FondoDefault\\fondo.png"));
                        break;
                        case 4:
                        jLabel5.setIcon(new ImageIcon("FondoDefault\\fondo.png"));
                        break;
                        case 5:
                        jLabel6.setIcon(new ImageIcon("FondoDefault\\fondo.png"));
                        break;
                        case 6:
                        jLabel7.setIcon(new ImageIcon("FondoDefault\\fondo.png"));
                        break;
                        case 7:
                        jLabel8.setIcon(new ImageIcon("FondoDefault\\fondo.png"));
                        break;
                        case 8:
                        jLabel9.setIcon(new ImageIcon("FondoDefault\\fondo.png"));
                        break;
                        case 9:
                        jLabel10.setIcon(new ImageIcon("FondoDefault\\fondo.png"));
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
            for(i=0;i<10;i++){
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
    public JuegoFacil(JLabel aux, JLabel au, int fon) {
        try {
            auxiliar=aux;
            aux1=au;
            fondo=fon;
            jbInit();
            Cargar();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    /**Metodo que inicializa los componentes graficos*/
    private void jbInit() throws Exception {
        this.setLayout( null );
        this.setSize(new Dimension(612, 273));
        jLabel1.setBounds(new Rectangle(25, 50, 100, 100));
        jLabel1.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        jLabel1.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    jugada(1);
                }
            });
        jLabel2.setBounds(new Rectangle(140, 50, 100, 100));
        jLabel2.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        jLabel2.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    jugada(2);
                }
            });
        jLabel3.setBounds(new Rectangle(255, 50, 100, 100));
        jLabel3.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        jLabel3.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    jugada(3);
                }
            });
        jLabel4.setBounds(new Rectangle(370, 50, 100, 100));
        jLabel4.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        jLabel4.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    jugada(4);
                }
            });
        jLabel5.setBounds(new Rectangle(485, 50, 100, 100));
        jLabel5.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        jLabel5.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    jugada(5);
                }
            });
        jLabel6.setBounds(new Rectangle(25, 160, 100, 100));
        jLabel6.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        jLabel6.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    jugada(6);
                }
            });
        jLabel7.setBounds(new Rectangle(140, 160, 100, 100));
        jLabel7.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        jLabel7.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    jugada(7);
                }
            });
        jLabel8.setBounds(new Rectangle(255, 160, 100, 100));
        jLabel8.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        jLabel8.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    jugada(8);
                }
            });
        jLabel9.setBounds(new Rectangle(370, 160, 100, 100));
        jLabel9.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        jLabel9.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    jugada(9);
                }
            });
        jLabel10.setBounds(new Rectangle(485, 160, 100, 100));
        jLabel10.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        jLabel10.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    jugada(10);
                }
            });
        
        auxiliar.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    remover(e);
                }
            });

        jLabel11.setText("Jugador 1: 0 puntos");
        jLabel11.setBounds(new Rectangle(25, 10, 130, 25));
        jLabel11.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        jLabel11.setHorizontalTextPosition(SwingConstants.CENTER);
        jLabel11.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel12.setText("Jugador 2: 0 puntos");
        jLabel12.setBounds(new Rectangle(450, 10, 125, 25));
        jLabel12.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        jLabel12.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel12.setHorizontalTextPosition(SwingConstants.CENTER);
        jLabel13.setBounds(new Rectangle(230, 10, 145, 25));
        jLabel13.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel13.setHorizontalTextPosition(SwingConstants.CENTER);
        jLabel13.setForeground(new Color(211, 0, 0));
        this.add(jLabel13, null);
        this.add(jLabel12, null);
        this.add(jLabel11, null);
        this.add(jLabel10, null);
        this.add(jLabel9, null);
        this.add(jLabel8, null);
        this.add(jLabel7, null);
        this.add(jLabel6, null);
        this.add(jLabel5, null);
        this.add(jLabel4, null);
        this.add(jLabel3, null);
        this.add(jLabel2, null);
        this.add(jLabel1, null);
    }
    
    
    /**Se ingresan todas las imagenes posibles para usarse*/
    public void Asignar(){
        if(fondo==0){
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
        if(fondo==1){
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
        if(fondo==2){
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
        if(fondo==3){
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
        while(i<5){
            f=false;
            aux=(int)(r.nextDouble()*14);
            for(j=0;j<5;j++){
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
        for(i=0;i<5;i++){
            System.out.printf("%d\t",contenedor[i]+1);
        }
        System.out.println("");
    }
    
    
    /**Este metodo guarda en el array guia las 5 cartas posibles*/
    public void Guia(){
        int i;
        for(i=0;i<5;i++){
            guia.add(cartas.get(contenedor[i]));
        }
    }
    
    
    /**Se llena una matriz con los valores posibles del contenedor*/
    public void matriz(){
        int i=0;
        inicializar();
        while(i<contenedor.length){
            int n=(int)(r.nextDouble()*2);
            int n1=(int)(r.nextDouble()*5);
            int n2=(int)(r.nextDouble()*2);
            int n3=(int)(r.nextDouble()*5);
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
        for(i=0;i<2;i++){
            for(j=0;j<5;j++){
                System.out.printf("%d\t", matriz[i][j]+1);
            }
            System.out.println("");
        }
            
    }
    
    
    
    /**Se inicializa la matriz en 0*/
    public void inicializar(){
        int r;
        int c;
        for(r=0;r<2;r++){
            for(c=0;c<5;c++){
                matriz[r][c]=0;
            }
        }
    }
    
    
    public static void main (String args[]){
        JLabel aux = new JLabel();
        JLabel aux1 = new JLabel();
        JuegoFacil jf = new JuegoFacil(aux, aux1,0);
        JFrame frame = new JFrame();
        frame.setSize(608, 269);
        frame.add(jf);
        frame.setVisible(true);
    }


    /**Metodo que carga cada nuevo juego */
    public void Cargar(){
        Asignar();
        array();
        Guia();
        matriz();
    }

    
    /**Reinicia el tablero*/
    private void remover(MouseEvent e) {
        jLabel1.setIcon(new ImageIcon("FondoDefault\\fondo.png"));
        jLabel2.setIcon(new ImageIcon("FondoDefault\\fondo.png"));
        jLabel3.setIcon(new ImageIcon("FondoDefault\\fondo.png"));
        jLabel4.setIcon(new ImageIcon("FondoDefault\\fondo.png"));
        jLabel5.setIcon(new ImageIcon("FondoDefault\\fondo.png"));
        jLabel6.setIcon(new ImageIcon("FondoDefault\\fondo.png"));
        jLabel7.setIcon(new ImageIcon("FondoDefault\\fondo.png"));
        jLabel8.setIcon(new ImageIcon("FondoDefault\\fondo.png"));
        jLabel9.setIcon(new ImageIcon("FondoDefault\\fondo.png"));
        jLabel10.setIcon(new ImageIcon("FondoDefault\\fondo.png"));
        jLabel11.setText("Jugador 1: 0 puntos");
        jLabel12.setText("Jugador 2: 0 puntos");
        for(int i=0;i<5;i++){
            contenedor[i]=-1;
        }
        for(int i=0;i<10;i++){
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
    
    /**Metodo que realiza todos los movimientos de las tarjetas*/
    private void jugada(int n){
        int i;
        switch(n){
            case 1:
                if(cartasocupadas[0]==0){
                    cartasocupadas[0]=1;
                    for(i=0;i<5;i++){
                        if(contenedor[i]==matriz[0][0]){
                            jLabel1.setIcon((Icon)guia.get(i));
                        }
                    }
                    JuegoFacil.j j1= juego1;
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
                    for(i=0;i<5;i++){
                        if(contenedor[i]==matriz[0][1]){
                            jLabel2.setIcon((Icon)guia.get(i));
                        }
                    }
                    JuegoFacil.j j1= juego1;
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
                for(i=0;i<5;i++){
                    if(contenedor[i]==matriz[0][2]){
                        jLabel3.setIcon((Icon)guia.get(i));
                    }
                }
                JuegoFacil.j j1= juego1;
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
                for(i=0;i<5;i++){
                    if(contenedor[i]==matriz[0][3]){
                        jLabel4.setIcon((Icon)guia.get(i));
                    }
                }
                JuegoFacil.j j1= juego1;
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
                for(i=0;i<5;i++){
                    if(contenedor[i]==matriz[0][4]){
                        jLabel5.setIcon((Icon)guia.get(i));
                    }
                }
                JuegoFacil.j j1= juego1;
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
                for(i=0;i<5;i++){
                    if(contenedor[i]==matriz[1][0]){
                        jLabel6.setIcon((Icon)guia.get(i));
                    }
                }
                JuegoFacil.j j1= juego1;
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
                for(i=0;i<5;i++){
                    if(contenedor[i]==matriz[1][1]){
                        jLabel7.setIcon((Icon)guia.get(i));
                    }
                }
                JuegoFacil.j j1= juego1;
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
                for(i=0;i<5;i++){
                    if(contenedor[i]==matriz[1][2]){
                        jLabel8.setIcon((Icon)guia.get(i));
                    }
                }
                JuegoFacil.j j1= juego1;
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
                for(i=0;i<5;i++){
                    if(contenedor[i]==matriz[1][3]){
                        jLabel9.setIcon((Icon)guia.get(i));
                    }
                }
                //
                JuegoFacil.j j1= juego1;
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
                for(i=0;i<5;i++){
                    if(contenedor[i]==matriz[1][4]){
                        jLabel10.setIcon((Icon)guia.get(i));
                    }
                }
                //
                JuegoFacil.j j1= juego1;
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
}
