package SpringEx.company.dto;

import SpringEx.address.dto.Address;

public class Company {
    private Address address;

    public Company(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "company{" +
                "address=" + address +
                '}';
    }
}
