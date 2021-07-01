package me.nettlica.spring5.tacos.web;

import me.nettlica.spring5.tacos.Ingredient;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

class DesignTacoControllerTest {

    @Test
    void test() {

        Ingredient.Type[] types = Ingredient.Type.values();

        List<Ingredient> ingredientList = DesignTacoController.ingredientList();

        // type별로 식자재를 분류
        //Arrays.stream(types).collect(groupingBy(In))
        Map<Ingredient.Type, List<Ingredient>> map = ingredientList.stream().collect(groupingBy(Ingredient::getType));

        map.keySet().stream().forEach(k-> System.out.println(k+ ":" + map.get(k).stream().map(Ingredient::getName).collect(Collectors.joining(","))));
    }
}