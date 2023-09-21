/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import Manage.Products;
import Manage.WareHouse;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author VietHoang
 */
public class Menu {

    public void Menu() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        
        Products products = new Products();
        String productsFilename = "products.dat";
        products.readDataFromFile(productsFilename);
        
        WareHouse wareHouse = new WareHouse();
        
        System.out.println("MENU");
        System.out.println("1. Manage products");
        System.out.println("2. Manage Warehouse");
        System.out.println("3. Report");
        System.out.println("4. Store data to files");
        System.out.println("5. Exit");
        int chose = Integer.parseInt(scanner.nextLine());
        System.out.println("");

        do {
            if (chose == 5) {
                System.out.println("Closing...");
                return;
            }
            switch (chose) {
                case 1:
                    System.out.println("1.1 Add a product.");
                    System.out.println("1.2 Update product information.");
                    System.out.println("1.3 Delete product.");
                    System.out.println("1.4 Show all product.");
                    int choseCase1 = Integer.parseInt(scanner.nextLine());
                    System.out.println("");

                    switch (choseCase1) {
                        case 1:
                            products.addProduct();
                            products.writeDataToFile(productsFilename);
                            break;
                        case 2:
                            products.updateProduct();
                            products.writeDataToFile(productsFilename);
                            break;
                        case 3:
                            products.deleteProduct();
                            products.writeDataToFile(productsFilename);
                            break;
                        case 4:
                            System.out.println("Products list: ");
                            products.showAllProduct();
                            System.out.println("");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("2.1 Create an import receipt.");
                    System.out.println("2.2 Create an export receipt.");
                    int choseCase2 = Integer.parseInt(scanner.nextLine());
                    System.out.println("");
                    switch (choseCase2) {
                        case 1: 
                            wareHouse.importReceipt();
                            break;
                        case 2:

                            break;
                        default: 
                            System.out.println("Wrong input");
                            break;
                    }
                    break;
                case 3:
                    System.out.println("3.1 Products that have expired.");
                    System.out.println("3.2 The products that the store is selling.");
                    System.out.println("3.3 Products that are running out of stock.");
                    System.out.println("3.4 Import/export receipt of a product.");
                    int choseCase3 = Integer.parseInt(scanner.nextLine());
                    System.out.println("");
                    switch (choseCase3) {

                    }
                    break;
                case 4:
                    products.writeDataToFile(productsFilename);
                    break;
                case 5:
                    System.out.println("Closing...");
                    break;
                default:
                    System.out.println("Invalid chose.");
            }
            System.out.println("1. Manage products");
            System.out.println("2. Manage Warehouse");
            System.out.println("3. Report");
            System.out.println("4. Store data to files");
            System.out.println("5. Exit");
            chose = Integer.parseInt(scanner.nextLine());
            System.out.println("");
        } while (chose != 5);
    }
}
