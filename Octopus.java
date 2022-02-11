import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.concurrent.Task;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import java.io.*;
import static java.lang.Thread.sleep;


public class Octopus
{

    private final ImageView [][] OCTOPUS_ARMS;
    private final Storage STORAGE;
    private final DiverGuy DIVER;
    private final long TIME;

    public Octopus(Group root,Storage storage,DiverGuy diverGuy, long time) throws FileNotFoundException
    {

        this.STORAGE = storage;
        this.DIVER = diverGuy;
        this.TIME = time;

        ImageView tentacle_01 = new ImageView(
            new Image(new FileInputStream("urPath/tentacles1.png"))
        );
        ImageView tentacle_02 = new ImageView(
            new Image(new FileInputStream("urPath/tentacles2.png"))
        );
        ImageView tentacle_03 = new ImageView(
            new Image(new FileInputStream("urPath/tentacles3.png"))
        );
        ImageView[] firstArm = new ImageView[]{tentacle_01, tentacle_02, tentacle_03};
        ImageView tentacle_11 = new ImageView(
            new Image(new FileInputStream("urPath/tentacles1.png"))
                                             );
        ImageView tentacle_12 = new ImageView
            (new Image(new FileInputStream("urPath/tentacles2.png"))
            );
        ImageView tentacle_13 = new ImageView(
            new Image(new FileInputStream("urPath/tentacles3.png"))
        );
        ImageView[] secondArm = new ImageView[]{tentacle_11, tentacle_12, tentacle_13};
        ImageView tentacle_21 = new ImageView(
            new Image(new FileInputStream("urPath/tentacles1.png"))
        );
        ImageView tentacle_22 = new ImageView(
            new Image(new FileInputStream("urPath/tentacles2.png"))
        );
        ImageView tentacle_23 = new ImageView(
            new Image(new FileInputStream("urPath/tentacles3.png"))
        );
        ImageView[] thirdArm = new ImageView[]{tentacle_21, tentacle_22, tentacle_23};
        ImageView tentacle_31 = new ImageView(
            new Image(new FileInputStream("urPath/tentacles2.png"))
        );
        ImageView tentacle_32 = new ImageView(
            new Image(new FileInputStream("urPath/tentacles2.png"))
        );
        ImageView tentacle_33 = new ImageView(
            new Image(new FileInputStream("urPath/tentacles2.png"))
        );
        ImageView[] fourthArm = new ImageView[]{tentacle_31, tentacle_32, tentacle_33};
        OCTOPUS_ARMS = new ImageView[][]{firstArm, secondArm, thirdArm, fourthArm};

        for (ImageView[] octopusArm : OCTOPUS_ARMS) {
            for (int g = 0; g < OCTOPUS_ARMS[1].length; g++) {
                octopusArm[g].setVisible(false);
                root.getChildren().add(octopusArm[g]);
            }
        }

        tentacle_01.setX(260);
        tentacle_01.setY(145);

        tentacle_02.setX(235);
        tentacle_02.setY(150);

        tentacle_03.setX(210);
        tentacle_03.setY(140);
        tentacle_03.setRotate(tentacle_03.getRotate());

        tentacle_11.setX(290);
        tentacle_11.setY(160);
        tentacle_11.setRotate(tentacle_11.getRotate() - 20);

        tentacle_12.setX(265);
        tentacle_12.setY(180);
        tentacle_12.setRotate(tentacle_12.getRotate() - 20);

        tentacle_13.setX(245);
        tentacle_13.setY(200);
        tentacle_13.setRotate(tentacle_13.getRotate() + 90);

        tentacle_21.setX(310);
        tentacle_21.setY(180);
        tentacle_21.setRotate(tentacle_21.getRotate() - 25);

        tentacle_22.setX(300);
        tentacle_22.setY(200);
        tentacle_22.setRotate(tentacle_22.getRotate() - 20);

        tentacle_23.setX(290);
        tentacle_23.setY(220);
        tentacle_23.setRotate(tentacle_23.getRotate() - 270);

        tentacle_31.setX(380);
        tentacle_31.setY(200);
        tentacle_31.setRotate(tentacle_31.getRotate() + 45);

        tentacle_32.setX(385);
        tentacle_32.setY(215);
        tentacle_32.setRotate(tentacle_32.getRotate() + 45);

        tentacle_33.setX(390);
        tentacle_33.setY(230);
        tentacle_33.setRotate(tentacle_33.getRotate() + 45);

    }


