package pg42sg.task09;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AllPathsGraphTest {

    @Test
    public void testAllPathsFromXto5(){

        AllPathsGraph<String> graph = new AllPathsGraph<>();
        graph.addEdge("0","X");
        graph.addEdge("X","1");
        graph.addEdge("X","Y");
        graph.addEdge("1","2");
        graph.addEdge("2","Y");
        graph.addEdge("1","3");
        graph.addEdge("3","4");
        graph.addEdge("3","5");
        graph.addEdge("4","5");

        List<List<String>> paths = graph.findAllPaths("X","5");
        assertEquals(4, paths.size());
        assertTrue(paths.stream().anyMatch(p -> p.size() == 4));
        assertTrue(paths.stream().anyMatch(p -> p.size() == 5));
        assertTrue(paths.stream().anyMatch(p -> p.size() == 6));
        assertTrue(paths.stream().anyMatch(p -> p.size() == 7));
    }
}