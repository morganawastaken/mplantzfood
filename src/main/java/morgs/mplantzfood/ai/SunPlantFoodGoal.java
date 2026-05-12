package morgs.mplantzfood.ai;


import joshxviii.plantz.entity.plant.Plant;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import morgs.mplantzfood.mixin.GenerateSunGoalAccessor;
import morgs.mplantzfood.pazimports.GenerateSunGoal;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;
import org.jetbrains.annotations.NotNull;

import java.util.function.Predicate;

public class SunPlantFoodGoal
        extends GenerateSunGoal
{

    public SunPlantFoodGoal(
            @NotNull Plant usingEntity,
            int cooldownTime,
            int actionDelay,
            @NotNull Function0<@NotNull Unit> actionStartEffect,
            @NotNull Function0<@NotNull Unit> actionEndEffect,
            @NotNull Predicate<@NotNull PathfinderMob> actionPredicate,
            int sunAmount, boolean generatesAtNight) {
        super(usingEntity, cooldownTime, actionDelay, actionStartEffect,
                actionEndEffect, actionPredicate, sunAmount, generatesAtNight);
    }

//    public boolean callDoAction(){
//        return true;
//    }
//    @Override
//    public boolean canDoAction(){return true;}
//    @Override
//    public boolean canUse(){return true;}
//    @Override
//    public boolean isInterruptable(){return false;}
//    @Override
//    public void stop(){}
    int tick = 0;
    int times = 0;

    @Override
    public void tick(){
        if (tick == 5){
            doAction();
            tick = 0;
            times++;
        }
        if (times == 5){
            stop();
        }else tick++;

    }

}



//package morgs.mplantzfood.setup;
//
//import joshxviii.plantz.PazTags;
//import joshxviii.plantz.ai.goal.ActionGoal;
//import joshxviii.plantz.ai.goal.GenerateSunGoal;
//import joshxviii.plantz.entity.plant.Plant;
//import joshxviii.plantz.entity.plant.Sunflower;
//import kotlin.Unit;
//import kotlin.jvm.functions.Function0;
//import kotlin.ranges.IntRange;
//import net.fabricmc.fabric.mixin.object.builder.EntityTypeBuilderMixin;
//import net.minecraft.tags.EntityTypeTags;
//import net.minecraft.util.filefix.access.PlayerData;
//import net.minecraft.world.entity.*;
//import net.minecraft.world.entity.ai.goal.Goal;
//import net.minecraft.world.level.Level;
//import net.minecraft.world.level.LevelAccessor;
//import org.jetbrains.annotations.NotNull;
//import morgs.mplantzfood.setup.entityTypes;
//
//import java.rmi.registry.Registry;
//import java.util.function.Predicate;
//
//import static java.io.FileDescriptor.out;
//import static joshxviii.plantz.PazTags.EntityTypes.PLANT;
//import static morgs.mplantzfood.setup.entityTypes.registerEntity;
//import static net.minecraft.world.level.Level.OVERWORLD;
//
//public class SunPlantFoodGoal  extends ActionGoal {
//    int amount;
//    boolean night;
//
//    public SunPlantFoodGoal(
//            Goal goal,
//            Plant usingEntity,
//            int time,
//            int delay,
//            Function0 actionStartEffect,
//            Function0 actionEndEffect,
//            Predicate actionPredicate,
//            int amount,
//            boolean night
//    ){
//        super((PathfinderMob) usingEntity,
//                time,
//                delay,
//                actionStartEffect,
//                actionEndEffect,
//                actionPredicate,
//                new IntRange(-10, 20));
//        this.amount = amount;
//        this.night = night;
//    }
//
//    public buildself(String[] args) {
//        super((PathfinderMob) usingEntity,
//                time,
//                delay,
//                actionStartEffect,
//                actionEndEffect,
//                actionPredicate,
//                new IntRange(-10, 20));;
//        Function0<Unit> function0 = () -> Unit.INSTANCE;
//        Predicate<PathfinderMob> predicate = (Class) -> SunPlantFoodGoal.class.isMemberClass();
//
//        Goal sc = new Goal() {
//            @Override
//            public boolean canUse() {
//                return false;
//            }
//        };
//
//
//        SunPlantFoodGoal constructor = new SunPlantFoodGoal(
//                sc,
//                null,
//                0,
//                0,
//                function0,
//                function0,
//                predicate,
//                0,
//                false
//        );
//    }
//
//
//
//    @Override
//    public boolean canUse() {
//        return false;
//    }
//
//    @Override
//    public boolean canDoAction() {
//        return false;
//    }
//
//    @Override
//    public boolean doAction() {
//        return false;
//    }
//}
