package ch.bbw.jl.idunno.services;

import ch.bbw.jl.idunno.Repositories.HistoryRepository;
import ch.bbw.jl.idunno.entity.History;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryService {

    private HistoryRepository historyRepository;

    public HistoryService(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    public List<History> findAll() {
        return historyRepository.findAll();
    }

    public History createHistory(History history) {
        return historyRepository.saveAndFlush(history);
    }

}
