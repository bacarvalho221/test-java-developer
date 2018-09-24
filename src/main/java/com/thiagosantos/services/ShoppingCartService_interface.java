package com.thiagosantos.services;

import com.thiagosantos.domain.Product;
import com.thiagosantos.services.exceptions.NotEnoughProductsInStockException;

import java.math.BigDecimal;
import java.util.Map;

public interface ShoppingCartService_interface {

    void addProduct(Product product);

    void removeProduct(Product product);

    Map<Product, Integer> getProductsInCart();

    void checkout() throws NotEnoughProductsInStockException;

    BigDecimal getTotal();
}
