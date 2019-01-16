package by.zapolski.model;

public interface CoffeeMachineInterface {
    void enable();
    void disable();
    void wasteContainerCleaning();

    void fillWaterContainer(int waterMl);
    void fillCoffeeContainer(int coffeeGr);
}
