package np.com.suulaav.backend.core.repository.api;

import java.util.List;
import java.util.Optional;
import np.com.suulaav.backend.core.repository.entity.Entity;
import np.com.suulaav.backend.core.service.domain.Domain;
import np.com.suulaav.backend.core.service.filter.Filter;

/**
 * @author Sulav created on 10/23/23
 */
public interface CRUDDao<D extends Domain, E extends Entity, F extends Filter> extends BaseDao{

  D insert(E entity);

  D update(E entity);

  void delete(F filter);

  Optional<D> findOne(F filter);

  List<D> findAll(F filter);

  List<D> findAllWithPagination(F filter);
}
