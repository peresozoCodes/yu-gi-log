import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import java.util.ArrayList;
import java.util.Random;

public class Field
{
    private final int MONSTER_LIMIT = 5;
    private Card card;
    private ArrayList<Card> monsterArea;
    private ArrayList<Card> deck;
    private ArrayList<Card> graveyard;

    public Field()
    {
        card = new Card();
        monsterArea = new ArrayList<>();
        graveyard = new ArrayList<>();
    }

    public void initializeDeck()
    {
        ArrayList<Card> cards = card.getCards();
        deck = shuffle(cards);
        // conectarse a la base de datos y llenar la lista de cartas [MAZO]
    }

    public void Mostrar()
    {
        GestorIO gestorIO = new GestorIO();
        //gestorIO.out("\n------- CAMPO -------\n");
        if (monsterArea.size() < 1)
        {
            gestorIO.out("\tCAMPO VACÍO\n");
            return;
        }

        for (Card monster : monsterArea)
        {
            gestorIO.out("\t"+ monster.getName()
                    +"\t ATK: "+ monster.getAttack()
                    +" DEF: "+  monster.getDefense() + "\n");
        }
    }

    public static ArrayList shuffle(ArrayList input)
    {
        ArrayList list = input;
        ArrayList shuffleList = new ArrayList();

        Random randNum = new Random();
        while (list.size() > 0)
        {
            int value = randNum.nextInt(list.size()); // number between zero and size of list
            shuffleList.add(list.get(value));
            list.remove(value);
        }

        return shuffleList;
    }
    public Card removeTopOfDeck()
    {
        Card card = deck.get(0);
        deck.remove(0);
        return card;
    }


    public void setFaceUp(Card cardToSet)
    {
        cardToSet.setVisible(true);
        monsterArea.add(cardToSet);
    }

    public void setFaceDown(Card cardToSet)
    {
        cardToSet.setVisible(false);
        monsterArea.add(cardToSet);
    }

    public void showGraveyard()
    {
        // TODO
        throw new NotImplementedException();
    }

}
