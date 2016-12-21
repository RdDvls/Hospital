/**
 * Created by RdDvls on 12/20/16.
 */
public class Cardiologist extends HospitalDoctor implements Doctor {

    public Cardiologist() {
    }

    public Cardiologist(String firstName, String lastName, String college, String type) {

        super(firstName, lastName, college, type);
    }

    @Override
    public Diagnosis diagnose(int illness) {
        return null;
    }

    public Boolean treatPatient(Patient patient){
        int randomNum = (int) (Math.random() *10);
        if(randomNum >5){
            patient.setSick(false);
            return true;
        } else {
            patient.setSick(true);
            return false;
        }
    }
}
