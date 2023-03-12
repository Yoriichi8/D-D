package DandD;
//-----------------------------------
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
//-----------------------------------
public class Selezione extends JPanel {
    String S_gender;
    String S_classe;
    String S_razza;
    String S_armi;
    String pg;
    int Frame_Width = 475;
    int Frame_Height = 600;
    JFrame frame;

    // -----------------------------------
    public Selezione() {
        frame = new JFrame("Dangeons&Dargons");
        // ---------------- Genere ----------------------------------------------------------------
        String gender[] = { "Maschio", "Femmina"};
        S_gender = (String) JOptionPane.showInputDialog(null, "Seleziona il GENERE:", "Selezione GENERE",JOptionPane.QUESTION_MESSAGE, null, gender, gender[0]);
        if (S_gender == null) {
            JOptionPane.showMessageDialog(null, "Non è stato inserito nessun GENERE. Prova di nuovo.", "Errore",JOptionPane.ERROR_MESSAGE);
            S_gender = (String) JOptionPane.showInputDialog(null, "Seleziona il GENERE:", "Selezione GENERE",JOptionPane.QUESTION_MESSAGE, null, gender, gender[0]);
        }
        // ---------------- Classe ---------------------------------------------------------------
        String classe[] = { "Guerriero", "Mago", "Berserk", "Curatore", "Assassino", "Samurai", "Spadaccino", "Combattente" };
        S_classe = (String) JOptionPane.showInputDialog(null, "Seleziona la CLASSE:", "Selezione CLASSE",JOptionPane.QUESTION_MESSAGE, null, classe, classe[0]);
        if (S_classe == null) {
            JOptionPane.showMessageDialog(null, "Non è stata inserita nessuna CLASSE. Prova di nuovo.", "Errore",JOptionPane.ERROR_MESSAGE);
            S_classe = (String) JOptionPane.showInputDialog(null, "Seleziona la CLASSE:", "Selezione CLASSE",JOptionPane.QUESTION_MESSAGE, null, classe, classe[0]);
        }
        // ---------------- Razza ---------------------------------------------------------------
        String razza[] = { "Elfo", "Umano", "Demone", "Nano", "Yokai", "Vampiro", "Licantropo", "Dragonico", "Strega"};
        S_razza = (String) JOptionPane.showInputDialog(null, "Seleziona la RAZZA:", "Selezione RAZZA",JOptionPane.QUESTION_MESSAGE, null, razza, razza[0]);
        if (S_razza == null) {
            JOptionPane.showMessageDialog(null, "Non è stata inserita nessuna RAZZA. Prova di nuovo.", "Errore",JOptionPane.ERROR_MESSAGE);
            S_razza = (String) JOptionPane.showInputDialog(null, "Seleziona la RAZZA:", "Selezione RAZZA",JOptionPane.QUESTION_MESSAGE, null, razza, razza[0]);
        }
        // ---------------- Razza ---------------------------------------------------------------
        String arma[] = { "Guantone", "Katana", "Falce", "Spadone", "Spada", "Mazza", "Magia"};
        S_armi = (String) JOptionPane.showInputDialog(null, "Seleziona l'ARMA:", "Selezione ARMA", JOptionPane.QUESTION_MESSAGE, null, arma, arma[0]);
        if (S_armi == null) {
            JOptionPane.showMessageDialog(null, "Non è stata inserita nessun ARMA. Prova di nuovo.", "Errore",JOptionPane.ERROR_MESSAGE);
            S_armi = (String) JOptionPane.showInputDialog(null, "Seleziona l'ARMA:", "Selezione ARMA",JOptionPane.QUESTION_MESSAGE, null, arma, arma[0]);
        }
        // -----------------------------------------------------------------------------------------
        if (S_classe == "Guerriero" && S_gender == "Maschio") {pg = "DD/Nuova cartella/Guerriero.jpg";}
        else{ if (S_classe == "Guerriero" && S_armi == "Femmina") {pg = "DD/Nuova cartella/Guerriera.jpg";}
        else{ if (S_classe == "Mago" && S_armi == "Magia" && S_gender == "Maschio") {pg = "DD/Nuova cartella/Mage.jpg";}
        else{ if (S_classe == "Mago" && S_armi == "Katana" || S_classe == "Mago" && S_gender == "Maschio") {pg = "DD/Nuova cartella/Spadaccino_mago.jpg";}
        else{ if (S_classe == "Mago" && S_armi == "Magia" && S_gender == "Femmina") {pg = "DD/Nuova cartella/Maga.jpg";}
        else{ if (S_classe == "Samurai" && S_gender == "Femmina") {pg = "DD/Nuova cartella/SamuraiF.jpg";}
        else{ if (S_classe == "Samurai" && S_gender == "Maschio") {pg = "DD/Nuova cartella/Samurai.jpg";}
        else{ if (S_classe == "Curatore" && S_gender == "Femmina") {pg = "DD/Nuova cartella/Curatore.jpg";}
        else{ if (S_classe == "Curatore" && S_gender == "Maschio") {pg = "DD/Nuova cartella/CuratoreM.jpg";}
        else{ if (S_classe == "Berserk") {pg = "DD/Nuova cartella/Berserk.jpg";}
        else{ if (S_classe == "Combattente" && S_gender == "Maschio") {pg = "DD/Nuova cartella/Combattente.jpg";}
        else{ if (S_classe == "Combattente" && S_gender == "Femmina") {pg = "DD/Nuova cartella/CombattenteF.jpg";}
        else{ if (S_classe == "Spadaccino" && S_gender == "Maschio" && S_razza == "Yokai") {pg = "DD/Nuova cartella/Spadaccino_yokai.jpg";}
        else{ if (S_classe == "Spadaccino" && S_gender == "Femmina" && S_razza == "Yokai") {pg = "DD/Nuova cartella/Spadaccina_yokai.jpg";}
        else{ if (S_classe == "Spadaccino" && S_gender == "Maschio") {pg = "DD/Nuova cartella/Spadaccino.jpg";}
        else{ if (S_classe == "Spadaccino" && S_gender == "Femmina") {pg = "DD/Nuova cartella/Spadaccina.jpg";}
        else{ if (S_classe == "Mago" && S_razza == "Strega" && S_gender == "Mashio") {pg = "DD/Nuova cartella/Stregone.jpg";}
        else{ if (S_classe == "Mago" && S_razza == "Strega" && S_gender == "Femmina") {pg = "DD/Nuova cartella/Strega.jpg";}
        else{ if (S_classe == "Assassino" && S_gender == "Maschio" && S_armi == "Magia") {pg = "DD/Nuova cartella/AssassinoM.jpg";}
        else{ if (S_classe == "Assassino" && S_gender == "Maschio") {pg = "DD/Nuova cartella/Assassino.jpg";}
        else{ if (S_classe == "Assassino" && S_gender == "Femmina" && S_razza == "Yokai") {pg = "DD/Nuova cartella/Assassina.jpg";}
        else{ if (S_classe == "Assassino" && S_gender == "Femmina") {pg = "DD/Nuova cartella/Assassina_yokai.jpg";}
        }}}}}}}}}}}}}}}}}}}}}
        // -----------------------------------------------------------------------------------------
        try {
            BufferedImage originalImage = ImageIO.read(new File(pg));
            // Crea un'immagine di dimensioni ridotte
            BufferedImage resizedImage = new BufferedImage(Frame_Width, Frame_Height, originalImage.getType());
            resizedImage.createGraphics().drawImage(originalImage, 0, 0, Frame_Width, Frame_Height, null);
            ImageIO.write(resizedImage, "jpg", new File(pg));
        } catch (Exception e) {
            e.printStackTrace();
        }

        Image backgroundImage = new ImageIcon(pg).getImage();
        backgroundImage.getScaledInstance(Frame_Width, Frame_Height, Image.SCALE_DEFAULT);
        JLabel background = new JLabel(new ImageIcon(backgroundImage));
        frame.setContentPane(background);
        // ---------------- Conferma e Annulla --------------------------------------------------
        JButton b1 = new JButton("ANNULLA");
        b1.setBounds((Frame_Width - 160), Frame_Height - 97, 165, 50);
        b1.setForeground(Color.BLACK);

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new MainFrame();
            }
        });
        // ----------------------------------------------------------------------------------
        JButton b3 = new JButton("CONFERMA");
        b3.setBounds((Frame_Width - 485), Frame_Height - 97, 165, 50);
        b3.setForeground(Color.BLACK);

        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new GameFrame();
            }
        });
        // -----------------------------------------------------------------------------------
        JButton b2 = new JButton("RICOSTRUISCI");
        b2.setBounds((Frame_Width - 315), Frame_Height - 97, 150, 50);
        b2.setForeground(Color.BLACK);

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new Selezione();
            }
        });

        background.add(b1);
        background.add(b2);
        background.add(b3);
        // -----------------------------------------------------------------------------------------
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setSize(Frame_Width, Frame_Height);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}