package catch_me;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;


/**Clase Contrareloj
 * clase que implementa el modo de juego de contrareloj en la cual el usuario tendra que encontrar todos los 
 * pares del tablero antes del tiempo establecido
 * esta clase hereda los metodos de la clase Matriz e implementa la interfaz Runnable para el funcionamiento
 * del contador de tiempo*/
public class Contrareloj extends Matriz implements Runnable{
    public int seg=0;
    public int min=0;
    boolean ind=true;
    
    int opc,pj=0,pc=0,pos1,pos2;
    int [] pos= new int[4];
    Random ran = new Random(new Date().getTime());
    
    /**Contructor de la clase la cual recibe como parametro
     * @param opc - la opcion del jugador
     * @param min - los minutos
     * @param seg - los segundos
     * le asigna al atributo de la clase matriz el valor de opc
     * y ejecuta los metodos de la clase matriz
     * y al finalizar ejecuta el metodo de juego
     * */
    public Contrareloj(int opc,int min,int seg) {
        super.opc=opc;
        this.opc=opc;
        this.seg=seg;
        this.min=min;
        inicializar1();
        llenar();
        inicializar2();
        juego();
    }
    
    /** metodo juego en el cual se llevara a cabo todo el proceso del juego
     *  al ejecutarse, ejecuta el metodo que inicializar el contador de tiempo
     *  y mostrara en pantalla el tablero de juego
     * */
    private void juego(){
        boolean ind=false,ind2=true;
        System.out.println("Comencemos");
        initReloj();
        System.out.println("Cada Carta esta");
        while(ind==false && this.ind==true){
            visualizarm();
                usuario();
                System.out.println("");
                System.out.println("");
            if(comprobar()==true){
                ind=true;
                this.ind=true;
            }
        }
        if(this.ind==true){
            ResultadoR res = new ResultadoR();
            res.resultado("Jugador Gana",pj);
        }
        else{
            ResultadoR res= new ResultadoR();
            res.resultado("Jugador Pierde", pj);
        }
    }
    
    
    /**Metodo usuario
     * en el cual se llevara a cabo sobre el turno en el cual el usuario escogera su par de cartas
     * */
    private void usuario(){
        int x=0,y=0,car=0;
        boolean aceptar=false, exc=false;
        System.out.println("Jugador:"+pj+" Puntos");
        try{
            do{
                try{
                     Scanner leer = new Scanner(System.in);
                        if(this.ind==true){
                            System.out.println("Dame numero de renglon:");
                            try{
                                x=leer.nextInt();
                            }catch(InputMismatchException e){
                                throw new ExcepcionGame("Debes Ingresar Numeros no Letras","Modo Contrareloj");
                            }
                        }
                        else{
                            exc=true;
                            throw new ExcepcionGame();
                        }
                        if(this.ind==true){
                            System.out.println("Dame numero de columna:");
                            try{
                                y=leer.nextInt();
                            }catch(InputMismatchException e){
                                throw new ExcepcionGame("Debes Ingresar Numeros no Letras","Modo Contrareloj");
                            }
                        }
                        else{
                            exc=true;
                            throw new ExcepcionGame();
                        }
                        try{
                            if(compmov(x,y)==true){
                                aceptar=true;
                            }
                            else{
                                aceptar=false;
                                System.out.println("Movimiento no Valido, Escoga Otra Vez");
                            }
                        }catch(ArrayIndexOutOfBoundsException a){
                            aceptar=false;
                            System.out.println("Posicion No Valida");
                        }
                        
                    }catch(ExcepcionGame a){
                    if(exc==false){
                        aceptar=false;
                        a.mensaje();
                    }else{
                        exc=false;
                        throw new TimeOut("Has Rebasado tu Tiempo Limite","Modo Contrareloj");
                    }
                    }
                        
             }while(aceptar==false);            

             car=1;
             car=jugada(x,y,car,"Jugador");
             aceptar=false;
             do{
                 try{
                     Scanner leer = new Scanner(System.in);
                     if(this.ind==true){
                         System.out.println("Dame numero de renglon:");
                         try{
                             x=leer.nextInt();
                         }catch(InputMismatchException e){
                             throw new ExcepcionGame("Debes Ingresar Numeros no Letras","Modo Contrareloj");
                         }
                     }
                     else{
                         exc=true;
                         throw new ExcepcionGame();
                     }
                     if(this.ind==true){
                         System.out.println("Dame numero de columna:");
                         try{
                             y=leer.nextInt();
                         }catch(InputMismatchException e){
                             throw new ExcepcionGame("Debes Ingresar Numeros no Letras","Modo Contrareloj");
                         }
                     }
                     else{
                         exc=true;
                         throw new ExcepcionGame();
                     }
                     try{
                         if(compmov(x,y)==true){
                             aceptar=true;
                         }
                         else{
                             aceptar=false;
                             System.out.println("Movimiento no Valido, Escoga Otra Vez");
                         }
                     }catch(ArrayIndexOutOfBoundsException ss){
                         aceptar=false;
                         System.out.println("Posicion no Valida");
                     }
                     
                 }catch(ExcepcionGame b){
                     if(exc==false){
                         aceptar=false;
                         b.mensaje();
                     }
                     else{
                         exc=false;
                         throw new TimeOut("Has Rebasado tu Tiempo Limite","Modo Contrareloj");
                     }
                     
                 }
             }while(aceptar==false);
             jugada(x,y,car,"Jugador");
        }catch(TimeOut c){
            c.mensaje();
        }
    }
    
    
    /** metodo jugada
     *  metodo que checara la jugada del usuario en el tablero dependiendo
     *  de la dificultad de juego que haya escogido el jugador y guardara en dos atributos el valor de la carta
     *  escogida. De igual forma guardara en un vector las posisiciones de la carta seleccionada
     *  para su posterior uso
     *  @param x - el valor del renglon donde estaba la carta
     *  @param y - el valor de la columna donde estaba la carta
     *  @param car - el numero de carta en el que va el jugador
     *  @param user - una cadena = "Jugador"
     *  @return regresa un entero indicando si es la primera o segunda carta del par que sigue
     * */
    private int jugada(int x, int y, int car,String user){
        switch(this.opc){
        case 1:
            mfacil[x][y]=String.valueOf(facil[x][y]);
            visualizarm();
            if(car==2){
               pos2=facil[x][y];
               pos[2]=x;
               pos[3]=y;
               car=1;
               comppar(user);
            }else{
                pos1=facil[x][y];
                pos[0]=x;
                pos[1]=y;
                car=2;
            }
            break;
        case 2:
            mmedio[x][y]=String.valueOf(medio[x][y]);
            visualizarm();
            if(car==2){
               pos2=medio[x][y];
               pos[2]=x;
               pos[3]=y;
               car=1;
               comppar(user);
            }else{
                pos1=medio[x][y];
                pos[0]=x;
                pos[1]=y;
                car=2;
            }
                break;
        case 3:
            mdificil[x][y]=String.valueOf(dificil[x][y]);
            visualizarm();
            if(car==2){
               pos2=dificil[x][y];
               pos[2]=x;
               pos[3]=y;
               car=1;
               comppar(user);
            }else{
                pos1=dificil[x][y];
                pos[0]=x;
                pos[1]=y;
                car=2;
            }
            break;
        }
        return car;
    }
    
