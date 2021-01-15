package ch.bbw.jl.idunno.controller;

import ch.bbw.jl.idunno.dao.DadJokeDao;
import ch.bbw.jl.idunno.entity.DadJoke;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/dadjoke")
public class DadJokeController {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public DadJoke getDadJoke() {
        return DadJokeDao.requestRandomDadJoke();
    }
}
