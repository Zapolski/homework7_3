package HomeMachineTests;

import by.zapolski.exception.CoffeeMachineException;
import by.zapolski.exception.NoCoffeeException;
import by.zapolski.exception.NoWaterException;
import by.zapolski.exception.WasteOverflowException;
import by.zapolski.model.coffee.Americano;
import org.junit.Assert;
import org.junit.Test;

public class HomeMachineAmericanoTests extends HomeMachineBaseTest {
    @Test
    public void makeAmericanoEnoughWaterAndCoffee()throws CoffeeMachineException {
        Americano cap = homeCoffeeMachineWithEverything.makeAmericano();
        Assert.assertNotNull(cap);
    }
    @Test(expected = NoCoffeeException.class)
    public void makeAmericanoWithoutCoffee()throws CoffeeMachineException{
        Americano amer = homeCoffeeMachineWithoutCoffee.makeAmericano();
    }
    @Test(expected = NoWaterException.class)
    public void makeAmericanoWithoutWater()throws CoffeeMachineException{
        Americano amer = homeCoffeeMachineWithoutWater.makeAmericano();
    }
    @Test(expected = WasteOverflowException.class)
    public void makeAmericanoWithFullWasteContainer()throws CoffeeMachineException{
        //given
        Americano amer;
        int count = homeCoffeeMachineForWasteOverflowTest.getWasteLimitGR()/ Americano.COFFEE;
        for (int i = 0; i < count; i++) {
            amer = homeCoffeeMachineForWasteOverflowTest.makeAmericano();
        }
        homeCoffeeMachineForWasteOverflowTest.fillCoffeeContainer(300);

        amer = homeCoffeeMachineForWasteOverflowTest.makeAmericano();
    }
}
