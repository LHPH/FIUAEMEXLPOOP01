package catch_me;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class MovimientoJL implements MouseMotionListener,MouseListener {
    private int [] coorXOrig;
    private int [] coorYOrig;
    private int coorX;
    private int coorY;
    private int width;
    private int height;
    private ArrayList<JLabel> lista = new ArrayList<JLabel>();
    private ArrayList<JLabel> lista2 = new ArrayList<JLabel>();
    private int ind=0;
    private int ind2=0;
    private DragDrop ventana;
    private JLabel aux;
    
    
    
    public MovimientoJL() {
        super();
    }
    
    /** metodo que agregara una JLabel al arrayList
     * las etiquetas agregadas seran las que podran arrastrarse*/
    public void add(JLabel etiqueta){
        lista.add(etiqueta);
    }
    /**metodo que agregara una JLabel al segundo arrayList
     * las etiquetas agregadas seran las que permanezcan estaticamente en el tablero*/
    public void add2(JLabel etiqueta2){
        lista2.add(etiqueta2);   
    }
    
    /**metodo que obtendra la referencia de la ventana
     * donde se jugara el juego*/
    public void setDragDrop(DragDrop ven){
        ventana=ven;
    }
    
    /**metodo que iniciara el vector de coordenadas iniciales de X y Y
     * y asignara las coordenandas iniciales al  vector
     * de coordenanas iniciales de X y Y y*/
    public void init(){
        coorXOrig=new int[lista.size()];
        coorYOrig=new int[lista.size()];
        for(int i=0;i<lista.size();i++){
            coorXOrig[i]=lista.get(i).getX();
            coorYOrig[i]=lista.get(i).getY();
        }
    }

/**metodo que se encargara del arrastre de la etiqueta determinada */
    @Override
    public void mouseDragged(MouseEvent e) {
        int i=0;
            for(i=0;i<lista.size();i++){
                if(lista.get(i)==(JLabel)e.getComponent()){
                    break;
                }
            }
            this.width=lista.get(i).getWidth();
            this.height=lista.get(i).getHeight();
            this.coorX=lista.get(i).getX();
            this.coorY=lista.get(i).getY();
            lista.get(i).setBounds(this.coorX+e.getX()-this.width/2,this.coorY+e.getY()-this.height/2,this.width,this.height);
        
    }

/** metodo que se encargara de asignar a los atributos de las coordenadas X y Y actuales
 * las coordenadas de X y Y de la etiqueta presionada*/
    @Override
    public void mousePressed(MouseEvent e) {
        for(int i=0;i<lista.size();i++){
            if(lista.get(i)==(JLabel) e.getComponent()){
                ind=i;
                break;
            }
        }
        this.coorX=lista.get(ind).getX();
        this.coorY=lista.get(ind).getY();
        this.width=lista.get(ind).getWidth();
        this.height=lista.get(ind).getHeight();
        lista.get(ind).setBounds(this.coorX,this.coorY, width, height);
    }

/** metodo que se encargara de colocar en la nueva posicion a la etiqueta en caso de que tengan el mismo nombre
 * o la misma imagen asociada, en caso contrario hara que la etiqueta vuelva a su posicion original*/
    @Override
    public void mouseReleased(MouseEvent e) {
       Point p = lista.get(ind).getMousePosition();
        lista.get(ind).updateUI();
        lista.get(ind).setBounds(new Rectangle(this.coorX,this.coorY,this.width,this.height));
        if (comprobar(p)==true) {
            if(comprobarNombre()==true){
                lista.get(ind).setVisible(false);
                lista2.get(ind2).setIcon(new ImageIcon(lista2.get(ind2).getName()));
                lista2.get(ind).updateUI();
                ventana.acertar(); 
            }
            else{
                lista.get(ind).setBounds(new Rectangle(this.coorXOrig[ind],this.coorYOrig[ind],this.width,this.height));
            }
           
        } else {
            lista.get(ind).setBounds(new Rectangle(this.coorXOrig[ind],this.coorYOrig[ind],this.width,this.height));
           
            lista.get(ind).updateUI();
        }
    }
    
    /**metodo que comprobara si la etiqueta arrastrada se suelta en una etiqueta o lugar validos */
    private boolean comprobar(Point punto){
        boolean resp=false;
        Point p = MouseInfo.getPointerInfo().getLocation();
        for(int i=0;i<lista2.size();i++){
            if(lista.get(ind).getX()<=lista2.get(i).getX()+10 && lista.get(ind).getY()<=lista2.get(i).getY()+10){
                ind2=i;
                resp=true;
                break;
            }
        }
        return resp;
    }
    
    /**metodo que comprobara si las dos etiquetas tienen el mismo nombre o la misma imagen asociada */
    private boolean comprobarNombre(){
        boolean indicador=false;
        System.out.println(lista.get(ind).getName());
        System.out.println(lista2.get(ind2).getName());
        if(lista.get(ind).getName().equals(lista2.get(ind2).getName())==true){
            indicador=true;;
        }
        else{
            indicador=false;
        }
        return indicador;
    }
    
    /** 
     * metodos de las interfaz MouseListener y MouseMotionListener*/
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
}
