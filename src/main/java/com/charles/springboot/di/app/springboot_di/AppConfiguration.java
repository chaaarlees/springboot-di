package com.charles.springboot.di.app.springboot_di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import com.charles.springboot.di.app.springboot_di.repositories.IProductRepository;
import com.charles.springboot.di.app.springboot_di.repositories.ProductRepositoryJson;

@Configuration //para acceder a la configuración de la aplicación
@PropertySources( //para añadir fuentes de propiedades (varias)
    @PropertySource( //para añadier fuente de propiedades (una)
        value = "classpath:values.properties"
    )
)
public class AppConfiguration {
    
    @Bean("productJson")
    IProductRepository productRepositoryJson(){
        return new ProductRepositoryJson();
    }

}