    /** 
     * Metodo visualizarm, el cual visualiza en pantalla el tablero de juego
     * y los respectivos cambios que se hayan hecho en el
     * muestra un tablero de juego diferente dependiendo de la dificultad seleccionada
     * */
    private void visualizarm(){
        switch(this.opc){
        case 1:
            System.out.printf("0\t1\t2\t3\t4\t\t\t\t"+min+":"+seg+"\n");
            System.out.printf("-----------------------------------------------------\n");
            for(int i=0;i<2;i++){
                for(int j=0;j<5;j++){
                    System.out.printf("%s\t",mfacil[i][j]);
                }
                System.out.printf("|"+i+"\n");
            }
            break;
        case 2:
            System.out.printf("0\t1\t2\t3\t4\t5\n");
            System.out.printf("-----------------------------------------------------\n");
            for(int i=0;i<3;i++){
                for(int j=0;j<6;j++){
                    System.out.printf("%s\t",mmedio[i][j]);
                }
                System.out.printf("|"+i+"\n");
            }
            break;
        case 3:
            System.out.printf("0\t1\t2\t3\t4\t5\t6\n");
            System.out.printf("------------------------------------------------------------------------\n");
            for(int i=0;i<4;i++){
                for(int j=0;j<7;j++){
                    System.out.printf("%s\t",mdificil[i][j]);
                }
                System.out.printf("|"+i+"\n");
            }
            break;
        }
    }
    
