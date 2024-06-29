package quek.astronomica.registry;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.*;
import quek.astronomica.Astronomica;

import java.util.List;
import java.util.OptionalLong;

public class AstronomicaDimensions {

    public static final ResourceKey<Level> LUNA_LEVEL = ResourceKey.create(Registries.DIMENSION, name("luna"));
    public static final ResourceKey<NoiseGeneratorSettings> LUNA_NOISE_GEN = ResourceKey.create(Registries.NOISE_SETTINGS, name("luna"));
    public static final ResourceKey<DimensionType> LUNA_DIM_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE, name("luna"));
    public static final ResourceKey<LevelStem> LUNA_LEVEL_STEM = ResourceKey.create(Registries.LEVEL_STEM, name("luna"));

    public static final ResourceKey<Level> ERSATZ_LEVEL = ResourceKey.create(Registries.DIMENSION, name("ersatz"));
    public static final ResourceKey<NoiseGeneratorSettings> ERSATZ_NOISE_GEN = ResourceKey.create(Registries.NOISE_SETTINGS, name("ersatz"));
    public static final ResourceKey<DimensionType> ERSATZ_DIM_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE, name("ersatz"));
    public static final ResourceKey<LevelStem> ERSATZ_LEVEL_STEM = ResourceKey.create(Registries.LEVEL_STEM, name("ersatz"));

    public static final ResourceKey<Level> VESTIGE_LEVEL = ResourceKey.create(Registries.DIMENSION, name("vestige"));
    public static final ResourceKey<NoiseGeneratorSettings> VESTIGE_NOISE_GEN = ResourceKey.create(Registries.NOISE_SETTINGS, name("vestige"));
    public static final ResourceKey<DimensionType> VESTIGE_DIM_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE, name("vestige"));
    public static final ResourceKey<LevelStem> VESTIGE_LEVEL_STEM = ResourceKey.create(Registries.LEVEL_STEM, name("vestige"));

    public static final ResourceKey<Level> NOTHINGNESS_LEVEL = ResourceKey.create(Registries.DIMENSION, name("nothingness"));
    public static final ResourceKey<NoiseGeneratorSettings> NOTHINGNESS_NOISE_GEN = ResourceKey.create(Registries.NOISE_SETTINGS, name("nothingness"));
    public static final ResourceKey<DimensionType> NOTHINGNESS_DIM_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE, name("nothingness"));
    public static final ResourceKey<LevelStem> NOTHINGNESS_LEVEL_STEM = ResourceKey.create(Registries.LEVEL_STEM, name("nothingness"));

    private static ResourceLocation name(String name) {
        return ResourceLocation.fromNamespaceAndPath(Astronomica.MODID, name);
    }

    public static void bootstrapType(BootstrapContext<DimensionType> context) {
        context.register(LUNA_DIM_TYPE, new DimensionType(
                OptionalLong.empty(),
                true,
                false,
                false,
                true,
                1.0,
                false,
                false,
                0,
                384,
                384,
                BlockTags.INFINIBURN_OVERWORLD,
                BuiltinDimensionTypes.OVERWORLD_EFFECTS,
                0.0F,
                new DimensionType.MonsterSettings(false, false, UniformInt.of(0, 7), 0)
        ));
        context.register(ERSATZ_DIM_TYPE, new DimensionType(
                OptionalLong.empty(),
                true,
                false,
                false,
                true,
                1.0,
                false,
                false,
                0,
                384,
                384,
                BlockTags.INFINIBURN_OVERWORLD,
                BuiltinDimensionTypes.OVERWORLD_EFFECTS,
                0.0F,
                new DimensionType.MonsterSettings(false, false, UniformInt.of(0, 7), 0)
        ));
        context.register(VESTIGE_DIM_TYPE, new DimensionType(
                OptionalLong.empty(),
                true,
                false,
                false,
                true,
                1.0,
                false,
                false,
                0,
                384,
                384,
                BlockTags.INFINIBURN_OVERWORLD,
                BuiltinDimensionTypes.OVERWORLD_EFFECTS,
                0.0F,
                new DimensionType.MonsterSettings(false, false, UniformInt.of(0, 7), 0)
        ));
        context.register(NOTHINGNESS_DIM_TYPE, new DimensionType(
                OptionalLong.of(18000L),
                true,
                false,
                false,
                true,
                1.0,
                false,
                false,
                0,
                384,
                384,
                BlockTags.INFINIBURN_OVERWORLD,
                BuiltinDimensionTypes.END_EFFECTS,
                0.0F,
                new DimensionType.MonsterSettings(false, false, UniformInt.of(0, 7), 0)
        ));
    }

    public static void bootstrapStem(BootstrapContext<LevelStem> context) {
        HolderGetter<Biome> biomeRegistry = context.lookup(Registries.BIOME);
        HolderGetter<DimensionType> dimTypes = context.lookup(Registries.DIMENSION_TYPE);
        HolderGetter<NoiseGeneratorSettings> noiseGenSettings = context.lookup(Registries.NOISE_SETTINGS);
        context.register(LUNA_LEVEL_STEM, new LevelStem(dimTypes.getOrThrow(LUNA_DIM_TYPE), new NoiseBasedChunkGenerator(AstronomicaBiomes.luna(biomeRegistry), noiseGenSettings.getOrThrow(LUNA_NOISE_GEN))));
        context.register(ERSATZ_LEVEL_STEM, new LevelStem(dimTypes.getOrThrow(ERSATZ_DIM_TYPE), new NoiseBasedChunkGenerator(AstronomicaBiomes.ersatz(biomeRegistry), noiseGenSettings.getOrThrow(ERSATZ_NOISE_GEN))));
        context.register(VESTIGE_LEVEL_STEM, new LevelStem(dimTypes.getOrThrow(VESTIGE_DIM_TYPE), new NoiseBasedChunkGenerator(AstronomicaBiomes.vestige(biomeRegistry), noiseGenSettings.getOrThrow(VESTIGE_NOISE_GEN))));
        context.register(NOTHINGNESS_LEVEL_STEM, new LevelStem(dimTypes.getOrThrow(NOTHINGNESS_DIM_TYPE), new NoiseBasedChunkGenerator(AstronomicaBiomes.nothingness(biomeRegistry), noiseGenSettings.getOrThrow(NOTHINGNESS_NOISE_GEN))));
    }

    public static void bootstrapNoise(BootstrapContext<NoiseGeneratorSettings> context) {
        context.register(LUNA_NOISE_GEN, new NoiseGeneratorSettings(
                NoiseSettings.create(0, 384, 1, 2),
                Blocks.STONE.defaultBlockState(),
                Blocks.AIR.defaultBlockState(),
                new NoiseRouter(
                        DensityFunctions.zero(),
                        DensityFunctions.zero(),
                        DensityFunctions.zero(),
                        DensityFunctions.zero(),
                        DensityFunctions.zero(),
                        DensityFunctions.zero(),
                        DensityFunctions.zero(),
                        DensityFunctions.zero(),
                        DensityFunctions.zero(),
                        DensityFunctions.zero(),
                        DensityFunctions.zero(),
                        DensityFunctions.zero(),
                        DensityFunctions.zero(),
                        DensityFunctions.zero(),
                        DensityFunctions.zero()
                ),
                SurfaceRules.state(Blocks.STONE.defaultBlockState()),
                List.of(),
                0,
                false,
                false,
                false,
                false
        ));
        context.register(ERSATZ_NOISE_GEN, new NoiseGeneratorSettings(
                NoiseSettings.create(0, 384, 1, 2),
                Blocks.STONE.defaultBlockState(),
                Blocks.AIR.defaultBlockState(),
                new NoiseRouter(
                        DensityFunctions.zero(),
                        DensityFunctions.zero(),
                        DensityFunctions.zero(),
                        DensityFunctions.zero(),
                        DensityFunctions.zero(),
                        DensityFunctions.zero(),
                        DensityFunctions.zero(),
                        DensityFunctions.zero(),
                        DensityFunctions.zero(),
                        DensityFunctions.zero(),
                        DensityFunctions.zero(),
                        DensityFunctions.zero(),
                        DensityFunctions.zero(),
                        DensityFunctions.zero(),
                        DensityFunctions.zero()
                ),
                SurfaceRules.state(Blocks.STONE.defaultBlockState()),
                List.of(),
                0,
                false,
                false,
                false,
                false
        ));
        context.register(VESTIGE_NOISE_GEN, new NoiseGeneratorSettings(
                NoiseSettings.create(0, 384, 1, 2),
                Blocks.STONE.defaultBlockState(),
                Blocks.AIR.defaultBlockState(),
                new NoiseRouter(
                        DensityFunctions.zero(),
                        DensityFunctions.zero(),
                        DensityFunctions.zero(),
                        DensityFunctions.zero(),
                        DensityFunctions.zero(),
                        DensityFunctions.zero(),
                        DensityFunctions.zero(),
                        DensityFunctions.zero(),
                        DensityFunctions.zero(),
                        DensityFunctions.zero(),
                        DensityFunctions.zero(),
                        DensityFunctions.zero(),
                        DensityFunctions.zero(),
                        DensityFunctions.zero(),
                        DensityFunctions.zero()
                ),
                SurfaceRules.state(Blocks.STONE.defaultBlockState()),
                List.of(),
                0,
                false,
                false,
                false,
                false
        ));
        context.register(NOTHINGNESS_NOISE_GEN, new NoiseGeneratorSettings(
                NoiseSettings.create(0, 384, 1, 2),
                Blocks.STONE.defaultBlockState(),
                Blocks.AIR.defaultBlockState(),
                new NoiseRouter(
                        DensityFunctions.zero(),
                        DensityFunctions.zero(),
                        DensityFunctions.zero(),
                        DensityFunctions.zero(),
                        DensityFunctions.zero(),
                        DensityFunctions.zero(),
                        DensityFunctions.zero(),
                        DensityFunctions.zero(),
                        DensityFunctions.zero(),
                        DensityFunctions.zero(),
                        DensityFunctions.zero(),
                        DensityFunctions.zero(),
                        DensityFunctions.zero(),
                        DensityFunctions.zero(),
                        DensityFunctions.zero()
                ),
                SurfaceRules.state(Blocks.STONE.defaultBlockState()),
                List.of(),
                0,
                false,
                false,
                false,
                false
        ));
    }
}