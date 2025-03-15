/*
import java.lang.*;
import java.util.*;
interface Item<K>{ K getCustomField();}
class Item1 implements Item<Integer> {
int custom1;
public Item1(int c){this.custom1=c;}
@Override
public Integer getCustomField() {return this.custom1;}
}
class Item2 implements Item<Double> {
double custom1;
public Item2(double c){this.custom1=c;}
@Override
public Double getCustomField() {return this.custom1;}
}
class Item3 implements Item<Float> {
float custom1;
public Item3(float c){this.custom1=c;}
@Override
public Float getCustomField() {return this.custom1;}
}
public class DRY{
public static List<Item1> sortAscendingItem1(List<Item1> p){
List<Item1> cl = new ArrayList<Item1>(p);
for(int i=0;i<cl.size()-1;i++) for (int j=i+1;j<cl.size();j++) if (cl.get(i).getCustomField() > cl.get(j).getCustomField()) Collections.swap(cl, i, j);
return cl;
}
public static List<Item2> sortAscendingItem2(List<Item2> p){
List<Item2> cl = new ArrayList<Item2>(p);
for(int i=0;i<cl.size()-1;i++) for (int j=i+1;j<cl.size();j++) if (cl.get(i).getCustomField() > cl.get(j).getCustomField()) Collections.swap(cl, i, j);
return cl;
}
public static List<Item3> sortAscendingItem3(List<Item3> p){
List<Item3> cl = new ArrayList<Item3>(p);
for(int i=0;i<cl.size()-1;i++) for (int j=i+1;j<cl.size();j++) if (cl.get(i).getCustomField() > cl.get(j).getCustomField()) Collections.swap(cl, i, j);
return cl;
}
public static List<Item1> sortDescendingItem1(List<Item1> p){
List<Item1> cl = new ArrayList<Item1>(p);
for(int i=0;i<cl.size()-1;i++) for (int j=i+1;j<cl.size();j++) if (cl.get(i).getCustomField() < cl.get(j).getCustomField()) Collections.swap(cl, i, j);
return cl;
}
public static List<Item2> sortDescendingItem2(List<Item2> p){
List<Item2> cl = new ArrayList<Item2>(p);
for(int i=0;i<cl.size()-1;i++) for (int j=i+1;j<cl.size();j++) if (cl.get(i).getCustomField() < cl.get(j).getCustomField()) Collections.swap(cl, i, j);
return cl;
}
public static List<Item3> sortDescendingItem3(List<Item3> p){
List<Item3> cl = new ArrayList<Item3>(p);
for(int i=0;i<cl.size()-1;i++) for (int j=i+1;j<cl.size();j++) if (cl.get(i).getCustomField() < cl.get(j).getCustomField()) Collections.swap(cl, i, j);
return cl;
}
}
*/

import java.lang.*;
import java.util.*;

// used better naming and included spacing and indentation
interface ElementInterface<K extends Comparable<K>> { // adding comparable so we can use comparison operator on generic
    K getCustomField();
}

// used better naming and included spacing and indentation, together with using wrapper classes
class IntegerElement implements ElementInterface<Integer> {
    Integer intCustomField;

    public IntegerElement(Integer intCustomField) {
        this.intCustomField = intCustomField;
    }

    @Override
    public Integer getCustomField() {
        return this.intCustomField;
    }
}

// used better naming and included spacing and indentation, together with using wrapper classes
class DoubleElement implements ElementInterface<Double> {
    Double doubleCustomField;

    public DoubleElement(Double doubleCustomField) {
        this.doubleCustomField = doubleCustomField;
    }
    @Override
    public Double getCustomField() {
        return this.doubleCustomField;
    }
}

// used better naming and included spacing and indentation, together with using wrapper classes
class FloatElement implements ElementInterface<Float> {
    Float floatCustomField;

    public FloatElement(Float floatCustomField) {
        this.floatCustomField = floatCustomField;
    }

    @Override
    public Float getCustomField() {
        return this.floatCustomField;
    }
}

public class DRY<K extends ElementInterface<V>, V extends Comparable<V>> {

    // used better naming and included spacing and indentation, together with using wrapper classes
    public List<K> sortElements(List<K> elements, Boolean isDescending) {
        // used generics to sort all types based on the interface and a bool parameter to decide the direction of sorting
        List<K> clonedList = new ArrayList<K>(elements);

        // implement a simple sorting algorithm with 2 fors
        for (Integer i = 0; i < clonedList.size() - 1; i++) {
            for (Integer j = i + 1; j < clonedList.size(); j++) {
                Boolean toSwap = false;
                Integer comparison = clonedList.get(i).getCustomField().compareTo(
                        clonedList.get(j).getCustomField()
                );

                if (isDescending && comparison < 0) {
                    toSwap = true;
                } else if (!isDescending && comparison > 0) {
                    toSwap = true;
                }

                if(toSwap) {
                    Collections.swap(clonedList, i, j);
                }
            }
        }

        return clonedList;
    }

}