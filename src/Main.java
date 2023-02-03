import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        int monthlyCost,includedAmount,extraCost,quantity;
        int[] in=getInput();
        if(in!=null){
            monthlyCost=in[0];
            includedAmount=in[1];
            extraCost=in[2];
            quantity=in[3];
            System.out.print(calculate(monthlyCost,includedAmount,extraCost,quantity));
        }

    }

    public static int calculate(int monthlyCost,int includedAmount,int extraCost,int quantity){
        if(quantity<=includedAmount){
            return monthlyCost;
        }
        else{
           return  monthlyCost+(quantity-includedAmount)*extraCost;
        }
    }


    public static int[] getInput() {
        int[] input=new int[4];
        try{
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            String string=br.readLine();
            String[] in=string.split("\\s+");
            for(int i=0;i<in.length;i++){
                input[i]=Integer.parseInt(in[i]);
            }
            return input;
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return null;

    }
}