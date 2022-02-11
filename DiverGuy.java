import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class DiverGuy {
    private int posX ,posY, countOfGold;
    private boolean lifeStatus = true;
    private ImageView runningGuy;

    public DiverGuy(int posX,int posY) throws FileNotFoundException {
        this.posX = posX;
        this.posY = posY;
        setCountOfGold(0);
        runningGuy = new ImageView(new Image(new FileInputStream("UrPath\Images\\GuyOnBoard.png")));
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public void setCountOfGold(int newGoldValue) {
        this.countOfGold = newGoldValue;
    }

    public ImageView getGuyImage() {
        return runningGuy;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public void it(){
        setCountOfGold(getCountOfGold() + 1);
    }

    public void toEmpty(){
        setCountOfGold(0);
    }

    public void kill(){
        lifeStatus = false;
    }

    public boolean isAlive(){
        return lifeStatus;
    }

    public int getCountOfGold() {
        return countOfGold;
    }
}

