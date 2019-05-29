package Solution;

import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Philosopher extends Thread{
    private String name;
    private Chopstick chopstick;
    public Philosopher(String name,Chopstick chopstick){
        super(name);
        this.name = name;
        this.chopstick = chopstick;
    }

    public void run(){
        while(true){
            thinking();
            chopstick.Wait();

            eating();
            chopstick.signal();
        }
    }

    public void eating(){
        System.out.println("I am Eating:" + name);

        Platform.runLater(new Runnable() {
            @Override public void run() {
                if(name.equals("P1")){
                    Painter.Tip01.setImage(Painter.imgEating);
                    Painter.Text01.setText("P1 is Eating!");
                }
                if(name.equals("P2")){
                    Painter.Tip02.setImage(Painter.imgEating);
                    Painter.Text02.setText("P2 is Eating!");
                }
                if(name.equals("P3")){
                    Painter.Tip03.setImage(Painter.imgEating);
                    Painter.Text03.setText("P3 is Eating!");
                }
                if(name.equals("P4")){
                    Painter.Tip04.setImage(Painter.imgEating);
                    Painter.Text04.setText("P4 is Eating!");
                }
                if(name.equals("P5")){
                    Painter.Tip05.setImage(Painter.imgEating);
                    Painter.Text05.setText("P5 is Eating!");
                }
            }
        });
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void thinking(){
        System.out.println("I am Thinking:" + name);

        Platform.runLater(new Runnable() {
            @Override public void run() {
                if(name.equals("P1")){
                    Painter.Tip01.setImage(Painter.imgThinking);
                    Painter.Text01.setText("P1 is Thinking!");
                }
                if(name.equals("P2")){
                    Painter.Tip02.setImage(Painter.imgThinking);
                    Painter.Text02.setText("P2 is Thinking!");
                }
                if(name.equals("P3")){
                    Painter.Tip03.setImage(Painter.imgThinking);
                    Painter.Text03.setText("P3 is Thinking!");
                }
                if(name.equals("P4")){
                    Painter.Tip04.setImage(Painter.imgThinking);
                    Painter.Text04.setText("P4 is Thinking!");
                }
                if(name.equals("P5")){
                    Painter.Tip05.setImage(Painter.imgThinking);
                    Painter.Text05.setText("P5 is Thinking!");
                }
            }
        });

        try {
            sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
