package by.zapolski.model.machine;

import by.zapolski.exception.*;
import by.zapolski.model.coffee.*;

public class ExtendedCoffeeMachine extends CoffeeMachineAbstract implements ICanMakeLatte,
        ICanMakeCappuccino, ICanMakeAmericano, ICanMakeEspresso {

    int milkContainer;

    private final int COFFEE_LIMIT_GR = 300;
    private final int WATER_LIMIT_ML = 1500;
    private final int WASTE_LIMIT_GR = 300;
    private final int MILK_LIMIT_ML = 1000;


    public void fillMilkContainer(int milkMl) {
        if ((milkContainer+milkMl)>getMilkLimitMl())
            milkContainer=getMilkLimitMl();
        else     milkContainer += milkMl;
    }

    public Americano makeAmericano() throws CoffeeMachineException {
        if (waterContainer< Americano.WATER) throw new NoWaterException("NO WATER");
        if (coffeeContainer< Americano.COFFEE) throw new NoCoffeeException("NO COFFEE");
        if ((wasteContainer+ Americano.COFFEE)>WASTE_LIMIT_GR) throw new WasteOverflowException("WASTE OVERFLOW");

        coffeeContainer -= Americano.COFFEE;
        waterContainer -= Americano.WATER;

        wasteContainer += Americano.COFFEE;
        return new Americano();
    }

    public Espresso makeEspresso() throws CoffeeMachineException {
        if (waterContainer<Espresso.WATER) throw new NoWaterException("NO WATER");
        if (coffeeContainer<Espresso.COFFEE) throw new NoCoffeeException("NO COFFEE");
        if ((wasteContainer+Espresso.COFFEE)>WASTE_LIMIT_GR) throw new WasteOverflowException("WASTE OVERFLOW");

        coffeeContainer -= Espresso.COFFEE;
        waterContainer -= Espresso.WATER;

        wasteContainer += Espresso.COFFEE;
        return new Espresso();
    }

    public Cappuccino makeCappuccino(int milkMl) throws CoffeeMachineException {
        if (waterContainer< Cappuccino.WATER) throw new NoWaterException("NO WATER");
        if (coffeeContainer< Cappuccino.COFFEE) throw new NoCoffeeException("NO COFFEE");
        if (milkContainer<milkMl) throw new NoMilkException("NO MILK");

        if ((wasteContainer+ Cappuccino.COFFEE)>WASTE_LIMIT_GR) throw new WasteOverflowException("WASTE OVERFLOW");

        coffeeContainer -= Cappuccino.COFFEE;
        waterContainer -= Cappuccino.WATER;
        milkContainer -= milkMl;

        wasteContainer += Cappuccino.COFFEE;
        return new Cappuccino();
    }

    public Latte makeLate(int milkMl) throws CoffeeMachineException {
        if (waterContainer< Latte.WATER) throw new NoWaterException("NO WATER");
        if (coffeeContainer< Latte.COFFEE) throw new NoCoffeeException("NO COFFEE");
        if (milkContainer<milkMl) throw new NoMilkException("NO MILK");

        if ((wasteContainer+ Latte.COFFEE)>WASTE_LIMIT_GR) throw new WasteOverflowException("WASTE OVERFLOW");

        coffeeContainer -= Latte.COFFEE;
        waterContainer -= Latte.WATER;
        milkContainer -= milkMl;

        wasteContainer += Latte.COFFEE;
        return new Latte();
    }

    public int getCoffeeLimitGr() {
        return COFFEE_LIMIT_GR;
    }

    public int getWaterLimitMl() {
        return WATER_LIMIT_ML;
    }

    public int getWasteLimitGR() {
        return WASTE_LIMIT_GR;
    }

    public int getMilkLimitMl() {
        return MILK_LIMIT_ML;
    }
}
