package morgs.mplantzfood.setup.util;

import joshxviii.plantz.PazEntities;
import joshxviii.plantz.PazSounds;
import joshxviii.plantz.ai.goal.SleepGoal;
import joshxviii.plantz.entity.plant.PeaShooter;
import joshxviii.plantz.entity.plant.Plant;
import joshxviii.plantz.entity.projectile.Pea;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import morgs.mplantzfood.ai.PeashooterPlantFoodGoal;
import morgs.mplantzfood.ai.SunPlantFoodGoal;
import morgs.mplantzfood.pazimports.ProjectileAttackGoal;
import morgs.mplantzfood.setup.PlantFoodEffects;
import morgs.mplantzfood.setup.RegisterFood;
import morgs.mplantzfood.setup.items;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.GoalSelector;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec2;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Objects;
import java.util.function.Predicate;

public abstract class Util {

    public static void initialize () {}



    public static void applyPlantFood(ItemStack itemStack, SynchedEntityData entityData,
                                      GoalSelector mySelector, Plant entity,
                                      CallbackInfoReturnable<InteractionResult> cir, boolean cancel) {
        if (itemStack.is(items.plant_food)) {
            var mytype = entity.getType();
            int i = entityData.hashCode();
            PlantFoodEffects.sunflowerFoodEffect(i);
            var instance = new MobEffectInstance(RegisterFood.PFood, 5, 0, false, true, false);
            ((Plant) (Object) entity).addEffect(instance);
            Function0<Unit> function0 = () -> Unit.INSTANCE;
            Predicate<PathfinderMob> predicate = (it) -> it != null;
            if (mytype == PazEntities.SUNFLOWER) {
                if ((Object) entity instanceof Plant) {
                    mySelector.addGoal(0, new SunPlantFoodGoal((Plant) (Object) entity,
                            0, 10,
                            function0, function0, predicate,
                            1, false));
                    System.out.println("Sunflower fed!");
                }
            } else if (mytype == PazEntities.PEA_SHOOTER) {
                if ((Object) entity instanceof Plant) {
                    Function0<? extends Entity> function01 = () -> new Pea(entity.level(), entity, Vec2.ZERO);
                    var x = ((Plant) (Object) entity).getAttributes().getValue(Attributes.FOLLOW_RANGE);
                    float Float = (float) x;
                    Predicate<Goal> goalPredicate = Objects::nonNull;
                    mySelector.removeAllGoals(goalPredicate);
                    mySelector.addGoal(1, new SleepGoal(entity, false, false));
                    mySelector.addGoal(3, new RandomLookAroundGoal(entity));
                    mySelector.addGoal(3, new LookAtPlayerGoal(entity, Player.class, 0.8f));
                    entity.attackGoals();
                    mySelector.addGoal( 5, new PeashooterPlantFoodGoal((Plant)(Object)entity,
                            0, 3,
                            function0, function0, predicate, function01,
                            0.9, 0.8f, Float,
                            false, PazSounds.PROJECTILE_FIRE));
                    System.out.println(mySelector.getAvailableGoals().toString());
                    System.out.println("Pea Shooter fed!");

                } else {System.out.println("Plant fed?");}
            }
            if (cancel == true) {
                cir.setReturnValue(InteractionResult.SUCCESS_SERVER);
                cir.cancel();
            }
        }
    }
}
