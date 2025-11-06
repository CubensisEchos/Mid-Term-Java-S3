import java.time.LocalDate;

public class Medication
{
    private int medicationId;
    private String name;
    private double dose;
    private int quantity;
    private LocalDate expDate;


    //constructors
    public Medication()
    {
        this.medicationId = 0;
        this.name = "";
        this.dose = 0.0;
        this.quantity = 0;
        this.expDate = LocalDate.now();
    }

    public Medication(int medicationId, String name, double dose, int quantity, LocalDate expDate)
    {
        this.medicationId = medicationId;
        this.name = name;
        this.dose = dose;
        this.quantity = quantity;
        this.expDate = expDate;
    }


    //get and set stuff
    public int getMedicationId()
    {
        return medicationId;
    }

    public String getName()
    {
        return name;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public LocalDate getExpDate()
    {
        return expDate;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }


    //toString
    public String toString()
    {
        return "Medication [medicationId=" + medicationId + ", name=" + name + ", dose=" + dose + ", quantity=" + quantity + ", expDate=" + expDate + "]";
    }
}
