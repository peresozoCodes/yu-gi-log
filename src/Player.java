import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Player
{
    private int number;
    private Field field;
    private int lifePoints;
    private boolean addedMonsterThisTurn; // cuando el jugador invoca/coloca un monstruo, se pone en true
    private boolean hasAttacked;

    public Player(int number)
    {
        this.number = number;
        field = new Field();
        lifePoints = 8000;
        field.initializeDeck(); // inicializar objetos del campo (y la mano del jugador)
    }

    public int getNumber() {
        return number;
    }

    public void makePlay(int option, Player opponent)
    {
        GestorIO gestorIO = new GestorIO();
        switch (option) {
            case 1:
                this.showHand();
                break;
            case 2:
                this.showField(opponent);
                break;
            case 3:
                if (!addedMonsterThisTurn)
                    this.setCardInField();
                else
                    gestorIO.out("\n¡Ya has realizado una invocación este turno!");
                break;
            case 4:
                this.declareAttack();
                break;
            case 5:
                this.changePosition();
                break;
            case 6:
                field.showGraveyard();
                break;
            case 7:
                addedMonsterThisTurn = false;
                //Console.Clear();
                break;
        }
    }

    private void showHand()
    {
        field.showHand();
    }

    private void showField(Player opponentPlayer)
    {
        GestorIO gestorIO = new GestorIO();
        gestorIO.out("\n------- CAMPO OPONENTE -------\n");
        this.showField(opponentPlayer.field);

        gestorIO.out("\n--------  TU CAMPO  --------\n");
        this.showField(this.field);
    }

    private void showField(Field field)
    {
        field.show(field);

    }

    private void setCardInField()
    {
        field.addMonsterToField();
        addedMonsterThisTurn = true;
    }

    public void addCardToHand()
    {
        field.addCardToHand();
    }

    public void addNCardsToHand(int n)
    {
        field.addNCardsToHand(n);
    }

    private void changePhase()
    {
        if (field.getPhase() == Phase.MAIN1 && hasAttacked)
        {
            field.setPhase(Phase.MAIN2);
        }
        if (field.getPhase() == Phase.MAIN1 && !hasAttacked)
        {
            field.setPhase(Phase.BATTLE);
        }
    }

    private void changePosition()
    {
        // TODO
        throw new NotImplementedException();
    }

    private void declareAttack()
    {
        // TODO
        changePhase();
        // .......
        hasAttacked = true;
        changePhase();
    }

    public static void main(String[] args)
    {
        GestorIO gestorIO = new GestorIO();
        Player player1 = new Player(0);

        gestorIO.out(player1.number);
        gestorIO.out(player1.addedMonsterThisTurn);
        player1.showHand();
        player1.addNCardsToHand(5);

    }
}
