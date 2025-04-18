package edu.guilford;

import java.util.ArrayList;


public class project4Driver {
    public static void main(String[] args) {

        // instantiate a list of 2000 plant objects each with a size of 300+-50 and a
        // rate of 5 a day
        ArrayList<plant> plants = new ArrayList<plant>();
        for (int i = 0; i < 2000; i++) {
            plants.add(new plant((float) (Math.random() * 100 + 250), 5));
        }

        // instantiate one plant eater object the size of 1000+-100 and a rate of 3 a
        // day and a food needed of 50
        plantEater pe = new plantEater((float) (Math.random() * 200 + 800), 3, 10);

        // add the list of plants to the plant eater object
        for (plant p : plants) {
            ((plantEater) pe).addPlant(p);
        }

        // print the plant eater object
        System.out.println(pe);

        // simulate 100 days of the plant eater object and the list of plants
        for (int i = 0; i < 10; i++) {
            // simulate a day for the plant eater object
            pe.simulateDay();
            // simulate a day for each plant object
            for (plant p : plants) {
                p.simulateDay();
            }
            //print the day
            System.out.println("\n Day: " + (i + 1));
            // print the plant eater object
            System.out.println(pe);
            // print the list of plants that were eaten
            for (int j = 0; j < 5; j++) {
                System.out.println(plants.get(j));
            }
        }

        // print the total mass of the list of plants
        System.out.println("\n total mass of plants: ");
        System.out.println(totalMass(plants));
        // print if the plant eater object is still alive
        System.out.println("is the plant eater still alive?");
        System.out.println(aliveStill(pe));
        // print how many plants were eaten
        System.out.println("number of plants eaten: " + pe.foodEaten);
        System.out.println("number of plants still alive: " + plants.size());
        System.out.println("\n");


        ArrayList<plantEater> plantEaters = new ArrayList<plantEater>();
        for (int i = 0; i < 300; i++) {
            plantEaters.add(new plantEater((float) (Math.random() * 200 + 800), 30,
            //make the foodNeeded be 1% of the size of the plantEater
                    (float) (Math.random() * 0.01 * (Math.random() * 200 + 800))));
        }
        for (int i = 0; i < 1000; i++) {
            for (plantEater pe1 : plantEaters) {
                pe1.simulateDay();
            }
            for (plant p : plants) {
                p.simulateDay();
            }
            if (Math.random() < 0.05) {
                plants.add(new plant((float) (Math.random() * 100 + 250), 5));
            }
            if (Math.random() < 0.5) {
                plantEaters.add(new plantEater((float) (Math.random() * 200 + 800), 3,
                //make the foodNeeded be 1% of the size of the plantEater
                (float) (Math.random() * 0.01 * (Math.random() * 200 + 800)))); 
            }

            for (int j = 0; j < plantEaters.size(); j++) {
                if (!plantEaters.get(j).isAlive()) {
                    plantEaters.remove(j);
                }
            }
            // Print out the total number and mass of the PlantEater and Plant objects.
    System.out.println("\n Day: " + (i+1));
    System.out.println("total mass of plants: ");
    System.out.println(totalMass(plants));
    System.out.println("total mass of plant eaters: ");
    System.out.println(totalMass(plantEaters));

            if (plantEaters.size() == 0) {
                break;
            } 

        }
    }

    public static boolean stillAlive(ArrayList<? extends creature> creatures) {
        // return true if any of the creatures objects in the list are still alive and
        // false otherwise
        if (creatures.size() > 0) {
            for (creature c : creatures) {
                if (c.isAlive()) {
                    return true;
                }
                // if the creature is not alive, return false
                else {
                    return false;
                }
            }
        }
        return creatures.size() > 0;
    }

public static boolean aliveStill(creature c) {
        // return true if the creature object is still alive and false otherwise
        return c.isAlive();
    }

    public static double totalMass(ArrayList<? extends creature> creatures) {
        // a list of creature objects and returns the total mass of all the creatures
        // in the list
        double totalMass = 0;
        for (creature c : creatures) {
            totalMass += c.getSize();
        }
        return totalMass;
    }

}


