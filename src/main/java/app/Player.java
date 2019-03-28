package app;

import java.util.Objects;

public class Player {
    private String nickName;

    public Player(String nickName) {
        if (nickName == null) {
            throw new IllegalArgumentException("nickName");
        }
        this.nickName = nickName;
    }

    public String getNickname() {
        return nickName;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Player)) {
            return false;
        }
        Player otherPlayer = (Player) other;
        return otherPlayer.nickName == nickName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nickName);
    }


}