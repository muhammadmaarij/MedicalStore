package fa20_bcs_060;

import java.io.File;
import java.util.Scanner;

public class ShowMedOrders extends ShowMedOrdersGui{
    public void show(){
        try{
            File file = new File("Orders.txt");
            Scanner medi = new Scanner(file);
            while(medi.hasNextLine()){
                areaOrders.append(medi.nextLine() + "\n");
            }
        }
        catch(Exception e){
            System.out.println(e.toString());
        }

    }
}
