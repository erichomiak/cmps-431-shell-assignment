/*
*Eric Homiak
* CMPS 431
* Shell Part One
* ErHO
* */
package CMPS431;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;

public class Main {
    private static boolean running = true;

    private static void echo(String c) throws IOException {
        String echoable, filename, fileContents;
        echoable = c;
        boolean checker = echoable.contains(" -> ");
        if (checker) {
            filename = c.substring(c.indexOf(">") + 2, c.length());
            fileContents = c.substring(1, c.indexOf(">") - 2);
            BufferedWriter bw = new BufferedWriter(new FileWriter(filename+".txt"));
            bw.write(fileContents);
            bw.close();

            System.out.println("Writing " + fileContents + " to " + filename + ".txt");
        }
        else {
            System.out.println(c);
        }
    }

     private static void cat(String c) throws IOException {
       BufferedReader br = new BufferedReader(new FileReader(c));
       String contents;
       while ((contents = br.readLine()) != null){
          System.out.println(contents);
       }
     }

    private static void exit() {
        System.out.print("Exiting ErHo shell..");
        running = false;
    }

    private static void clear() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    private static void help() {
        System.out.println("---- ErHo Help ----");
        System.out.println("AVAILABLE COMMANDS");
        System.out.println("echo [text to print] - prints [text]");
        System.out.println("echo [text to print] -> [filename] - prints [text] to [filename].txt \n(must enter contents to be written to file)");
        System.out.println("cat [filename].txt - reads the contents of [file] \n(must include .txt to end of desired filename)");
        System.out.println("exit - exits the shell");
        System.out.println("clear - \"clears\" the command line ;)");
        System.out.println("help - shows available commands");
    }

    public static void main(String[] args) throws IOException {
        String picked, read;
        boolean exist;

        while (running) {
            System.out.print("$ErHo > ");
            Scanner s = new Scanner(System.in);
            String pick = s.next();

            switch (pick) {
                case "echo":
                    picked = s.nextLine();
                    if (picked.length() <= 0) {
                        System.out.println ("No entry has been made");
                    }
                    else {
                        echo(picked);
                    }
                    break;
                case "cat":
                    picked = s.nextLine();
                    read = picked.substring(1, picked.length());
                    File reading = new File (read);
                    exist = reading.exists();
                    if (exist) {
                        cat(read);
                    }
                    else {
                        System.out.println ("No such file exists");
                    }
                    break;
                case "exit":
                    exit();
                    break;
                case "clear":
                    clear();
                    break;
                case "help":
                    help();
                    break;
                default:
                    System.out.println("Invalid entry");
            }
        }
    }
}
