package ExtendedMachineTests;

import by.zapolski.exception.CoffeeMachineException;
import by.zapolski.model.coffee.Espresso;
import org.junit.Assert;
import org.junit.Test;

public class ExtendedMachineSystemTests extends ExtendedMachineBaseTest{
    @Test
    public void testTankCleaning()throws CoffeeMachineException {
        //given
        Espresso esp;
        int count = ExtendedCoffeeMachineForCleaningTest.getWasteLimitGR()/Espresso.COFFEE;
        for (int i = 0; i < count; i++) {
            esp = ExtendedCoffeeMachineForCleaningTest.makeEspresso();
        }
        ExtendedCoffeeMachineForCleaningTest.fillCoffeeContainer(300);

        ExtendedCoffeeMachineForCleaningTest.wasteContainerCleaning();
        esp = ExtendedCoffeeMachineForCleaningTest.makeEspresso();
        Assert.assertNotNull(esp);
    }


}
