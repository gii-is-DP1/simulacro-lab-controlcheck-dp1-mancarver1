package org.springframework.samples.petclinic.product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.product.*;


public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public List<Product> getProductsCheaperThan(double price) {
    	List<Product> ret = new ArrayList<>();
    	for(Product p :productRepository.findAll() ) {
    		if (p.getPrice()<price) {
    			ret.add(p);
    		}}
        return ret;
    }

    public ProductType getProductType(String typeName) {
    	ProductType ret = null;
        for(ProductType p : productRepository.findAllProductTypes()) {
        	if (p.getName().equals(typeName)) {
    			ret = p;
    		}}
        return ret;
    }

    public Product save(Product p){
        return productRepository.save(p);       
    }

    
}
