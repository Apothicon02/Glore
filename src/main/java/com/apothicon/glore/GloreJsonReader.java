package com.apothicon.glore;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import net.neoforged.fml.loading.FMLPaths;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class GloreJsonReader {
    public static Map<String, Integer> customBlocks;
    public static Map<String, Integer> customTrims;
    public static void main() throws Exception {
        makeConfig(Path.of(FMLPaths.CONFIGDIR.get() + "/glore.json"));
        makeTrimsConfig(Path.of(FMLPaths.CONFIGDIR.get() + "/glore_trims.json"));
    }

    public static void makeConfig(Path path) throws IOException {
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

    public static void makeTrimsConfig(Path path) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        if (!Files.exists(path)) {
            Files.write(path, ("{\n" +
                    "  \"amethyst\":4,\n" +
                    "  \"redstone\":2\n" +
                    "}").getBytes());
        }
        JsonReader reader = new JsonReader(new FileReader(path.toString()));
        JsonObject data = gson.fromJson(reader, JsonObject.class);

        Map<String, Integer> tempCustomTrims = new java.util.HashMap<>(Map.of());
        data.asMap().forEach((trim, brightness) -> tempCustomTrims.put(trim, brightness.getAsInt()));

        customTrims = tempCustomTrims;
    }
}