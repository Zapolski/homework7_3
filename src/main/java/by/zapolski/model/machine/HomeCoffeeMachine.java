package by.zapolski.model;

import by.zapolski.exception.CoffeeMachineException;
import by.zapolski.exception.NoCoffeeException;
import by.zapolski.exception.NoWaterException;
import by.zapolski.exception.WasteOverflowException;

public class HomeCoffeeMachine extends CoffeeMachineAbstract implements ICanMakeCappuccino, ICanMakeEspresso{

    private final int COFFEE_LIMIT_GR = 300;
    private final int WATER_LIMIT_ML = 1000;
    private final int WASTE_LIMIT_GR = 300;


    public int getCOFFEE_LIMIT_GR() {
        return COFFEE_LIMIT_GR;
    }

    public int getWATER_LIMIT_ML() {
        return WATER_LIMIT_ML;
    }

    public int getWASTE_LIMIT_GR() {
        return WASTE_LIMIT_GR;
    }

    public void fillWaterContainer(int waterMl) {
        if ((waterContainer+waterMl)>WATER_LIMIT_ML)
                waterContainer=WATER_LIMIT_ML;
        else     waterContainer += waterMl;
    }

    public void fillCoffeeContainer(int coffeeGr) {
        if ((coffeeContainer+coffeeGr)>COFFEE_LIMIT_GR)
                coffeeContainer=COFFEE_LIMIT_GR;
        else    coffeeContainer += coffeeGr;

    }

    public Cappuccino makeCappuccino() throws CoffeeMachineException {
        if (waterContainer<Cappuccino.WATER) throw new NoWaterException("NO WATER");
        if (coffeeContainer<Cappuccino.COFFEE) throw new NoCoffeeException("NO COFFEE");
        if ((wasteContainer+Cappuccino.COFFEE)>WASTE_LIMIT_GR) throw new WasteOverflowException("WASTE OVERFLOW");

        coffeeContainer -= Cappuccino.COFFEE;
        waterContainer += Cappuccino.WATER;
        wasteContainer += Cappuccino.COFFEE;
        return new Cappuccino();
    }

    public Espresso makeEspresso() throws CoffeeMachineException {

        if (waterContainer<Espresso.WATER) throw new NoWaterException("NO WATER");
        if (coffeeContainer<Espresso.COFFEE) throw new NoCoffeeException("NO COFFEE");
        if ((wasteContainer+Espresso.COFFEE)>WASTE_LIMIT_GR) throw new WasteOverflowException("WASTE OVERFLOW");

        coffeeContainer -= Espresso.COFFEE;
        waterContainer += Espresso.WATER;
        wasteContainer += Espresso.COFFEE;
        return new Espresso();
    }
}
