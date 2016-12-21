/**
 * Created by RdDvls on 12/20/16.
 */
public class Diagnosis {
    public static final int STREP_THROAT = 1;
    public static final int HEART_DISEASE = 2;
    public static final int BROKEN_BONE = 3;
    public static final int CANCEROUS_TUMOR = 4;
    public static final int OTHER = 5;
    public static final int UNDIAGONOSED = -1;

    private int illness = UNDIAGONOSED;

    public Diagnosis(int illness) {
        this.illness = illness;
    }

}
