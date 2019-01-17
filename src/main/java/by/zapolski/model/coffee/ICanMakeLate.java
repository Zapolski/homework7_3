package by.zapolski.model.coffee;

import by.zapolski.exception.CoffeeMachineException;

public interface ICanMakeLate {
    Late makeLate(int milkMl) throws CoffeeMachineException;
}
