package morgs.mplantzfood.ai;

import joshxviii.plantz.PazSounds;
import joshxviii.plantz.entity.plant.Plant;
import morgs.mplantzfood.mixin.MobAccessor;
import morgs.mplantzfood.pazimports.ProjectileAttackGoal;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.GoalSelector;
import org.jetbrains.annotations.NotNull;

import java.util.function.Predicate;

public class PeashooterPlantFoodGoal extends ProjectileAttackGoal {

    public PeashooterPlantFoodGoal(@NotNull PathfinderMob usingEntity, int cooldownTime, int actionDelay, @NotNull Function0<@NotNull Unit> actionStartEffect, @NotNull Function0<@NotNull Unit> actionEndEffect, @NotNull Predicate<@NotNull PathfinderMob> actionPredicate, @NotNull Function0<? extends @NotNull Entity> projectileFactory, double velocity, float inaccuracy, float attackRadius, boolean useHighArc, @NotNull SoundEvent soundEvent) {
        super(usingEntity, cooldownTime, actionDelay, actionStartEffect, actionEndEffect, actionPredicate, projectileFactory, velocity, inaccuracy, attackRadius, useHighArc, soundEvent);

    }
    int time = 0;
    int t = 0;
//    @Override
//    public boolean canDoAction(){
//        return getActionTimer() != -1;
//    }
//
//    @Override
//    public void stop() {
//        setActionTimer(-1);
//    }

    @Override
    public void tick() {
        if (t == 5 && time != 100){
            doAction();
            t = 0;
        }else t++;

        if (time == 100){

        }else time++;
    }
}




