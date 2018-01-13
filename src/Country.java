import java.util.ArrayList;
import java.util.List;

public class Country {
    public final String name;
    public List<City> cities = new ArrayList<>();
    public int myCurrencyIndex;
    public boolean wasCompleted = false;
    public int daysTocked = 0;
    int xh; int yh; int xl; int yl;


    public Country(int xh, int yh, int xl, int yl, String name, int coinIndex, int possibleCoins) {
        this.xh = xh;
        this.xl = xl;
        this.yl = yl;
        this.yh = yh;
        this.name = name;

        myCurrencyIndex = coinIndex;

        for (int i = xl; i <= xh; i++) {
            for (int j = yl; j <= yh; j++) {
                City c = new City(i, j, new int[possibleCoins],coinIndex, this);
                c.coins[coinIndex] = 1000000;
                cities.add(c);

            }
        }
    }

    public void operateDay(){
        boolean is = true;

        for (City c:cities
                ) {
            if(!c.isCompleted())
                is =false;
        }

        wasCompleted = is;

        for (City c: cities
                ) {
            c.operateOneDay();
        }

        if(wasCompleted)
            return;

        daysTocked++;
    }

    public boolean cointainsCity(int x, int y){
        return x>=xl && x<=xh && y>=yl && y<=yh;
    }
}
