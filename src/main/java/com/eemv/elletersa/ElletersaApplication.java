package com.eemv.elletersa;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import com.eemv.elletersa.modelo.Producto;
import com.eemv.elletersa.modelo.TIPO_PRODUCTO;
import com.eemv.elletersa.modelo.Usuario;
import com.eemv.elletersa.repositorios.ProductoRepository;
import com.eemv.elletersa.repositorios.UsuarioRepository;
import com.eemv.elletersa.servicios.UsuarioServicio;



@SpringBootApplication
@EnableAutoConfiguration
public class ElletersaApplication {
//
//	public class ApplicationStartupRunner implements CommandLineRunner {
//	 
//	    @Override
//	    public void run(String... args) throws Exception {
//	        System.out.println("hasta loc cojones y polla");
//	    }
//	}
	public static void main(String[] args) {
		SpringApplication.run(ElletersaApplication.class, args);
	}


	
	@Bean
	public CommandLineRunner initData(UsuarioServicio usuarioServicio, ProductoRepository productoRepository) {
		return args -> {

			Usuario usuario = new Usuario("Luis Miguel", "López Magaña", null, "luismi.lopez@openwebinars.net", "luismi");
			 usuarioServicio.registrar(usuario);

			Usuario usuario2 = new Usuario("Antonio", "García Martín", null, "antonio.garcia@openwebinars.net", "antonio");
			 usuarioServicio.registrar(usuario2);

			
			productoRepository.saveAll( Arrays.asList(new Producto("Bicicleta de montaña", 100.0f,
					"https://www.decathlon.es/media/835/8350582/big_23c25284-2810-415d-8bcc-e6bebdb536fc.jpg",TIPO_PRODUCTO.TIPO1),
					new Producto("Golf GTI Serie 2", 2500.0f,
							"https://www.minicar.es/large/Volkswagen-Golf-GTi-G60-Serie-II-%281990%29-Norev-1%3A18-i22889.jpg",TIPO_PRODUCTO.TIPO1
							),
					new Producto("Raqueta de tenis", 10.5f, "https://imgredirect.milanuncios.com/fg/2311/04/tenis/Raqueta-tenis-de-segunda-mano-en-Madrid-231104755_1.jpg?VersionId=T9dPhTf.3ZWiAFjnB7CvGKsvbdfPLHht", TIPO_PRODUCTO.TIPO2),
					new Producto("Xbox One X", 425.0f, "https://images.vibbo.com/635x476/860/86038583196.jpg", TIPO_PRODUCTO.TIPO3 ),
					new Producto("Trípode flexible", 10.0f, "https://images.vibbo.com/635x476/860/86074256163.jpg",TIPO_PRODUCTO.TIPO1),
					new Producto("Iphone 7 128 GB", 350.0f, "https://store.storeimages.cdn-apple.com/4667/as-images.apple.com/is/image/AppleInc/aos/published/images/i/ph/iphone7/rosegold/iphone7-rosegold-select-2016?wid=470&hei=556&fmt=jpeg&qlt=95&op_usm=0.5,0.5&.v=1472430205982",TIPO_PRODUCTO.TIPO3)));
	
			

		};
	}	
}
