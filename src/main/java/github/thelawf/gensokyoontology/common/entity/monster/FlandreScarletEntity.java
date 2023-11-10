package github.thelawf.gensokyoontology.common.entity.monster;

import github.thelawf.gensokyoontology.core.init.ItemRegistry;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.NetworkHooks;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public class FlandreScarletEntity extends YoukaiEntity {

    @OnlyIn(Dist.CLIENT)
    private Animation animation = Animation.IDLE;

    public static final EntityType<FlandreScarletEntity> FLANDRE_SCARLET = EntityType.Builder.create(
                    FlandreScarletEntity::new, EntityClassification.CREATURE).setShouldReceiveVelocityUpdates(true)
            .size(0.6f, 1.5f).trackingRange(10).build("flandre_scarlet");

    public FlandreScarletEntity(EntityType<? extends TameableEntity> type, World worldIn) {
        super(type, worldIn);
        this.favorability = -10;
        this.setHeldItem(Hand.MAIN_HAND, new ItemStack(ItemRegistry.CLOCK_HAND_ITEM.get()));
    }


    @Nullable
    @Override
    public AgeableEntity createChild(ServerWorld world, AgeableEntity mate) {
        return null;
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new SwimGoal(this));
        this.goalSelector.addGoal(2, new SitGoal(this));
        this.goalSelector.addGoal(4, new FollowOwnerGoal(this, 1.0D, 10.0F, 2.0F, false));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 0.4f));
        this.goalSelector.addGoal(8, new LookAtGoal(this, PlayerEntity.class, 0.8f));
        this.goalSelector.addGoal(8, new LookRandomlyGoal(this));

        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this, CreatureEntity.class)).setCallsForHelp());
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, TsumiBukuroEntity.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.addGoal(5, new ResetAngerGoal<>(this, true));
    }

    @Override
    @NotNull
    public ActionResultType getEntityInteractionResult(@NotNull PlayerEntity playerIn, @NotNull Hand hand) {
        return super.getEntityInteractionResult(playerIn, hand);
    }

    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    public void onDeath(@NotNull DamageSource cause) {
        super.onDeath(cause);
    }

    @Override
    public int getAngerTime() {
        return super.getAngerTime();
    }

    @Override
    public void setAngerTime(int time) {
        super.setAngerTime(time);
    }

    @Nullable
    @Override
    public UUID getAngerTarget() {
        return super.getAngerTarget();
    }

    @Override
    public void setAngerTarget(@Nullable UUID target) {
        super.setAngerTarget(target);
    }

    @Override
    public void func_230258_H__() {
        super.func_230258_H__();
    }

    @OnlyIn(Dist.CLIENT)
    public void setAnimation(Animation animation) {
        this.animation = animation;
    }

    @OnlyIn(Dist.CLIENT)
    public Animation getAnimation() {
        return animation;
    }

    public static class Doppelganger extends FlandreScarletEntity {

        public Doppelganger(EntityType<? extends TameableEntity> type, World worldIn) {
            super(type, worldIn);
        }
    }

    public enum Animation {
        IDLE,
        DIVING,
        FLYING,
        SITTING,
        SPELL_CARD_ATTACK
    }
}
