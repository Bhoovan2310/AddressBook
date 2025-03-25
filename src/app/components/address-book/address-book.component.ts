import { Component, OnInit } from '@angular/core';
import { AddressBookService } from '../../services/address.service';
import { Address } from '../../models/address.model';

@Component({
  selector: 'app-address-book',
  templateUrl: './address-book.component.html',
  styleUrls: ['./address-book.component.scss']
})
export class AddressBookComponent implements OnInit {
  addresses: Address[] = [];
  showForm = false;
  selectedAddress: Address | null = null;

  constructor(private addressService: AddressBookService) {}

  ngOnInit(): void {
    console.log('Component loaded');
    this.loadAddresses();
  }

  loadAddresses(): void {
    this.addressService.getAddresses().subscribe({
      next: (data: Address[]) => {
        this.addresses = data;
      },
      error: (err) => {
        console.error('Error loading addresses:', err);
      }
    });
  }

  addNewAddress(): void {
    this.selectedAddress = { name: '', email: '', phoneNumber: '', address: '' };
    this.showForm = true;
  }


  editAddress(address: Address): void {
    this.selectedAddress = { ...address };
    this.showForm = true;
  }

  deletePerson(id?: number) {
    if (id) {
      this.addressService.deleteAddress(id).subscribe(() => {
        this.loadAddresses(); 
      });
    } else {
      console.error('Invalid ID');
    }
  }

  closeForm(): void {
    this.showForm = false;
    this.loadAddresses();
  }

  save(): void {
    if (this.selectedAddress) {
      if (this.selectedAddress.id) {
        // Update existing address
        this.addressService.updateAddress(this.selectedAddress.id, this.selectedAddress).subscribe({
          next: () => {
            console.log('Address updated successfully');
            this.closeForm();
          },
          error: (err) => {
            console.error('Error updating address:', err);
          }
        });
      } else {
        // Add new address
        this.addressService.addAddress(this.selectedAddress).subscribe({
          next: () => {
            console.log('Address added successfully');
            this.closeForm();
          },
          error: (err) => {
            console.error('Error adding address:', err);
          }
        });
      }
    }
  }
}
