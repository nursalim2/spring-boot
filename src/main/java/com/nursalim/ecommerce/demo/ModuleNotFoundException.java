package com.nursalim.ecommerce.demo;

public class ModuleNotFoundException extends RuntimeException{
	public ModuleNotFoundException(Long id) {
        super("Book id not found : " + id);
    }
}
