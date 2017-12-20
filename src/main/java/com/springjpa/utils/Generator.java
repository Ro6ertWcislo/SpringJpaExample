package com.springjpa.utils;

import com.springjpa.model.Category;
import com.springjpa.model.Product;
import com.springjpa.model.Supplier;
import com.springjpa.repo.CategoryRepository;
import com.springjpa.repo.ProductRepository;
import com.springjpa.repo.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@Component
@Configurable
public class Generator {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    SupplierRepository supplierRepository;
    @Autowired
    CategoryRepository categoryRepository;
    Random rn = new Random();

    public Generator() {
    }

    public void generate(int quantity){
        List<Category> categories = new LinkedList<>();
        List<Supplier> suppliers = new LinkedList<>();
        List<Product> products  = new LinkedList<>();
        int counter=0;
        for(int i=0;i<quantity;i++){
            categories.add(new Category("category_"+i));
        }
        for(int i=0;i<quantity;i++){
            suppliers.add(new Supplier("Company_"+i,"street_"+i,"city_"+i,"zip_"+i));
        }
        categoryRepository.save(categories);
        supplierRepository.save(suppliers);
        for(int i=0;i<quantity*quantity;i++){
            Product p= new Product("product_"+i,i);
            Category c = categories.get(rn.nextInt(categories.size()));
            Supplier s = suppliers.get(rn.nextInt(suppliers.size()));
            p.setCategory(c);
            p.setSupplier(s);
            s.addProduct(p);
            c.addProduct(p);
            products.add(p);
        }
        productRepository.save(products);
        categoryRepository.save(categories);
        supplierRepository.save(suppliers);

    }
}
