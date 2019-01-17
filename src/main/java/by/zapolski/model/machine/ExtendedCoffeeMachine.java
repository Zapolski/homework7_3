package by.zapolski.model.machine;

import by.zapolski.exception.*;
import by.zapolski.model.coffee.*;

public class ExtendedCoffeeMachine extends CoffeeMachineAbstract implements ICanMakeLate,
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

    public Cuppuccino makeCappuccino(int milkMl) throws CoffeeMachineException {
        if (waterContainer<Cuppuccino.WATER) throw new NoWaterException("NO WATER");
        if (coffeeContainer<Cuppuccino.COFFEE) throw new NoCoffeeException("NO COFFEE");
        if (milkContainer<milkMl) throw new NoMilkException("NO MILK");

        if ((wasteContainer+Cuppuccino.COFFEE)>WASTE_LIMIT_GR) throw new WasteOverflowException("WASTE OVERFLOW");

        coffeeContainer -= Cuppuccino.COFFEE;
        waterContainer -= Cuppuccino.WATER;
        milkContainer -= milkMl;

        wasteContainer += Cuppuccino.COFFEE;
        return new Cuppuccino();
    }

    public Late makeLate(int milkMl) throws CoffeeMachineException {
        if (waterContainer<Late.WATER) throw new NoWaterException("NO WATER");
        if (coffeeContainer<Late.COFFEE) throw new NoCoffeeException("NO COFFEE");
        if (milkContainer<milkMl) throw new NoMilkException("NO MILK");

        if ((wasteContainer+Late.COFFEE)>WASTE_LIMIT_GR) throw new WasteOverflowException("WASTE OVERFLOW");

        coffeeContainer -= Late.COFFEE;
        waterContainer -= Late.WATER;
        milkContainer -= milkMl;

        wasteContainer += Late.COFFEE;
        return new Late();
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
