 package catch_me;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Random;

import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


/**Clase que funge como tablero del nivel facil*/
public class ContraRelojG extends JPanel implements Runnable {
    final String fondo="FondoDefault\\fondo.png";
    private JLabel jLabel1 = new JLabel(new ImageIcon(fondo));
    private JLabel jLabel2 = new JLabel(new ImageIcon("FondoDefault\\fondo.png"));
    private JLabel jLabel3 = new JLabel(new ImageIcon("FondoDefault\\fondo.png"));
    private JLabel jLabel4 = new JLabel(new ImageIcon("FondoDefault\\fondo.png"));
    private JLabel jLabel5 = new JLabel(new ImageIcon("FondoDefault\\fondo.png"));
    private JLabel jLabel6 =  new JLabel(new ImageIcon("FondoDefault\\fondo.png"));
    private JLabel jLabel7 = new JLabel(new ImageIcon("FondoDefault\\fondo.png"));
    private JLabel jLabel8 = new JLabel(new ImageIcon("FondoDefault\\fondo.png"));
    private JLabel jLabel9 = new JLabel(new ImageIcon("FondoDefault\\fondo.png"));
    private JLabel jLabel10 = new JLabel(new ImageIcon("FondoDefault\\fondo.png"));
    String facil1[] ={"FondoDefault\\1.png","FondoDefault\\2.png","FondoDefault\\3.png","FondoDefault\\4.png","FondoDefault\\5.png"};
    String mfacil1[][]=new String[2][5];
    int matriz [][]=new int[2][5];
    int par[]= new int[2];
    //public JLabel auxiliar;
    //public JLabel aux1;
    /**Referencia a la clase interna*/
   // ContrarelojG.j juego1 = new j();
    private JLabel jLabel11 = new JLabel();
    //private JLabel jLabel12 = new JLabel();
    int seg=0,min=0;
    boolean ind=true;
    
    int x=0,y=0,x1=0,y1=0,sum=0;
    int cont=0,numCard=1;
    int pj;
    int cartAnterior=0;
    public JLabel aux;
    Thread r1;
    boolean juego=true;
    int fnd;
    
    /**Clase Anonima*/
    Matriz a = new Matriz(){
        /**Metodo que inicializa la matriz asociada  en * */
        public void inicializar1(){
            for(int i=0;i<mfacil1.length;i++){
                for(int j=0;j<mfacil1[i].length;j++){
                    mfacil1[i][j]="*";
                }
            }
        }
        
        /**Metodo que inicializar la matriz asociada con muero aleatorios*/
        public void inicializar2(){
            int i=0;
            while(i<facil1.length){
                int n=(int)(r.nextDouble()*2);
                int n1=(int)(r.nextDouble()*5);
                int n2=(int)(r.nextDouble()*2);
                int n3=(int)(r.nextDouble()*5);
                String aux="",aux1="";
                aux=""+n+""+n1;
                aux1=""+n2+""+n3;
                if(mfacil1[n][n1].equals("*")==true && mfacil1[n2][n3].equals("*")==true && aux.equals(aux1)==false){
                    mfacil1[n][n1]=facil1[i];
                    mfacil1[n2][n3]=facil1[i];
                    i++;
                }
            }
            
        }
    };
    private JLabel jLabel13 = new JLabel();
    private JLabel jLabel12 = new JLabel();


