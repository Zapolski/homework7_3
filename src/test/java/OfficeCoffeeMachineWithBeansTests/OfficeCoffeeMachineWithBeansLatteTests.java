package OfficeCoffeeMachineWithBeansTests;

import by.zapolski.exception.*;
import by.zapolski.model.coffee.Latte;
import org.junit.Assert;
import org.junit.Test;

public class OfficeCoffeeMachineWithBeansLatteTests extends OfficeMachineWhtiBeansBaseTest{
    @Test
    public void makeLateEnoughWaterAndCoffeeAndMilk()throws CoffeeMachineException {
        Latte latte = officeCoffeeMachineWithEverything.makeLate(MILK_FOR_LATTE_FOR_TEST);
        Assert.assertNotNull(latte);
    }

    @Test(expected = NoBeansCoffeeException.class)
    public void makeLateWithoutCoffee()throws CoffeeMachineException{
        Latte late = officeCoffeeMachineWithoutCoffee.makeLate(MILK_FOR_LATTE_FOR_TEST);
    }

    @Test(expected = NoWaterException.class)
    public void makeLateWithoutWater()throws CoffeeMachineException{
        Latte late = officeCoffeeMachineWithoutWater.makeLate(MILK_FOR_LATTE_FOR_TEST);
    }
    @Test(expected = WasteOverflowException.class)
    public void makeLateWithFullWasteContainer()throws CoffeeMachineException{
        //given
        Latte late;
        int count = officeCoffeeMachineForWasteOverflowTest.getWasteLimitGR()/Latte.COFFEE;
        for (int i = 0; i < count; i++) {
            late = officeCoffeeMachineForWasteOverflowTest.makeLate(MILK_FOR_LATTE_FOR_TEST);
        }
        officeCoffeeMachineForWasteOverflowTest.fillCoffeeContainer(300);
        late = officeCoffeeMachineForWasteOverflowTest.makeLate(MILK_FOR_LATTE_FOR_TEST);
    }
}
