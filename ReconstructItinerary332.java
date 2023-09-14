import java.util.*;

public class ReconstructItinerary332 {
    public static void main(String[] args) {
        TestCase[] cases = new TestCase[] {
            new TestCase(
                List.of(
                    List.of("MUC","LHR"),
                    List.of("JFK","MUC"),
                    List.of("SFO","SJC"),
                    List.of("LHR","SFO")
                ),
                List.of("JFK","MUC","LHR","SFO","SJC")
            ),
            new TestCase(
                List.of(
                    List.of("JFK","SFO"),
                    List.of("JFK","ATL"),
                    List.of("SFO","ATL"),
                    List.of("ATL","JFK"),
                    List.of("ATL","SFO")
                ),
                List.of("JFK","ATL","JFK","SFO","ATL","SFO")
            ),
            new TestCase(
                List.of(
                    List.of("JFK","ATL"),
                    List.of("ATL","JFK")
                ),
                List.of("JFK","ATL","JFK")
            )
        };

        for (TestCase c: cases) {
            System.out.println(c);
            List<String> actual = new Solution().findItinerary(c.tickets);
            System.out.println("actual " + actual);
            if (!c.expected.equals(actual)) {
                System.out.println("Error");
                return;
            }
        }
    }
}

class TestCase {
    public List<List<String>> tickets;
    public List<String> expected;

    public TestCase(List<List<String>> tickets, List<String> expected) {
        this.tickets = tickets;
        this.expected = expected;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Test case: ");
        sb.append(tickets);
        sb.append("\n");
        sb.append("expected: ").append(expected);
        return sb.toString();
    }
}

class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new TreeMap<>();
        for (List<String> node: tickets) {
            String dep = node.get(0);
            String arr = node.get(1);
            if (!graph.containsKey(dep)) {
                graph.put(dep, new PriorityQueue<>());
            }
            graph.get(dep).add(arr);
        }

        LinkedList<String> itinerary = new LinkedList<>();
        
        dfs("JFK", graph, itinerary);
        
        return itinerary;
    }

    private void dfs(String dep, Map<String, PriorityQueue<String>>  graph, LinkedList<String> itinerary) {
        PriorityQueue<String> arr = graph.get(dep);

        while (arr != null && !arr.isEmpty()) {
            dfs(arr.poll(), graph, itinerary);
        }

        itinerary.addFirst(dep);
    }
}
