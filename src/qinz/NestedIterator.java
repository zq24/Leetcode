package qinz;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NestedIterator implements Iterator<Integer> {

    Queue<Integer> queue = new LinkedList<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        numOfInt(nestedList);
    }

    private void numOfInt(List<NestedInteger> elements) {
        for (int i = 0; i < elements.size(); i++) {
            NestedInteger element = elements.get(i);
            if (element.isInteger()) {
                queue.add(element.getInteger());
            } else {
                numOfInt(element.getList());
            }
        }
    }

    @Override
    public Integer next() {
        return queue.poll();
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}