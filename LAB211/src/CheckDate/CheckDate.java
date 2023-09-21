/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CheckDate;

/**
 *
 * @author VietHoang
 */

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;  
import java.time.YearMonth;

public class CheckDate {
    
    public static boolean checkManufacturingDate (String date) {
        try {
            String[] dateSplit = date.split("/");
            String day = dateSplit[0];
            String month = dateSplit[1];
            String year = dateSplit[2];
            int intDay = Integer.parseInt(day);
            int intMonth = Integer.parseInt(month);
            int intYear = Integer.parseInt(year);
            boolean isValidDay = YearMonth.of(intYear, intMonth).isValidDay(intDay);
            if (!isValidDay) {
                return false;
            }
            
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

            if (intCurrentYear > intYear) {
                return true;
            }
            if (intCurrentYear == intYear) {
                if (intCurrentMonth > intMonth) {
                    return true;
                }
                if (intCurrentMonth == intMonth) {
                    if (intCurrentDay >= intDay) {
                        return true;
                    }
                }
            }
            return false;
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException | DateTimeException exception) {
            return false;
        }
    }
    
    public static boolean checkExpirationDate (String date) {
        try {
            String[] dateSplit = date.split("/");
            String day = dateSplit[0];
            String month = dateSplit[1];
            String year = dateSplit[2];
            int intDay = Integer.parseInt(day);
            int intMonth = Integer.parseInt(month);
            int intYear = Integer.parseInt(year);
            boolean isValidDay = YearMonth.of(intYear, intMonth).isValidDay(intDay);
            if (!isValidDay) {
                return false;
            }
            return true;
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException | DateTimeException exception) {
            return false;
        }
    }
}
