package quek.astronomica;

import net.minecraft.DetectedVersion;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.metadata.PackMetadataGenerator;
import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.metadata.pack.PackMetadataSection;
import net.minecraft.util.InclusiveRange;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.registries.DeferredRegister;
import quek.astronomica.data.AstronomicaBlockStates;
import quek.astronomica.data.AstronomicaItemModels;
import quek.astronomica.data.AstronomicaLang;
import quek.astronomica.data.AstronomicaRegistries;
import quek.astronomica.registry.AstronomicaBlocks;
import quek.astronomica.registry.AstronomicaItems;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Mod(Astronomica.MODID)
public class Astronomica {

    public static final String MODID = "astronomica";

    public Astronomica(IEventBus bus) {
        bus.addListener(this::gatherData);

        DeferredRegister<?>[] registers = {
                AstronomicaBlocks.BLOCKS,
                AstronomicaItems.ITEMS
        };

        for (DeferredRegister<?> register : registers) {
            register.register(bus);
        }
    }

    public void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> provider = event.getLookupProvider();
        ExistingFileHelper helper = event.getExistingFileHelper();

        generator.addProvider(event.includeClient(), new AstronomicaBlockStates(output, helper));
        generator.addProvider(event.includeClient(), new AstronomicaItemModels(output, helper));
        generator.addProvider(event.includeClient(), new AstronomicaLang(output));

        DatapackBuiltinEntriesProvider datapackProvider = new AstronomicaRegistries(output, provider);
        generator.addProvider(event.includeServer(), datapackProvider);

        generator.addProvider(true, new PackMetadataGenerator(output).add(PackMetadataSection.TYPE, new PackMetadataSection(
                Component.literal("Astronomica resources"),
                DetectedVersion.BUILT_IN.getPackVersion(PackType.SERVER_DATA),
                Optional.of(new InclusiveRange<>(0, Integer.MAX_VALUE))
        )));
    }
}
