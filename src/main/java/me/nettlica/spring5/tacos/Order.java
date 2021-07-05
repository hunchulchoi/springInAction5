package me.nettlica.spring5.tacos;

import lombok.Data;

@Data
public class Order {

    private String deliveryName;
    private String deliveryStreeet;
    private String deliveryCity;
    private String deliveryState;
    private String deliveryZip;
    private String ccNumber;
    private String ccExpiration;
    private String ccCW;
}
