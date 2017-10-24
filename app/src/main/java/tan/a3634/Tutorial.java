package tan.a3634;

/**
 * Created by Jitae on 24/10/2017.
 */

public class Tutorial {
    private String classID;
    private String troomCode;
    private String classes;

    public Tutorial(){

    }

    public Tutorial(String classID, String troomCode, String classes) {
        this.classID = classID;
        this.troomCode = troomCode;
        this.classes = classes;
    }

    public String getClassID() {
        return classID;
    }

    public String getTroomCode() {
        return troomCode;
    }

    public String getClasses() {
        return classes;
    }

}
