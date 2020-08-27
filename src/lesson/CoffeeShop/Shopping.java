package lesson.CoffeeShop;

import java.util.HashMap;
import java.util.Scanner;

public class Shopping {
    public static void main(String[] args) {

        /*
        Beverage beverage = new Latte();
        System.out.println("Your Coffee:   " + beverage.getDescription());
        System.out.println("Total Price:   $" + beverage.cost());
         */

        Beverage beverage = null;


        //主咖啡选择
        System.out.println("Welcome!");
        System.out.println("Which coffee do you want? \n" +
                "1: Latte ($14) \n" +
                "2: Roast ($13) ");
        System.out.println("Choose number:");
        Scanner input = new Scanner(System.in);
        String coffee = input.next();
        switch (coffee){
            case "1": beverage = new Latte(beverage);break;
            case "2": beverage = new Roast(beverage);break;
        }


        //糖浆选择
        HashMap<String, String> sugar_table = new HashMap<>();
        Outer:while(true) {
            System.out.println("Which sugar do you want? \n" +
                    "1: OriginalSugar ($2)  \n" +
                    "2: VanillaSugar ($2.5)  \n" +
                    "3: MokaSugar ($4)  \n" +
                    "0: OK and Next");
            System.out.println("Choose number: ");
            String sugar = input.next();
            if(sugar.equals("0"))
                break Outer;
            System.out.println("Choose amount: ");
            String amount = input.next();
            sugar_table.put(sugar, amount);
        }

        for(String s : sugar_table.keySet()){
            switch (s){
                case "1": beverage = new OriginalSugar(beverage, Integer.parseInt(sugar_table.get(s)));break;
                case "2": beverage = new VanillaSugar(beverage, Integer.parseInt(sugar_table.get(s)));break;
                case "3": beverage = new MokaSugar(beverage, Integer.parseInt((sugar_table.get(s))));break;
            }
        }


        //温度选择
        System.out.println("Which temperature do you want?\n" +
                "1: Hot \n" +
                "2: Cool\n" +
                "3: Cold");
        System.out.println("Choose number: ");
        String temperature = input.next();
        String temperature_result = "";
        switch (temperature){
            case "1": temperature_result = "Hot";break;
            case "2": temperature_result = "Cool";break;
            case "3": temperature_result = "Cold";break;
        }


        //尺寸选择
        System.out.println("Which CupSize do you want?\n" +
                "1: Tall (100% base price) \n" +
                "2: Grande (150% base price)\n" +
                "3: Venti (200% base price)");
        System.out.println("Choose number: ");
        String CupSize = input.next();
        String CupSize_Result = "";
        double multiple = 1;
        switch (CupSize){
            case "1": CupSize_Result = "Tall"; multiple = 1.0; break;
            case "2": CupSize_Result = "Grande"; multiple = 1.5; break;
            case "3": CupSize_Result = "Venti"; multiple = 2.0; break;
        }


        //打印咖啡信息
        System.out.println("Your Coffee:   " + beverage.getDescription() + "\n" +
                "Your Temperature:   " + temperature_result + "\n" +
                "Your CupSize:   " + CupSize_Result );
        System.out.println("Total Price:   $" + multiple * beverage.cost());
        System.out.println("See you next time!");




    }

}
