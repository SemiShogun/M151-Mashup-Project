package ch.bbw.jl.idunno.entity;

import ch.bbw.jl.idunno.entity.pokeapi.*;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Pokemon {

    @SerializedName("id")
    private int id;
    @SerializedName("abilities")
    private List<Abilities> abilities;
    @SerializedName("base_experience")
    private int base_experience;
    @SerializedName("forms")
    private List<Form> forms;
    @SerializedName("height")
    private int height;
    @SerializedName("moves")
    private List<Moves> moves;
    @SerializedName("name")
    private String name;
    @SerializedName("species")
    private Specie species;
    @SerializedName("sprites")
    private Sprite sprites;
    @SerializedName("stats")
    private List<Stats> stats;
    @SerializedName("types")
    private List<Types> types;
    @SerializedName("weight")
    private int weight;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Abilities> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Abilities> abilities) {
        this.abilities = abilities;
    }

    public int getBase_experience() {
        return base_experience;
    }

    public void setBase_experience(int base_experience) {
        this.base_experience = base_experience;
    }

    public List<Form> getForms() {
        return forms;
    }

    public void setForms(List<Form> forms) {
        this.forms = forms;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public List<Moves> getMoves() {
        return moves;
    }

    public void setMoves(List<Moves> moves) {
        this.moves = moves;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Specie getSpecies() {
        return species;
    }

    public void setSpecies(Specie species) {
        this.species = species;
    }

    public Sprite getSprites() {
        return sprites;
    }

    public void setSprites(Sprite sprites) {
        this.sprites = sprites;
    }

    public List<Stats> getStats() {
        return stats;
    }

    public void setStats(List<Stats> stats) {
        this.stats = stats;
    }

    public List<Types> getTypes() {
        return types;
    }

    public void setTypes(List<Types> types) {
        this.types = types;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
