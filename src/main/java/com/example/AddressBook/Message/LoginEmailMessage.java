package com.example.AddressBook.Message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginEmailMessage {
    private String toEmail;
    private String username;
}