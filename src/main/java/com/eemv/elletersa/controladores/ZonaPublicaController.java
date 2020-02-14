package com.eemv.elletersa.controladores;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eemv.elletersa.modelo.Producto;
import com.eemv.elletersa.modelo.TIPO_PRODUCTO;
import com.eemv.elletersa.servicios.ProductoServicio;

@Controller
@RequestMapping("/public")
public class ZonaPublicaController {
	
	@Autowired
	ProductoServicio productoServicio;
	
	
	@GetMapping({"/", "/index"})
	public String index() {
		return "index";
	}
	
	@GetMapping("/productos")
	public String showProducts(@RequestParam Map<String, Object> params, Model model) {

		List<Producto> result;
		Integer page = params.get("page") != null ? (Integer.valueOf(params.get("page").toString())-1) : 0;
		if( params.get("page") != null && Integer.valueOf((String) params.get("page")) != 0 ) {
			model.addAttribute("numPage", page);
		}else {
			model.addAttribute("numPage", 0);
		}
		PageRequest pageRequest = PageRequest.of(page, 4);
		 result = productoServicio.findAllByPage(pageRequest);
		
		String tipo =params.get("tipo") != null ? (params.get("tipo").toString()) : "";
		
		if( params.get("tipo") != null && (String) params.get("tipo") != "") {
			model.addAttribute("tipo", tipo);
			TIPO_PRODUCTO tipoP = TIPO_PRODUCTO.valueOf(tipo);
			result = productoServicio.findAllByTipo(tipoP, pageRequest);
		}
		
		
		
		if (result != null) {
			model.addAttribute("productos", result);
		}
		
		return "productos";
	}

	@GetMapping("/producto/{id}")
	public String showProduct(Model model, @PathVariable Long id) {
		Producto result = productoServicio.findById(id); 
		if (result != null) {
			model.addAttribute("producto", result);
		}
		return "app/producto/form";
	}

}
