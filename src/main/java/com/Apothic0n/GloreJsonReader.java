package com.Apothic0n;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import net.fabricmc.loader.api.FabricLoader;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class GloreJsonReader {
    public static Map<String, Integer> customBlocks;
    public static void main() throws Exception {
        makeConfig(Path.of(FabricLoader.getInstance().getConfigDir() + "/glore.json"));
    }

    private static void makeConfig(Path path) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        if (!Files.exists(path)) {
            Files.write(path, ("{\n" +
                                "  \"minecraft:coal_ore\":4,\n" +
                                "  \"minecraft:deepslate_coal_ore\":4,\n" +
                                "  \"minecraft:iron_ore\":4,\n" +
                                "  \"minecraft:deepslate_iron_ore\":4,\n" +
                                "  \"minecraft:copper_ore\":7,\n" +
                                "  \"minecraft:deepslate_copper_ore\":7,\n" +
                                "  \"minecraft:lapis_ore\":7,\n" +
                                "  \"minecraft:deepslate_lapis_ore\":7,\n" +
                                "  \"minecraft:gold_ore\":10,\n" +
                                "  \"minecraft:deepslate_gold_ore\":10,\n" +
                                "  \"minecraft:emerald_ore\":12,\n" +
                                "  \"minecraft:deepslate_emerald_ore\":12,\n" +
                                "  \"minecraft:diamond_ore\":15,\n" +
                                "  \"minecraft:deepslate_diamond_ore\":15\n" +
                                "}").getBytes());
        }
        JsonReader reader = new JsonReader(new FileReader(path.toString()));
        JsonObject data = gson.fromJson(reader, JsonObject.class);

        Map<String, Integer> tempCustomBlocks = new java.util.HashMap<>(Map.of());
        data.asMap().forEach((block, brightness) -> tempCustomBlocks.put(block, brightness.getAsInt()));

        customBlocks = tempCustomBlocks;
    }
}
