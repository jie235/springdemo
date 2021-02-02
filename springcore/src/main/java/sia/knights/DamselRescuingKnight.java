package sia.knights;

public class DamselRescuingKnight implements Knight{
    private RescueDamselQuest quest;

    public int getCount() {
        return count;
    }

    private static int count=0;

    public DamselRescuingKnight(){
        this.quest = new RescueDamselQuest();
    }

    public void embarkOnQuest(){
        quest.embark();
        count++;
    }
}
