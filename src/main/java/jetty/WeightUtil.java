package jetty;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by chj on 2016/4/6.
 */

public class WeightUtil <T extends WeightUtil.Weight> {



    private Set<T> ele=new TreeSet<T>();

    public T getNext()
    {
        if (ele.size()>0)
        {
            Iterator<T> ite=ele.iterator();
            T r=ite.next();
            ite.remove();
            r.setHasGet(r.getHasGet()+1);
            ele.add(r);
            return r;
        }

        return null;
    }

    public void AddEle(T e)
    {
        this.ele.add(e);
    }

    public static abstract class Weight implements Comparable
    {
        abstract public int  getWeight();

        private int hasGet=0;

        public int getHasGet() {
            return hasGet;
        }

        @Override
        public int compareTo(Object o) {
            if ( ((Weight)o).getHasGet()==0 && this.getHasGet() == 0 )
                return Integer.compare(((Weight) o).getWeight(),this.getWeight());
            else
                return Integer.compare(this.getHasGet()*((Weight)o).getWeight(),((Weight)o).getHasGet()*this.getWeight());
        }

        public void setHasGet(int hasGet) {
            this.hasGet = hasGet;
            if(this.hasGet == getWeight())
                this.hasGet = 0;
        }
    }

}


