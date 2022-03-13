package algorithm.multipleWayRecursion;

import java.util.ArrayList;
import java.util.List;

public class FlattenList {
    // @param nestedList a list of NestedInteger
    // @return a list of integer
    public List<Integer> flatten(List<NestedInteger> nestedList) {
        List<Integer> result = new ArrayList<>();
        for (NestedInteger element : nestedList) {
            if (element.isInteger()) {
                result.add(element.getInteger());
            }
            else {
                result.addAll(flatten(element.getList()));
            }
        }
        return result;
    }
}

interface NestedInteger {
    // @return true if this NestedInteger holds a single integer,
    // rather than a nested list.
    boolean isInteger();

    // @return the single integer that this NestedInteger holds,
    // if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    Integer getInteger();

    // @return the nested list that this NestedInteger holds,
    // if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    List<NestedInteger> getList();
}