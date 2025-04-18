package edu.guilford;

public abstract class critter extends creature{

    //attributes
    /** 
     * the amount of food needed by the critter
    */
    float foodNeeded;
    /**
     * the amount of food eaten by the critter
     */
    float foodEaten;

    //constructor that sets the values of size and rate and food needed 

    public critter(float size, float rate, float foodNeeded) {
        super(size, rate);
        this.foodNeeded = foodNeeded;
        foodEaten = 0;
    }

    public critter(float size, float rate) {
        super(size, rate);
    }
 
    public float getFoodNeeded() {
        return foodNeeded;
    }

    public void setFoodNeeded(float foodNeeded) {
        this.foodNeeded = foodNeeded;
    }

   /**override the method simulateDay, should call simulateDay method and and set a condition that 
    * the critter dies if the amount of food needed is less that the amount eaten in that day
    * @return void
    * @param none
    */
    @Override
    public void simulateDay() {
        super.simulateDay();
        //foodEaten += size * 0.1;
        //which essentially means that the critter dies if it eats less than 10% of its size in a day
        if (foodEaten < foodNeeded) {
            die();
        }
    }


    /**method that adds an amount to the value of foodEaten
     * @param amount the amount to be added to the value of foodEaten
     * @return void
     */
    public void eat(float amount) {
        foodEaten += amount;
    }

    /**method with no parameters that return the amount of food still needed 
     * @return the amount of food still needed
     */
    public float stillNeeded() {
        return foodNeeded - foodEaten;
    }
}