package HomeMachineTests;

import by.zapolski.exception.CoffeeMachineException;
import by.zapolski.model.coffee.Espresso;
import org.junit.Assert;
import org.junit.Test;

public class HomeMachineSystemTests extends HomeMachineBaseTest{

    @Test
    public void testTankCleaning()throws CoffeeMachineException{
        //given
        Espresso esp;
        int count = homeCoffeeMachineForCleaningTest.getWasteLimitGR()/Espresso.COFFEE;
        for (int i = 0; i < count; i++) {
            esp = homeCoffeeMachineForCleaningTest.makeEspresso();
        }
        homeCoffeeMachineForCleaningTest.fillCoffeeContainer(300);

        homeCoffeeMachineForCleaningTest.wasteContainerCleaning();
        esp = homeCoffeeMachineForCleaningTest.makeEspresso();
        Assert.assertNotNull(esp);
    }
}
