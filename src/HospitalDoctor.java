/**
 * Created by RdDvls on 12/20/16.
 */
public abstract class HospitalDoctor extends Person implements Doctor{
    private String college;
    private String type;

    public HospitalDoctor(String firstName, String lastName, String college, String type) {
        super(firstName, lastName);
        this.college = college;
        this.type = type;
    }

    public HospitalDoctor() {
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDoctorInfo(){
        return "\tName: " + this.getFirstName() + " " + this.getLastName() + "\n\tCollege: " + this.getCollege() + "\n\tSpecialty: " + this.getType();
    }
}
