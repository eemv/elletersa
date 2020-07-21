package com.eemv.elletersa.controladores;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.eemv.elletersa.modelo.Oferta;
import com.eemv.elletersa.modelo.Pack;
import com.eemv.elletersa.modelo.Producto;
import com.eemv.elletersa.modelo.TIPO_PRODUCTO;
import com.eemv.elletersa.modelo.TIPO_TRATAMIENTO;
import com.eemv.elletersa.modelo.Tratamiento;
import com.eemv.elletersa.modelo.Usuario;
import com.eemv.elletersa.servicios.OfertaServicio;
import com.eemv.elletersa.servicios.PackServicio;
import com.eemv.elletersa.servicios.ProductoServicio;
import com.eemv.elletersa.servicios.TratamientoServicio;

@Controller
@RequestMapping("/public")
public class ZonaPublicaController {
	
	@Autowired
	ProductoServicio productoServicio;
	
	@Autowired
	TratamientoServicio tratamientoServicio;
	
	@Autowired
	PackServicio packServicio;
	
	@Autowired
	OfertaServicio ofertaServicio;
	
//	private static final Logger LOGGER=LoggerFactory.getLogger(ZonaPublicaController.class);
	
	@GetMapping({"/" ,"/index"})
	public String index(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "index";
	}
	
	@GetMapping("/productos")
	public String showProducts(@RequestParam Map<String, Object> params, Model model) {
		Integer itemsPerPage = 6;
		List<Producto> result;
		Integer page = params.get("page") != null ? (Integer.valueOf(params.get("page").toString())-1) : 0;
		String tipo =params.get("tipo") != null ? (params.get("tipo").toString()) : "";
		PageRequest pageRequest = null;

		Double maxPaginas = productoServicio.findAll().stream().count() / itemsPerPage.doubleValue();
		
		if( params.get("page") != null && Integer.valueOf((String) params.get("page")) != 0 ) {
			model.addAttribute("numPage", page);
			pageRequest = PageRequest.of(page, itemsPerPage);
		}else {
			model.addAttribute("numPage", 0);
			pageRequest = PageRequest.of(0, itemsPerPage);
		}
		
		if( params.get("tipo") != null && (String) params.get("tipo") != "") {
			model.addAttribute("tipo", tipo);
			TIPO_PRODUCTO tipoP = TIPO_PRODUCTO.valueOf(tipo);
			maxPaginas = productoServicio.findAllByTipo(tipoP).stream().count() / itemsPerPage.doubleValue();
			result = productoServicio.findAllByTipo(tipoP,pageRequest);
		}else {
		 result = productoServicio.findAllByPage(pageRequest);
		}
		
		if (result != null) {
			model.addAttribute("productos", result);
			model.addAttribute("maxPaginas", (int) Math.ceil(maxPaginas));
		}
		model.addAttribute("usuario", new Usuario());
		return "productos";
	}

	@GetMapping("/productos/{id}")
	public ModelAndView showProduct(ModelMap modelMap, @PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView();
		Producto result = productoServicio.findById(id); 
		if (result != null) {
			
			Oferta oferta = new Oferta();
			Long ofertaId = 0L;
			 try { 
				ofertaId = ofertaServicio.findAll().stream().filter(x->x.getProducto().equals(result)).findFirst().get().getId();
			 } catch(RuntimeException NoSuchElementException){
			 }
			
			if(ofertaId != null) {
				
			oferta = ofertaServicio.findById(ofertaId);
			}
			modelMap.addAttribute("producto", result);
			modelMap.addAttribute("oferta", oferta);
			
		}
		modelMap.addAttribute("usuario", new Usuario());
		modelAndView.addAllObjects(modelMap);
		modelAndView.setViewName("app/producto/form");
		return modelAndView;
	}
	
	@GetMapping("/productos/search/{search}")
	public String searchProduct(Model model, @PathVariable String search) {
		PageRequest pageRequest = PageRequest.of(0, 10);
		List<Producto> result = productoServicio.buscar(search, pageRequest); 
		if (result != null) {
			model.addAttribute("productos", result);
		}
		model.addAttribute("usuario", new Usuario());
		return "productos";
	}
	
	@GetMapping("/tratamientos")
	public String showTratamientos(@RequestParam Map<String, Object> params, Model model) {
		Integer itemsPerPage = 6;
		List<Tratamiento> result;
		Integer page = params.get("page") != null ? (Integer.valueOf(params.get("page").toString())-1) : 0;
		String tipo =params.get("tipo") != null ? (params.get("tipo").toString()) : "";
		PageRequest pageRequest = null;

		Double maxPaginas = tratamientoServicio.findAll().stream().count() / itemsPerPage.doubleValue();
		
		if( params.get("page") != null && Integer.valueOf((String) params.get("page")) != 0 ) {
			model.addAttribute("numPage", page);
			pageRequest = PageRequest.of(page, itemsPerPage);
		}else {
			model.addAttribute("numPage", 0);
			pageRequest = PageRequest.of(0, itemsPerPage);
		}
		
		if( params.get("tipo") != null && (String) params.get("tipo") != "") {
			model.addAttribute("tipo", tipo);
			TIPO_TRATAMIENTO tipoT = TIPO_TRATAMIENTO.valueOf(tipo);
			maxPaginas = tratamientoServicio.findAllByTipo(tipoT).stream().count() / itemsPerPage.doubleValue();
			result = tratamientoServicio.findAllByTipo(tipoT,pageRequest);
		}else {
		 result = tratamientoServicio.findAllByPage(pageRequest);
		}
		
		if (result != null) {
			model.addAttribute("tratamientos", result);
			model.addAttribute("maxPaginas", (int) Math.ceil(maxPaginas));
		}
		model.addAttribute("usuario", new Usuario());
		return "tratamientos";
	}

