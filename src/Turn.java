import java.util.Random;

public class Turn {

    private int turn;

    public Turn()
    {
        turn = new Random().nextInt(2); // value between zero and one
    }

    public int isTurnOf()
    {
        return turn;
    }

    public int isNotTurnOf()
    {
        if (turn == 0)
            return 1;
        else
            return 0;
    }

    public void change()
    {
        turn = this.isNotTurnOf();
    }

}

