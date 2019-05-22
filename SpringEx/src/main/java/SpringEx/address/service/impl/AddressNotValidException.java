package SpringEx.address.service.impl;

public class AddressNotValidException extends Exception {
    public AddressNotValidException(String errorMessage) {
        super(errorMessage);
    }
}
