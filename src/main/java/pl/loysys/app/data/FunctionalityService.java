package pl.loysys.app.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FunctionalityService {

    public FunctionalityService() {
    }

    public FunctionalityService(Functionality functionality) {
    }

    @Autowired
    private FunctionalityRepository functionalityRepository;

    @Autowired
    private QuotationRepository quotationRepository;


    public FunctionalityTO addFunctionality(FunctionalityTO functionalityTO) {
        Functionality toSave = new Functionality(functionalityTO.getName());
        toSave.addQuotationToList(quotationRepository.findById(functionalityTO.getQuotationId()));
        functionalityRepository.save(toSave);
        return functionalityTO;
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

