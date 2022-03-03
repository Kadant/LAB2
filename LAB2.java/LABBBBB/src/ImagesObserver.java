import Interfaces.Observer;

public class ImagesObserver implements Observer {

    public static void update() {
        CarView.drawPanel.repaint();
    }
}