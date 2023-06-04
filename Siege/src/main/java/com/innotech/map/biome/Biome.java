package com.innotech.map.biome;

import com.innotech.map.data.TexturePack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Biome {
    private Climate climate;
    private Ecology ecology;
    private TexturePack data;
    public enum Climate {
        ARCTIC,
        SUBARCTIC,
        TEMPERATE,
        SUBTROPICAL,
        TROPICAL
    }
    public enum Ecology {
        PLAINS,
        ARBOREAL,
        RUGGED,
        COASTAL,
        WETLANDS
    }

    public enum Terrain {
        WATER,
        ROCKS,
        DIRT,
        SAND,
        GRASS,
        SHRUBS,
        CACTI,
        TREES,
        SNOW,
        ICE
    }

    private Biome() {

    }

    public Climate getClimate() {
        return climate;
    }

    public Ecology getEcology() {
        return ecology;
    }

    public static Climate fetchClimate(int index) {
        for (Climate candidate : Climate.values()) {
            if (candidate.ordinal() == index) return candidate;
        }
        return Climate.TEMPERATE;
    }

    public static Ecology fetchEcology(int index) {
        for (Ecology candidate : Ecology.values()) {
            if (candidate.ordinal() == index) return candidate;
        }
        return Ecology.PLAINS;
    }

    private TexturePack getDefaultTexturePack(List<TexturePack> texturePacks) {
        for (TexturePack pack : texturePacks) {
            if (pack.getEcoTag().equals(ecology.toString()) && pack.getClimateTag().equals("TEMPERATE")) {
                return pack;
            }
        }
        return null;
    }

    public static class Generator {
        private final Biome biome = new Biome();

        public Biome.Generator setClimate(Climate climate) {
            biome.climate = climate;
            return this;
        }

        public Biome.Generator setEcology(Ecology ecology) {
            biome.ecology = ecology;
            return this;
        }

        public Biome.Generator configureTextures(List<TexturePack> textures) {
            List<TexturePack> availablePacks = new ArrayList<>();
            TexturePack defaultPack = biome.getDefaultTexturePack(textures);
            for (TexturePack pack : textures) {
                if (pack.getClimateTag().equals(biome.climate.toString()) && pack.getEcoTag().equals(biome.ecology.toString())) {
                    availablePacks.add(pack);
                }
            }
            if (availablePacks.isEmpty()) availablePacks.add(defaultPack);
            int seed = new Random().nextInt(availablePacks.size());
            biome.data = availablePacks.get(seed);
            return this;
        }

        public Biome generate() {
            return biome;
        }
    }
}
