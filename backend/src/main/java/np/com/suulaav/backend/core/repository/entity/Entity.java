package np.com.suulaav.backend.core.repository.entity;

/**
 * @author Sulav created on 10/23/23
 */
public interface Entity {
    String getCreatedOn();

    void setCreatedOn(String createdOn);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    String getLastModifiedBy();

    void setLastModifiedBy(String lastModifiedBy);

    String getLastModifiedOn();

    void setLastModifiedOn(String lastModifiedOn);

    String getDeletedBy();

    void setDeletedBy(String deletedBy);

    String getDeletedOn();

    void setDeletedOn(String deletedOn);

    boolean isActive();

    void setActive(boolean active);

    boolean isDeleted();

    void setDeleted(boolean deleted);

    String getId();

    void setId(String id);

}
