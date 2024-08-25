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

        // Automatyczne generowanie nowego świata przy starcie
        createCustomWorld();
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("CustomWorldGenerator jest wyłączany!");
    }

    public void createCustomWorld() {
        // Tworzenie nowego świata o nazwie "custom_world"
        WorldCreator creator = new WorldCreator("custom_world");
        creator.environment(World.Environment.NORMAL); // Świat normalny (Overworld)
        creator.type(WorldType.NORMAL); // Standardowy typ świata
        creator.generator(new CustomChunkGenerator()); // Ustawienie niestandardowego generatora chunków

        World world = Bukkit.createWorld(creator);
        if (world != null) {
            Bukkit.getLogger().info("Stworzono niestandardowy świat: " + world.getName());
        } else {
            Bukkit.getLogger().warning("Nie udało się stworzyć świata!");
        }
    }

    // Klasa generatora chunków (na razie prosta)
    public static class CustomChunkGenerator extends ChunkGenerator {
        // W przyszłości możemy tu dodać niestandardową generację chunków
    }
}
