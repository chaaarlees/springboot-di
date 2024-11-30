package com.charles.springboot.di.app.springboot_di.repositories;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import com.charles.springboot.di.app.springboot_di.models.Product;

@Repository("productRepoFoo")
@Primary
public class ProductRepositoryFoo implements IProductRepository {

    @Override
    public List<Product> findAll() {
        return Collections.singletonList(new Product(1L,"XBOX Series X",250000L));
    }

    @Override
    public Product findById(Long id) {
        return new Product(1L,"XBOX Series X",250000L);
    }

}
