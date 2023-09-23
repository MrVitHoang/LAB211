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
        boolean validChoice = true;
        do {
            try {
                Products products = new Products();
                String productsFilename = "products.dat";
                products.readDataFromFile(productsFilename);

                WareHouse wareHouse = new WareHouse();
                String warehouseImport = "warehouseImport.dat";
                System.out.println("┌─────────────────────┐");
                System.out.println("│               MENU                │");
                System.out.println("│       1. Manage products          │");
                System.out.println("│       2. Manage Warehouse         │");
                System.out.println("│       3. Report                   │");
                System.out.println("│       4. Store data to files      │");
                System.out.println("│       5. Exit                     │");
                System.out.println("└─────────────────────┘");
                System.out.print("Enter your choice (1 - 5): ");
                int chose = Integer.parseInt(scanner.nextLine());
                System.out.println();

                do {
                    if (chose == 5) {
                        System.out.println("Closing...");
                        return;
                    }
                    switch (chose) {
                        case 1:
                            System.out.println("┌────────────────────────┐");
                            System.out.println("│                  MENU                  │");
                            System.out.println("│       1.1 Add a product                │");
                            System.out.println("│       1.2 Update product information   │");
                            System.out.println("│       1.3 Delete product               │");
                            System.out.println("│       1.4 Show all product             │");
                            System.out.println("│       1.5 Back to main menu            │");
                            System.out.println("└────────────────────────┘");
                            System.out.print("Enter your choice (1 - 5): ");
                            int choseCase1 = Integer.parseInt(scanner.nextLine());

                            while (choseCase1 != 5) {
                                switch (choseCase1) {
                                    case 1:
                                        products.addProduct();
                                        break;
                                    case 2:
                                        products.updateProduct();
                                        break;
                                    case 3:
                                        products.deleteProduct();
                                        break;
                                    case 4:
                                        System.out.println();
                                        products.showAllProduct();
                                        System.out.println();
                                        break;
                                    case 5:
                                        break;
                                    default:
                                        System.out.println("Invalid choice");
                                        break;
                                }
                                System.out.println("┌────────────────────────┐");
                                System.out.println("│                  MENU                  │");
                                System.out.println("│       1.1 Add a product                │");
                                System.out.println("│       1.2 Update product information   │");
                                System.out.println("│       1.3 Delete product               │");
                                System.out.println("│       1.4 Show all product             │");
                                System.out.println("│       1.5 Back to main menu            │");
                                System.out.println("└────────────────────────┘");
                                System.out.print("Enter your choice (1 - 5): ");
                                choseCase1 = Integer.parseInt(scanner.nextLine());
                            }
                            break;
                        case 2:
                            System.out.println("┌────────────────────────┐");
                            System.out.println("│                  MENU                  │");
                            System.out.println("│       2.1 Create an import receipt     │ ");
                            System.out.println("│       2.2 Create an export receipt     │ ");
                            System.out.println("│       2.3 Back to main menu            │ ");
                            System.out.println("└────────────────────────┘");
                            System.out.print("Enter your choice (1 - 3): ");
                            int choseCase2 = Integer.parseInt(scanner.nextLine());
                            System.out.println();
                            while (choseCase2 != 3) {
                                switch (choseCase2) {
                                    case 1:
                                        wareHouse.importReceipt();
                                        break;
                                    case 2:
                                        wareHouse.exportReceipt();
                                        break;
                                    case 3:
                                        break;
                                    default:
                                        System.out.println("Invalid input");
                                        break;
                                }
                                System.out.println("┌────────────────────────┐");
                                System.out.println("│                  MENU                  │");
                                System.out.println("│       2.1 Create an import receipt     │ ");
                                System.out.println("│       2.2 Create an export receipt     │ ");
                                System.out.println("│       2.3 Back to main menu            │ ");
                                System.out.println("└────────────────────────┘");
                                System.out.print("Enter your choice (1 - 3): ");
                                choseCase2 = Integer.parseInt(scanner.nextLine());

                            }
                            break;
                        case 3:
                            System.out.println("┌─────────────────────────────────┐");
                            System.out.println("│                         MENU                          │");
                            System.out.println("│         3.1 Products that have expired                │");
                            System.out.println("│         3.2 The products that the store is selling    │");
                            System.out.println("│         3.3 Products that are running out of stock    │");
                            System.out.println("│         3.4 Import/export receipt of a product        │");
                            System.out.println("│         3.5 Back to main menu                         │");
                            System.out.println("└─────────────────────────────────┘");
                            System.out.print("Enter your choice (1 - 5): ");
                            int choseCase3 = Integer.parseInt(scanner.nextLine());
                            while (choseCase3 != 5) {
                                switch (choseCase3) {
                                    case 1:
                                        products.expDayPrint();
                                        break;
                                    case 2:
                                        products.sellingProductsPrint();
                                        break;
                                    case 3:
                                        products.outOfStockPrint();
                                        break;
                                    case 4:
                                        break;
                                    case 5:
                                        break;
                                    default:
                                        System.out.println("Invalid input");
                                        break;
                                }
                            System.out.println("┌─────────────────────────────────┐");
                            System.out.println("│                         MENU                          │");
                            System.out.println("│         3.1 Products that have expired                │");
                            System.out.println("│         3.2 The products that the store is selling    │");
                            System.out.println("│         3.3 Products that are running out of stock    │");
                            System.out.println("│         3.4 Import/export receipt of a product        │");
                            System.out.println("│         3.5 Back to main menu                         │");
                            System.out.println("└─────────────────────────────────┘");
                                System.out.print("Enter your choice (1 - 5): ");
                                choseCase3 = Integer.parseInt(scanner.nextLine());
                            }
                            break;
                        case 4:
                            products.writeDataToFile(productsFilename);
                            wareHouse.writeDataToFile(warehouseImport);
                            break;
                        case 5:
                            System.out.println("Closing...");
                            break;
                        default:
                            System.out.println("Invalid chose.");
                    }
                    System.out.println();
                    System.out.println("┌─────────────────────┐");
                    System.out.println("│               MENU                │");
                    System.out.println("│       1. Manage products          │");
                    System.out.println("│       2. Manage Warehouse         │");
                    System.out.println("│       3. Report                   │");
                    System.out.println("│       4. Store data to files      │");
                    System.out.println("│       5. Exit                     │");
                    System.out.println("└─────────────────────┘");
                    System.out.print("Enter your choice (1 - 5): ");
                    chose = Integer.parseInt(scanner.nextLine());
                    System.out.println();
                    if (chose == 5) {
                        System.out.println("Closing...");
                        return;
                    }
                } while (chose != 5);
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice");
                validChoice = false;
            }
        } while (!validChoice);
    }
}