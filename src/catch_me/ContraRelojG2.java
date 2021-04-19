package catch_me;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**Clase que funge como tablero del nivel medio*/
public class ContraRelojG2 extends JPanel implements Runnable{
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
    
    String medio1[] ={"FondoDefault\\1.png","FondoDefault\\2.png","FondoDefault\\3.png","FondoDefault\\4.png","FondoDefault\\5.png",
                      "FondoDefault\\6.png","FondoDefault\\7.png","FondoDefault\\8.png","FondoDefault\\9.png"};
    String mmedio1[][]=new String[3][6];
    int par[]= new int[2];
    //public JLabel auxiliar;
    //public JLabel aux1;
    // ContrarelojG.j juego1 = new j();
    private JLabel jLabel11 = new JLabel();
    //private JLabel jLabel12 = new JLabel();
    int seg=0,min=0;
    boolean ind=true;
    
    int x=0,y=0,x1=0,y1=0,sum=0;
    int cont=0,numCard=1;
    int pj;
    int cartAnterior=0;
    
    /**Clase Anonima*/
    Matriz a = new Matriz(){
        /**Metodo que inicializa la matriz asociada  en * */
        public void inicializar1(){
            for(int i=0;i<mmedio1.length;i++){
                for(int j=0;j<mmedio1[i].length;j++){
                    mmedio1[i][j]="*";
                }
            }
        }
        
        /**Metodo que inicializar la matriz asociada con muero aleatorios*/
        public void inicializar2(){
            int i=0;
            while(i<medio1.length){
                int n=(int)(r.nextDouble()*3);
                int n1=(int)(r.nextDouble()*6);
                int n2=(int)(r.nextDouble()*3);
                int n3=(int)(r.nextDouble()*6);
                String aux="",aux1="";
                aux=""+n+""+n1;
                aux1=""+n2+""+n3;
                if(mmedio1[n][n1].equals("*")==true && mmedio1[n2][n3].equals("*")==true && aux.equals(aux1)==false){
                    mmedio1[n][n1]=medio1[i];
                    mmedio1[n2][n3]=medio1[i];
                    i++;
                }
            }
            
        }
    };
    
    private JLabel jLabel13 = new JLabel();
    int fnd;
    public JLabel aux;
    Thread r1;
    boolean juego=true;
    private JLabel jLabel1 = new JLabel();


    /**Clase interna que realiza las comprobacion de cada jugada realizada ademas de llevar el control de los turnos*/
    

