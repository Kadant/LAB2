import java.awt.*;
import javax.swing.*;
import javax.swing.text.View;

public class DrawPanel extends JPanel{

    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.pink);
    }

    @Override
    protected void paintComponent (Graphics g){
        super.paintComponent(g);
        for (int i = 0; i < StorageViewables.viewables.size(); i++) {
            ViewableVehicles current = StorageViewables.viewables.get(i);
            g.drawImage(current.getVehicleImage(), current.getVehicle().getX(), current.getVehicle().getY(), null);
        }
    }
}
