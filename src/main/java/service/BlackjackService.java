package service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class BlackjackService {

    public List<String> validPlayerNames(String[] player) {
        List<String> players = new ArrayList<>(Arrays.asList(player));

        if (player.length != new HashSet<>(players).size()) {
            throw new IllegalArgumentException("중복된 이름이 있습니다.");
        }

        return players;
    }
}
