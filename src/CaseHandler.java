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

        for (int i = countries.size() - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (countries.get(j).daysTocked > countries.get(j + 1).daysTocked) {
                    Country t = countries.get(j);
                    countries.set(j, countries.get(j + 1));
                    countries.set(j + 1, t);
                }
                else
                    if(countries.get(j).daysTocked == countries.get(j + 1).daysTocked){
                    if(countries.get(j).name.compareTo( countries.get(j + 1).name) > 0){
                        Country t = countries.get(j);
                        countries.set(j, countries.get(j + 1));
                        countries.set(j + 1, t);
                    }
                    }
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
