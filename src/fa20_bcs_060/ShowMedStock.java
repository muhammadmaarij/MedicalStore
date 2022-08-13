package fa20_bcs_060;

import java.io.File;
import java.util.Scanner;

public class ShowMedStock extends ShowMedStockGui {
    public void show(){
        try{
            File file = new File("Medicines.txt");
            Scanner medi = new Scanner(file);
            while(medi.hasNextLine()){
                getArea().append(medi.nextLine() + "\n");
            }
        }
        catch(Exception e){
            System.out.println(e.toString());
        }

    }
}
