package pelagustravel.travelo.model.ticketSellingService;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "flight")
@Data
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flight_id")
    private long flightId;

    @Column(name = "boarding_time")
    private LocalTime boardingTime;

    @Column(name = "departing_time")
    private LocalTime departingTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "to_country",referencedColumnName = "country_id")
    private Country toCountry;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "from_country",referencedColumnName = "country_id")
    private Country fromCountry;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "airplane_id")
    private Airplane airplane;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "flight")
    private Set<Ticket> tickets;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return flightId == flight.flightId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightId);
    }
}