    /** metodo comprobar el cual comprobara si todos los pares del tablero han
     * sido descubiertos de este*/
    public boolean comprobar(){
        boolean ind=false;
        switch(this.opc){
        case 1:
            for(int i=0;i<2;i++){
                for(int j=0;j<5;j++){
                    if(mfacil[i][j].equals("*")==false){
                        ind=true;
                    }
                    else{
                        ind=false;
                        break;
                    }
                }
            }
            break;
        case 2:
            for(int i=0;i<3;i++){
                for(int j=0;j<6;j++){
                    if(mmedio[i][j].equals("*")==false){
                        ind=true;
                    }
                    else{
                        ind=false;
                        break;
                    }
                }
            }
            break;
        case 3:
            for(int i=0;i<4;i++){
                for(int j=0;j<7;j++){
                    if(mdificil[i][j].equals("*")==false){
                        ind=true;
                    }
                    else{
                        ind=false;
                        break;
                    }
                }
            }
            break;
        }
        return ind;
    }
    
    /**metodo comppar que comprobara si las dos cartas escogidas
     * por el jugador contienen el mismo valor
     * si es asi se le asigna un punto
     * en caso contrario esconde las cartas en el tablero
     * @param user - una cadena = "Jugador"
     * */
    public void comppar(String user){
        if(pos1==pos2){
           if(user.equals("Jugador")==true)
                pj++;
        }
        else{
            switch(this.opc){
            case 1:
                mfacil[pos[0]][pos[1]]="*";
                mfacil[pos[2]][pos[3]]="*";
                break;
            case 2:
                mmedio[pos[0]][pos[1]]="*";
                mmedio[pos[2]][pos[3]]="*";
                break;
            case 3:
                mdificil[pos[0]][pos[1]]="*";
                mdificil[pos[2]][pos[3]]="*";
                break;
            }
        }
    }
    
    /** 
     * metodo que comprobara si la posicion seleccionada por el jugador no esta repetida
     * @param x - el renglon donde estaba la carta
     * @param y - la columna donde estaba la carta
     * @return regresa false si la posicion esta repetida y true si no  es asi
     * */
    public boolean compmov(int x, int y){
        boolean ind=false;
        switch(this.opc){
        case 1:
            if(mfacil[x][y].equals("*")==true){
                ind= true;
            }
            else{
                ind= false;
            }
            break;
        case 2:
            if(mmedio[x][y].equals("*")==true){
                ind=true;
            }
            else{
                ind=false;
            }
            break;
        case 3:
            if(mdificil[x][y].equals("*")==true){
                ind=true;
            }
            else{
                ind= false;
            }
            break;
        }
        return ind;
    }
    
    
    /**Metodo que inicializara el contador de tiempo */
    public void initReloj(){
        Thread r1 = new Thread(this,"Reloj");
        r1.start();
    }
    
    public static void main(String [] arg){
        Contrareloj s = new Contrareloj(1,0,20);
        
    }


/**Metodo sobreescrito de la interfaz Runnable en el cual
 * se ejecutaran el contador de tiempo*/
    @Override
    public void run() {
        while(ind==true){
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
            } catch (InterruptedException e) {
                
            }
        }
    }
}
