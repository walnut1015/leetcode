package Other.responsibilitychainmode;


import java.util.LinkedList;
import java.util.List;

/**
 * Created by Tanya on 2017/8/31.
 * Lily想请人吃饭，但是吝啬的她要求对方点菜的总价不高于s，对方想点k道菜，店中一共有m道菜。
 * 问总共有多少种点菜选择？
 */
public class MeanLily
{
    public int orderFood(List<List<Integer>> input)
    {
        int maxMoney = input.get(0).get(0);
        int orderDishes = input.get(0).get(1);
        int totalDishes = input.get(0).get(2);
        if(orderDishes>totalDishes)
            return 0;
        List<Integer> prices = new LinkedList<>();
        for (int i = 0;i<totalDishes;i++)
            prices.add(input.get(i+1).get(0));
        return orderfood(maxMoney,orderDishes,prices);
    }
    private int orderfood(int maxMoney, int orderDishes, List<Integer> prices)
    {
        if(orderDishes<1)
            return 0;
        if(orderDishes>prices.size())
            return 0;
        int res=0;
        for(int i = 0;i<prices.size();i++)
        {
            int temp = prices.get(i);
            if(temp<maxMoney)
            {
                prices.remove(i);
                res = res+ 1 + orderfood(maxMoney - temp, orderDishes-1,prices);
                prices.add(i,temp);
            }
        }
        return res;
    }
}
