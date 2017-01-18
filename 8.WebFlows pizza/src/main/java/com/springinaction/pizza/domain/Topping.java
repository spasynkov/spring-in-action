package com.springinaction.pizza.domain;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Fat Faggy on 16.01.2017.
 */
public enum Topping {
    CHEESE,
    TOMATOES,
    SAUSAGES;

    public static List<Topping> getAsList() {
        return Arrays.asList(Topping.values());
    }
}
