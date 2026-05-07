package morgs.mplantzfood.setup;

import joshxviii.plantz.ai.goal.ActionGoal;
import joshxviii.plantz.ai.goal.GenerateSunGoal;
import joshxviii.plantz.entity.plant.Plant;
import joshxviii.plantz.entity.plant.Sunflower;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.GoalSelector;

import java.util.HashMap;
import java.util.function.Predicate;

public class PlantFoodEffects {
    int timer;
    boolean effecthappened;
    int planthash;
    static HashMap m = new HashMap<Integer, PlantFoodEffects>();

    public PlantFoodEffects(int timer, boolean effecthappened, int planthash) {
        this.timer = timer;
        this.effecthappened = effecthappened;
        this.planthash = planthash;
    }

    public static void sunflowerFoodEffect(int i){
        System.out.println("\"Delicious!\" - said Sunflower" + i);
        PlantFoodEffects TIMER = new PlantFoodEffects(10, false, i);
        if (!(m.containsKey(i))){
            m.putIfAbsent(i, TIMER);
        };
        if (m.containsKey(i)) {
            var timerupdate = m.get(i);
        }
    }

    void timerRefresh(int x){
        this.timer = x;
    };
}

