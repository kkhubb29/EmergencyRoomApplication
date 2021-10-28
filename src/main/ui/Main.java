package ui;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        try {
            new ERWaitingRoomApp();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to rune application: file not found");
        }
    }

}

