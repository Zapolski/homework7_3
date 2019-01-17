package HomeMachineTests;

import by.zapolski.exception.CoffeeMachineException;
import by.zapolski.exception.NoCoffeeException;
import by.zapolski.exception.NoWaterException;
import by.zapolski.exception.WasteOverflowException;
import by.zapolski.model.coffee.Espresso;
import org.junit.Assert;
import org.junit.Test;

public class HomeMachineEspressoTests extends HomeMachineBaseTest{

    @Test
    public void makeEspressoEnoughWaterAndCoffee()throws CoffeeMachineException {
        Espresso esp = homeCoffeeMachineWithEverything.makeEspresso();
        Assert.assertNotNull(esp);
    }

    @Test(expected = NoCoffeeException.class)
    public void makeEspressoWithoutCoffee()throws CoffeeMachineException{
        Espresso esp = homeCoffeeMachineWithoutCoffee.makeEspresso();
    }

    @Test(expected = NoWaterException.class)
    public void makeEspressoWithoutWater()throws CoffeeMachineException{
        Espresso esp = homeCoffeeMachineWithoutWater.makeEspresso();
    }

    @Test(expected = WasteOverflowException.class)
    public void makeEspressoWithFullWasteContainer()throws CoffeeMachineException {
        //given
        Espresso esp;
        int count = homeCoffeeMachineForWasteOverflowTest.getWasteLimitGR()/Espresso.COFFEE;
        for (int i = 0; i < count; i++) {
            esp = homeCoffeeMachineForWasteOverflowTest.makeEspresso();
        }
        homeCoffeeMachineForWasteOverflowTest.fillCoffeeContainer(300);

        esp = homeCoffeeMachineForWasteOverflowTest.makeEspresso();
    }
}
