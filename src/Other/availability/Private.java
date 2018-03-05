package Other.availability;

/**
 * class: Private
 *
 * @author 刘天雅
 * @date 2018/02/25
 */
public class Private
{
    public Private(int a ){this.a = a;}
    private int a;
    public boolean isLarger(Private obj)
    {
        return a>obj.a?true:false;
    }
    public static void main(String[] args)
    {
        Private a1 = new Private(4);
        Private a2 = new Private(5);
        System.out.println(a1.isLarger(a2));
    }
}
