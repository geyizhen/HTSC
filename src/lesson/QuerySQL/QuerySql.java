package lesson.QuerySQL;

import java.util.*;

public class QuerySql {

    public static Map<String, List> data_table;

    public static void main(String[] args) {

        QuerySql querySql = new QuerySql();
        querySql.init();


        //数据库打印
        System.out.println("Simple DataTable:");
        querySql.print(data_table);
        System.out.println();



        //模拟数据库查询
        System.out.println("Simulation query step by step:");
        Node query = new SetNode(" ");
        query.addChild(new Keyword("Select"));
        System.out.println(query.toString());

        Node fields = new SetNode(",");
        fields.addChild(new Value("*"));
        query.addChild(fields);
        System.out.println(query.toString());

        query.addChild(new Keyword("From"));
        Node tables = new SetNode(",");
        tables.addChild(new Value("Customer"));
        query.addChild(tables);
        System.out.println(query.toString());

        query.addChild(new Keyword("Where"));
        System.out.println(query.toString());

        //测试and逻辑
        Node conditioins = new SetNode(" and ");
        Node ageCompare = new Compare(">=");
        ageCompare.addChild(new Value("age"));
        ageCompare.addChild(new Value("30"));
        conditioins.addChild(ageCompare);


        Node levelCompare = new Compare(">");
        levelCompare.addChild(new Value("height"));
        levelCompare.addChild(new Value("170cm"));
        conditioins.addChild(levelCompare);
        query.addChild(conditioins);
        System.out.println(query.toString());


        //测试or逻辑
        query.addChild(new Value("and"));
        conditioins = new SetNode(" or ");

        Node CompanyCompare = new Compare("=");
        CompanyCompare.addChild(new Value("Company"));
        CompanyCompare.addChild(new Value("HTSC"));
        conditioins.addChild(CompanyCompare);

        Node PhoneNumCompare = new Compare("like ");
        PhoneNumCompare.addChild(new Value("PhoneNum"));
        PhoneNumCompare.addChild(new Value("'0%'"));
        conditioins.addChild(PhoneNumCompare);
        query.addChild(conditioins);
        System.out.println(query.toString());

        query.addChild(new Keyword("order by"));
        Node orders = new SetNode(",");
        orders.addChild(new Value("UserId"));
        query.addChild(orders);

        System.out.println(query.toString());

        System.out.println();
        System.out.println("Simulation query result:");
        querySql.print("000003");

    }



    private void print(Map<String, List> data_table) {
        for(String s : data_table.keySet()){
            String str = s;
            for(int i = 0; i < data_table.get(s).size(); i++){
                str += "     " + data_table.get(s).get(i);
            }
            System.out.println(str);
        }
    }

    private void print(String s) {
        String str = "";
        for(int i = 0; i < data_table.get(s).size(); i++){
            str += data_table.get("000000").get(i)  + ":" + data_table.get(s).get(i) + "  ";
        }
        System.out.println(str);
    }


    private void init() {
        List<String> list = new LinkedList<>();
        list.add("UserId");
        list.add("Age");
        list.add("Height");
        list.add("Company");
        list.add("PhoneNum");

        List<String> list1 = new LinkedList<>();
        list1.add("000001");
        list1.add("20");
        list1.add("170");
        list1.add("ICBC");
        list1.add("0123456");

        List<String> list2 = new LinkedList<>();
        list2.add("000002");
        list2.add("30");
        list2.add("180");
        list2.add("CICC");
        list2.add("6012345");

        List<String> list3 = new LinkedList<>();
        list3.add("000003");
        list3.add("35");
        list3.add("185");
        list3.add("HTSC");
        list3.add("5601234");

        data_table = new TreeMap<String, List>(){{
            put("000000", list);
            put("000001", list1);
            put("000002", list2);
            put("000003", list3);
        }};
    }
}
