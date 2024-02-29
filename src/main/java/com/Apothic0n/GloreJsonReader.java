package com.Apothic0n;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import net.fabricmc.loader.api.FabricLoader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class GloreJsonReader {
    public static List<String> customBlocks;
    public static List<Integer> customBrightness;
    public static void main() throws Exception {
        makeCustomBlocks(Path.of(FabricLoader.getInstance().getGameDir().resolve("mods") + "/glore_blocks.json"));
        makeCustomBrightness(Path.of(FabricLoader.getInstance().getGameDir().resolve("mods") + "/glore_brightness.json"));
    }

    private static void makeCustomBlocks(Path path) throws IOException {
        Gson gson = new Gson();
        if (!Files.exists(path)) {
            JsonWriter writer = new JsonWriter(new FileWriter(path.toString()));
            JsonObject defaultData = gson.fromJson("{\"values\":[\"minecraft:coal_ore\",\"minecraft:deepslate_coal_ore\",\"minecraft:iron_ore\",\"minecraft:deepslate_iron_ore\",\"minecraft:copper_ore\",\"minecraft:deepslate_copper_ore\",\"minecraft:lapis_ore\",\"minecraft:deepslate_lapis_ore\",\"minecraft:gold_ore\",\"minecraft:deepslate_gold_ore\",\"minecraft:emerald_ore\",\"minecraft:deepslate_emerald_ore\",\"minecraft:diamond_ore\",\"minecraft:deepslate_diamond_ore\"]}", JsonObject.class);
            gson.toJson(defaultData, writer);
            writer.close();
        }
        JsonReader reader = new JsonReader(new FileReader(path.toString()));
        JsonObject data = gson.fromJson(reader, JsonObject.class);
        JsonArray customBlockNames = data.get("values").getAsJsonArray();
        List<String> tempCustomBlocks = new ArrayList<>(List.of());
        for (int i = 0; i < customBlockNames.size(); i++) {
            tempCustomBlocks.add(customBlockNames.get(i).getAsString());
        }
        customBlocks = tempCustomBlocks;
    }

    private static void makeCustomBrightness(Path path) throws IOException {
        Gson gson = new Gson();
        if (!Files.exists(path)) {
            JsonWriter writer = new JsonWriter(new FileWriter(path.toString()));
            JsonObject defaultData = gson.fromJson("{\"values\":[4,4,4,4,7,7,7,7,10,10,12,12,15,15]}", JsonObject.class);
            gson.toJson(defaultData, writer);
            writer.close();
        }
        JsonReader reader = new JsonReader(new FileReader(path.toString()));
        JsonObject data = gson.fromJson(reader, JsonObject.class);
        JsonArray gloreCustomBrightness = data.get("values").getAsJsonArray();
        List<Integer> tempCustomBrightness = new ArrayList<>(List.of());
        for (int i = 0; i < gloreCustomBrightness.size(); i++) {
            tempCustomBrightness.add(gloreCustomBrightness.get(i).getAsInt());
        }
        customBrightness = tempCustomBrightness;
    }
}
