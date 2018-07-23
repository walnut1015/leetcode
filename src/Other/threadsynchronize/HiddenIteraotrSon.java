package Other.threadsynchronize;

/**
 * @author tanya
 * @date 2018/7/16 14:39
 */
public class HiddenIteraotrSon extends HiddenIterator{
    private void privateFatherFunc(){
        System.out.println("I'm son");
    }
    @Override
    public void addTenThings(){
        privateFatherFunc();
    }
}
