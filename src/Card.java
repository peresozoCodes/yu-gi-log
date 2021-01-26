import java.util.ArrayList;

public class Card
{
    private String name;
    private int attack;
    private int defense;
    private boolean isVisible = true;

    public String getName()
    {
        if (isVisible)
            return name;
        else
            return "Carta boca abajo";
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    public int getAttack()
    {
        if (isVisible)
            return attack;
        else
            return -1;
    }

    public int getDefense()
    {
        if (isVisible)
            return defense;
        else
            return -1;
    }

    public Card()
    {
    }

    public Card(String name, int attack, int defense)
    {
        this.name = name;
        this.attack = attack;
        this.defense = defense;
    }

    public ArrayList<Card> getCards() {
        ArrayList cardList = new ArrayList<Card>()
        {
            {
                add(new Card("Kojikocy", 1500, 1200));
                add(new Card("Harpie Lady", 1300, 1400));
                add(new Card("Dark Magician", 2500, 2100));
                add(new Card("Dragon Blanco Oji-Azulinos", 3000, 2500));
                add(new Card("Feral Imp", 1300, 1400));
                add(new Card("Jinzo", 2400, 1500));
                add(new Card("Dragon Negro Oji-Carmesianos", 2400, 2000));
                add(new Card("Big Shield Gardna", 100, 2600));
                add(new Card("MINOTARUS!!", 17000, 1000));
                add(new Card("Gran Polilla", 2600, 2500));
                add(new Card("Planta Come-Hombres", 800, 600));
                add(new Card("Bicho del Pantano", 1800, 1600));
                add(new Card("Guerrero Castor", 1200, 1500));
            }
        };

        return cardList;
    }

}
