package com.company;

import java.io.*;
import java.util.Random;

public class Encrypt {
    private String message;
    private String filename;
    protected static int KEY;
    Encrypt(String message, String filename){
        this.message = message;
        this.filename = filename;
        encrypt();
    }
    private void encrypt(){
        generateKey();
        char[] arrayOfChars = new char[message.length()];
        for(int i = 0; i < message.length(); ++i){
            int code = ((int) message.charAt(i)) + KEY;
            arrayOfChars[i] = (char) code;
        }
        serializeToFile(arrayOfChars);
    }
    private void serializeToFile(char[] arrayfOfChars){
        try {
            FileWriter fw = new FileWriter(filename);
            BufferedWriter bw = new BufferedWriter(fw);
            String tempEncrypted = String.valueOf(arrayfOfChars);
            bw.write(arrayfOfChars);
            bw.close();
            fw.close();
        }catch(FileNotFoundException e){
            System.out.println("File not found");
        }catch(IOException f){
            System.out.println("Can't write into file");
        }

    }

    private void generateKey(){
        KEY = (new Random().nextInt(30));
    }
}
