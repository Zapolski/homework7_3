package ExtendedMachineTests;

import by.zapolski.model.machine.ExtendedCoffeeMachine;
import org.junit.After;
import org.junit.Before;

public class ExtendedMachineBaseTest {

    ExtendedCoffeeMachine ExtendedCoffeeMachineWithEverything;
    ExtendedCoffeeMachine ExtendedCoffeeMachineWithoutWater;
    ExtendedCoffeeMachine ExtendedCoffeeMachineWithoutCoffee;
    ExtendedCoffeeMachine ExtendedCoffeeMachineForWasteOverflowTest;

    ExtendedCoffeeMachine ExtendedCoffeeMachineForCleaningTest;

    @Before
    public void init(){
        ExtendedCoffeeMachineWithEverything = new ExtendedCoffeeMachine();
        ExtendedCoffeeMachineWithEverything.fillCoffeeContainer(300);
        ExtendedCoffeeMachineWithEverything.fillWaterContainer(1500);
        ExtendedCoffeeMachineWithEverything.enable();

        ExtendedCoffeeMachineWithoutWater = new ExtendedCoffeeMachine();
        ExtendedCoffeeMachineWithoutWater.fillCoffeeContainer(300);
        ExtendedCoffeeMachineWithoutWater.enable();

        ExtendedCoffeeMachineWithoutCoffee = new ExtendedCoffeeMachine();
        ExtendedCoffeeMachineWithoutCoffee.fillWaterContainer(1500);
        ExtendedCoffeeMachineWithoutCoffee.enable();

        ExtendedCoffeeMachineForWasteOverflowTest = new ExtendedCoffeeMachine();
        ExtendedCoffeeMachineForWasteOverflowTest.fillCoffeeContainer(300);
        ExtendedCoffeeMachineForWasteOverflowTest.fillWaterContainer(1500);

        ExtendedCoffeeMachineForCleaningTest = new ExtendedCoffeeMachine();
        ExtendedCoffeeMachineForCleaningTest.fillCoffeeContainer(300);
        ExtendedCoffeeMachineForCleaningTest.fillWaterContainer(1000);

    }




    @After
    public void tearDown() {
        ExtendedCoffeeMachineWithEverything.disable();
        ExtendedCoffeeMachineWithoutWater.disable();
        ExtendedCoffeeMachineWithoutCoffee.disable();
        ExtendedCoffeeMachineForWasteOverflowTest.disable();
        ExtendedCoffeeMachineForCleaningTest.disable();

        ExtendedCoffeeMachineWithEverything = null;
        ExtendedCoffeeMachineWithoutWater = null;
        ExtendedCoffeeMachineWithoutCoffee = null;
        ExtendedCoffeeMachineForWasteOverflowTest = null;
        ExtendedCoffeeMachineForCleaningTest = null;
    }





}
