import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException {
        CarController cc = new CarController();
        Update update = new Update();
        new FactoryViewable();

        StorageViewables.initViewables();
        cc.frame = new CarView("CarSim 1.0");
        cc.inputButtons();

        update.timer.start();
    }
}