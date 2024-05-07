package com.shop.basket.shoppingBasket.process;

import com.shop.basket.shoppingBasket.util.Utils;
import com.shop.basket.shoppingBasket.items.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ShoppingCartProcessorTest {
    ItemMaintainer itemMaintainer ;
    ShoppingCartProcessor shoppingCartProcessor ;

    @BeforeEach
    void setUp() {
        itemMaintainer = new ItemMaintainer();
        shoppingCartProcessor = new ShoppingCartProcessor();
    }


    @Test
    void getTotalShoppingCost1() {

        List<String> shoppingItems =  Arrays.asList("Apple", "Banana", "Melon", "Lime", "Melon", "Melon");
        assertEquals(170, shoppingCartProcessor.calculateShoppingCost(shoppingItems, itemMaintainer.getItemMap()));
    }
    @Test
    void getTotalShoppingCost2() {

        List<String> shoppingItems =  Arrays.asList("Apple", "Banana", "Melon", "Lime", "Melon", "Melon", "Lime", "Lime", "Lime", "Lime");
        assertEquals(215.0, shoppingCartProcessor.calculateShoppingCost(shoppingItems, itemMaintainer.getItemMap()));
    }

    @Test
    void getTotalShoppingCost3() {

        List<String> shoppingItems =  Arrays.asList("Melon", "Melon", "Melon", "Melon", "Melon", "Melon");
        assertEquals(150, shoppingCartProcessor.calculateShoppingCost(shoppingItems, itemMaintainer.getItemMap()));
    }
    @Test
    void getAppleTotalTest()
    {
        Item item = new Apple();
        assertNotNull( item.calculateItemPrice(5, item.getUnitPrice(), item.getDiscountFactor(), item.getDiscountedPrice()));
    }
    @Test
    void getBananaTotalTest()
    {
        Item item = new Banana();
        assertNotNull( item.calculateItemPrice(5, item.getUnitPrice(), item.getDiscountFactor(), item.getDiscountedPrice()));
    }
    @Test
    void getLimeTotalTest()
    {
        Item item = new Lime();
        assertNotNull( item.calculateItemPrice(5, item.getUnitPrice(), item.getDiscountFactor(), item.getDiscountedPrice()));
    }
    @Test
    void getMelonTotalTest()
    {
        Item item = new Melon();
        assertNotNull( item.calculateItemPrice(5, item.getUnitPrice(), item.getDiscountFactor(), item.getDiscountedPrice()));
    }

    @Test
    void calculateShoppingCostTestWithDefault() {


        List<String> shoppingItems =  Arrays.asList("Apple", "Banana", "Melon", "Lime", "Melon", "Melon", "Lime", "Lime", "Lime", "Lime");

        assertEquals(215.0, shoppingCartProcessor.calculateShoppingCost(shoppingItems, itemMaintainer.getItemMap()));
    }

    @Test
    void calculateShoppingCostTestWithUpdates() {

        List<String> shoppingItems =  Arrays.asList("Apple", "Banana", "Melon", "Lime", "Melon", "Melon", "Lime", "Lime", "Lime", "Lime");

        //below values can be updated based on user input in future
        itemMaintainer.updateItem(Utils.APPLE, 30.0, 6,150.0);
        itemMaintainer.updateItem(Utils.BANANA, 5.0, 6,25.0);

        itemMaintainer.updateItem(Utils.LIME,15.0, 3,30.0);

        itemMaintainer.updateItem(Utils.MELON,  50.0, 3,80.0);
        //with updated unit price and discount values

        assertNotNull(shoppingCartProcessor.calculateShoppingCost(shoppingItems, itemMaintainer.getItemMap()));
        assertEquals(175.0, shoppingCartProcessor.calculateShoppingCost(shoppingItems, itemMaintainer.getItemMap()));
    }
}