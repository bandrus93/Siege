package com.innotech.map.data;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MapData {
    private final List<TexturePack> texturePacks = new ArrayList<>();

    private MapData() {

    }

    public List<TexturePack> getTexturePacks() {
        return texturePacks;
    }

    public static class Loader {
        private final MapData data = new MapData();

        public Loader loadTexturePacks() throws IOException {
            BufferedReader textureReader = new BufferedReader(new FileReader("src/main/resources/map/terrain/textures/textures.txt"));
            String texturePack;
            Gson gson = new Gson();
            while ((texturePack = textureReader.readLine()) != null) {
                texturePack = texturePack.trim().charAt(0) == ',' ? texturePack.trim().substring(1) : texturePack.trim();
                if (!(texturePack.equals("[") || texturePack.equals("]"))) data.texturePacks.add(gson.fromJson(texturePack, TexturePack.class));
            }
            textureReader.close();
            return this;
        }

        public MapData load() {
            return data;
        }
    }
}
