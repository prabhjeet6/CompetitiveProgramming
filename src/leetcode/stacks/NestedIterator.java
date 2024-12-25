package leetcode.stacks;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//https://leetcode.com/problems/flatten-nested-list-iterator/
public class NestedIterator implements Iterator<Integer> {
    private final List<NestedInteger> nestedList;

    private final Iterator<Integer> iterator;


    public NestedIterator(List<NestedInteger> nestedList) {
        this.nestedList = nestedList;
        List<Integer> flattendList = new ArrayList<>();
        processList(flattendList, nestedList);
        this.iterator = flattendList.iterator();
    }

    private void processList(List<Integer> flattendList, List<NestedInteger> nestedIntegerList) {
        for (int i = 0; i < nestedIntegerList.size(); i++) {
            NestedInteger nestedInteger = nestedIntegerList.get(i);
            if (nestedInteger.isInteger()) {
                flattendList.add(nestedInteger.getInteger());
            } else {
                processList(flattendList, nestedInteger.getList());
            }
        }
    }

    @Override
    public Integer next() {
        return this.iterator.next();
    }

    @Override
    public boolean hasNext() {
        return this.iterator.hasNext();
    }

}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */