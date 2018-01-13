import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputReader {
    String EndOfCaseMark = "0";
    List<Case> cases = new ArrayList<Case>();

    public void read(File file) throws IOException {
        Scanner scanner = new Scanner(file);
        int i = 0;
        Case curCase = null;

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if (line.equals(EndOfCaseMark)) {
                cases.add(curCase);
                i = 0;
            } else {
                if (i == 0) {
                    curCase = handleFirstLine((line));
                    i++;
                }
                else if(i <= curCase.c){
                    curCase = handleCountriesLine(line,curCase);
                    i++;
                }
            }
        }
    }

        private Case handleFirstLine(String line){
            Case aCase = new Case();
            aCase.c = Character.getNumericValue(line.charAt(0));
            return aCase;
        }

        private Case handleCountriesLine(String line, Case curCase){
            int i = 0;
            char ch = line.charAt(i);
            String name = new String();
            //name+=ch;

            while ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')){
                name+=ch;
                i++;
                ch = line.charAt(i);
            }

            Case.Countries coor = new Case.Countries(name, Character.getNumericValue(line.charAt(name.length() + 1)),
                    Character.getNumericValue(line.charAt(name.length() + 3)),Character.getNumericValue(line.charAt(name.length() + 5))
                    ,Character.getNumericValue(line.charAt(name.length() + 7)));
            curCase.countries.add(coor);
            return curCase;
        }

}
