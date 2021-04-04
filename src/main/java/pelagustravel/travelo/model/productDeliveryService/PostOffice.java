package pelagustravel.travelo.model.productDeliveryService;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "post_office")
@Data
public class PostOffice {
    @Id
    @Column(name = "post_office_id")
    @GeneratedValue(generator = "post_office_gen")
    @SequenceGenerator(name = "post_office_gen",sequenceName = "post_office_id_seq",allocationSize = 1)
    private long id;

    @Column(name = "post_office_name")
    private String postOfficeName;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "postOffice")
    Set<Order> orders;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostOffice that = (PostOffice) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
