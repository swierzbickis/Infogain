package com.infogain.retail.app.purchase.model;

import com.infogain.retail.app.customer.model.Customer;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Purchase {

    @Id
    private Long id;

    private LocalDateTime dateOfPurchase;

    private BigDecimal rewardedPoints;

    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

}
