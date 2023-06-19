package com.startup.bar.modules.products.dataprovider.crudrepository;

import com.startup.bar.crosscutting.dto.ProductDetail;
import com.startup.bar.crosscutting.model.UpdateProduct;
import com.startup.bar.crosscutting.persistence.entity.Presentation;
import com.startup.bar.crosscutting.persistence.entity.Product;
import com.startup.bar.crosscutting.persistence.repository.BarProductRepository;
import com.startup.bar.modules.products.dataprovider.ProductsDataProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CrudProductsDataProvider implements ProductsDataProvider {

    @Autowired
    private BarProductRepository repository;

    @Override
    public List<Product> findAllProducts() {
        return repository.findAll();
    }

    @Override
    public List<ProductDetail> findProducts() {
        List<ProductDetail> productDetails = new ArrayList<>();
        List<Product> products = findAllProducts();

        for(Product product : products) {
            String name = product.getLicor();
            for (Presentation presentation : product.getPresentations()) {

                String productName = name + " " + presentation.getMm() + "mm";
                ProductDetail productDetail = ProductDetail.builder()
                        .licor(productName)
                        .mm(presentation.getMm())
                        .price(presentation.getPrecioEstablecimiento())
                        .gain(presentation.getGananciaEstablecimiento())
                        .build();

                productDetails.add(productDetail);
            }
        }

        return productDetails;
    }

    @Override
    public Product addProduct(Product product) {
        return repository.save(product);
    }

    @Override
    public Product updateProduct(UpdateProduct updateProduct) {
        Optional<Product> productExist = repository.findById(updateProduct.getId().toString());

        if (productExist.isEmpty()) {
            throw new RuntimeException("No existe producto");
        } else {
            Product productSave = productExist.get();

            for(Presentation presentation : productSave.getPresentations()) {
                if (presentation.getMm().equals(updateProduct.getMm())) {
                    presentation.setMm(updateProduct.getMm());
                    presentation.setCantidad(updateProduct.getCantidad());
                    presentation.setGananciaEstablecimiento(updateProduct.getGananciaEstablecimiento());
                    presentation.setPrecioEstablecimiento(updateProduct.getPrecioEstablecimiento());
                    return repository.save(productSave);
                }
            }
        }
        return new Product();
    }
}
