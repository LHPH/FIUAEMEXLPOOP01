package catch_me;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
public class VrComputadoraG extends JPanel implements Runnable {
    final String fondo="FondoDefault\\fondo.png";
    final VrComputadoraG ventana= this;
    private JLabel jLabel1 = new JLabel(new ImageIcon(fondo));
    private JLabel jLabel2 = new JLabel(new ImageIcon("FondoDefault\\fondo.png"));
    private JLabel jLabel3 = new JLabel(new ImageIcon("FondoDefault\\fondo.png"));
    private JLabel jLabel4 = new JLabel(new ImageIcon("FondoDefault\\fondo.png"));
    private JLabel jLabel5 = new JLabel(new ImageIcon("FondoDefault\\fondo.png"));
    private JLabel jLabel6 = new JLabel(new ImageIcon("FondoDefault\\fondo.png"));
    private JLabel jLabel7 = new JLabel(new ImageIcon("FondoDefault\\fondo.png"));
    private JLabel jLabel8 = new JLabel(new ImageIcon("FondoDefault\\fondo.png"));
    private JLabel jLabel9 = new JLabel(new ImageIcon("FondoDefault\\fondo.png"));
    private JLabel jLabel10 = new JLabel(new ImageIcon("FondoDefault\\fondo.png"));
    String facil1[] ={"FondoDefault\\1.png","FondoDefault\\2.png","FondoDefault\\3.png","FondoDefault\\4.png","FondoDefault\\5.png"};
    String mfacil1[][]=new String[2][5];
    int matriz [][]=new int[2][5];
    int comp []= {0,0,0,0,0,0,0,0,0,0};
    int par[]= new int[2];
    int par2[]=new int[2];
    /**Referencia a la clase interna*/
   // ContrarelojG.j juego1 = new j();
    private JLabel jLabel11 = new JLabel();
    private JLabel jLabel12 = new JLabel();
    Random r = new Random(new Date().getTime());
    boolean ind=true;
    boolean Usuario=true;
    boolean Comput=false;
    
    int x=0,y=0,x1=0,y1=0,sum=0;
    int cont=0,numCard=1,numCard2=1;
    int pj,pc;
    int cartAnterior=0;
    
