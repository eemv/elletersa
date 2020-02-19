package com.eemv.elletersa.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.eemv.elletersa.modelo.Producto;
import com.eemv.elletersa.servicios.ProductoServicio;
import com.eemv.elletersa.servicios.UsuarioServicio;

@Controller
@RequestMapping("/producto")
public class ProductosController {

	@Autowired
	ProductoServicio productoServicio;

	@Autowired
	UsuarioServicio usuarioServicio;
	
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable Long id) {
		Producto p = productoServicio.findById(id);
		productoServicio.borrar(p);
		return "redirect:/public/index";
	}
	
	@GetMapping("/nuevo")
	public String nuevoProductoForm(Model model) {
		model.addAttribute("producto", new Producto());
		return "app/producto/form";
	}
	
	@PostMapping("/nuevo/submit")
	public String nuevoProductoSubmit(@ModelAttribute Producto producto) {		
		productoServicio.insertar(producto);
		return "redirect:/public/index";
	}
	

}
