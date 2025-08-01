package me.tini.announcer.extension.impl.ultrapunishments;

import me.tini.announcer.PunishmentListener;
import me.tini.announcer.extension.AbstractExtension;
import me.tini.announcer.plugin.bukkit.BanAnnouncerBukkit;

public class UltraPunishmentsExtension extends AbstractExtension {

    private PunishmentListener listener;

    public UltraPunishmentsExtension(BanAnnouncerBukkit plugin) {
        this.listener = new UltraPunishmentsListener(plugin);
    }

    @Override
    public PunishmentListener getPunishmentListener() {
        return listener;
    }
}
