package com.springjpa.model;

import javax.persistence.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = StoreTransaction.TABLE_NAME)
public class StoreTransaction {
    public static final String TABLE_NAME = "store_transaction";
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = Columns.ID,nullable = false,insertable = false,updatable = false)
    private long transactionID;
    @Column(name = Columns.DATE)
    private Date transactionDate;

    @OneToMany(mappedBy = "storeTransaction",cascade = CascadeType.ALL)
    private List<ProductTransaction> productTransactions = new LinkedList<>();
    public void addProductTransaction(ProductTransaction productTransaction){
        productTransactions.add(productTransaction);
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = Customer.Columns.ID)
    private Customer customer;

    @Override
    public String toString() {
        return "StoreTransaction{" +
                "transactionID=" + transactionID +
                ", date=" + transactionDate +
                '}';
    }


    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public List<ProductTransaction> getProductTransactions() {
        return productTransactions;
    }


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public long getTransactionID() {
        return transactionID;
    }


    public StoreTransaction() {

    }

    static class Columns {
        public static final String ID = "storetransaction_id";
        public static final String DATE = "transaction_date";

    }
}
