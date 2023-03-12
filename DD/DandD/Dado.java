package DandD;
//----------------------------------------
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Dado extends Rectangle{
    static int GAME_WIDTH;
    static int GAME_HEIGHT;
    //-----------------------
    int dado_20 = 3;
    int dado_10 = 3;
    int dado_6 = 1;
    int dado_somma = 0;
    int x = 1;
    int y = 1;
    int z = 1;
    //-----------------------
    private ImageIcon v;
    private ImageIcon v1;
    private ImageIcon v2;
    private ImageIcon v3;
    private ImageIcon v4;
    private ImageIcon v5;
    private ImageIcon v6;
    private ImageIcon v7;
    private ImageIcon v8;
    private ImageIcon v9;
    //-----------------------
    private Image vi;
    private Image vi1;
    private Image vi2;
    private Image vi3;
    private Image vi4;
    private Image vi5;
    private Image vi6;
    private Image vi7;
    private Image vi8;
    private Image vi9;
    //-----------------------
    int vita;
    int attacco;
    int difesa;
    int velocità;
    int agilità;
    int mana;
    //-----------------------
    int vitam;
    int vitam1;
    int vitam2;
    int vitam3;
    int vitam4;
    int vitam5;
    int vitam6;
    int attaccom;
    //-----------------------
    int vitams;
    int vitas;
    int manas;
    //-----------------------
    Client danno;

    Dado(int GAME_WIDTH, int GAME_HEIGHT){
        Dado.GAME_WIDTH = GAME_WIDTH;
        Dado.GAME_HEIGHT = GAME_HEIGHT;
        //-----------------------------------------------
        
        //-----------------------------------------------
        
        v=new ImageIcon("DD/Mappe/OIP.png");
        vi=v.getImage();
        v1=new ImageIcon("DD/Mappe/Dado6.png");
        vi1=v1.getImage();
        v2=new ImageIcon("DD/Mappe/Dado10.png");
        vi2=v2.getImage();
        //-----------------------------------------------

        vita=100;
        attacco=70;
        difesa=50;
        velocità=50;
        agilità=50;
        mana=100;

        vitam = 1000;
        vitam1 = 2000;
        vitam2 = 4000;
        vitam3 = 5000;
        vitam4 = 6500;
        vitam5 = 7500;
        vitam6 = 10000;

        //-----------------------------------------------
        v3=new ImageIcon("DD/Nuova cartella/Villain_npc.png");
        vi3=v3.getImage();
        v4=new ImageIcon("DD/Nuova cartella/Monster.png");
        vi4=v4.getImage();
        v5=new ImageIcon("DD/Nuova cartella/Golem_di_ghiaccio.png");
        vi5=v5.getImage();
        v6=new ImageIcon("DD/Nuova cartella/Golem.png");
        vi6=v6.getImage();
        v7=new ImageIcon("DD/Nuova cartella/Villain_necromant.png");
        vi7=v7.getImage();
        v8=new ImageIcon("DD/Nuova cartella/NPC_FinalBoss_assist.png");
        vi8=v8.getImage();
        v9=new ImageIcon("DD/Nuova cartella/Idra.png");
        vi9=v9.getImage();
    }

    public void draw(Graphics g){
        //----------------------- Dadi -----------------------------
        g.drawImage(vi, 25, 180, 80, 90, null);
        g.drawImage(vi1, 120, 100, 80, 90, null);
        g.drawImage(vi2, 25, 80, 80, 90, null);
        //----------------------- Facce principali ---------------------------------
        g.setFont(new Font("Consolas",Font.PLAIN,20));
        //dado_20
		g.setColor(Color.BLACK);
		g.drawString(String.valueOf(dado_20), 58, 230);
        //dado_10
		g.setColor(Color.WHITE);
		g.drawString(String.valueOf(dado_10), 59, 130);
        //dado_6
        g.setColor(Color.BLACK);
		g.drawString(String.valueOf(dado_6), 153, 147);
        //------------------------- Facce secondarie ----------------------------------
        //dado_20
        g.setFont(new Font("Consolas",Font.PLAIN,15));
        g.setColor(Color.BLACK);
		g.drawString(String.valueOf(dado_20+1), 38, 220);
		if(dado_20 == 1 || dado_20 == 0){dado_20=dado_20 + 21;}
        g.drawString(String.valueOf(dado_20-1), 82, 220);
        if(dado_20 == 2){dado_20=dado_20 + 21;}
		g.drawString(String.valueOf(dado_20-2), 60, 255);
        //dado_10
        g.setColor(Color.WHITE);
        if(dado_10==1){dado_10=dado_10+1;}
        g.drawString(String.valueOf(dado_10-1), 33, 130);
        if(dado_10 == 10){dado_10=dado_10-9;}
        g.drawString(String.valueOf(dado_10+1), 89, 130);
        g.drawString(String.valueOf(dado_10+2), 60, 157);
        //dado_6
        g.setColor(Color.BLACK);
        g.setFont(new Font("Consolas",Font.PLAIN,6));
        if(dado_6==1){dado_6=dado_6+7;}
        g.drawString(String.valueOf(dado_6-1), 157, 180);
        //------------------------- Statistiche PG ----------------------------------
        g.setFont(new Font("Consolas",Font.PLAIN,15));
		g.setColor(Color.WHITE);
		g.drawString(String.valueOf("Health: "), 1065, 450);
        g.drawString(String.valueOf("Mana: "), 1065, 470);
        g.drawString(String.valueOf("Attack: "+ attacco), 1065, 490);
        g.drawString(String.valueOf("Defense: "+ difesa), 1065, 510);
        g.drawString(String.valueOf("Speed: "+ velocità), 1065, 530);
        g.drawString(String.valueOf("Agility: "+ agilità), 1065, 550);

        switch (y){
            case 1 :
                if(vita <= 100){
                    g.setColor(Color.GRAY);
                    g.fillRect(1130, 437, 101, 15);
                    g.setColor(Color.GREEN);
                    g.fillRect(1131, 438, (vitas = vita/y), 13);
                }else{
                    y = 2;
                }
                break;
            case 2 :
                if(vita <= 200){
                    g.setColor(Color.GRAY);
                    g.fillRect(1130, 437, 101, 15);
                    g.setColor(Color.GREEN);
                    g.fillRect(1131, 438, (vitas = vita/y), 13);
                }else{
                    y = 3;
                }
                break;
            case 3 :
                if(vita <= 300){
                    g.setColor(Color.GRAY);
                    g.fillRect(1130, 437, 101, 15);
                    g.setColor(Color.GREEN);
                    g.fillRect(1131, 438, (vitas = vita/y), 13);
                }else{
                    y = 3;
                }
                break;
            case 4 :
                if(vita <= 300){
                    g.setColor(Color.GRAY);
                    g.fillRect(1130, 437, 101, 15);
                    g.setColor(Color.GREEN);
                    g.fillRect(1131, 438, (vitas = vita/y), 13);
                }
                break;
        }

        switch (z){
            case 1 :
                if(mana <= 100){
                    g.setColor(Color.GRAY);
                    g.fillRect(1130, 457, 101, 15);
                    g.setColor(Color.BLUE);
                    g.fillRect(1131, 458, (manas = mana/z), 13);
                }else{
                    z = 2;
                }
                break;
            case 2 :
                if(mana <= 200){
                    g.setColor(Color.GRAY);
                    g.fillRect(1130, 457, 101, 15);
                    g.setColor(Color.BLUE);
                    g.fillRect(1131, 458, (manas = mana/z), 13);
                }else{
                    z = 3;
                }
                break;
            case 3 :
                if(mana <= 300){
                    g.setColor(Color.GRAY);
                    g.fillRect(1130, 457, 101, 15);
                    g.setColor(Color.BLUE);
                    g.fillRect(1131, 458, (manas = mana/z), 13);
                }else{
                    z = 3;
                }
                break;
            case 4 :
                if(mana <= 400){
                    g.setColor(Color.GRAY);
                    g.fillRect(1130, 457, 101, 15);
                    g.setColor(Color.BLUE);
                    g.fillRect(1131, 458, (manas = mana/z), 13);
                }
                break;
        }

        //---------------------------- Mostri ----------------------------------
        switch (x) {
            case 1:
                if(vitam > 0){
                    g.drawImage(vi3, 400, 250, 200, 250, null);
                    g.setColor(Color.GRAY);
                    g.fillRect(600, 250, 15, 251);
                    g.setColor(Color.RED);
                    g.fillRect(601, 251, 13, (vitams = (vitam/4)));
                }
                else{
                    if(vita > 0){
                        x = 2;
                        vita = vita + 70;
                        attacco = attacco + 10;
                        mana = mana + 50;
                    }
                    else{
                        x = 8;
                    }
                }
                break;

                case 2:
                if(vitam1 > 0){
                    g.drawImage(vi4, 400, 250, 200, 250, null);
                    g.setColor(Color.GRAY);
                    g.fillRect(600, 250, 15, 251);
                    g.setColor(Color.RED);
                    g.fillRect(601, 251, 13, (vitams = (vitam1/8)));
                }
                else{
                    if(vita > 0){
                        x = 3;
                        vita = vita + 90;
                        attacco = attacco + 40;
                        mana = mana + 50;
                    }
                    else{
                        x = 8;
                    }
                }
                break;
    
            case 3:
                if(vitam2 > 0){
                    g.drawImage(vi5, 400, 250, 200, 250, null);
                    g.setColor(Color.GRAY);
                    g.fillRect(600, 250, 15, 251);
                    g.setColor(Color.RED);
                    g.fillRect(601, 251, 13, (vitams = (vitam2/16)));
                }
                else{
                    if(vita > 0){
                        x = 4;
                        vita = vita + 140;
                        attacco = attacco + 60;
                        mana = mana + 50;
                    }
                    else{
                        x = 8;
                    }
                }
                break;

            case 4:
                if(vitam3 > 0){
                    g.drawImage(vi6, 400, 250, 200, 250, null);
                    g.setColor(Color.GRAY);
                    g.fillRect(600, 250, 15, 251);
                    g.setColor(Color.RED);
                    g.fillRect(601, 251, 13, (vitams = (vitam3/20)));
                }
                else{
                    if(vita > 0){
                        x = 5;
                        vita = vita + 160;
                        attacco = attacco + 80;
                        mana = mana + 50;
                    }
                    else{
                        x = 8;
                    }
                }
                break;

            case 5:
                if(vitam4 > 0){
                    g.drawImage(vi7, 400, 250, 200, 250, null);
                    g.setColor(Color.GRAY);
                    g.fillRect(600, 250, 15, 251);
                    g.setColor(Color.RED);
                    g.fillRect(601, 251, 13, (vitams = (vitam4/26)));
                }
                else{
                    if(vita > 0){
                        x = 6;
                        vita = vita + 180;
                        attacco = attacco + 100;
                        mana = mana + 50;
                    }
                    else{
                        x = 8;
                    }
                }
                break;

            case 6:
                if(vitam5 > 0){
                    g.drawImage(vi8, 400, 250, 200, 250, null);
                    g.setColor(Color.GRAY);
                    g.fillRect(600, 250, 15, 251);
                    g.setColor(Color.RED);
                    g.fillRect(601, 251, 13, (vitams = (vitam5/30)));
                }
                else{
                    if(vita > 0){
                        x = 7;
                        vita = vita + 200;
                        attacco = attacco + 120;
                        mana = mana + 50;
                    }
                    else{
                        x = 8;
                    }
                }
                break;

            case 7:
                if(vitam6 > 0){
                    g.drawImage(vi9, 400, 250, 200, 250, null);
                    g.setColor(Color.GRAY);
                    g.fillRect(600, 250, 15, 251);
                    g.setColor(Color.RED);
                    g.fillRect(601, 251, 13, (vitams = (vitam6/40)));
                }
                else{
                    x = 8;
                }
                break;
                
            case 8:
                if(vita > 0){
                    g.setFont(new Font("Consolas",Font.PLAIN,50));
                    g.setColor(Color.YELLOW);
                    g.drawString(String.valueOf("YOU WIN"), (GAME_WIDTH/2), (GAME_HEIGHT/2));
                }
                else{
                    g.setFont(new Font("Consolas",Font.PLAIN,50));
                    g.setColor(Color.RED);
                    g.drawString(String.valueOf("YOU LOSE"), (GAME_WIDTH/2), (GAME_HEIGHT/2));
                }
                break;
        }
    }

    //-----------------------------------------------------------------------------------------
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_SPACE) {
            dado_somma = 0;
            dado_20 = (int) (Math.random() * 20) + 1;
            dado_10 = (int) (Math.random() * 10) + 1;
            dado_6 = (int) (Math.random() * 6) + 1;
            dado_somma = attacco + (dado_20 +(dado_20+1)+(dado_20-1)+(dado_20-2)) + (dado_10 +(dado_10+1)+(dado_10-1)+(dado_10+2)) + (dado_6);
            switch (x){
                case 1:
                    vitam = vitam - dado_somma;
                    vitam = vitam - danno.dato;
                    attaccom = (int) (Math.random()*10) + 1;
                    vita = vita - attaccom;
                    mana = mana - 2;
                    break;
                case 2:
                    vitam1 = vitam1 - dado_somma;
                    vitam = vitam - danno.dato;
                    attaccom = (int) (Math.random()*10) + 1;
                    vita = vita - attaccom;
                    mana = mana - 2;
                    break;
                case 3:
                    vitam2 = vitam2 - dado_somma;
                    vitam = vitam - danno.dato;
                    attaccom = (int) (Math.random()*10) + 1;
                    vita = vita - attaccom;
                    mana = mana - 2;
                    break;
                case 4:
                    vitam3 = vitam3 - dado_somma;
                    vitam = vitam - danno.dato;
                    attaccom = (int) (Math.random()*10) + 1;
                    vita = vita - attaccom;
                    mana = mana - 2;
                    break;
                case 5:
                    vitam4 = vitam4 - dado_somma;
                    vitam = vitam - danno.dato;
                    attaccom = (int) (Math.random()*15) + 1;
                    vita = vita - attaccom;
                    mana = mana - 2;
                    break;
                case 6:
                    vitam5 = vitam5 - dado_somma;
                    vitam = vitam - danno.dato;
                    attaccom = (int) (Math.random()*17) + 1;
                    vita = vita - attaccom;
                    mana = mana - 2;
                    break;
                case 7:
                    vitam6 = vitam6 - dado_somma;
                    vitam = vitam - danno.dato;
                    attaccom = (int) (Math.random()*20) + 1;
                    vita = vita - attaccom;
                    mana = mana - 2;
                    break;
            }
        }
    }
}