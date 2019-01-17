package HomeMachineTests;

import by.zapolski.model.machine.HomeCoffeeMachine;
import org.junit.After;
import org.junit.Before;

public class HomeMachineBaseTest {
    HomeCoffeeMachine homeCoffeeMachineWithEverything;
    HomeCoffeeMachine homeCoffeeMachineWithoutWater;
    HomeCoffeeMachine homeCoffeeMachineWithoutCoffee;
    HomeCoffeeMachine homeCoffeeMachineForWasteOverflowTest;

    HomeCoffeeMachine homeCoffeeMachineForCleaningTest;

    @Before
    public void init(){
        homeCoffeeMachineWithEverything = new HomeCoffeeMachine();
        homeCoffeeMachineWithEverything.fillCoffeeContainer(300);
        homeCoffeeMachineWithEverything.fillWaterContainer(1500);
        homeCoffeeMachineWithEverything.enable();

        homeCoffeeMachineWithoutWater = new HomeCoffeeMachine();
        homeCoffeeMachineWithoutWater.fillCoffeeContainer(300);
        homeCoffeeMachineWithoutWater.enable();

        homeCoffeeMachineWithoutCoffee = new HomeCoffeeMachine();
        homeCoffeeMachineWithoutCoffee.fillWaterContainer(1500);
        homeCoffeeMachineWithoutCoffee.enable();

        homeCoffeeMachineForWasteOverflowTest = new HomeCoffeeMachine();
        homeCoffeeMachineForWasteOverflowTest.fillCoffeeContainer(300);
        homeCoffeeMachineForWasteOverflowTest.fillWaterContainer(1500);

        homeCoffeeMachineForCleaningTest = new HomeCoffeeMachine();
        homeCoffeeMachineForCleaningTest.fillCoffeeContainer(300);
        homeCoffeeMachineForCleaningTest.fillWaterContainer(1000);

    }

    @After
    public void tearDown() {
        homeCoffeeMachineWithEverything.disable();
        homeCoffeeMachineWithoutWater.disable();
        homeCoffeeMachineWithoutCoffee.disable();
        homeCoffeeMachineForWasteOverflowTest.disable();
        homeCoffeeMachineForCleaningTest.disable();

        homeCoffeeMachineWithEverything = null;
        homeCoffeeMachineWithoutWater = null;
        homeCoffeeMachineWithoutCoffee = null;
        homeCoffeeMachineForWasteOverflowTest = null;
        homeCoffeeMachineForCleaningTest = null;
    }
}
