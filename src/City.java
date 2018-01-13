import java.util.ArrayList;
import java.util.List;

public class City {
    public int[] coins;
    int x;
    int y;
    int curCoinIndex;
    public Country parentCountry;

    private List<City> neighbors = new ArrayList<>();

    public boolean isCompleted() {
        boolean completed = true;
        for (int c :coins
                ) {
            if(c == 0)
                completed = false;
        }
        return completed;
    }

    public City(int x, int y, int[] coins, int coinIndex, Country parentCountry){
        this.x = x;
        this.coins = coins.clone();
        this.y = y;
        this.curCoinIndex = coinIndex;
        this.parentCountry = parentCountry;
    }

    public void addNeighbor(City c){
        neighbors.add(c);
    }
    public void operateOneDay(){
        for (City neighbor:neighbors
             ) {
            if(neighbor == null)
                continue;

            for (int i = 0; i < coins.length; i++){
                int curentCoin = coins[i];
                int transaction = curentCoin/1000;
                neighbor.coins[i]+=transaction;
                coins[i] -=transaction;
            }
        }
    }
}
