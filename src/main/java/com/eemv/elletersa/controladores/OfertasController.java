package com.eemv.elletersa.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eemv.elletersa.modelo.Oferta;
import com.eemv.elletersa.servicios.OfertaServicio;
import com.eemv.elletersa.servicios.ProductoServicio;
import com.eemv.elletersa.servicios.TratamientoServicio;
import com.eemv.elletersa.servicios.UsuarioServicio;

@Controller
@RequestMapping("/oferta")
public class OfertasController {

	@Autowired
	ProductoServicio productoServicio;
	
	@Autowired
	TratamientoServicio tratamientoServicio;
	
	@Autowired
	OfertaServicio ofertaServicio;

	@Autowired
	UsuarioServicio usuarioServicio;
	
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable Long id) {
		Oferta p = ofertaServicio.findById(id);
		ofertaServicio.borrar(p);
		return "redirect:/public/index";
	}
	
	@GetMapping("/nuevo")
	public String nuevaOfertaForm(Model model) {
	
		model.addAttribute("oferta", new Oferta());
		
		return "app/oferta/form";
	}
	
	@PostMapping("/nuevo/submit")
	public String nuevaOfertaSubmit(@ModelAttribute Oferta oferta) {		
		
		String p= oferta.getProducto().getNombre();
		String t= oferta.getTratamiento().getNombre();
		System.out.println(oferta.getProducto());
		if (!p.isEmpty() && t.isEmpty()) {
			Long l = Long.parseLong(p);
			oferta.setProducto(productoServicio.findById(l));
			oferta.setTratamiento(null);
		}
		
		if (p.isEmpty() && !t.isEmpty()) {
			Long l = Long.parseLong(t);
			oferta.setTratamiento(tratamientoServicio.findById(l));
			oferta.setProducto(null);
		}
		ofertaServicio.insertar(oferta);
		return "redirect:/public/index";
	}
	

}
