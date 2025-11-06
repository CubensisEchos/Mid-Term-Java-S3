public class Patient extends Person
{
    private  Medication[] medications;
    private Prescription[] prescriptions;
    

    //constructors
    public Patient()
    {
        super();
        this.medications = new Medication[0];
        this.prescriptions = new Prescription[0];
    }

    public Patient(int id, String name, int age, String phoneNumber, Medication[] medications, Prescription[] prescriptions)
    {
        super(id, name, age, phoneNumber);
        this.medications = medications;
        this.prescriptions = prescriptions;
    }


    //get and set stuff
    public Medication[] getMedications()
    {
        return medications;
    }

    public Prescription[] getPrescriptions()
    {
        return prescriptions;
    }

    public void setPrescriptions(Prescription[] prescriptions)
    {
        this.prescriptions = prescriptions;
    }

    
    //toString
    public String toString()
    {
        return super.toString() + ", medications: " + java.util.Arrays.toString(medications) + ", prescriptions: " + java.util.Arrays.toString(prescriptions);
    }
}
