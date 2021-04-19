package catch_me;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

    /** 
     * Clase Vrcomputadora
     * clase en la que se desarrolla el modo de juego de jugador contra la computadora
     * en una de las tres dificultades seleccionadas
     * esta clase extiende de la clase Matriz
     * */

public class Vrcomputadora extends Matriz {
    
    int opc,pj=0,pc=0,pos1,pos2;
    int [] pos= new int[4];
    Random ran = new Random(new Date().getTime());
    
    
    /** 
     * Constructor de la clase
     * recibe como parametro la opcion que haya escogido el usuario
     * y lo asigna al atributo de la superclase opc
     * despues ejecuta los metodos que hereda de ella
     * y luego inicia el juego
     * @param opc - la opcion del jugador
     * */
    public Vrcomputadora(int opc){
        super.opc=opc;
        this.opc=opc;
        inicializar1();
        llenar();
        inicializar2();
        juego();
    }
        
  
    public static void main(String [] arg){
        Vrcomputadora a = new Vrcomputadora(1);
        
    }
    
    /** 
     * Metodo que lleva todo el proceso del juego
     * del usuario y de la computadora
     * */
    private void juego(){
        boolean ind=false,ind2=true;
        System.out.println("Comencemos");
        System.out.println("Cada Carta esta");
        while(ind==false){
            visualizarm();
            if(ind2==true){
                ind2=usuario();
                System.out.println("");
                System.out.println("");
            }
            else{
                ind2=computadora();
                System.out.println("");
                System.out.println("");
            }
            if(comprobar()==true){
                ind=true;
            }
        }
        if(pc>pj){
            ResultadoC res = new ResultadoC();
            res.resultado("Computadora Gana",pc,pj);
            
            
        }
        else{
            ResultadoC res = new ResultadoC();
            res.resultado("Jugador Gana",pc,pj);
        }
    }
    
    /** 
     * metodo que lleva el proceso de juego del jugador
     * en el el jugador selecciona sus dos cartas
     * y se determina si acerto o equivoco
     * regresa false para indicar que su turno acabo
     * */
    private boolean usuario(){
        int x=0,y=0,car=0;
        boolean aceptar=false, exc=false;
        System.out.println("Jugador:"+pj+" Puntos");
            do{
                try{
                     Scanner leer = new Scanner(System.in);
                            System.out.println("Dame numero de renglon:");
                            try{
                                x=leer.nextInt();
                            }catch(InputMismatchException e){
                                throw new ExcepcionGame("Debes Ingresar Numeros no Letras","Modo Contrareloj");
                            }
                            System.out.println("Dame numero de columna:");
                            try{
                                y=leer.nextInt();
                            }catch(InputMismatchException e){
                                throw new ExcepcionGame("Debes Ingresar Numeros no Letras","Modo Contrareloj");
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
                        aceptar=false;
                        a.mensaje();
                    }
             }while(aceptar==false);            

             car=1;
             car=jugada(x,y,car,"Jugador");
             aceptar=false;
             do{
                 try{
                     Scanner leer = new Scanner(System.in);
                         System.out.println("Dame numero de renglon:");
                         try{
                             x=leer.nextInt();
                         }catch(InputMismatchException e){
                             throw new ExcepcionGame("Debes Ingresar Numeros no Letras","Modo Contrareloj");
                         }
                         System.out.println("Dame numero de columna:");
                         try{
                             y=leer.nextInt();
                         }catch(InputMismatchException e){
                             throw new ExcepcionGame("Debes Ingresar Numeros no Letras","Modo Contrareloj");
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
                         aceptar=false;
                         b.mensaje();
                 }
             }while(aceptar==false);
             jugada(x,y,car,"Jugador");
            return false;
    }
    
    
    /** 
     * metodo que lleva el proceso de juego de la computadora
     * en el que la computadora selecciona sus dos cartas
     * y se determina si acerto o equivoco
     * regresa true para indicar que su turno acabo
     * */
    private boolean computadora(){
        int x,y,car=0;
        boolean aceptar=true;
        System.out.println("Computadora:"+pc+" Puntos");
        do{
            System.out.println("Dame numero de renglon:");
            x=(int)(ran.nextDouble()*2);
            System.out.println(x);
            System.out.println("Dame numero de columna:");
            y=(int)(ran.nextDouble()*5);
            System.out.println(y);
            if(compmov(x,y)==true){
                aceptar=true;
            }
            else{
                aceptar=false;
                System.out.println("Movimiento no Valido, Escoga Otra Vez");
            }
        }while(aceptar==false);
        
        car=1;
        car=jugada(x,y,car,"Computadora");
        aceptar=false;
        
        do{
            System.out.println("Dame numero de renglon:");
            x=(int)(ran.nextDouble()*2);
            System.out.println(x);
            System.out.println("Dame numero de columna:");
            y=(int)(ran.nextDouble()*5);
            System.out.println(y);
            if(compmov(x,y)==true){
                aceptar=true;
            }
            else{
                aceptar=false;
                System.out.println("Movimiento no Valido, Escoga Otra Vez");
            }
        }while(aceptar==false);
        
        jugada(x,y,car,"Computadora");
        return true;
    }
    
    
    /** 
     * metodo que gestiona la jugada de la computadora
     * y del jugador y muestra en el tablero
     * las cartas seleccionadas por ambos jugadores
     * @param x - el renglon donde se saco la carta
     * @param y - la columna donde se saco la carta
     * @param car - el numero de carta
     * @param user - una cadena indicando de quien es turno
     * @return un entero indicando el numero de carta que sigue
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
            System.out.printf("0\t1\t2\t3\t4\n");
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
     * por el jugador o la computadora contienen el mismo valor
     * y si es asi se le asigna un punto al jugador correspondiente
     * en caso contrario oculta las cartas de nuevo
     * @param user - una cadena indicando de quien es el par a revisar
     * */
   public void comppar(String user){
       if(pos1==pos2){
          if(user.equals("Jugador")==true)
               pj++;
          if(user.equals("Computadora")==true)
              pc++;
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
}
