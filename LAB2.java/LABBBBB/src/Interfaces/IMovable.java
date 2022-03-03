package Interfaces;

/**
 * Contains methods that must be implemented in cars
 */
public interface IMovable {

    /**
     * Moving the car based on currentSpeed
     */
    void move();

    /**
     * Turning the car 90 degrees to the left
     */
    void turnLeft();

    /**
     * Turning the car 90 degrees to the right
     */
    void turnRight();
}