package by.zapolski.model.coffee;

import by.zapolski.exception.CoffeeMachineException;

public interface ICanMakeAmericano {
    Americano makeAmericano() throws CoffeeMachineException;
}
