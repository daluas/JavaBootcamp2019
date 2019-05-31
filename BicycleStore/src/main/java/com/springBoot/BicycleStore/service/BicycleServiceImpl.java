package com.springBoot.BicycleStore.service;

import com.springBoot.BicycleStore.model.Bicycle;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service("bicycleService")
public class BicycleServiceImpl implements BicycleService{

    private static final AtomicLong counter = new AtomicLong();

    private static List<Bicycle> bicycles;

    static{
        bicycles= populateDummyBicycles();
    }

    public List<Bicycle> findAllBicycles() {
        return bicycles;
    }

    public Bicycle findById(long id) {
        for(Bicycle bicycle : bicycles){
            if(bicycle.getId() == id){
                return bicycle;
            }
        }
        return null;
    }

    public Bicycle findByName(String name) {
        for(Bicycle bicycle : bicycles){
            if(bicycle.getName().equalsIgnoreCase(name)){
                return bicycle;
            }
        }
        return null;
    }

    public void saveBicycle(Bicycle bicycle) {
        bicycle.setId(counter.incrementAndGet());
        bicycles.add(bicycle);
    }

    public void updateBicycle(Bicycle bicycle) {
        int index = bicycles.indexOf(bicycle);
        bicycles.set(index, bicycle);
    }

    public void deleteBicycleById(long id) {

        for (Iterator<Bicycle> iterator = bicycles.iterator(); iterator.hasNext(); ) {
            Bicycle bicycle = iterator.next();
            if (bicycle.getId() == id) {
                iterator.remove();
            }
        }
    }

    public boolean isBicycleExist(Bicycle bicycle) {
        return findByName(bicycle.getName())!=null;
    }

    public void deleteAllBicycles(){
        bicycles.clear();
    }

    private static List<Bicycle> populateDummyBicycles(){
        List<Bicycle> bicycles = new ArrayList<Bicycle>();
        bicycles.add(new Bicycle(counter.incrementAndGet(),"Mountain Bike", 700));
        bicycles.add(new Bicycle(counter.incrementAndGet(),"Road Bike", 500));
        bicycles.add(new Bicycle(counter.incrementAndGet(),"Fitness Bike", 300));
        bicycles.add(new Bicycle(counter.incrementAndGet(),"Cross Bike", 400));
        return bicycles;
    }

}
