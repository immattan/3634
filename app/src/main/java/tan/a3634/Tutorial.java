package tan.a3634;

/**
 * Created by Jitae on 24/10/2017.
 */

public class Tutorial {
    private String classID;
    private String roomCode;
    private String classes;

    public Tutorial(){

    }
//    public Tutorial(String classID, String classes){
//        this.classID = classID;
//        this.classes = classes;
//    }

    public Tutorial(String classID, String classes, String troomCode) {
        this.classID = classID;
        this.roomCode = roomCode;
        this.classes = classes;
    }

    public String getClassID() {
        return classID;
    }

    public String getRoomCode() {
        return roomCode;
    }

    public String getClasses() {
        return classes;
    }

}
