package com.charles.springboot.di.app.springboot_di.services;
import java.util.List;
import java.util.stream.Collectors;

import com.charles.springboot.di.app.springboot_di.models.Product;
import com.charles.springboot.di.app.springboot_di.repositories.ProductRepository;

//USAMOS EL SERVICIO PARA TRAER LOS DATOS DESDE EL REPOSITORY
//LOS DATOS SE PUEDEN MODIFICAR SEGÚN LAS NECESIDADES DE LA APP
public class ProductService implements IProductService {

    private ProductRepository repository = new ProductRepository();

    //IMPLEMENTAR EL SERVICIO ASÍ PRODUCE PROBLEMAS DE INMUTABILIDAD (EL PRECIO CAMBIA POR CADA EJECUCIÓN YA QUE SE GUARDA EN LA MEMORIA)
    // public List<Product> findAll(){
    //     return repository.findAll().stream().map(p->{
    //         Double pricePlusTaxes = p.getPrice() * 1.25D;
    //         p.setPrice(pricePlusTaxes.longValue());
    //         return p;
    //     }).collect(Collectors.toList());
    // }

    public List<Product> findAll(){
        return repository.findAll().stream().map(p->{
            Double pricePlusTaxes = p.getPrice() * 1.25D;
            Product product = new Product(p.getId(), p.getName(), pricePlusTaxes.longValue());
            return product;
        }).collect(Collectors.toList());
    }

    public Product findById(Long id){
        return repository.findById(id);
    }

}
