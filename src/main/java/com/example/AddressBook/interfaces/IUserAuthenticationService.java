package com.example.AddressBook.interfaces;

import com.example.AddressBook.DTO.UserAuthenticationDTO;
import com.example.AddressBook.DTO.LoginDTO;
import com.example.AddressBook.exception.UserException;

/**
 * Interface for User Authentication Service.
 * It provides methods for user authentication operations.
 * It includes methods for user registration and login.
 */
public interface IUserAuthenticationService {
    UserAuthenticationDTO register(UserAuthenticationDTO userDTO) throws Exception;
    String login(LoginDTO loginDTO) throws UserException;
//    String activateUser(String token) throws UserException;
}
