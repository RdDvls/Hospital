/**
 * Created by RdDvls on 12/20/16.
 */
public class Patient extends Person {
    private boolean isSick = true;
    private String illness = "";
    private Diagnosis diagnosis;
    private int illnessInt;

    public boolean isSick() {
        return isSick;
    }

    public void setSick(boolean sick) {
        isSick = sick;
    }

    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }

    public Diagnosis getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(Diagnosis diagnosis) {
        this.diagnosis = diagnosis;
    }

    public int getIllnessInt() {
        return illnessInt;
    }

    public void setIllnessInt(int illnessInt) {
        this.illnessInt = illnessInt;
    }

    public Patient(String firstName, String lastName) {

        super(firstName, lastName);
    }


    public String patientDiagnosisToString() {
        if (this.illnessInt == 1) {
            return "Strep Throat";
        } else if (this.illnessInt == 2) {
            return "Heart Disease";
        } else if (this.illnessInt == 3){
            return "Broken Bone";
        }else if (this.illnessInt == 4){
            return "Cancerous Tumor";
        }

        return "Other";
    }
}

