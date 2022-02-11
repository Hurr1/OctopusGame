import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.event.EventHandler;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class GameController
{

    private final Map<Integer, int[]> POSITIONS;

    public GameController(Scene scene, Group root, Label textLabel,DiverGuy diverGuy, Storage storage) throws FileNotFoundException, InterruptedException {

        POSITIONS = new HashMap<>();
        POSITIONS.put(0, new int[]{195, 85});
        POSITIONS.put(1, new int[]{185, 150});
        POSITIONS.put(2, new int[]{220, 200});
        POSITIONS.put(3, new int[]{290, 225});
        POSITIONS.put(4, new int[]{370, 225});

        scene.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<>() {
            int positionIndex = 0;


            public void handle(KeyEvent ke) {

                if (diverGuy.isAlive()) {
                    if (ke.getCode() == KeyCode.LEFT) {
                        if (positionIndex >= 0) {
                            if (positionIndex > 0) {
                                positionIndex--;
                                diverGuy.getGuyImage().setX(POSITIONS.get(positionIndex)[0]);
                                diverGuy.getGuyImage().setY(POSITIONS.get(positionIndex)[1]);
                            } else {
                                storage.refill(diverGuy.getCountOfGold());
                                textLabel.setText(storage.getGold() + "");
                                diverGuy.setCountOfGold(0);
                                positionIndex++;
                                diverGuy.getGuyImage().setX(POSITIONS.get(positionIndex)[0]);
                                diverGuy.getGuyImage().setY(POSITIONS.get(positionIndex)[1]);
                            }
                        }

                    }
                    if (ke.getCode() == KeyCode.RIGHT) {
                        if (positionIndex < 5) {
                            positionIndex++;
                            if (positionIndex == 5) {
                                if (diverGuy.getCountOfGold() == 0) {
                                    diverGuy.setCountOfGold(2);
                                }
                                diverGuy.it();
                                positionIndex--;
                            }
                            diverGuy.getGuyImage().setX(POSITIONS.get(positionIndex)[0]);
                            diverGuy.getGuyImage().setY(POSITIONS.get(positionIndex)[1]);
                        }
                    }
                    if (positionIndex == 0) {
                        try {
                            diverGuy.getGuyImage().setImage(new Image(new FileInputStream("urPath/GuyOnBoard.png")));
                        } catch (FileNotFoundException e) {
                            e.getMessage();
                        }
                    } else
                        try {
                            diverGuy.getGuyImage().setImage(new Image(new FileInputStream("urPath/RunningGuy.png")));
                        } catch (FileNotFoundException e) {
                            e.getMessage();
                        }
                }
            }
        });
    }
}

