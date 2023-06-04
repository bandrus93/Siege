package com.innotech.map.data;

import com.innotech.map.biome.Biome;

import java.util.ArrayList;
import java.util.List;

public class TexturePack {
    private String climateTag;
    private String ecoTag;
    private List<Texture> textures = new ArrayList<>();

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
}
