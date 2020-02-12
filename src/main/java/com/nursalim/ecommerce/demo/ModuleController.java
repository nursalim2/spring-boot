package com.nursalim.ecommerce.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ModuleController {
	@Autowired
	private ModuleRepository repository;
	
	// Find All Modules
    @GetMapping("/modules")
    List<Module> findAll() {
        return repository.findAll();
    }
    
    // Insert Modules
    @PostMapping("/modules")
    @ResponseStatus(HttpStatus.CREATED)
    Module newModule(@RequestBody Module newModule){
    	return repository.save(newModule);
    }
    
    // Find By Id
    @GetMapping("/modules/{id}")
    Module findOne(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ModuleNotFoundException(id));
    }
    
    // Save or update Module
    @PutMapping("/modules/{id}")
    Module saveOrUpdate(@RequestBody Module newModule, @PathVariable Long id) {

        return repository.findById(id)
                .map(x -> {
                    x.setModuleId(newModule.getModuleId());
                    x.setModuleName(newModule.getModuleName());
                    return repository.save(x);
                })
                .orElseGet(() -> {
                	newModule.setId(id);
                    return repository.save(newModule);
                });
    }
    
    @DeleteMapping("/books/{id}")
    void deleteBook(@PathVariable Long id) {
        repository.deleteById(id);
    }
    
    
    
}
