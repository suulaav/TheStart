package np.com.suulaav.backend.reposotary.api.user;

import np.com.suulaav.backend.core.repository.api.CRUDDao;
import np.com.suulaav.backend.reposotary.entity.user.UserEntity;
import np.com.suulaav.backend.service.domain.user.UserDomain;
import np.com.suulaav.backend.service.filter.user.DefaultUserFilter;

import java.util.Optional;

/**
 * @author Sulav created on 10/24/23
 */
public interface UserDao extends CRUDDao<UserDomain, UserEntity, DefaultUserFilter> {
    Optional<UserDomain> findOneByUserName(DefaultUserFilter filter);
}
