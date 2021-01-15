package ch.bbw.jl.idunno.controller;

import ch.bbw.jl.idunno.dao.DadJokeDao;
import ch.bbw.jl.idunno.dao.PokemonDao;
import ch.bbw.jl.idunno.entity.DadJoke;
import ch.bbw.jl.idunno.entity.Pokemon;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/pokemon")
public class PokemonController {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Pokemon> getPokemon() {
        return PokemonDao.requestPokemonList();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Pokemon getPokemonById(@PathVariable int id) {
        return PokemonDao.getPokemonById(id);
    }
}
