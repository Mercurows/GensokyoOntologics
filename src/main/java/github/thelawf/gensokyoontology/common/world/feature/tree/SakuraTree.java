package github.thelawf.gensokyoontology.common.world.feature.tree;

import github.thelawf.gensokyoontology.common.world.feature.GSKOFeatures;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class SakuraTree extends Tree {
    @Nullable
    @Override
    protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean largeHive) {
        return GSKOFeatures.SAKURA_TREE_BASE;
    }
}
