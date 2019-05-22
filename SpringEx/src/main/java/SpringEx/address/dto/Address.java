package SpringEx.address.dto;


public class Address {
    private String street;
    private Integer number;

    public Address(String street, Integer number) {
        this.street = street;
        this.number = number;
    }

    @Override
    public String toString() {
        return "address{" +
                "street='" + street + '\'' +
                ", number=" + number +
                '}';
    }
}