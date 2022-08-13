package fa20_bcs_060;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class StockMedicine {
    static ArrayList<MedicineStock> medicineStock = new ArrayList<>();

    public void show(){

        medicineStock.add(new MedicineStock("Panadol", 12, 20));
        medicineStock.add(new MedicineStock("Risek", 17, 10));
        medicineStock.add(new MedicineStock("Concor", 13, 30));
        medicineStock.add(new MedicineStock("Norvasc", 10, 29));
        medicineStock.add(new MedicineStock("Telfast", 14, 25));
        medicineStock.add(new MedicineStock("Sustac", 7, 22));
        medicineStock.add(new MedicineStock("LowPlat", 16, 15));

        try {
            File file = new File("Medicines.txt");

            FileWriter f = new FileWriter(file, true);

            PrintWriter print = new PrintWriter(f);

            for (int i = 0; i <= medicineStock.size() - 1; i++) {
                print.println("Medicine name: " + medicineStock.get(i).medicineName + " Quantity: " + medicineStock.get(i).quantity + " Price: " + medicineStock.get(i).price);
            }

            print.close();

        } catch (Exception e) {

            System.out.println(e.toString());
        }
    }

}
