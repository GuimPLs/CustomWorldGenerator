package pl.guimpl.customworldgenerator;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.generator.ChunkGenerator.ChunkData;
import java.util.Random;

public class CustomChunkGenerator extends ChunkGenerator {

    @Override
    public ChunkData generateChunkData(World world, Random random, int x, int z, BiomeGrid biome) {
        ChunkData chunkData = createChunkData(world);

        for (int i = 0; i < 64; i++) {
            chunkData.setRegion(0, i, 0, 16, i + 1, 16, (i == 63) ? Material.GRASS_BLOCK : Material.DIRT);
        }

        return chunkData;
    }
}
