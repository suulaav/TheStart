package np.com.suulaav.backend.core.service.domain;

/**
 * @author Sulav created on 10/23/23
 */
public interface Domain {
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

    void validate();
}
