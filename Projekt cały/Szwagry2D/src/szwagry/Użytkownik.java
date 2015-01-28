package szwagry;

/**
 * Klasa ta odpowiedzialna jest za sprawdzanie możliwości ruchu postaci kierowanej przez gracza
 * @author Sulf
 */

public class Użytkownik {
    
    final int JUMPSPEED = -15;
    final int MOVESPEED = 5;
    final int GROUND = 382;
   
    private int centerX = 380;
    private int centerY = GROUND;
    private boolean jumped = false;
    private boolean movingLeft = false;
    private boolean movingRight = false;
    private boolean ducked = false;
    private boolean direction = true;

        private static Background bg1 = Ingerencja.getBg1();                
        private static Background bg2 = Ingerencja.getBg2();

    private int speedX = 0;
    private int speedY = 1;

    /**
     * Ta metoda porusza tłem/postacią, jest odpowiedzialna za sprawdzanie możliwości 
     * ruchu w prawo, lewo oraz za skakanie; 
     */
    public void update() {

        // porusza posatcią/tłem
        if (speedX < 0 && centerX >= 380) {
            centerX += speedX;
        }
        if (speedX == 0 )//|| speedX < 0) {
        {
            bg1.setSpeedX(0);
            bg2.setSpeedX(0);

        }
        if (centerX <= 380 && speedX > 0) {
            centerX += speedX;
        }
        if (speedX > 0 && centerX >= 380){
            bg1.setSpeedX(-MOVESPEED);
            bg2.setSpeedX(-MOVESPEED);
        }

        if (speedX < 0 && centerX < 380){
            bg1.setSpeedX(MOVESPEED);
            bg2.setSpeedX(MOVESPEED);
        }
        // aktualizuje y
        centerY += speedY;
        if (centerY + speedY >= GROUND) {
            centerY = GROUND;
        }

        // skakanie
        if (jumped == true) {
            speedY += 1;

            if (centerY + speedY >= GROUND) {
                centerY = GROUND;
                speedY = 0;
                jumped = false;
            }

        }

        // nie wyjdzie po za ekran
        if (centerX + speedX <= 30) {
            centerX = 31;
        }
    }

    /**
     * Metoda ta sprawdza czy postać kuca, jeżeli tak, nie jest mozliwy ruch w prawo
     */
    public void moveRight() {
        if (ducked == false) {
            speedX = MOVESPEED;
            direction = true;
        }
    }

    /**
     * Metoda ta sprawdza czy postać kuca, jeżeli tak, nie jest mozliwy ruch w lewo
     */
    public void moveLeft() {
        if (ducked == false) {
            speedX = -MOVESPEED;
            direction = false;
        }
    }

    /**
     * Metoda ta odpowiedzialna jest za zatrzymywanie ruchu postaci w momencie w którym przestalismy isc w prawo
     */
    public void stopRight() {
        setMovingRight(false);
        stop();
    }

    /**
     * Metoda ta odpowiedzialna jest za zatrzymywanie ruchu postaci w momencie w którym przestalismy isc w lewo
     */
    public void stopLeft() {
        setMovingLeft(false);
        stop();
    }

    /**
     * Metoda ta odpowiedzialna jest za sprawdzanie flag isMovingRight() oraz isMovingLeft()
     * w przypadku false obu, postac zatrzymuje się w każdym innym postać porusza się w kierunku
     * pożądanym przez gracza
     */
    private void stop() {
        if (isMovingRight() == false && isMovingLeft() == false) {
            speedX = 0;
        }

        if (isMovingRight() == false && isMovingLeft() == true) {
            moveLeft();
        }

        if (isMovingRight() == true && isMovingLeft() == false) {
            moveRight();
        }

    }

    /**
     * Metoda ta odpowiada za sprawdzanie mozliwosci skoku
     */
    public void jump() {
        if (jumped == false) {
            speedY = JUMPSPEED;
            jumped = true;
        }
    }
    /**
     * Metoda ta odpowiedzialna jest za wpisanie nicku postaci
     * (W trakcie przygotowania)
     */
    public void wpiszNick(){}
    /**
     * Metoda ta odpowiedzialna jest za zakonczenie rozgrywki
     * (W trakcie przygotowania)
     */
    public void wyjscie(){}

    /**
     * Zwraca wartosc zmiennej centerX
     * @return centerX
     */
    public int getCenterX() {
        return centerX;
    }
    /**
     * Zwraca wartosc zmiennej centerY
     * @return centerY
     */
    public int getCenterY() {
        return centerY;
    }

    /**
     * Zwraca wartosc zmiennej jumped
     * @return jumped
     */
    public boolean isJumped() {
        return jumped;
    }

    /**
     * Zwraca wartosc zmiennej speedX
     * @return speedX
     */
    public int getSpeedX() {
        return speedX;
    }

    /**
     * Zwraca wartosc zmiennej speedY
     * @return speedY
     */
    public int getSpeedY() {
        return speedY;
    }

    /**
     * Zwraca wartosc zmiennej direction
     * @return direction
     */
    public boolean getDirection() {
        return direction;
    }
    
    /**
     * Ustawia wartosc zmiennej centerX
     * @param centerX zmienna przechowuje centralne położenie postaci po x
     */
    public void setCenterX(int centerX) {
        this.centerX = centerX;
    }

    /**
     * Ustawia wartosc zmiennej centerY
     * @param centerY zmienna przechowuje centralne położenie postaci po y
     */
    public void setCenterY(int centerY) {
        this.centerY = centerY;
    }

    /**
     * Ustawia wartosc zmiennej jumped
     * @param jumped zmienna binarna; gdy prawda, postac znajdue się w powietrzu/skacze
     */
    public void setJumped(boolean jumped) {
        this.jumped = jumped;
    }

    /**
     * Ustawia wartosc zmiennej speedX
     * @param speedX zmienna przechowuje szybkość postaci w poziomie
     */
    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }

    /**
     * Ustawia wartosc zmiennej speedY
     * @param speedY zmienna przechowuje szybkość postaci w pionie
     */
    public void setSpeedY(int speedY) {
        this.speedY = speedY;
    }

    /**
     * Zwraca wartosc zmiennej ducked
     * @return ducked
     */
    public boolean isDucked() {
        return ducked;
    }

    /**
     * Ustawia wartosc zmiennej ducked
     * @param ducked zmienna binarna; gdy prawda, postac kuca, nie ma mozliwosci ruchu ani skoku
     */
    public void setDucked(boolean ducked) {
        this.ducked = ducked;
    }

    /**
     * Zwraca wartosc zmiennej movingRight
     * @return movingRight
     */
    public boolean isMovingRight() {
        return movingRight;
    }

    /**
     * Ustawia wartosc zmiennej movingRight
     * @param movingRight zmienna binarna; gdy prawda, porusza się w prawo
     */
    public void setMovingRight(boolean movingRight) {
        this.movingRight = movingRight;
    }

    /**
     * Zwraca wartosc zmiennej movingLeft
     * @return movingLeft
     */
    public boolean isMovingLeft() {
        return movingLeft;
    }

    /**
     * Ustawia wartosc zmiennej movingLeft
     * @param movingLeft zmienna binarna; gdy prawda, porusza się w lewo
     */
    public void setMovingLeft(boolean movingLeft) {
        this.movingLeft = movingLeft;
    }
}
