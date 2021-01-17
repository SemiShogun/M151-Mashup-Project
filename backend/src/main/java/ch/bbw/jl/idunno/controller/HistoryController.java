package ch.bbw.jl.idunno.controller;

import ch.bbw.jl.idunno.entity.History;
import ch.bbw.jl.idunno.services.HistoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/history")
public class HistoryController {

    private final HistoryService historyService;

    public HistoryController(HistoryService historyService) {
        this.historyService = historyService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<History> getAllRequests() {
        return historyService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public History saveRequest(@RequestBody History history) {
        return historyService.createHistory(history);
    }
}
