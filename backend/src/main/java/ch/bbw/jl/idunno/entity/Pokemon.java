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
//    @SerializedName("species")
//    private List<Specie> species;
//    @SerializedName("sprites")
//    private List<Sprite> sprites;
//    @SerializedName("stats")
//    private List<Stat> stats;
//    @SerializedName("types")
//    private List<Type> types;
//    @SerializedName("weight")
//    private int weight;


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
}