    Matriz a = new Matriz(){
        public void inicializar1(){
            for(int i=0;i<mfacil1.length;i++){
                for(int j=0;j<mfacil1[i].length;j++){
                    mfacil1[i][j]="*";
                }
            }
        }
        
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
    private JLabel jLabel14 = new JLabel();
    int fnd;

    /**Constructor de la clase Principal*/
    public VrComputadoraG(int f) {
        try {
            fnd=f;
            cargar();
            a.inicializar1();
            a.inicializar2();
            jbInit();
            this.initHilo();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**Metodo que inicializa los componentes graficos*/
    private void jbInit() throws Exception {
        this.setLayout( null );
        this.setSize(new Dimension(608, 278));
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
        

        jLabel11.setText("Jugador: 0 puntos");
        jLabel11.setBounds(new Rectangle(5, 10, 130, 25));
        jLabel11.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        
        jLabel12.setText("Computadora: 0 puntos");
        jLabel12.setBounds(new Rectangle(380, 10, 220, 25));
        jLabel12.setBorder(BorderFactory.createLineBorder(Color.black, 1));


        jLabel12.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel12.setHorizontalTextPosition(SwingConstants.CENTER);
        jLabel14.setBounds(new Rectangle(155, 10, 215, 25));
        jLabel14.setHorizontalTextPosition(SwingConstants.CENTER);
        jLabel14.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(jLabel14, null);
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
    
    /**metodo que inicia un hilo el cual determinara el jugador que ha ganado la partida
     * una vez que todas las cartas esten desbloqueadas*/
        
    public void initHilo(){
        Thread hilo = new Thread(this,"VrComputadora");
        hilo.start();
    }
    
    /**Metodo jugada
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
                if(ind==false && numCard==2){
                   par[cont]=numLabel;
                    jLabel14.setForeground(new Color(211, 0, 0));
                    jLabel14.setText("No son par");
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
                   this.Comput=true;
                   
                }else{
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
            }
            if(this.Comput==true){
                    boolean rep=false;
                        do{
                            
                                rep=jugada2(1);
                        }while(rep==true);
                        do{
                                rep=jugada2(2);
                        }while(rep==true);
                        this.Comput=false;
            }
}
   
   /**metodo jugada2 en nivel facil
    * en el cual la computadora escogera su carta en la etiqueta correspondiente*/ 
    public boolean jugada2(int car){
        boolean ind=false;
        boolean rep=false;
        int x=-1,y=-1;
         int numLabel = (int)(r.nextDouble()*10)+1;
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
            numCard2=1;
            rep=true;
        }
        else{
            rep=false;
            if(car==2 && numCard2==1){
                numCard2=2;
            }
            ind=comprobar(x,y);
            if(ind==false && numCard2==2){
               par2[cont]=numLabel;
               //JOptionPane.showMessageDialog(this, "No es Par","Buena Suerte",JOptionPane.INFORMATION_MESSAGE);
               Runnable run = new Runnable(){

                    @Override
                    public void run() {
                        try{
                            ventana.setEnabled(false);
                            Thread.sleep(1000);
                            ocultar(par2[0]);
                            ocultar(par2[1]);
                               numCard2=1;
                               par2[0]=0;
                               par2[1]=0;
                               cont=0;
                            ventana.setEnabled(true);
                        } catch (InterruptedException e) {
                        }
                    }
                };
               Thread hilo2 = new Thread(run);
               hilo2.start();
                   
            }else{
                    if(cont==1){
                        cont=0;
                    }
                    par2[cont]=numLabel;
                    cont++;
                    if(numCard2==2){
                        numCard2=1;
                    }else{
                        numCard2++;
                    }   
            }
        }  
        return rep;
    }
    
    
    /**metodo levantar en el que se pondra en la etiqueta correspondiente
     * la imagen asociada a ella*/ 
    public boolean levantar(int x,int y,int label){
        boolean ind=true;
        switch(label){
        case 1:
            if(comp[0]!=1){
                jLabel1.setIcon(new ImageIcon(mfacil1[x][y]));
                cartAnterior=1;
                comp[0]=1;
            }
            else{
                ind=false;
            }
            break;
        case 2:
            if( comp[1]!=1){
                jLabel2.setIcon(new ImageIcon(mfacil1[x][y]));
                cartAnterior=2;
                comp[1]=1;
            }
            else{
                ind=false;
            }
            break;
        case 3:
            if( comp[2]!=1){
                jLabel3.setIcon(new ImageIcon(mfacil1[x][y]));
                cartAnterior=3;
                comp[2]=1;
            }
            else{
                ind=false;
            }
            break;
        case 4:
            if( comp[3]!=1){
                jLabel4.setIcon(new ImageIcon(mfacil1[x][y]));
                cartAnterior=4;
                comp[3]=1;
            }       
            else{
                ind=false;
            }
            break;
        case 5:
            if( comp[4]!=1){
                jLabel5.setIcon(new ImageIcon(mfacil1[x][y]));
                cartAnterior=5;
                comp[4]=1;
            }
            else{
                ind=false;
            }
            break;
        case 6:
            if( comp[5]!=1){
                jLabel6.setIcon(new ImageIcon(mfacil1[x][y]));
                cartAnterior=6;
                comp[5]=1;
            }
            else{
                ind=false;
            }
            break;
        case 7:
            if( comp[6]!=1){
                jLabel7.setIcon(new ImageIcon(mfacil1[x][y]));
                cartAnterior=7;
                comp[6]=1;
            }
            else{
                ind=false;
            }
            break;
        case 8:
            if( comp[7]!=1){
                jLabel8.setIcon(new ImageIcon(mfacil1[x][y]));
                cartAnterior=8;
                comp[7]=1;
            }
            else{
                ind=false;
            }
            break;
        case 9:
            if( comp[8]!=1){
                jLabel9.setIcon(new ImageIcon(mfacil1[x][y]));
                cartAnterior=9;
                comp[8]=1;
            }
            else{
                ind=false;
            }
            break;
        case 10:
            if( comp[9]!=1){
                jLabel10.setIcon(new ImageIcon(mfacil1[x][y]));
                cartAnterior=10;
                comp[9]=1;
            }
            else{
                ind=false;
            }
            break;
        }
        return ind;
    }
    
    /**metodo comprobar en el que se verificara si los dos pares levantados
     * son pares o no lo son*/
    public boolean comprobar(int x,int y){
        boolean ind=true;
        if(numCard!=2 && numCard2!=2){
            this.x=x;
            this.y=y;
            ind=true;
        }
        else{
            this.x1=x;
            this.y1=y;
            if(mfacil1[this.x][this.y].equals(mfacil1[this.x1][this.y1])==true ){
                if(this.Comput==false){
                    jLabel14.setForeground(new Color(0, 66, 198));
                    jLabel14.setText("Encontro un par");
                    pj++; 
                    jLabel11.setText("Jugador: "+pj+" puntos");
                    this.Comput=true;
                   
                }
                else{
                    pc++;
                    jLabel14.setForeground(new Color(0, 66, 198));
                    jLabel14.setText("La Computadora Encontro un par");
                    jLabel12.setText("Computadora: "+pc+" puntos");
                    this.Comput=false;
                   
                }
                sum++;
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
         
    /** metodo ocultar en el que se ocultara la carta en la etiqueta correspondiente
     * sustituyendo la imagen por una imagen default*/             
     public void ocultar(int numLabel){
            switch(numLabel){
            case 1:
                jLabel1.setIcon(new ImageIcon(fondo));
                comp[0]=0;
                break;
            case 2:
                jLabel2.setIcon(new ImageIcon(fondo));
                comp[1]=0;
                break;
            case 3:
                jLabel3.setIcon(new ImageIcon(fondo));
                comp[2]=0;
                break;
            case 4:
                jLabel4.setIcon(new ImageIcon(fondo));
                comp[3]=0;
                break;
            case 5:
                jLabel5.setIcon(new ImageIcon(fondo));
                comp[4]=0;
                break;
            case 6:
                jLabel6.setIcon(new ImageIcon(fondo));
                comp[5]=0;
            break;
            case 7:
                jLabel7.setIcon(new ImageIcon(fondo));
                comp[6]=0;
                break;
            case 8:
                jLabel8.setIcon(new ImageIcon(fondo));
                comp[7]=0;
                break;
            case 9:
                jLabel9.setIcon(new ImageIcon(fondo));
                comp[8]=0;
                break;
            case 10:
                jLabel10.setIcon(new ImageIcon(fondo));
                comp[9]=0;
                break;
            }
        }
     
    /**metodo que dira si todos los pares han sido levantados
     * regresa false si no
     * regresa true si todos los pares han sido levantados*/  
     public boolean isCompleto(){
         boolean res=false;
         if(sum==5){
             res=true;
         }
         else{
             res=false;
         }
         return res;
     }
     
    
     public static void main(String []arg){
         //VrComputadoraG a = new VrComputadoraG();
         //a.setVisible(true);
     }

    /**metodo run sobreescrito de la interfaz runnable y cuerpo del hilo en el que
     * verificara si todos los pares han sido levantados y una vez levantados todos
     * dira quien es el jugador ganador*/
    @Override
    public void run() {
        while(isCompleto()==false){
                 
        }
        if(pj>pc){
            JOptionPane.showMessageDialog(this,"Ha Ganado La Partida","Exito",JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(this,"Ha Perdido La Partida","Fallo",JOptionPane.ERROR_MESSAGE);   
        }
        
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
