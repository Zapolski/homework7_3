package ExtendedMachineTests;

import by.zapolski.exception.CoffeeMachineException;
import by.zapolski.exception.NoCoffeeException;
import by.zapolski.exception.NoWaterException;
import by.zapolski.exception.WasteOverflowException;
import by.zapolski.model.coffee.Americano;
import org.junit.Assert;
import org.junit.Test;

public class ExtendedMachineAmericanoTests extends ExtendedMachineBaseTest {

    @Test
    public void makeAmericanoEnoughWaterAndCoffee()throws CoffeeMachineException {
        Americano cap = ExtendedCoffeeMachineWithEverything.makeAmericano();
        Assert.assertNotNull(cap);
    }
    @Test(expected = NoCoffeeException.class)
    public void makeAmericanoWithoutCoffee()throws CoffeeMachineException{
        Americano amer = ExtendedCoffeeMachineWithoutCoffee.makeAmericano();
    }
    @Test(expected = NoWaterException.class)
    public void makeAmericanoWithoutWater()throws CoffeeMachineException{
        Americano amer = ExtendedCoffeeMachineWithoutWater.makeAmericano();
    }
    @Test(expected = WasteOverflowException.class)
    public void makeAmericanoWithFullWasteContainer()throws CoffeeMachineException{
        //given
        Americano amer;
        int count = ExtendedCoffeeMachineForWasteOverflowTest.getWasteLimitGR()/ Americano.COFFEE;
        for (int i = 0; i < count; i++) {
            amer = ExtendedCoffeeMachineForWasteOverflowTest.makeAmericano();
        }
        ExtendedCoffeeMachineForWasteOverflowTest.fillCoffeeContainer(300);

        amer = ExtendedCoffeeMachineForWasteOverflowTest.makeAmericano();
    }

}
