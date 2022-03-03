import Model.AbstractMotorVehicle;
import java.awt.image.BufferedImage;

public class ViewableVehicles {

    private final AbstractMotorVehicle vehicle;
    private final BufferedImage vehicleImage;

    public ViewableVehicles(BufferedImage vehicleImage, AbstractMotorVehicle vehicle) {
        this.vehicle = vehicle;
        this.vehicleImage = vehicleImage;
    }

    public BufferedImage getVehicleImage() {
        return vehicleImage;
    }

    public void hitWalls() {
        if (vehicle.getX() < 0) {
            vehicle.uTurn();
        } else if (CarView.drawPanel.getWidth() - vehicleImage.getWidth() - 20 < vehicle.getX()) {
            vehicle.uTurn();
        }
    }

    public AbstractMotorVehicle getVehicle() {
        return vehicle;
    }
}