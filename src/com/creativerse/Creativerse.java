package com.creativerse;

import com.creativerse.commands.Save;
import com.creativerse.commands.Link;
import com.creativerse.commands.Sync;
import com.creativerse.commands.SyncAll;
import com.creativerse.files.CustomConfig;
import com.plotsquared.core.PlotSquared;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Creativerse extends JavaPlugin {

    @Override
    public void onEnable() {
        CustomConfig.setup();
        CustomConfig.get().addDefault("ETH-Node", "127.0.0.1:7545");
        CustomConfig.get().addDefault("IPFS-Node", "/ip4/127.0.0.1/tcp/5001");
        CustomConfig.get().addDefault("Transaction-Domain", "https://phazejeff.github.io/");
        CustomConfig.get().addDefault("Contract", "0x12B7795727334F18A3DF6388b0b2Ef4561b009BA");
        CustomConfig.get().addDefault("AutoSyncAll", "false");
        CustomConfig.get().addDefault("NFTStorageKey", "");
        CustomConfig.get().options().copyDefaults(true);
        CustomConfig.save();


        getCommand("save").setExecutor(new Save());
        getCommand("sync").setExecutor(new Sync());
        getCommand("link").setExecutor(new Link());
        getCommand("syncall").setExecutor(new SyncAll());
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Creativerse is enabled.");
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Creativerse is disabled.");
    }

}
