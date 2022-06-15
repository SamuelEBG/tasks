package pg42sg.Eksamen2022;

import org.pg4200.les09.UndirectedGraph;

import java.util.*;

public class Ex02<V> extends UndirectedGraph<V> {
    /**
     The idea here was to use Depth-First Search to first look for a path with no changes of transport type.
     For each time we would pop from the stack and move forward to the next vertex we would also check
     if that same vertex exists in the other graph, if so we would call the findPath method for that graph, and try and combine
     the (possible) path that we find, if it would end up at the end-destination, together with the started path in the first graph.
     I tried to use 2 different methods for each transportation-method but failed to swap between them.
     */

    protected Map<V, Set<V>> metro = new HashMap<>();
    protected Map<V, Set<V>> tram = new HashMap<>();

    public List<List<V>> findPath(V start, V end){
        // If start location does not exist in either metro nor tram, return empty collection.
        if(!metro.containsKey(start) || !tram.containsKey(start)){
            return Collections.emptyList();
        }
        // Cyclic paths does not seem to be something we look for.
        if(start.equals(end)){
            throw new IllegalArgumentException("You are already at your destination.");
        }
        // A list with the path found from start to end destination, in this case it seems like we only want 1 path,
        // so we do not need a list of all paths from start to finish.
        List<List<V>> paths = new ArrayList<>();
        // Stack that keeps track of the node we are at and its adjacent nodes as we iterate through the graph.
        // Each time we go further in the graph, we push that node onto the stack, once we've reached the end of a line
        // we pop that node from the stack, would not have to save the path as long as it is not to the end destination.
        Deque<V> stack = new ArrayDeque<>();

        findPathWithDfs(paths, stack, start, end);

        return paths;
    }

    private void findPathWithDfs(List<List<V>> paths,
                                 Deque<V> stack,
                                 V currentNode,
                                 V endNode){
        // Push the vertex on to the stack, so we know which node we are working on.
        stack.push(currentNode);
        /*
            This will return true once we reach the end node, our destination.
            Once that happens, we create a list of the path taken (the stack).
            reverse it so that it will show the path in the right order,
            add it to our paths array that will be or end result, and return.
         */
        if(isThisAPath(stack, endNode)){
            List<V> path = new ArrayList<>(stack);
            Collections.reverse(path);
            paths.add(path);
            return;
        }
        /*
            Start by checking every adjacent vertex of the node where we begin.
            This for-loop will go through each of those nodes, and keep going
            down recursively until it meets a cycle, or it ends at a node that is not
            the desired endpoint.
         */
        /**
            This is where I fail to understand how to connect the 2 graphs.
         */
        for(V connected : getAdjacents(currentNode)){
            if(stack.contains(connected)){
                continue;
            }

            findPathWithDfs(paths, stack, connected, endNode);

            stack.pop();
        }
    }

    private boolean isThisAPath(Deque<V> stack, V endNode){
        return !stack.isEmpty() && stack.peek().equals(endNode);
    }

}
