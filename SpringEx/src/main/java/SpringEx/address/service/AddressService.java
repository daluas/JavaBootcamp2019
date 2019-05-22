package SpringEx.address.service;

import SpringEx.address.dto.Address;
import org.springframework.stereotype.Component;

@Component
public interface AddressService {
    void create(Address address);
}
