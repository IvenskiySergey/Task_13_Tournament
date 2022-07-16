package ru.netology.statistic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameTest {
    Player player = new Player(111, "Serge", 500);
    Player player1 = new Player(121, "Alex", 400);
    Player player2 = new Player(131, "Dima", 200);
    Player player3 = new Player(141, "Sofi", 300);
    Player player4 = new Player(151, "Katrin", 500);

    @Test
    public void registerTest() {
        Game game = new Game();
        game.register(player);
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);

        Player[] actual = game.getAll();
        Player[] expected = {player, player1, player2, player3, player4};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void failedRegistrationTest() {
        Game game = new Game();
        game.register(player);
        game.register(player1);
        game.register(player2);

        assertThrows(RegisteredException.class, () -> {
            game.register(player2);
        });
    }

    @Test
    public void nullPlayer1() {
        Game game = new Game();
        game.register(player);
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);

        assertThrows(NotRegisteredException.class, () -> {
            game.round("Boris", "Serge");
        });
    }

    @Test
    public void nullPlayer2() {
        Game game = new Game();
        game.register(player);
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);

        assertThrows(NotRegisteredException.class, () -> {
            game.round("Serge", "Boris");
        });
    }

    @Test
    public void draw() {
        Game game = new Game();
        game.register(player);
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);

        Assertions.assertEquals(0, game.round("Serge", "Katrin"));
    }

    @Test
    public void player1Win() {
        Game game = new Game();
        game.register(player);
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);

        Assertions.assertEquals(1, game.round("Serge", "Alex"));
    }

    @Test
    public void player2Win() {
        Game game = new Game();
        game.register(player);
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);

        Assertions.assertEquals(2, game.round("Dima", "Sofi"));
    }
}
