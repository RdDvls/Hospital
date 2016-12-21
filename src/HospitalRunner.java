import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by RdDvls on 12/20/16.
 */
public class HospitalRunner {
    public static void main(String[] args) {
        Hospital myHospital = new Hospital();
        HospitalDoctor genDoc = new GeneralDoctor();
        System.out.println("Welcome to " + myHospital.hospitalName);
        System.out.println("How many doctors in the hospital?");
        Scanner inputScanner = new Scanner(System.in);
        int numDoctors = Integer.valueOf(inputScanner.nextLine());
        ArrayList<HospitalDoctor> doctorList = new ArrayList<>();
        for (int index = 0; index < numDoctors; index++) {
            System.out.println("Enter doctor #" + (index + 1) + " information: ");
            System.out.println("\tFirst Name: ");
            String docFirstName = inputScanner.nextLine();
            System.out.println("\tLast Name: ");
            String docLastName = inputScanner.nextLine();
            System.out.println("\tCollege Attended: ");
            String docCollege = inputScanner.nextLine();
            try {
                System.out.println("Doctor Specialty: \n*Enter a number from the list");
                System.out.println("\t1. General");
                System.out.println("\t2. Cardiologist");
                System.out.println("\t3. Surgical Oncologist");
                System.out.println("\t4. Orthopedic Surgeon");
                int docType = inputScanner.nextInt();
                inputScanner.nextLine();
                HospitalDoctor newDoctor;

                if (docType == 1) {
                    newDoctor = new GeneralDoctor(docFirstName, docLastName, docCollege, "General Doctor");
                } else if (docType == 2) {
                    newDoctor = new Cardiologist(docFirstName, docLastName, docCollege, "Cardiologist");
                } else if (docType == 3) {
                    newDoctor = new SurgicalOncologist(docFirstName, docLastName, docCollege, "Surgical Oncologist");
                } else if (docType == 4) {
                    newDoctor = new OrthopedicSurgeon(docFirstName, docLastName, docCollege, "Orthopedic Surgeon");
                } else {
                    System.out.println("NOT VALID");
                    throw new Exception("\tYou must enter a number from the list");
                }
                doctorList.add(newDoctor);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

        }
        System.out.println("********** Doctors in Hospital **********");
        int docIndex = 1;
        for (HospitalDoctor doctor : doctorList) {
            System.out.println("Doctor #" + docIndex);
            System.out.println(doctor.getDoctorInfo());
            docIndex++;
            System.out.println();
        }
        ArrayList<Patient> patientsList = new ArrayList<>();

        System.out.println("How many patients in the hospital?");
        int numPatients = Integer.valueOf(inputScanner.nextLine());
        for (int index = 0; index < numPatients; index++) {
            System.out.println("Enter patient #" + (index + 1) + " information: ");
            System.out.println("\tFirst Name: ");
            String patientFirstName = inputScanner.nextLine();
            System.out.println("\tLast Name: ");
            String patientLastName = inputScanner.nextLine();
            Patient newPatient = new Patient(patientFirstName, patientLastName);
            try {
                System.out.println("What is the patient's affliction?");
                System.out.println("\t1.Strep Throat");
                System.out.println("\t2.Heart Disease");
                System.out.println("\t3.Broken Bone");
                System.out.println("\t4.Cancerous Tumor");
                int afflictionChoice = inputScanner.nextInt();
                inputScanner.nextLine();
                if (afflictionChoice == 1) {
                    newPatient.setDiagnosis(genDoc.diagnose(1));
                    newPatient.setIllnessInt(1);
                    newPatient.setIllness(newPatient.patientDiagnosisToString());
                } else if (afflictionChoice == 2) {
                    newPatient.setDiagnosis(genDoc.diagnose(2));
                    newPatient.setIllnessInt(2);
                    newPatient.setIllness(newPatient.patientDiagnosisToString());
                } else if (afflictionChoice == 3) {
                    newPatient.setDiagnosis(genDoc.diagnose(3));
                    newPatient.setIllnessInt(3);
                    newPatient.setIllness(newPatient.patientDiagnosisToString());
                } else if (afflictionChoice == 4) {
                    newPatient.setDiagnosis(genDoc.diagnose(4));
                    newPatient.setIllnessInt(4);
                    newPatient.setIllness(newPatient.patientDiagnosisToString());
                }
                patientsList.add(newPatient);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        while (true) {
            System.out.println("Choose a patient to treat:");
            System.out.println("\tEnter 0 to exit");
            int index = 1;
            for (Patient currentPatient : patientsList) {
                System.out.println(index + ":" + currentPatient.getFirstName() + " " + currentPatient.getLastName() + "\n\tAffliction: " + currentPatient.getIllness());
                index++;
            }
            int patientChoice = Integer.valueOf(inputScanner.nextLine());
            if(patientChoice == 0){
                break;
            }
            Patient userPatient = patientsList.get((patientChoice - 1));
            System.out.println("You chose: " + userPatient.getFirstName());
            System.out.println("Checking doctors in hospital...");
            for (HospitalDoctor doc : doctorList) {
                if (userPatient.getIllnessInt() == 1 && (doc instanceof GeneralDoctor)) {
                    myHospital.setDocIsHere(true);
                    System.out.println(userPatient.getFirstName() + " " + userPatient.getLastName() + " will be seeing " + doc.getDoctorInfo());
                    System.out.println("Administering treatment for " + userPatient.getIllness());
                    boolean success = ((GeneralDoctor) doc).treatPatient(userPatient);
                    if (success) {
                        System.out.println("Successful treatment!");
                        patientsList.remove(userPatient);
                    } else {
                        System.out.println("Treatment Failed!");
                    }
                } else if (userPatient.getIllnessInt() == 2 && doc instanceof Cardiologist) {
                    myHospital.setDocIsHere(true);
                    System.out.println(userPatient.getFirstName() + " " + userPatient.getLastName() + " will be seeing " + doc.getDoctorInfo());
                    System.out.println("Administering treatment for " + userPatient.getIllness());
                    boolean success = ((Cardiologist) doc).treatPatient(userPatient);
                    if (success) {
                        System.out.println("Successful treatment!");
                        patientsList.remove(userPatient);
                    } else {
                        System.out.println("Treatment Failed!");
                    }
                } else if (userPatient.getIllnessInt() == 3 && doc instanceof OrthopedicSurgeon) {
                    myHospital.setDocIsHere(true);
                    System.out.println(userPatient.getFirstName() + " " + userPatient.getLastName() + " will be seeing " + doc.getDoctorInfo());
                    System.out.println("Administering treatment for " + userPatient.getIllness());
                    boolean success = ((OrthopedicSurgeon) doc).operate(userPatient);
                    if (success) {
                        System.out.println("Successful treatment!");
                        patientsList.remove(userPatient);
                    } else {
                        System.out.println("Treatment Failed!");
                    }
                } else if (userPatient.getIllnessInt() == 4 && doc instanceof SurgicalOncologist) {
                    myHospital.setDocIsHere(true);
                    System.out.println(userPatient.getFirstName() + " " + userPatient.getLastName() + " will be seeing " + doc.getDoctorInfo());
                    System.out.println("Administering  treatment for " + userPatient.getIllness());
                    boolean success = ((SurgicalOncologist) doc).operate(userPatient);
                    if (success) {
                        System.out.println("Successful treatment!");
                        patientsList.remove(userPatient);
                    } else {
                        System.out.println("Treatment Failed!");
                    }
                }

            }
        }

    }
}
