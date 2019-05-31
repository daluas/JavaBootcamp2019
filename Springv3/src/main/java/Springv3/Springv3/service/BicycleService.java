package Springv3.Springv3.service;

import Springv3.Springv3.model.Bicycle;

import java.util.List;
import java.util.Optional;

public interface BicycleService {

    List<Bicycle> getAllBicycles();
    Optional<Bicycle> getBicycleById(Integer id);
    Boolean deleteByid(Integer id);
    Boolean updateById(Integer id, Bicycle bike);
    Boolean addBicycle(Bicycle bike);
}
