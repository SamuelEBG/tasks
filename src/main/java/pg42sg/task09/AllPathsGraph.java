package pg42sg.task09;

import org.pg4200.les09.UndirectedGraph;

import java.util.*;

public class AllPathsGraph<T> extends UndirectedGraph<T> {

    public List<List<T>> findAllPaths(T start, T end){
        // If neither start nor end exists in the graph:
        // return an empty array, since paths = 0.
        if(!graph.containsKey(start) || !graph.containsKey(end)){
            return Collections.emptyList();
        }
        // We don't consider cyclic paths, therefor if the start and
        // end are equal, we do not want that path.
        if (start.equals(end)){
            throw new IllegalArgumentException("nei nei ikkje bra");
        }
        // List with all the paths we find in the graph with the given
        // start to finish nodes.
        List<List<T>> paths = new ArrayList<>();
        // This stack will keep track of the current node
        // and its adjacent nodes when we iterate through the graph.
        // Everytime we go to a new node, we push that node and its
        // adjacent nodes into the stack, then we iterate further
        // through each path until we reach our destination (end).
        // The pathsWithDfs method is getting called recursively so that
        // it returns to the "beginning" node in the stack, then we pop that
        // node and go on to the next one, after we have added that path to the list.
        Deque<T> stack = new ArrayDeque<>();

        pathsWithDfs(paths, stack, start, end);

        return paths;
    }

    private void pathsWithDfs(List<List<T>> paths,
                              Deque<T> stack,
                              T currentNode,
                              T endNode){
        // Whenever this method is called with a vertex,
        // push it onto the stack so that we know which node we are
        // working on.
        stack.push(currentNode);

        if(isThisAPath(stack, endNode)){
            List<T> path = new ArrayList<>(stack);
            Collections.reverse(path);
            paths.add(path);
            return;
        }
        // For loop that goes to the initial array of vertices(nodes)
        // and checks for each adjacent node and goes to that node to see if there is a path.
        // If that node is already in the stack i.e. when we go from X -> 0.
        // When we are at 0, it will go into this loop again from 0.
        // The only adjacent node from 0 is X, so the if-statement will be true,
        // and the for-loop will exit without recursing beyond 0,
        // it will go back to X, do a stack pop, which means it will remove
        // 0 from the stack, and iterate further in the adjacency nodes of X.
        for(T connected : getAdjacents(currentNode)){
            if(stack.contains(connected)){
                continue;
            }

            pathsWithDfs(paths, stack, connected, endNode);

            stack.pop();
        }
    }

    protected boolean isThisAPath(Deque<T> stack, T endNode){
        return !stack.isEmpty() && stack.peek().equals(endNode);
    }
}
