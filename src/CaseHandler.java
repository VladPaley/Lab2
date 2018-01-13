import java.util.ArrayList;
import java.util.List;

public class CaseHandler {
    List<Country> countries = new ArrayList<>();
    List<City> cities = new ArrayList<>();

    public String handle(Case curCase) {
        String result = new String();
        for (int i = 0; i<curCase.c ; i++){
            Country c = new Country(curCase.countries.get(i).xh,curCase.countries.get(i).yh,curCase.countries.get(i).xl
            ,curCase.countries.get(i).yl,curCase.countries.get(i).name, i, curCase.c);
            countries.add(c);
        }

        for (Country country:countries) {
            cities.addAll(country.cities);
        }

        initNeightboors();
        int days = 0;

        while (!isComplete()){
            for (Country country:countries) {
            country.operateDay();
            }
            days++;

            if(days > 10000000){
                result = "Imposible to caclalate, will take more than 10000000 days";
                break;
            }
        }

        for (Country country:countries) {
            result+= new String(country.name + " " + country.daysTocked);
            result+= System.lineSeparator();
        }

        return result;
    }

    private boolean isComplete(){
        boolean is = true;

        for (Country c :countries
             ) {
            if(!c.wasCompleted)
                is = false;
        }
        return is;
    }

    private void initNeightboors(){
        for (Country country:countries) {
            for (City city: country.cities) {

                city.addNeighbor(getCityAt(city.x+1,city.y));
                city.addNeighbor(getCityAt(city.x-1,city.y));
                city.addNeighbor(getCityAt(city.x,city.y+1));
                city.addNeighbor(getCityAt(city.x,city.y-1));
            }
        }
    }

    private City getCityAt(int x, int y){
        for (City c:cities
             ) {
            if(c.x ==x && c.y == y)
                return c;
        }
        return null;
    }

    private Country getContatiningCountry(int x, int y){
        for (Country c :countries
             ) {
            if(c.cointainsCity(x,y))
                return c;
        }
        return null;
    }
}
