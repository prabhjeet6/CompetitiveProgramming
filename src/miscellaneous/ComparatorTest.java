package miscellaneous;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorTest {
    public static void main(String [] args){
        List<Person> list=new ArrayList<>();
        list.add(new Person("Prabhjeet","Singh"));
        list.add(new Person("A","Z"));
        list.add(new Person("Z","A"));
        //Collections.sort(list,new PersonComparator());
        Collections.sort(list);
        System.out.println(list);

    }

}
class Person implements Comparable<Person>{

    @Override
    public int compareTo(Person o) {
        return this.secondName.compareTo(o.secondName);
    }
    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                '}';
    }

    Person(String firstName, String secondName){
        this.firstName=firstName;
        this.secondName=secondName;
    }

    String firstName;
    String secondName;

}
class PersonComparator implements Comparator<Person>{

    @Override
    public int compare(Person o1, Person o2) {
       return o1.secondName.compareTo(o2.secondName);
    }
}






