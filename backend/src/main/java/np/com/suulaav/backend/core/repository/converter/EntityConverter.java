package np.com.suulaav.backend.core.repository.converter;

import np.com.suulaav.backend.core.repository.entity.Entity;
import np.com.suulaav.backend.core.service.domain.Domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sulav created on 10/23/23
 */
public interface EntityConverter<D extends Domain,E extends Entity> extends Converter{

    D toDomain(E entity);
    E toEntity(D domain);
    default List<D> toDomainList(List<E> entities){
        List<D> domains = new ArrayList<>();
        entities.forEach(e -> domains.add(toDomain(e)));
        return domains;
    }


}
