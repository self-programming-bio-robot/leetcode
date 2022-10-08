class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap();
        Set<Integer> started = new HashSet();
        int[] indegree = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new LinkedList()); 
            started.add(i);
        }
        
        for (int[] p: prerequisites) {
            graph.get(p[1]).add(p[0]);
            started.remove(p[0]);
            indegree[p[0]] += 1;
        }
        
        if (started.isEmpty()) return new int[0];
        
        Queue<Integer> q = new LinkedList(started);
        int[] res = new int[numCourses];
        int i = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            res[i++] = node;
            
            List<Integer> neighbors = graph.get(node);
            for (int n: neighbors) {
                indegree[n]--;
                
                if (indegree[n] == 0) {
                    q.add(n);
                }
            }
        }  
        
        if (i == numCourses) return res;
        
        return new int[0];
    }
}
