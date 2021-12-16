package com.company;

import java.util.Scanner;

public class MainActivities {
    private final String filename = "Encryption.txt";
    Encrypt encrypt;
    Decrypt decrypt;
    MainActivities(){
        run();
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("Which action would you like to continue with? ");
            outputActions();
            int nOfAction = sc.nextInt();
            sc.nextLine();
            switch (nOfAction) {
                case 1: {
                    System.out.println("Enter sentence to encrypt it");
                    String initialMessage = sc.nextLine();
                    encrypt = new Encrypt(initialMessage, filename);
                    break;
                }
                case 2: {
                    decrypt = new Decrypt(filename);
                    System.out.println("Your decrypted sentence: " + decrypt.getDecypted());
                    break;
                }
                case 3: {
                    decrypt = new Decrypt(filename);
                    System.out.println("Your encrypted message: " + decrypt.getEncrypted());
                    break;
                }

                case 4:
                    isRunning = false;
                    break;
            }
        }
    }
    public void outputActions(){
        System.out.println("1.Encrypt your message");
        System.out.println("2.Decrypt your message");
        System.out.println("3.Show encrypted version of the message");
        System.out.println("4.Exit");
    }
}
