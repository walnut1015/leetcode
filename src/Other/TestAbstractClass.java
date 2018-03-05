package Other;

import java.util.Enumeration;

/**
 * Created by Tanya on 2017/8/31.
 */
public class TestAbstractClass
{
    public abstract class A
    {
        public String value;
        public A(String value)
        {
            this.value = value;
        }
        public abstract void B();
    }
    public void func()
    {
        A a = new A("not abstract anymore") {
            @Override
            public void B() {
                System.out.println(this.value);
            }
        };
    }
    public enum Grade
    {
        A, B,C,Ｄ;
    }
    public void testGradeEnum()
    {
        Grade a = Grade.A;
        System.out.println(a.name());
        System.out.println(Enum.valueOf(Grade.class,"B").name());
        Grade []grades = Grade.values();
        for(Grade b:grades)
            System.out.println(b.name());
    }
}
