package qinz;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KeysAndRoomsSolution {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();
        canVisitAllRoomsHelper(rooms, visited, 0);
        if (visited.size() != rooms.size()) {
            return false;
        } else {
            return true;
        }
    }

    private void canVisitAllRoomsHelper(List<List<Integer>> rooms, Set<Integer> visited, int room) {
        if (visited.contains(room)) {
            return;
        }

        visited.add(room);

        for (int i = 0; i < rooms.get(room).size(); i++) {
            canVisitAllRoomsHelper(rooms, visited, rooms.get(room).get(i));
        }
    }
}
