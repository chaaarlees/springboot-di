package com.charles.springboot.di.app.springboot_di.repositories;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import com.charles.springboot.di.app.springboot_di.models.Product;
// @Component //Lo define como un componente (Puede inyectarse su instancia en otros componentes)
@Repository("productRepo") //Lo define como repositorio y le añadimos un nombre para llamar con @qualifier 
// @Primary //Define el repositorio como primario para buscar los datos 
@RequestScope //Hace que el ciclo vida de cada instancia sea por request (resuelve el problema de mutabilidad de los precios) (deja de ser singleton)
@SessionScope// Hace que el ciclo de vida de cada instancia se por session
public class ProductRepository implements IProductRepository {

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
