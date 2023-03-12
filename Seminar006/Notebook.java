
public class Notebook {
    String idSN;
    String brand;
    int ozu;
    int zd;
    String os;
    String color;

    public Notebook(String idSN, String brand, int ozu, int zd, String os, String color) {
        this.idSN = idSN;
        this.brand = brand;
        this.ozu = ozu;
        this.zd = zd;
        this.os = os;
        this.color = color;
    }

    public boolean alike(Object el) {
        if (el instanceof Integer) {
            if (((Integer) el == ozu) || ((Integer) el == zd)) {
                return true;
            }
        } else {
            if (el instanceof String) {
                if ((el.toString().equals(os)) || (el.toString().equals(color))) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("S/N:%s, %s, %dГб/%dГб, %s, %s", idSN, brand, ozu, zd, os, color);
    }
}
