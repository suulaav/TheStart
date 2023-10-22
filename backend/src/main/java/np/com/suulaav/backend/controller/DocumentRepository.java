package np.com.suulaav.backend.controller;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface DocumentRepository extends MongoRepository<Items, String> {
}