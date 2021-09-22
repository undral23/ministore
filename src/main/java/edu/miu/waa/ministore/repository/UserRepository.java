package edu.miu.waa.ministore.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.miu.waa.ministore.domain.User;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    public Optional<User> findUserByUsername(String userName);
    public User findUserByEmail(String email);
}
