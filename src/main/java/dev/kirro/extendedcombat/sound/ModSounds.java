package dev.kirro.extendedcombat.sound;

import dev.kirro.extendedcombat.ExtendedCombat;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {


    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.of(ExtendedCombat.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }


    public static void registerSounds() {
        ExtendedCombat.LOGGER.info("Registering mod sounds for " + ExtendedCombat.MOD_ID);
    }
}
