package com.giangtheshy.product;

import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@Slf4j
public class ProductController {

    @Autowired private ProductService productService;

    @PostMapping("/")
    public Product create(@RequestBody Product product){
        return productService.create(product);
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id)  {
        return productService.getProduct(id);
    }

}
