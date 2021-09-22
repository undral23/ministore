package edu.miu.waa.ministore.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.miu.waa.ministore.domain.Phone;

@Repository
public interface PhoneRepository extends CrudRepository<Phone,Long> {
}
