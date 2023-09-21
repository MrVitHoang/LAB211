/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manage;

/**
 *
 * @author VietHoang
 */

import CheckDate.CheckDate;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
public class WareHouse extends Products implements IWareHouse{
    
     public boolean checkProductCode(String inputCode) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        while (inputCode.isEmpty() || inputCode.trim().equals("")) {
            System.out.println("Code must not be empty");
            System.out.println("Input code: ");
            inputCode = scanner.nextLine();
        }
        String productsFilename = "products.dat";
        readDataFromFile(productsFilename);
        
        for (Products products : listProducts) {
            if (products.getCode().equals(inputCode)) {
                return true;
            }
        }
        return false;
    }

        
    @Override
    public void importReceipt() {
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;
        String inputCode;
        while (!validInput) {
            try {
                System.out.println("2.1.1 Check constraints product code");
                System.out.println("2.1.2 Import products to the import receipt");
                int chose = Integer.parseInt(scanner.nextLine());
                do {
                    switch (chose) {
                    case 1:
                        System.out.print("Input check code: ");
                        
                        inputCode = scanner.nextLine();
                        if (checkProductCode(inputCode)) {
                            System.out.println("Product exists");
                        } else {
                            System.out.println("Product doesn't exist yet");
                        }
                        break;
                    case 2:
                        System.out.print("Input check code: ");
                        inputCode = scanner.nextLine();
                        
                        if (checkProductCode(inputCode)) {
                            updateProductQuantity(inputCode);
                        } else {
                            System.out.println("Product doesn't exist");
                        }
                        break;
                    default:
                        break;
                    }
                    System.out.println("2.1.1 Check constraints product code");
                    System.out.println("2.1.2 Add new products to the import receipt");
                    chose = Integer.parseInt(scanner.nextLine());
                } while (chose == 1 || chose == 2);
                validInput = true;
                 // Input is valid, exit the loop
            } catch (InputMismatchException exception) {
                System.out.println("Input must be a number. Please try again.");
            } catch (FileNotFoundException ex) {
                System.out.println("File save not found");
            }
        }
        
    }

    @Override
    public void exportReceipt() {
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;
        String inputCode;
        while (!validInput) {
            try {
                System.out.println("2.2.1 Check constraints product code, quantity");
                System.out.println("2.2.2 Add new products to the export receipt");
                int chose = Integer.parseInt(scanner.nextLine());
                do {
                    switch (chose) {
                    case 1:
                        System.out.print("Input check code: ");
                        
                        inputCode = scanner.nextLine();
                        if (checkProductCode(inputCode)) {
                            System.out.println("Product exists");
                        } else {
                            System.out.println("Product doesn't exist yet");
                        }
                        break;
                    case 2:
                        System.out.print("Input check code: ");
                        inputCode = scanner.nextLine();
                        
                        if (checkProductCode(inputCode)) {
                            System.out.println("");
                        } else {
                            System.out.println("Product doesn't exists");
                        }
                        break;
                    default:
                        break;
                    }
                    System.out.println("2.1.1 Check constraints product code");
                    System.out.println("2.1.2 Add new products to the export receipt");
                    chose = Integer.parseInt(scanner.nextLine());
                } while (chose == 1 || chose == 2);
                validInput = true;
            } catch (InputMismatchException exception) {
                System.out.println("Input must be a number. Please try again.");
            } catch (FileNotFoundException ex) {
                System.out.println("File save not found");
            }
        }
    }

    public void updateProductQuantity(String codeUpdate) {
        Scanner scanner = new Scanner(System.in);
        for (Products products : listProducts) {
            if (products.getCode().equals(codeUpdate)) {
                System.out.println("Add amount: ");
                int quantityAdd = Integer.parseInt(scanner.nextLine());
                int updatedQuantity = quantityAdd + products.getQuantity();

                setQuantity(updatedQuantity);
                return;
            }
        }
    }
}
