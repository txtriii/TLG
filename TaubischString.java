public class TaubischString implements ComparableContent<TaubischString> {
    private String value;

    public TaubischString(String s) {
        this.value = s;
    }

    public String getValue() {
        return this.value;
    }
    @Override
    public boolean isEqual(TaubischString other) {
        return this.value.equals(other.getValue());
    }

    @Override
    public boolean isGreater(TaubischString other) {
        return this.value.compareTo(other.getValue()) > 0;
    }

    @Override
    public boolean isLess(TaubischString other) {
        return this.value.compareTo(other.getValue()) < 0;
    }
}