package com.serenitydojo;

import java.util.ArrayList;
import java.util.List;

public class FruitsDB {

    List<Fruit> listOfFruits;
    public FruitsDB(List<Fruit> listOfFruits) {
        this.listOfFruits = listOfFruits;
    }

    public List<Fruit> add_item(Fruit item) {

        List<Fruit> fruits = new ArrayList<>(listOfFruits);

        for (Fruit fruit : listOfFruits) {
            if(fruit.getName().equals(item.getName()) && fruit.getColor().equals(item.getColor())
                    && fruit.getCountry().equals(item.getCountry())) {
                System.out.println("Some item is already in the list");
                return fruits;
            }
        }
        System.out.println("The new item was added to the list");
        fruits.add(item);
        return fruits;
    }

    public List<Fruit> del_item(String name, String color, String country) {
        List<Fruit> fruits = new ArrayList<>(listOfFruits);

        for (Fruit fruit : listOfFruits) {
            if(fruit.getName().equals(name) && fruit.getColor().equals(color)
                    && fruit.getCountry().equals(country)) {
                System.out.println("The item has deleted successfully");
                fruits.remove(fruit);
                return fruits;
            }
        }
        System.out.println("The item is not in the list");
        return fruits;
    }


    public List<Fruit> change_item(String oldName, String oldColor, String oldCountry, String newName, String newColor, String newCountry) {
        List<Fruit> fruits = new ArrayList<>(listOfFruits);

        for (Fruit fruit : listOfFruits) {
            if(fruit.getName().equals(oldName) && fruit.getColor().equals(oldColor)
                    && fruit.getCountry().equals(oldCountry)) {
                fruit.setName(newName);
                fruit.setColor(newColor);
                fruit.setCountry(newCountry);
                System.out.println("The item has changed successfully");

                return fruits;
            }
        }
        System.out.println("The item is not in the list");
        return fruits;
    }
}
