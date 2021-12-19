package com.company;


import java.awt.*;
import java.io.*;

public class Decrypt {
    private String decrypted;
    private String filename;

    Decrypt(String filename){
        this.filename = filename;
    }
    protected void getFromFile(){
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            String tempFromFile = br.readLine();
            char[] arrayOfCharsRecieved = tempFromFile.toCharArray();
            for(int i = 0; i < arrayOfCharsRecieved.length; ++i){
                int code = arrayOfCharsRecieved[i] - Encrypt.KEY;
                arrayOfCharsRecieved[i] = (char) code;
            }
            decrypted = String.valueOf(arrayOfCharsRecieved);
        }
        catch(IOException e){
            System.out.println("Cant get content out from the file " + filename);
            }
    }
    protected String getEncrypted(){
        String decrypted = "";
        try{
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            decrypted = br.readLine();
        }catch(IOException e){
            System.out.println("Can't get encrypted content from the file"  + filename);
        }
        return decrypted;
    }
    protected String getDecypted(){
        getFromFile();
        return decrypted;
    }
    protected void openEncryptionFile(){
        Desktop desktop = Desktop.getDesktop();
        File file = new File(filename);
        try {
            desktop.open(file);
        }catch (IOException e){
            System.out.println("Can't open \"Encryption.txt\" file");
        }
    }
}
