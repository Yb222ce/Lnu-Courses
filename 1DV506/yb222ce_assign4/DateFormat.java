package yb222ce_assign4;

public class DateFormat {
	private int year, month ,day;
   
    private char punctuation, format;
    

    public DateFormat(){
    }
    public DateFormat(int y,int m, int d,char p, char f){
        year = y;
        month = m;
        day = d;
        punctuation = p;
        format = f;
    }
    public int getYear(){
        return year;
    }
    public void setYear(int y){
        notValidYear(y);
        year = y;
    }
    public void setMonth(int m){
        notValidMonth(m);
        month = m;
    }
    public void setDay(int d){
        notValidDay(d);
        day = d;
    }
    public void setPunctuation(char p){
        punctuation = p;
    }
    public void setFormat(char f){
        format = f;
    }

    public String getDate(boolean fullYear){

        String stringYear = year + "";
        String stringMonth;
        if (month < 10){
            stringMonth = "0" + month;
        }
        else stringMonth = month + "";

        String stringDay;
        if (day < 10){
            stringDay = "0" + day;
        }
        else stringDay = day + "";

            if (fullYear){
                if (punctuation != '!'){
                    if (format == 'b'){
                        return stringYear + punctuation + stringMonth + punctuation + stringDay;
                    }
                    else if (format == 'l'){
                        return stringDay + punctuation + stringMonth + punctuation + stringYear;
                    }
                    else if (format == 'm'){
                        return stringMonth + punctuation + stringDay + punctuation + stringYear;
                    }
                    else return "Invalid input";
                }
                else {
                    if (format == 'b'){
                        return stringYear + stringMonth + stringDay;
                    }
                    else if (format == 'l'){
                        return stringDay + stringMonth + stringYear;
                    }
                    else if (format == 'm'){
                        return stringMonth + stringDay + stringYear;
                    }
                    else return "Invalid input";
                }
            }
            else {
                stringYear = stringYear.substring(2);
                if (punctuation != '!'){
                    if (format == 'b'){
                        return stringYear + punctuation + stringMonth + punctuation + stringDay;
                    }
                    else if (format == 'l'){
                        return stringDay + punctuation + stringMonth + punctuation + stringYear;
                    }
                    else if (format == 'm'){
                        return stringMonth + punctuation + stringDay + punctuation + stringYear;
                    }
                    else return "Invalid input";
                }
                else {
                    if (format == 'b'){
                        return stringYear + stringMonth + stringDay;
                    }
                    else if (format == 'l'){
                        return stringDay + stringMonth + stringYear;
                    }
                    else if (format == 'm'){
                        return stringMonth + stringDay + stringYear;
                    }
                    else return "Invalid input";
                }
            }
        }


    //exercise 7
    public static void notValidYear(int year){
        if (year < 1900 || year >= 2100){
            throw new IllegalArgumentException("No, that is not possible, error is: Year must be between 1900 and 2100.");
        }
    }
    public static void notValidMonth(int month){
        if (month < 1 || month > 12){
            throw new IllegalArgumentException("No, that is not possible, error is: Month must be between 1 and 12.");
        }
    }
    public static void notValidDay(int day){
        if (day < 1 || day > 31){
            throw new IllegalArgumentException("No, that is not possible, error is: Not a valid day that month.");
        }
    }

    public static void notValid(int year, int month, int day){

            if (year <= 1900 || year >= 2100){
                throw new IllegalArgumentException("No, that is not possible, error is: Year must be between 1900 and 2100.");
            }
            if (month < 1 || month > 12){
                throw new IllegalArgumentException("No, that is not possible, error is: Month must be between 1 and 12.");
            }
            if (day < 1 || day > 31){
                throw new IllegalArgumentException("No, that is not possible, error is: Not a valid day that month.");
            }

        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0){
            if (month == 2 && day > 29){
                throw new IllegalArgumentException("No, that is not possible, error is: Not a valid day that month.");
            }
            else if ((month == 4 || month == 6 || month == 9 || month == 11) && day > 30){
                throw new IllegalArgumentException("No, that is not possible, error is: Not a valid day that month.");
            }
        }
        else {
            if (month == 2 && day > 28){
                throw new IllegalArgumentException("No, that is not possible, error is: Not a valid day that month.");
            }
            else if ((month == 4 || month == 6 || month == 9 || month == 11) && day > 30){
                throw new IllegalArgumentException("No, that is not possible, error is: Not a valid day that month.");
            }
        }
    }
}
	