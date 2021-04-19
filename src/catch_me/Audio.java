package catch_me;

import java.io.File;

import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import javax.swing.JOptionPane;

public class Audio{
    
    public static int caso=0;
    
      Audio() {
        super();
    }
    
    public static void reproducir(){
        
        Runnable Run = new Runnable(){
            public void run(){
                String path="";
                if(Audio.caso==0){
                    path="Sonidos\\1.wav";
                }
                else{
                    path="Sonidos\\2.wav";
                }
                Clip sonido1;
                try {
                    sonido1 = AudioSystem.getClip();
                    sonido1.open(AudioSystem.getAudioInputStream(new File(path)));
                    sonido1.start();
                    sonido1.loop(2);
                    while(sonido1.isRunning());{
                        try {
                            System.out.println("---------------");
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                        }
                    }
                    
                     sonido1.close();   

                } catch (LineUnavailableException e) {
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "El Archivo de Audio no se pudo reproducir","Error",JOptionPane.ERROR_MESSAGE);
                } catch (UnsupportedAudioFileException e) {
                }
            }
        };
        Run.run();
        
    }
}
