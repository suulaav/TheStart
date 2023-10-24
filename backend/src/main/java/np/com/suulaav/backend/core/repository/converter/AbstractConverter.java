package np.com.suulaav.backend.core.repository.converter;

import np.com.suulaav.backend.core.repository.entity.Entity;
import np.com.suulaav.backend.core.service.domain.Domain;

import java.util.List;

/**
 * @author Sulav created on 10/23/23
 */
public abstract class AbstractConverter<D extends Domain, E extends Entity>
    implements EntityConverter<D, E> {

  @Override
  public D toDomain(E entity) {
    D domain = this.toDomainBase(entity);
    domain.setCreatedBy(entity.getCreatedBy());
    domain.setCreatedOn(entity.getCreatedOn());
    domain.setLastModifiedBy(entity.getLastModifiedBy());
    domain.setLastModifiedOn(entity.getLastModifiedOn());
    domain.setDeletedBy(entity.getDeletedBy());
    domain.setDeletedOn(entity.getDeletedOn());
    domain.setActive(entity.isActive());
    domain.setDeleted(entity.isDeleted());
    domain.setId(entity.getId());
    return domain;
  }

  @Override
  public E toEntity(D domain) {
    E entity = this.toEntityBase(domain);
    entity.setId(domain.getId());
    entity.setActive(domain.isActive());
    entity.setDeleted(domain.isDeleted());
    entity.setCreatedBy(domain.getCreatedBy());
    entity.setCreatedOn(domain.getCreatedOn());
    entity.setLastModifiedBy(domain.getLastModifiedBy());
    entity.setLastModifiedOn(domain.getLastModifiedOn());
    entity.setDeletedBy(domain.getDeletedBy());
    entity.setDeletedOn(domain.getDeletedOn());
    return entity;
  }

  protected abstract E toEntityBase(D domain);

  protected abstract D toDomainBase(E entity);
}
