package me.nettlica.spring5.tacos.web;

import lombok.extern.slf4j.Slf4j;
import me.nettlica.spring5.tacos.Order;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/orders")
@Slf4j
public class OrderController {

    @PostMapping
    public String porcessOrder(@Valid Order order, Errors errors) {
        log.info("order: {}, {}", order, errors);

        if(errors.hasErrors()){
            errors.getAllErrors().stream().forEach(e->log.error("{}: {}", e.getCode(), e.getDefaultMessage()));
            return "orderForm";
        }

        return "redirect:/";
    }

}
