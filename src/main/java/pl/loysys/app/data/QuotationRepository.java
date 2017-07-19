package pl.loysys.app.data;

import org.springframework.data.repository.CrudRepository;

public interface QuotationRepository extends CrudRepository<Quotation, Long>{
    Quotation findByClient(String clientName);
    Quotation findByName(String quotationName);
}
