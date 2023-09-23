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
import Report.Report;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class Products implements IProduct{
    public static ArrayList<Products> listProducts = new ArrayList<>();
    private String code;
    private String name;
    private String manufacturingDate;
    private String expirationDate;
    private int quantity;

    public Products() {
    }

    public Products(String code, String name, String manufacturingDate, String expirationDate, int quantity) {
        this.code = code;
        this.name = name;
        this.manufacturingDate = manufacturingDate;
        this.expirationDate = expirationDate;
        this.quantity = quantity;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(String manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
    
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public void updateProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input id: ");
        String codeUpdate = scanner.nextLine();
        for (Products products : listProducts) {
            if (products.getCode().equals(codeUpdate)) {
                System.out.print("Input name: ");
                String nameUpdate = scanner.nextLine();
                System.out.print("Input manufacturing date: ");
                String manuDateUpdate = scanner.nextLine();
                while (!CheckDate.checkExpirationDate(manuDateUpdate)) {
                    System.out.println("Invalid input. Please input again.");
                    System.out.println("Input expiration date: ");
                    manuDateUpdate = scanner.nextLine();
                }

                System.out.print("Input expiration date: ");
                String expDateUpdate = scanner.nextLine();
                while (!CheckDate.checkExpirationDate(expDateUpdate)) {
                    System.out.println("Invalid input. Please input again.");
                    System.out.println("Input expiration date: ");
                    expDateUpdate = scanner.nextLine();
                }
                while (CheckDate.checkValidDay(manuDateUpdate,expDateUpdate)) {
                    System.out.println("Invalid input (expiration date can't happen before manufacturing date");
                    System.out.print("Input manufacturing date: ");
                    manuDateUpdate = scanner.nextLine();
                    while (!CheckDate.checkExpirationDate(manuDateUpdate)) {
                        System.out.println("Invalid input. Please input again.");
                        System.out.println("Input expiration date: ");
                        manuDateUpdate = scanner.nextLine();
                    }

                    System.out.print("Input expiration date: ");
                    expDateUpdate = scanner.nextLine();
                    while (!CheckDate.checkExpirationDate(expDateUpdate)) {
                        System.out.println("Invalid input. Please input again.");
                        System.out.println("Input expiration date: ");
                        expDateUpdate = scanner.nextLine();
                    }
                }
                System.out.println("Input quantity: ");
                int quantityUpdate = Integer.parseInt(scanner.nextLine());
                products.setName(nameUpdate);
                products.setManufacturingDate(manuDateUpdate);
                products.setExpirationDate(expDateUpdate);
                products.setQuantity(quantityUpdate);
                return;
            }
        }
        System.out.println("No product found");
    }

    @Override
    public void deleteProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input code: ");
        String deleteCode = scanner.nextLine();
        
        for (Products products : listProducts) {
            if (products.getCode().equals(deleteCode)) {
                listProducts.remove(products);
                System.out.println("Products deleted successful");
                return;
            }
        }
        System.out.println("No product found");
    }

    @Override
    public void showAllProduct() {
        if (listProducts.isEmpty()) {
            System.out.println("The products list is empty");
            return;
        }
        System.out.println("┌───────────────────────────────────────────────────────┐");
        System.out.format("│ %-10s │ %-15s │ %-20s │ %-20s │ %-10s │", "CODE", "NAME", "MANUFACTURING DATE", "EXPIRATION DATE", "QUANTITY");
        System.out.println();
        System.out.println("├───────────────────────────────────────────────────────┤");
        for (Products products : listProducts) {
            System.out.println(products);
        }
        System.out.println("└───────────────────────────────────────────────────────┘");
    }
    
    @Override
    public void addProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input code: ");
        String inputCode = scanner.nextLine();
        while (inputCode.isEmpty() || inputCode.trim().equals("")) {
            System.out.println("Code must not be empty");
            System.out.println("Input code: ");
            inputCode = scanner.nextLine();
        }
        for (Products products : listProducts) {
            if (products.getCode().equals(inputCode)) {
                System.out.println("This products already exist.");
                System.out.println("");
                return;
            }
        }
        
        System.out.println("Input name: ");
        String inputName = scanner.nextLine();
        while (inputName.isEmpty() || inputName.trim().equals("")) {
            System.out.println("Name must not be empty");
            System.out.println("Input name: ");
            inputName = scanner.nextLine();
        }
        
        System.out.println("Input manufacturing date: ");
        String manuDate = scanner.nextLine();
        while (!CheckDate.checkManufacturingDate(manuDate)) {
            System.out.println("Invalid input. Please input again.");
            System.out.println("Input manufacturing date: ");
            
            manuDate = scanner.nextLine();
        }
        
        System.out.println("Input expiration date: ");
        String expDate = scanner.nextLine();
        while (!CheckDate.checkExpirationDate(expDate)) {
            System.out.println("Invalid input. Please input again.");
            System.out.println("Input expiration date: ");
            expDate = scanner.nextLine();
        }

        while (CheckDate.checkValidDay(manuDate,expDate)) {
            System.out.println("Invalid input (expiration date can't happen before manufacturing date");
            System.out.print("Input manufacturing date: ");
            manuDate = scanner.nextLine();
            while (!CheckDate.checkManufacturingDate(manuDate)) {
                System.out.println("Invalid input. Please input again.");
                System.out.println("Input manufacturing date: ");

                manuDate = scanner.nextLine();
            }

            System.out.print("Input expiration date: ");
            expDate = scanner.nextLine();
            while (!CheckDate.checkExpirationDate(expDate)) {
                System.out.println("Invalid input. Please input again.");
                System.out.println("Input expiration date: ");
                expDate = scanner.nextLine();
            }
        }

        System.out.println("Input quantity: ");
        int inputQuantity = Integer.parseInt(scanner.nextLine());
        while (inputQuantity <= 0) {
            System.out.println("Invalid quantity.");
            System.out.println("Input quantity: ");
            inputQuantity = Integer.parseInt(scanner.nextLine());
        }
        Products products = new Products(inputCode, inputName, manuDate, expDate, inputQuantity);
        listProducts.add(products);
    }
    
    @Override
    public String toString() {
        return String.format("│ %-10s │ %-15s │ %-20s │ %-20s │ %-10s │", code, name, manufacturingDate, expirationDate, quantity);
    }
    
    public void readDataFromFile(String filename) throws FileNotFoundException {
        try {
            File f = new File(filename);
            if (!f.exists()) {
                return;
            }

            FileReader fr = new FileReader(f);
            BufferedReader bfr = new BufferedReader(fr);
            String line;
            while ((line = bfr.readLine()) != null) {
                String[] data = line.split(", ");

                String _code = data[0].trim();
                String _name = data[1].trim();
                String _manufacturingDate = data[2].trim();
                String _expirationDate = data[3].trim();
                int _quantity = Integer.parseInt(data[4].trim());

                Products _products = new Products(_code, _name, _manufacturingDate, _expirationDate, _quantity);

                listProducts.add(_products);
            }
            bfr.close();
            fr.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

        public void writeDataToFile(String filename) {
        try {

            File f = new File(filename);

            FileWriter fw = new FileWriter(f);

            PrintWriter pw = new PrintWriter(fw);
            for (Products products : listProducts) {
                pw.println(products.getCode() + ", " + products.getName()
                            + ", " + products.getManufacturingDate()
                            + ", " + products.getExpirationDate()
                            + ", " + products.getQuantity());
            }
            pw.close();
            fw.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void expDayPrint() {
        Report report = new Report();
        for (Products products : listProducts) {
            if (!report.expiredProductsCheck(products.getExpirationDate())) {
                System.out.println(products);
            }
        }
        System.out.println();
    }

    public void sellingProductsPrint() {
        Report report = new Report();
        for (Products products : listProducts) {
            if (report.expiredProductsCheck(products.getExpirationDate()) && products.getQuantity() > 0) {
                System.out.println(products);
            }
        }
        System.out.println();
    }

    public void outOfStockPrint() {
        Report report = new Report();
        for (Products products : listProducts) {
            if (report.outOfStock(products.getQuantity())) {
                System.out.println(products);
            }
        }
        System.out.println();
    }
}