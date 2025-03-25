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

    @Autowired
    AddressBookService addressBookService;

    @GetMapping("")
    public String intialmessage(){
        return "Welcome to the Address Book!!";
    }


    //add the Address in the book
    @PostMapping("/add")
    public ResponseEntity<String> addAddress(@RequestBody AddressBookDTO addressBookDTO) {
        try {
            addressBookService.addAddress(addressBookDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body("Contact added successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    // Update a Addresss
    @PutMapping("update/{id}")
    public ResponseEntity<String> updateContact(@PathVariable Long id, @RequestBody AddressBookDTO addressBookDTO) {
        try {
            addressBookService.updateAddress(id, addressBookDTO);
            return ResponseEntity.ok("Contact updated successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAddress(@PathVariable Long id){
        addressBookService.deleteAddress(id);
        return ResponseEntity.ok("Address Deleted Successfully");
    }


    // Get all Adddresss
    @GetMapping("/all")
    public ResponseEntity<List<Address>> getAllContacts() {
        List<Address> contacts = addressBookService.getAllContacts();
        return ResponseEntity.ok(contacts);
    }

    // Get a address by ID
    @GetMapping("/{id}")
    public ResponseEntity<Address> getContactById(@PathVariable Long id) {
        Optional<Address> contact = addressBookService.getContactById(id);
        return contact.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Get a address by email
    @GetMapping("/email/{email}")
    public ResponseEntity<Address> getContactByEmail(@PathVariable String email) {
        Optional<Address> contact = addressBookService.getContactByEmail(email);
        return contact.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Get a address by phone number
    @GetMapping("/phone/{phoneNumber}")
    public ResponseEntity<Address> getContactByPhoneNumber(@PathVariable String phoneNumber) {
        Optional<Address> contact = addressBookService.getContactByPhoneNumber(phoneNumber);
        return contact.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
