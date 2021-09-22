package edu.miu.waa.ministore.service;

import org.springframework.stereotype.Service;

import edu.miu.waa.ministore.domain.Admin;
import edu.miu.waa.ministore.domain.Buyer;
import edu.miu.waa.ministore.domain.Seller;
import edu.miu.waa.ministore.domain.User;
import edu.miu.waa.ministore.dto.UserRegisterDTO;

import java.util.Optional;

@Service
public interface UserService {

    public Optional<User> findUserByUserName(String userName);

    boolean createUser(UserRegisterDTO userRegisterDTO);

    public void addSeller(Seller seller);
    public void addBuyer(Buyer buyer);
    public void addAdmin(Admin admin);

}
