package com.eemv.elletersa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.eemv.elletersa.modelo.Pack;
import com.eemv.elletersa.modelo.Producto;
import com.eemv.elletersa.modelo.TIPO_PIEL;
import com.eemv.elletersa.modelo.TIPO_PRODUCTO;
import com.eemv.elletersa.modelo.TIPO_TRATAMIENTO;
import com.eemv.elletersa.modelo.Tratamiento;
import com.eemv.elletersa.modelo.Usuario;
import com.eemv.elletersa.repositorios.PackRepository;
import com.eemv.elletersa.repositorios.ProductoRepository;
import com.eemv.elletersa.repositorios.TratamientoRepository;
import com.eemv.elletersa.servicios.PackServicio;
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
	public CommandLineRunner initData(UsuarioServicio usuarioServicio, ProductoRepository productoRepository, TratamientoRepository tratamientoRepository,
			PackServicio packServicio) {
		return args -> {

			Usuario usuario = new Usuario("Luis Miguel", "López Magaña", null, "luismi.lopez@openwebinars.net", "luismi");
			 usuarioServicio.registrar(usuario);

			 
			productoRepository.saveAll( Arrays.asList(new Producto("Crema 1", 100.00,"https://static.abc.es/media/sociedad/2016/09/27/CREMA-kDjE--620x349@abc.jpg",
					"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut lficia deserunt mollit anim id est laborum.","Componentes estos y aquellos",TIPO_PIEL.MADURA, TIPO_PRODUCTO.INDEPENDIENTE),
					new Producto("Crema 2", 2500.00,
							"https://www.minicar.es/large/Volkswagen-Golf-GTi-G60-Serie-II-%281990%29-Norev-1%3A18-i22889.jpg","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut lficia deserunt mollit anim id est laborum.","Componentes estos y aquellos",TIPO_PIEL.SENSIBLE,TIPO_PRODUCTO.COMPLEMENTARIO
							),
					new Producto("Crema 3", 10.50, "https://static.abc.es/media/sociedad/2016/09/27/CREMA-kDjE--620x349@abc.jpg","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut lficia deserunt mollit anim id est laborum.","Componentes estos y aquellos",TIPO_PIEL.MADURA, TIPO_PRODUCTO.INDEPENDIENTE),
					new Producto("Crema 4", 425.00, "https://i1-unilevermx.a8e.net.br/gg/crema-ponds-s-humectante-nutritiva-100g_170477802_7501056326142.jpg","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut lficia deserunt mollit anim id est laborum.","Componentes estos y aquellos",TIPO_PIEL.CASTIGADAS, TIPO_PRODUCTO.COMPLEMENTARIO ),
					new Producto("Crema 5", 10.00, "https://www.instyle.es/medio/2019/02/01/sesderma-c-vit-radiance-fluido-luminoso_4d237e39_640x637.jpg","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut lficia deserunt mollit anim id est laborum.","Componentes estos y aquellos",TIPO_PIEL.TODAS,TIPO_PRODUCTO.COMPLEMENTARIO),
					new Producto("Crema 6", 350.00, "https://www.torrerovidre.com/files/pagina_simple/7/blog-cremas-cosmeticos.png","Componentes estos y aquellos","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut lficia deserunt mollit anim id est laborum.",TIPO_PIEL.MADURA,TIPO_PRODUCTO.INDEPENDIENTE),
					new Producto("Crema 7", 350.00, "https://static.abc.es/media/sociedad/2016/09/27/CREMA-kDjE--620x349@abc.jpg","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut lficia deserunt mollit anim id est laborum.","Componentes estos y aquellos",TIPO_PIEL.MADURA,TIPO_PRODUCTO.COMPLEMENTARIO),
					new Producto("Crema 8", 350.00, "https://static.abc.es/media/sociedad/2016/09/27/CREMA-kDjE--620x349@abc.jpg","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut lficia deserunt mollit anim id est laborum.","Componentes estos y aquellos",TIPO_PIEL.MADURA,TIPO_PRODUCTO.COMPLEMENTARIO)));
				
			 tratamientoRepository.saveAll(Arrays.asList(
					 new Tratamiento("Tratamiento 1", "https://scontent-mad1-1.xx.fbcdn.net/v/t1.0-9/84990606_2474879242761158_8908963229443555328_n.jpg?_nc_cat=100&_nc_sid=a61e81&_nc_ohc=esMT_Lvql1gAX-klInh&_nc_ht=scontent-mad1-1.xx&oh=eadefcda6ea9ba90158a9051b2f40580&oe=5EB84B3A",
							 "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut lficia deserunt mollit anim id est laborum."
							 , 6, 30.00, 120, TIPO_TRATAMIENTO.CORPORAL),
					 new Tratamiento("Tratamiento 2", "https://img.grouponcdn.com/deal/cbHxSnrkobfiCistM73L/po-1000x600/v1/c700x420.jpg",
							 "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut lficia deserunt mollit anim id est laborum."
							 , 3, 60.00, 50, TIPO_TRATAMIENTO.FACIAL),
					 new Tratamiento("Tratamiento 3", "https://scontent-mad1-1.xx.fbcdn.net/v/t1.0-9/84990606_2474879242761158_8908963229443555328_n.jpg?_nc_cat=100&_nc_sid=a61e81&_nc_ohc=esMT_Lvql1gAX-klInh&_nc_ht=scontent-mad1-1.xx&oh=eadefcda6ea9ba90158a9051b2f40580&oe=5EB84B3A",
							 "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut lficia deserunt mollit anim id est laborum."
							 , 1, 45.00, 50, TIPO_TRATAMIENTO.FACIAL),
					 new Tratamiento("Tratamiento 4", "https://scontent-mad1-1.xx.fbcdn.net/v/t1.0-9/s960x960/82819442_2467271300188619_4021108236902989824_o.jpg?_nc_cat=111&_nc_sid=2d5d41&_nc_ohc=V5FsgjzoFmQAX-RX_oF&_nc_ht=scontent-mad1-1.xx&_nc_tp=7&oh=d825264d9628497c300965bcb89ae4ba&oe=5EFF37F7",
							 "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut lficia deserunt mollit anim id est laborum."
							 , 76, 189.00, 10, TIPO_TRATAMIENTO.CORPORAL),
					 new Tratamiento("Tratamiento 5", "https://scontent-mad1-1.xx.fbcdn.net/v/t1.0-9/s960x960/79824148_2441887579393658_5355566142117117952_o.jpg?_nc_cat=109&_nc_sid=8024bb&_nc_ohc=znPRdlHNHiwAX9T_Jlz&_nc_ht=scontent-mad1-1.xx&_nc_tp=7&oh=2c06803748f0798f3b084b97fa914294&oe=5EFB56A8",
							 "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut lficia deserunt mollit anim id est laborum."
							 , 3, 60.00, 50, TIPO_TRATAMIENTO.CORPORAL)
					 ));
			 
			 Tratamiento t1 = new Tratamiento("Tratamiento 6", "https://img.grouponcdn.com/deal/cbHxSnrkobfiCistM73L/po-1000x600/v1/c700x420.jpg",
					 "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut lficia deserunt mollit anim id est laborum."
					 , 3, 60.00, 50, TIPO_TRATAMIENTO.FACIAL);
			 
			 Tratamiento t2 = new Tratamiento("Tratamiento 7", "https://img.grouponcdn.com/deal/cbHxSnrkobfiCistM73L/po-1000x600/v1/c700x420.jpg",
					 "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut lficia deserunt mollit anim id est laborum."
					 , 3, 60.00, 50, TIPO_TRATAMIENTO.FACIAL);
			 
			 Producto p1 = new Producto("Crema9", 234.54,"https://static.abc.es/media/sociedad/2016/09/27/CREMA-kDjE--620x349@abc.jpg",
					 "Lorem ipso", "Estos y aquellos", TIPO_PIEL.CASTIGADAS, TIPO_PRODUCTO.COMPLEMENTARIO);
			 
			 List<Tratamiento> TratamientosList1 = new ArrayList<Tratamiento>();
			 List<Producto> ProductosList1 = new ArrayList<>();
			 ProductosList1.add(p1);
			 TratamientosList1.add(t1);
			 TratamientosList1.add(t2);
			 
			 Pack pack1 =  new Pack("Pack1",ProductosList1,TratamientosList1, "Descripcion", 45.00,"https://img.grouponcdn.com/deal/cbHxSnrkobfiCistM73L/po-1000x600/v1/c700x420.jpg");
			 
			 packServicio.insertar(pack1);
		};
	}	
}
