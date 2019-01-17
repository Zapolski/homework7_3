package by.zapolski.model.machine;

import by.zapolski.exception.CoffeeMachineException;
import by.zapolski.exception.NoCoffeeException;
import by.zapolski.exception.NoWaterException;
import by.zapolski.exception.WasteOverflowException;
import by.zapolski.model.coffee.ICanMakeAmericano;
import by.zapolski.model.coffee.ICanMakeEspresso;
import by.zapolski.model.coffee.Americano;
import by.zapolski.model.coffee.Espresso;

public class HomeCoffeeMachine extends CoffeeMachineAbstract implements ICanMakeAmericano, ICanMakeEspresso {

    private final int COFFEE_LIMIT_GR = 300;
    private final int WATER_LIMIT_ML = 1500;
    private final int WASTE_LIMIT_GR = 300;


    public int getCoffeeLimitGr() {
        return COFFEE_LIMIT_GR;
    }
    public int getWaterLimitMl() {
        return WATER_LIMIT_ML;
    }
    public int getWasteLimitGR() {
        return WASTE_LIMIT_GR;
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
}