    public void Attack(int i)
    {

        if (i == 1)
        {
            Task<Void> pattern_1 = new Task<>()
            {
                @Override
                public Void call()
                {
                    Timeline attackpattern = new Timeline(
                            new KeyFrame(Duration.seconds(1),
                                    new KeyValue(OCTOPUS_ARMS[0][0].visibleProperty(), true), new KeyValue(OCTOPUS_ARMS[2][0].visibleProperty(), true)
                            ),
                            new KeyFrame(Duration.seconds(2),
                                    new KeyValue(OCTOPUS_ARMS[0][1].visibleProperty(), true), new KeyValue(OCTOPUS_ARMS[2][1].visibleProperty(), true)
                            ),
                            new KeyFrame(Duration.seconds(3),
                                    new KeyValue(OCTOPUS_ARMS[0][2].visibleProperty(), true), new KeyValue(OCTOPUS_ARMS[2][2].visibleProperty(), true), new KeyValue(OCTOPUS_ARMS[1][0].visibleProperty(), true), new KeyValue(OCTOPUS_ARMS[3][0].visibleProperty(), true)
                            ),
                            new KeyFrame(Duration.seconds(4),
                                    new KeyValue(OCTOPUS_ARMS[1][1].visibleProperty(), true), new KeyValue(OCTOPUS_ARMS[3][1].visibleProperty(), true),
                                    new KeyValue(OCTOPUS_ARMS[0][2].visibleProperty(), false), new KeyValue(OCTOPUS_ARMS[2][2].visibleProperty(), false)
                            ),
                            new KeyFrame(Duration.seconds(5),
                                    new KeyValue(OCTOPUS_ARMS[1][2].visibleProperty(), true), new KeyValue(OCTOPUS_ARMS[3][2].visibleProperty(), true),
                                    new KeyValue(OCTOPUS_ARMS[0][1].visibleProperty(), false), new KeyValue(OCTOPUS_ARMS[2][1].visibleProperty(), false)
                            ),
                            new KeyFrame(Duration.seconds(6),
                                    new KeyValue(OCTOPUS_ARMS[0][0].visibleProperty(), false), new KeyValue(OCTOPUS_ARMS[2][0].visibleProperty(), false)

                            ),
                            new KeyFrame(Duration.seconds(7))
                    );
                    attackpattern.setAutoReverse(true);
                    attackpattern.setCycleCount(Timeline.INDEFINITE);
                    attackpattern.play();
                    return null;
                }
            };
            new Thread(pattern_1).start();
        }
        if (i == 2)
        {
            Task<Void> pattern_2 = new Task<>()
            {
                @Override
                public Void call() 
                {
                    Timeline attackpattern = new Timeline(
                            new KeyFrame(Duration.seconds(1),
                                    new KeyValue(OCTOPUS_ARMS[1][0].visibleProperty(), true), new KeyValue(OCTOPUS_ARMS[2][0].visibleProperty(), true)
                            ),
                            new KeyFrame(Duration.seconds(2),
                                    new KeyValue(OCTOPUS_ARMS[1][1].visibleProperty(), true), new KeyValue(OCTOPUS_ARMS[2][1].visibleProperty(), true)
                            ),
                            new KeyFrame(Duration.seconds(3),
                                    new KeyValue(OCTOPUS_ARMS[1][2].visibleProperty(), true), new KeyValue(OCTOPUS_ARMS[2][2].visibleProperty(), true)
                            ),
                            new KeyFrame(Duration.seconds(4),
                                    new KeyValue(OCTOPUS_ARMS[1][2].visibleProperty(), false), new KeyValue(OCTOPUS_ARMS[2][2].visibleProperty(), false),
                                    new KeyValue(OCTOPUS_ARMS[0][0].visibleProperty(), true), new KeyValue(OCTOPUS_ARMS[3][0].visibleProperty(), true)
                            ),
                            new KeyFrame(Duration.seconds(5),
                                    new KeyValue(OCTOPUS_ARMS[0][1].visibleProperty(), true), new KeyValue(OCTOPUS_ARMS[3][1].visibleProperty(), true),
                                    new KeyValue(OCTOPUS_ARMS[1][1].visibleProperty(), false), new KeyValue(OCTOPUS_ARMS[2][1].visibleProperty(), false)
                            ),
                            new KeyFrame(Duration.seconds(6),
                                    new KeyValue(OCTOPUS_ARMS[0][2].visibleProperty(), true), new KeyValue(OCTOPUS_ARMS[3][2].visibleProperty(), true),
                                    new KeyValue(OCTOPUS_ARMS[1][0].visibleProperty(), false), new KeyValue(OCTOPUS_ARMS[2][0].visibleProperty(), false)

                            ),
                            new KeyFrame(Duration.seconds(7))
                    );
                    attackpattern.setAutoReverse(true);
                    attackpattern.setCycleCount(Timeline.INDEFINITE);
                    attackpattern.play();
                    return null;
                }
            };
            new Thread(pattern_2).start();
        }
        if (i == 3)
        {
            Task<Void> pattern_3 = new Task<>() 
            {
                @Override
                public Void call()
                {
                    Timeline attackpattern = new Timeline(
                            new KeyFrame(Duration.seconds(1),
                                    new KeyValue(OCTOPUS_ARMS[1][0].visibleProperty(), true), new KeyValue(OCTOPUS_ARMS[3][0].visibleProperty(), true)
                            ),
                            new KeyFrame(Duration.seconds(2),
                                    new KeyValue(OCTOPUS_ARMS[1][1].visibleProperty(), true), new KeyValue(OCTOPUS_ARMS[3][1].visibleProperty(), true)
                            ),
                            new KeyFrame(Duration.seconds(3),
                                    new KeyValue(OCTOPUS_ARMS[1][2].visibleProperty(), true), new KeyValue(OCTOPUS_ARMS[3][2].visibleProperty(), true), new KeyValue(OCTOPUS_ARMS[1][0].visibleProperty(), true), new KeyValue(OCTOPUS_ARMS[3][0].visibleProperty(), true)
                            ),
                            new KeyFrame(Duration.seconds(4),
                                    new KeyValue(OCTOPUS_ARMS[0][0].visibleProperty(), true), new KeyValue(OCTOPUS_ARMS[2][0].visibleProperty(), true),
                                    new KeyValue(OCTOPUS_ARMS[1][2].visibleProperty(), false), new KeyValue(OCTOPUS_ARMS[3][2].visibleProperty(), false)
                            ),
                            new KeyFrame(Duration.seconds(5),
                                    new KeyValue(OCTOPUS_ARMS[0][1].visibleProperty(), true), new KeyValue(OCTOPUS_ARMS[2][1].visibleProperty(), true),
                                    new KeyValue(OCTOPUS_ARMS[1][1].visibleProperty(), false), new KeyValue(OCTOPUS_ARMS[3][1].visibleProperty(), false)
                            ),
                            new KeyFrame(Duration.seconds(6),
                                    new KeyValue(OCTOPUS_ARMS[0][2].visibleProperty(), true), new KeyValue(OCTOPUS_ARMS[2][2].visibleProperty(), true),
                                    new KeyValue(OCTOPUS_ARMS[1][0].visibleProperty(), false), new KeyValue(OCTOPUS_ARMS[3][0].visibleProperty(), false)

                            ),
                            new KeyFrame(Duration.seconds(7))
                    );
                    attackpattern.setAutoReverse(true);
                    attackpattern.setCycleCount(Timeline.INDEFINITE);
                    attackpattern.play();
                    return null;
                }
            };
            new Thread(pattern_3).start();
        }

    }

