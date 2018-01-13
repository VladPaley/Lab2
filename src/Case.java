import java.util.ArrayList;
import java.util.List;

public class Case {
    public int c;
    public List<Countries> countries = new ArrayList<Countries>();

    public static class Countries {
        public int xh;
        public int xl;
        public int yh;
        public int yl;
        public String name;

        public Countries(String name, int xl, int yl, int xh, int yh) {
            this.xh = xh;
            this.xl = xl;
            this.yh = yh;
            this.yl = yl;
            this.name = name;
        }
    }
}

