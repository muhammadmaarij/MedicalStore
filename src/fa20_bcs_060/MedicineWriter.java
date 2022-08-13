package fa20_bcs_060;

import java.io.*;

import java.util.Scanner;

public class MedicineWriter extends StockMedicine{

    public boolean addMed(String name, String quantity, String price) {
        try{

            File file = new File("Medicines.txt");
            FileWriter f = new FileWriter(file, true);
            PrintWriter print = new PrintWriter(f);
            print.println("Medicine name: " + name + " Quantity: " + quantity + " Price: " + price);
            medicineStock.add(new MedicineStock(name,Integer.parseInt(quantity),Integer.parseInt(price)));
            print.close();
            return true;
        }
        catch (Exception e){
            System.out.println(e.toString());

        }
        return false;
    }

    public void deleteMedi(String name){
        boolean delchk = false;
        try{
            File file = new File("Medicines.txt");
            Scanner medi = new Scanner(file);
            for (int i = 0; i<medicineStock.size(); i++){
                if(name.equals(medicineStock.get(i).medicineName)){
                    delchk = true;
                    medicineStock.remove(i);
                    break;
                }
            }
            PrintWriter printWriter = new PrintWriter(file);

            printWriter.write("");


            if(delchk){
                FileWriter f = new FileWriter(file, true);

                PrintWriter print = new PrintWriter(f);

                for(int j = 0; j<=medicineStock.size()-1; j++){
                    print.println("Medicine name: " + medicineStock.get(j).medicineName + " Quantity: " + medicineStock.get(j).quantity + " Price: " + medicineStock.get(j).price);
                }
                print.close();
                f.close();
            }
            for(int i = 0; i<=medicineStock.size()-1; i++){
                System.out.println(medicineStock.get(i).medicineName);
            }
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
    }
}
