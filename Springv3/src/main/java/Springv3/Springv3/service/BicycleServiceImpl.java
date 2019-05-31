package Springv3.Springv3.service;

import Springv3.Springv3.model.Bicycle;
import Springv3.Springv3.model.BicycleColour;
import Springv3.Springv3.model.BicycleSize;
import Springv3.Springv3.model.BicycleType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BicycleServiceImpl implements BicycleService {

    private List<Bicycle> bicycleRepository = new ArrayList<Bicycle>()
    {{
        add(new Bicycle(1,"Verve+ Lowstep Red",BicycleType.MOUNTAIN, BicycleSize.S,2399.99, BicycleColour.RED, "Trek"));
        add(new Bicycle(2,"San Anselmo DS-E",BicycleType.ROAD, BicycleSize.XS,2849.99,BicycleColour.BLACK, "Marin"));
        add(new Bicycle(3,"Montague Paratrooper",BicycleType.MOUNTAIN, BicycleSize.L,2995.00,BicycleColour.BLUE, "Montague"));
        add(new Bicycle(4,"Marin Hawk Hill",BicycleType.BMX, BicycleSize.S,1529.99,BicycleColour.WHITE, "Marin"));
        add(new Bicycle(5,"Psratrooper Pro",BicycleType.BMX, BicycleSize.M,955.00,BicycleColour.BLUE, "Montague"));
        add(new Bicycle(6,"Super Commuter+ 8S Viper Red",BicycleType.HYBRID, BicycleSize.L,5199.99,BicycleColour.GREEN, "Trek"));
    }};
    @Override
    public List<Bicycle> getAllBicycles() {
        return  bicycleRepository;
    }

    @Override
    public Optional<Bicycle> getBicycleById(Integer id) {
        Optional<Bicycle> bike =  bicycleRepository.stream()
                                                    .filter(x -> id.equals(x.getId()))
                                                    .findFirst();
        return bike;
    }

    @Override
    public Boolean deleteByid(Integer id) {
       return bicycleRepository.removeIf(x -> id.equals(x.getId()));
    }

    @Override
    public Boolean updateById(Integer id, Bicycle bike) {
        Optional<Bicycle> searchedBike =  bicycleRepository.stream()
                .filter(x -> id.equals(x.getId()))
                .findFirst();
        if(searchedBike.isPresent()){
            bicycleRepository = bicycleRepository.stream()
                    .filter(x -> id.equals(x.getId()))
                    .map(x -> bike).collect(Collectors.toList());
            return true;
        }
        else
            return false;

    }

    @Override
    public Boolean addBicycle(Bicycle bike) {

        return bicycleRepository.add(bike);
    }
}
