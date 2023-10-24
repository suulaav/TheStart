package np.com.suulaav.backend.reposotary.converter.user;

import np.com.suulaav.backend.core.repository.converter.AbstractConverter;
import np.com.suulaav.backend.reposotary.entity.user.UserEntity;
import np.com.suulaav.backend.service.domain.user.UserDomain;
import org.springframework.beans.BeanUtils;

import java.util.Objects;

/**
 * @author Sulav created on 10/23/23
 */
public class UserConverter extends AbstractConverter<UserDomain, UserEntity> {

  @Override
  protected UserEntity toEntityBase(UserDomain domain) {
    if (!Objects.isNull(domain)) {
      UserEntity entity = new UserEntity();
      BeanUtils.copyProperties(domain, entity);
      return entity;
    }
    return null;
  }

  @Override
  protected UserDomain toDomainBase(UserEntity entity) {
    if (!Objects.isNull(entity)) {
      UserDomain domain = new UserDomain();
      BeanUtils.copyProperties(entity, domain);
      return domain;
    }
    return null;
  }
}
