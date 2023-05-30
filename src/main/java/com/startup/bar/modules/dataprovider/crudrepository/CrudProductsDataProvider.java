package com.startup.bar.modules.dataprovider.crudrepository;

import com.startup.bar.crosscutting.persistence.entity.Product;
import com.startup.bar.crosscutting.persistence.repository.BarProductRepository;
import com.startup.bar.modules.dataprovider.ProductsDataProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CrudProductsDataProvider implements ProductsDataProvider {

    @Autowired
    private BarProductRepository repository;

    @Override
    public List<Product> findAllProducts() {
        return repository.findAll();
    }

    @Override
    public Product addProduct(Product product) {
        return repository.save(product);
    }
}
