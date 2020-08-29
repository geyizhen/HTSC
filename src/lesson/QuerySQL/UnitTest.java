package lesson.QuerySQL;
import org.junit.Test;

public class UnitTest {

    @Test
    public void TestKeyword(){
        Node query = new SetNode(" ");
        query.addChild(new Keyword("Select"));
        System.out.println(query.toString());

        Node fields = new SetNode(",");
        Node tables = new SetNode(",");
        fields.addChild(new Value("UserId"));
        fields.addChild(new Value("Age"));
        query.addChild(fields);
        System.out.println(query.toString());

        //fields.addChild(new ValueNode("ID from data_table"));
        query.addChild(new Keyword("From"));
        System.out.println(query.toString());

        tables.addChild(new Value("Customer"));
        query.addChild(tables);

        query.addChild(new Keyword("order by"));
        System.out.println(query.toString());

        Node orders = new SetNode(",");
        orders.addChild(new Value("UserId"));
        query.addChild(orders);

        System.out.println(query.toString());
    }

    @Test
    public void TestCompareAnd(){

        Node query = new SetNode( " ");
        //测试and逻辑
        Node conditioins = new SetNode(" and ");
        Node ageCompare = new Compare(">=");
        ageCompare.addChild(new Value("age"));
        ageCompare.addChild(new Value("41"));
        conditioins.addChild(ageCompare);

        Node levelCompare = new Compare("<");
        levelCompare.addChild(new Value("level"));
        levelCompare.addChild(new Value("9"));
        conditioins.addChild(levelCompare);
        query.addChild(conditioins);

        System.out.println(query.toString().substring(1, query.toString().length() - 1));
    }

    @Test
    public void TestCompareOr(){

        Node query = new SetNode( " ");

        //测试or逻辑
        Node conditioins = new SetNode(" or ");
        Node ageCompare = new Compare(">=");
        ageCompare.addChild(new Value("age"));
        ageCompare.addChild(new Value("41"));
        conditioins.addChild(ageCompare);


        Node levelCompare = new Compare("<");
        levelCompare.addChild(new Value("level"));
        levelCompare.addChild(new Value("9"));
        conditioins.addChild(levelCompare);
        //query.addChild(conditioins);


        Node CompanyCompare = new Compare("=");
        CompanyCompare.addChild(new Value("Company"));
        CompanyCompare.addChild(new Value("HTSC"));
        conditioins.addChild(CompanyCompare);
        //query.addChild(conditioins);

        Node PhoneNumCompare = new Compare("like");
        PhoneNumCompare.addChild(new Value("PhoneNum"));
        PhoneNumCompare.addChild(new Value("'0%'"));
        conditioins.addChild(PhoneNumCompare);
        query.addChild(conditioins);



        System.out.println(query.toString().substring(1, query.toString().length() - 1));
    }

    @Test
    public void TestCompareMixed(){

        Node query = new SetNode( " and ");

        //测试and逻辑
        SetNode conditioins = new SetNode(" and ");


        Node ageCompare = new Compare(">=");
        ageCompare.addChild(new Value("age"));
        ageCompare.addChild(new Value("30"));
        conditioins.addChild(ageCompare);


        Node levelCompare = new Compare(">");
        levelCompare.addChild(new Value("height"));
        levelCompare.addChild(new Value("170cm"));
        conditioins.addChild(levelCompare);

        query.addChild(conditioins);


        //混合添加测试or逻辑
        conditioins = new SetNode(" or ");

        Node CompanyCompare = new Compare("=");
        CompanyCompare.addChild(new Value("Company"));
        CompanyCompare.addChild(new Value("HTSC"));
        conditioins.addChild(CompanyCompare);

        Node PhoneNumCompare = new Compare("like");
        PhoneNumCompare.addChild(new Value("PhoneNum"));
        PhoneNumCompare.addChild(new Value("'0%'"));
        conditioins.addChild(PhoneNumCompare);

        query.addChild(conditioins);

        System.out.println(query.toString().substring(1, query.toString().length() - 1));
    }

}
