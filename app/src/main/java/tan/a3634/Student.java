package tan.a3634;

/**
 * Created by Jitae on 24/10/2017.
 */

public class Student {
    private String studentID;
    private String studentName;
    private String zID;

    public Student(){

    }

    public Student(String studentID, String studentName, String zID){
    this.studentID = studentID;
    this.studentName = studentName;
    this.zID = zID;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getzID() {
        return zID;
    }

}
