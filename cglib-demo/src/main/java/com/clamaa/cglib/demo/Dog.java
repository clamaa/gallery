package com.clamaa.cglib.demo;

/**
 * User: mazhqa
 * Date: 14-3-6
 */
public class Dog implements IAnimal {
    @Override
    public void active(String message) {
        System.out.println("The dog is active!" + message);
    }
}
