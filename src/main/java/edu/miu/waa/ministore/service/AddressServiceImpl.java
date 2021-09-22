package edu.miu.waa.ministore.service;

import org.springframework.beans.factory.annotation.Autowired;

import edu.miu.waa.ministore.repository.AddressRepository;

public class AddressServiceImpl implements AddressService{
    @Autowired
    AddressRepository addressRepository;
}

