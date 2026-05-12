package morgs.mplantzfood.setup.util;

import com.mojang.serialization.Keyable;
import morgs.mplantzfood.pazimports.GenerateSunGoal;
import joshxviii.plantz.entity.plant.Plant;
import kotlin.jvm.functions.Function0;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.GoalSelector;

import java.util.function.Predicate;


public interface PlantEntityInterface<T> extends Keyable{
    void testmixin();

    default <T extends Plant> GenerateSunGoal FoodGoalRegister(
            T t, int time, int delay, Function0 function0,
            Predicate<PathfinderMob> predicate, int amount, boolean night)
    {
        return new GenerateSunGoal(t, time, delay, function0, function0, predicate, amount, night);
    };

    default GoalSelector FoodGoalCreate(){
        return new GoalSelector();
    };

    default <T extends Plant> GoalSelector FoodGoalMount(T object){
        GoalSelector FoodGoalSelector = FoodGoalCreate();
       // FoodGoalSelector.addGoal(0, FoodGoalRegister(object, 0, 0, 10, false));
        return FoodGoalSelector;
    }

}
