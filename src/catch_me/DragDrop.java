package catch_me;

import java.awt.Color;
import java.awt.Dimension;

import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;

import java.util.Date;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**Clase que manejara el modo de juego de DragDrop Arrastrar y Soltar */
public class DragDrop extends JPanel implements Runnable {
    final String fondo="FondoDefault\\fondo.png";
    private JLabel marcador = new JLabel();
    private JLabel tablero = new JLabel();
    private JLabel tablero2 = new JLabel();
    private JLabel carta1 = new JLabel(new ImageIcon(fondo));
    private JLabel carta2 = new JLabel(new ImageIcon(fondo));
    private JLabel carta3 = new JLabel(new ImageIcon(fondo));
    private JLabel carta4 = new JLabel(new ImageIcon(fondo));
    private JLabel carta5 = new JLabel(new ImageIcon(fondo));
    private JLabel carta6 = new JLabel(new ImageIcon(fondo));
    private JLabel carta7 = new JLabel(new ImageIcon(fondo));
    private JLabel carta8 = new JLabel(new ImageIcon(fondo));
    private JLabel carta11 = new JLabel();
    private JLabel carta12 = new JLabel();
    private JLabel carta13 = new JLabel();
    private JLabel carta14 = new JLabel();
    private JLabel carta15 = new JLabel();
    private JLabel carta16 = new JLabel();
    private JLabel carta17 = new JLabel();
    private JLabel carta18 = new JLabel();
    
    String [] figuras = {"Figuras\\1.png","Figuras\\2.png","Figuras\\3.png","Figuras\\4.png","Figuras\\5.png","Figuras\\6.png",
    "Figuras\\7.png","Figuras\\8.png"};
    int [] base = {0,1,2,3,4,5,6,7};
    int [] base2 ={0,1,2,3,4,5,6,7};
    int [] indice = {-1,-1,-1,-1,-1,-1,-1,-1};
    int [] indice2 ={-1,-1,-1,-1,-1,-1,-1,-1};
    int seg=30,min=1;
    boolean ind=true;
    
    Random r = new Random(new Date().getTime());
    int pj=0;
    MovimientoJL mov = new MovimientoJL();
    private JLabel reloj = new JLabel();
    JLabel lab;
    boolean av;

