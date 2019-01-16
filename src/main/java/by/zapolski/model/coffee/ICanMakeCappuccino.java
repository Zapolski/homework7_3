package by.zapolski.model;

import by.zapolski.exception.CoffeeMachineException;

public interface ICanMakeCappuccino {
    Cappuccino makeCappuccino() throws CoffeeMachineException;
}
