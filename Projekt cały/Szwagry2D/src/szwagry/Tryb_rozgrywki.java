package szwagry;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Tryb_rozgrywki {
    
    public Rectangle playRedButton = new Rectangle(360,150,100,50);
    public Rectangle playBlueButton = new Rectangle(360,250,100,50);
    public Rectangle quitButton = new Rectangle(360,350,100,50);
 
    public void render(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        
        Font font1 = new Font("arial",Font.BOLD,50);
        g.setFont(font1);
        g.setColor(Color.white);
        g.drawString("Szwagry 2D", 260, 100);
        
        Font font2 = new Font("arial",Font.BOLD,20);
        g.setFont(font2);
        g.drawString("Play Red", playRedButton.x + 9, playRedButton.y +30);
        g.drawString("Play Blue", playBlueButton.x + 7, playBlueButton.y +30);
        g.drawString("Quit", quitButton.x +30, quitButton.y +30);
        g.drawString("Red", 69, 315);
        g.drawString("Blue", 695, 315);
        g2d.draw(playRedButton);
        g2d.draw(playBlueButton);
        g2d.draw(quitButton);
        g.drawImage(Postac.getPostacRedLayout(), 50, 200, null);
        g.drawImage(Postac.getPostacBlueLayout(), 678, 200, null);
    }
    public void zmienTryb(){}
    public void wybierzRozmiarMapy(){}
    
}
