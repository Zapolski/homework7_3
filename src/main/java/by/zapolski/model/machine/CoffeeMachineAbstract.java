package by.zapolski.model;

public abstract class CoffeeMachineAbstract implements CoffeeMachineInterface {

    int wasteContainer;
    int waterContainer;
    int coffeeContainer;

    boolean isRunning;

    public void enable() {
        isRunning=true;
    }

    public void disable() {
        isRunning=false;
    }

    public void wasteContainerCleaning() {
        wasteContainer=0;
    }


}
