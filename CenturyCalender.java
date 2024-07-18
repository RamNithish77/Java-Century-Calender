
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;

class CenturyCalender {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true){
        System.out.println("ENTER WHAT DO U NEED");
        System.out.print("1.PRINT THE YEAR    2.ENTER DATE TO GET DAY    3.SAVE A INCIDENT WITH DATE:");
        int option;
        option= in.nextInt();
       switch (option)
        {
            case 1:
                case1();
            break;
            case 2:
               case2();
                break;
            case 3:
                case3();
                break;
            }
        }
    }
    static void case1(){
        Scanner input= new Scanner(System.in);
        int Year;
        System.out.println("ENTER THE YEAR:");
        Year=input.nextInt();
        YEAR_1114 test=new YEAR_1114(Year);
        test.p(Year);
    }
    static void case2(){
        System.out.println("ENTER THE DATE IN 00/00/0000:");
        Scanner ram=new Scanner(System.in);
        String date = ram.nextLine();
        FINALDATE_1114 Date = new FINALDATE_1114();
        LocalDate localDate = Date.getDate(date);
        String dayOfWeek =Date.getDayOfWeek(localDate);
        System.out.println("THE DAY IS :" + dayOfWeek);
    }
    static void case3(){
        HashMap<LocalDate, String> incidentMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("ENTER THE DATE IN FORMAT YYYY-MM-DD:");
                String dateStr = scanner.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate date1 = LocalDate.parse(dateStr, formatter);

                System.out.println("ENTER THE INCIDENT");
                String incident = scanner.nextLine();

                incidentMap.put(date1, incident);
                System.out.println("DO YOU WANT TO ENTER ANOTHER INCIDENT(YES/NO)");
                String response = scanner.nextLine();
                if (!response.equalsIgnoreCase("YES")) {
                    break;
                }
            } catch (DateTimeParseException e) {
                System.out.println("INVALID DATA TRY AGAIN");
            }
        }

        System.out.println("INCIDENTS:");
        for (LocalDate date1 : incidentMap.keySet()) {
            System.out.println("DATE: " + date1 + ", INCIDENT: " + incidentMap.get(date1));
        }
    }
}

interface DAYTODATE_1114 {
    LocalDate getDate(String date);
}
 class YEAR_1114 {

    private static int year = 0;

    public YEAR_1114(int year) {
        YEAR_1114.year =year;
    }

    void p(int y)
    {
        int year, daycode, leapyear;

        year = inputyear(y);
        daycode = determinedaycode(year);
        determineleapyear(year);
        calendar(year, daycode);
        System.out.println(" ");
    }


     int[] daysinmonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
     String[] months =
            {
                    " ",
                    "\n\n\nJANUARY",
                    "\n\n\nFEBRUARY",
                    "\n\n\nMARCH",
                    "\n\n\nAPRIL",
                    "\n\n\nMAY",
                    "\n\n\nJUNE",
                    "\n\n\nJULY",
                    "\n\n\nAUGUST",
                    "\n\n\nSEPTEMBER",
                    "\n\n\nOCTOBER",
                    "\n\n\nNOVEMBER",
                    "\n\n\nDECEMBER"
            };


     int inputyear (int y)
    {
        return y;
    }

     int determinedaycode ( int year)
    {
        int daycode;
        int d1, d2, d3;

        d1 = (int) ((year - 1) / 4.0);
        d2 = (int) ((year - 1) / 100.);
        d3 = (int) ((year - 1) / 400.);
        daycode = (year + d1 - d2 + d3) % 7;
        return daycode;
    }


     void determineleapyear (int year)
    {
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            daysinmonth[2] = 29;
        } else {
            daysinmonth[2] = 28;
        }
    }

     void calendar ( int year, int daycode) {
        int month, day;
        for (month = 1; month <= 12; month++) {
            System.out.println(months[month]);
            System.out.print("\n\nSUN  MON  TUE  WED  THUS  FRI  SAT\n");
            for (day = 1; day <= 1 + daycode * 5; day++) {
                System.out.print(" ");
            }
            for (day = 1; day <= daysinmonth[month]; day++) {
                System.out.print(day);
                if ((day + daycode) % 7 > 0)
                    System.out.print("   ");
                else
                    System.out.println("  ");
            }
            daycode = (daycode + daysinmonth[month]) % 7;
        }
    }
}

abstract class ABSTRACTDATE_1114 implements DAYTODATE_1114 {
    abstract String getDayOfWeek(LocalDate date);
}
class FINALDATE_1114 extends ABSTRACTDATE_1114 {
    @Override
    public LocalDate getDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(date, formatter);
    }

    @Override
    public String getDayOfWeek(LocalDate date) {
        return date.getDayOfWeek().toString();
    }
}
