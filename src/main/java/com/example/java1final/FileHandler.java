package com.example.java1final;

import java.io.*;
import java.util.ArrayList;

public class FileHandler {
    private BufferedReader charIn;
    private BufferedWriter charOut;

    //constructors
    //writer
    public FileHandler(String fileName, boolean append) {
        try {
            this.charOut = new BufferedWriter(new FileWriter(fileName, append));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //reader
    public FileHandler(String fileName){
        try {
            this.charIn = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    //destructors
    public void closeWriter(){
        if (charOut != null) {
            try {
                charOut.close();
            } catch (IOException fileNotFound) {
                throw new RuntimeException(fileNotFound.getMessage());
            }
        }
    }

    public void closeReader(){
        if (charIn != null) {
            try {
                charIn.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    //reading
        //reads the data in the character file, creating Character objects and storing them in an array that
        //is then returned
    public static ArrayList<Character> readCharacter(File fileName){
        ArrayList<Character> characters = new ArrayList<>();
        try{
            BufferedReader charIn = new BufferedReader(new FileReader(fileName));
            int count = 0;
            String line;
            while ((line = charIn.readLine()) != null) { //stores next lines data in line/ check for null
                Character tempChar = new Character(line); //store name
                for (int stat = 0; stat < Character.STATSIZE; stat++) { //store stats
                    tempChar.setStat(stat, Integer.parseInt(charIn.readLine()));
                }
                characters.add(tempChar); //add Character to our array
            }
        }catch(IOException fileNotFoundException){
            System.out.println("File not found");
        }
        return characters;
    }
        //writing
    public static int characterWriter(File charFile, ArrayList<Character> characters){
        try {
            BufferedWriter charOut = new BufferedWriter(new FileWriter(charFile));
            for (int count = 0; count < characters.size(); count++) {
                charOut.write(characters.get(count).getName());
                charOut.newLine();
                for (int stat = 0; stat < Character.STATSIZE; stat++) {
                    charOut.write(String.valueOf(characters.get(count).getStat(stat)));
                    charOut.newLine();
                }
            }
            charOut.close();
            return 0;
        }catch(IOException fileNotFoundError){
            return 1;
        }
    }
}