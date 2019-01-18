package ExtendedMachineTests;

import by.zapolski.exception.CoffeeMachineException;
import by.zapolski.exception.NoCoffeeException;
import by.zapolski.exception.NoWaterException;
import by.zapolski.exception.WasteOverflowException;
import by.zapolski.model.coffee.Cappuccino;
import org.junit.Assert;
import org.junit.Test;

public class ExtendedMachineCappuccinoTests extends ExtendedMachineBaseTest{
    @Test
    public void makeCappuccinoEnoughWaterAndCoffeeAndMilk()throws CoffeeMachineException {
        Cappuccino cap = ExtendedCoffeeMachineWithEverything.makeCappuccino(MILK_FOR_CAPPUCCINO_FOR_TEST);
        Assert.assertNotNull(cap);
    }

    @Test(expected = NoCoffeeException.class)
    public void makeCappuccinoWithoutCoffee()throws CoffeeMachineException{
        Cappuccino cap = ExtendedCoffeeMachineWithoutCoffee.makeCappuccino(MILK_FOR_CAPPUCCINO_FOR_TEST);
    }
    @Test(expected = NoWaterException.class)
    public void makeCappuccinoWithoutWater()throws CoffeeMachineException{
        Cappuccino cap = ExtendedCoffeeMachineWithoutWater.makeCappuccino(MILK_FOR_CAPPUCCINO_FOR_TEST);
    }
    @Test(expected = WasteOverflowException.class)
    public void makeCappuccinoWithFullWasteContainer()throws CoffeeMachineException{
        //given
        Cappuccino cap;
        int count = ExtendedCoffeeMachineForWasteOverflowTest.getWasteLimitGR()/ Cappuccino.COFFEE;
        for (int i = 0; i < count; i++) {
            cap = ExtendedCoffeeMachineForWasteOverflowTest.makeCappuccino(MILK_FOR_CAPPUCCINO_FOR_TEST);
        }
        ExtendedCoffeeMachineForWasteOverflowTest.fillCoffeeContainer(300);
        //ExtendedCoffeeMachineForWasteOverflowTest.fillMilkContainer(1000);

        cap = ExtendedCoffeeMachineForWasteOverflowTest.makeCappuccino(MILK_FOR_CAPPUCCINO_FOR_TEST);
    }
}
