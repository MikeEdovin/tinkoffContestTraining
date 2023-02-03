import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        int nrOfPersons=getInput();
            System.out.print(calculate(nrOfPersons));
        }

    public static int calculate(int input) {
        int counter = 0;
        while (input != 1) {
            if (input % 2 == 1) {
               input += 1;
            }
            input=input/2;
            counter += 1;
        }
        return counter ;
    }

    public static int getInput() {
        try{
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            String string=br.readLine();
            return Integer.parseInt(string);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return 0;

    }
}