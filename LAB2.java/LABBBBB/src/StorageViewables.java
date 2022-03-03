import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StorageViewables {

    private static int availableViewables = 3;
    private static int maxCapacity = 10;


    public static List<ViewableVehicles> viewables = new ArrayList<>();

    public static void initViewables(){
        viewables.add(FactoryViewable.createViewableSaab95());
        viewables.add(FactoryViewable.createViewableVolvo240());
        viewables.add(FactoryViewable.createViewableScania());
    }

    public static void addViewableSaab95(){
        if (!isStorageFull()) {
            ViewableVehicles newSaab95 = FactoryViewable.createViewableSaab95();
            viewables.add(newSaab95);
        }
    }

    public static void addViewableVolvo240() {
        if (!isStorageFull()) {
            ViewableVehicles newVolvo240 = FactoryViewable.createViewableVolvo240();
            viewables.add(newVolvo240);
        }
    }

    public static void addViewableScania() {
        if (!isStorageFull()) {
            ViewableVehicles newScania = FactoryViewable.createViewableScania();
            viewables.add(newScania);
        }
    }

    public static void addRandomViewable() {
        if (!isStorageFull()) {
            Random random = new Random();
            int randomInt = random.nextInt(1, availableViewables);
            switch (randomInt) {
                case 1 -> addViewableSaab95();
                case 2 -> addViewableScania();
                case 3 -> addViewableVolvo240();
            }
        }
    }

    public static void removeRandomViewable() {
        Random random = new Random();
        if (viewables.size() > 0) {
            int randomVehicle = random.nextInt(0,viewables.size());
            viewables.remove(randomVehicle);
            FactoryViewable.positionY -= 60;
        }
    }

    private static boolean isStorageFull(){
        return viewables.size() >= maxCapacity;
    }
}