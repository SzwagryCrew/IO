package szwagry;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;

public class Ingerencja extends Applet implements Runnable, KeyListener {

private Użytkownik player;
public static Image image, currentSprite, character, characterDown, characterJumped,
                                          character1, characterDown1, characterJumped1, character1l, characterDown1l, characterJumped1l,
                                          character2, characterDown2, characterJumped2, character2l, characterDown2l, characterJumped2l,
        background;
private Graphics second;
public static URL base;
private static Background bg1, bg2;
public static boolean playerChoice =false;
private Tryb_rozgrywki menu;
//public static Thread music;
public static enum STATE{
MENU,
GAME};

public static STATE State = STATE.MENU;

@Override
public void init() {

setSize(800, 480);
setBackground(Color.BLACK);
setFocusable(true);
addKeyListener(this);
this.addMouseListener(new Postac());
menu = new Tryb_rozgrywki();

try {
    base = getCodeBase();
} catch (Exception e) {}

character1 = getImage(base, "data/characterRed.png");
characterDown1 = getImage(base, "data/downRed.png");
characterJumped1 = getImage(base, "data/jumpedRed.png");
character1l = getImage(base, "data/characterRedl.png");
characterDown1l = getImage(base, "data/downRedl.png");
characterJumped1l = getImage(base, "data/jumpedRedl.png");

character2 = getImage(base, "data/characterBlue.png");
characterDown2 = getImage(base, "data/downBlue.png");
characterJumped2 = getImage(base, "data/jumpedBlue.png");
character2l = getImage(base, "data/characterBluel.png");
characterDown2l = getImage(base, "data/downBluel.png");
characterJumped2l = getImage(base, "data/jumpedBluel.png");
background = getImage(base, "data/background.png");

Frame frame = (Frame) this.getParent().getParent();
frame.setTitle("Szwagry 2D");

}

public void start() {
    
bg1 = new Background(0,0);
bg2 = new Background(2160, 0); 
 
player = new Użytkownik();
Thread thread = new Thread(this);
thread.start();
 
}

@Override
public void stop() {}

@Override
public void destroy() {}

@Override
public void run() {
    
while (true) {
            playerChosen();
            
            player.update();
            
            if (player.isJumped()){
                currentSprite = characterJumped;
            }else if (player.isJumped() == false && player.isDucked() == false){
                currentSprite = character;
            }
                       
            bg1.update();
            bg2.update();
            repaint();
            try {
                Thread.sleep(17);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
}

public void playerChosen()
{
    if(playerChoice)
    {
        if(player.getDirection())
        {
            character = character1;
            characterDown = characterDown1;
            characterJumped = characterJumped1;
        }
        else
        {
            character = character1l;
            characterDown = characterDown1l;
            characterJumped = characterJumped1l;
        }
    }
    else
    {
        if(player.getDirection())
        {
            character = character2;
            characterDown = characterDown2;
            characterJumped = characterJumped2;
        }
        else
        {
            character = character2l;
            characterDown = characterDown2l;
            characterJumped = characterJumped2l;
        }
    }
}

public int pobierzPołożenieX()
{
    return player.getCenterX();
}

public int pobierzPołożenieY()
{
    return player.getCenterX();
}

public int licznikPrzeciwnikow()
{
    return 0;
}

@Override
public void update(Graphics g) {
    if(State == STATE.GAME){
    
    if (image == null) {
    image = createImage(this.getWidth(), this.getHeight());
    second = image.getGraphics();
    }

    second.setColor(getBackground());
    second.fillRect(0, 0, getWidth(), getHeight());
    second.setColor(getForeground());
    paint(second);
    
    g.drawImage(image, 0, 0, this);
    }
    else
    {
        menu.render(g);
    }
}

@Override
public void paint(Graphics g) {
    g.drawImage(background, bg1.getBgX(), bg1.getBgY(), this);
    g.drawImage(background, bg2.getBgX(), bg2.getBgY(), this);
    g.drawImage(currentSprite, player.getCenterX() - 37, player.getCenterY() - 51, this);
}

@Override
public void keyPressed(KeyEvent e) {
    if(State == STATE.GAME){
 switch (e.getKeyCode()) {

        case KeyEvent.VK_DOWN:
            currentSprite = characterDown;
            if (player.isJumped() == false){
                player.setDucked(true);
                player.setSpeedX(0);
            }
            break;

        case KeyEvent.VK_LEFT:
            player.moveLeft();
            player.setMovingLeft(true);
            break;

        case KeyEvent.VK_RIGHT:
            player.moveRight();
            player.setMovingRight(true);
            break;

        case KeyEvent.VK_SPACE:
            player.jump();
            break;

        }
    }else if(State == STATE.MENU){}
}

@Override
public void keyReleased(KeyEvent e) {
    if(State == STATE.GAME){
switch (e.getKeyCode()) {

        case KeyEvent.VK_DOWN:
            currentSprite = character;
            player.setDucked(false);
            break;

        case KeyEvent.VK_LEFT:
            player.stopLeft();
            break;

        case KeyEvent.VK_RIGHT:
            player.stopRight();
            break;

        case KeyEvent.VK_SPACE:
            break;

        }
    }else if(State == STATE.MENU){}
}

@Override
public void keyTyped(KeyEvent e) {
}

 public static Background getBg1() {
        return bg1;
    }

    public static Background getBg2() {
        return bg2;
    }
    
    public static Image getImageRed()
    {
        return character1;
    }
    
    public static Image getImageBlue()
    {
        return character2;
    }
}