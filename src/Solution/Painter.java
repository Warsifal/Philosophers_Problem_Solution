package Solution;

import javafx.application.Application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.awt.*;


public class Painter extends Application{
    static Image imgQuit;
    static Image imgStart;
    static Image imgPause;
    static Image imgBlank;
    static Image imgEating;
    static Image imgWaiting;
    static Image imgThinking;
    static Image imgBackground ;
    static Image imgChopstick01;
    static Image imgChopstick02;
    static Image imgChopstick03;
    static Image imgChopstick04;
    static Image imgChopstick05;


    static {
        try {
            imgQuit = new Image("Solution/Image/quit.png");
            imgPause = new Image("Solution/Image/pause.png");
            imgStart = new Image("Solution/Image/start.png");
            imgBlank = new Image("Solution/Image/blank.png");
            imgEating = new Image("Solution/Image/eating.png");
            imgWaiting = new Image("Solution/Image/waiting.png");
            imgThinking = new Image("Solution/Image/thinking.png");
            imgBackground = new Image("Solution/Image/background.png");
            imgChopstick01 = new Image("Solution/Image/c1.png");
            imgChopstick02 = new Image("Solution/Image/c2.png");
            imgChopstick03 = new Image("Solution/Image/c3.png");
            imgChopstick04 = new Image("Solution/Image/c4.png");
            imgChopstick05 = new Image("Solution/Image/c5.png");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    static ImageView imvQuit = new ImageView(imgQuit);
    static ImageView imvStart = new ImageView(imgStart);
    static ImageView imvPause = new ImageView(imgPause);

    static ImageView imvBackground = new ImageView(imgBackground);

    static ImageView Tip01 = new ImageView(imgBlank);
    static ImageView Tip02 = new ImageView(imgBlank);
    static ImageView Tip03 = new ImageView(imgBlank);
    static ImageView Tip04 = new ImageView(imgBlank);
    static ImageView Tip05 = new ImageView(imgBlank);

    static ImageView Chop01 = new ImageView(imgChopstick01);
    static ImageView Chop02 = new ImageView(imgChopstick02);
    static ImageView Chop03 = new ImageView(imgChopstick03);
    static ImageView Chop04 = new ImageView(imgChopstick04);
    static ImageView Chop05 = new ImageView(imgChopstick05);

    static Text Text01 = new Text(100,780,"P1 is doing Nothing!");
    static Text Text02 = new Text(100,820,"P2 is doing Nothing!");
    static Text Text03 = new Text(100,860,"P3 is doing Nothing!");
    static Text Text04 = new Text(100,900,"P4 is doing Nothing!");
    static Text Text05 = new Text(100,940,"P5 is doing Nothing!");

    final int WIDTH = 1000;
    final int HEIGHT = 1045;

    public boolean isStart = false;

    public void start(Stage primaryStage){

        primaryStage = new Stage();
        primaryStage.setTitle("Philosopher Problem Solution");
        primaryStage.setHeight(HEIGHT);
        primaryStage.setWidth(WIDTH);

        Pane pane = new Pane();

        imvBackground.setX(0);
        imvBackground.setY(0);

        Chop01.setX(0);
        Chop01.setY(0);

        Chop02.setX(0);
        Chop02.setY(0);

        Chop03.setX(0);
        Chop03.setY(0);

        Chop04.setX(0);
        Chop04.setY(0);

        Chop05.setX(0);
        Chop05.setY(0);

        Tip01.setX(460);
        Tip01.setY(40);

        Tip02.setX(650);
        Tip02.setY(90);

        Tip03.setX(610);
        Tip03.setY(210);

        Tip04.setX(360);
        Tip04.setY(220);

        Tip05.setX(290);
        Tip05.setY(110);

        Text01.setFont(Font.font("monospaced", FontWeight.BOLD,32));
        Text02.setFont(Font.font("monospaced", FontWeight.BOLD,32));
        Text03.setFont(Font.font("monospaced", FontWeight.BOLD,32));
        Text04.setFont(Font.font("monospaced", FontWeight.BOLD,32));
        Text05.setFont(Font.font("monospaced", FontWeight.BOLD,32));

        Text01.setFill(Color.rgb(89,73,65));
        Text02.setFill(Color.rgb(89,73,65));
        Text03.setFill(Color.rgb(89,73,65));
        Text04.setFill(Color.rgb(89,73,65));
        Text05.setFill(Color.rgb(89,73,65));

        Button button = new Button("", imvStart);
        button.setLayoutX(750);
        button.setLayoutY(30);
        button.setStyle("-fx-base: #594941;");
        button.setOnAction((ActionEvent e) -> {
            isStart = !isStart;
            if(isStart){
                button.setGraphic(imvQuit);
                Chopstick chopstick = new Chopstick();
                new Philosopher("P1", chopstick).start();
                new Philosopher("P2", chopstick).start();
                new Philosopher("P3", chopstick).start();
                new Philosopher("P4", chopstick).start();
                new Philosopher("P5", chopstick).start();
            }
            else {
                System.exit(0);
            }
        });

        pane.getChildren().addAll(imvBackground, button);
        pane.getChildren().addAll(Tip01, Tip02, Tip03, Tip04, Tip05);
        pane.getChildren().addAll(Chop01, Chop02, Chop03, Chop04, Chop05);
        pane.getChildren().addAll(Text01, Text02, Text03, Text04, Text05);

        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                System.exit(0);
            }
        });

        Scene scene= new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();



    }

    public static void main(String[] args){
        launch(args);
    }

}
