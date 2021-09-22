package edu.miu.waa.ministore.service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.waa.ministore.domain.Admin;
import edu.miu.waa.ministore.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    AdminRepository adminRepository;

    @Override
    public Admin getAdminProfile(String admin_userName) {
        return adminRepository.findAdminByUserName(admin_userName);
    }
}