    public void checkGameStatus()
    {
        Task<Void> checkProcessStatus = new Task<>()
        {
            @Override
            public Void call() throws InterruptedException, FileNotFoundException
            {
                while (STORAGE.checkStatus()) {
                    Thread.sleep(100);
                }
                DIVER.getGuyImage().setImage(new Image(new FileInputStream("urPath/WonGuy.png")));
                DIVER.kill();

                try(FileWriter writer = new FileWriter("urPath/Results.txt", true))
                {
                    BufferedWriter bufferedWriter = new BufferedWriter(writer);
                    bufferedWriter.write("  Time: " + ((int)(System.currentTimeMillis() - TIME)/1000) +"  Score: " + STORAGE.getGold() + "\n");
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.getMessage();
                }
                sleep(1000);
                System.exit(0);

                return null;
            }
        };
        new Thread(checkProcessStatus).start();
    }

    public void checkDiverStatus()
    {
        Task<Void> checkGuyStatus = new Task<>()
        {
            @Override
            public Void call() throws InterruptedException, FileNotFoundException
            {
                boolean status = false;
                while (!status) {

                if(DIVER.getGuyImage().getX()==185 && DIVER.getGuyImage().getY()==150 && OCTOPUS_ARMS[0][2].isVisible()){
                    status = true;
                }
                if(DIVER.getGuyImage().getX()==220 && DIVER.getGuyImage().getY()==200 && OCTOPUS_ARMS[1][2].isVisible()){
                    status = true;
                }
                if(DIVER.getGuyImage().getX()==290 && DIVER.getGuyImage().getY()==225 && OCTOPUS_ARMS[2][2].isVisible()){
                    status = true;
                }
                if(DIVER.getGuyImage().getX()==370 && DIVER.getGuyImage().getY()==225 && OCTOPUS_ARMS[3][2].isVisible()){
                    status = true;
                }
                }
                DIVER.getGuyImage().setImage(new Image(new FileInputStream("urPath/CatchedGuy.png")));
                DIVER.kill();
                sleep(1000);
                try(FileWriter writer = new FileWriter("urPath/Results.txt", true))
                {
                    BufferedWriter bufferedWriter = new BufferedWriter(writer);
                    bufferedWriter.write("  Time: " + ((int)(System.currentTimeMillis() - TIME)/1000) +" Score: " + STORAGE.getGold() + "\n");
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.exit(0);


                return null;
            }
        };
        new Thread(checkGuyStatus).start();
    }
}



