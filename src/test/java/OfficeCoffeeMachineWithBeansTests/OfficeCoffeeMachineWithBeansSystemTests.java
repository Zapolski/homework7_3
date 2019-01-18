package OfficeCoffeeMachineWithBeansTests;

import HomeMachineTests.HomeMachineBaseTest;
import by.zapolski.exception.CoffeeMachineException;
import by.zapolski.model.coffee.Americano;
import by.zapolski.model.coffee.Espresso;
import org.junit.Assert;
import org.junit.Test;

public class OfficeCoffeeMachineWithBeansSystemTests extends OfficeMachineWhtiBeansBaseTest{

    @Test
    public void testTankCleaning()throws CoffeeMachineException{
        //given
        Americano amer;
        int count = officeCoffeeMachineForCleaningTest.getWasteLimitGR()/Americano.COFFEE;
        for (int i = 0; i < count; i++) {
            amer = officeCoffeeMachineForCleaningTest.makeAmericano();
        }
        officeCoffeeMachineForCleaningTest.fillCoffeeContainer(300);

        officeCoffeeMachineForCleaningTest.wasteContainerCleaning();
        amer = officeCoffeeMachineForCleaningTest.makeAmericano();
        Assert.assertNotNull(amer);
    }
}
