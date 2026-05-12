package morgs.mplantzfood.mixin;


import joshxviii.plantz.PazEntities;
import joshxviii.plantz.PazItems;
import joshxviii.plantz.PazSounds;
import joshxviii.plantz.entity.plant.PeaShooter;
import joshxviii.plantz.entity.plant.Plant;
import joshxviii.plantz.entity.projectile.Pea;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import morgs.mplantzfood.ai.PeashooterPlantFoodGoal;
import morgs.mplantzfood.ai.SunPlantFoodGoal;
import morgs.mplantzfood.pazimports.ProjectileAttackGoal;
import morgs.mplantzfood.setup.PlantFoodEffects;
//import morgs.mplantzfood.ai.SunPlantFoodGoal;
import morgs.mplantzfood.setup.RegisterFood;
import morgs.mplantzfood.setup.items;
import morgs.mplantzfood.setup.util.PlantEntityInterface;
import morgs.mplantzfood.setup.util.Util;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.GoalSelector;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec2;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.Objects;
import java.util.function.Predicate;

import static org.spongepowered.asm.mixin.injection.At.Shift.*;

@Mixin(Plant.class)
public abstract class PlantEntityMixin
        extends TamableAnimal
        implements PlantEntityInterface<Plant>, MobAccessor {
    protected PlantEntityMixin(EntityType<? extends TamableAnimal> type, Level level) {
        super(type, level);
    }

    public GoalSelector mySelector = getGoalSelector();



    @Shadow
    public abstract InteractionResult mobInteract(Player player, InteractionHand hand);

    @ModifyVariable(
            method = "mobInteract",
            at = @At(value = "JUMP:FIRST", shift = BY, by = -1),
            name = "itemStack"
    )
    private ItemStack lie(ItemStack itemStack) {
        ItemStack newItemStack = itemStack;
        if (newItemStack.is(items.plant_food)) {
            return PazItems.SUN.getDefaultInstance();
        } else {
            return newItemStack;
        }
    }

    @ModifyVariable(
            method = "mobInteract",
            at = @At(value = "JUMP", ordinal = 3),
            name = "itemStack"
    )
    private ItemStack youwereliedto(ItemStack itemStack, Player player, InteractionHand hand) {
        itemStack = player.getItemInHand(hand);
        return itemStack;
    }

    @Inject(
            method = "mobInteract",
            at = @At(value = "JUMP:FIRST", shift = BY, by = -2),
            locals = LocalCapture.CAPTURE_FAILSOFT,
            cancellable = true
    )
    public void
    inject0(Player player, InteractionHand hand, CallbackInfoReturnable<InteractionResult> cir,
            ItemStack itemStack, Level level) {
        Util.applyPlantFood(itemStack, ((Plant) (Object) this).getEntityData(),
                mySelector, ((Plant) (Object) this), cir, true);
    }


    @Inject(
            method = "mobInteract",
            at = @At(value = "JUMP", ordinal = 3, shift = AFTER),
            locals = LocalCapture.CAPTURE_FAILSOFT,
            cancellable = true
    )
    public void
    inject1(Player player, InteractionHand hand, CallbackInfoReturnable<InteractionResult> cir,
            ItemStack itemStack, Level level) {
        Util.applyPlantFood(itemStack, ((Plant) (Object) this).getEntityData(),
                mySelector, ((Plant) (Object) this), cir, true);
    }
}




