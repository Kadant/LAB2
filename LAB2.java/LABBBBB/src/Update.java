import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.util.List;

public class Update {

    private final int delay = 50;
    public Timer timer;

    public Update() throws IOException {
        timer = new Timer(delay, new TimerListener());
    }

    private static class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < StorageViewables.viewables.size(); i++) {
                ViewableVehicles current = StorageViewables.viewables.get(i);
                current.getVehicle().setX(current.getVehicle().getX());
                current.getVehicle().move();
                current.hitWalls();
            }
            ImagesObserver.update();
        }
    }
}