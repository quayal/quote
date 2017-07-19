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
    @Autowired
    private QuotationRepository quotationRepository;

/*    @PostConstruct
    public void doSth() {

        quotationRepository.save(new Quotation("Sąd", "dodanie funkcji zwalniania niepokornych sędziów"));
        quotationRepository.save(new Quotation("Sąd", "dodanie funkcji robienia kawy"));
        quotationRepository.save(new Quotation("Sąd", "dodanie katalogu myślozbrodni"));
        quotationRepository.save(new Quotation("Sąd", "dodanie możliwości samokrytyki"));
        quotationRepository.save(new Quotation("Sąd", "dodanie przyspieszonej ścieżki awansu"));

        }*/
    }

