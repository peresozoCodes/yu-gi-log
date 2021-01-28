import java.util.Random;

public class Board
{
    private Player activePlayer;
    private Player opponentPlayer;
    private Player winner;
    private int playerNumber;

    public Board() {

        MonsterCard.setBoard(this);
        playerNumber = 1;

    }

    public void whoStarts(Player p1, Player p2) {

        Random r = new Random();

        if (r.nextInt(2) == 0) {
            activePlayer = p1;
            opponentPlayer = p2;
        } else {
            activePlayer = p2;
            opponentPlayer = p1;
        }

    }

    public void startGame(Player p1, Player p2) {

        p1.addNCardsToHand(5);
        p2.addNCardsToHand(5);

        this.whoStarts(p1, p2);

        activePlayer.addCardToHand();

    }

    public void nextPlayer() {

        Player temp = activePlayer;
        activePlayer = opponentPlayer;
        opponentPlayer = temp;
        activePlayer.addCardToHand();

        changePlayerNumber();

    }

    public boolean isGameOver() {
        return winner != null;
    }

    public Player getActivePlayer() {
        return activePlayer;
    }

    public void setActivePlayer(Player activePlayer) {
        this.activePlayer = activePlayer;
    }

    public Player getOpponentPlayer() {
        return opponentPlayer;
    }

    public void setOpponentPlayer(Player opponentPlayer) {
        this.opponentPlayer = opponentPlayer;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        if (isGameOver())
            return;
        this.winner = winner;
    }

    private void changePlayerNumber()
    {
        if (playerNumber == 1)
            playerNumber = 2;
        else
            playerNumber = 1;
    }

    public int getPlayerNumber()
    {
        return playerNumber;
    }

}