    /**Constructor de la clase Principal*/
    public ContraRelojG2(int s,int m, JLabel salir,int f) {
        try {
            //auxiliar=aux;
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
        this.setSize(new Dimension(713, 398));
        label1.setBounds(new Rectangle(20, 50, 100, 100));
        label1.setBorder(BorderFactory.createLineBorder(Color.black, 1));
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
        
       /* auxiliar.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    //remover(e);
                }
            });*/

        jLabel11.setText("Jugador: 0 puntos");
        jLabel11.setBounds(new Rectangle(25, 10, 130, 25));
        jLabel11.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        
        /*jLabel12.setText("Jugador 2: 0 puntos");
        jLabel12.setBounds(new Rectangle(545, 5, 125, 25));
        jLabel12.setBorder(BorderFactory.createLineBorder(Color.black, 1));*/


        jLabel13.setText("Reloj "+min+":"+seg);
        jLabel13.setBounds(new Rectangle(615, 10, 75, 25));
        jLabel13.setFont(new Font("Arial",1,12));


        jLabel1.setBounds(new Rectangle(250, 10, 285, 30));
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setHorizontalTextPosition(SwingConstants.CENTER);
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
        
        aux.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    remover(e);
                }
            });

        this.add(jLabel1, null);
        this.add(label18, null);
        this.add(label17, null);
        this.add(label16, null);
        this.add(label15, null);
        this.add(label14, null);
        this.add(label13, null);
        this.add(label12, null);
        this.add(label11, null);
        //this.add(jLabel12, null);
        this.add(jLabel13, null);
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
                x=0;
                y=5;
               break;
            case 7:
                x=1;
                y=0;
                break;
            case 8:
                x=1;
                y=1;
                break;
            case 9:
                x=1;
                y=2;
                break;
            case 10:
                x=1;
                y=3;
                break;
            case 11:
                x=1;
                y=4;
                break;
            case 12:
                x=1;
                y=5;
                break;
            case 13:
                x=2;
                y=0;
                break;
            case 14:
                x=2;
                y=1;
                break;
            case 15:
                x=2;
                y=2;
                break;
            case 16:
                x=2;
                y=3;
                break;
            case 17:
                x=2;
                y=4;
                break;
            case 18:
                x=2;
                y=5;
                break;
            }
            if(levantar(x,y,numLabel)==false){
                numCard=1;
            }
            else{
                ind=comprobar(x,y);
                if(ind==false && numCard==2){
                   par[cont]=numLabel;
                    jLabel1.setForeground(new Color(211, 0, 0));
                    jLabel1.setText("No son par");
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
        if(cartAnterior!=label){
            switch(label){
            case 1:
                    label1.setIcon(new ImageIcon(mmedio1[x][y]));
                    cartAnterior=1;
                break;
            case 2:
                label2.setIcon(new ImageIcon(mmedio1[x][y]));
                cartAnterior=2;
                break;
            case 3:
                label3.setIcon(new ImageIcon(mmedio1[x][y]));
                cartAnterior=3;
                break;
            case 4:
                label4.setIcon(new ImageIcon(mmedio1[x][y]));
                cartAnterior=4;
                break;
            case 5:
                label5.setIcon(new ImageIcon(mmedio1[x][y]));
                cartAnterior=5;
                break;
            case 6:
                label6.setIcon(new ImageIcon(mmedio1[x][y]));
                cartAnterior=6;
                break;
            case 7:
                label7.setIcon(new ImageIcon(mmedio1[x][y]));
                cartAnterior=7;
                break;
            case 8:
                label8.setIcon(new ImageIcon(mmedio1[x][y]));
                cartAnterior=8;
                break;
            case 9:
                label9.setIcon(new ImageIcon(mmedio1[x][y]));
                cartAnterior=9;
                break;
            case 10:
                label10.setIcon(new ImageIcon(mmedio1[x][y]));
                cartAnterior=10;
                break;
            case 11:
                label11.setIcon(new ImageIcon(mmedio1[x][y]));
                cartAnterior=11;
                break;
            case 12:
                label12.setIcon(new ImageIcon(mmedio1[x][y]));
                cartAnterior=12;
                break;
            case 13:
                label13.setIcon(new ImageIcon(mmedio1[x][y]));
                cartAnterior=13;
                break;
            case 14:
                label14.setIcon(new ImageIcon(mmedio1[x][y]));
                cartAnterior=14;
                break;
            case 15:
                label15.setIcon(new ImageIcon(mmedio1[x][y]));
                cartAnterior=15;
                break;
            case 16:
                label16.setIcon(new ImageIcon(mmedio1[x][y]));
                cartAnterior=16;
                break;
            case 17:
                label17.setIcon(new ImageIcon(mmedio1[x][y]));
                cartAnterior=17;
                break;
            case 18:
                label18.setIcon(new ImageIcon(mmedio1[x][y]));
                cartAnterior=18;
                break;
            }
        }
        else{
            ind=false;
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
            if(mmedio1[this.x][this.y].equals(mmedio1[this.x1][this.y1])==true ){
                jLabel1.setForeground(new Color(0, 66, 198));
                jLabel1.setText("Encontro un par");
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
                label1.setIcon(new ImageIcon(fondo));
                break;
            case 2:
                label2.setIcon(new ImageIcon(fondo));
                break;
            case 3:
                label3.setIcon(new ImageIcon(fondo));
                break;
            case 4:
                label4.setIcon(new ImageIcon(fondo));
                break;
            case 5:
                label5.setIcon(new ImageIcon(fondo));
                break;
            case 6:
                label6.setIcon(new ImageIcon(fondo));
            break;
            case 7:
                label7.setIcon(new ImageIcon(fondo));
                break;
            case 8:
                label8.setIcon(new ImageIcon(fondo));
                break;
            case 9:
                label9.setIcon(new ImageIcon(fondo));
                break;
            case 10:
                label10.setIcon(new ImageIcon(fondo));
                break;
            case 11:
                label11.setIcon(new ImageIcon(fondo));
                break;
            case 12:
                label12.setIcon(new ImageIcon(fondo));
                break;
            case 13:
                label13.setIcon(new ImageIcon(fondo));
                break;
            case 14:
                label14.setIcon(new ImageIcon(fondo));
                break;
            case 15:
                label15.setIcon(new ImageIcon(fondo));
                break;
            case 16:
                label16.setIcon(new ImageIcon(fondo));
                break;
            case 17:
                label17.setIcon(new ImageIcon(fondo));
                break;
            case 18:
                label18.setIcon(new ImageIcon(fondo));
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
         return res;
     }
     
    /**Metodo que inicializa el reloj*/
        public void initReloj(){
            r1 = new Thread(this,"Reloj");
            r1.start();
        }
    /*
     public static void main(String []arg){
         ContraRelojG2 a = new ContraRelojG2(59,0);
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
        if(isCompleto()==true){
            JOptionPane.showMessageDialog(this,"Ha Ganado La Partida","Exito",JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(this,"Ha Perdido La Partida","Fallo",JOptionPane.ERROR_MESSAGE);
            label1.setIcon(new ImageIcon(mmedio1[0][0]));
            label2.setIcon(new ImageIcon(mmedio1[0][1]));
            label3.setIcon(new ImageIcon(mmedio1[0][2]));
            label4.setIcon(new ImageIcon(mmedio1[0][3]));
            label5.setIcon(new ImageIcon(mmedio1[0][4]));
            label6.setIcon(new ImageIcon(mmedio1[0][5]));
            label7.setIcon(new ImageIcon(mmedio1[1][0]));
            label8.setIcon(new ImageIcon(mmedio1[1][1]));
            label9.setIcon(new ImageIcon(mmedio1[1][2]));
            label10.setIcon(new ImageIcon(mmedio1[1][3]));
            label11.setIcon(new ImageIcon(mmedio1[1][4]));
            label12.setIcon(new ImageIcon(mmedio1[1][5]));
        }
        }
    
    private void remover(MouseEvent e){
        juego=false;
    }
    
    void cargar(){
        if(fnd==0){
            String medio[] ={"FondoDefault\\1.png","FondoDefault\\2.png","FondoDefault\\3.png","FondoDefault\\4.png","FondoDefault\\5.png",
                      "FondoDefault\\6.png","FondoDefault\\7.png","FondoDefault\\8.png","FondoDefault\\9.png"};
            medio1=medio;
        }
        if(fnd==1){
            String medio[] ={"Carros\\1.png","Carros\\2.png","Carros\\3.png","Carros\\4.png","Carros\\5.png",
                             "Carros\\6.png","Carros\\7.png","Carros\\8.png","Carros\\9.png"};
            medio1=medio;
        }
        if(fnd==2){
            String medio[] ={"ResidentEvil\\1.png","ResidentEvil\\2.png","ResidentEvil\\3.png","ResidentEvil\\4.png","ResidentEvil\\5.png",
                             "ResidentEvil\\6.png","ResidentEvil\\7.png","ResidentEvil\\8.png","ResidentEvil\\9.png"};
            medio1=medio;
        }
        if(fnd==3){
            String medio[] ={"Perros\\1.png","Perros\\2.png","Perros\\3.png","Perros\\4.png","Perros\\5.png",
                             "Perros\\6.png","Perros\\7.png","Perros\\8.png","Perros\\9.png"};
            medio1=medio;
        }
    }    
}

