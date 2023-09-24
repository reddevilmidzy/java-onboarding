package onboarding;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Recommend recommend = new Recommend(new HashMap<>());

        return recommend.calculate(user, friends, visitors);

    }
}

class Recommend {

    HashMap<String, Integer> map;

    public Recommend(HashMap<String, Integer> map) {
        this.map = map;
    }

    public List<String> calculate(String user, List<List<String>> friends, List<String> visitors) {
        visitorsCalculator(visitors);
        List<String> followedWithUser = followedFriends(user, friends);
        newFriend(friends, followedWithUser);
        List<String> sorted = sortByValues();
        return commendList(user, sorted, followedWithUser);
    }

    private void visitorsCalculator(List<String> visitors) {
        for (String visitor : visitors) {
            plus(visitor, 1);
        }
    }

    private List<String> followedFriends(String user, List<List<String>> friends) {
        Map<String, List<String>> connection = friends.stream()
                .flatMap(friend -> Stream.of(new AbstractMap.SimpleEntry<>(friend.get(0), friend.get(1)),
                        new AbstractMap.SimpleEntry<>(friend.get(1), friend.get(0))))
                .collect(Collectors.groupingBy(Map.Entry::getKey,
                        Collectors.mapping(Map.Entry::getValue, Collectors.toList())));

        return connection.getOrDefault(user, Collections.emptyList());
    }

    private void newFriend(List<List<String>> friends, List<String> followedWithUser) {
        for (List<String> friend : friends) {
            String idA = friend.get(0);
            String idB = friend.get(1);

            if (followedWithUser.contains(idA) && !followedWithUser.contains(idB)) {
                plus(idB, 10);
            }

            if (followedWithUser.contains(idB) && !followedWithUser.contains(idA)) {
                plus(idA, 10);
            }
        }
    }

    private List<String> sortByValues() {
        List<String> sortedList = new ArrayList<>(map.keySet());
        Collections.sort(sortedList);
        sortedList.sort((value1, value2) -> (map.get(value2).compareTo(map.get(value1))));
        return sortedList;
    }

    private List<String> commendList(String user, List<String> sortedList, List<String> followedWithUser) {
        List<String> result = new ArrayList<>();
        int friendsNumber = 0;
        for (String friend : sortedList) {
            if (!followedWithUser.contains(friend) && !user.equals(friend)) {
                result.add(friend);
                friendsNumber += 1;
            }
            if (friendsNumber == 5) {
                return result;
            }
        }
        return result;
    }


    private void plus(String id, int point) {
        if (map.containsKey(id)) {
            map.put(id, map.get(id) + point);
        } else {
            map.put(id, point);
        }
    }
}