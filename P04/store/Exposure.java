package store;
public enum Exposure {
    SHADE("full shade"), PARTSUN("part sun / part shade"), SUN("full sun");
    private String string;
    private Exposure(String string) {
        this.string = string;
    }
    
    @Override
    public String toString() {
        return string;
    }
}
