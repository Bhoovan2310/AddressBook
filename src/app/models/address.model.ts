export interface Address {
  id?: number; // Optional for new entries
  name: string;
  email: string;
  phoneNumber?: string; // Optional
  address?: string; // Optional
}
