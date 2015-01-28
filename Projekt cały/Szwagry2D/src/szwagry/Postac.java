package szwagry;

import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Postac implements MouseListener{
    
    public static int mx, my;
    public static Image image_red, image_blue;
               
    public void wybierzPostac(boolean choice)
    {
        Ingerencja.playerChoice = choice;
        Ingerencja.State = Ingerencja.STATE.GAME;
    }
    
    public static Image getPostacRedLayout()
    {
        return image_red = Ingerencja.getImageRed();
    }
    public static Image getPostacBlueLayout()
    {
        return image_blue = Ingerencja.getImageBlue();
    }
    
    public void mouseClicked(MouseEvent me) {
        }

    @Override
    public void mousePressed(MouseEvent me) {
        
        mx = me.getX();
        my = me.getY();
        
        
        if(mx >= 360 && mx <= 460)
        {
            if(my >= 150 && my <= 200)
            {
                wybierzPostac(true);              
            }
            if(my >= 250 && my <= 300)
            {
                wybierzPostac(false);
            }
            if(my >= 350 && my <= 400)
                System.exit(0);
        }
        
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
        }
}
