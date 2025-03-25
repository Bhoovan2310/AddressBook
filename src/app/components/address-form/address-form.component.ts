import { Component, EventEmitter, Input, Output } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AddressBookService } from '../../services/address.service';

@Component({
  selector: 'app-address-form',
  templateUrl: './address-form.component.html',
  styleUrls: ['./address-form.component.scss']
})
export class AddressFormComponent {
  @Input() selectedAddress: any = { id: null, name: '', email: '', phoneNumber: '', address: '' };
  @Output() close = new EventEmitter<void>();

  constructor(private addressService: AddressBookService) {}

  save(): void {
    if (!this.selectedAddress) {
      console.error("Error: selectedAddress is null");
      return;
    }

    if (this.selectedAddress.id) {
      this.addressService.updateAddress(this.selectedAddress.id, this.selectedAddress).subscribe(() => {
        this.close.emit();
      }, error => {
        console.error("Error updating address:", error);
      });
    } else {
      this.addressService.addAddress(this.selectedAddress).subscribe(() => {
        this.close.emit();
      }, error => {
        console.error("Error adding address:", error);
      });
    }
  }


  closeForm() {
    this.close.emit();
  }
}
