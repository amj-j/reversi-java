package model.game;

import structures.*;
import model.GameOverException;
import model.DefaultSettings;

public class Singleplayer extends Game {
    Owner bot = DefaultSettings.BOT;
    Owner player = bot.opponent();

    public Singleplayer(int boardSize) {
        super(boardSize);
    }
    
    @Override
    public void playTurn(Coords chosenTile) throws GameOverException {
        if (!canPlay(chosenTile)) {
            return;
        }
        BoardChange boardChange = play(player, chosenTile);
        sendBoardChange(boardChange);
        if (isBoardFull()) {
            sendGameOver(getWinner());
        }
        boolean passed = playBot();
        setPlayableTiles(player);
        if (playableTiles.isEmpty()) {
            sendPassMove(player);
            if (passed) {
                sendGameOver(player);
                return;
            }
        }
        
    }

    public boolean playBot() throws GameOverException {
        setPlayableTiles(bot);
        if (playableTiles.isEmpty()) {
            sendPassMove(bot);
            return true;
        }
        Coords bestMove = calcBestMove(bot);
        BoardChange boardChange = play(bot, bestMove);
        sendBoardChange(boardChange);
        if (isBoardFull()) {
            sendGameOver(getWinner());
        }
        return false;
    }
}
