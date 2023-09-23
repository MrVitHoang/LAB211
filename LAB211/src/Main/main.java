package Main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Menu.Menu;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;


/**
 *
 * @author VietHoang
 */

public class main{

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        Menu menu = new Menu();
        boolean validInput = false;
        while (!validInput) {
            try {
                menu.Menu();
                validInput = true; // Input is valid, exit the loop
            } catch (InputMismatchException exception) {
                System.out.println("Input must be a number. Please try again.");
            }
        }
    }
}
