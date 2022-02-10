package pgr112.step12;

public class Ball extends Equipment{

    private boolean needsAir;
    private String ballType;

    public Ball(int id, String locker, boolean replace, String ballType, boolean needsAir){
        super(id, locker, replace);
        this.needsAir = needsAir;
        this.ballType = ballType;
    }

    public boolean isNeedsAir() {return needsAir;}
    public void setNeedsAir(boolean needsAir) {this.needsAir = needsAir;}
    public String getBallType() {return ballType;}
    public void setBallType(String ballType) {this.ballType = ballType;}

    @Override
    public String toString(){
        return String.format("A %s with id %s from %s, needs replacement: %s, needs air: %s"
        , getBallType(), getId(), getLocker(), isNeedsReplacement(), isNeedsAir());
    }
}
