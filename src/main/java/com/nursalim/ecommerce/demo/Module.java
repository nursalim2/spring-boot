package com.nursalim.ecommerce.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Module {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	private String moduleId;
	private String moduleName;
	
	public Module(){
	}
	
	public Module(Long id, String moduleId, String moduleName){
		this.id = id;
		this.moduleId = moduleId;
		this.moduleName = moduleName;
	}
	
	public Module(String moduleId, String moduleName){
		this.moduleId = moduleId;
		this.moduleName = moduleName;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getModuleId() {
		return moduleId;
	}
	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	
	@Override
    public String toString() {
        return "Module{" +
                "id=" + id +
                ", moduleId='" + moduleId + '\'' +
                ", moduleName='" + moduleName + '\'' +
                '}';
    }
	
}
