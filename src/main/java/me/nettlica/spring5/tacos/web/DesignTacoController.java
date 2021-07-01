package me.nettlica.spring5.tacos.web;

import lombok.extern.slf4j.Slf4j;
import me.nettlica.spring5.tacos.Ingredient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import me.nettlica.spring5.tacos.Ingredient.Type;

@Slf4j
@Controller
@RequestMapping("/design")
public class DesignTacoController {

    public String showDesignForm(Model model) {

        List<Ingredient> ingredientList = ingredientList();

        //Type별로 식자재 그룹화
        Map<Type, List<Ingredient>> typeListMap = ingredientList.stream().collect(Collectors.groupingBy(Ingredient::getType));

        typeListMap.keySet().stream().forEach(k->model.addAttribute(k.toString().toLowerCase(Locale.ROOT), typeListMap.get(k)));

        return "design";
    }

    public static List<Ingredient>  ingredientList(){
        return  Arrays.asList(
                new Ingredient("FLTO", "Flour Tortilla", Type.WRAP),
                new Ingredient("COTO", "Corn Tortilla", Type.WRAP),
                new Ingredient("GRBF", "Ground Beef", Type.PROTEIN),
                new Ingredient("CARN", "Carnitas", Type.PROTEIN),
                new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES),
                new Ingredient("LETC", "Lettuce", Type.VEGGIES),
                new Ingredient("CHED", "Cheddar", Type.CHEESE),
                new Ingredient("JACK", "Monterrey Jack", Type.CHEESE),
                new Ingredient("SLSA", "Salsa", Type.SAUCE),
                new Ingredient("SRCR", "Sour Cream", Type.SAUCE)
        );
    }


}
