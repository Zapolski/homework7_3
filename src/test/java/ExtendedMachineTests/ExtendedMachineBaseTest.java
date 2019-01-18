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

    public static final int MILK_FOR_LATTE_FOR_TEST = 10;
    public static final int MILK_FOR_CAPPUCCINO_FOR_TEST = 10;

    @Before
    public void init(){
        ExtendedCoffeeMachineWithEverything = new ExtendedCoffeeMachine();
        ExtendedCoffeeMachineWithEverything.fillCoffeeContainer(300);
        ExtendedCoffeeMachineWithEverything.fillWaterContainer(1500);
        ExtendedCoffeeMachineWithEverything.fillMilkContainer(1000);
        ExtendedCoffeeMachineWithEverything.enable();

        ExtendedCoffeeMachineWithoutWater = new ExtendedCoffeeMachine();
        ExtendedCoffeeMachineWithoutWater.fillCoffeeContainer(300);
        ExtendedCoffeeMachineWithoutWater.fillMilkContainer(1000);
        ExtendedCoffeeMachineWithoutWater.enable();

        ExtendedCoffeeMachineWithoutCoffee = new ExtendedCoffeeMachine();
        ExtendedCoffeeMachineWithoutCoffee.fillWaterContainer(1500);
        ExtendedCoffeeMachineWithoutCoffee.fillMilkContainer(1000);
        ExtendedCoffeeMachineWithoutCoffee.enable();

        ExtendedCoffeeMachineForWasteOverflowTest = new ExtendedCoffeeMachine();
        ExtendedCoffeeMachineForWasteOverflowTest.fillCoffeeContainer(300);
        ExtendedCoffeeMachineForWasteOverflowTest.fillWaterContainer(1500);
        ExtendedCoffeeMachineForWasteOverflowTest.fillMilkContainer(1000);

        ExtendedCoffeeMachineForCleaningTest = new ExtendedCoffeeMachine();
        ExtendedCoffeeMachineForCleaningTest.fillCoffeeContainer(300);
        ExtendedCoffeeMachineForCleaningTest.fillWaterContainer(1000);
        ExtendedCoffeeMachineForCleaningTest.fillMilkContainer(1000);

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
