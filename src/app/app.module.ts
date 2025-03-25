import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { AddressBookComponent } from './components/address-book/address-book.component';
import { AddressFormComponent } from './components/address-form/address-form.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

@NgModule({
  declarations: [AppComponent, AddressBookComponent, AddressFormComponent],
  imports: [BrowserModule, HttpClientModule, FormsModule , RouterModule],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {}


