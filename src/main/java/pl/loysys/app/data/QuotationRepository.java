package pl.loysys.app.data;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface QuotationRepository extends CrudRepository<Quotation, Long>{
    List<Quotation> findByClientId(Long clientId);
    Quotation findByName(String quotationName);
}
