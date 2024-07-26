package com.example.java1final;

public class Character {
    final static int STATSIZE = 6;
    public String name;
    private int [] stats;
    //statName array is parallel to the players actual stats which is an int, this array is for displaying what each stat represents
    //and to keep better track of them
    final static String [] statName = {
            "STRENGTH",
            "DEXTERITY",
            "CONSTITUTION",
            "INTELLIGENCE",
            "WISDOM",
            "CHARISMA"
    };

        //constructor
    public Character(String name){
        this.name = name;
        this.stats = new int[STATSIZE];
    };
        //setters
    public void setStat(int stat, int statSize){
        this.stats[stat] = statSize;
    };
}
