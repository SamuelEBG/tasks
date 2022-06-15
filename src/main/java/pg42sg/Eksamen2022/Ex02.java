package pg42sg.Eksamen2022;

import org.pg4200.les09.UndirectedGraph;

import java.util.*;

public class Ex02<V> extends UndirectedGraph<V> {

    protected Map<V, Set<V>> metro = new HashMap<>();
    protected Map<V, Set<V>> tram = new HashMap<>();

    public List<V> findPath(V start, V end){

        if(!metro.containsKey(start) || !tram.containsKey(start)){
            return Collections.emptyList();
        }

        if(start.equals(end)){
            throw new IllegalArgumentException("You are already at your destination.");
        }

        List<V> paths = new ArrayList<>();

        Deque<V> stack = new ArrayDeque<>();

        findPathWithDfs(paths, stack, start, end);

        return paths;
    }

    private void findPathWithDfs(List<V> paths,
                                 Deque<V> stack,
                                 V currentNode,
                                 V endNode){
        stack.push(currentNode);

        if(isThisAPath(stack, endNode)){

        }
    }

    private boolean isThisAPath(Deque<V> stack, V endNode){
        return !stack.isEmpty() && stack.peek().equals(endNode);
    }

}
