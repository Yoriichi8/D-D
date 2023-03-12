package DandD;

//-----------------------------------
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

//------------------------------------
public class MainFrame {
  final int FRAME_WIDTH = 1000;
  final int FRAME_HEIGHT = 600;
  final int BLOCK_WIDTH = 250;
  final int BLOCK_HEIGHT = 50;
  JFrame frame;

  public MainFrame() {
    frame = new JFrame("Dangeons&Dragons");
    frame.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
    frame.setResizable(false);
    frame.setBackground(Color.black);

    try {
      // Legge l'immagine da file
      BufferedImage originalImage = ImageIO.read(new File("DD/Mappe/background.jpg"));
      // Crea un'immagine di dimensioni ridotte
      BufferedImage resizedImage = new BufferedImage(FRAME_WIDTH, FRAME_HEIGHT, originalImage.getType());
      resizedImage.createGraphics().drawImage(originalImage, 0, 0, FRAME_WIDTH, FRAME_HEIGHT, null); // Disegna l'immagine originale sulla nuova immagine con le dimensioni ridotte
      ImageIO.write(resizedImage, "jpg", new File("DD/Mappe/background.jpg")); // Salva l'immagine ridimensionata su file
    } catch (Exception e) {
      e.printStackTrace();
    }

    Image backgroundImage = new ImageIcon("DD/Mappe/background.jpg").getImage();
    backgroundImage.getScaledInstance(FRAME_WIDTH, FRAME_HEIGHT, Image.SCALE_DEFAULT);
    JLabel background = new JLabel(new ImageIcon(backgroundImage));
    frame.setContentPane(background);
    // -------------- Offline --------------------------------------------------------
    JButton Offline = new JButton("OFFLINE");
    Offline.setBounds((FRAME_WIDTH - FRAME_WIDTH), (FRAME_HEIGHT - 97), (BLOCK_WIDTH), (BLOCK_HEIGHT)); // X - Y - lunghezza blocco - altezza blocco 250-100-100-50
    Offline.setBackground(Color.BLACK);
    Offline.setForeground(Color.WHITE);
    Offline.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        frame.dispose();
        new Selezione();
      }
    });

    background.add(Offline);
    // -------------- Online ----------------------------------------------------------
    JButton Online = new JButton("ONLINE");
    Online.setBounds((FRAME_WIDTH - 750), (FRAME_HEIGHT - 97), (BLOCK_WIDTH), (BLOCK_HEIGHT)); // X - Y - lunghezza blocco - altezza blocco 250-300-100-50
    Online.setBackground(Color.BLACK);
    Online.setForeground(Color.WHITE);
    Online.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        frame.dispose();
        new Client();
      }
    });

    background.add(Online);
    // -------------- Opzioni ----------------------------------------------------------
    JButton Option = new JButton("OPTION");
    Option.setBounds((FRAME_WIDTH - 500), (FRAME_HEIGHT - 97), (BLOCK_WIDTH), (BLOCK_HEIGHT)); // X - Y - lunghezza blocco - altezza blocco 250-300-100-50
    Option.setBackground(Color.BLACK);
    Option.setForeground(Color.WHITE);
    Option.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        frame.dispose();
      }
    });

    background.add(Option);
    // -------------- Esci --------------------------------------------------------------
    JButton Exit = new JButton("EXIT");
    Exit.setBounds((FRAME_WIDTH - 250), (FRAME_HEIGHT - 97), (BLOCK_WIDTH), (BLOCK_HEIGHT)); // X - Y - lunghezza blocco - altezza blocco 250-500-100-50
    Exit.setBackground(Color.BLACK);
    Exit.setForeground(Color.WHITE);
    Exit.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
      }
    });

    background.add(Exit);

    frame.setLayout(null);
    frame.pack();
    frame.setVisible(true);
  }
}