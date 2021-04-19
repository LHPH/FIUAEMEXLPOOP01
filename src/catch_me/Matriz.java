package catch_me;

import java.util.Date;
import java.util.Random;


/**Clase Matriz
 * clase en la cual se inicializaran las matrices que contendran los pares a buscar en el juego
 * tres matrices por dificultad de juego que seran la base para la busqueda de valores
 * ,tres vectores contendiendo los valores de los pares y
 * tres matrices las cuales seran la mascara de las tres modalidades de juego*/
public class Matriz {
   public int [][] facil = new int[2][5];
    public int [][] medio = new int[3][6];
   public int [][] dificil = new int [4][7];
    int [] vfacil ={1,2,3,4,5};
    int [] vmedio ={1,2,3,4,5,6,7,8,9};
    int [] vdificil ={1,2,3,4,5,6,7,8,9,10,11,12,13,14};
    public String [][] mfacil=new String[2][5];
    public String [][] mmedio=new String[3][6];
    public String [][] mdificil = new String[4][7];
    Random r = new Random(new Date().getTime());
    public int opc;
    
    
    /**Metodo llenar el cual dependiendo de la opcion de dificultad que haya escogido el jugador
     * llenara uno de los tres arreglos bidimensionales con los respectivos valores del arreglo 
     * unidimensional destinado para el modo de juego. los valores del arreglo unidimensional se
     * iran colocando en la matriz dependiendo de la posicion sorteada de esta aleatoriamente
     * por el objeto de tipo Random*/    
    public void llenar(){
        int i=0;
        switch(this.opc){
        case 1:
            while(i<vfacil.length){
                    int n=(int)(r.nextDouble()*2);
                    int n1=(int)(r.nextDouble()*5);
                    int n2=(int)(r.nextDouble()*2);
                    int n3=(int)(r.nextDouble()*5);
                String aux="",aux1="";
                aux=""+n+""+n1;
                aux1=""+n2+""+n3;
                    if(facil[n][n1]==0 && facil[n2][n3]==0 && aux.equals(aux1)==false){
                        facil[n][n1]=vfacil[i];
                        facil[n2][n3]=vfacil[i];
                        i++;
                    }
                }
            
          break;
        case 2:
            while(i<vmedio.length){
                   int n=(int)(r.nextDouble()*3);
                   int n1=(int)(r.nextDouble()*6);
                   int n2=(int)(r.nextDouble()*3);
                   int n3=(int)(r.nextDouble()*6);
                   String aux="",aux1="";
                   aux=""+n+""+n1;
                   aux1=""+n2+""+n3;
                if(medio[n][n1]==0 && medio[n2][n3]==0 && aux.equals(aux1)==false ){
                   medio[n][n1]=vmedio[i];
                   medio[n2][n3]=vmedio[i];
                   i++;
               }
            }
            break;
        case 3:
            while(i<vdificil.length){
                    int n=(int)(r.nextDouble()*4);
                    int n1=(int)(r.nextDouble()*7);
                    int n2=(int)(r.nextDouble()*4);
                    int n3=(int)(r.nextDouble()*7);
                    String aux="",aux1="";
                    aux=""+n+""+n1;
                    aux1=""+n2+""+n3;
                    if(dificil[n][n1]==0 && dificil[n2][n3]==0 && aux.equals(aux1)==false ){
                        dificil[n][n1]=vdificil[i];
                        dificil[n2][n3]=vdificil[i];
                        i++;
                    }
                }
            break;
        }
    }
    
    /**Metodo inicializar1 el cual llenara de valores 0 a la matriz de la dificultad de juego
     * seleccionada por el usuario*/
    
    public void inicializar1(){
        switch(this.opc){
        case 1:
            for(int r=0;r<2;r++){
                for(int c=0;c<5;c++){
                    facil[r][c]=0;
                }
            }
            break;
        case 2:
            for(int r=0;r<3;r++){
                for(int c=0;c<6;c++){
                    medio[r][c]=0;
                }
            }
            break;
        case 3:
            for(int r=0;r<4;r++){
                for(int c=0;c<7;c++){
                    dificil[r][c]=0;
                }
            }
            break;
        }
        
    }
    
    /**Metodo inicializar2 el cual llenara a una de las tres matrices de tipo String dependiendo de la opcion
     * escogida por el usuario y las llenara de asteriscos, la cual sera el tablero de juego y los asteriscos
     * seran las cartas a escoger*/
    public void inicializar2(){
        switch(this.opc){
        case 1:
            for(int r=0;r<2;r++){
                for(int c=0;c<5;c++){
                    mfacil[r][c]="*";
                }
            }
            break;
        case 2:
            for(int r=0;r<3;r++){
                for(int c=0;c<6;c++){
                    mmedio[r][c]="*";
                }
            }
            break;
        case 3:
            for(int r=0;r<4;r++){
                for(int c=0;c<7;c++){
                    mdificil[r][c]="*";
                }
            }
            break;
        }
    }
}
