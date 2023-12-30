package lab6;

import java.util.*;

public class SalesTracker {
    public static void main(String[] args) {
        TreeMap<String, Integer> sales = new TreeMap<>();

        addSale(sales, "яблоко");
        addSale(sales, "апельсин");
        addSale(sales, "апельсин");
        addSale(sales, "груша");
        addSale(sales, "апельсин");

        // sales - экземпляр объкта TreeMap
        System.out.println("Список проданных продуктов:");
        for (Map.Entry<String, Integer> entry : sales.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        int totalSales = 0;
        for (int quantity : sales.values()) {
            totalSales += quantity;
        }
        System.out.println("Общее кол-во проданных продуктов: " + totalSales);

        String popularProduct = "";
        int maxQuantity = 0;
        for (Map.Entry<String, Integer> entry : sales.entrySet()) {
            if (entry.getValue() > maxQuantity) {
                popularProduct = entry.getKey();
                maxQuantity = entry.getValue();
            }
        }
        System.out.println("Самый популярный продукт: " + popularProduct);
    }

    private static void addSale(TreeMap<String, Integer> sales, String product) {
        if (sales.containsKey(product)) {
            sales.put(product, sales.get(product) + 1);
        } else {
            sales.put(product, 1);
        }
    }
}
