package com.shop.basket.shoppingBasket.factory;

import com.shop.basket.shoppingBasket.util.Utils;
import com.shop.basket.shoppingBasket.items.*;

public class ItemFactory
{

    private ItemFactory()
    {

    }
    /**
     * this method generates an instance of an Item object with default values
     * @param name

     * @return
     */
    public static Item getItem(String name)
    {
        Item item = null;
        switch (name)
        {
            case Utils.APPLE:
                item = new Apple() ;
                break;
            case Utils.BANANA:
                item = new Banana() ;
                break;
            case Utils.MELON:
                item = new Melon() ;
                break;
            case Utils.LIME:
                item = new Lime() ;
                break;

        }
        return item;

    }

    public static Item getItem(String name, Double unitPrice, Integer discountFactor, Double discountedPrice)
    {
        Item item = null;
        switch (name)
        {
            case Utils.APPLE:
                item = new Apple(unitPrice, discountFactor, discountedPrice) ;
                break;
            case Utils.BANANA:
                item = new Banana(unitPrice, discountFactor, discountedPrice) ;
                break;
            case Utils.MELON:
                item = new Melon(unitPrice, discountFactor, discountedPrice) ;
                break;
            case Utils.LIME:
                item = new Lime(unitPrice, discountFactor, discountedPrice) ;
                break;

        }
        return item;

    }


}
