package pl.loysys.app.data.functionality;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.loysys.app.data.item.Item;
import pl.loysys.app.data.quotation.Quotation;
import pl.loysys.app.data.quotation.QuotationRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toList;

@Service
public class FunctionalityService {

    private final FunctionalityRepository functionalityRepository;
    private final QuotationRepository quotationRepository;
    private final FunctionalityMapper functionalityMapper;

    @Autowired
    public FunctionalityService(FunctionalityRepository functionalityRepository,
                                QuotationRepository quotationRepository,
                                FunctionalityMapper functionalityMapper) {
        this.functionalityRepository = functionalityRepository;
        this.quotationRepository = quotationRepository;
        this.functionalityMapper = functionalityMapper;
    }


    public FunctionalityTO addFunctionality(FunctionalityTO functionalityTO) {
        Quotation quotationToSave = quotationRepository.findById(functionalityTO.getQuotationId());
        quotationToSave.addFunctionality(functionalityRepository.findById(functionalityTO.getId()));
        quotationRepository.save(quotationToSave);
        return functionalityTO;
    }

    public List<FunctionalityTO> readAllFunctionalities(){
        return StreamSupport.stream(functionalityRepository.findAll().spliterator(), true).map(functionalityMapper::map)
                .collect(toList());
    }

    public List<Functionality> getAllFunctionalities() {
        List<Functionality> functionalityList = new ArrayList<>();
        functionalityRepository.findAll().forEach(functionalityList::add);
        return functionalityList;
    }

    public void addItem(Functionality functionality, Item item) {
        functionality.addItem(item);
    }

    public Functionality getFunctionalityDetails(Long id) {
        return functionalityRepository.findById(id);
    }

}