   /**Constructor de la clase */
    public DragDrop(JLabel label,boolean a) {
        try {
            lab=label;
            av=a;
            //iniciar el hilo del reloj
            Thread hilo = new Thread(this,"DragDrop");
            hilo.start();
            jbInit();
            setNombre();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

/** Cuerpo de la ventana
 * que inicializara todos los componentes graficos*/
    private void jbInit() throws Exception {
        this.setLayout( null );
        this.setSize(new Dimension(587, 587));
        
        marcador.setText("Jugador: 0 puntos");
        marcador.setFont(new Font("Arial",1,12));
        marcador.setBounds(new Rectangle(240, 5, 170, 30));
        
        tablero.setBounds(new Rectangle(50, 40, 495, 250));
        tablero.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        
        tablero2.setBounds(new Rectangle(50, 300, 495, 245));
        tablero2.setBorder(BorderFactory.createLineBorder(Color.black, 2));

        carta1.setBounds(new Rectangle(65, 55, 100, 100));
        carta1.setBorder(BorderFactory.createLineBorder(Color.black, 1));

        carta2.setBounds(new Rectangle(180, 55, 100, 100));
        carta2.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        
        carta3.setBounds(new Rectangle(295, 55, 100, 100));
        carta3.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        
        carta4.setBounds(new Rectangle(415, 55, 100, 100));
        carta4.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        
        carta5.setBounds(new Rectangle(65, 170, 100, 100));
        carta5.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        
        carta6.setBounds(new Rectangle(180, 170, 100, 100));
        carta6.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        
        carta7.setBounds(new Rectangle(295, 170, 100, 100));
        carta7.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        
        carta8.setBounds(new Rectangle(415, 170, 100, 100));
        carta8.setBorder(BorderFactory.createLineBorder(Color.black, 1));

        carta11.setBounds(new Rectangle(65, 320, 100, 100));
        carta11.addMouseListener(mov);
        carta11.addMouseMotionListener(mov);
        
       // carta11.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        
        carta12.setBounds(new Rectangle(180, 320, 100, 100));
        carta12.addMouseListener(mov);
        carta12.addMouseMotionListener(mov);
        //carta12.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        
        carta13.setBounds(new Rectangle(295, 320, 100, 100));
        carta13.addMouseListener(mov);
        carta13.addMouseMotionListener(mov);
        //carta13.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        
        carta14.setBounds(new Rectangle(415, 320, 100, 100));
        carta14.addMouseListener(mov);
        carta14.addMouseMotionListener(mov);
        //carta14.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        
        carta15.setBounds(new Rectangle(65, 430, 100, 100));
        carta15.addMouseListener(mov);
        carta15.addMouseMotionListener(mov);
       // carta15.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        
        carta16.setBounds(new Rectangle(180, 430, 100, 100));
        carta16.addMouseListener(mov);
        carta16.addMouseMotionListener(mov);
        //carta16.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        
        carta17.setBounds(new Rectangle(295, 430, 100, 100));
        carta17.addMouseListener(mov);
        carta17.addMouseMotionListener(mov);
        //carta17.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        
        carta18.setBounds(new Rectangle(415, 430, 100, 100));
        carta18.addMouseListener(mov);
        carta18.addMouseMotionListener(mov);
       // carta18.setBorder(BorderFactory.createLineBorder(Color.black, 1));

        reloj.setText("Reloj: "+min+" : "+seg);
        reloj.setFont(new Font("Arial",1,12));
        reloj.setBounds(new Rectangle(400, 5, 155, 30));
        cargar();

        this.add(reloj, null);
        this.add(carta18,null);
        this.add(carta17,null);
        this.add(carta16,null);
        this.add(carta15,null);
        this.add(carta14,null);
        this.add(carta13,null);
        this.add(carta12,null);
        this.add(carta11, null);
        this.add(carta8, null);
        this.add(carta7, null);
        this.add(carta6, null);
        this.add(carta5, null);
        this.add(carta4, null);
        this.add(carta3, null);
        this.add(carta2, null);
        this.add(carta1, null);
        this.add(tablero2, null);
        this.add(tablero, null);
        this.add(marcador, null);
    }
    
    /**metodo que
     * le pondra como nombre a la determinada etiqueta que le toque
     * el nombre de la ruta de su imagen asociada
     * para esto se sorteara aleatoriamente y los numeros se meteran a un vector
     * y una vez hecho esto el vector asiganara el indice para escoger una de 
     * las 8 imagenes posibles y la asociara con la etiqueta
     * */
    public void setNombre(){
        int i=0;
        while(i<indice.length){
            int n=(int)(r.nextDouble()*8);
            if(indice[i]==-1 && base[n]!=-1){
                indice[i]=base[n];
                base[n]=-1;
                i++;
            }
        }
        carta1.setName(figuras[indice[0]]);
        carta2.setName(figuras[indice[1]]);
        carta3.setName(figuras[indice[2]]);
        carta4.setName(figuras[indice[3]]);
        carta5.setName(figuras[indice[4]]);
        carta6.setName(figuras[indice[5]]);
        carta7.setName(figuras[indice[6]]);
        carta8.setName(figuras[indice[7]]);
        
        int j=0;
        while(j<indice2.length){
            int n=(int)(r.nextDouble()*8);
            if(indice2[j]==-1 && base2[n]!=-1){
                indice2[j]=base2[n];
                base2[n]=-1;
                j++;
            }
        }
        
        carta11.setName(figuras[indice2[0]]);
        carta12.setName(figuras[indice2[1]]);
        carta13.setName(figuras[indice2[2]]);
        carta14.setName(figuras[indice2[3]]);
        carta15.setName(figuras[indice2[4]]);
        carta16.setName(figuras[indice2[5]]);
        carta17.setName(figuras[indice2[6]]);
        carta18.setName(figuras[indice2[7]]);
        
        carta11.setIcon(new ImageIcon(figuras[indice2[0]]));
        carta12.setIcon(new ImageIcon(figuras[indice2[1]]));
        carta13.setIcon(new ImageIcon(figuras[indice2[2]]));
        carta14.setIcon(new ImageIcon(figuras[indice2[3]]));
        carta15.setIcon(new ImageIcon(figuras[indice2[4]]));
        carta16.setIcon(new ImageIcon(figuras[indice2[5]]));
        carta17.setIcon(new ImageIcon(figuras[indice2[6]]));
        carta18.setIcon(new ImageIcon(figuras[indice2[7]]));
        
    }
    
    /**metodo que hara que el objeto de la clase que dara movimiento a las etiquetas
     * agrege a todos las etiquetas del juego*/
    private void cargar(){
        mov.add(carta11);
        mov.add(carta12);
        mov.add(carta13);
        mov.add(carta14);
        mov.add(carta15);
        mov.add(carta16);
        mov.add(carta17);
        mov.add(carta18);
        
        mov.add2(carta1);
        mov.add2(carta2);
        mov.add2(carta3);
        mov.add2(carta4);
        mov.add2(carta5);
        mov.add2(carta6);
        mov.add2(carta7);
        mov.add2(carta8);
        
        mov.init();
        mov.setDragDrop(this);
    }
    
    /**metodo que cambiara la puntuacion del jugador una vez encontrado un par */
    public void acertar(){
        pj++;
        marcador.setText("Jugador: "+pj+" puntos");
        
    }
    
    /** metodo que mostrara el resultado
     * una vez que el jugador haya perdido contra el reloj y no haya
     * logrado encontrar todos los pares*/
    private void mostrar(){
        reloj.setText("Reloj: --:--");
        carta1.setIcon(new ImageIcon(carta1.getName()));
        carta2.setIcon(new ImageIcon(carta2.getName()));
        carta3.setIcon(new ImageIcon(carta3.getName()));
        carta4.setIcon(new ImageIcon(carta4.getName()));
        carta5.setIcon(new ImageIcon(carta5.getName()));
        carta6.setIcon(new ImageIcon(carta6.getName()));
        carta7.setIcon(new ImageIcon(carta7.getName()));
        carta8.setIcon(new ImageIcon(carta8.getName()));
        
        carta11.setVisible(false);
        carta12.setVisible(false);
        carta13.setVisible(false);
        carta14.setVisible(false);
        carta15.setVisible(false);
        carta16.setVisible(false);
        carta17.setVisible(false);
        carta18.setVisible(false);
    }

    public void refresh(){
        this.updateUI();
    }

/** 
 *  metodo sobreescrito de Runnable que
 *  gestionara el uso del reloj y a la vez que determinara si el jugador
 *  ha ganado la partida antes de que se acabe el tiempo o ha perdido*/ 
    @Override
    public void run() {
        while(ind==true && pj<8 && av==true){
            try {
                Thread.sleep(1000);
                //System.out.println(min+":"+seg);
                seg--;
                if(seg==0 && min!=0){
                    min--;
                    seg=59;
                }
                if(seg==0 && min==0){
                    ind=false;
                }
                if(ind==false || pj==8 || av==false){
                    throw new InterruptedException();
                }
                reloj.setText("Reloj "+min+" : "+seg);
            } catch (InterruptedException e) {
                ind=false;
            }
        }
        if(pj==8){
            JOptionPane.showMessageDialog(this, "Ha Ganado La Partida","Felicidades",JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(this, "Ha Perdido La Partida","Mala Suerte",JOptionPane.ERROR_MESSAGE);
            mostrar();
        }
        
    }
}
