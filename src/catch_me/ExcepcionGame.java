package catch_me;

import java.util.InputMismatchException;

import javax.swing.JOptionPane;

/**Clase ExcepcionGame  Luis Ernesto Sierra Alva - Luis Humberto Ponce Hermosillo 
 * clase que contendra el metodo con el cual se mostrara el mensaje de error ante una excepcion que ocurra
 * en el juego*/

public class ExcepcionGame extends Exception{
    
    public String error;
    public String origen;
    
    /**Constructor de la clase, recibe como parametro un mensaje de error y el nombre
     * de la ventana, modo de juego donde se produzca la excepcion*/
    public ExcepcionGame(String e, String o){
        this.error=e;
        this.origen=o;
    }
    
    public ExcepcionGame(){
        
    }
    /**Metodo que mostrara el mensaje de error al usuario al generarse la excepcion */
    public  void mensaje(){
        JOptionPane.showMessageDialog(null,this.error,this.origen+" dice:",JOptionPane.INFORMATION_MESSAGE);
    }

}


    /** 
     * clase que extiende de ExcepcionGame y que
     * tiene el proposito de mostrar los mensajes
     * de aviso cuando el tiempo limite de la partida acabe
     * */
class TimeOut extends ExcepcionGame{
        
    /**Constructor de la clase, recibe como parametro un mensaje de error y el nombre
     * de la ventana, modo de juego donde se produzca la excepcion
     * y los manda comdo parametro al constructor de la superclase*/
    public TimeOut(String error,String origen){
        super(error,origen);
    }
    /**Metodo que mostrara el mensaje de error al usuario al generarse la excepcion */
    public void mensaje(){
        JOptionPane.showMessageDialog(null,error,origen+" dice:",JOptionPane.INFORMATION_MESSAGE);
    }
}

