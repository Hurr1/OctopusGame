import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.input.KeyEvent;
import javafx.scene.control.Label;
import java.io.*;


public class Main extends Application
{

    DiverGuy diverGuy;
    Storage storage;

    @Override
    public void start(Stage stage) throws Exception
    {

        this.diverGuy = null;
        this.storage = new Storage();

        Label nickLabel = new Label("Enter your name:");
        nickLabel.setFont(new Font(30));
        nickLabel.setTranslateX(115);

        TextField nickField = new TextField("Player");

        Pane root = new VBox();
        root.getChildren().add(nickLabel);
        root.getChildren().add(nickField);

        ObservableList<String> obsListForResults = FXCollections.observableArrayList();
        ListView<String> listOfResults = new ListView<>(obsListForResults);
        listOfResults.setLayoutX(370);
        listOfResults.setLayoutY(150);

        try {
            File file = new File("urPath/Results.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                obsListForResults.add(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.getMessage();
        }
        root.getChildren().add(listOfResults);
        
        Scene scene = new Scene(root, 450, 250);

        stage.setTitle("MainMenu");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

        scene.addEventFilter(KeyEvent.KEY_PRESSED,
                new EventHandler<>() {
                    final Image gameScreen = new Image(new FileInputStream("urPath/GameScreen.png"));

                    public void handle(KeyEvent ke) {
                        if (ke.getCode() == KeyCode.SPACE) {

                            ImageView imageView = new ImageView();
                            imageView.setImage(gameScreen);

                            try (FileWriter writer = new FileWriter("urPath/Results.txt", true)) {
                                BufferedWriter bufferedWriter = new BufferedWriter(writer);
                                bufferedWriter.write(" " + nickField.getText() + "    ");
                                bufferedWriter.close();
                            } catch (IOException e) {
                                e.getMessage();
                            }


                            Group root = new Group(imageView);
                            Label score = new Label();
                            score.setLayoutX(380);
                            score.setLayoutY(85);
                            score.setText("0");
                            score.setFont(new Font(25));

                            Scene scene = new Scene(root, 630, 345);

                            stage.setScene(scene);
                            stage.setTitle("GamePanel");
                            stage.show();

                            try {
                                diverGuy = new DiverGuy(195, 85);
                                diverGuy.getGuyImage().setX(diverGuy.getPosX());
                                diverGuy.getGuyImage().setY(diverGuy.getPosY());
                                root.getChildren().add(diverGuy.getGuyImage());
                                root.getChildren().add(score);
                                GameController game = new GameController(scene, root, score, diverGuy, storage);
                                Octopus octopus = new Octopus(root, storage, diverGuy, System.currentTimeMillis());
                                octopus.Attack((int) (Math.random() * 3) + 1);
                                octopus.checkGameStatus();
                                octopus.checkDiverStatus();
                            } catch (FileNotFoundException | InterruptedException e) {
                                e.getMessage();
                            }
                        }
                    }
                }
        );

    }

    public static void main(String[] args)
    {
        launch(args);
    }

}
