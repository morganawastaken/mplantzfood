package morgs.mplantzfood.mixin;


import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import joshxviii.plantz.PazItems;
import joshxviii.plantz.entity.plant.Plant;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import morgs.mplantzfood.setup.items;
import morgs.mplantzfood.setup.util.PlantEntityInterface;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import net.minecraft.core.TypedInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;

@Mixin(Plant.class)
public abstract class PlantEntityMixin
        extends TamableAnimal
        implements PlantEntityInterface {
    protected PlantEntityMixin(EntityType<? extends TamableAnimal> type, Level level) {
        super(type, level);
    }

    @Override
    public void testmixin() {
        System.out.println("Yay");
    }

    /**
     * @author
     * @reason
     */
    @Overwrite
    public InteractionResult mobInteract(@NotNull Player player, @NotNull InteractionHand hand) {
        ItemStack var10000 = player.getItemInHand(hand);
        ItemStack itemStack = var10000;
        Level var9 = this.level();
        Level level = var9;
        if (level instanceof ServerLevel) {
            if (itemStack.is(PazItems.SUN) || itemStack.is(items.plant_food)) {
                if (this.isTame() && this.getHealth() < this.getMaxHealth()) {
                    itemStack.consume(1, (LivingEntity) player);
                    SimpleParticleType var10002 = ParticleTypes.HAPPY_VILLAGER;
                    InteractionResult.Success var20 = InteractionResult.SUCCESS_SERVER;
                    Intrinsics.checkNotNullExpressionValue(var20, "SUCCESS_SERVER");
                    return (InteractionResult) var20;
                }
            }
        }
        InteractionResult var10 = super.mobInteract(player, hand);
        return var10;
    }
}

