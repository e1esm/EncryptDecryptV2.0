package com.company;

import java.io.*;

public class Decrypt {
    private String decrypted;
    private String filename;

    Decrypt(String filename){
        this.filename = filename;
    }
    public void getFromFile(){
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
    public String getEncrypted(){
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
    public String getDecypted(){
        getFromFile();
        return decrypted;
    }
}
