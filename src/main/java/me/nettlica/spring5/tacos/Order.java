package me.nettlica.spring5.tacos;

import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.jetbrains.annotations.NotNull;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class Order {

    @NotBlank(message = "Name is required")
    private String deliveryName;

    @NotBlank(message = "street is required")
    private String deliveryStreeet;

    @NotBlank(message = "city is required")
    private String deliveryCity;

    @NotBlank(message = "state is required")
    private String deliveryState;

    @NotBlank(message = "zipcode is required")
    private String deliveryZip;

    @CreditCardNumber(message = "Not a valid credit card Number")
    private String ccNumber;

    @Pattern(regexp = "^(0[1-9]|1[0-2])(\\/)([0-9][0-9])$"
            ,message = "Must be formatted MM/YY")
    private String ccExpiration;

    @Digits(integer = 3, fraction = 0, message = "Invalid CVV")
    private String ccCVV;
}
