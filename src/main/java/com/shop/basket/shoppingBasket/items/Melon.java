package com.shop.basket.shoppingBasket.items;

import com.shop.basket.shoppingBasket.util.Utils;

public class Melon extends Item {

    public Melon(Double unitPrice, Integer discountFactor, Double discountedPrice) {
        this.itemCode = Utils.MELON;
        this.unitPrice = unitPrice;
        this.discountFactor = discountFactor;
        this.discountedPrice = discountedPrice;
    }
    public Melon(){
        this.itemCode = Utils.MELON;
        this.unitPrice = 50.0;
        this.discountFactor = 2;
        this.discountedPrice = 50.0;
        this.itemTotal = 0.0;
    }






}
