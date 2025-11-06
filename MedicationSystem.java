import java.time.LocalDate;

public class MedicationSystem
{
    private Patient[] patients;
    private Doctor[] doctors;
    private Medication[] medications;
    private Prescription[] prescriptions;


    //constructors
    public MedicationSystem()
    {
        this.patients = new Patient[0];
        this.doctors = new Doctor[0];
        this.medications = new Medication[0];
        this.prescriptions = new Prescription[0];
    }

    public MedicationSystem(Patient[] patients, Doctor[] doctors, Medication[] medications, Prescription[] prescriptions)
    {
        this.patients = patients;
        this.doctors = doctors;
        this.medications = medications;
        this.prescriptions = prescriptions;
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


    // search by name
    public void searchByPatientName(String name)
    {
        for (int i = 0; i < patients.length; i++)
        if (patients[i].getName().equalsIgnoreCase(name))
        System.out.println(patients[i]);
    }

    public void searchByDoctorName(String name)
    {
        for (int i = 0; i < doctors.length; i++)
        if (doctors[i].getName().equalsIgnoreCase(name))
        System.out.println(doctors[i]);
    }

    public void searchByMedicationName(String name)
    {
        for (int i = 0; i < medications.length; i++)
        if (medications[i].getName().equalsIgnoreCase(name))
        System.out.println(medications[i]);
    }


    //add patient to doctor
    public void assignPatientToDoctor(Doctor doctor, Patient patient)
    {
        Patient[] beforeUpdate = doctor.getPatients();
        Patient[] updated = new Patient[beforeUpdate.length + 1];
        for (int i = 0; i < beforeUpdate.length; i++)
        updated[i] = beforeUpdate[i];
        updated[beforeUpdate.length] = patient;
        doctor.setPatients(updated);
        System.out.println("Patient " + patient.getName() + " assigned to Doctor " + doctor.getName());
    }


    // accept prescription
    public void addPrescription(int prescriptionId, Doctor doctor, Patient patient, Medication medication, LocalDate date)
    {
        if (patient == null || doctor == null || medication == null)
        {
            System.out.println("Error, invalid doctor, patient, or medication.");
            return;
        }
        Prescription newPrescription = new Prescription(prescriptionId, doctor, patient, medication, date);

        //add to prescriptions array
        Prescription[] beforeUpdate = this.prescriptions;
        Prescription[] updated = new Prescription[beforeUpdate.length + 1];
        for (int i = 0; i < beforeUpdate.length; i++)
        updated[i] = beforeUpdate[i];
        updated[beforeUpdate.length] = newPrescription;
        this.prescriptions = updated;

        // add to patient's prescriptions array
        Prescription[] patientBeforeUpdate = patient.getPrescriptions();
        Prescription[] patientUpdated = new Prescription[patientBeforeUpdate.length + 1];
        for (int i = 0; i < patientBeforeUpdate.length; i++)
        patientUpdated[i] = patientBeforeUpdate[i];
        patientUpdated[patientBeforeUpdate.length] = newPrescription;
        patient.setPrescriptions(patientUpdated);

        System.out.println("Prescription added:" + newPrescription);
    }


    // add/edit/delete stuff
    //patient add
    public void addPatient(Patient patient)
    {
        Patient[] newPatients = new Patient[patients.length + 1];
        for (int i = 0; i < patients.length; i++)
        {
            newPatients[i] = patients[i];
        }
        newPatients[patients.length] = patient;
        patients = newPatients;
        System.out.println("Patient added: " + patient.getName());
    }

    //patient edit
    public void editPatient(int id, Patient patientEdited)
    {
        for (int i = 0; i < patients.length; i++)
        {
            if (patients[i].getId() == id)
            {
                patients[i] = patientEdited;
                System.out.println("Patient information updated.");
                return;
            }
        }
        System.out.println("Patient not found.");
    }

    //patient delete
    public void deletePatient(int id)
    {
        int num = 0;
        for (int i = 0; i < patients.length; i++)
        if (patients[i].getId() != id)
        num++;

        Patient[] updated = new Patient[num];
        int index = 0;
        for (int i = 0; i < patients.length; i++)
        {
            if (patients[i].getId() != id)
            {
                updated[index] = patients[i];
                index++;
            }
        }
    patients = updated;
    System.out.println("Patient deleted if they existed.");
    }

    //doctor add
    public void addDoctor(Doctor doctor)
    {
        Doctor[] newDoctors = new Doctor[doctors.length + 1];
        for (int i = 0; i < doctors.length; i++)
        {
            newDoctors[i] = doctors[i];
        }
        newDoctors[doctors.length] = doctor;
        doctors = newDoctors;
        System.out.println("Doctor added: " + doctor.getName());
    }

    //doctor edit
    public void editDoctor(int id, Doctor doctorEdited)
    {
        for (int i = 0; i < doctors.length; i++)
        {
            if (doctors[i].getId() == id)
            {
                doctors[i] = doctorEdited;
                System.out.println("Doctor information updated.");
                return;
            }
        }
        System.out.println("Doctor not found.");
    }

    //doctor delete
    public void deleteDoctor(int id)
    {
        int num = 0;
        for (int i = 0; i < doctors.length; i++)
        if (doctors[i].getId() != id)
        num++;

        Doctor[] updated = new Doctor[num];
        int index = 0;
        for (int i = 0; i < doctors.length; i++)
        {
            if (doctors[i].getId() != id)
            {
                updated[index] = doctors[i];
                index++;
            }
        }
    doctors = updated;
    System.out.println("Doctor deleted if they existed.");
    }

    //medication add
    public void addMedication(Medication medication)
    {
        Medication[] newMedications = new Medication[medications.length + 1];
        for (int i = 0; i < medications.length; i++)
        {
            newMedications[i] = medications[i];
        }
        newMedications[medications.length] = medication;
        medications = newMedications;
        System.out.println("Medication added: " + medication.getName());
    }

    //medication edit
    public void editMedication(int id, Medication medicationEdited)
    {
        for (int i = 0; i < medications.length; i++)
        {
            if (medications[i].getMedicationId() == id)
            {
                medications[i] = medicationEdited;
                System.out.println("Medication information updated.");
                return;
            }
        }
        System.out.println("Medication not found.");
    }

    //medication delete
    public void deleteMedication(int id)
    {
        int num = 0;
        for (int i = 0; i < medications.length; i++)
        if (medications[i].getMedicationId() != id)
        num++;

        Medication[] updated = new Medication[num];
        int index = 0;
        for (int i = 0; i < medications.length; i++)
        {
            if (medications[i].getMedicationId() != id)
            {
                updated[index] = medications[i];
                index++;
            }
        }
    medications = updated;
    System.out.println("Medication deleted if it existed.");
    }


    // generate report with all info
    public void reportGeneration()
    {
        System.out.println("|-- Patients --|");
        for (int i = 0; i < patients.length; i++)
        System.out.println(patients[i]);

        System.out.println("|-- Doctors --|");
        for (int i = 0; i < doctors.length; i++)
        System.out.println(doctors[i]);

        System.out.println("|-- Medications --|");
        for (int i = 0; i < medications.length; i++)
        System.out.println(medications[i]);

        System.out.println("|-- Prescriptions --|");
        for (int i = 0; i < prescriptions.length; i++)
        System.out.println(prescriptions[i]);
    }


    // check expired medications
    public void checkExpMedications()
    {
        for (int i = 0; i < medications.length; i++)
        {
            if (medications[i].getExpDate().isBefore(LocalDate.now()))
            {
                System.out.println("Expired: " + medications[i]);
            }
        }
    }


    //print prescriptions(names only) for the past year for selected patient
    public void printPrescriptionsForPatient(Patient patient)
    {
        LocalDate oneYear = LocalDate.now().minusYears(1);
        System.out.println("Prescriptions in the past year:");

        Prescription[] patientPrescriptions = patient.getPrescriptions();
        for (int i = 0; i < patientPrescriptions.length; i++)
        {
            Prescription pastPrescription = patientPrescriptions[i];
            if (pastPrescription.getDate().isAfter(oneYear))
            {
                System.out.println(pastPrescription.getMedication().getName());
            }
        }
    }


    //print prescriptions from a certain doctor
    public void printPrescriptionsFromDoctor(Doctor doctor )
    {
        for (int i = 0; i < prescriptions.length; i++)
        {
            if (prescriptions[i].getDoctor() == doctor)
            {
                System.out.println(prescriptions[i]);
            }
        }
    }


    //restock medications
    public void restockMedication(int medicationId, int newQuantity)
    {
        for (int i = 0; i < medications.length; i++)
        {
            if (medications[i].getMedicationId() == medicationId)
            {
                medications[i].setQuantity(newQuantity);
                System.out.println("Medication restocked: " + medications[i]. getName() + " | new quantity: " + newQuantity);
                return;
            }
        }
        System.out.println("Medication not found.");
    }
}
