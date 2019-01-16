package by.zapolski.model;

import by.zapolski.exception.CoffeeMachineException;

public interface ICanMakeEspresso{
    Espresso makeEspresso() throws CoffeeMachineException;
}
