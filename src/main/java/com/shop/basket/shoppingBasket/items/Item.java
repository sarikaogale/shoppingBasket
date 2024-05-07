package com.shop.basket.shoppingBasket.items;

import com.shop.basket.shoppingBasket.ShoppingBasketApplication;

import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Item {
    private static Logger logger = Logger.getLogger(Item.class.getName());

    String itemCode ;
    Double unitPrice ;
    Integer discountFactor ;
    Double discountedPrice ;
    Double itemTotal;

    public String getItemCode() {
        return itemCode;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }


    public Integer getDiscountFactor() {
        return discountFactor;
    }

    public Double getDiscountedPrice() {
        return discountedPrice;
    }


    public Double calculateItemPrice(int qty, Double unitPrice, Integer discountFactor, Double discountedPrice)
    {
        if(null != discountFactor && discountFactor != 0 && null != discountedPrice)
        {
            this.itemTotal=  ((qty/discountFactor ) * discountedPrice ) + ((qty % discountFactor ) * unitPrice );
        }
        else
        {
            this.itemTotal=  unitPrice * qty;
        }
        logger.log(Level.INFO, "Item:" + this.getItemCode() + ", Qty: " + qty + ", Discount Factor: "+ this.getDiscountFactor() +
                ", Discount Price: "+ this.getDiscountedPrice() + ", Item total: "+ this.getItemTotal());

        return this.itemTotal;
    }

    public Double calculateItemPrice(int qty)
    {
        if(null != this.getDiscountFactor() && this.getDiscountFactor() != 0 && null != this.getDiscountedPrice())
        {
            this.itemTotal=  ((qty/this.getDiscountFactor() ) * this.getDiscountedPrice() ) + ((qty % this.getDiscountFactor() ) * this.getUnitPrice() );
        }
        else
        {
            this.itemTotal=  this.getUnitPrice() * qty;
        }
        logger.log(Level.INFO, "Item:" + this.getItemCode() + ", Qty: " + qty + ", Discount Factor: "+ this.getDiscountFactor() +
                ", Discount Price: "+ this.getDiscountedPrice() + ", Item total: "+ this.getItemTotal());

        return this.itemTotal;
    }


    public Double getItemTotal() {
        return this.itemTotal;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setDiscountFactor(Integer discountFactor) {
        this.discountFactor = discountFactor;
    }

    public void setDiscountedPrice(Double discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

}
