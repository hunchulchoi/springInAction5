/**
 * 타코 식자재
 */
package me.nettlica.spring5.tacos;

import lombok.Data;


@Data
public class Ingredient {

    private final String id;
    private final String name;
    private final Type type;

    public static enum Type{
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE;
    }
}
