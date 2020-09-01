package lesson.QuerySQL_new;

import java.util.Stack;

public class SQLGene {
    public static String check(String input) {
        //input = "(age >= 30) and (height > 170cm)"

        input = input.replace("and", "a")
                .replace("or", "o");
//        String[] keywords = {"Select", "From", "Where", "orderby"};
//        String[] fields = {"UserId", "Age", "Height", "Company", "PhoneNum"};
//        String[] compare = {">", "<", ">=", "<=", "=", "!="};
//        String[] andor = {"a", "o"};
//        String str = "Select * From Customer Where ";
//        String[] strs = input.split(" ");

        String prefix = "Select * From Customer Where ";
        if (!input.contains("(")){
            String result = function2(input);
            return prefix + result;
        }
        Node query = new SetNode(" and ");
        Node conditions = new SetNode("");
        function(input, query,"", conditions);

        query.popChild();

        return prefix + query.toString().substring(1, query.toString().length() - 1);


    }

    private static String function2(String input) {
        Node query = new SetNode(" and ");
        Node conditions = new SetNode("");
        String[] str = input.split(" ");
        Node Compare = new CompareNode(str[1]);
        Compare.addChild(new ValueNode(str[0]));
        Compare.addChild(new ValueNode(str[2]));
        conditions.addChild(Compare);
        query.addChild(conditions);
        return query.toString().substring(1, query.toString().length() - 1);
    }

    private static void function(String input, Node query, String root, Node conditions) {
        //root是传入的a（and）或者o（or）

        if(!input.contains(" a ") && !input.contains(" o ")){
            String[] str = input.split(" ");
            Node Compare = new CompareNode(str[1]);
            Compare.addChild(new ValueNode(str[0]));
            Compare.addChild(new ValueNode(str[2]));
            conditions.addChild(Compare);



            return;

        }


        Stack stack = new Stack();

        String root_temp = "";
        int index = 0;
        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) == '(') {
                stack.push(input.charAt(i));
            }else if(input.charAt(i) == ')'){
                stack.pop();
                if(stack.empty() == true) {
                    index = i + 2;
                    root_temp = String.valueOf(input.charAt(index));
                    break;
                }
            }
        }
        String left = input.substring(1, index - 2);
        String right = input.substring(index + 3, input.length() - 1);

        //root_temp = root_temp.equals("a")? " and ": " or ";
        conditions = new SetNode(root_temp.equals("a")? " and ": " or ");
        function(left, query, root_temp, conditions);
        function(right, query, root_temp, conditions);

        query.addChild(conditions);

        //return left + root_temp + right;
    }
}
