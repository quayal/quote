package pl.loysys.app.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class DataInitialiser {
    private static final Logger log = LoggerFactory.getLogger(DataInitialiser.class);
    @Autowired
    private FunctionalityRepository functionalityRepository;

    @PostConstruct
    public void doSth() {
        functionalityRepository.save(new Functionality("Functionality one"));
        functionalityRepository.save(new Functionality("Functionality two"));
        functionalityRepository.save(new Functionality("Functionality three"));
        functionalityRepository.save(new Functionality("Functionality four"));
        functionalityRepository.save(new Functionality("Functionality five"));

        log.info("Functionalites added");
        for (Functionality qf : functionalityRepository.findAll()) {
            log.info(qf.toString());
        }
    }
}
