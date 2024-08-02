package com.example.java1final;

import java.io.*;
import java.util.ArrayList;

public class FileHandler {
    private BufferedReader charIn;
    private BufferedWriter charOut;

    //constructors
    //writer
    public FileHandler(String fileName, boolean append)
            throws IOException {
        this.charOut = new BufferedWriter(new FileWriter(fileName, append));
    }

    //reader
    public FileHandler(String fileName) throws IOException {
        this.charIn = new BufferedReader(new FileReader(fileName));
    }

    //destructors
    public void closeWriter() throws IOException {
        if (charOut != null) {
            charOut.close();
        }
    }

    public void closeReader() throws IOException {
        if (charIn != null) {
            charIn.close();
        }
    }

    //Writing
    public void writeData(Character charSave) throws IOException {

        //name is seperated from stats with newline
        charOut.write(charSave.getName() + " ");
        charOut.newLine();
        for (int count = 0; count < Character.STATSIZE; count++) { //add stats
            charOut.write(String.valueOf(charSave.getStat(count) + " "));
        }
        charOut.newLine();
    }

    //reading
        //reads the data in the character file, creating Character objects and storing them in an array that
        //is then returned
    public static ArrayList<Character> readCharacter(String fileName){
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
    public static void characterWriter(String charFile, ArrayList<Character> characters){
        try {
            BufferedWriter charOut = new BufferedWriter(new FileWriter(charFile));
            for (int count = 0; count < characters.size(); count++) {
                charOut.write(characters.get(count).getName());
                for (int stat = 0; stat < Character.STATSIZE; stat++) {
                    charOut.write(String.valueOf(characters.get(count).getStat(stat)));
                }
            }
            charOut.close();
        }catch(IOException fileNotFoundError){
            System.out.println("File not found");
        }
    }
}