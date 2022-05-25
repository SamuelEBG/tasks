package pgr112.eksamen2021;

public class Ball extends Equipment {

    private BallType ballType;
    private boolean needsAir;

    public Ball(
            int id,
            int locker,
            boolean needsReplacement,
            BallType ballType,
            boolean needsAir) {
        super(id, locker, needsReplacement);
        this.ballType = ballType;
        this.needsAir = needsAir;
    }

    @Override
    public String toString(){
        return String.format(
                "%s with id: %s from locker %s that needs air: %s and needs replacement: %s",
                this.ballType,
                super.getId(),
                super.getLocker(),
                this.needsAir,
                super.isNeedsReplacement()
        );
    }

    public BallType getBallType() {
        return ballType;
    }

    public void setBallType(BallType ballType) {
        this.ballType = ballType;
    }

    public boolean isNeedsAir() {
        return needsAir;
    }

    public void setNeedsAir(boolean needsAir) {
        this.needsAir = needsAir;
    }
}
