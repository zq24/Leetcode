package qinz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubdomainVisitCountSolution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String domain: cpdomains) {
            String[] splited = domain.split("\\s+");
            String wholeDomain = splited[1];
            int times = Integer.parseInt(splited[0]);
            if (!map.containsKey(wholeDomain)) {
                map.put(wholeDomain, times);
            } else {
                int oldTimes = map.get(wholeDomain);
                map.put(wholeDomain, oldTimes + times);
            }
            int first = wholeDomain.indexOf('.');
            String subDomainOne = wholeDomain.substring(first + 1);
            if (!map.containsKey(subDomainOne)) {
                map.put(subDomainOne, times);
            } else {
                int oldTimes = map.get(subDomainOne);
                map.put(subDomainOne, oldTimes + times);
            }
            int second = wholeDomain.indexOf('.', first + 1);
            if (second != -1) {
                String subDomainTwo = wholeDomain.substring(second + 1);
                if (!map.containsKey(subDomainTwo)) {
                    map.put(subDomainTwo, times);
                } else {
                    int oldTimes = map.get(subDomainTwo);
                    map.put(subDomainTwo, oldTimes + times);
                }
            }
        }

        List<String> res = new ArrayList<>();
        for (Map.Entry<String, Integer> entry: map.entrySet()){
            String countPair = entry.getValue() + " " + entry.getKey();
            res.add(countPair);
        }
        return res;
    }
}
