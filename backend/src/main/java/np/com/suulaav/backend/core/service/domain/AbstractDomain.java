package np.com.suulaav.backend.core.service.domain;

import lombok.Data;

/**
 * @author Sulav created on 10/23/23
 */
@Data
public class AbstractDomain implements Domain{
    private String createdOn;
    private String createdBy;
    private String lastModifiedBy;
    private String lastModifiedOn;
    private String deletedBy;
    private String deletedOn;
    private boolean active;
    private boolean deleted;
    private String id;

    @Override
    public void validate() {

    }
}
