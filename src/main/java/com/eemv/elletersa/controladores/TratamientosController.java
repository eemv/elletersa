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
import com.eemv.elletersa.modelo.Tratamiento;
import com.eemv.elletersa.servicios.ProductoServicio;
import com.eemv.elletersa.servicios.TratamientoServicio;
import com.eemv.elletersa.servicios.UsuarioServicio;

@Controller
@RequestMapping("/tratamiento")
public class TratamientosController {
	

		@Autowired
		TratamientoServicio tratamientoServicio;

		@Autowired
		UsuarioServicio usuarioServicio;
		
		
		@GetMapping("/eliminar/{id}")
		public String eliminar(@PathVariable Long id) {
			Tratamiento t = tratamientoServicio.findById(id);
			tratamientoServicio.borrar(t);
			return "redirect:/public/tratamientos";
		}
		
		@GetMapping("/nuevo")
		public String nuevoProductoForm(Model model) {
			model.addAttribute("tratamiento", new Tratamiento());
			return "app/tratamiento/form";
		}
		
		@PostMapping("/nuevo/submit")
		public String nuevoTratamientoSubmit(@ModelAttribute Tratamiento tratamiento) {		
			tratamientoServicio.insertar(tratamiento);
			return "redirect:/public/index";
		}
		

	}


