package com.serenitydojo;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FruitTests {

    Fruit apple = new Fruit("Apple", "Red", "Ukraine");
    Fruit banana = new Fruit("Banana", "Yellow", "Ecuador");
    Fruit pear = new Fruit("Pear", "Green", "Spain");
    List<Fruit> listOfFruits = Arrays.asList(apple, banana, pear);

    @Test
    public void aCustomerShouldAddNewUniqueItem() {

        FruitsDB fruitsDB = new FruitsDB(listOfFruits);

        Fruit orange = new Fruit("Orange", "Orange", "Mexico");

        List<Fruit> fruits = fruitsDB.add_item(orange);

        assertThat(fruits).contains(orange);
        System.out.println(fruits);
    }

    @Test
    public void aCustomerShouldNotAddExistedItem() {

        FruitsDB fruitsDB = new FruitsDB(listOfFruits);
        Fruit pear = new Fruit("Pear", "Green", "Spain");

        List<Fruit> fruits = fruitsDB.add_item(pear);

        assertThat(fruits).doesNotContain(pear);
        System.out.println(fruits);
    }

    @Test
    public void aCustomerShouldAddNewItemWithTheSameNameAndAnotherCountry() {

        Fruit apple = new Fruit("Apple", "Red", "Ukraine");
        Fruit banana = new Fruit("Banana", "Yellow", "Ecuador");
        List<Fruit> listOfFruits = Arrays.asList(apple, banana);

        FruitsDB fruitsDB = new FruitsDB(listOfFruits);
        Fruit greenApple = new Fruit("Apple", "Green", "Ukraine");

        List<Fruit> fruits = fruitsDB.add_item(greenApple);

        assertThat(fruits).contains(greenApple);
        System.out.println(fruits);
    }

    @Test
    public void aCustomerShouldDeleteExistedItem() {

        Fruit apple = new Fruit("Apple", "Red", "Ukraine");
        Fruit banana = new Fruit("Banana", "Yellow", "Ecuador");
        List<Fruit> listOfFruits = Arrays.asList(apple, banana);

        FruitsDB fruitsDB = new FruitsDB(listOfFruits);

        List<Fruit> fruits = fruitsDB.del_item("Banana", "Yellow", "Ecuador");

        assertThat(fruits).doesNotContain(banana);
        System.out.println(fruits);

    }

    @Test
    public void aCustomerShouldNotDeleteNonExistedItem() {

        Fruit apple = new Fruit("Apple", "Red", "Ukraine");
        Fruit banana = new Fruit("Banana", "Yellow", "Ecuador");
        List<Fruit> listOfFruits = Arrays.asList(apple, banana);

        FruitsDB fruitsDB = new FruitsDB(listOfFruits);

        List<Fruit> fruits = fruitsDB.del_item("Banana", "Green", "Ecuador");

        assertThat(fruits).contains(banana);
        System.out.println(fruits);

    }

    @Test
    public void aCustomerShouldChangeExistedItem() {
        Fruit apple = new Fruit("Apple", "Red", "Ukraine");
        Fruit banana = new Fruit("Banana", "Yellow", "Ecuador");
        List<Fruit> listOfFruits = Arrays.asList(apple, banana);

        FruitsDB fruitsDB = new FruitsDB(listOfFruits);

        String name = "Banana";
        String color = "Yellow";
        String country = "Venezuela";

        List<Fruit> fruits = fruitsDB.change_item("Banana", "Yellow", "Ecuador", name, color, country);

        for (Fruit f: fruits
             ) {
            if(f.getName().equals(name)) {
                assertThat(f.getCountry().equals(country));
                System.out.println("New name is " + name + " " + "New country is " + country);
            }
        }
    }

    @Test
    public void aCustomerShouldNotChangeNonExistedItem() {
        Fruit apple = new Fruit("Apple", "Red", "Ukraine");
        Fruit banana = new Fruit("Banana", "Yellow", "Ecuador");
        List<Fruit> listOfFruits = Arrays.asList(apple, banana);

        FruitsDB fruitsDB = new FruitsDB(listOfFruits);

        String name = "Pear";
        String color = "Yellow";
        String country = "Venezuela";

        List<Fruit> fruits = fruitsDB.change_item("Pear", "Yellow", "Ecuador", name, color, country);

        for (Fruit f: fruits
             ) {
            assertThat(f.getName()).doesNotContain(name);
        }

        System.out.println(fruits);

    }
}
