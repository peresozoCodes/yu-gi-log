import java.util.ArrayList;

public class MonsterCard extends Card
{
    private int level;
    private int attackPoints;
    private int defensePoints;
    private Mode mode = Mode.DEFENSE;
    private boolean isVisible = true;
    private boolean switchedMode;
    private boolean attacked;

    public MonsterCard()
    {
        super("");
    }

    public MonsterCard(String name, int level, int attack, int defense)
    {
        super(name);
        this.level = level;
        attackPoints = attack;
        defensePoints = defense;
    }

    public String getName()
    {
        if (isVisible)
            return super.getName();
        else
            return "Carta boca abajo";
    }

    @Override
    public void action(MonsterCard var1)
    {

    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    public ArrayList<MonsterCard> getCards() {
        ArrayList cardList = new ArrayList<MonsterCard>()
        {
            {
                add(new MonsterCard("Kojikocy",4, 1500, 1200));
                add(new MonsterCard("Harpie Lady",4, 1300, 1400));
                add(new MonsterCard("Dark Magician",7, 2500, 2100));
                add(new MonsterCard("Dragon Blanco Oji-Azulinos",8, 3000, 2500));
                add(new MonsterCard("Feral Imp",4, 1300, 1400));
                add(new MonsterCard("Jinzo",6, 2400, 1500));
                add(new MonsterCard("Dragon Negro Oji-Carmesianos",7, 2400, 2000));
                add(new MonsterCard("Big Shield Gardna",4, 100, 2600));
                add(new MonsterCard("MINOTAURUS!!",4, 17000, 1000));
                add(new MonsterCard("Gran Polilla",8, 2600, 2500));
                add(new MonsterCard("Planta Come-Hombres",2, 800, 600));
                add(new MonsterCard("Bicho del Pantano",4, 1800, 1600));
                add(new MonsterCard("Guerrero Castor",4, 1200, 1500));
            }
        };

        return cardList;
    }

    public boolean isSwitchedMode() {
        return switchedMode;
    }

    public void setSwitchedMode(boolean switchedMode) {
        this.switchedMode = switchedMode;
    }

    public boolean isAttacked() {
        return attacked;
    }

    public void setAttacked(boolean attacked) {
        this.attacked = attacked;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getDefensePoints() {
        return defensePoints;
    }

    public void setDefensePoints(int defensePoints) {
        this.defensePoints = defensePoints;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }

    public Mode getMode() {
        return mode;
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }

    public void setHidden(boolean hidden) {
        super.setHidden(hidden);
    }

}
