package morgs.mplantzfood.mixin;


import joshxviii.plantz.PazEntities;
import joshxviii.plantz.PazItems;
import joshxviii.plantz.ai.goal.GenerateSunGoal;
import joshxviii.plantz.entity.plant.Plant;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import morgs.mplantzfood.setup.PlantFoodEffects;
//import morgs.mplantzfood.setup.SunPlantFoodGoal;
import morgs.mplantzfood.setup.items;
import morgs.mplantzfood.setup.util.PlantEntityInterface;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.function.Predicate;

import static org.spongepowered.asm.mixin.injection.At.Shift.AFTER;
import static org.spongepowered.asm.mixin.injection.At.Shift.BY;

@Mixin(Plant.class)
public abstract class PlantEntityMixin
        extends TamableAnimal
        implements PlantEntityInterface<Plant> {
    protected PlantEntityMixin(EntityType<? extends TamableAnimal> type, Level level) {
        super(type, level);
    }

    @Override
    public void testmixin() {
    }

    @Shadow
    public abstract InteractionResult mobInteract(Player player, InteractionHand hand);

    @ModifyVariable(
            method = "mobInteract",
            at = @At(value = "JUMP:FIRST", shift = BY, by = -1),
            name = "itemStack"
    )
    private ItemStack lie(ItemStack itemStack){
        ItemStack newItemStack = itemStack;
        if (newItemStack.is(items.plant_food)) {return PazItems.SUN.getDefaultInstance();}
        else {return newItemStack;}
    }

    @ModifyVariable(
            method = "mobInteract",
            at = @At(value = "JUMP", ordinal = 3),
            name = "itemStack"
    )
    private ItemStack youwereliedto(ItemStack itemStack, Player player, InteractionHand hand){
        itemStack = player.getItemInHand(hand);
        return itemStack;
    }

    @Inject(
            method = "mobInteract",
            at = @At(value = "JUMP", ordinal = 3, shift = AFTER),
            locals = LocalCapture.CAPTURE_FAILSOFT
    )
    public void
    inject(Player player, InteractionHand hand, CallbackInfoReturnable<InteractionResult> cir,
           ItemStack itemStack, Level level){
        if (itemStack.is(items.plant_food)){
            var me = this.getType();
            int i = entityData.hashCode();
            if (me == PazEntities.SUNFLOWER){
                System.out.println("Sunflower fed!");
                PlantFoodEffects.sunflowerFoodEffect(i);
            }else
                System.out.println("Plant fed!");
        }
    }


}

