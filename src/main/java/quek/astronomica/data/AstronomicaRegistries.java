package quek.astronomica.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import quek.astronomica.Astronomica;
import quek.astronomica.registry.AstronomicaBiomes;
import quek.astronomica.registry.AstronomicaDimensions;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class AstronomicaRegistries extends DatapackBuiltinEntriesProvider {

    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.BIOME, AstronomicaBiomes::bootstrap)
            .add(Registries.DIMENSION_TYPE, AstronomicaDimensions::bootstrapType)
            .add(Registries.LEVEL_STEM, AstronomicaDimensions::bootstrapStem)
            .add(Registries.NOISE_SETTINGS, AstronomicaDimensions::bootstrapNoise);

    public AstronomicaRegistries(PackOutput output, CompletableFuture<HolderLookup.Provider> provider) {
        super(output, provider, BUILDER, Set.of("minecraft", Astronomica.MODID));
    }
}
