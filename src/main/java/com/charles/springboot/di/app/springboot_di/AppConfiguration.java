package com.charles.springboot.di.app.springboot_di;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration //para acceder a la configuración de la aplicación
@PropertySources( //para añadir fuentes de propiedades (varias)
    @PropertySource( //para añadier fuente de propiedades (una)
        value = "classpath:values.properties"
    )
)
public class AppConfiguration {
    
}
