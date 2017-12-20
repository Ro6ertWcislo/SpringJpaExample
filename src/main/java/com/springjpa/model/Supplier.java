package com.springjpa.model;


import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = Supplier.TABLE_NAME)
public class Supplier {
    public static final String TABLE_NAME = "supplier";

    public Supplier() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = Columns.ID,nullable = false,insertable = false,updatable = false)
    private long id;


    @Column(name = Columns.COMPANY_NAME)
    private String companyName;
    @Column(name = Columns.STREET)
    private String street;
    @Column(name = Columns.CITY)
    private String city;
    @Column(name = Columns.ZIP_CODE)
    private String zipCode;

    @OneToMany(mappedBy = "supplier", cascade = CascadeType.PERSIST)
    private List<Product> products = new LinkedList<>();

    public long getId() {
        return id;
    }

    public Supplier(String companyName, String street, String city, String zipCode) {
        this.companyName = companyName;
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
    }

    public void addProduct(Product product){
        products.add(product);
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public List<Product> getProducts() {
        return products;
    }


    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    static class Columns {
        public static final String ID = "supplier_id";
        public static final String COMPANY_NAME = "company_name";
        public static final String STREET = "street";
        public static final String CITY = "city";
        public static final String ZIP_CODE = "zip_code";
    }


}



