package com.infogain.retail.app.purchase.service;

import com.infogain.retail.app.customer.model.Customer;
import com.infogain.retail.app.purchase.model.Purchase;
import com.infogain.retail.app.purchase.repository.PurchaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PurchaseService {

    private final PurchaseRepository purchaseRepository;

    public List<Purchase> getPurchases() {
        return purchaseRepository.findAll();
    }

    public Optional<Purchase> getPurchaseById(Long id) {
        return purchaseRepository.findById(id);
    }

    public Purchase createPurchase(Purchase purchase) {
        return purchaseRepository.save(purchase);
    }

    public Optional<Purchase> updatePurchase(Long id, Purchase purchase) {
        Optional<Purchase> existingPurchaseOptional = purchaseRepository.findById(id);
        if (existingPurchaseOptional.isEmpty()) {
            return Optional.empty();
        }
        Purchase existingPurchase = existingPurchaseOptional.get();

        existingPurchase.setDateOfPurchase(LocalDateTime.now());
        existingPurchase.setPrice(purchase.getPrice());
        existingPurchase.setRewardedPoints(purchase.getRewardedPoints());

        return Optional.of(purchaseRepository.save(existingPurchase));
    }

    public boolean deletePurchase(Long id) {
        if (purchaseRepository.existsById(id)) {
            purchaseRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
