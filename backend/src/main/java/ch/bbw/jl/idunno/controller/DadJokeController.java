package ch.bbw.jl.idunno.controller;

import ch.bbw.jl.idunno.dao.DadJokeDao;
import ch.bbw.jl.idunno.entity.DadJoke;
import ch.bbw.jl.idunno.entity.History;
import ch.bbw.jl.idunno.services.HistoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/dadjoke")
public class DadJokeController {

    private final HistoryService historyService;

    public DadJokeController(HistoryService historyService) {
        this.historyService = historyService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public DadJoke getDadJoke(HttpServletResponse res) {
        History history = new History();
        history.setRequest("localhost:8080/dadjoke");
        history.setResponseCode(String.valueOf(res.getStatus()));
        historyService.createHistory(history);
        return DadJokeDao.requestRandomDadJoke();
    }
}
