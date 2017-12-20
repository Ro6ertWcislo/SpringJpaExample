package com.springjpa.model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = Columns.ID,nullable = false,insertable = false,updatable = false)
    private long id;

    @Column(name = Columns.FIRSTNAME)
    private String firstName;

    @Column(name = Columns.LASTNAME)
    private String lastName;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private List<StoreTransaction> storeTransactions = new LinkedList<>();



    protected Customer() {
    }

    public long getId() {
        return id;
    }

    public void addTransaction(StoreTransaction transaction) {
        storeTransactions.add(transaction);
    }

    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<StoreTransaction> getStoreTransactions() {
        return storeTransactions;
    }


    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


    static class Columns {
        public static final String ID = "customer_id";
        public static final String FIRSTNAME = "firstname";
        public static final String LASTNAME = "lastname";
    }
}
