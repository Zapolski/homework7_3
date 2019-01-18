package by.zapolski.model.coffee;

import by.zapolski.exception.CoffeeMachineException;

public interface ICanMakeLatte {
    Latte makeLate(int milkMl) throws CoffeeMachineException;
}
