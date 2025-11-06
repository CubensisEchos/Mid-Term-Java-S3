import java.time.LocalDate;

public class Prescription
{
    private int prescriptionId;
    private Doctor doctor;
    private Patient patient;
    private Medication medication;
    private LocalDate date;
    private LocalDate expDate;

    
    //constructors
    public Prescription()
    {
        this.prescriptionId = 0;
        this.doctor = null;
        this.patient = null;
        this.medication = null;
        this.date = LocalDate.now();
        this.expDate = date.plusYears(1);
    }

    public Prescription(int prescriptionId, Doctor doctor, Patient patient, Medication medication, LocalDate date)
    {
        this.prescriptionId = prescriptionId;
        this.doctor = doctor;
        this.patient = patient;
        this.medication = medication;
        this.date = date;
        this.expDate = date.plusYears(1);
    }


    //get and set stuff
    public Doctor getDoctor()
    {
        return doctor;
    }

    public Patient getPatient()
    {
        return patient;
    }

    public Medication getMedication()
    {
        return medication;
    }

    public LocalDate getDate()
    {
        return date;
    }


    //toString
    public String toString()
    {
        return "Prescription [prescriptionId=" + prescriptionId + ", doctor=" + doctor.getName() + ", patient=" + patient.getName() + ", medication=" + medication.getName() + ", date=" + date + ", expDate=" + expDate + "]";
    }
}