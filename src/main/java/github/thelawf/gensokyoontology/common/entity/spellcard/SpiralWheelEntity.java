package github.thelawf.gensokyoontology.common.entity.spellcard;

import github.thelawf.gensokyoontology.common.entity.projectile.HeartShotEntity;
import github.thelawf.gensokyoontology.common.entity.projectile.SmallShotEntity;
import github.thelawf.gensokyoontology.common.util.danmaku.DanmakuColor;
import github.thelawf.gensokyoontology.common.util.danmaku.DanmakuType;
import github.thelawf.gensokyoontology.common.util.danmaku.TransformFunction;
import github.thelawf.gensokyoontology.core.init.ItemRegistry;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class SpiralWheelEntity extends SpellCardEntity {

    private final int lifeSpan = 100;
    public static final EntityType<SpiralWheelEntity> SPIRAL_WHEEL_ENTITY =
            EntityType.Builder.<SpiralWheelEntity>create(SpiralWheelEntity::new,
                            EntityClassification.MISC).size(1F,1F).trackingRange(4)
                    .updateInterval(2).build("spiral_wheel");

    public SpiralWheelEntity(World worldIn, PlayerEntity player) {
        super(SPIRAL_WHEEL_ENTITY, worldIn, player);
    }

    public SpiralWheelEntity(EntityType<? extends SpellCardEntity> entityTypeIn, World worldIn) {
        super(SPIRAL_WHEEL_ENTITY, worldIn);
    }

    @Override
    public void tick() {
        super.tick();

        //PlayerEntity player = this.world.getPlayerByUuid(this.dataManager.get(DATA_OWNER_UUID).get());
        Vector3d center = new Vector3d(Vector3f.XP);

        for (int i = 0; i < 8; i++) {
            Vector3d global = center.add(20,0,0).rotateYaw((float) (Math.PI / 4 * i));
            Vector3d shootAngle = global.normalize().inverse().rotateYaw((float) Math.PI / 50);
            global = global.rotateYaw((float) (Math.PI / 50 * ticksExisted)).add(this.getPositionVec());

            HashMap<Integer, TransformFunction> map = new HashMap<>();

            HeartShotEntity heartShot = new HeartShotEntity((LivingEntity) this.getOwner(), world, DanmakuType.LARGE_SHOT, DanmakuColor.AQUA);
            setDanmakuInit(heartShot, global, new Vector2f((float) shootAngle.x, (float) shootAngle.z));

            heartShot.shoot(shootAngle.x, shootAngle.y, shootAngle.z, 0.6f, 0f);
            world.addEntity(heartShot);
        }
    }

    @Override
    @NotNull
    public ItemStack getItem() {
        return new ItemStack(ItemRegistry.SPELL_CARD_BLANK.get());
    }
}
