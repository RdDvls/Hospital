/**
 * Created by RdDvls on 12/20/16.
 */
public class OrthopedicSurgeon extends HospitalDoctor implements Surgeon{
    @Override
    public Diagnosis diagnose(int illness) {
        return null;
    }

    @Override
    public Boolean operate(Patient patient) {
        int randomNum = (int)(Math.random() * 10);
        if (randomNum > 5) {
            patient.setSick(false);
            return true;
        } else {
            patient.setSick(true);
            return false;
        }
    }

    public OrthopedicSurgeon() {
    }

    public OrthopedicSurgeon(String firstName, String lastName, String college, String type) {

        super(firstName, lastName, college, type);
    }
}
