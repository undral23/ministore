package edu.miu.waa.ministore.repository;

import org.springframework.data.repository.CrudRepository;

import edu.miu.waa.ministore.domain.CreditCard;

public interface CreditCardRepository extends CrudRepository<CreditCard,Long> {
}
