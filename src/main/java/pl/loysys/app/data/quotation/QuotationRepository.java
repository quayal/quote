package pl.loysys.app.data.quotation;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface QuotationRepository extends CrudRepository<Quotation, Long>{
    List<Quotation> findByClientId(Long clientId);
    Quotation findById(Long id);
}
