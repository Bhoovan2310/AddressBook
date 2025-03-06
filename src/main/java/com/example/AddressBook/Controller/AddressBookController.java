package com.example.AddressBook.Controller;


import com.example.AddressBook.DTO.AddressBookDTO;
import com.example.AddressBook.Model.Address;
import com.example.AddressBook.Service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/address")
public class AddressBookController {


    @GetMapping("")
    public String intialmessage(){
        return "Welcome to the Address Book!!";
    }


    //add the Address in the book
    @PostMapping("/add")


    // Update a Addresss
    @PutMapping("update/{id}")


    @DeleteMapping("/delete/{id}")



    // Get all Adddresss
    @GetMapping("/all")


    // Get a address by ID
    @GetMapping("/{id}")

    // Get a address by email
    @GetMapping("/email/{email}")


    // Get a address by phone number
    @GetMapping("/phone/{phoneNumber}")

}
