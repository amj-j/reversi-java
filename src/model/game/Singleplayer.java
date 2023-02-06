package model.game;

import java.util.ArrayList;

import structures.*;
import model.GameOverException;
import model.DefaultSettings;
import interfaces.ReversiModelListener;

public class Singleplayer extends Game {
    Owner bot = DefaultSettings.BOT;
    Owner player = bot.opponent();

    public Singleplayer(int boardSize, ArrayList<ReversiModelListener> listeners) {
        super(boardSize, listeners);
    }
    
    @Override
    public void playTurn(Coords chosenTile) throws GameOverException {
        if (!canPlay(chosenTile)) {
            return;
        }
        sendRemovePlayableTiles();
        BoardChange boardChange = play(player, chosenTile);
        sendBoardChange(boardChange);
        if (isBoardFull()) {
            sendGameOver(getWinner());
        }
        boolean botPassed = playBot();
        setPlayableTiles(player);
        if (playableTiles.isEmpty()) {
            sendPassMove(player);
            if (botPassed) {
                sendGameOver(player);
                return;
            }
        }
        sendPlayableTiles();
    }

    public boolean playBot() throws GameOverException {
        setPlayableTiles(bot);
        if (playableTiles.isEmpty()) {
            sendPassMove(bot);
            return true;
        }
        Coords bestMove = calcBestMove(bot);
        sendStall(1000);
        BoardChange boardChange = play(bot, bestMove);
        sendBoardChange(boardChange);
        if (isBoardFull()) {
            sendGameOver(getWinner());
        }
        return false;
    }
}
