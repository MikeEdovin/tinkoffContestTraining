import java.io.*;

public class Main {
    public static void main(String[] args) {
        Input input=new Input();
        input.getInput();
        input.calculate();
        input.display();
    }

public static class Input {
    private int quantity;
    private int nrOfReplacement;
    private int[] numbers;
    private int result;
    public void getInput() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("input.txt"));
            String string = br.readLine();
            String[] first = string.split("\\s+");
            quantity = Integer.parseInt(first[0]);
            nrOfReplacement = Integer.parseInt(first[1]);
            numbers = new int[quantity];

            String secondString = br.readLine();
            String[] second = secondString.split("\\s+");
            for (int i = 0; i < second.length; i++) {
                numbers[i] = Integer.parseInt(second[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void calculate() {

    }
    public void display(){
        for(int i=0;i<quantity;i++) {
            System.out.print(numbers[i]+" ");
        }
        System.out.println();
        for(int i=0;i<quantity;i++) {
            System.out.print(Integer.toBinaryString(numbers[i])+" ");
        }
    }

}
}