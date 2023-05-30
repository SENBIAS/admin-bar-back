package com.startup.bar.modules.api;

import com.startup.bar.crosscutting.persistence.entity.Product;
import com.startup.bar.modules.usecase.ProcessProducts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(
        value = "/product",
        produces = {MediaType.APPLICATION_JSON_VALUE}
)
@CrossOrigin("*")
public class ProductsWebApi {

    @Autowired
    private ProcessProducts process;

    @GetMapping("")
    public List<Product> findAllProducts() {
        return process.findAllProducts();
    }

    @PostMapping("/newProduct")
    public Product newProduct(@RequestBody Product product) {
        return process.newProduct(product);
    }
}
