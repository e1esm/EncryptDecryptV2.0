package com.company;

import java.awt.*;
import java.io.*;
import java.util.Scanner;

public class Credentials {
    private String name;
    private int year;
    private int month;
    private int day;
    String filename;
    Credentials(String name, int year, int month, int day, String credentialsFile){
        this.name = name;
        this.year = year;
        this.month = month;
        this.day = day;
        this.filename = credentialsFile;
        writeIntoFile();
    }
    private String writeCredentials(){
        return " used the service: " + day + "." + month + "." + year + "\n";
    }

    private void writeIntoFile(){
        countNewLines();
        String sentenceDate = writeCredentials();
        String binaryName = encryptCredentials();
        try{
            FileWriter fw = new FileWriter(filename, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(binaryName);
            bw.write(sentenceDate);
            bw.close();
            fw.close();
        }catch(IOException e){
            System.out.println("Can't write credentials into the file");
        }

    }

    private String encryptCredentials(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < name.length(); ++i){
            int code = name.charAt(i);
            sb.append(Integer.toBinaryString(code));
            sb.append(" ");
        }
        return sb.toString();
    }

    //private String decryptCredentials(){

   // }

    protected void openCredentialsFile(){
        Desktop d = Desktop.getDesktop();
        File file = new File(filename);
        try {
            d.open(file);
        }catch (IOException e){
            System.out.println("Can't open the file with credentials");
        }
    }

    private void countNewLines(){
        int count = 0;
        try{
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            while(br.readLine() != null)
                ++count;
        }catch (IOException e){
            System.out.println("Can't open file with credentials to check for the amount of lines");
        }
        if(count >= 200){
            try{
                PrintWriter pw = new PrintWriter(filename);
                pw.println("");
                pw.close();
            }catch (IOException e){
                System.out.println("Can't delete contents of a file with credentials");
            }
        }
    }
}
