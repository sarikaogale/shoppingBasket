package com.shop.basket.shoppingBasket.process;

import com.shop.basket.shoppingBasket.factory.ItemFactory;
import com.shop.basket.shoppingBasket.items.Item;
import com.shop.basket.shoppingBasket.items.ItemEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * this will update/maintain the item cost, discount rules etc.
 */
public class ItemMaintainer {

    private Map<String, Item> itemMap;

    public ItemMaintainer() {
        this.itemMap = new HashMap<>();
        for (ItemEnum inventoryItem : ItemEnum.values()) {
            this.itemMap.put(inventoryItem.name(), ItemFactory.getItem(inventoryItem.name()));
        }
    }


    /**
     * updates the latest item price, discount amount if any for a current item
     * @param itemCategory
     * @param unitPrice
     * @param discountFactor
     * @param discountedPrice
     */
    public void updateItem(String itemCategory, Double unitPrice, Integer discountFactor, Double discountedPrice)
    {
        Item item = this.getItemMap().get(itemCategory);
        if(null != item)
        {
            item.setUnitPrice(unitPrice);
            item.setDiscountFactor(discountFactor);
            item.setDiscountedPrice(discountedPrice);
            this.itemMap.put(itemCategory, item);
        }

    }


    public Map<String, Item> getItemMap() {
        return this.itemMap;
    }


}
