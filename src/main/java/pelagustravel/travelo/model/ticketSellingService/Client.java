package pelagustravel.travelo.model.ticketSellingService;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "client")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    @Id
    @Column(name = "client_id")
    @GeneratedValue(generator = "client_id_gen")
    @SequenceGenerator(name = "client_id_gen",sequenceName = "client_id_seq",allocationSize = 1)
    private long clientId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "passport")
    private String passport;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "airport_id")
    private Airport airport;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "client")
    private Set<Ticket> tickets;

    @Column(name = "phone")
    private String phone;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return clientId == client.clientId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId);
    }
}
