package pgr112.step12;

import java.util.HashMap;

public abstract class Equipment {

    private final int id;
    private String locker;
    private boolean needsReplacement;

    public Equipment(int id, String locker, boolean needsReplacement){
        this.id = id;
        this.locker = locker;
        this.needsReplacement = needsReplacement;
    }


    public int getId() {return id;}
    public String getLocker() {return locker;}
    public void setLocker(String locker) {this.locker = locker;}
    public boolean isNeedsReplacement() {return needsReplacement;}
    public void setNeedsReplacement(boolean needsReplacement) {this.needsReplacement = needsReplacement;}

}
