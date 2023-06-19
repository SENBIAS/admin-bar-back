package com.startup.bar.modules.products.usecase;

import com.startup.bar.crosscutting.dto.ProductDetail;
import com.startup.bar.crosscutting.model.UpdateProduct;
import com.startup.bar.crosscutting.persistence.entity.Product;
import com.startup.bar.crosscutting.persistence.entity.ProductsConsumed;
import com.startup.bar.modules.products.dataprovider.ProductsDataProvider;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class ProcessProducts {

    @Autowired
    private ProductsDataProvider repository;

    public List<Product> findAllProducts() {
        return repository.findAllProducts();
    }

    public List<ProductDetail> findProducts() {
        return repository.findProducts();
    }
    public Product newProduct(Product product) {
        return repository.addProduct(product);
    }

    public Product updateProduct(UpdateProduct updateProduct) {
        return repository.updateProduct(updateProduct);
    }
}
