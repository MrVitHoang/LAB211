/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Report;

/**
 *
 * @author VietHoang
 */

import Manage.Products;

import java.time.DateTimeException;
import java.time.LocalDate;

import java.time.format.DateTimeFormatter;

public class Report extends Products{
    public boolean expiredProductsCheck(String expDate) {
        try {
            String[] dateSplit = expDate.split("/");
            String day = dateSplit[0];
            String month = dateSplit[1];
            String year = dateSplit[2];
            int intDay = Integer.parseInt(day);
            int intMonth = Integer.parseInt(month);
            int intYear = Integer.parseInt(year);

            LocalDate localDate = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String currentDateString = formatter.format(localDate);
            String[] currentDateStringSplit = currentDateString.split("/");
            String currentDate = currentDateStringSplit[0];
            String currentMonth = currentDateStringSplit[1];
            String currentYear = currentDateStringSplit[2];
            int intCurrentDay = Integer.parseInt(currentDate);
            int intCurrentMonth = Integer.parseInt(currentMonth);
            int intCurrentYear = Integer.parseInt(currentYear);

            if (intCurrentYear < intYear) {
                return true;
            }
            if (intCurrentYear == intYear) {
                if (intCurrentMonth < intMonth) {
                    return true;
                }
                if (intCurrentMonth == intMonth) {
                    if (intCurrentDay <= intDay) {
                        return true;
                    }
                }
            }
            return false;
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException | DateTimeException exception) {
            return false;
        }
    }

    public boolean outOfStock (int quantity) {
        if (quantity == 0) {
            return true;
        } else {
            return false;
        }
    }
}
