package com.innotech.map;

import java.util.Random;

public class Biome {
    private final Climate climate;
    private final Ecology ecology;
    private static final Random generator = new Random();
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

    private Biome(Climate climate, Ecology ecology) {
        this.climate = climate;
        this.ecology = ecology;
    }

    public static Biome getInstance() {
        Climate climateZone = fetchClimate(generator.nextInt(Climate.values().length));
        Ecology ecoZone = fetchEcology(generator.nextInt(Ecology.values().length));
        return new Biome(climateZone, ecoZone);
    }

    private static Climate fetchClimate(int index) {
        for (Climate candidate : Climate.values()) {
            if (candidate.ordinal() == index) return candidate;
        }
        return Climate.TEMPERATE;
    }

    private static Ecology fetchEcology(int index) {
        for (Ecology candidate : Ecology.values()) {
            if (candidate.ordinal() == index) return candidate;
        }
        return Ecology.PLAINS;
    }
}
