import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap();
        
        for (String x: words) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        
        return map.entrySet().stream()
            .sorted((a,b) -> {
                if (b.getValue() == a.getValue()) {
                    return a.getKey().compareTo(b.getKey());
                } else {
                    return b.getValue() - a.getValue();
                }
            })
            .limit(k)
            .map(it -> it.getKey())
            .collect(Collectors.toList());        
    }
}
