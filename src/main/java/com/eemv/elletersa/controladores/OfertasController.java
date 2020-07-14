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
import com.eemv.elletersa.modelo.Producto;
import com.eemv.elletersa.modelo.Tratamiento;
import com.eemv.elletersa.repositorios.ProductoRepository;
import com.eemv.elletersa.repositorios.TratamientoRepository;
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
	
	@Autowired
	ProductoRepository productoRepository;
	
	@Autowired
	TratamientoRepository tratamientoRepository;
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable Long id) {
		Oferta o = ofertaServicio.findById(id);
		if(o.getProducto() != null) {
			Producto producto = o.getProducto();
			producto.setOferta(null);
			
			o.setProducto(null);
			productoServicio.insertar(producto);
			ofertaServicio.insertar(o);
		}else if(o.getTratamiento() != null) {
			Tratamiento tratamiento = o.getTratamiento();
			tratamiento.setOferta(null);
			
			o.setTratamiento(null);
			tratamientoServicio.insertar(tratamiento);
			ofertaServicio.insertar(o);
		}
		
		
//		Oferta o2 = ofertaServicio.findById(id);
     	ofertaServicio.borrar(o);
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
		if (!p.isEmpty() && t.isEmpty()) {
			Long l = Long.parseLong(p);
			Producto pro =productoServicio.findById(l);
			oferta.setProducto(pro);
			oferta.setTratamiento(null);
			pro.setOferta(oferta);
			ofertaServicio.insertar(oferta);
			productoRepository.save(pro);
		}else if (p.isEmpty() && !t.isEmpty()) {
			Long l = Long.parseLong(t);
			Tratamiento tr =tratamientoServicio.findById(l);
			oferta.setTratamiento(tr);
			oferta.setProducto(null);
			tr.setOferta(oferta);
			ofertaServicio.insertar(oferta);
			tratamientoRepository.save(tr);
		}
		
		return "redirect:/public/index";
	}
}
