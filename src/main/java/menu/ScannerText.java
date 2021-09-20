package menu;

import java.util.Scanner;

public class ScannerText {

    public static int getInt(){
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNext()){
            sc.next();
            System.out.print("Enter integer number: ");
        }
        return sc.nextInt();
    }

    public static String getString(){
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNextLine()){
            sc.next();
            System.out.print("Enter integer number: ");
        }
        return sc.nextLine();
    }
}
