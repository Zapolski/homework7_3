package OfficeCoffeeMachineWithBeansTests;

import by.zapolski.exception.*;
import by.zapolski.model.coffee.Americano;
import org.junit.Assert;
import org.junit.Test;

public class OfficeMachineAmericanoTests extends OfficeMachineWhtiBeansBaseTest {
    @Test
    public void makeAmericanoEnoughWaterAndCoffee()throws CoffeeMachineException {
        Americano amer = officeCoffeeMachineWithEverything.makeAmericano();
        Assert.assertNotNull(amer);
    }
    @Test(expected = NoBeansCoffeeException.class)
    public void makeAmericanoWithoutCoffee()throws CoffeeMachineException{
        Americano amer = officeCoffeeMachineWithoutCoffee.makeAmericano();
    }
    @Test(expected = NoWaterException.class)
    public void makeAmericanoWithoutWater()throws CoffeeMachineException{
        Americano amer = officeCoffeeMachineWithoutWater.makeAmericano();
    }
    @Test(expected = WasteOverflowException.class)
    public void makeAmericanoWithFullWasteContainer()throws CoffeeMachineException{
        //given
        Americano amer;
        int count = officeCoffeeMachineForWasteOverflowTest.getWasteLimitGR()/ Americano.COFFEE;
        for (int i = 0; i < count; i++) {
            amer = officeCoffeeMachineForWasteOverflowTest.makeAmericano();
        }
        officeCoffeeMachineForWasteOverflowTest.fillCoffeeContainer(300);

        amer = officeCoffeeMachineForWasteOverflowTest.makeAmericano();
    }
}
