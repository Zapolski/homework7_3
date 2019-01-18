package by.zapolski.model.machine;

import by.zapolski.exception.*;
import by.zapolski.model.coffee.Americano;
import by.zapolski.model.coffee.ICanMakeAmericano;
import by.zapolski.model.coffee.ICanMakeLatte;
import by.zapolski.model.coffee.Latte;

public class OfficeCoffeeMachineWithBeans extends CoffeeMachineAbstract implements ICanMakeAmericano, ICanMakeLatte{

    int milkContainer;
    int beansContainer;

    private final int COFFEE_LIMIT_GR = 300;
    private final int WATER_LIMIT_ML = 1500;
    private final int WASTE_LIMIT_GR = 300;
    private final int MILK_LIMIT_ML = 1000;
    private final int BEANS_LIMIT_GR = 1000;

    public void fillMilkContainer(int milkMl) {
        if ((milkContainer+milkMl)>getMilkLimitMl())
            milkContainer=getMilkLimitMl();
        else     milkContainer += milkMl;
    }

    public void fillBeansContainer(int beansGr) {
        if ((beansContainer+beansGr)>getBeansLimitGR())
            beansContainer=getBeansLimitGR();
        else     beansContainer += beansGr;
    }

    public Americano makeAmericano() throws CoffeeMachineException {
        if (waterContainer< Americano.WATER) throw new NoWaterException("NO WATER");

        if (coffeeContainer< Americano.COFFEE){ //если не хватает молотого кофе
            if (beansContainer<Americano.COFFEE){ //проверяем хватает ли в зернах
                throw new NoBeansCoffeeException("NO COFFEE BEANS");
            }else{ //мелим кофе если в зернах хватает
                beansContainer -= Americano.COFFEE;
                coffeeContainer +=Americano.COFFEE;
            }
        }

        if ((wasteContainer+ Americano.COFFEE)>WASTE_LIMIT_GR) throw new WasteOverflowException("WASTE OVERFLOW");

        coffeeContainer -= Americano.COFFEE;
        waterContainer -= Americano.WATER;

        wasteContainer += Americano.COFFEE;
        return new Americano();
    }

    public Latte makeLate(int milkMl) throws CoffeeMachineException {
        if (waterContainer< Latte.WATER) throw new NoWaterException("NO WATER");

        if (coffeeContainer< Latte.COFFEE){ //если не хватает молотого кофе
            if (beansContainer<Latte.COFFEE){ //проверяем хватает ли в зернах
                throw new NoBeansCoffeeException("NO COFFEE BEANS");
            }else{ //мелим кофе если в зернах хватает
                beansContainer -= Latte.COFFEE;
                coffeeContainer += Latte.COFFEE;
            }
        }

        if (milkContainer<milkMl) throw new NoMilkException("NO MILK");

        if ((wasteContainer+ Latte.COFFEE)>WASTE_LIMIT_GR) throw new WasteOverflowException("WASTE OVERFLOW");

        coffeeContainer -= Latte.COFFEE;
        waterContainer -= Latte.WATER;
        milkContainer -= milkMl;

        wasteContainer += Latte.COFFEE;
        return new Latte();
    }

    public int getCoffeeLimitGr() { return COFFEE_LIMIT_GR; }
    public int getWaterLimitMl() { return WATER_LIMIT_ML; }
    public int getWasteLimitGR() { return WASTE_LIMIT_GR; }
    public int getMilkLimitMl() {
        return MILK_LIMIT_ML;
    }
    public int getBeansLimitGR() {
        return BEANS_LIMIT_GR;
    }
}
