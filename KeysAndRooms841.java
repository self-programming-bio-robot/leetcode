class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> unseen = new HashSet<>();

        for (int i = 0; i < rooms.size(); i++) {
            unseen.add(i);
        }
        
        return dfs(rooms, unseen, 0);
    }

    private boolean dfs(List<List<Integer>> r, Set<Integer> u, int i) {
        if (!u.contains(i)) {
            return u.isEmpty();
        }
        u.remove(i);
        if (u.isEmpty()) {
            return true;
        }

        List<Integer> keys = r.get(i);
        for (int j: keys) {
            if (dfs(r, u, j)) {
                return true;
            }
        }

        return false;
    }
}
