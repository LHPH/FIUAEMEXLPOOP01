package catch_me;

//Luis Ernesto Sierra Alva
//Luis Humberto Ponce Hermosillo

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
import java.util.Random;

import javax.swing.ImageIcon;

/**Esta clase atraves de la coleccion ArrayList permite almacenar las imagenes que se almacenaran en las labels */

public class CambiarFondo {
    public ArrayList fondo = new ArrayList();
    public ArrayList cr = new ArrayList();
    public ArrayList cp = new ArrayList();
    public ArrayList ci = new ArrayList();
    public int[] contenedor = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
    Random r = new Random(new Date().getTime());
    
    public CambiarFondo() {
    }
    
    /**Este metodo le permite al usuario escoger entre los 3 fondos posibles o el predefinido por el usuario*/
    public int Seleccion(){
        int op;
        Scanner leer = new Scanner(System.in);
        do{
            System.out.println("Escoja un fondo para el juego:");
            System.out.println("1.- Resident Evil");
            System.out.println("2.- Perros");
            System.out.println("3.- Indefinido");
            System.out.println("Escoja una opcion: ");
            op=leer.nextInt();
            if(op<1 || op >3){
                System.out.println("Opcion invalida seleccione otra");   
            }
        }while(op<1 || op>3);
        return op;
    }
    
    public static void main (String args[]){
        int fnd;
        ArrayList guia;
        CambiarFondo cf = new CambiarFondo();
        fnd=cf.Seleccion();
        System.out.println("Se asignaran las imagenes las imagenes correspondientes al fondo disfrute de su juego");
        guia=cf.Asignar(fnd);
        System.out.println("Hola");
        cf.array(guia);
        System.out.println("Fin");
    }
    
    /** Dependiendo de la opcion que se haya seleccionado  se asigaran las correspondientes imagenes*/
    
    public ArrayList Asignar(int op){
        if(op==1){
            //cr.add(new ImageIcon("Imagen1.png"));
            cr.add("Imagen1.png");
            cr.add("Imagen2.png");
            cr.add("Imagen3.png");
            cr.add("Imagen4.png");
            cr.add("Imagen5.png");
            cr.add("Imagen6.png");
            cr.add("Imagen7.png");
            cr.add("Imagen8.png");
            cr.add("Imagen9.png");
            cr.add("Imagen10.png");
            cr.add("Imagen11.png");
            cr.add("Imagen12.png");
            cr.add("Imagen13.png");
            cr.add("Imagen14.png");
            return cr;
        }
        if(op==2){
            cp.add("Imagen1.png");
            cp.add("Imagen2.png");
            cp.add("Imagen3.png");
            cp.add("Imagen4.png");
            cp.add("Imagen5.png");
            cp.add("Imagen6.png");
            cp.add("Imagen7.png");
            cp.add("Imagen8.png");
            cp.add("Imagen9.png");
            cp.add("Imagen10.png");
            cp.add("Imagen11.png");
            cp.add("Imagen12.png");
            cp.add("Imagen13.png");
            cp.add("Imagen14.png");
            return cp;
        }
        
        if(op==3){
            ci.add("Imagen1.png");
            ci.add("Imagen2.png");
            ci.add("Imagen3.png");
            ci.add("Imagen4.png");
            ci.add("Imagen5.png");
            ci.add("Imagen6.png");
            ci.add("Imagen7.png");
            ci.add("Imagen8.png");
            ci.add("Imagen9.png");
            ci.add("Imagen10.png");
            ci.add("Imagen11.png");
            ci.add("Imagen12.png");
            ci.add("Imagen13.png");
            ci.add("Imagen14.png");
            return ci;
        }
        
        return fondo;
    }
    
    
    /**Este metodo relaciona aleatoriamente cada imagen con un numero */
    public void array(ArrayList guia){
        int i=0;
        int j=0;
        boolean f;
        int aux;
        while(i<14){
            f=false;
            aux=(int)(r.nextDouble()*14);
            for(j=0;j<14;j++){
                if(contenedor[j]== aux){
                    f=true;
                }
            }
            System.out.println(aux);
            if(f==false){
                contenedor[i]=aux;
                i=i+1;
            }
        }
        System.out.println("Vector asociado a las imagenes");
        for(i=0;i<14;i++){
            System.out.printf("%d\t",contenedor[i]);
        }
        System.out.println("");
    }
}
