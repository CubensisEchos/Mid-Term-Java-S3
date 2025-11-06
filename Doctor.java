public class Doctor extends Person
{
    private String specialization;
    private Patient[] patients;

    
    //constructors
    public Doctor()
    {
        super();
        this.specialization = "";
        this.patients = new Patient[0];
    }

    public Doctor(int id, String name, int age, String phoneNumber, String specialization, Patient[] patients)
    {
        super(id, name, age, phoneNumber);
        this.specialization = specialization;
        this.patients = patients;
    }


    //get and set stuff
    public Patient[] getPatients()
    {
        return patients;
    }

    public void setPatients(Patient[] patients)
    {
        this.patients = patients;
    }


    //toString
    public String toString()
    {
    return super.toString() + ", specialization: " + specialization + ", list of patients: " + java.util.Arrays.toString(patients);
    }
}
