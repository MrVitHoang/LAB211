package Manage;

import CheckDate.CheckDate;
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
                System.out.print("Input expiration date: ");
                String expDateUpdate = scanner.nextLine();
                System.out.print("Input manufacturing date: ");
                String manuDateUpdate = scanner.nextLine();
                System.out.println("Input quantity: ");
                int quantityUpdate = Integer.parseInt(scanner.nextLine());
                products.setName(nameUpdate);
                products.setExpirationDate(expDateUpdate);
                products.setManufacturingDate(manuDateUpdate);
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
        for (Products products : listProducts) {
            System.out.println(products);
        }
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
        return String.format("Code: %s  Name: %s  Manufacturing date: %s expiration date: %s quantity: %s", code, name, manufacturingDate, expirationDate, quantity);
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

                String _code = data[0];
                String _name = data[1];
                String _manufacturingDate = data[2];
                String _expirationDate = data[3];
                int _quantity = Integer.parseInt(data[4]);

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
}

