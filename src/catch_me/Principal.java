package catch_me;

import java.util.InputMismatchException;
import java.util.Scanner;


/**Clase Principal
 * clase que contiene el metodo principal con el cual se ejecutara el programa y al hacerlo
 * mostrara un menu de opciones al usuario para poder ingresar al juego*/
public class Principal {
    
    /**Metodo principal el cual ejecuta el inicio del juego y mostrara una serie de opciones al jugador
     * pide al usuario que ingrese un determinado numero y esto ejecuta una de las tres opciones disponibles
     * en este menu principal. si el usuario ingresa algo diferente de una letra se lanzara una excepcion
     * mostrando un mensaje y volviendo a mostrar el menu principal hasta que el usuario ingrese un numero*/
    public static void main(String[] args) {
        int opc;
        do{
            Scanner leer = new Scanner(System.in);
            opc=0;
            try{
                try{
                        System.out.printf("\tBienvenido a Catch Me\n");
                        System.out.println("1-Entrar");
                        System.out.println("2-Acerca de Catch Me");
                        System.out.println("3-Salir");
                        System.out.println("Seleccione Opcion :");
                        opc=leer.nextInt();
                        switch(opc){
                        case 1:
                            SeleccionarModo sel = new SeleccionarModo();
                            sel.menu();
                            break;
                        case 2:
                           // Acercade ace = new Acercade();
                           // ace.informacion();
                            break;
                        case 3:
                            opc=3;
                            System.out.println("Gracias Por Jugar");
                            break;
                        default:
                            System.out.println("Opcion Incorrecta");
                            break;
                        }
                }catch(InputMismatchException a){
                    throw new ExcepcionGame("Debe Ingresar Numeros, No Letras","Menu Principal"); 
                }
            }catch(ExcepcionGame b){
                opc=0;
                b.mensaje();
            }
        }while(opc!=3);
    }
}
