package pl.tomasz_reda.praca_magisterska.soap_vs_rest.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.email.EmailTemplate;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.email.EmailTemplateType;


@RepositoryRestResource
public interface EmailTemplateRepository extends JpaRepository<EmailTemplate, EmailTemplateType> {
}
