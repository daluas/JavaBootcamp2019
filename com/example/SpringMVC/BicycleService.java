package com.example.SpringMVC;

import java.util.List;
import java.util.Map;

/**
 * Interfata care contine serviciile oferite
 */
public interface BicycleService {
    /**
     * @return Returneaza lista tuturor bicicletelor
     */
    List<Bicycle> getListOfBicycles();
    /**
     * @param id Un identificator unic pentru bicicleta
     * @return Returneaza bicicleta cu id-ul respectiv
     */
    Bicycle getBicycleById(int id);

    /**
     * @param price Pretul dupa care cautam bicicletele cu un pret mai mic
     * @return Returneaza lista bicicletelor care au un pret mai mic
     */
    List<Bicycle> getBicyclesWithLowerPrice(int price);

    /**
     * @param listOfIds Lista cu id-urile bicicletelor pe care le dorim
     * @return Returneaza lista cu bicicletele gasite
     */
    List<Bicycle> getBicycleByIds(List<String> listOfIds);

    /**
     * @return Un Map care contine ca si cheie tipul bicicletei si ca valoare o lista de biciclete de tipul respectiv
     */
    Map<BicycleType,List<Bicycle>> getBicycleGroupByBicycleType();

    /**
     * @return Un Map care contine ca si cheie tipul rotilor bicicletei si ca valoare o lista de biciclete de tipul respectiv
     */
    Map<BicycleWheelsType,List<Bicycle>> getBicycleGroupByBicycleWheelsType();

    /**
     * @param bicycle Bicicleta de adaugat
     * @return true sau false daca bicicleta exista sau nu in lista de biciclete
     */
    boolean addBicycleIfNotExist(Bicycle bicycle);

    /**
     * @param id bicicletei care sa fie stearsa
     * @return true sau false daca s-a sters sau nu exista
     */
    boolean deleteBicycleById(int id);

    /**
     * @return Sterge toate bicicletele
     */
    boolean deleteAllBicycles();


    /**
     * @param bicycle
     * @return true daca s-a gasit si s-a facut update, false altfel
     */
    boolean updateBicycle(Bicycle bicycle);


}
