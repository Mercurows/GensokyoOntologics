package github.thelawf.gensokyoontology.common.entity.spellcard;

import github.thelawf.gensokyoontology.common.entity.projectile.HeartShotEntity;
import github.thelawf.gensokyoontology.common.util.danmaku.DanmakuColor;
import github.thelawf.gensokyoontology.common.util.danmaku.DanmakuType;
import github.thelawf.gensokyoontology.common.util.danmaku.DanmakuUtil;
import github.thelawf.gensokyoontology.core.init.ItemRegistry;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ManiaDepressEntity extends SpellCardEntity{

    public static final EntityType<ManiaDepressEntity> MANIA_DEPRESS =
            EntityType.Builder.<ManiaDepressEntity>create(ManiaDepressEntity::new, EntityClassification.MISC)
                    .size(1F,1F).trackingRange(4).updateInterval(2).build("mania_depress");

    public ManiaDepressEntity(World worldIn, PlayerEntity player) {
        super(MANIA_DEPRESS, worldIn, player);
    }

    public ManiaDepressEntity(EntityType<? extends SpellCardEntity> entityTypeIn, World worldIn) {
        super(MANIA_DEPRESS, worldIn);
    }

    @Override
    public void tick() {
        super.tick();
        List<Vector3d> pinkPositions = DanmakuUtil.getHeartLinePos(0.3f, 0.11);
        List<Vector3d> aquaPositions = DanmakuUtil.getHeartLinePos(1.8f, 0.11);
        int shootInterval = 15;
        int ratio = ticksExisted / shootInterval;
        pinkPositions = DanmakuUtil.getRotatedPos(pinkPositions, (float) Math.PI / 12 * ratio, 0f);
        aquaPositions = DanmakuUtil.getRotatedPos(aquaPositions, (float) Math.PI / 2, 0f);
        aquaPositions = DanmakuUtil.getRotatedPos(aquaPositions, (float) Math.PI / 6 * ratio, 0f);

        if (ticksExisted % shootInterval == 0) {

            for (Vector3d vector3d : pinkPositions) {
                HeartShotEntity heartShotPink = new HeartShotEntity((LivingEntity) this.getOwner(), world, DanmakuType.HEART_SHOT, DanmakuColor.RED);

                Vector3d shootVec = new Vector3d(vector3d.x, vector3d.y, vector3d.z);
                vector3d = vector3d.add(this.getPositionVec());

                setDanmakuInit(heartShotPink, vector3d, new Vector2f((float) vector3d.x, (float) vector3d.y));
                heartShotPink.shoot(shootVec.x, shootVec.y, shootVec.z, 0.55f, 0f);
                world.addEntity(heartShotPink);
            }

            for (Vector3d vector3d : aquaPositions) {
                HeartShotEntity heartShotAqua = new HeartShotEntity((LivingEntity) this.getOwner(), world, DanmakuType.HEART_SHOT, DanmakuColor.AQUA);

                Vector3d shootVec = new Vector3d(vector3d.x, vector3d.y, vector3d.z);
                vector3d = vector3d.add(this.getPositionVec());

                setDanmakuInit(heartShotAqua, vector3d, new Vector2f((float) vector3d.x, (float) vector3d.y));
                heartShotAqua.shoot(-shootVec.x, -shootVec.y, -shootVec.z, 0.3f, 0f);
                world.addEntity(heartShotAqua);
            }
        }
    }

    @Override
    @NotNull
    public ItemStack getItem() {
        return new ItemStack(ItemRegistry.SPELL_CARD_BLANK.get());
    }
}
