package com.shop.basket.shoppingBasket.process;

import com.shop.basket.shoppingBasket.ShoppingBasketApplication;
import com.shop.basket.shoppingBasket.items.*;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class ShoppingCartProcessor {
    private static Logger logger = Logger.getLogger(ShoppingCartProcessor.class.getName());


    private Map<String, Integer> getItemWiseQtyMap(List<String> shoppingItems) {
        Map<String, Integer> itemWiseQtyMap = new HashMap<>();
        for (ItemEnum inventoryItem : ItemEnum.values()) {
            List<String> result = shoppingItems.stream()
                    .filter(item -> inventoryItem.name().equalsIgnoreCase(item))
                    .collect(Collectors.toList());
            itemWiseQtyMap.put(inventoryItem.name(), result.size());
        }
        return itemWiseQtyMap;
    }


    /**
     * This method will calculate total shopping cost based on latest updated unit price, discount price and rules if any
     * @param shoppingItems
     * @param itemMap
     * @return
     */
    public Double calculateShoppingCost(List<String> shoppingItems, Map<String, Item> itemMap)
    {
        Map<String, Integer> itemWiseQtyMap = getItemWiseQtyMap(shoppingItems);
        Double shoppingTotal = 0.0;
        Item item;
        for(String key : itemWiseQtyMap.keySet())
        {
            item = itemMap.get(key);
            shoppingTotal += item.calculateItemPrice(itemWiseQtyMap.get(key));
        }
        logger.log(Level.INFO, "---------------------------Total Shopping Cost: " +shoppingTotal+"-----------------------------");

        return shoppingTotal;
    }



}



