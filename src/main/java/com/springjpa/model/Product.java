package com.springjpa.model;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = Product.TABLE_NAME)
public class Product {
    public static final String TABLE_NAME = "product";
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = Columns.ID,nullable = false,insertable = false,updatable = false)
    private long productID;

    @ManyToOne
    @JoinColumn(name = Supplier.Columns.ID)
    private Supplier supplier;
    @Column(name = Columns.NAME)
    private String productName;
    @Column(name = Columns.UNITS_PER_STOCK)
    private int unitsPerStock;


    public List<ProductTransaction> getProductTransactions() {
        return productTransactions;
    }


    @ManyToOne
    @JoinColumn(name = Category.Columns.ID)
    private Category category;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    private List<ProductTransaction> productTransactions;

    public void addProductTransaction(ProductTransaction productTransaction){
        productTransactions.add(productTransaction);
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {

        this.category = category;
    }


    public Product() {
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setUnitsPerStock(int unitsPerStock) {
        this.unitsPerStock = unitsPerStock;
    }

    public String getProductName() {

        return productName;
    }

    public int getUnitsPerStock() {
        return unitsPerStock;
    }

    public Product(String productName, int unitsPerStock) {
        this.productName = productName;
        this.unitsPerStock = unitsPerStock;
    }

    public long getProductID() {
        return productID;
    }

    public Supplier getSupplier() {

        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", category= " + category.getName() +
                ", productName='" + productName + '\'' +
                ", unitsPerStock=" + unitsPerStock +
                '}';
    }

    static class Columns {
        public static final String ID = "product_id";
        public static final String CATEGORY = "category";
        public static final String NAME = "name";
        public static final String UNITS_PER_STOCK = "units_per_stock";
    }
}
