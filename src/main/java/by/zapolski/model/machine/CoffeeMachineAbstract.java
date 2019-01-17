package by.zapolski.model.machine;


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

    public abstract int getCoffeeLimitGr();

    public abstract int getWaterLimitMl();

    public abstract int getWasteLimitGR();

    public void fillWaterContainer(int waterMl) {
        if ((waterContainer+waterMl)>getWaterLimitMl())
            waterContainer=getWaterLimitMl();
        else     waterContainer += waterMl;
    }

    public void fillCoffeeContainer(int coffeeGr) {
        if ((coffeeContainer+coffeeGr)>getCoffeeLimitGr())
            coffeeContainer=getCoffeeLimitGr();
        else    coffeeContainer += coffeeGr;

    }



}
