import java.io.*;

public class Main {
    public static void main(String[] args) {
        Input input=new Input();
        input.getInput();
        input.calculate();
        input.display();
    }

public static class Input {
    private int nrOfEmployes;
    private int time;
    private int[] floors;
    private int timePerson;
    private int result;
    public void getInput() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String string = br.readLine();
            String[] first = string.split("\\s+");
            nrOfEmployes = Integer.parseInt(first[0]);
            time = Integer.parseInt(first[1]);
            floors = new int[nrOfEmployes];
            if(nrOfEmployes<2||nrOfEmployes>100||time<2||time>100){
                System.exit(0);
            }

            String secondString = br.readLine();
            String[] second = secondString.split("\\s+");
            for (int i = 0; i < second.length; i++) {
                int floor=Integer.parseInt(second[i]);
                if(floor>100){
                    System.exit(0);
                }
                floors[i] = floor;

            }
            String third = br.readLine();
            timePerson = Integer.parseInt(third)-1;

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void calculate() {
        if(time>floors[timePerson]-floors[0]||time>floors[nrOfEmployes-1]-floors[timePerson]){
            result= floors[nrOfEmployes-1]-floors[0];
        }else{
            int left=floors[timePerson]-floors[0];
            int right=floors[nrOfEmployes-1]-floors[timePerson];
            result=Math.min(left,right)*2+Math.max(left,right);
        }
    }
    public void display(){
        System.out.print(result);
    }

}
}