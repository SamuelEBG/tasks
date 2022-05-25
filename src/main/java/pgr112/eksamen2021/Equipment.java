package pgr112.eksamen2021;

public abstract class Equipment {

    private int id;
    private int locker;
    private boolean needsReplacement;

    public Equipment(int id, int locker, boolean needsReplacement){
        this.id = id;
        this.locker = locker;
        this.needsReplacement = needsReplacement;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLocker() {
        return locker;
    }

    public void setLocker(int locker) {
        this.locker = locker;
    }

    public boolean isNeedsReplacement() {
        return needsReplacement;
    }

    public void setNeedsReplacement(boolean needsReplacement) {
        this.needsReplacement = needsReplacement;
    }
}
