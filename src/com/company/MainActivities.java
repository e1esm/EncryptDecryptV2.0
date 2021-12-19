package com.company;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class MainActivities {
    private final String filename = "Encryption.txt";
    private final String credentialsFile = "Credentials.txt";
    Encrypt encrypt;
    Decrypt decrypt;
    Credentials credentials;
    MainActivities(){
        run();
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        boolean isRunning = true;

        credentials = addCredentials();

        while (isRunning) {
            System.out.println("Which action would you like to continue with? ");
            outputActions();
            int nOfAction = sc.nextInt();
            sc.nextLine();
            decrypt = new Decrypt(filename);
            switch (nOfAction) {
                case 1: {
                    System.out.println("Enter sentence to encrypt it");
                    String initialMessage = sc.nextLine();
                    encrypt = new Encrypt(initialMessage, filename);
                    break;
                }
                case 2: {
                    System.out.println("Your decrypted sentence: " + decrypt.getDecypted());
                    break;
                }
                case 3: {
                    System.out.println("Your encrypted message: " + decrypt.getEncrypted());
                    break;
                }
                case 4: {
                    credentials.openCredentialsFile();
                    break;
                }
                case 5: {
                    decrypt.openEncryptionFile();
                    break;
                }
                case 6:
                    isRunning = false;
                    break;
            }
        }
    }
    public void outputActions(){
        System.out.println("1.Encrypt your message");
        System.out.println("2.Decrypt your message");
        System.out.println("3.Show encrypted version of the message");
        System.out.println("4.Open \"Credentials.txt\" file");
        System.out.println("5.Open \"Encryption.txt\" file");
        System.out.println("6.Exit");
    }

    public Credentials addCredentials(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your first and second name: ");
        String name = sc.nextLine();
        Date date = new Date();
        int year = date.getYear() + 1900;
        int month = date.getMonth();
        int day = date.getDate();
        Credentials cred = new Credentials(name, year, month, day, credentialsFile);

        return cred;
    }
}
