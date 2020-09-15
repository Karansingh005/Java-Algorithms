import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {

    public static void main(String args[]){
        int[] wt = {10,40,20,30};
        int[] val = {60,40,100,120};
        int capacity = 50;

        double max = getMaxProfit(wt,val,capacity);

        System.out.print("The maximum possible profit is: "+ max);
    }

    private static double getMaxProfit(int[] wt, int[] val, int capacity) {
        Item[] items = new Item[wt.length];
        for (int i=0; i<items.length; i++){
            items[i] = new Item(wt[i],val[i], i);
        }
        Arrays.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o2.cost.compareTo(o1.cost);
            }
        });
        double totalValue = 0d;
        for (Item item: items){
            int curWT = (int)item.wt;
            int curVal = (int)item.val;

            if(capacity - curWT >= 0){
                capacity = capacity - curWT;
                totalValue+=curVal;
            }
            else {
                double fraction = (double)capacity/(double)curWT;
                totalValue += curVal * fraction;
                break;
            }
        }
        return totalValue;
    }

    static class Item{
        Double cost;
        double wt, val, ind;

        public Item(double wt, double val, double ind) {
            this.wt = wt;
            this.val = val;
            this.ind = ind;

            this.cost = Double.valueOf(val/wt);
        }

    }
}
