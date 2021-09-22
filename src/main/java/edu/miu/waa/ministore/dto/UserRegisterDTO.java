package edu.miu.waa.ministore.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.Set;

import edu.miu.waa.ministore.domain.Role;

@Getter
@Setter
public class UserRegisterDTO {

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String role;

}
