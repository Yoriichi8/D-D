package DandD;
import java.io.*;
import javax.sound.sampled.*;

public class Musica {
  
  public static void playSong(String fileName) {
    try {
      File file = new File(fileName);
      Clip clip = AudioSystem.getClip();
      clip.open(AudioSystem.getAudioInputStream(file));
      clip.start();
    } catch (Exception e) {
      System.out.println("Errore durante la riproduzione della canzone");
      e.printStackTrace();
    }
  }
}