package edu.guilford;

public abstract class creature {

    //attributes 
    /**
     * size of the creature
     */
    float size;
    /**
     * rate of the creature
     */
    float rate;
    /**
     * boolean to check if the creature is alive
     */
    boolean alive;
    /**
     * age of the creature
     */
    int age;


    //constructor that sets the values of size and rate
    public creature(float size, float rate) {
        this.size = size;
        this.rate = rate;
        alive = true;
        age = 0;
    }
    public float getSize() {
        return size;
    }
    public void setSize(float size) {
        this.size = size;
    }
    public float getRate() {
        return rate;
    }
    public void setRate(float rate) {
        this.rate = rate;
    }
    public boolean isAlive() {
        return alive;
    }
    public void setAlive(boolean alive) {
        this.alive = alive;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    
    /**
     * method to change the size of the creature
     * if the size is less than 0, call die method
     * @ return void
     * @ param none
     */
    public void changeSize() {
        size += rate;
        //if the size is less than 0, call die method
        if (size < 0) {
            die();
        }
    }

    /**method to simulate what happens over 1 day in the life of an object based of its current values of the attributes
     * @return void
     * @param none
    */
    public void simulateDay() {
        age++;
        changeSize();
        // =if (size <= 0) {
        //     alive = false;
        // }
    }


    /**method to set size and rate to zero and alive to false
     * @return void
     * @param none
     * 
     */

    public void die() {
        size = 0;
        rate = 0;
        alive = false;
    }



    /**to string method
     * @return string
     * @param none
     */
    @Override
    public String toString() {
        return "creature{" + "size=" + size + ", rate=" + rate + ", alive=" + alive + ", age=" + age + '}';
    }
}
