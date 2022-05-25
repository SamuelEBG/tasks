package pgr112.eksamen2021;

public class TableTennisRacket extends Equipment {

    private boolean needsNewCoating;

    public TableTennisRacket(
            int id,
            int locker,
            boolean needsReplacement,
            boolean needsNewCoating) {
        super(id, locker, needsReplacement);
        this.needsNewCoating = needsNewCoating;
    }

    @Override
    public String toString(){
        return String.format(
                "Table-tennis with id: %s from locker %s that needs new coating: %s needs replacement: %s",
                super.getId(),
                super.getLocker(),
                this.needsNewCoating,
                super.isNeedsReplacement()
        );
    }

    public boolean isNeedsNewCoating() {
        return needsNewCoating;
    }

    public void setNeedsNewCoating(boolean needsNewCoating) {
        this.needsNewCoating = needsNewCoating;
    }
}
