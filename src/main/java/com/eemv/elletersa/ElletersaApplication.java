package com.eemv.elletersa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.eemv.elletersa.modelo.Oferta;
import com.eemv.elletersa.modelo.Pack;
import com.eemv.elletersa.modelo.Producto;
import com.eemv.elletersa.modelo.TIPO_PIEL;
import com.eemv.elletersa.modelo.TIPO_PRODUCTO;
import com.eemv.elletersa.modelo.TIPO_TRATAMIENTO;
import com.eemv.elletersa.modelo.Tratamiento;
import com.eemv.elletersa.modelo.Usuario;
import com.eemv.elletersa.repositorios.OfertaRepository;
import com.eemv.elletersa.repositorios.PackRepository;
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

	public CommandLineRunner initData(UsuarioServicio usuarioServicio, ProductoRepository productoRepository
			, TratamientoRepository tratamientoRepository, OfertaRepository ofertaRepository, PackRepository packRepository) {

		return args -> {

			Usuario usuario = new Usuario("Luis Miguel", "López Magaña", null, "luismi.lopez@openwebinars.net",
					"luismi");
			usuarioServicio.registrar(usuario);

			productoRepository.saveAll(Arrays.asList(new Producto("Crema 1", 100.00,
					"https://static.abc.es/media/sociedad/2016/09/27/CREMA-kDjE--620x349@abc.jpg",
					"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut lficia deserunt mollit anim id est laborum.",
					"Componentes estos y aquellos", TIPO_PIEL.MADURA, TIPO_PRODUCTO.INDEPENDIENTE),
					new Producto("Crema 2", 2500.00,
							"https://www.minicar.es/large/Volkswagen-Golf-GTi-G60-Serie-II-%281990%29-Norev-1%3A18-i22889.jpg",
							"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut lficia deserunt mollit anim id est laborum.",
							"Componentes estos y aquellos", TIPO_PIEL.SENSIBLE, TIPO_PRODUCTO.COMPLEMENTARIO),
					new Producto("Crema 3", 10.50,
							"https://static.abc.es/media/sociedad/2016/09/27/CREMA-kDjE--620x349@abc.jpg",
							"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut lficia deserunt mollit anim id est laborum.",
							"Componentes estos y aquellos", TIPO_PIEL.MADURA, TIPO_PRODUCTO.INDEPENDIENTE),
					new Producto("Crema 4", 425.00,
							"https://i1-unilevermx.a8e.net.br/gg/crema-ponds-s-humectante-nutritiva-100g_170477802_7501056326142.jpg",
							"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut lficia deserunt mollit anim id est laborum.",
							"Componentes estos y aquellos", TIPO_PIEL.CASTIGADAS, TIPO_PRODUCTO.COMPLEMENTARIO),
					new Producto("Crema 5", 10.00,
							"https://www.instyle.es/medio/2019/02/01/sesderma-c-vit-radiance-fluido-luminoso_4d237e39_640x637.jpg",
							"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut lficia deserunt mollit anim id est laborum.",
							"Componentes estos y aquellos", TIPO_PIEL.TODAS, TIPO_PRODUCTO.COMPLEMENTARIO),
					new Producto("Crema 6", 350.00,
							"https://www.torrerovidre.com/files/pagina_simple/7/blog-cremas-cosmeticos.png",
							"Componentes estos y aquellos",
							"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut lficia deserunt mollit anim id est laborum.",
							TIPO_PIEL.MADURA, TIPO_PRODUCTO.INDEPENDIENTE),
					new Producto("Crema 7", 350.00,
							"https://static.abc.es/media/sociedad/2016/09/27/CREMA-kDjE--620x349@abc.jpg",
							"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut lficia deserunt mollit anim id est laborum.",
							"Componentes estos y aquellos", TIPO_PIEL.MADURA, TIPO_PRODUCTO.COMPLEMENTARIO),
					new Producto("Crema 8", 350.00,
							"https://static.abc.es/media/sociedad/2016/09/27/CREMA-kDjE--620x349@abc.jpg",
							"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut lficia deserunt mollit anim id est laborum.",
							"Componentes estos y aquellos", TIPO_PIEL.MADURA, TIPO_PRODUCTO.COMPLEMENTARIO)));
			
			Producto p5 = productoRepository.getOne(5L);
			Producto p3 = productoRepository.getOne(3L);
			Producto p2 = productoRepository.getOne(2L);
			Producto p1 = productoRepository.getOne(1L);
			
			Tratamiento t2 = tratamientoRepository.getOne(2L);
			Tratamiento t3 = tratamientoRepository.getOne(3L);
			Tratamiento t4 = tratamientoRepository.getOne(4L);
			List<Producto> l1 = new ArrayList<>();
			List<Producto> l2 = new ArrayList<>();
			List<Producto> l3 = new ArrayList<>();
			List<Tratamiento> lt1 = new ArrayList<>();
			List<Tratamiento> lt2 = new ArrayList<>();
			List<Tratamiento> lt3 = new ArrayList<>();
			l1.add(p5);
			l1.add(p1);
			l1.add(p2);

			l2.add(p3);
			l3.add(p5);
			lt1.add(t4);
			lt2.add(t3);
			lt3.add(t2);
			tratamientoRepository.saveAll(Arrays.asList(
					 new Tratamiento("Tratamiento 1", "https://img.grouponcdn.com/deal/cbHxSnrkobfiCistM73L/po-1000x600/v1/c700x420.jpg",
							 "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut lficia deserunt mollit anim id est laborum."
							 , 6, 30.00, 120, TIPO_TRATAMIENTO.CORPORAL,new ArrayList<>()),
					 new Tratamiento("Tratamiento 2", "https://img.grouponcdn.com/deal/cbHxSnrkobfiCistM73L/po-1000x600/v1/c700x420.jpg",
							 "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut lficia deserunt mollit anim id est laborum."
							 , 3, 60.00, 50, TIPO_TRATAMIENTO.FACIAL,new ArrayList<>()),
					 new Tratamiento("Tratamiento 3", "https://img.grouponcdn.com/deal/cbHxSnrkobfiCistM73L/po-1000x600/v1/c700x420.jpg",
							 "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut lficia deserunt mollit anim id est laborum."
							 , 1, 45.00, 50, TIPO_TRATAMIENTO.FACIAL,new ArrayList<>()),
					 new Tratamiento("Tratamiento 4", "https://img.grouponcdn.com/deal/cbHxSnrkobfiCistM73L/po-1000x600/v1/c700x420.jpg",
							 "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut lficia deserunt mollit anim id est laborum."
							 , 76, 189.00, 10, TIPO_TRATAMIENTO.CORPORAL, new ArrayList<>()),
					 new Tratamiento("Tratamiento 5", "https://img.grouponcdn.com/deal/cbHxSnrkobfiCistM73L/po-1000x600/v1/c700x420.jpg",
							 "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut lficia deserunt mollit anim id est laborum."
							 , 3, 60.00, 50, TIPO_TRATAMIENTO.CORPORAL, l1)
					 ));
			
			Oferta oferta1 = new Oferta("oferta1", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut lficia deserunt mollit anim id est laborum.",
					30.00, "https://images-na.ssl-images-amazon.com/images/I/81mnRoyrC7L._SL1500_.jpg");
			oferta1.setProducto(p5);
			Oferta oferta2 = new Oferta("oferta2", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut lficia deserunt mollit anim id est laborum.",
					30.00, "https://images-na.ssl-images-amazon.com/images/I/81mnRoyrC7L._SL1500_.jpg");
			oferta2.setProducto(p3);
			Oferta oferta3 = new Oferta("oferta3", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut lficia deserunt mollit anim id est laborum.",
					30.00, "https://images-na.ssl-images-amazon.com/images/I/81mnRoyrC7L._SL1500_.jpg");
			oferta3.setTratamiento(t3);
			ofertaRepository.saveAll(Arrays.asList(
					oferta1,oferta2,oferta3
					));
			
			Pack pck1 = new Pack("pack1", l1, lt1, "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut lficia deserunt mollit anim id est laborum.",
					30.00, "https://images-na.ssl-images-amazon.com/images/I/81mnRoyrC7L._SL1500_.jpg");
//			Pack pck2 = new Pack("pack2", new ArrayList<Producto>(), lt1, "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut lficia deserunt mollit anim id est laborum.",
//					30.00, "https://images-na.ssl-images-amazon.com/images/I/81mnRoyrC7L._SL1500_.jpg");
			Pack pck3 = new Pack("pack3", l2, lt2, "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut lficia deserunt mollit anim id est laborum.",
					30.00, "https://images-na.ssl-images-amazon.com/images/I/81mnRoyrC7L._SL1500_.jpg");
//			Pack pck4 = new Pack("pack4",l1, new ArrayList<Tratamiento>(), "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut lficia deserunt mollit anim id est laborum.",
//					30.00, "https://images-na.ssl-images-amazon.com/images/I/81mnRoyrC7L._SL1500_.jpg");
			packRepository.saveAll(Arrays.asList(
					pck1,pck3));
		
		};
		
		
	}	
}
