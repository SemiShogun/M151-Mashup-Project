package ch.bbw.jl.idunno.controller;

import ch.bbw.jl.idunno.dao.PokemonDao;
import ch.bbw.jl.idunno.entity.History;
import ch.bbw.jl.idunno.entity.Pokemon;
import ch.bbw.jl.idunno.services.HistoryService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/pokemon")
public class PokemonController {

    private final HistoryService historyService;

    public PokemonController(HistoryService historyService) {
        this.historyService = historyService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Pokemon> getPokemon() {
        History history = new History();
        history.setRequest("localhost:8080/pokemon");
        history.setResponseCode("200");
        historyService.createHistory(history);
        return PokemonDao.requestPokemonList();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Pokemon getPokemonById(@PathVariable int id, HttpServletResponse res) {
        History history = new History();
        history.setRequest("localhost:8080/pokemon/" + id);
        history.setResponseCode(String.valueOf(res.getStatus()));
        historyService.createHistory(history);
        return PokemonDao.getPokemonById(id);
    }

    @GetMapping("/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public Pokemon getPokemonByName(@PathVariable String name, HttpServletResponse res) {
        History history = new History();
        history.setRequest("localhost:8080/pokemon/name/" + name);
        history.setResponseCode(String.valueOf(res.getStatus()));
        historyService.createHistory(history);
        return PokemonDao.getPokemonByName(name);
    }
}
