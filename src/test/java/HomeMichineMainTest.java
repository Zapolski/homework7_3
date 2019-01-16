import by.zapolski.exception.CoffeeMachineException;
import by.zapolski.exception.NoCoffeeException;
import by.zapolski.exception.NoWaterException;
import by.zapolski.exception.WasteOverflowException;
import by.zapolski.model.Cappuccino;
import by.zapolski.model.Espresso;
import by.zapolski.model.HomeCoffeeMachine;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MainTest {

    private HomeCoffeeMachine homeCoffeeMachineWithEverything;
    private HomeCoffeeMachine homeCoffeeMachineWithoutWater;
    private HomeCoffeeMachine homeCoffeeMachineWithoutCoffee;
    private HomeCoffeeMachine homeCoffeeMachineForWasteOverflowTest;

    private HomeCoffeeMachine homeCoffeeMachineForCleaningTest;

    @Before
    public void init(){
        homeCoffeeMachineWithEverything = new HomeCoffeeMachine();
        homeCoffeeMachineWithEverything.fillCoffeeContainer(300);
        homeCoffeeMachineWithEverything.fillWaterContainer(1000);
        homeCoffeeMachineWithEverything.enable();

        homeCoffeeMachineWithoutWater = new HomeCoffeeMachine();
        homeCoffeeMachineWithoutWater.fillCoffeeContainer(300);
        homeCoffeeMachineWithoutWater.enable();

        homeCoffeeMachineWithoutCoffee = new HomeCoffeeMachine();
        homeCoffeeMachineWithoutCoffee.fillWaterContainer(1000);
        homeCoffeeMachineWithoutCoffee.enable();

        homeCoffeeMachineForWasteOverflowTest = new HomeCoffeeMachine();
        homeCoffeeMachineForWasteOverflowTest.fillCoffeeContainer(300);
        homeCoffeeMachineForWasteOverflowTest.fillWaterContainer(1000);

        homeCoffeeMachineForCleaningTest = new HomeCoffeeMachine();
        homeCoffeeMachineForCleaningTest.fillCoffeeContainer(300);
        homeCoffeeMachineForCleaningTest.fillWaterContainer(1000);

    }

    @Test
    public void makeCappuccinoEnoughWaterAndCoffee()throws CoffeeMachineException {
        Cappuccino cap = homeCoffeeMachineWithEverything.makeCappuccino();
        Assert.assertNotNull(cap);
    }
    @Test(expected = NoCoffeeException.class)
    public void makeCappuccinoWithoutCoffee()throws CoffeeMachineException{
        Cappuccino cap = homeCoffeeMachineWithoutCoffee.makeCappuccino();
    }
    @Test(expected = NoWaterException.class)
    public void makeCappuccinoWithoutWater()throws CoffeeMachineException{
        Cappuccino cap = homeCoffeeMachineWithoutWater.makeCappuccino();
    }
    @Test(expected = WasteOverflowException.class)
    public void makeCappuccinoWithFullWasteContainer()throws CoffeeMachineException{
        //given
        Cappuccino cap;
        int count = homeCoffeeMachineForWasteOverflowTest.getWASTE_LIMIT_GR()/Cappuccino.COFFEE;
        for (int i = 0; i < count; i++) {
            cap = homeCoffeeMachineForWasteOverflowTest.makeCappuccino();
        }
        homeCoffeeMachineForWasteOverflowTest.fillCoffeeContainer(300);

        cap = homeCoffeeMachineForWasteOverflowTest.makeCappuccino();
    }

    @Test
    public void makeEspressoEnoughWaterAndCoffee()throws CoffeeMachineException {
        Espresso esp = homeCoffeeMachineWithEverything.makeEspresso();
        Assert.assertNotNull(esp);
    }

    @Test(expected = NoCoffeeException.class)
    public void makeEspressoWithoutCoffee()throws CoffeeMachineException{
        Espresso esp = homeCoffeeMachineWithoutCoffee.makeEspresso();
    }

    @Test(expected = NoWaterException.class)
    public void makeEspressoWithoutWater()throws CoffeeMachineException{
        Espresso esp = homeCoffeeMachineWithoutWater.makeEspresso();
    }
    @Test(expected = WasteOverflowException.class)
    public void makeEspressoWithFullWasteContainer()throws CoffeeMachineException{
        //given
        Espresso esp;
        int count = homeCoffeeMachineForWasteOverflowTest.getWASTE_LIMIT_GR()/Espresso.COFFEE;
        for (int i = 0; i < count; i++) {
            esp = homeCoffeeMachineForWasteOverflowTest.makeEspresso();
        }
        homeCoffeeMachineForWasteOverflowTest.fillCoffeeContainer(300);

        esp = homeCoffeeMachineForWasteOverflowTest.makeEspresso();
    }

    @Test
    public void testTankCleaning()throws CoffeeMachineException{
        //given
        Espresso esp;
        int count = homeCoffeeMachineForCleaningTest.getWASTE_LIMIT_GR()/Espresso.COFFEE;
        for (int i = 0; i < count; i++) {
            esp = homeCoffeeMachineForCleaningTest.makeEspresso();
        }
        homeCoffeeMachineForCleaningTest.fillCoffeeContainer(300);

        homeCoffeeMachineForCleaningTest.wasteContainerCleaning();
        esp = homeCoffeeMachineForCleaningTest.makeEspresso();
        Assert.assertNotNull(esp);
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
