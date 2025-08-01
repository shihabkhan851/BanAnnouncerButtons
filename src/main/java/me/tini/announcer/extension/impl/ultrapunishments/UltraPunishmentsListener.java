package me.tini.announcer.extension.impl.ultrapunishments;

import org.bukkit.event.EventHandler;

import me.TechsCode.UltraPunishments.event.BanEvent;
import me.TechsCode.UltraPunishments.event.FreezeEvent;
import me.TechsCode.UltraPunishments.event.KickEvent;
import me.TechsCode.UltraPunishments.event.ReportEvent;
import me.TechsCode.UltraPunishments.event.UnbanEvent;
import me.TechsCode.UltraPunishments.event.UnfreezeEvent;
import me.tini.announcer.PunishmentInfo;
import me.tini.announcer.plugin.bukkit.BanAnnouncerBukkit;
import me.tini.announcer.plugin.bukkit.BukkitPunishmentListener;

public final class UltraPunishmentsListener extends BukkitPunishmentListener {

    public UltraPunishmentsListener(BanAnnouncerBukkit plugin) {
        super(plugin);
    }

    @EventHandler
    public void onBan(BanEvent event) {
        final PunishmentInfo punishment = new PunishmentInfo();
        punishment.setType(PunishmentInfo.Type.BAN);
        punishment.setPermanent(true);
        punishment.setReason(event.getReason());
        punishment.setOperator(event.getIssuer().getName());
        punishment.setPlayer(event.getPlayer().getName());
        punishment.setPlayerId(event.getPlayer().getUniqueId().toString());

        handlePunishment(punishment);
    }

    @EventHandler
    public void onUnban(UnbanEvent event) {
        final PunishmentInfo punishment = new PunishmentInfo();
        punishment.setType(PunishmentInfo.Type.UNBAN);
        punishment.setOperator(event.getIssuer().getName());
        punishment.setPlayer(event.getPlayer().getName());
        punishment.setPlayerId(event.getPlayer().getUniqueId().toString());

        handlePunishment(punishment);
    }

    @EventHandler
    public void onKick(KickEvent event) {
        final PunishmentInfo punishment = new PunishmentInfo();
        punishment.setType(PunishmentInfo.Type.KICK);
        punishment.setReason(event.getReason());
        punishment.setOperator(event.getIssuer().getName());
        punishment.setPlayer(event.getPlayer().getName());
        punishment.setPlayerId(event.getPlayer().getUniqueId().toString());

        handlePunishment(punishment);
    }

    @EventHandler
    public void onReport(ReportEvent event) {
        // Currently not handled
    }

    @EventHandler
    public void onFreeze(FreezeEvent event) {
        // Currently not handled
    }

    @EventHandler
    public void onUnfreeze(UnfreezeEvent event) {
        // Currently not handled
    }
}
