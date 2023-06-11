package com.startup.bar.modules.dataprovider;

import com.startup.bar.crosscutting.model.UpdateProduct;
import com.startup.bar.crosscutting.persistence.entity.Product;
import org.bson.types.ObjectId;

import java.util.List;

public interface ProductsDataProvider {

    public List<Product> findAllProducts();
    public Product addProduct(Product product);

    public Product updateProduct(UpdateProduct updateProduct);
}
