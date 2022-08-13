package fa20_bcs_060;

import java.io.File;
import java.util.Scanner;

public class SearchMedicine {
    protected boolean searchM(String med){
        String[] medN;
        boolean b = false;
        try{
            File file = new File("Medicines.txt");
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()){
                String strMed = sc.nextLine();
                strMed = strMed.substring(15);
                medN = strMed.split(" ");
                if(medN[0].equals(med)){
                    b = true;
                    System.out.println("Medicine name: " + medN[0]  + " Quantity: " + medN[2] + " Price: " + medN[4]);
                    break;
                }
            }
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
        return b;
    }
}
