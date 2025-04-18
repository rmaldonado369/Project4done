package edu.guilford;

import java.util.LinkedList;

public class plantEater extends critter {

    //constructor that sets the values of size and rate and food needed and the list of plant objects
    public plantEater(float size, float rate, float foodNeeded) {
        super(size, rate, foodNeeded);
    }
 
    // linked list of plant objects
    private LinkedList<plant> plants = new LinkedList<plant>();
 

    /**  method that adds a plant object to the linked list
     * @param p the plant object to be added to the list
     * @return void
     */
    public void addPlant(plant p) {
        plants.add(p);
    }

     

    /**method that eats a plant object, the amount it chews is random but cant
   
    * @return void
    * @param none 
    */
   
    public void chew() {
        int random = (int) (Math.random() * plants.size());
        float amount = (float) (Math.random() * (plants.get(random).getSize() * 0.5));
        if ((amount > stillNeeded()) || (amount > size * 0.1)) {
            amount = 0;
            
        }
        plants.get(random).chewedOn(amount);
        eat(amount);
         foodEaten += amount;
    }
    /**override the simulateDay method
    
    * @return void
    * @param none
    */
    @Override
    public void simulateDay() {
        int random = (int) (Math.random() * (plants.size() * 0.015) + (plants.size() * 0.005));
        for (int i = 0; i < random; i++) {
            chew();
        }
        super.simulateDay();
    }

    /**to string method
     * @return a string representation of the object
     */
    @Override
    public String toString() {
        return "plantEater{" + "foodNeeded=" + foodNeeded + ", foodEaten=" + foodEaten +  ", size=" + size + ", rate=" + rate + ", alive=" + alive + ", age=" + age + '}';
    }



}
