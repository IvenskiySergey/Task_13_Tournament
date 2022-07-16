package ru.netology.statistic;

import java.util.ArrayList;
import java.util.Collection;

public class Game {
    private Collection<Player> players;

    public Game() {
        this.players = new ArrayList<>();
    }

    public void register(Player player) {
        if (players.contains(player) == true) {
            throw new RegisteredException("Игрок " + player + " уже зарегистрирован");
        }
        players.add(player);
    }

    public Player[] getAll() {
        return players.toArray(new Player[0]);
    }

    private Player findByName(String playerName) {
        for (Player player : players)
            if (player.getName() == playerName) {
                return player;
            }
        return null;
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = findByName(playerName1);
        if (player1 == null) {
            throw new NotRegisteredException("Игрок с именем " + playerName1 + " не зарегистрирован");
        }
        Player player2 = findByName(playerName2);
        if (player2 == null) {
            throw new NotRegisteredException("Игрок с именем " + playerName2 + " не зарегистрирован");
        }
        if (player1.getStrength() == player2.getStrength()) {
            return 0;
        }
        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        }
        return 2;
    }
}


