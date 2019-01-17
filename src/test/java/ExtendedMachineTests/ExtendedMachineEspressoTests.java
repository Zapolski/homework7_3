package ExtendedMachineTests;

import by.zapolski.exception.CoffeeMachineException;
import by.zapolski.exception.NoCoffeeException;
import by.zapolski.exception.NoWaterException;
import by.zapolski.exception.WasteOverflowException;
import by.zapolski.model.coffee.Espresso;
import org.junit.Assert;
import org.junit.Test;

public class ExtendedMachineEspressoTests extends ExtendedMachineBaseTest{

    @Test
    public void makeEspressoEnoughWaterAndCoffee()throws CoffeeMachineException {
        Espresso esp = ExtendedCoffeeMachineWithEverything.makeEspresso();
        Assert.assertNotNull(esp);
    }

    @Test(expected = NoCoffeeException.class)
    public void makeEspressoWithoutCoffee()throws CoffeeMachineException{
        Espresso esp = ExtendedCoffeeMachineWithoutCoffee.makeEspresso();
    }

    @Test(expected = NoWaterException.class)
    public void makeEspressoWithoutWater()throws CoffeeMachineException{
        Espresso esp = ExtendedCoffeeMachineWithoutWater.makeEspresso();
    }
    @Test(expected = WasteOverflowException.class)
    public void makeEspressoWithFullWasteContainer()throws CoffeeMachineException{
        //given
        Espresso esp;
        int count = ExtendedCoffeeMachineForWasteOverflowTest.getWasteLimitGR()/Espresso.COFFEE;
        for (int i = 0; i < count; i++) {
            esp = ExtendedCoffeeMachineForWasteOverflowTest.makeEspresso();
        }
        ExtendedCoffeeMachineForWasteOverflowTest.fillCoffeeContainer(300);

        esp = ExtendedCoffeeMachineForWasteOverflowTest.makeEspresso();
    }
}
