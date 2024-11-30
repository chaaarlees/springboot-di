package com.charles.springboot.di.app.springboot_di.services;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.charles.springboot.di.app.springboot_di.models.Product;
import com.charles.springboot.di.app.springboot_di.repositories.IProductRepository;

//USAMOS EL SERVICIO PARA TRAER LOS DATOS DESDE EL REPOSITORY
//LOS DATOS SE PUEDEN MODIFICAR SEGÚN LAS NECESIDADES DE LA APP
// @Component //Lo define como un componente (Puede inyectarse su instancia en otros componentes)
@Service // Lo define como Servicio
public class ProductService implements IProductService {

    // private ProductRepository repository = new ProductRepository(); //llamamos al objeto repository instanciandolo con ProductRepository (Forma antigua sin @component)
    
    // @Autowired
    // private ProductRepository repository; //inyectamos el repository usando @autowired en vez de instanciarlo como arriba ↑ (Principio hollywood -> no lo llamaes, nosotros te llamaremos)
   
    

    // public ProductService(@Qualifier("productRepo") IProductRepository repository) {
    //     // Usamos el @Qualifier para determinar que ProductRepository va a ser el repositorio a inyectar (y no ProductRepositoryFoo)
    //     // para poder usar el Qualifier debemos hacer un constructor de la clase que reciba como parámetro a la interfaz
    //     // IMPORTANTE: PARA INYECTAR DEPENDENCIAS USANDO EL CONSTRUCTOR DEBEMOS QUITAR EL @AUTOWIRED O NO NOS TOMARÁ EL @QUALIFIER
    //     this.repository = repository;
    // }

    // @Autowired
    // public void setRepository(IProductoRepository repository) {
    // this.repository = repository; //Inyección mediante setter (otra forma)
    // }

    @Autowired
    @Qualifier("productRepo")
    private IProductRepository repository; // Inyectamos la interfaz en vez de la clase


    // public ProductService(IProductoRepository repository) {
    // this.repository = repository; //También se puede inyectar la dependecia
    // mediante el uso de constructor (sin usar @autowired)
    // }

    // IMPLEMENTAR EL SERVICIO ASÍ PRODUCE PROBLEMAS DE INMUTABILIDAD (EL PRECIO
    // CAMBIA POR CADA EJECUCIÓN YA QUE SE GUARDA EN LA MEMORIA)
    // public List<Product> findAll(){
    // return repository.findAll().stream().map(p->{
    // Double pricePlusTaxes = p.getPrice() * 1.25D;
    // p.setPrice(pricePlusTaxes.longValue());
    // return p;
    // }).collect(Collectors.toList());
    // }

    @Value("${config.tax}") //Traer valor desde archivo properties creado
    private Double tax;

    public List<Product> findAll() {
        return repository.findAll().stream().map(p -> {
            Double pricePlusTaxes = p.getPrice() * tax;
            Product product = new Product(p.getId(), p.getName(), pricePlusTaxes.longValue());
            return product;
        }).collect(Collectors.toList());
    }

    public Product findById(Long id) {
        return repository.findById(id);
    }

}
