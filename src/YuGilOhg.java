public class YuGilOhg
{
    private Menu menu;
    private Board board;
    private Player[] players = new Player[2];

    private YuGilOhg()
    {
        board = new Board();
        menu = new Menu();
        players[0] = new Player(0);
        players[1] = new Player(1);
    }

    private void play()
    {
        board.startGame(players[0], players[1]);
        int option;
        do
        {
            option = 0;
            new GestorIO().out("\nTurno de Jugador: " + board.getPlayerNumber());
            menu.show();
            while (option != 7)
            {
                option = menu.getOption();
                players[board.getActivePlayer().getNumber()]
                        .makePlay(option, board.getOpponentPlayer());
            }
            board.nextPlayer();
        } while (!board.isGameOver());
    }

    public static void main(String[] args)
    {
        new YuGilOhg().play();
    }
}
