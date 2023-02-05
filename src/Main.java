import java.io.*;

public class Main {
    public static void main(String[] args) {
        Input input=new Input();
        input.getInput();
        input.calculate();
        input.display();
    }

public static class Input {
    private byte nrOfEmployes;
    private byte time;
    private byte[] floors;
    private byte timePerson;
    private short result;
    public void getInput() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String string = br.readLine();
            String[] first = string.split("\\s+");
            nrOfEmployes = Byte.parseByte(first[0]);
            time = Byte.parseByte(first[1]);
            floors = new byte[nrOfEmployes];

            String secondString = br.readLine();
            String[] second = secondString.split("\\s+");
            for (int i = 0; i < second.length; i++) {
                byte floor=Byte.parseByte(second[i]);
                floors[i] = floor;

            }
            String third = br.readLine();
            timePerson = (byte) (Byte.parseByte(third)-1);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void calculate() {
        if(time>floors[timePerson]-floors[0]||time>floors[nrOfEmployes-1]-floors[timePerson]){
            result= (short) (floors[nrOfEmployes-1]-floors[0]);
        }else{
            int left=floors[timePerson]-floors[0];
            int right=floors[nrOfEmployes-1]-floors[timePerson];
            result= (short) (Math.min(left,right)*2+Math.max(left,right));
        }
    }
    public void display(){
        System.out.print(result);
    }

}
}