package com.example.demo2;
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

public class GameController {

    HashMap<Integer, int[]> pos;
    Scene scene;
    Group root;
    Storage storage;
    DiverGuy diverGuy;
    public GameController(Scene scene, Group root, Label textLabel,DiverGuy diverGuy, Storage storage) throws FileNotFoundException, InterruptedException {


        pos = new HashMap<>();
        pos.put(0, new int[]{195, 85});
        pos.put(1, new int[]{185, 150});
        pos.put(2, new int[]{220, 200});
        pos.put(3, new int[]{290, 225});
        pos.put(4, new int[]{370, 225});

        this.scene = scene;
        this.root = root;
        this.storage = storage;
        this.diverGuy = diverGuy;




        scene.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<>() {
            int positionIndex = 0;


            public void handle(KeyEvent ke) {

                if (diverGuy.isAlive()) {
                    if (ke.getCode() == KeyCode.LEFT) {
                        if (positionIndex >= 0) {
                            if (positionIndex > 0) {
                                positionIndex--;
                                diverGuy.getGuyImage().setX(pos.get(positionIndex)[0]);
                                diverGuy.getGuyImage().setY(pos.get(positionIndex)[1]);
                            } else {
                                storage.refill(diverGuy.getCountOfGold());
                                textLabel.setText(storage.getGold() + "");
                                diverGuy.setCountOfGold(0);
                                positionIndex++;
                                diverGuy.getGuyImage().setX(pos.get(positionIndex)[0]);
                                diverGuy.getGuyImage().setY(pos.get(positionIndex)[1]);
                            }
                        }

                    }
                    if (ke.getCode() == KeyCode.RIGHT) {
                        if (positionIndex < 5) {
                            positionIndex++;
                            if (positionIndex == 5) {
                                if (diverGuy.countOfGold == 0) {
                                    diverGuy.setCountOfGold(2);
                                }
                                diverGuy.it();
                                positionIndex--;
                            }
                            diverGuy.getGuyImage().setX(pos.get(positionIndex)[0]);
                            diverGuy.getGuyImage().setY(pos.get(positionIndex)[1]);
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

