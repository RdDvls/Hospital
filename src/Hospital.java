import java.util.ArrayList;

/**
 * Created by RdDvls on 12/20/16.
 */
public class Hospital {
    public String hospitalName = "Patch Adams Memorial Center for People Who Don't Feel Right";
    private boolean docIsHere = false;
    private ArrayList<HospitalDoctor> doctorArrayList;

    public boolean isDocIsHere() {
        return docIsHere;
    }

    public void setDocIsHere(boolean docIsHere) {
        this.docIsHere = docIsHere;
    }

    public ArrayList<HospitalDoctor> getDoctorArrayList() {
        return doctorArrayList;
    }

    public void setDoctorArrayList(ArrayList<HospitalDoctor> doctorArrayList) {
        this.doctorArrayList = doctorArrayList;
    }

    public Hospital(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public Hospital() {
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }
}
