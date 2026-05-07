package morgs.mplantzfood.mixin;

import joshxviii.plantz.ai.goal.GenerateSunGoal;
import joshxviii.plantz.entity.plant.Plant;
import joshxviii.plantz.entity.plant.Sunflower;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import morgs.mplantzfood.setup.PlantFoodEffects;
import morgs.mplantzfood.setup.util.PlantEntityInterface;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.GoalSelector;
import net.minecraft.world.level.Level;
import org.jspecify.annotations.NonNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Predicate;

@Mixin(Sunflower.class)
public abstract class SunflowerMixin
        extends Plant
        implements PlantEntityInterface<Plant> {

    public SunflowerMixin(@NonNull EntityType<? extends Plant> type, @NonNull Level level) {
        super(type, level);
    }
    private static final boolean _init_$lambda$2(PathfinderMob it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return true;
    }
    @Inject(method = "registerGoals", at = @At("TAIL"))
    public void inject(CallbackInfo ci){
        //if(){
            Function0<Unit> function0 = () -> Unit.INSTANCE;
            Predicate<PathfinderMob> predicate = (it) -> it != null;
            //Predicate<PathfinderMob> predicate = (it) -> it "it";
            this.goalSelector.addGoal(1, new GenerateSunGoal(this, 0, 10,  function0, function0, predicate, 0, true));
        //}
    }

    /**
     * @author Morgana
     * @reason Protected class
     */
//    @Overwrite
//    protected void registerGoals() {
//        super.registerGoals();
//        this.goalSelector.addGoal(1, new GenerateSunGoal(this, 0, 10, null, null, null, 0, true));
//        this.foodgoal.addGoal(0, FoodGoalRegister(this, 0, 0, 20, true));
//    }
}


