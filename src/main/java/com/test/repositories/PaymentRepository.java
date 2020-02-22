package com.test.repositories;

import com.test.entities.Campaign;
import com.test.entities.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, Long> {

    Payment findById(Integer id);
    Iterable<Payment> findByRecipient(Campaign campaign);

}
