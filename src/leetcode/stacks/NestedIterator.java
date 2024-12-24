package leetcode.stacks;

import java.util.Iterator;
import java.util.List;


public class NestedIterator implements Iterator<Integer> {

    private int currentIndex;
    private int currentSubIndex;
    private List<NestedInteger> nestedList;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.nestedList = nestedList;
        this.currentIndex = 0;
        this.currentSubIndex = 0;
    }

    @Override
    public Integer next() {
        NestedInteger current = nestedList.get(currentIndex);
        if (current.getList().isEmpty()) {
            currentIndex++;
            return current.getInteger();
        } else {
            currentSubIndex++;
            if(current.getList().size()>currentSubIndex){
                return current.getList().get(currentSubIndex).getInteger();
            }
        }
        return null;
    }


    @Override
    public boolean hasNext() {
        if (nestedList.isEmpty()) {
            return false;
        } else {
            NestedInteger current=nestedList.get(currentIndex);
            if (current.isInteger()) {
                return true;
            } else if (!current.getList().isEmpty() ) {
                if(currentSubIndex<current.getList().size()){
                    return true;
                }
                else{
                    currentSubIndex=0;
                    return false;
                }
            }
        }
        return false;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */