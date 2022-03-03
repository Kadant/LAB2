import Model.*;

public abstract class FactoryVehicle {
    
    public static AbstractMotorVehicle createVolvo240() {
        return new Volvo240();
    }

    public static AbstractMotorVehicle createSaab95() {
        return new Saab95();
    }

    public static AbstractMotorVehicle createScania() {
        return new Scania();
    }
}
