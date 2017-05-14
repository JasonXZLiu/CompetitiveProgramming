package com.jason.dontBeLast;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Jason on 1/16/2017.
 */
public class Cow implements Comparator<Cow> {
    String name;
    int milk;
    private boolean needDelete;

    public String getName () {return name;}

    public int getMilk () {return milk;}

    public void setName(String name) {
        this.name = name;
    }

    public void setMilk(int milk) {
        this.milk = milk;
    }

    public void setNeedDelete(boolean needDelete) {this.needDelete = needDelete;}

    public boolean getNeedDelete() {
        return needDelete;
    }

    @Override
    public int compare(Cow o1, Cow o2) {
        int a = o1.milk - o2.milk;
        if (a == 0) {
            return (o1.name).compareTo(o2.name);
        }
        return a;
    }

    @Override
    public String toString() {
        return this.getName() + " " + this.getMilk();
    }


}
