package com.redhat.cloudnative;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import java.io.Serializable;

@Entity 
@Table(name = "INVENTORY") 
public class Inventory implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id 
    private String itemId;

    @Column
    private int quantity;

    public Inventory() {
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Inventory [itemId='" + itemId + '\'' + ", quantity=" + quantity + ']';
    }
}