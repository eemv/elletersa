package com.eemv.elletersa.validadores;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.eemv.elletersa.modelo.Producto;

public class ProductoFormValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Producto.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "id.required");
		
		Producto producto = (Producto) target;
		if(producto.getId() <=0){
			errors.rejectValue("id", "validation.id.error");
		}
		if(producto.getNombre().isEmpty()){
			errors.reject("nombre", "validation.producto.nombre.vacio");
		}
		
	}

}