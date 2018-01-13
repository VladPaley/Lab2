import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        InputReader inputReader = new InputReader();

        inputReader.read(new File("src/input"));

        int i = 1;
        for (Case curCase : inputReader.cases) {
            System.out.print("Case " + i);
            System.out.print(System.lineSeparator());
            CaseHandler caseHandler = new CaseHandler();
            String output = caseHandler.handle(curCase);
            System.out.println(output);
            i++;
        }
    }
    }
