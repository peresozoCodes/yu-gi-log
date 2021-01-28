import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import java.util.ArrayList;
import java.util.Random;

public class Field
{
    private final int MONSTER_LIMIT = 5;
    private MonsterCard card;
    private ArrayList<Card> hand;
    private ArrayList<MonsterCard> monsterAreas;
    private ArrayList<Card> deck;
    private ArrayList<Card> graveyard;
    private Phase phase;

    public Field()
    {
        card = new MonsterCard();
        monsterAreas = new ArrayList<MonsterCard>();
        graveyard = new ArrayList<>();
        hand = new ArrayList<>();
        phase = Phase.MAIN1;
    }

    public void initializeDeck()
    {
        ArrayList<MonsterCard> cards = card.getCards();
        deck = this.shuffle(cards);
    }

    public void show(Field field)
    {
        GestorIO gestorIO = new GestorIO();
        if (field.monsterAreas.size() < 1)
        {
            gestorIO.out("\tCAMPO VACÍO\n");
            return;
        }

        for (MonsterCard monster : field.monsterAreas)
        {
            gestorIO.out("\t"+ monster.getName()
                    +"\t ATK: "+ monster.getAttackPoints()
                    +" DEF: "+  monster.getDefensePoints() + "\n");
        }
    }

    public void showHand()
    {
        GestorIO gestorIO = new GestorIO();
        gestorIO.out("\n------- MANO -------\n");
        for (Card card : hand)
        {
            MonsterCard monster = (MonsterCard) card;
            gestorIO.out("\t-"+ monster.getName()
                    +"\t ATK: "+ monster.getAttackPoints()
                    +" DEF: "+  monster.getDefensePoints() + "\n");
        }
    }

    public void addMonsterToField()
    {
        MonsterCard monster = this.askWhichCard();
        Mode mode = this.askModeOfCard();
        if (mode == Mode.ATTACK)
            this.addMonsterToField(monster, mode, false);
        else
            this.addMonsterToField(monster, mode, true);
    }

    public MonsterCard askWhichCard()
    {
        GestorIO gestorIO = new GestorIO();
        gestorIO.out("\nQué carta quieres colocar en el campo?");
        int indexCard = 0;
        for (Card card : hand)
        {
            gestorIO.out("\n"+ indexCard +". " + card.getName());
            indexCard++;
        }
        int selectedValue = gestorIO.inInt();
        MonsterCard monster = (MonsterCard) hand.get(selectedValue);
        return monster;
    }

    private Mode askModeOfCard()
    {
        GestorIO gestorIO = new GestorIO();
        gestorIO.out("\nEn qué posicion quieres colocar la carta en el campo?");
        gestorIO.out( "\n1. Posición de Ataque\n2. Posición de Defensa\n: ");
        int selectedValue;
        do {
            selectedValue = gestorIO.inInt();
            if (selectedValue == 1)
                return Mode.ATTACK;
            if (selectedValue == 2)
                return Mode.DEFENSE;
            else
                gestorIO.out("Valor no válido. Vuelva a ingresarlo\n");
        } while (selectedValue !=1 && selectedValue !=2);
        return null;
    }

    public void addMonsterToField(MonsterCard monster, Mode m, boolean isHidden)
    {
        if (monsterAreaIndexOutOfRange())
            return;
        if (phase == Phase.BATTLE)
            return;
        if (hand.contains(monster) && monster.getLocation() == Location.HAND)
        {
            hand.remove(monster);
            monster.setHidden(isHidden);
            monster.setMode(m);
            monster.setLocation(Location.FIELD);
            monsterAreas.add(monster);
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

    public void addCardToHand()
    {
        Card card = this.removeTopOfDeck();
        card.setLocation(Location.HAND);
        hand.add(card);
    }

    public void addNCardsToHand(int n)
    {
        for (int i = 0; i < n; i++)
        {
            this.addCardToHand();
        }
    }

    public Card removeTopOfDeck()
    {
        Card card = deck.get(0);
        deck.remove(0);
        return card;
    }

    public void showGraveyard()
    {
        // TODO
        throw new NotImplementedException();
    }

    private boolean monsterAreaIndexOutOfRange()
    {
        if (monsterAreas.size() >= 5) {
            new GestorIO().out("No hay zonas de monstrous libres para invocar");
            return true;
        }
        return false;
    }

    public Phase getPhase() {
        return phase;
    }

    public void setPhase(Phase phase) {
        this.phase = phase;
    }

    public static void main (String[] args)
    {
        Field field1 = new Field();
        field1.initializeDeck();
        field1.addNCardsToHand(5);
        field1.addMonsterToField();
    }

}
