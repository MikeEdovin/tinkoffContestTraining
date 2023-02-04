import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Input input=new Input();
        input.getInput();
        input.generateBegin();
        input.generateEnd();
        input.calculate();
        input.display();
    }

public static class Input {
    private long start;
    private long end;
    private long nrOfStartDigits;
    private long nrOfEndDigits;
    private List<Long> generatedStart=new LinkedList<>();
    private List<Long>generatedEnd=new LinkedList<>();
    private long result;
    public void getInput() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("input.txt"));
            String string = br.readLine();
            String[] first = string.split("\\s+");
            start = Long.parseLong(first[0]);
            end = Long.parseLong(first[1]);
            nrOfStartDigits= first[0].length();
            nrOfEndDigits=first[1].length();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void calculate() {
        result = (nrOfEndDigits - nrOfStartDigits) * 9+9;
            for (long item : generatedStart) {
                if (item < start) {
                    result--;
                }
                if(item>start){
                    break;
                }
            }
            for (long item : generatedEnd) {
                if (item > end) {
                    result--;
                }
                if(item<end){
                    break;
                }
            }
    }
    private void generateBegin(){
        for(int i=1;i<10;i++) {
            String digit=String.valueOf(i);
            for (int j =1; j<nrOfStartDigits;j++) {
                 digit=digit+ i;
            }
            generatedStart.add(Long.parseLong(digit));
        }

    }
    private void generateEnd(){
        for(int i=9;i>0;i--) {
            String digit=String.valueOf(i);
            for (int j =1; j<nrOfEndDigits;j++) {
                digit=digit+ i;
            }
            generatedEnd.add(Long.parseLong(digit));
        }
    }
    public void display(){
        System.out.println(result);
    }

}
}