	@GetMapping("/tratamientos/{id}")
	public String showTratamiento(Model model, @PathVariable Long id) {
		Tratamiento result = tratamientoServicio.findById(id); 
		if (result != null) {
			model.addAttribute("tratamiento", result);
		}
		model.addAttribute("usuario", new Usuario());
		return "app/tratamiento/form";
	}
	
	@GetMapping("/tratamientos/search/{search}")
	public String searchTratamiento(Model model, @PathVariable String search) {
		PageRequest pageRequest = PageRequest.of(0, 10);
		List<Tratamiento> result = tratamientoServicio.buscar(search, pageRequest); 
		if (result != null) {
			model.addAttribute("tratamiento", result);
		}
		model.addAttribute("usuario", new Usuario());
		return "tratamientos";
	}
	
	@GetMapping("/packs")
	public String showPacks(@RequestParam Map<String, Object> params, Model model) {
		Integer itemsPerPage = 1;
		List<Pack> result;
		Integer page = params.get("page") != null ? (Integer.valueOf(params.get("page").toString())-1) : 0;
		
		PageRequest pageRequest = null;

		Double maxPaginas = packServicio.findAll().stream().count() / itemsPerPage.doubleValue();
		result = packServicio.findAllByPage(pageRequest);
		
		if( params.get("page") != null && Integer.valueOf((String) params.get("page")) != 0 ) {
			model.addAttribute("numPage", page);
			pageRequest = PageRequest.of(page, itemsPerPage);
		}else {
			model.addAttribute("numPage", 0);
			pageRequest = PageRequest.of(0, itemsPerPage);
		}
		
		if (result != null) {
			model.addAttribute("packs", result);
			model.addAttribute("maxPaginas", (int) Math.ceil(maxPaginas));
		}
		model.addAttribute("usuario", new Usuario());
		return "packs";
	}

	@GetMapping("/packs/{id}")
	public String showPack(Model model, @PathVariable Long id) {
		Pack result = packServicio.findById(id); 
		if (result != null) {
			model.addAttribute("pack", result);
//			model.addAttribute("productos",result.getProductos());
//			model.addAttribute("tratamientos",result.getTratamientos());
		}
		model.addAttribute("usuario", new Usuario());
		return "app/pack/form";
	}
	
	@GetMapping("/ofertas")
	public String showOfertas(@RequestParam Map<String, Object> params, Model model) {
		Integer itemsPerPage = 1;
		List<Oferta> result;
		Integer page = params.get("page") != null ? (Integer.valueOf(params.get("page").toString())-1) : 0;
		
		PageRequest pageRequest = null;

		Double maxPaginas = ofertaServicio.findAll().stream().count() / itemsPerPage.doubleValue();
		result = ofertaServicio.findAllByPage(pageRequest);
		
		if( params.get("page") != null && Integer.valueOf((String) params.get("page")) != 0 ) {
			model.addAttribute("numPage", page);
			pageRequest = PageRequest.of(page, itemsPerPage);
		}else {
			model.addAttribute("numPage", 0);
			pageRequest = PageRequest.of(0, itemsPerPage);
		}
		
		if (result != null) {
			model.addAttribute("ofertas", result);
			model.addAttribute("maxPaginas", (int) Math.ceil(maxPaginas));
		}
		model.addAttribute("usuario", new Usuario());
		return "ofertas";
	}
	
	@GetMapping("/ofertas/{id}")
	public String showOferta(Model model, @PathVariable Long id) {
		Oferta result = ofertaServicio.findById(id); 
		if (result != null) {
			model.addAttribute("oferta", result);
			model.addAttribute("producto",result.getProducto());
			model.addAttribute("tratamiento",result.getTratamiento());
		}
		model.addAttribute("usuario", new Usuario());
		return "app/oferta/form";
	}
	
//	@GetMapping("/tratamientos/search/{search}")
//	public String searchTratamiento(Model model, @PathVariable String search) {
//		PageRequest pageRequest = PageRequest.of(0, 10);
//		List<Tratamiento> result = tratamientoServicio.buscar(search, pageRequest); 
//		if (result != null) {
//			model.addAttribute("tratamiento", result);
//		}
//		model.addAttribute("usuario", new Usuario());
//		return "tratamientos";
//	}
	
}
