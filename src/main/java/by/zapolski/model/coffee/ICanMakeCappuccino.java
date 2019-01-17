package by.zapolski.model.coffee;

import by.zapolski.exception.CoffeeMachineException;

public interface ICanMakeCappuccino {
    Cuppuccino makeCappuccino(int milkML) throws CoffeeMachineException;
}
