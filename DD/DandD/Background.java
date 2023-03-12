package DandD;
//-----------------------------
import java.awt.*;
import javax.swing.*;
public class Background extends Rectangle{

    static int GAME_WIDTH;
    static int GAME_HEIGHT;
    private ImageIcon v;
    private Image vi;
    
    Background(int GAME_WIDTH, int GAME_HEIGHT){
        Background.GAME_WIDTH = GAME_WIDTH;
        Background.GAME_HEIGHT = GAME_HEIGHT;
        //-----------------------------------------------
        
        v=new ImageIcon("DD/Mappe/realworld.png");
        vi=v.getImage();
    }

    public void draw(Graphics g){
        g.drawImage(vi, (GAME_WIDTH-1335), (GAME_HEIGHT-680), (GAME_WIDTH-360), (GAME_HEIGHT-40), null);
    }
}
