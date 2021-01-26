import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;

public class Player
{
    private int number;
    private Field[] fields;
    private ArrayList<Card> hand;
    private int lifePoints;
    private boolean addedMonsterThisTurn; // cuando el jugador invoca/coloca monstruo, se pone en false

    public Player(int number)
    {
        this.number = number;
        fields = new Field[2];
        fields[0] = new Field();
        fields[1] = new Field();
        hand = new ArrayList<>();
        lifePoints = 8000;
        fields[number].initializeDeck(); // inicializar objetos del campo (todo lo que no sea la mano del jugador)
        this.initialDraw();
    }

    public int getNumber() {
        return number;
    }

    public void makePlay(int option)
    {
        switch (option) {
            case 1:
                this.showHand();
                break;
            case 2:
                this.showField();
                break;
            case 3:
                this.setCard(true);
                break;
            case 4:
                this.setCard(false);
                break;
            case 5:
                this.declareAttack();
                break;
            case 6:
                this.changePosition();
                break;
            case 7:
                fields[number].showGraveyard();
                break;
            case 8:
                //Console.Clear();
                break;
        }
    }

    private void showHand()
    {
        GestorIO gestorIO = new GestorIO();
        gestorIO.out("\n------- MANO -------\n");
        for (Card card : hand)
        {
            gestorIO.out("\t-"+ card.getName()
                    +"\t ATK: "+ card.getAttack()
                    +" DEF: "+  card.getDefense() + "\n");
        }
    }

    private void showField()
    {
        GestorIO gestorIO = new GestorIO();
        gestorIO.out("\n------- CAMPO OPONENTE -------\n");

        if (number == 0) {
            this.showField(1);
        } else {
            this.showField(0);
        }

        gestorIO.out("\n--------  TU CAMPO  --------\n");
        showField(this.number);
    }

    private void showField(int number)
    {
        fields[number].Mostrar();
    }

    private void setCard(boolean position)
    {
        GestorIO gestorIO = new GestorIO();
        gestorIO.out("Qué carta quieres colocar en le campo?");
        int indexCard = 0;
        for (Card card : hand)
        {
            gestorIO.out(indexCard +". " + card.getName());
            indexCard++;
        }

        int selectedValue = gestorIO.inInt();
        Card cardToSet = hand.get(selectedValue);
        if (position == true) {
            fields[number].setFaceUp(cardToSet);
        } else {
            fields[number].setFaceDown(cardToSet);
        }
        hand.remove(selectedValue);
    }



    public void draw()
    {
        Card card = fields[number].removeTopOfDeck();
        hand.add(card);
    }

    private void initialDraw()
    {
        for (int i = 0; i < 5; i++)
        {
            this.draw();
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
        throw new NotImplementedException();
    }

    public boolean lose()
    {
        return lifePoints <= 0;
    }

    public static void main(String[] args)
    {
        GestorIO gestorIO = new GestorIO();
        Player player1 = new Player(0);

        gestorIO.out(player1.number);
        gestorIO.out(player1.addedMonsterThisTurn);
        player1.showHand();
        player1.showField();
        player1.draw();

    }
}
