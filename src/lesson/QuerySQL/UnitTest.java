package lesson.QuerySQL;
import org.junit.Test;

public class UnitTest {

    @Test
    public void TestKeyword(){
        Node query = new SetNode(" ");
        query.addChild(new KeywordNode("Select"));
        System.out.println(query.toString());

        Node fields = new SetNode(",");
        Node tables = new SetNode(",");
        fields.addChild(new ValueNode("UserId"));
        fields.addChild(new ValueNode("Age"));
        query.addChild(fields);
        System.out.println(query.toString());

        //fields.addChild(new ValueNode("ID from data_table"));
        query.addChild(new KeywordNode("From"));
        System.out.println(query.toString());

        tables.addChild(new ValueNode("Customer"));
        query.addChild(tables);

        query.addChild(new KeywordNode("order by"));
        System.out.println(query.toString());

        Node orders = new SetNode(",");
        orders.addChild(new ValueNode("UserId"));
        query.addChild(orders);

        System.out.println(query.toString());
    }

    @Test
    public void TestCompareAnd(){

        Node query = new SetNode( " ");
        //测试and逻辑
        Node conditioins = new SetNode(" and ");
        Node ageCompare = new CompareNode(">=");
        ageCompare.addChild(new ValueNode("age"));
        ageCompare.addChild(new ValueNode("41"));
        conditioins.addChild(ageCompare);


        Node levelCompare = new CompareNode("<");
        levelCompare.addChild(new ValueNode("level"));
        levelCompare.addChild(new ValueNode("9"));
        conditioins.addChild(levelCompare);
        query.addChild(conditioins);

        System.out.println(query.toString().substring(1, query.toString().length() - 1));
    }

    @Test
    public void TestCompareOr(){

        Node query = new SetNode( " ");

        //测试or逻辑
        Node conditioins = new SetNode(" or ");
        Node ageCompare = new CompareNode(">=");
        ageCompare.addChild(new ValueNode("age"));
        ageCompare.addChild(new ValueNode("41"));
        conditioins.addChild(ageCompare);


        Node levelCompare = new CompareNode("<");
        levelCompare.addChild(new ValueNode("level"));
        levelCompare.addChild(new ValueNode("9"));
        conditioins.addChild(levelCompare);
        //query.addChild(conditioins);


        Node CompanyCompare = new CompareNode("=");
        CompanyCompare.addChild(new ValueNode("Company"));
        CompanyCompare.addChild(new ValueNode("HTSC"));
        conditioins.addChild(CompanyCompare);
        //query.addChild(conditioins);

        Node PhoneNumCompare = new CompareNode("like");
        PhoneNumCompare.addChild(new ValueNode("PhoneNum"));
        PhoneNumCompare.addChild(new ValueNode("'0%'"));
        conditioins.addChild(PhoneNumCompare);
        query.addChild(conditioins);



        System.out.println(query.toString().substring(1, query.toString().length() - 1));
    }

    @Test
    public void TestCompareMixed(){

        Node query = new SetNode( " and ");

        //测试and逻辑
        SetNode conditioins = new SetNode(" and ");


        Node ageCompare = new CompareNode(">=");
        ageCompare.addChild(new ValueNode("age"));
        ageCompare.addChild(new ValueNode("30"));
        conditioins.addChild(ageCompare);


        Node levelCompare = new CompareNode(">");
        levelCompare.addChild(new ValueNode("height"));
        levelCompare.addChild(new ValueNode("170cm"));
        conditioins.addChild(levelCompare);

        query.addChild(conditioins);


        //混合添加测试or逻辑
        conditioins = new SetNode(" or ");

        Node CompanyCompare = new CompareNode("=");
        CompanyCompare.addChild(new ValueNode("Company"));
        CompanyCompare.addChild(new ValueNode("HTSC"));
        conditioins.addChild(CompanyCompare);

        Node PhoneNumCompare = new CompareNode("like");
        PhoneNumCompare.addChild(new ValueNode("PhoneNum"));
        PhoneNumCompare.addChild(new ValueNode("'0%'"));
        conditioins.addChild(PhoneNumCompare);

        query.addChild(conditioins);

        System.out.println(query.toString().substring(1, query.toString().length() - 1));
    }

}
