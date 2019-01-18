package OfficeCoffeeMachineWithBeansTests;

import by.zapolski.model.machine.OfficeCoffeeMachineWithBeans;
import org.junit.After;
import org.junit.Before;

public class OfficeMachineWhtiBeansBaseTest {

    OfficeCoffeeMachineWithBeans officeCoffeeMachineWithEverything;
    OfficeCoffeeMachineWithBeans officeCoffeeMachineWithoutWater;
    OfficeCoffeeMachineWithBeans officeCoffeeMachineWithoutCoffee;
    OfficeCoffeeMachineWithBeans officeCoffeeMachineForWasteOverflowTest;

    OfficeCoffeeMachineWithBeans officeCoffeeMachineForCleaningTest;

    public static final int MILK_FOR_LATTE_FOR_TEST = 10;

    @Before
    public void init(){
        officeCoffeeMachineWithEverything = new OfficeCoffeeMachineWithBeans();
        //officeCoffeeMachineWithEverything.fillCoffeeContainer(300);
        officeCoffeeMachineWithEverything.fillWaterContainer(1500);
        officeCoffeeMachineWithEverything.fillMilkContainer(1000);
        officeCoffeeMachineWithEverything.fillBeansContainer(1000);
        officeCoffeeMachineWithEverything.enable();

        officeCoffeeMachineWithoutWater = new OfficeCoffeeMachineWithBeans();
        officeCoffeeMachineWithoutWater.fillCoffeeContainer(300);
        officeCoffeeMachineWithoutWater.fillMilkContainer(1000);
        officeCoffeeMachineWithoutWater.fillBeansContainer(1000);
        officeCoffeeMachineWithoutWater.enable();

        officeCoffeeMachineWithoutCoffee = new OfficeCoffeeMachineWithBeans();
        officeCoffeeMachineWithoutCoffee.fillWaterContainer(1500);
        officeCoffeeMachineWithoutCoffee.fillMilkContainer(1000);
        //officeCoffeeMachineWithoutCoffee.fillBeansContainer(1000);
        officeCoffeeMachineWithoutCoffee.enable();

        officeCoffeeMachineForWasteOverflowTest = new OfficeCoffeeMachineWithBeans();
        officeCoffeeMachineForWasteOverflowTest.fillCoffeeContainer(300);
        officeCoffeeMachineForWasteOverflowTest.fillWaterContainer(1500);
        officeCoffeeMachineForWasteOverflowTest.fillMilkContainer(1000);
        officeCoffeeMachineForWasteOverflowTest.fillBeansContainer(1000);

        officeCoffeeMachineForCleaningTest = new OfficeCoffeeMachineWithBeans();
        officeCoffeeMachineForCleaningTest.fillCoffeeContainer(300);
        officeCoffeeMachineForCleaningTest.fillWaterContainer(1500);
        officeCoffeeMachineForCleaningTest.fillMilkContainer(1000);
        officeCoffeeMachineForCleaningTest.fillBeansContainer(1000);

    }




    @After
    public void tearDown() {
        officeCoffeeMachineWithEverything.disable();
        officeCoffeeMachineWithoutWater.disable();
        officeCoffeeMachineWithoutCoffee.disable();
        officeCoffeeMachineForWasteOverflowTest.disable();
        officeCoffeeMachineForCleaningTest.disable();

        officeCoffeeMachineWithEverything = null;
        officeCoffeeMachineWithoutWater = null;
        officeCoffeeMachineWithoutCoffee = null;
        officeCoffeeMachineForWasteOverflowTest = null;
        officeCoffeeMachineForCleaningTest = null;
    }





}
