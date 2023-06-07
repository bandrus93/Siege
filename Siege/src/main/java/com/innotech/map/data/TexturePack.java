package com.innotech.map.data;

import com.innotech.map.biome.Biome;

import java.util.*;

public class TexturePack implements Comparator<Texture> {
    private String climateTag;
    private String ecoTag;
    private List<Texture> textures = new ArrayList<>();
    private Texture defaultTexture;

    public TexturePack() {}

    public String getClimateTag() {
        return climateTag;
    }

    public void setClimateTag(String climateTag) {
        this.climateTag = climateTag;
    }

    public String getEcoTag() {
        return ecoTag;
    }

    public void setEcoTag(String ecoTag) {
        this.ecoTag = ecoTag;
    }

    public List<Texture> getTextures() {
        return textures;
    }

    public void setTextures(List<Texture> textures) {
        this.textures = textures;
    }

    public Texture getDefaultTexture() { return defaultTexture; }

    public void setDefaultTexture(Texture texture) { this.defaultTexture = texture; }

    public Texture getRandomTexture() {
        Random random = new Random();
        int selector = random.nextInt(getWeightTotals() + 1);
        int incrementer = 0;
        textures.sort(this);
        for (Texture texture : textures) {
            incrementer += texture.getWeight();
            if (incrementer >= selector) return texture;
        }
        return defaultTexture;
    }

    private int getWeightTotals() {
        int total = 0;
        for (Texture texture : textures) {
            total += texture.getWeight();
        }
        return total;
    }

    @Override
    public int compare(Texture o1, Texture o2) {
        return o1.getWeight() - o2.getWeight();
    }
}
