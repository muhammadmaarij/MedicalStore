package fa20_bcs_060;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class PlaceOrder extends MedicineOrder implements OrderInterface{
    ArrayList<MedicineOrder> medicineStockOrder = new ArrayList<>();

    public void Stock(){
        try{
            File file = new File("Orders.txt");

            FileWriter f = new FileWriter(file, true);

            PrintWriter print = new PrintWriter(f);

            for(int i = 0; i<= medicineStockOrder.size()-1; i++){
                print.println("Medicine name: " + medicineStockOrder.get(i).medicineName + " Quantity: " + medicineStockOrder.get(i).quantity);
            }
            print.close();
        }
        catch (Exception e){

            System.out.println(e.toString());
        }
    }
    public boolean placeOrd(String name, String quantity){
        try{
            SearchMedicine searchMedicine = new SearchMedicine();
            if(searchMedicine.searchM(name)){
                File file = new File("Orders.txt");
                FileWriter f = new FileWriter(file, true);
                PrintWriter print = new PrintWriter(f);
                print.println("Medicine name: " + name + " Quantity: " + quantity);
                medicineStockOrder.add(new MedicineOrder(name,Integer.parseInt(quantity)));
                print.close();
                return true;
            }
            else {
                return false;
            }
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
        return false;
    }
}
