package com.springjpa.model;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = Category.TABLE_NAME)
public class Category {
    public static final String TABLE_NAME = "category";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = Columns.ID,nullable = false,insertable = false,updatable = false)
    private long categoryID;
    @Column(name = Columns.NAME)
    private String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.PERSIST)
    private List<Product> products = new LinkedList<>();

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }
    public void addProduct(Product product){
        products.add(product);
    }

    public long getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void add(Product product) {
        products.add(product);
    }


    static class Columns {
        public static final String ID = "category_id";
        public static final String NAME = "name";

    }


}