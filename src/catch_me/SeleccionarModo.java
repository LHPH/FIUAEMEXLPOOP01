package catch_me;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Scanner;

/**CLase SeleecionarModo
 * clase en la cual se mostrara un menu con los diferentes modos de juego que tiene Catch Me*/
public class SeleccionarModo {
   
   
   /**Metodo Menu el cual muestra un menu principal con todos los modos de juego que tiene
    * el juego, al ingresar una opcion, esta lo llevara a un submenu del modo de juego el cual
    * mostrara las dificultades del juego*/
    public void menu(){
        int opc,opc2;
        do{
            Scanner leer = new Scanner(System.in);
          try{
              try{
                        System.out.println("Catch Me: Juego de Memoria");
                        System.out.println("Menu de Opciones");
                        System.out.println("1-Jugar Contra Computadora");
                        System.out.println("2-Jugar Contra Jugador");
                        System.out.println("3-Jugar Contra Reloj");
                        System.out.println("4-Personalizada");
                        System.out.println("5-Seleccionar Tema");
                        System.out.println("6-Regresar al Menu Principal");
                        System.out.print("Dame Opcion: ");
                        opc=leer.nextInt();
                        switch(opc){
                        case 1:
                            do{
                                System.out.println("Escoga Dificultad:");
                                System.out.println("1-Facil");
                                System.out.println("2-Media");
                                System.out.println("3-Dificil");
                                System.out.println("4-Regresar");
                                opc2=leer.nextInt();
                                switch(opc2){
                                
                                case 1:
                                   Vrcomputadora v1 = new Vrcomputadora(1);
                                break;
                                
                                case 2:
                                    Vrcomputadora v2 = new Vrcomputadora(2);
                                break;
                                
                                case 3:
                                    Vrcomputadora v3 = new Vrcomputadora(3);
                                break;
                                
                                case 4:
                                     opc2=4;
                                break;
                                
                                default:
                                     System.out.println("Opcion Incorrecta");
                                break; 
                              }
                            }while(opc2!=4);
                            break;
                        case 2:
                            do{
                                System.out.println("Escoga Dificultad:");
                                System.out.println("1-Facil");
                                System.out.println("2-Media");
                                System.out.println("3-Dificil");
                                System.out.println("4-Regresar");
                                opc2=leer.nextInt();
                                switch(opc2){
                                
                                case 1:
                                  Vrjugador v1 = new Vrjugador(1);       
                                break;
                                
                                case 2:
                                  Vrjugador v2 = new Vrjugador(2); 
                                break;
                                
                                case 3:
                                  Vrjugador v3 = new Vrjugador(3);     
                                break;
                                case 4:
                                     opc2=4;
                                break;
                                default:
                                     System.out.println("Opcion Incorrecta");
                                break; 
                              }
                            }while(opc2!=4);
                            
                            break;
                        case 3:
                            do{
                                System.out.println("Escoga Dificultad:");
                                System.out.println("1-Facil");
                                System.out.println("2-Media");
                                System.out.println("3-Dificil");
                                System.out.println("4-Regresar");
                                opc2=leer.nextInt();
                                switch(opc2){
                                
                                case 1:
                                   Contrareloj v = new Contrareloj(1,0,59);   
                                break;
                                
                                case 2:
                                  Contrareloj v2 = new Contrareloj(2,0,59);  
                                break;
                                
                                case 3:
                                  Contrareloj v3 = new Contrareloj(3,0,59);      
                                break;
                                
                                case 4:
                                     opc2=4;
                                break;
                                
                                default:
                                     System.out.println("Opcion Incorrecta");
                                break; 
                              }
                            }while(opc2!=4);
                            break;
                        case 4:
                            
                            break;
                        case 5:
                             CambiarFondo cf = new CambiarFondo();
                            break;
                        case 6:
                          opc=6;
                            break;
                        default:
                            System.out.println("Opcion Incorrecta");
                        }                
                }catch(InputMismatchException a){
                   throw new ExcepcionGame("Debe Ingresar numeros, no letras","Catch Me: Menu Principal");
                }
          }catch (ExcepcionGame e) {
               e.mensaje();
               opc=0;
               opc2=0;
            }
        }while(opc!=6);
    }
}
