import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Address } from '../models/address.model';
// import { Address } from 'cluster';

@Injectable({
  providedIn: 'root'
})
export class AddressBookService {
  private apiUrl = 'http://localhost:8080/api/user/addressBook'; // Adjust as needed

  constructor(private http: HttpClient) {}

  getAddresses(): Observable<Address[]> {
    return this.http.get<Address[]>(this.apiUrl);
  }

  getAddressById(id: number): Observable<Address> {
    return this.http.get<Address>(`${this.apiUrl}/${id}`);
  }

  addAddress(address: any): Observable<any> {
    console.log("Sending address data:", address);  // Debugging
    return this.http.post(`${this.apiUrl}/addAddress`, address);
  }

  updateAddress(id: number, address: Address): Observable<string> {
    return this.http.put<string>(`${this.apiUrl}/updateAddress/${id}`, address);
  }

  deleteAddress(id: number): Observable<string> {
    return this.http.delete<string>(`${this.apiUrl}/deleteAddress/${id}`);
  }
}
