import javax.imageio.ImageIO;
import javax.swing.text.View;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

public class FactoryViewable extends FactoryVehicle {

    public static int positionY = 0;
    private static BufferedImage saab95Image;
    private static BufferedImage volvo240Image;
    private static BufferedImage scaniaImage;

    FactoryViewable() throws IOException {
        saab95Image = ImageIO.read(Objects.requireNonNull(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg")));
        volvo240Image = ImageIO.read(Objects.requireNonNull(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg")));
        scaniaImage = ImageIO.read(Objects.requireNonNull(DrawPanel.class.getResourceAsStream("pics/Scania.jpg")));
    }

    public static ViewableVehicles createViewableSaab95(){
        ViewableVehicles newSaab = new ViewableVehicles(saab95Image, createSaab95());
        newSaab.getVehicle().setY(positionY);
        positionY += 60;
        return newSaab;
    }

    public static ViewableVehicles createViewableVolvo240(){
        ViewableVehicles newVolvo = new ViewableVehicles(volvo240Image, createVolvo240());
        newVolvo.getVehicle().setY(positionY);
        positionY += 60;
        return newVolvo;
    }

    public static ViewableVehicles createViewableScania(){
        ViewableVehicles newScania = new ViewableVehicles(scaniaImage, createScania());
        newScania.getVehicle().setY(positionY);
        positionY += 60;
        return newScania;
    }
}
