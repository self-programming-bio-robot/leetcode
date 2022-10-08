class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;
        
        Map<Integer, Set<Integer>> graph = new HashMap();
        Map<Integer, Set<Integer>> stops = new HashMap();
        
        for (int i = 0; i < routes.length; i++) {
            Set<Integer> next = graph.getOrDefault(i, new HashSet());
            for (int p: routes[i]) {
                Set<Integer> s = stops.getOrDefault(p, new HashSet());
                for (int j: s) {
                    next.add(j);
                    Set<Integer> nn = graph.getOrDefault(j, new HashSet());
                    nn.add(i);
                    graph.put(j, nn);
                }
                s.add(i);
                stops.put(p, s);
            }
            graph.put(i, next);
        }
               
        Set<Integer> visited = new HashSet();
        Queue<Pair> q = new LinkedList();
        for (int i: stops.get(source)) {
            q.add(new Pair(i, 1));
        }
        
        while (!q.isEmpty()) {
            Pair r = q.poll();
            visited.add(r.i);
            for (int j: routes[r.i]) {
                if (j == target) return r.j;
            }
            for (int j: graph.get(r.i)) {
                if (!visited.contains(j)) {
                    q.add(new Pair(j, r.j+1));                
                }
            }
        }
        return -1;
    }
}

class Pair {
    public int i;
    public int j;
    
    public Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }
}
