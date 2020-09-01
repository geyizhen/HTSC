package lesson.QuerySQL_new;

import org.junit.Assert;
import org.junit.Test;

public class UnitTest {

    @Test
    public void TestEqual(){
        Assert.assertEquals("Select * From Customer Where (UserId = 000001)",
                SQLGene.check("UserId = 000001"));
        Assert.assertEquals("Select * From Customer Where (age = 30)",
                SQLGene.check("age = 30"));
        Assert.assertEquals("Select * From Customer Where (Height = 170)",
                SQLGene.check("Height = 170"));
        Assert.assertEquals("Select * From Customer Where (CompanyName = HTSC)",
                SQLGene.check("CompanyName = HTSC"));
        Assert.assertEquals("Select * From Customer Where (PhoneNum = 0123456)",
                SQLGene.check("PhoneNum = 0123456"));
    }

    @Test
    public void TestNotEqual(){
        Assert.assertEquals("Select * From Customer Where (UserId != 000001)",
                SQLGene.check("UserId != 000001"));
        Assert.assertEquals("Select * From Customer Where (age != 30)",
                SQLGene.check("age != 30"));
        Assert.assertEquals("Select * From Customer Where (Height != 170)",
                SQLGene.check("Height != 170"));
        Assert.assertEquals("Select * From Customer Where (CompanyName != HTSC)",
                SQLGene.check("CompanyName != HTSC"));
        Assert.assertEquals("Select * From Customer Where (PhoneNum != 0123456)",
                SQLGene.check("PhoneNum != 0123456"));
    }
    @Test
    public void TestGreaterThan(){
        Assert.assertEquals("Select * From Customer Where (UserId > 000001)",
                SQLGene.check("UserId > 000001"));
        Assert.assertEquals("Select * From Customer Where (age > 30)",
                SQLGene.check("age > 30"));
        Assert.assertEquals("Select * From Customer Where (Height > 170)",
                SQLGene.check("Height > 170"));
    }

    @Test
    public void TestGreaterEqualThan(){
        Assert.assertEquals("Select * From Customer Where (UserId >= 000001)",
                SQLGene.check("UserId >= 000001"));
        Assert.assertEquals("Select * From Customer Where (age >= 30)",
                SQLGene.check("age >= 30"));
        Assert.assertEquals("Select * From Customer Where (Height >= 170)",
                SQLGene.check("Height >= 170"));
    }

    @Test
    public void TestLessThan(){Assert.assertEquals("Select * From Customer Where (UserId < 000001)",
            SQLGene.check("UserId < 000001"));
        Assert.assertEquals("Select * From Customer Where (age < 30)",
                SQLGene.check("age < 30"));
        Assert.assertEquals("Select * From Customer Where (Height < 170)",
                SQLGene.check("Height < 170"));
    }

    @Test
    public void TestLessEqualThan(){
        Assert.assertEquals("Select * From Customer Where (UserId = 000001)",
                SQLGene.check("UserId <= 000001"));
        Assert.assertEquals("Select * From Customer Where (age <= 30)",
                SQLGene.check("age <= 30"));
        Assert.assertEquals("Select * From Customer Where (Height <= 170)",
                SQLGene.check("Height <= 170"));
    }


    @Test
    public void TestAnd(){
        Assert. assertEquals("Select * From Customer Where ((age >= 30) and (height > 170cm))",
                SQLGene.check("(age >= 30) and (height > 170cm)"));
        Assert. assertEquals("Select * From Customer Where ((age = 30) and (Company = HTSC))",
                SQLGene.check("(age = 30) and (Company = HTSC)"));
        Assert. assertEquals("Select * From Customer Where ((age != 30) and (PhoneNum like '0%'))",
                SQLGene.check("(age != 30) and (PhoneNum like '0%')"));
        Assert. assertEquals("Select * From Customer Where ((age < 30) and (PhoneNum like '0%'))",
                SQLGene.check("(age < 30) and (PhoneNum like '0%')"));
        Assert. assertEquals("Select * From Customer Where ((Height > 170) and (PhoneNum like '0%'))",
                SQLGene.check("(Height > 170) and (PhoneNum like '0%')"));
    }

    @Test
    public void TestOr(){
        Assert. assertEquals("Select * From Customer Where ((age >= 30) or (height > 170cm))",
                SQLGene.check("(age >= 30) or (height > 170cm)"));
        Assert. assertEquals("Select * From Customer Where ((age = 30) or (Company = HTSC))",
                SQLGene.check("(age = 30) or (Company = HTSC)"));
        Assert. assertEquals("Select * From Customer Where ((age != 30) or (PhoneNum like '0%'))",
                SQLGene.check("(age != 30) or (PhoneNum like '0%')"));
        Assert. assertEquals("Select * From Customer Where ((age < 30) or (PhoneNum like '0%'))",
                SQLGene.check("(age < 30) or (PhoneNum like '0%')"));
        Assert. assertEquals("Select * From Customer Where ((Height > 170) or (PhoneNum like '0%'))",
                SQLGene.check("(Height > 170) or (PhoneNum like '0%')"));
    }

    @Test
    public void TestAndOR(){
        Assert. assertEquals("Select * From Customer Where ((age = 30) or (Height = 170)) and ((Company = HTSC))",
                SQLGene.check("((age = 30) or (Height = 170)) and (Company = HTSC)"));
        Assert. assertEquals("Select * From Customer Where ((Height = 170) or (Company = HTSC)) and ((age = 30))",
                SQLGene.check("(age = 30) and ((Height = 170) or (Company = HTSC))"));
        Assert. assertEquals("Select * From Customer Where ((age = 30) and (Height = 170)) and ((Company = HTSC) or (PhoneNum like '0%'))",
                SQLGene.check("((age = 30) and (Height = 170)) and ((Company = HTSC) or (PhoneNum like '0%'))"));
        Assert. assertEquals("Select * From Customer Where ((age = 30) or (Height = 170)) and ((Company = HTSC) and (PhoneNum like '0%'))",
                SQLGene.check("((age = 30) or (Height = 170)) and ((Company = HTSC) and (PhoneNum like '0%'))"));
        Assert. assertEquals("Select * From Customer Where ((age > 30) or (Height != 170)) and ((Company != HTSC) and (PhoneNum like '0%'))",
                SQLGene.check("((age > 30) or (Height != 170)) and ((Company != HTSC) and (PhoneNum like '0%'))"));

    }

    @Test
    public void TestAndOr2(){

    }

}
