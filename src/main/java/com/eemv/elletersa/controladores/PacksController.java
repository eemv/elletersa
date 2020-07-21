package com.eemv.elletersa.controladores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eemv.elletersa.modelo.Pack;
import com.eemv.elletersa.modelo.Producto;
import com.eemv.elletersa.modelo.Tratamiento;
import com.eemv.elletersa.repositorios.ProductoRepository;
import com.eemv.elletersa.repositorios.TratamientoRepository;
import com.eemv.elletersa.servicios.PackServicio;
import com.eemv.elletersa.servicios.ProductoServicio;
import com.eemv.elletersa.servicios.TratamientoServicio;
import com.eemv.elletersa.servicios.UsuarioServicio;

@Controller
@RequestMapping("/pack")
public class PacksController {

	@Autowired
	ProductoServicio productoServicio;
	
	@Autowired
	TratamientoServicio tratamientoServicio;
	
	@Autowired
	PackServicio packServicio;

	@Autowired
	UsuarioServicio usuarioServicio;
	
	@Autowired
	ProductoRepository productoRepository;
	
	@Autowired
	TratamientoRepository tratamientoRepository;
	
//	@GetMapping("/eliminar/{id}")
//	public String eliminar(@PathVariable Long id) {
//		Pack o = packServicio.findById(id);
//		if(o.getProductos() != null) {
//			Producto producto = o.getProducto();
//			producto.setpack(null);
//			
//			o.setProducto(null);
//			productoServicio.insertar(producto);
//			packServicio.insertar(o);
//		}else if(o.getTratamiento() != null) {
//			Tratamiento tratamiento = o.getTratamiento();
//			tratamiento.setpack(null);
//			
//			o.setTratamiento(null);
//			tratamientoServicio.insertar(tratamiento);
//			packServicio.insertar(o);
//		}
		
		
//		pack o2 = packServicio.findById(id);
//     	packServicio.borrar(o);
//		return "redirect:/public/index";
//	}
	
	@GetMapping("/nuevo")
	public String nuevoPackForm(Model model) {
		
		Pack pack = new Pack();
		List<Producto> productos = new ArrayList<>();
		productos.add(new Producto());
		productos.add(new Producto());
		productos.add(new Producto());
		pack.setProductos(productos);
		
		List<Tratamiento> tratamientos = new ArrayList<>();
		tratamientos.add(new Tratamiento());
		tratamientos.add(new Tratamiento());
		tratamientos.add(new Tratamiento());
		pack.setTratamientos(tratamientos);
		
		model.addAttribute("pack", pack);
		
		return "app/pack/form";
	}
	
	@PostMapping("/nuevo/submit")
	public String nuevoPackSubmit(@ModelAttribute Pack pack) {

		List<Producto> productos = new ArrayList<>();
		List<Tratamiento> tratamientos = new ArrayList<>();
		
		Long p1= pack.getProductos().get(0).getId();
		Long p2= pack.getProductos().get(1).getId();
		Long p3= pack.getProductos().get(2).getId();
		
		Long t1= pack.getTratamientos().get(0).getId();
		Long t2= pack.getTratamientos().get(1).getId();
		Long t3= pack.getTratamientos().get(2).getId();
		
//		String t= pack.getTratamiento().getNombre();
		if (!p1.toString().isEmpty() || p1==0) {
//			Long l = Long.parseLong(p1);
			Producto pro =productoServicio.findById(p1);
			productos.add(pro);
		}if(!p2.toString().isEmpty() || p2==0) {
//			Long l = Long.parseLong(p2);
			Producto pro =productoServicio.findById(p2);
			productos.add(pro);
		}if(!p3.toString().isEmpty() || p3==0) {
//			Long l = Long.parseLong(p3);
			Producto pro =productoServicio.findById(p3);
			productos.add(pro);
		}
		
		if (!t1.toString().isEmpty() || t1==0) {
//			Long l = Long.parseLong(p1);
			Tratamiento tra =tratamientoServicio.findById(t1);
			tratamientos.add(tra);
		}if(!t2.toString().isEmpty() || t2==0) {
//			Long l = Long.parseLong(p2);
			Tratamiento tra =tratamientoServicio.findById(t2);
			tratamientos.add(tra);
		}if(!t3.toString().isEmpty() || t3==0) {
//			Long l = Long.parseLong(p3);
			Tratamiento tra =tratamientoServicio.findById(t3);
			tratamientos.add(tra);
		}
			pack.setProductos(productos);
			pack.setTratamientos(tratamientos);
			packServicio.insertar(pack);
			
		return "redirect:/public/packs";
	}
}
