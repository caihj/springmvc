package jetty;

/**
 * Created by chj on 2016/4/6.
 */


class App extends WeightUtil.Weight {

    public int weight;

    public App(int weight)
    {
        this.weight = weight;
    }
    @Override
    public int getWeight() {
        return this.weight;
    }
}

public class WeightUtilMain {
    public static void main(String [] args)
    {
        WeightUtil<App> a=new WeightUtil<App>();

        a.AddEle(new App(1));
        a.AddEle(new App(2));
        a.AddEle(new App(3));

        for(int i=0;i<12;i++)
        {
            System.out.println(a.getNext().getWeight());
        }

    }
}
