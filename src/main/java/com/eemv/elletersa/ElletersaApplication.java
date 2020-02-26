package com.eemv.elletersa;

import java.util.Arrays;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import com.eemv.elletersa.modelo.Producto;
import com.eemv.elletersa.modelo.TIPO_PRODUCTO;
import com.eemv.elletersa.modelo.TIPO_TRATAMIENTO;
import com.eemv.elletersa.modelo.Tratamiento;
import com.eemv.elletersa.modelo.Usuario;
import com.eemv.elletersa.repositorios.ProductoRepository;
import com.eemv.elletersa.repositorios.TratamientoRepository;
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
	public CommandLineRunner initData(UsuarioServicio usuarioServicio, ProductoRepository productoRepository, TratamientoRepository tratamientoRepository) {
		return args -> {

			Usuario usuario = new Usuario("Luis Miguel", "López Magaña", null, "luismi.lopez@openwebinars.net", "luismi");
			 usuarioServicio.registrar(usuario);

			Usuario usuario2 = new Usuario("Antonio", "García Martín", null, "antonio.garcia@openwebinars.net", "antonio");
			 usuarioServicio.registrar(usuario2);

//			
//			productoRepository.saveAll( Arrays.asList(new Producto("Crema 1", 100.0f,
//					"https://scontent-mad1-1.xx.fbcdn.net/v/t1.0-9/82371178_2457842064464876_158547300392632320_n.jpg?_nc_cat=100&_nc_ohc=KK_EnnnU6IkAX-yw9Jk&_nc_ht=scontent-mad1-1.xx&oh=132391aa8417c44feff129d9524d5448&oe=5EBB9F39",TIPO_PRODUCTO.TIPO1),
//					new Producto("Crema 2", 2500.0f,
//							"https://www.minicar.es/large/Volkswagen-Golf-GTi-G60-Serie-II-%281990%29-Norev-1%3A18-i22889.jpg",TIPO_PRODUCTO.TIPO1
//							),
//					new Producto("Crema 3", 10.5f, "https://static.abc.es/media/sociedad/2016/09/27/CREMA-kDjE--620x349@abc.jpg", TIPO_PRODUCTO.TIPO2),
//					new Producto("Crema 4", 425.0f, "https://i1-unilevermx.a8e.net.br/gg/crema-ponds-s-humectante-nutritiva-100g_170477802_7501056326142.jpg", TIPO_PRODUCTO.TIPO3 ),
//					new Producto("Crema 5", 10.0f, "https://www.instyle.es/medio/2019/02/01/sesderma-c-vit-radiance-fluido-luminoso_4d237e39_640x637.jpg",TIPO_PRODUCTO.TIPO1),
//					new Producto("Crema 6", 350.0f, "https://www.torrerovidre.com/files/pagina_simple/7/blog-cremas-cosmeticos.png",TIPO_PRODUCTO.TIPO3),
//					new Producto("Crema 7", 350.0f, "https://scontent-mad1-1.xx.fbcdn.net/v/t1.0-9/66614576_2302466366669114_1889631012892180480_n.jpg?_nc_cat=103&_nc_ohc=x_qXryjeUCwAX8UZ3__&_nc_ht=scontent-mad1-1.xx&oh=0222de2ad77dc45f2d13248aee63ad3e&oe=5EF9C474",TIPO_PRODUCTO.TIPO3),
//					new Producto("Crema 8", 350.0f, "https://scontent-mad1-1.xx.fbcdn.net/v/t1.0-9/s960x960/70150585_2343310115918072_9107878944631160832_o.jpg?_nc_cat=106&_nc_ohc=Slr-MPaX09gAX8Az_o-&_nc_ht=scontent-mad1-1.xx&_nc_tp=7&oh=469cb7265bd86d32e157b859c0043bc5&oe=5EB8A7B5",TIPO_PRODUCTO.TIPO3)));
//				
			 tratamientoRepository.saveAll(Arrays.asList(
					 new Tratamiento("Tratamiento 1", "https://scontent-mad1-1.xx.fbcdn.net/v/t1.0-9/84990606_2474879242761158_8908963229443555328_n.jpg?_nc_cat=100&_nc_sid=a61e81&_nc_ohc=esMT_Lvql1gAX-klInh&_nc_ht=scontent-mad1-1.xx&oh=eadefcda6ea9ba90158a9051b2f40580&oe=5EB84B3A",
							 "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut lficia deserunt mollit anim id est laborum."
							 , 3, 60.00, 50, TIPO_TRATAMIENTO.CORPORAL)
					 ));
		};
	}	
}
