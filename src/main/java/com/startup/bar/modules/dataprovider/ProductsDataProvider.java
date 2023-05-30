package com.startup.bar.modules.dataprovider;

import com.startup.bar.crosscutting.persistence.entity.Product;

import java.util.List;

public interface ProductsDataProvider {

    public List<Product> findAllProducts();
    public Product addProduct(Product product);
}
