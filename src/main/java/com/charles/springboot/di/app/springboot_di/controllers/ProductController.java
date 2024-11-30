package com.charles.springboot.di.app.springboot_di.controllers;
import com.charles.springboot.di.app.springboot_di.models.Product;
import com.charles.springboot.di.app.springboot_di.services.IProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api")
public class ProductController {
   
    // private ProductService productService = new ProductService(); 
    // private ProductService productService; //inyectamos la dependencia con @autowired en vez de instanciarla
    @Autowired
    private IProductService productService; // En vez de inyectar la clase inyectamos la interfaz, de esta forma podemos usar distintos Services que implementan la misma interfaz

    @GetMapping
    public List<Product> list(){
        return productService.findAll();
    } 

    @GetMapping("/{id}")
    public Product show(@PathVariable Long id) {
        return productService.findById(id);
    }
    
    

}
