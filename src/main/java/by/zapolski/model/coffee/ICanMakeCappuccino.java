package by.zapolski.model.coffee;

import by.zapolski.exception.CoffeeMachineException;

public interface ICanMakeCappuccino {
    Cappuccino makeCappuccino(int milkML) throws CoffeeMachineException;
}
