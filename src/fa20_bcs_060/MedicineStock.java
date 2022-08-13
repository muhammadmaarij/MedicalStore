package fa20_bcs_060;

public class MedicineStock extends MedicineOrder{
    protected double price;

    public MedicineStock(){
        super();
        price = 0.0;
    }

    public MedicineStock(String name, int quantity, double price){
        super(name, quantity);
        this.price = price;
    }
}
