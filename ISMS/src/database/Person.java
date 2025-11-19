/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

/**
 *
 * @author Ijerson
 */
public class Person {
    private int person_id;
    private String name;
    private String sex;
    
    // Constructor
    public Person() {}
    public Person(int id, String s, String n) {
        person_id = id;
        sex = s;
        name = n;
    }
    
    // Getters
    public String Sex() {
        return this.sex;
    }
    
    public String Name() {
        return this.name;
    }
    
    public int PersonID() {
        return this.person_id;
    }
    
    // Setters
    public void Sex(String s) {
        this.sex = s;
    }
    
    public void Name(String n) {
        this.name = n;
    }
    
    public void PersonID(int id) {
        this.person_id = id;
    }
}
