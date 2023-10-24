package np.com.suulaav.backend.reposotary.impl;

import java.util.List;
import java.util.Optional;
import np.com.suulaav.backend.reposotary.api.user.UserDao;
import np.com.suulaav.backend.reposotary.api.user.UserRepository;
import np.com.suulaav.backend.reposotary.converter.user.UserConverter;
import np.com.suulaav.backend.reposotary.entity.user.UserEntity;
import np.com.suulaav.backend.service.domain.user.UserDomain;
import np.com.suulaav.backend.service.filter.user.DefaultUserFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Sulav created on 10/23/23
 */
@Component
public class UserDaoImpl implements UserDao {

  private final UserRepository userRepository;

  @Autowired
  public UserDaoImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserDomain insert(UserEntity entity) {
    return new UserConverter().toDomain(userRepository.insert(entity));
  }

  @Override
  public UserDomain update(UserEntity entity) {
    return new UserConverter().toDomain(userRepository.insert(entity));
  }

  @Override
  public void delete(DefaultUserFilter filter) {
    userRepository.deleteById(filter.getId());
  }

  @Override
  public Optional<UserDomain> findOne(DefaultUserFilter filter) {
    Optional<UserEntity> optionalUserEntity = this.userRepository.findById(filter.getId());
    return optionalUserEntity.map(userEntity -> new UserConverter().toDomain(userEntity));
  }

  @Override
  public List<UserDomain> findAll(DefaultUserFilter filter) {
    return new UserConverter().toDomainList(this.userRepository.findAll());
  }

  @Override
  public List<UserDomain> findAllWithPagination(DefaultUserFilter filter) {
    return new UserConverter().toDomainList(this.userRepository.findAll());
  }

  @Override
  public Optional<UserDomain> findOneByUserName(DefaultUserFilter filter) {
    return this.userRepository
        .findOneByUserName(filter.getUserName())
        .map(userEntity -> new UserConverter().toDomain(userEntity));
  }
}
