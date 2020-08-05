package com.peridot.mangoores.game.common.world.generation.ores;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class SandOreGeneration {

    public final Block block;

    public final int count;
    public final int bottomOffset;
    public final int topOffset;
    public final int maximum;
    public final int size;

    public SandOreGeneration(Block block, int count, int bottomOffset, int topOffset, int maximum, int size) {
        this.block = block;
        this.count = count;
        this.bottomOffset = bottomOffset;
        this.topOffset = topOffset;
        this.maximum = maximum;
        this.size = size;

        generateOre();
    }

    public void generateOre() {
        for (Biome biome : ForgeRegistries.BIOMES) {
            ConfiguredPlacement configurationValue = Placement.COUNT_RANGE.configure(new CountRangeConfig(count, bottomOffset, topOffset, maximum));
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
                    Feature.ORE
                            .withConfiguration(
                                    new OreFeatureConfig(OreFeatureConfig.FillerBlockType.create("SAND", "sand", predicate -> {
                                        if (predicate == null) {
                                            return false;
                                        }
                                        return predicate.isIn(Blocks.SAND);
                                    }), block.getDefaultState(), size))
                            .withPlacement(configurationValue));
        }
    }

}
