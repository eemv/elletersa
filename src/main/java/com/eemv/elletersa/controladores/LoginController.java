package com.eemv.elletersa.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.eemv.elletersa.modelo.Usuario;
import com.eemv.elletersa.servicios.UsuarioServicio;


@Controller
public class LoginController {
	
	@Autowired
	UsuarioServicio usuarioServicio;
	
//	@Autowired
//	StorageService storageService;
	
	@GetMapping("/")
	public String welcome() {
		return "redirect:/public/";
		//prueba git
	}
	
	
	@GetMapping("/auth/login")
	public String login(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "login";
	}
	
	
//	@PostMapping("/auth/register")
//	public String register(@ModelAttribute Usuario usuario,  @RequestParam("file") MultipartFile file) {		
//		if (!file.isEmpty()) {
//			String imagen = storageService.store(file);
//			usuario.setAvatar(MvcUriComponentsBuilder
//					.fromMethodName(FilesController.class, "serveFile", imagen).build().toUriString());
//			
//		}
//		usuarioServicio.registrar(usuario);
//		return "redirect:/auth/login";
//	}

}
