package ch.bbw.jl.idunno.controller;

import ch.bbw.jl.idunno.dao.DadJokeDao;
import ch.bbw.jl.idunno.entity.DadJoke;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dadjoke")
public class DadJokeController {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public DadJoke getDadJoke() {
        return DadJokeDao.requestRandomDadJoke();
    }
}
