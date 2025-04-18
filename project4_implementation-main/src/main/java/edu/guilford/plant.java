package edu.guilford;

public class plant extends creature {

    public plant(float size, float rate) {
        super(size, rate);
    }

    /**method that decrases the size of this object by a specific amount
     * @param amount the amount to decrease the size of the object by
     * @return void
     */
    public void chewedOn(float amount) {
        if (amount < size) {
            size -= amount;
        }
        // make it so it cant exceed the size of the object
        else {
            size = 0;
        } 
    } 

    /**to string method
     * @return a string representation of the object
     */ 
    @Override
    public String toString() {
        return "Plant{" + "size=" + size + ", rate=" + rate + ", alive=" + alive + ", age=" + age + '}';
    }
}
