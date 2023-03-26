package com.infogain.retail.app.customer.model;

import com.infogain.retail.app.purchase.model.Purchase;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {

    @Id
    private Long id;

    private String emailAddress;

    private String firstName;

    private String lastName;

    @OneToMany(mappedBy = "customer")
    private Set<Purchase> purchases;

}
