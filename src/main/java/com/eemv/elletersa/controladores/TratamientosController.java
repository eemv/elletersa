package com.eemv.elletersa.controladores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eemv.elletersa.modelo.Pack;
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
		ProductoServicio productoServicio;
		
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
			Tratamiento tratamiento = new Tratamiento();
			List<Producto> productos = new ArrayList<>();
			productos.add(new Producto());
			productos.add(new Producto());
			productos.add(new Producto());
			tratamiento.setProductosRecomendados(productos);
			model.addAttribute("tratamiento",  tratamiento);
			return "app/tratamiento/form";
		}
		
		@PostMapping("/nuevo/submit")
		public String nuevoTratamientoSubmit(@ModelAttribute Tratamiento tratamiento) {		
			List<Producto> productos = new ArrayList<>();
			
			Long p1= tratamiento.getProductosRecomendados().get(0).getId();
			Long p2= tratamiento.getProductosRecomendados().get(1).getId();
			Long p3= tratamiento.getProductosRecomendados().get(2).getId();
			
			if (!p1.toString().isEmpty() || p1==0) {
//				Long l = Long.parseLong(p1);
				Producto pro =productoServicio.findById(p1);
				productos.add(pro);
			}if(!p2.toString().isEmpty() || p2==0) {
//				Long l = Long.parseLong(p2);
				Producto pro =productoServicio.findById(p2);
				productos.add(pro);
			}if(!p3.toString().isEmpty() || p3==0) {
//				Long l = Long.parseLong(p3);
				Producto pro =productoServicio.findById(p3);
				productos.add(pro);
			}
			tratamiento.setProductosRecomendados(productos);
			tratamientoServicio.insertar(tratamiento);
			return "redirect:/public/tratamientos";
		}
		

	}


