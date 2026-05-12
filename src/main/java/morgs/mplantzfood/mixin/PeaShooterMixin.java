//package morgs.mplantzfood.mixin;
//
//import joshxviii.plantz.PazSounds;
//import joshxviii.plantz.entity.plant.PeaShooter;
//import joshxviii.plantz.entity.plant.Plant;
//import joshxviii.plantz.entity.projectile.Pea;
//import kotlin.Unit;
//import kotlin.jvm.functions.Function0;
//import morgs.mplantzfood.pazimports.ProjectileAttackGoal;
//import net.minecraft.world.effect.MobEffect;
//import net.minecraft.world.entity.Entity;
//import net.minecraft.world.entity.EntityType;
//import net.minecraft.world.entity.PathfinderMob;
//import net.minecraft.world.entity.ai.attributes.Attributes;
//import net.minecraft.world.entity.ai.goal.Goal;
//import net.minecraft.world.entity.ai.goal.GoalSelector;
//import net.minecraft.world.level.Level;
//import net.minecraft.world.phys.Vec2;
//import org.jspecify.annotations.NonNull;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.Overwrite;
//import org.spongepowered.asm.mixin.Shadow;
//import org.spongepowered.asm.mixin.injection.At;
//import org.spongepowered.asm.mixin.injection.Inject;
//import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
//
//import java.util.Objects;
//import java.util.function.Predicate;
//@Mixin(PeaShooter.class)
//public class PeaShooterMixin extends Plant {
//    public PeaShooterMixin(@NonNull EntityType<? extends Plant> type, @NonNull Level level) {
//        super(type, level);
//    }
//    public GoalSelector mySelector = getGoalSelector();
//    @Override
//    public void tick(){
//        super.tick();
//        if (MobEffect.FILTERED_REGISTRIES.isEmpty() == true) {
//            Function0<Unit> function0 = () -> Unit.INSTANCE;
//            Predicate<PathfinderMob> predicate = (it) -> it != null;
//            Function0<? extends Entity> function01 = () -> new Pea(((Plant)(Object)this).level(), (Plant)(Object)this, Vec2.ZERO);
//            Predicate<Goal> goalPredicate = Objects::nonNull;
//            var x = ((Plant) (Object) this).getAttributes().getValue(Attributes.FOLLOW_RANGE);
//            float Float = (float) x;
//            mySelector.removeAllGoals(goalPredicate);
//
//            super.registerGoals();
//            attackGoals();
//            mySelector.addGoal(4, new ProjectileAttackGoal((Plant)(Object)this,
//                    0, 20,
//                    function0, function0, predicate, function01,
//                    0.9, 0.8f, Float,
//                    false, PazSounds.PROJECTILE_FIRE));
//                }
//            }
//        }
//    }
