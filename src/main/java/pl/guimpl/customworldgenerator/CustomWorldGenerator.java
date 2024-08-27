package pl.guimpl.customworldgenerator;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.WorldType;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.java.JavaPlugin;

public class CustomWorldGenerator extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getLogger().info("CustomWorldGenerator jest aktywowany!");

        createCustomWorld();
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("CustomWorldGenerator jest wyłączany!");
    }

    public void createCustomWorld() {
        WorldCreator creator = new WorldCreator("custom_world");
        creator.environment(World.Environment.NORMAL); 
        creator.type(WorldType.NORMAL); 
        creator.generator(new CustomChunkGenerator()); 

        World world = Bukkit.createWorld(creator);
        if (world != null) {
            Bukkit.getLogger().info("Stworzono niestandardowy świat: " + world.getName());
        } else {
            Bukkit.getLogger().warning("Nie udało się stworzyć świata!");
        }
    }

    public static class CustomChunkGenerator extends ChunkGenerator {
    }
}
