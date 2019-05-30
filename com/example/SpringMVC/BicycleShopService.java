package com.example.SpringMVC;

import org.springframework.stereotype.Service;
import static com.example.SpringMVC.BicycleType.*;
import static com.example.SpringMVC.BicycleWheelsType.*;
import java.util.*;
import java.util.stream.Collectors;


@Service("bicycleShopService")
public class BicycleShopService implements BicycleService {
    private List<Bicycle> bicycleList = new ArrayList<>();
    {
        bicycleList.add(new Bicycle("Bicicleta1",MOUNTAIN)
                .customizeSticker("Mountain"));
        bicycleList.add(new Bicycle("Bicicleta2",FITNESS));
        bicycleList.add(new Bicycle("Bicicleta3",MOUNTAIN));
        bicycleList.add(new Bicycle("Bicicleta4",HYBRID)
                .customizeSticker("Hybrid"));
        bicycleList.add(new Bicycle("Bicicleta5",ADVENTURE)
                .customizeSticker("Hybrid"));
        bicycleList.add(new Bicycle("Bicicleta6",ROAD)
                .customizeSticker("Mountain"));
        bicycleList.add(new Bicycle("Bicicleta7",MOUNTAIN)
                .customizeSticker("Mountain"));
        bicycleList.add(new Bicycle("Bicicleta8",FITNESS));
        bicycleList.add(new Bicycle("Bicicleta9",MOUNTAIN));
        bicycleList.add(new Bicycle("Bicicleta10",HYBRID)
                .customizeWheels(BIG));
        bicycleList.add(new Bicycle("Bicicleta11",ADVENTURE)
                .customizeWheels(HUGE));
        bicycleList.add(new Bicycle("Bicicleta12",TOURING)
                .customizeSticker("Mountain"));
        bicycleList.add(new Bicycle("Bicicleta13",CYCLOCROSS)
                .customizeWheels(SMALL));
        bicycleList.add(new Bicycle("Bicicleta14",HYBRID)
                .customizeWheels(BIG));
        bicycleList.add(new Bicycle("Bicicleta15",ADVENTURE)
                .customizeWheels(HUGE));
        bicycleList.add(new Bicycle("Bicicleta16",TOURING)
                .customizeSticker("Mountain"));
        bicycleList.add(new Bicycle("Bicicleta17",CYCLOCROSS)
                .customizeWheels(SMALL));
    }

    @Override
    public List<Bicycle> getListOfBicycles() {
        return bicycleList;
    }

    @Override
    public Bicycle getBicycleById(int id) {
        return bicycleList.stream()
                .filter(bicycle -> bicycle.getId() == id)
                .findAny()
                .orElse(null);
    }
    @Override
    public List<Bicycle> getBicycleByIds(List<String> listOfStringIds) {
        List<Integer> listOfIntegerIds = getListOfIntegerIds(listOfStringIds);
        return bicycleList.stream()
                .filter(bicycle -> listOfIntegerIds.contains(bicycle.getId()))
                .collect(Collectors.toList());
    }
    @Override
    public List<Bicycle> getBicyclesWithLowerPrice(int price) {
        return bicycleList.stream()
                .filter(bicycle -> bicycle.getPrice() < price)
                .collect(Collectors.toList());
    }

    @Override
    public Map<BicycleType,List<Bicycle>> getBicycleGroupByBicycleType(){
        return bicycleList.stream()
                .collect(Collectors.groupingBy(Bicycle::getBicycleType));
    }

    @Override
    public  Map<BicycleWheelsType,List<Bicycle>> getBicycleGroupByBicycleWheelsType(){
        return bicycleList.stream()
                .collect(Collectors.groupingBy(Bicycle::getBicycleWheelsType));
    }

    @Override
    public boolean addBicycleIfNotExist(Bicycle bicycle){

        if(isBicycleInList(bicycle)){
            return false;
        }
        bicycleList.add(bicycle);
        return true;
    }

    @Override
    public boolean deleteBicycleById(int id){

        Bicycle bicycleWithId = getBicycleWithIdFromList(id);
       return bicycleList.remove(bicycleWithId);
    }

    @Override
    public boolean deleteAllBicycles(){
        bicycleList.clear();
        return true;
    }

    @Override
    public boolean updateBicycle(Bicycle bicycle){

        if(isBicycleInList(bicycle)) {
           updateBicycleInList(bicycle);
           return true;
        }
        return false;

    }


    private List<Integer> getListOfIntegerIds(List<String> listOfStringIds){
        return listOfStringIds.stream()
                .map(elem -> elem.split(","))
                .flatMap(Arrays::stream)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
    private boolean isBicycleInList(Bicycle bicycle){
        return bicycleList.stream()
                .anyMatch(bicycleElement -> bicycleElement.getId() == bicycle.getId());
    }

    private Bicycle getBicycleWithIdFromList(int id){
        return  bicycleList.stream()
                .filter(bicycleElement -> bicycleElement.getId() == id)
                .findAny()
                .orElse(null);
    }
    private void updateBicycleInList(Bicycle bicycle){

        ListIterator<Bicycle> listIterator = bicycleList.listIterator();
        while(listIterator.hasNext()){
            if(listIterator.next().getId() == bicycle.getId()){
                listIterator.set(bicycle);
                break;
            }
        }
    }




}
