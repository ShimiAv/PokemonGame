import com.company.Attack;
import com.company.Constants;
import com.company.Pokemon;

public class ElectricPokemon extends Pokemon {


    public ElectricPokemon(int maxHp, int currentHp, int maxAttackPts, int currentAttackPts, String name,  int currentLevel, int maxLevel, Attack[] attacks) {
        super(maxHp, currentHp, maxAttackPts, currentAttackPts, name, currentLevel, maxLevel, attacks);
    }

    protected int uniqueFeature(int currentAttackPts) {


        return currentAttackPts * getMaxAttackPts() / Constants.PERCENT_REPRESENTATION;
    }

    public int selfDischarge(int currentHp){
        int updatedHp=0;
        if (currentHp>Constants.MIN_HP_TO_SELF_DISCHARGE){
            updatedHp = currentHp;
        }
        return updatedHp;
    }




}
