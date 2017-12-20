package com.springjpa.model;

import javax.persistence.*;

@Entity
@Table(name = ProductTransaction.TABLE_NAME)
public class ProductTransaction {
    public static final String TABLE_NAME = "product_transaction";
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = Columns.ID,nullable = false,insertable = false,updatable = false)
    private long productID;

    @Column(name = Columns.QUANTITY)
    private int quantity;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = StoreTransaction.Columns.ID)
    private StoreTransaction storeTransaction;

    public long getProductID() {
        return productID;
    }

    public int getQuantity() {

        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public StoreTransaction getStoreTransaction() {
        return storeTransaction;
    }

    public void setStoreTransaction(StoreTransaction storeTransaction) {
        this.storeTransaction = storeTransaction;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = Product.Columns.ID)
    private Product product;


    static class Columns {
        public static final String ID = "product_transaction_id";
        public static final String QUANTITY = "category";
    }
}
