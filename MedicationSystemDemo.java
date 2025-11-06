import java.time.LocalDate;

public class MedicationSystemDemo
{
    public static void main(String[] args)
    {
        MedicationSystem system = new MedicationSystem();

        // Create and add medications
        Medication medication1 = new Medication(1, "Oxycodone", 10.0, 15, LocalDate.of(2025, 12, 9));
        Medication medication2 = new Medication(2, "Adderall", 30.0, 30, LocalDate.of(2024, 6, 30));
        Medication medication3 = new Medication(3, "Methylphenidate", 60, 60, LocalDate.of(2026, 3, 15));

        system.addMedication(medication1);
        system.addMedication(medication2);
        system.addMedication(medication3);


        // Create and add patients
        Patient patient1 = new Patient(1, "Tom Bombadil", 26, "746-2938", new Medication[]{medication1, medication2}, new Prescription[]{});
        Patient patient2 = new Patient(2, "Varg Vikernes", 16, "746-0505", new Medication[]{medication3}, new Prescription[]{});
        Patient patient3 = new Patient(3, "Hidetaka Miyazaki", 50, "746-2247", new Medication[]{medication2, medication3}, new Prescription[]{});

        system.addPatient(patient1);
        system.addPatient(patient2);
        system.addPatient(patient3);


        // Create and add doctors
        Doctor doctor1 = new Doctor(1, "Dr. Roronoa", 50, "746-0978", "General Practitioner", new Patient[]{});
        Doctor doctor2 = new Doctor(2, "Dr. Oberyn", 45, "746-5150", "Pediatrics", new Patient[]{});

        system.addDoctor(doctor1);
        system.addDoctor(doctor2);


        // Edit a patient, doctor, & medication
        Patient updatedPatient1 = new Patient(1, "Tom Bombadil", 27, "555-1234", new Medication[]{medication1, medication2}, new Prescription[]{});
        system.editPatient(1, updatedPatient1);

        Doctor updatedDoctor1 = new Doctor(1, "Dr. Roronoa Zoro", 51, "555-5678", "General Practitioner", new Patient[]{});
        system.editDoctor(1, updatedDoctor1);


        // Assign patients to doctors
        system.assignPatientToDoctor(doctor1, patient1);
        system.assignPatientToDoctor(doctor2, patient2);


        // Accept prescriptions
        system.addPrescription(1, doctor1, patient1, medication1, LocalDate.now());
        system.addPrescription(2, doctor2, patient2, medication3, LocalDate.now());


        // Print prescriptions for a selected patient and from a selected doctor
        system.printPrescriptionsForPatient(patient1);

        system.printPrescriptionsFromDoctor(doctor2);


        // Restock medication
        system.restockMedication(1, 50);


        // Check expired medications
        system.checkExpMedications();


        // Search by name(before deleting)
        system.searchByPatientName("Tom Bombadil");
        system.searchByDoctorName("Dr. Roronoa Zoro");
        system.searchByMedicationName("Adderall");


        // Delete a patient, doctor, and medication
        system.deletePatient(3);
        system.deleteDoctor(2);
        system.deleteMedication(3);


        // Search by name(after deleting)
        system.searchByPatientName("Tom Bombadil");
        system.searchByDoctorName("Dr. Roronoa Zoro");
        system.searchByMedicationName("Adderall");


        // Generate full system report
        system.reportGeneration();
    }
}