    /**Constructor de la clase Principal*/
    public ContraRelojG(int s,int m, JLabel salir,int f) {
        try {
           // auxiliar=aux;
            //aux1=au;
            aux=salir;
            fnd=f;
            juego=true;
            cargar();
            a.inicializar1();
            a.inicializar2();
            seg=s;
            min=m;
            jbInit();
            this.initReloj();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**Metodo que inicializa los componentes graficos*/
    private void jbInit() throws Exception {
        this.setLayout( null );
        this.setSize(new Dimension(598, 274));
        jLabel1.setBounds(new Rectangle(5, 45, 100, 100));
        jLabel1.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        jLabel1.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    jugada(1);
                }
            });
        jLabel2.setBounds(new Rectangle(130, 45, 100, 100));
        jLabel2.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        jLabel2.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    jugada(2);
                }
            });
        jLabel3.setBounds(new Rectangle(250, 45, 100, 100));
        jLabel3.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        jLabel3.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    jugada(3);
                }
            });
        jLabel4.setBounds(new Rectangle(370, 45, 100, 100));
        jLabel4.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        jLabel4.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    jugada(4);
                }
            });
        jLabel5.setBounds(new Rectangle(490, 45, 100, 100));
        jLabel5.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        jLabel5.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    jugada(5);
                }
            });
        jLabel6.setBounds(new Rectangle(5, 160, 100, 100));
        jLabel6.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        jLabel6.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    jugada(6);
                }
            });
        jLabel7.setBounds(new Rectangle(130, 160, 100, 100));
        jLabel7.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        jLabel7.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    jugada(7);
                }
            });
        jLabel8.setBounds(new Rectangle(250, 160, 100, 100));
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
        jLabel10.setBounds(new Rectangle(490, 160, 100, 100));
        jLabel10.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        jLabel10.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    jugada(10);
                }
            });
        
        aux.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    remover(e);
                }
            });

        jLabel11.setText("Jugador: 0 puntos");
        jLabel11.setBounds(new Rectangle(25, 10, 130, 25));
        jLabel11.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        
      /*  jLabel12.setText("Jugador 2: 0 puntos");
        jLabel12.setBounds(new Rectangle(425, 5, 125, 25));
        jLabel12.setBorder(BorderFactory.createLineBorder(Color.black, 1));*/


        jLabel13.setText("Reloj "+min+":"+seg);
        jLabel13.setBounds(new Rectangle(480, 10, 70, 25));
        jLabel13.setFont(new Font("Arial",1,12));
        //this.add(jLabel12, null);
        jLabel12.setBounds(new Rectangle(185, 10, 270, 25));
        jLabel12.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel12.setHorizontalTextPosition(SwingConstants.CENTER);
        this.add(jLabel12, null);
        this.add(jLabel13, null);
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
        
    
    /**Metodo usuario
     * en el cual se llevara a cabo sobre el turno en el cual el usuario escogera su par de cartas
     * */
    
    public void jugada(int numLabel){
        int x=-1,y=-1;
        boolean ind=false;
            switch(numLabel){
            case 1:
                x=0;
                y=0;
                break;
            case 2:
                x=0;
                y=1;
                break;
            case 3:
                x=0;
                y=2;
                break;
            case 4:
                x=0;
                y=3;
                break;
            case 5:
                x=0;
                y=4;
                break;
            case 6:
                x=1;
                y=0;
               break;
            case 7:
                x=1;
                y=1;
                break;
            case 8:
                x=1;
                y=2;
                break;
            case 9:
                x=1;
                y=3;
                break;
            case 10:
                x=1;
                y=4;
                break;
            }
            if(levantar(x,y,numLabel)==false){
                numCard=1;
            }
            else{
                ind=comprobar(x,y);
                System.out.println(numCard);
                if(ind==false && numCard==2){
                   par[cont]=numLabel;
                    jLabel12.setForeground(new Color(211, 0, 0));
                    jLabel12.setText("No son par");
                    JOptionPane.showMessageDialog(null, "No son par", "Lo Sentimos",JOptionPane.ERROR_MESSAGE); 
                    try {
                    Thread.sleep(500);
                    } catch (InterruptedException ex) {
                    // aquí tratamos la excepción como queramos, haciendo nada, sacando por pantalla el error, ...
                    }
                    ocultar(par[0]);
                    ocultar(par[1]);
                   numCard=1;
                   par[0]=0;
                   par[1]=0;
                   cont=0;
                }else{
                    if(isCompleto()==false){
                        if(cont==1){
                            cont=0;
                        }
                        par[cont]=numLabel;
                        cont++;
                        if(numCard==2){
                            numCard=1;
                        }else{
                            numCard++;
                        } 
                    }
                    else{
                        JOptionPane.showMessageDialog(this,"Completo la Partida","Exito",JOptionPane.INFORMATION_MESSAGE);
                    }
                        
                }
            }
        }
    
    /**Gira la carta mostrando su valor y regresa un booleano si no se levanta la misma carta*/
    public boolean levantar(int x,int y,int label){
        boolean ind=true;
        switch(label){
        case 1:
            if(cartAnterior!=1){
                jLabel1.setIcon(new ImageIcon(mfacil1[x][y]));
                cartAnterior=1;
            }
            else{
                ind=false;
            }
            break;
        case 2:
            if(cartAnterior!=2){
                jLabel2.setIcon(new ImageIcon(mfacil1[x][y]));
                cartAnterior=2;
            }
            else{
                ind=false;
            }
            break;
        case 3:
            if(cartAnterior!=3){
                jLabel3.setIcon(new ImageIcon(mfacil1[x][y]));
                cartAnterior=3;
            }
            else{
                ind=false;
            }
            break;
        case 4:
            if(cartAnterior!=4){
                jLabel4.setIcon(new ImageIcon(mfacil1[x][y]));
                cartAnterior=4;
            }
            else{
                ind=false;
            }
            break;
        case 5:
            if(cartAnterior!=5){
                jLabel5.setIcon(new ImageIcon(mfacil1[x][y]));
                cartAnterior=5;
            }
            else{
                ind=false;
            }
            break;
        case 6:
            if(cartAnterior!=6){
                jLabel6.setIcon(new ImageIcon(mfacil1[x][y]));
                cartAnterior=6;
            }
            else{
                ind=false;
            }
            break;
        case 7:
            if(cartAnterior!=7){
                jLabel7.setIcon(new ImageIcon(mfacil1[x][y]));
                cartAnterior=7;
            }
            else{
                ind=false;
            }
            break;
        case 8:
            if(cartAnterior!=8){
                jLabel8.setIcon(new ImageIcon(mfacil1[x][y]));
                cartAnterior=8;
            }
            else{
                ind=false;
            }
            break;
        case 9:
            if(cartAnterior!=9){
                jLabel9.setIcon(new ImageIcon(mfacil1[x][y]));
                cartAnterior=9;
            }
            else{
                ind=false;
            }
            break;
        case 10:
            if(cartAnterior!=10){
                jLabel10.setIcon(new ImageIcon(mfacil1[x][y]));
                cartAnterior=10;
            }
            else{
                ind=false;
            }
            break;
        }
        return ind;
    }
    
    /**Comprueba la jugada realizada*/
    public boolean comprobar(int x,int y){
        boolean ind=true;
        if(numCard!=2){
            this.x=x;
            this.y=y;
            ind=true;
        }
        else{
            this.x1=x;
            this.y1=y;
            if(mfacil1[this.x][this.y].equals(mfacil1[this.x1][this.y1])==true ){
                jLabel12.setForeground(new Color(0, 66, 198));
                jLabel12.setText("Encontro un par");
                pj++;
                sum++;
                jLabel11.setText("Jugador: "+pj+" puntos");
                this.x=0;
                this.x1=0;
                this.y=0;
                this.y1=0;
                ind=true;
               
            }
            else{
                this.x=0;
                this.x1=0;
                this.y=0;
                this.y1=0;
                ind=false;
            }
        }
        return ind;
    }
                    
    /**Oculta el valor de la carta*/
     public void ocultar(int numLabel){
            switch(numLabel){
            case 1:
                jLabel1.setIcon(new ImageIcon(fondo));
                break;
            case 2:
                jLabel2.setIcon(new ImageIcon(fondo));
                break;
            case 3:
                jLabel3.setIcon(new ImageIcon(fondo));
                break;
            case 4:
                jLabel4.setIcon(new ImageIcon(fondo));
                break;
            case 5:
                jLabel5.setIcon(new ImageIcon(fondo));
                break;
            case 6:
                jLabel6.setIcon(new ImageIcon(fondo));
            break;
            case 7:
                jLabel7.setIcon(new ImageIcon(fondo));
                break;
            case 8:
                jLabel8.setIcon(new ImageIcon(fondo));
                break;
            case 9:
                jLabel9.setIcon(new ImageIcon(fondo));
                break;
            case 10:
                jLabel10.setIcon(new ImageIcon(fondo));
                break;
            }
        }
     
     /**Metodo que comprueba si el juego esta acabado*/
     public boolean isCompleto(){
         boolean res=false;
         if(sum==10 && ind==true){
             res=true;
         }
         else{
             res=false;
         }
         System.out.println(sum);
         return res;
     }
     
     /**Metodo que inicializa el reloj*/
        public void initReloj(){
            r1 = new Thread(this,"Reloj");
            r1.start();
        }
    
  /*   public static void main(String []arg){
         ContraRelojG a = new ContraRelojG(59,0,null);
         a.setVisible(true);
     }*/

    /**Metodo que inicia la interfaz runneable*/
    @Override
    public void run() {
        while(ind==true && isCompleto()==false){
            try {
                Thread.sleep(1000);
                //System.out.println(min+":"+seg);
                seg--;
                if(seg==0 && min!=0){
                    min--;
                    seg=60;
                }
                if(seg==0 && min==0){
                    ind=false;
                }
                if(juego==false){
                    throw new InterruptedException();
                }
                jLabel13.setText("Reloj "+min+":"+seg);
            } catch (InterruptedException e) {
                
            }
        }
        if(juego==true){
            if(isCompleto()==true){
                JOptionPane.showMessageDialog(this,"Ha Ganado La Partida","Exito",JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(this,"Ha Perdido La Partida","Fallo",JOptionPane.ERROR_MESSAGE); 
                jLabel1.setIcon(new ImageIcon(mfacil1[0][0]));
                jLabel2.setIcon(new ImageIcon(mfacil1[0][1]));
                jLabel3.setIcon(new ImageIcon(mfacil1[0][2]));
                jLabel4.setIcon(new ImageIcon(mfacil1[0][3]));
                jLabel5.setIcon(new ImageIcon(mfacil1[0][4]));
                jLabel6.setIcon(new ImageIcon(mfacil1[1][0]));
                jLabel7.setIcon(new ImageIcon(mfacil1[1][1]));
                jLabel8.setIcon(new ImageIcon(mfacil1[1][2]));
                jLabel9.setIcon(new ImageIcon(mfacil1[1][3]));
                jLabel10.setIcon(new ImageIcon(mfacil1[1][4]));
            }
            
        }
        }
    
    private void remover(MouseEvent e){
        juego=false;
    }
    
    void cargar(){
        if(fnd==0){
            String facil[] ={"FondoDefault\\1.png","FondoDefault\\2.png","FondoDefault\\3.png","FondoDefault\\4.png","FondoDefault\\5.png"};
            facil1=facil;
        }
        if(fnd==1){
            String facil[] ={"Carros\\1.png","Carros\\2.png","Carros\\3.png","Carros\\4.png","Carros\\5.png"};
            facil1=facil;
        }
        if(fnd==2){
            String facil[] ={"ResidentEvil\\1.png","ResidentEvil\\2.png","ResidentEvil\\3.png","ResidentEvil\\4.png","ResidentEvil\\5.png"};
            facil1=facil;
            
        }
        if(fnd==3){
            String facil[] ={"Perros\\1.png","Perros\\2.png","Perros\\3.png","Perros\\4.png","Perros\\5.png"};
            facil1=facil;
        }
    }

}
