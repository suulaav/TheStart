package np.com.suulaav.backend.reposotary.api.user;

import np.com.suulaav.backend.reposotary.entity.user.UserEntity;
import np.com.suulaav.backend.service.domain.user.UserDomain;
import np.com.suulaav.backend.service.filter.user.DefaultUserFilter;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

/**
 * @author Sulav created on 10/23/23
 */
public interface UserRepository extends MongoRepository<UserEntity, String> {
    Optional<UserEntity> findOneByUserName(String userName);
}
