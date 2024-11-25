package com.charles.springboot.di.app.springboot_di.repositories;
import java.util.Arrays;
import java.util.List;
import com.charles.springboot.di.app.springboot_di.models.Product;

public class ProductRepository implements IProductoRepository {

    private List<Product> data;

    public ProductRepository() {
        this.data = Arrays.asList(
                new Product(1L, "RG406V", 170000L),
                new Product(2L, "M36S", 30000L),
                new Product(3L, "NINTENDO SWITCH", 200000L),
                new Product(4L, "PS5", 500000L));
    }

    @Override // indica que es un metodo implementado de la interfaz (no es necesario agregarlo)
    public List<Product> findAll() {
        return this.data;
    }

    public Product findById(Long id) {
        return this.data.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow();
    }

}
