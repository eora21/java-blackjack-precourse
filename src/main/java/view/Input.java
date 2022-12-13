package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private final Output output;

    public Input(Output output) {
        this.output = output;
    }

    public String[] player() {
        output.requirePlayer();
        String[] playerNames = readLine().split(",");
        output.enter();
        return playerNames;
    }

    private String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new IllegalArgumentException("입출력에 문제가 있습니다.");
        }
    }
}
