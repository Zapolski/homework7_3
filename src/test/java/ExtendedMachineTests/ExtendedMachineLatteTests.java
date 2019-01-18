package ExtendedMachineTests;

import by.zapolski.exception.CoffeeMachineException;
import by.zapolski.exception.NoCoffeeException;
import by.zapolski.exception.NoWaterException;
import by.zapolski.exception.WasteOverflowException;
import by.zapolski.model.coffee.Latte;
import org.junit.Assert;
import org.junit.Test;

public class ExtendedMachineLatteTests extends ExtendedMachineBaseTest{
    @Test
    public void makeLateEnoughWaterAndCoffeeAndMilk()throws CoffeeMachineException {
        Latte latte = ExtendedCoffeeMachineWithEverything.makeLate(MILK_FOR_LATTE_FOR_TEST);
        Assert.assertNotNull(latte);
    }

    @Test(expected = NoCoffeeException.class)
    public void makeLateWithoutCoffee()throws CoffeeMachineException{
        Latte late = ExtendedCoffeeMachineWithoutCoffee.makeLate(MILK_FOR_LATTE_FOR_TEST);
    }

    @Test(expected = NoWaterException.class)
    public void makeLateWithoutWater()throws CoffeeMachineException{
        Latte late = ExtendedCoffeeMachineWithoutWater.makeLate(MILK_FOR_LATTE_FOR_TEST);
    }
    @Test(expected = WasteOverflowException.class)
    public void makeLateWithFullWasteContainer()throws CoffeeMachineException{
        //given
        Latte late;
        int count = ExtendedCoffeeMachineForWasteOverflowTest.getWasteLimitGR()/Latte.COFFEE;
        for (int i = 0; i < count; i++) {
            late = ExtendedCoffeeMachineForWasteOverflowTest.makeLate(MILK_FOR_LATTE_FOR_TEST);
        }
        ExtendedCoffeeMachineForWasteOverflowTest.fillCoffeeContainer(300);

        late = ExtendedCoffeeMachineForWasteOverflowTest.makeLate(MILK_FOR_LATTE_FOR_TEST);
    }
}
