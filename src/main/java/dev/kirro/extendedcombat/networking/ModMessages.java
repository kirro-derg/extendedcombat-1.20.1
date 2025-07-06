package dev.kirro.extendedcombat.networking;

import dev.kirro.extendedcombat.ExtendedCombat;
import net.minecraft.util.Identifier;

public class ModMessages {
    public static final Identifier RENDER_PACKET = new Identifier(ExtendedCombat.MOD_ID, "render_packet");
    public static final Identifier RENDER_PACKET_SYNC = new Identifier(ExtendedCombat.MOD_ID, "render_packet_sync");
    public static final Identifier EXAMPLE = new Identifier(ExtendedCombat.MOD_ID, "example");

    public static void registerC2SPackets() {

    }

    public static void registerS2CPackets() {

    }
}
