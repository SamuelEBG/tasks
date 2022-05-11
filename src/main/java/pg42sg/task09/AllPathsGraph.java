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
        // This will run until the method has found all paths.
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
        // This will return true once we reach the end node, our destination.
        // Once that happends we create a list of the path taken (the stack).
        // reverse it so that it will show the path in the right order,
        // add it to our paths array that will be or end result, and return.
        // we still have nodes where we are going to check adjacency for further
        // paths that we have not yet found.
        if(isThisAPath(stack, endNode)){
            List<T> path = new ArrayList<>(stack);
            Collections.reverse(path);
            paths.add(path);
            return;
        }
        /*
            Start by checking every adjacent vertex of the node where we begin.
            This for-loop will go through each of those nodes, and keep going
            down recursively until it meets a cycle, or it ends at a node that is not
            the desired endpoint e.g. 5 in this task.
            For example when it starts from X, it will first try and go to 0.
            0 only has one adjacent node, X. So it will go back to X, and pop
            0 from the stack.
         */
        for(T connected : getAdjacents(currentNode)){
            if(stack.contains(connected)){
            // If the node that the loop checks is already in the stack, it will continue iterating
                // until there are no more adjacent nodes, then it will exit.
                continue;
            }
            // Found a node that is yet to be iterated through and not in the stack?
            // Let's go deeper.
            pathsWithDfs(paths, stack, connected, endNode);
            // Node came to a dead end? For example there are only nodes that
            // are already in the stack, or there are no more nodes to traverse to.
            // Then we recurse back, and pop that node from the stack.
            stack.pop();
        }
    }
    // If we finally arrive at our end node, this will return true, since the stack
    // will not be empty, and the stack.peek() will return our endNode.
    protected boolean isThisAPath(Deque<T> stack, T endNode){
        return !stack.isEmpty() && stack.peek().equals(endNode);
    }
}
