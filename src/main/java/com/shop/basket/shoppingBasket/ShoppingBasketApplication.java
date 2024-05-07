package com.shop.basket.shoppingBasket;

import com.shop.basket.shoppingBasket.process.ItemMaintainer;
import com.shop.basket.shoppingBasket.util.Utils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.shop.basket.shoppingBasket.process.ShoppingCartProcessor;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
public class ShoppingBasketApplication {
	private static Logger logger = Logger.getLogger(ShoppingBasketApplication.class.getName());

	public static void main(String[] args) {
		SpringApplication.run(ShoppingBasketApplication.class, args);

		ItemMaintainer itemMaintainer = new ItemMaintainer();

		ShoppingCartProcessor shoppingCartProcessor = new ShoppingCartProcessor();

		logger.log(Level.INFO, "Total shopping cost with all default values (unit price and discounted price)-----------------------------");


		//This will use default values for unit price, discount offer
		List<String> shoppingList1 =  Arrays.asList("Apple", "Banana", "Melon", "Lime", "Melon", "Melon");
		shoppingCartProcessor.calculateShoppingCost(shoppingList1, itemMaintainer.getItemMap());

		//This will use default values for unit price, discount offer
		List<String> shoppingList2 =  Arrays.asList("Melon", "Melon", "Melon", "Melon", "Melon", "Melon", "Melon");
		shoppingCartProcessor.calculateShoppingCost(shoppingList2, itemMaintainer.getItemMap());

		logger.log(Level.INFO, "Total Cost with updated item price and discount price---------------------------------------------------------------");

		updateItems(itemMaintainer);

		//This will use updated values for unit price, discount offer
		shoppingList1 =  Arrays.asList("Apple", "Banana", "Melon", "Lime", "Melon", "Melon");
		shoppingCartProcessor.calculateShoppingCost(shoppingList1, itemMaintainer.getItemMap());

		//This will use updated values for unit price, discount offer
		shoppingList2 =  Arrays.asList("Melon", "Melon", "Melon", "Melon", "Melon", "Melon", "Melon");
		shoppingCartProcessor.calculateShoppingCost(shoppingList2, itemMaintainer.getItemMap());

		//This will use updated values for unit price, discount offer
		shoppingList2 = Arrays.asList("Apple", "Banana", "Melon", "Lime", "Melon", "Melon", "Lime", "Lime", "Lime", "Lime", "Lime", "Lime",
				"Apple", "Apple", "Melon", "Lime", "Melon");
		shoppingCartProcessor.calculateShoppingCost(shoppingList2, itemMaintainer.getItemMap());


	}

	/**
	 * This method will take the new updated values like unit price, discount price if any,and updates the Fruit item.
	 * @return
	 */
	private static void updateItems(ItemMaintainer itemMaintainer)
	{
		//below values can be updated based on user input in future
		itemMaintainer.updateItem(Utils.APPLE, 30.0, 6,150.0);
		itemMaintainer.updateItem(Utils.BANANA, 5.0, 6,25.0);

		itemMaintainer.updateItem(Utils.LIME,15.0, 3,30.0);

		itemMaintainer.updateItem(Utils.MELON,  50.0, 3,80.0);
	}

}
