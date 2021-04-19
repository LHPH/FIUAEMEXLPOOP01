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
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class VrComputadoraG3 extends JPanel implements Runnable{
    VrComputadoraG3 ventana=this;
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
    private JLabel label19 = new JLabel(new ImageIcon(fondo));
    private JLabel label20 = new JLabel(new ImageIcon(fondo));
    private JLabel label21 = new JLabel(new ImageIcon(fondo));
    private JLabel label22 = new JLabel(new ImageIcon(fondo));
    private JLabel label23 = new JLabel(new ImageIcon(fondo));
    private JLabel label24 = new JLabel(new ImageIcon(fondo));
    private JLabel label25 = new JLabel(new ImageIcon(fondo));
    private JLabel label26 = new JLabel(new ImageIcon(fondo));
    private JLabel label27 = new JLabel(new ImageIcon(fondo));
    private JLabel label28 = new JLabel(new ImageIcon(fondo));
    
    String dificil1[] ={"FondoDefault\\1.png","FondoDefault\\2.png","FondoDefault\\3.png","FondoDefault\\4.png","FondoDefault\\5.png",
                      "FondoDefault\\6.png","FondoDefault\\7.png","FondoDefault\\8.png","FondoDefault\\9.png","FondoDefault\\10.png",
                        "FondoDefault\\11.png","FondoDefault\\12.png","FondoDefault\\13.png","FondoDefault\\14.png"};
    String mdificil1[][]=new String[4][7];
    int par[]= new int[2];
    int par2[] = new int[2];
    int comp[]={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

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
            for(int i=0;i<mdificil1.length;i++){
                for(int j=0;j<mdificil1[i].length;j++){
                    mdificil1[i][j]="*";
                }
            }
        }
        
        public void inicializar2(){
            int i=0;
            while(i<dificil1.length){
                int n=(int)(r.nextDouble()*4);
                int n1=(int)(r.nextDouble()*7);
                int n2=(int)(r.nextDouble()*4);
                int n3=(int)(r.nextDouble()*7);
                String aux="",aux1="";
                aux=""+n+""+n1;
                aux1=""+n2+""+n3;
                if(mdificil1[n][n1].equals("*")==true && mdificil1[n2][n3].equals("*")==true && aux.equals(aux1)==false){
                    mdificil1[n][n1]=dificil1[i];
                    mdificil1[n2][n3]=dificil1[i];
                    i++;
                }
            }
            
        }
    };
    
    private JLabel jLabel13 = new JLabel();
    int fnd;
    private JLabel jLabel1 = new JLabel();


    /**Constructor de la clase Principal*/
    public VrComputadoraG3(int f) {
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
    
    /**metodo que inicia un hilo el cual determinara el jugador que ha ganado la partida
     * una vez que todas las cartas esten desbloqueadas*/
    private void initHilo(){
        Thread hilo = new Thread(this,"VrComputadoraG3");
        hilo.start();
    }
    /**Metodo que inicializa los componentes graficos*/
    private void jbInit() throws Exception {
        this.setLayout( null );
        this.setSize(new Dimension(835, 538));
        label1.setBounds(new Rectangle(5, 45, 100, 100));
        label1.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        label1.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    jugada(1);
                }
            });
        label2.setBounds(new Rectangle(125, 45, 100, 100));
        label2.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        label2.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    jugada(2);
                }
            });
        label3.setBounds(new Rectangle(245, 45, 100, 100));
        label3.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        label3.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    jugada(3);
                }
            });
        label4.setBounds(new Rectangle(365, 45, 100, 100));
        label4.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        label4.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    jugada(4);
                }
            });
        label5.setBounds(new Rectangle(485, 45, 100, 100));
        label5.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        label5.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    jugada(5);
                }
            });
        label6.setBounds(new Rectangle(605, 45, 100, 100));
        label6.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        label6.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    jugada(6);
                }
            });
        label7.setBounds(new Rectangle(725, 45, 100, 100));
        label7.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        label7.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    jugada(7);
                }
            });
        label8.setBounds(new Rectangle(5, 160, 100, 100));
        label8.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        label8.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    jugada(8);
                }
            });
        label9.setBounds(new Rectangle(125, 160, 100, 100));
        label9.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        label9.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    jugada(9);
                }
            });
        label10.setBounds(new Rectangle(245, 160, 100, 100));
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

        jLabel11.setText("Jugador 1: 0 puntos");
        jLabel11.setBounds(new Rectangle(25, 10, 130, 25));
        jLabel11.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        
        jLabel12.setText("Computadora: 0 puntos");
        jLabel12.setBounds(new Rectangle(610, 10, 180, 25));
        jLabel12.setBorder(BorderFactory.createLineBorder(Color.black, 1));


        jLabel1.setBounds(new Rectangle(260, 10, 280, 25));
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setHorizontalTextPosition(SwingConstants.CENTER);
        label12.setBounds(new Rectangle(485, 160, 100, 100));
        label12.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        label12.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    jugada(12);
                }
            });
        
        label13.setBounds(new Rectangle(605, 160, 100, 100));
        label13.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        label13.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    jugada(13);
                }
            });
        
        label14.setBounds(new Rectangle(725, 160, 100, 100));
        label14.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        label14.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    jugada(14);
                }
            });
        
        label15.setBounds(new Rectangle(5, 280, 100, 100));
        label15.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        label15.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    jugada(15);
                }
            });
        
        label16.setBounds(new Rectangle(125, 280, 100, 100));
        label16.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        label16.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    jugada(16);
                }
            });
        
        label17.setBounds(new Rectangle(245, 280, 100, 100));
        label17.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        label17.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    jugada(17);
                }
            });
        
        label18.setBounds(new Rectangle(365, 280, 100, 100));
        label18.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        label18.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    jugada(18);
                }
            });


        label19.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        label19.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    jugada(19);
                }
            });
        label19.setBounds(new Rectangle(485, 280, 100, 100));
        

        label20.setBounds(new Rectangle(605, 280, 100, 100));
        label20.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        label20.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    jugada(20);
                }
            });
      
        label21.setBounds(new Rectangle(725, 280, 100, 100));
        label21.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        label21.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    jugada(21);
                }
            });
        
        label22.setBounds(new Rectangle(5, 400, 100, 100));
        label22.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        label22.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    jugada(22);
                }
            });
        
        label23.setBounds(new Rectangle(125, 400, 105, 100));
        label23.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        label23.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    jugada(23);
                }
            });
        
        label24.setBounds(new Rectangle(245, 400, 100, 100));
        label24.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        label24.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    jugada(24);
                }
            });
        
        label25.setBounds(new Rectangle(365, 400, 100, 100));
        label25.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        label25.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    jugada(25);
                }
            });
        
        label26.setBounds(new Rectangle(485, 400, 100, 100));
        label26.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        label26.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    jugada(26);
                }
            });
        
        label27.setBounds(new Rectangle(605, 400, 100, 100));
        label27.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        label27.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    jugada(27);
                }
            });
        
        label28.setBounds(new Rectangle(725, 400, 100, 100));
        label28.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        label28.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    jugada(28);
                }
            });
        
        label11.setBounds(new Rectangle(365, 160, 100, 100));
        label11.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        label11.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    jugada(11);
                }
            });


        this.add(jLabel1, null);
        this.add(label28, null);
        this.add(label27, null);
        this.add(label26, null);
        this.add(label25, null);
        this.add(label24, null);
        this.add(label23, null);
        this.add(label22, null);
        this.add(label21, null);
        this.add(label20, null);
        this.add(label19, null);
        this.add(label18, null);
        this.add(label17, null);
        this.add(label16, null);
        this.add(label15, null);
        this.add(label14, null);
        this.add(label13, null);
        this.add(label12, null);
        this.add(label11, null);
        this.add(jLabel13, null);
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
        
    
    /**Metodo jugada en nivel dificil
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
                x=0;
                y=6;
                break;
            case 8:
                x=1;
                y=0;
                break;
            case 9:
                x=1;
                y=1;
                break;
            case 10:
                x=1;
                y=2;
                break;
            case 11:
                x=1;
                y=3;
                break;
            case 12:
                x=1;
                y=4;
                break;
            case 13:
                x=1;
                y=5;
                break;
            case 14:
                x=1;
                y=6;
                break;
            case 15:
                x=2;
                y=0;
                break;
            case 16:
                x=2;
                y=1;
                break;
            case 17:
                x=2;
                y=2;
                break;
            case 18:
                x=2;
                y=3;
                break;
            case 19:
                x=2;
                y=4;
                break;
            case 20:
                x=2;
                y=5;
                break;
            case 21:
                x=2;
                y=6;
                break;
            case 22:
                x=3;
                y=0;
                break;
            case 23:
                x=3;
                y=1;
                break;
            case 24:
                x=3;
                y=2;
                break;
            case 25:
                x=3;
                y=3;
                break;
            case 26:
                x=3;
                y=4;
                break;
            case 27:
                x=3;
                y=5;
                break;
            case 28:
                x=3;
                y=6;
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
    
    /**metodo jugada2 en nivel dificil
     * en el cual la computadora escogera su carta en la etiqueta correspondiente*/ 
    public boolean jugada2(int car){
        boolean ind=false;
        boolean rep=false;
        int x=-1,y=-1;
         int numLabel = (int)(r.nextDouble()*28)+1;
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
            x=0;
            y=6;
            break;
        case 8:
            x=1;
            y=0;
            break;
        case 9:
            x=1;
            y=1;
            break;
        case 10:
            x=1;
            y=2;
            break;
        case 11:
            x=1;
            y=3;
            break;
        case 12:
            x=1;
            y=4;
            break;
        case 13:
            x=1;
            y=5;
            break;
        case 14:
            x=1;
            y=6;
            break;
        case 15:
            x=2;
            y=0;
            break;
        case 16:
            x=2;
            y=1;
            break;
        case 17:
            x=2;
            y=2;
            break;
        case 18:
            x=2;
            y=3;
            break;
        case 19:
            x=2;
            y=4;
            break;
        case 20:
            x=2;
            y=5;
            break;
        case 21:
            x=2;
            y=6;
            break;
        case 22:
            x=3;
            y=0;
            break;
        case 23:
            x=3;
            y=1;
            break;
        case 24:
            x=3;
            y=2;
            break;
        case 25:
            x=3;
            y=3;
            break;
        case 26:
            x=3;
            y=4;
            break;
        case 27:
            x=3;
            y=5;
            break;
        case 28:
            x=3;
            y=6;
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
                label1.setIcon(new ImageIcon(mdificil1[x][y]));
                cartAnterior=1;
                comp[0]=1;
            }
            else{
                ind=false;
            }
            break;
        case 2:
            if( comp[1]!=1){
                label2.setIcon(new ImageIcon(mdificil1[x][y]));
                cartAnterior=2;
                comp[1]=1;
            }
            else{
                ind=false;
            }
            break;
        case 3:
            if( comp[2]!=1){
                label3.setIcon(new ImageIcon(mdificil1[x][y]));
                cartAnterior=3;
                comp[2]=1;
            }
            else{
                ind=false;
            }
            break;
        case 4:
            if( comp[3]!=1){
                label4.setIcon(new ImageIcon(mdificil1[x][y]));
                cartAnterior=4;
                comp[3]=1;
            }       
            else{
                ind=false;
            }
            break;
        case 5:
            if( comp[4]!=1){
                label5.setIcon(new ImageIcon(mdificil1[x][y]));
                cartAnterior=5;
                comp[4]=1;
            }
            else{
                ind=false;
            }
            break;
        case 6:
            if( comp[5]!=1){
                label6.setIcon(new ImageIcon(mdificil1[x][y]));
                cartAnterior=6;
                comp[5]=1;
            }
            else{
                ind=false;
            }
            break;
        case 7:
            if( comp[6]!=1){
                label7.setIcon(new ImageIcon(mdificil1[x][y]));
                cartAnterior=7;
                comp[6]=1;
            }
            else{
                ind=false;
            }
            break;
        case 8:
            if( comp[7]!=1){
                label8.setIcon(new ImageIcon(mdificil1[x][y]));
                cartAnterior=8;
                comp[7]=1;
            }
            else{
                ind=false;
            }
            break;
        case 9:
            if( comp[8]!=1){
                label9.setIcon(new ImageIcon(mdificil1[x][y]));
                cartAnterior=9;
                comp[8]=1;
            }
            else{
                ind=false;
            }
            break;
        case 10:
            if( comp[9]!=1){
                label10.setIcon(new ImageIcon(mdificil1[x][y]));
                cartAnterior=10;
                comp[9]=1;
            }
            else{
                ind=false;
            }
            break;
        case 11:
            if(comp[10]!=1){
                label11.setIcon(new ImageIcon(mdificil1[x][y]));
                cartAnterior=1;
                comp[10]=1;
            }
            else{
                ind=false;
            }
            break;
        case 12:
            if(comp[11]!=1){
                label12.setIcon(new ImageIcon(mdificil1[x][y]));
                cartAnterior=1;
                comp[11]=1;
            }
            else{
                ind=false;
            }
            break;
        case 13:
            if(comp[12]!=1){
                label13.setIcon(new ImageIcon(mdificil1[x][y]));
                cartAnterior=1;
                comp[12]=1;
            }
            else{
                ind=false;
            }
            break;
        case 14:
            if(comp[13]!=1){
                label14.setIcon(new ImageIcon(mdificil1[x][y]));
                cartAnterior=1;
                comp[13]=1;
            }
            else{
                ind=false;
            }
            break;
        case 15:
            if(comp[14]!=1){
                label15.setIcon(new ImageIcon(mdificil1[x][y]));
                cartAnterior=1;
                comp[14]=1;
            }
            else{
                ind=false;
            }
            break;
        case 16:
            if(comp[15]!=1){
                label16.setIcon(new ImageIcon(mdificil1[x][y]));
                cartAnterior=1;
                comp[15]=1;
            }
            else{
                ind=false;
            }
            break;
        case 17:
            if(comp[16]!=1){
                label17.setIcon(new ImageIcon(mdificil1[x][y]));
                cartAnterior=1;
                comp[16]=1;
            }
            else{
                ind=false;
            }
            break;
        case 18:
            if(comp[17]!=1){
                label18.setIcon(new ImageIcon(mdificil1[x][y]));
                cartAnterior=1;
                comp[17]=1;
            }
            else{
                ind=false;
            }
            break;
        case 19:
            if(comp[18]!=1){
                label19.setIcon(new ImageIcon(mdificil1[x][y]));
                cartAnterior=1;
                comp[18]=1;
            }
            else{
                ind=false;
            }
            break;
        case 20:
            if(comp[19]!=1){
                label20.setIcon(new ImageIcon(mdificil1[x][y]));
                cartAnterior=1;
                comp[19]=1;
            }
            else{
                ind=false;
            }
            break;
        case 21:
            if(comp[20]!=1){
                label21.setIcon(new ImageIcon(mdificil1[x][y]));
                cartAnterior=1;
                comp[20]=1;
            }
            else{
                ind=false;
            }
            break;
        case 22:
            if(comp[21]!=1){
                label22.setIcon(new ImageIcon(mdificil1[x][y]));
                cartAnterior=1;
                comp[21]=1;
            }
            else{
                ind=false;
            }
            break;
        case 23:
            if(comp[22]!=1){
                label23.setIcon(new ImageIcon(mdificil1[x][y]));
                cartAnterior=1;
                comp[22]=1;
            }
            else{
                ind=false;
            }
            break;
        case 24:
            if(comp[23]!=1){
                label24.setIcon(new ImageIcon(mdificil1[x][y]));
                cartAnterior=1;
                comp[23]=1;
            }
            else{
                ind=false;
            }
            break;
        case 25:
            if(comp[24]!=1){
                label25.setIcon(new ImageIcon(mdificil1[x][y]));
                cartAnterior=1;
                comp[24]=1;
            }
            else{
                ind=false;
            }
            break;
        case 26:
            if(comp[25]!=1){
                label26.setIcon(new ImageIcon(mdificil1[x][y]));
                cartAnterior=1;
                comp[25]=1;
            }
            else{
                ind=false;
            }
            break;
        case 27:
            if(comp[26]!=1){
                label27.setIcon(new ImageIcon(mdificil1[x][y]));
                cartAnterior=1;
                comp[26]=1;
            }
            else{
                ind=false;
            }
            break;
        case 28:
            if(comp[27]!=1){
                label28.setIcon(new ImageIcon(mdificil1[x][y]));
                cartAnterior=1;
                comp[27]=1;
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
            if(mdificil1[this.x][this.y].equals(mdificil1[this.x1][this.y1])==true ){
                if(this.Comput==false){
                    jLabel1.setForeground(new Color(0, 66, 198));
                    jLabel1.setText("Encontro un par");
                    pj++; 
                    jLabel11.setText("Jugador: "+pj+" puntos");
                    this.Comput=true;
                   
                }
                else{
                    pc++;
                    jLabel1.setForeground(new Color(0, 66, 198));
                    jLabel1.setText("La Computadora Encontro un par");
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
                label1.setIcon(new ImageIcon(fondo));
                comp[0]=0;
                break;
            case 2:
                label2.setIcon(new ImageIcon(fondo));
                comp[1]=0;
                break;
            case 3:
                label3.setIcon(new ImageIcon(fondo));
                comp[2]=0;
                break;
            case 4:
                label4.setIcon(new ImageIcon(fondo));
                comp[3]=0;
                break;
            case 5:
                label5.setIcon(new ImageIcon(fondo));
                comp[4]=0;
                break;
            case 6:
                label6.setIcon(new ImageIcon(fondo));
                comp[5]=0;
                break;
            case 7:
                label7.setIcon(new ImageIcon(fondo));
                comp[6]=0;
                break;
            case 8:
                label8.setIcon(new ImageIcon(fondo));
                comp[7]=0;
                break;
            case 9:
                label9.setIcon(new ImageIcon(fondo));
                comp[8]=0;
                break;
            case 10:
                label10.setIcon(new ImageIcon(fondo));
                comp[9]=0;
                break;
            case 11:
                label11.setIcon(new ImageIcon(fondo));
                comp[10]=0;
                break;
            case 12:
                label12.setIcon(new ImageIcon(fondo));
                comp[11]=0;
                break;
            case 13:
                label13.setIcon(new ImageIcon(fondo));
                comp[12]=0;
                break;
            case 14:
                label14.setIcon(new ImageIcon(fondo));
                comp[13]=0;
                break;
            case 15:
                label15.setIcon(new ImageIcon(fondo));
                comp[14]=0;
                break;
            case 16:
                label16.setIcon(new ImageIcon(fondo));
                comp[15]=0;
                break;
            case 17:
                label17.setIcon(new ImageIcon(fondo));
                comp[16]=0;
                break;
            case 18:
                label18.setIcon(new ImageIcon(fondo));
                comp[17]=0;
                break;
            
                case 19:
                label19.setIcon(new ImageIcon(fondo));
                comp[18]=0;
                break;
            
                case 20:
                label20.setIcon(new ImageIcon(fondo));
                comp[19]=0;
                break;
            
            case 21:
                label21.setIcon(new ImageIcon(fondo));
                comp[20]=0;
                break;
            case 22:
                label22.setIcon(new ImageIcon(fondo));
                comp[21]=0;
                    break;
            case 23:
                label23.setIcon(new ImageIcon(fondo));
                comp[22]=0;
                 break;
          case 24:
                label24.setIcon(new ImageIcon(fondo));
                comp[23]=0;
                  break;
            case 25:
                label25.setIcon(new ImageIcon(fondo));
                comp[24]=0;
                break;
          case 26:
                label26.setIcon(new ImageIcon(fondo));
                comp[25]=0;
                break;
            case 27:
                label27.setIcon(new ImageIcon(fondo));
                comp[26]=0;
                break;
            case 28:
                label28.setIcon(new ImageIcon(fondo));
                comp[27]=0;
                break;         
            }
        }
     
    /**metodo que dira si todos los pares han sido levantados
     * regresa false si no
     * regresa true si todos los pares han sido levantados*/  
     public boolean isCompleto(){
         boolean res=false;
         if(sum==14){
             res=true;
         }
         else{
             res=false;
         }
         return res;
     }
     
    
    /* public static void main(String []arg){
         VrComputadoraG3 a = new VrComputadoraG3();
         a.setVisible(true);
         
     }*/

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
            String dificil[] ={"FondoDefault\\1.png","FondoDefault\\2.png","FondoDefault\\3.png","FondoDefault\\4.png","FondoDefault\\5.png",
                      "FondoDefault\\6.png","FondoDefault\\7.png","FondoDefault\\8.png","FondoDefault\\9.png","FondoDefault\\10.png",
                        "FondoDefault\\11.png","FondoDefault\\12.png","FondoDefault\\13.png","FondoDefault\\14.png"};
            dificil1=dificil;
        }
        if(fnd==1){
            String dificil[] ={"Carros\\1.png","Carros\\2.png","Carros\\3.png","Carros\\4.png","Carros\\5.png",
                             "Carros\\6.png","Carros\\7.png","Carros\\8.png","Carros\\9.png","Carros\\10.png",
                               "Carros\\11.png","Carros\\12.png","Carros\\13.png","Carros\\14.png"};
            dificil1=dificil;
        }
        if(fnd==2){
            String dificil[] ={"ResidentEvil\\1.png","ResidentEvil\\2.png","ResidentEvil\\3.png","ResidentEvil\\4.png","ResidentEvil\\5.png",
                             "ResidentEvil\\6.png","ResidentEvil\\7.png","ResidentEvil\\8.png","ResidentEvil\\9.png","ResidentEvil\\10.png",
                               "ResidentEvil\\11.png","ResidentEvil\\12.png","ResidentEvil\\13.png","ResidentEvil\\14.png"};
            dificil1=dificil;
        }
        if(fnd==3){
            String dificil[] ={"Perros\\1.png","Perros\\2.png","Perros\\3.png","Perros\\4.png","Perros\\5.png",
                             "Perros\\6.png","Perros\\7.png","Perros\\8.png","Perros\\9.png", "Perros\\10.png",
                               "Perros\\11.png","Perros\\12.png","Perros\\13.png","Perros\\14.png"};
            dificil1=dificil;
        }
    }
}
