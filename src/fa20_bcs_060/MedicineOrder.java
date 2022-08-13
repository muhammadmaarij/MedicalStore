package fa20_bcs_060;

public class MedicineOrder {
    protected String medicineName;
    protected int quantity;

    public MedicineOrder() {
        medicineName = null;
        quantity = 0;
    }
    public MedicineOrder(String medicineName, int quantity){
        this.medicineName = medicineName;
        this.quantity = quantity;
    }
}
