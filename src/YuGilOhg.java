public class YuGilOhg
{
    private Menu menu;
    private Player[] players = new Player[2];
    private Turn turn;

    private YuGilOhg()
    {
        menu = new Menu();
        turn = new Turn();
        players[0] = new Player(0);
        players[1] = new Player(1);
    }

    private void play()
    {
        int option;
        do
        {
            option = 0;
            new GestorIO().out("\nTurno de Jugador: "+ players[turn.isTurnOf()].getNumber());
            players[turn.isTurnOf()].draw();
            menu.show();
            while (option != 8)
            {
                option = menu.getOption();
                players[turn.isTurnOf()].makePlay(option);
            }
            turn.change();
        } while (!players[0].lose() || !players[1].lose());
    }

    public static void main(String[] args)
    {
        //new YuGilOhg().play();
    }
}
