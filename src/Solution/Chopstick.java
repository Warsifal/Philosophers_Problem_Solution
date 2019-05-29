package Solution;

import javafx.application.Platform;
import javafx.scene.image.Image;

public class Chopstick {

    private boolean[] chopsticks = {true, true, true, true, true};

    public void Wait(){
        String name = Thread.currentThread().getName();
        int k = index(name);
        if(k%2==1){
            waitforLeft();
            waitforRight();
        }
        else{
            waitforRight();
            waitforLeft();
      }
    }

    public synchronized void waitforRight(){
        String name = Thread.currentThread().getName();
        int i = index(name);
        while(!chopsticks[i]){
            try {
                wait();
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        if(name.equals("P1")){
                            Painter.Tip01.setImage(Painter.imgWaiting);
                            Painter.Text01.setText("P1 is Waiting for right chopstick!");
                        }
                        if(name.equals("P2")){
                            Painter.Tip02.setImage(Painter.imgWaiting);
                            Painter.Text02.setText("P2 is Waiting for right chopstick!");
                        }
                        if(name.equals("P3")){
                            Painter.Tip03.setImage(Painter.imgWaiting);
                            Painter.Text03.setText("P3 is Waiting for right chopstick!");
                        }
                        if(name.equals("P4")){
                            Painter.Tip04.setImage(Painter.imgWaiting);
                            Painter.Text04.setText("P4 is Waiting for right chopstick!");
                        }
                        if(name.equals("P5")){
                            Painter.Tip05.setImage(Painter.imgWaiting);
                            Painter.Text05.setText("P5 is Waiting for right chopstick!");
                        }
                    }
                });

            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        chopsticks[i] = false;

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                switch (i){
                    case 0:
                        Painter.Chop01.setImage(Painter.imgBlank);
                        break;
                    case 1:
                        Painter.Chop02.setImage(Painter.imgBlank);
                        break;
                    case 2:
                        Painter.Chop03.setImage(Painter.imgBlank);
                        break;
                    case 3:
                        Painter.Chop04.setImage(Painter.imgBlank);
                        break;
                    case 4:
                        Painter.Chop05.setImage(Painter.imgBlank);
                        break;
                }
            }
        });
    }

    public synchronized void waitforLeft(){
        String name = Thread.currentThread().getName();
        int i = index(name);
        while(!chopsticks[(i+1)%5]){
            try {
                wait();
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        if(name.equals("P1")){
                            Painter.Tip01.setImage(Painter.imgWaiting);
                            Painter.Text01.setText("P1 is Waiting for left chopstick!");
                        }
                        if(name.equals("P2")){
                            Painter.Tip02.setImage(Painter.imgWaiting);
                            Painter.Text02.setText("P2 is Waiting for left chopstick!");
                        }
                        if(name.equals("P3")){
                            Painter.Tip03.setImage(Painter.imgWaiting);
                            Painter.Text03.setText("P3 is Waiting for left chopstick!");
                        }
                        if(name.equals("P4")){
                            Painter.Tip04.setImage(Painter.imgWaiting);
                            Painter.Text04.setText("P4 is Waiting for left chopstick!");
                        }
                        if(name.equals("P5")){
                            Painter.Tip05.setImage(Painter.imgWaiting);
                            Painter.Text05.setText("P5 is Waiting for left chopstick!");
                        }
                    }
                });

            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        chopsticks[(i+1)%5]=true;
    }


    public synchronized void signal(){
        String name = Thread.currentThread().getName();
        int i = index(name);
        int j = (i+1)%5;
        chopsticks[i] = true;
        chopsticks[(i+1)%5] = true;
        notifyAll();

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                PutbackChop(i);
                PutbackChop(j);
            }
        });
    }

    private void PutbackChop(int j) {
        switch (j){
            case 0:
                Painter.Chop01.setImage(Painter.imgChopstick01);
                break;
            case 1:
                Painter.Chop02.setImage(Painter.imgChopstick02);
                break;
            case 2:
                Painter.Chop03.setImage(Painter.imgChopstick03);
                break;
            case 3:
                Painter.Chop04.setImage(Painter.imgChopstick04);
                break;
            case 4:
                Painter.Chop05.setImage(Painter.imgChopstick05);
                break;
        }
    }

    public int index(String name){
        int i=0;
        if(name=="P1")   i = 0;
        else if(name=="P2")   i = 1;
        else if(name=="P3")   i = 2;
        else if(name=="P4")   i = 3;
        else if(name=="P5")   i = 4;
        return i;
    }


}
