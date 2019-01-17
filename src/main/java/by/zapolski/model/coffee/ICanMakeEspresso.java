package by.zapolski.model.coffee;

import by.zapolski.exception.CoffeeMachineException;

public interface ICanMakeEspresso{
    Espresso makeEspresso() throws CoffeeMachineException;
}
