package quek.astronomica.registry;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import quek.astronomica.Astronomica;

public class AstronomicaBiomes {

    public static final ResourceKey<Biome> LUNAR_PLAINS = create("lunar_plains");

    public static final ResourceKey<Biome> ERSATZ_FOREST = create("ersatz_forest");

    public static final ResourceKey<Biome> VESTIGE_WASTES = create("vestige_wastes");

    public static final ResourceKey<Biome> NOTHINGNESS = create("nothingness");

    private static ResourceKey<Biome> create(String name) {
        return ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(Astronomica.MODID, name));
    }

    public static void bootstrap(BootstrapContext<Biome> context) {
        HolderGetter<PlacedFeature> featureGetter = context.lookup(Registries.PLACED_FEATURE);
        HolderGetter<ConfiguredWorldCarver<?>> carverGetter = context.lookup(Registries.CONFIGURED_CARVER);

        context.register(LUNAR_PLAINS, new Biome.BiomeBuilder()
                .generationSettings(new BiomeGenerationSettings.Builder(featureGetter, carverGetter)
                                .build())
                .mobSpawnSettings(new MobSpawnSettings.Builder()
                        .build())
                .hasPrecipitation(false)
                .downfall(0.0F)
                .temperature(0.0F)
                .specialEffects(new BiomeSpecialEffects.Builder()
                        .skyColor(0)
                        .fogColor(0)
                        .waterColor(4159204)
                        .waterFogColor(329011)
                        .build())
                .build()
        );

        context.register(ERSATZ_FOREST, new Biome.BiomeBuilder()
                .generationSettings(new BiomeGenerationSettings.Builder(featureGetter, carverGetter)
                        .build())
                .mobSpawnSettings(new MobSpawnSettings.Builder()
                        .build())
                .hasPrecipitation(true)
                .downfall(0.8F)
                .temperature(0.8F)
                .specialEffects(new BiomeSpecialEffects.Builder()
                        .skyColor(9355132)
                        .fogColor(12648387)
                        .waterColor(4159204)
                        .waterFogColor(329011)
                        .build())
                .build()
        );

        context.register(VESTIGE_WASTES, new Biome.BiomeBuilder()
                .generationSettings(new BiomeGenerationSettings.Builder(featureGetter, carverGetter)
                        .build())
                .mobSpawnSettings(new MobSpawnSettings.Builder()
                        .build())
                .hasPrecipitation(true)
                .downfall(0.8F)
                .temperature(0.3F)
                .specialEffects(new BiomeSpecialEffects.Builder()
                        .skyColor(0)
                        .fogColor(0)
                        .waterColor(4159204)
                        .waterFogColor(329011)
                        .build())
                .build()
        );

        context.register(NOTHINGNESS, new Biome.BiomeBuilder()
                .generationSettings(new BiomeGenerationSettings.Builder(featureGetter, carverGetter)
                        .build())
                .mobSpawnSettings(new MobSpawnSettings.Builder()
                        .build())
                .hasPrecipitation(false)
                .downfall(0.0F)
                .temperature(0.0F)
                .specialEffects(new BiomeSpecialEffects.Builder()
                        .skyColor(0)
                        .fogColor(0)
                        .waterColor(4159204)
                        .waterFogColor(329011)
                        .build())
                .build()
        );
    }

    public static BiomeSource luna(HolderGetter<Biome> biomes) {
        return MultiNoiseBiomeSource.createFromList(new Climate.ParameterList<>(ImmutableList.of(
                Pair.of(Climate.parameters(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), biomes.getOrThrow(LUNAR_PLAINS))
        )));
    }

    public static BiomeSource ersatz(HolderGetter<Biome> biomes) {
        return MultiNoiseBiomeSource.createFromList(new Climate.ParameterList<>(ImmutableList.of(
                Pair.of(Climate.parameters(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), biomes.getOrThrow(ERSATZ_FOREST))
        )));
    }

    public static BiomeSource vestige(HolderGetter<Biome> biomes) {
        return MultiNoiseBiomeSource.createFromList(new Climate.ParameterList<>(ImmutableList.of(
                Pair.of(Climate.parameters(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), biomes.getOrThrow(VESTIGE_WASTES))
        )));
    }

    public static BiomeSource nothingness(HolderGetter<Biome> biomes) {
        return new FixedBiomeSource(biomes.getOrThrow(NOTHINGNESS));
    }
}
