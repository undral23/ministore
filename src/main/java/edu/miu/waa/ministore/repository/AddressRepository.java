package edu.miu.waa.ministore.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.miu.waa.ministore.domain.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address,Long> {

}
