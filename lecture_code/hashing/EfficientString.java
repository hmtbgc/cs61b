// some bugs ?? I cannot find them.
public class EfficientString {
    private int _hash;
    private String _val;

    public EfficientString(String val) {
        if (val == null) {
            throw new IllegalArgumentException("null!");
        }

        _val = val;
        _hash = val.hashCode();
    }

    @Override
    public String toString() {
        return _val;
    }

    public int hashcode() {
        return _hash;
    }

    public void setVal(String val) {
        _val = val;
        _hash = val.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof EfficientString && _val.equals(obj.toString());
    }
}
