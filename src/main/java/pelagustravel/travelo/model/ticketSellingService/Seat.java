package pelagustravel.travelo.model.ticketSellingService;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "seat")
@Data
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seat_id")
    private long seatId;

    @Column(name = "class")
    private String seatClass;

    @ManyToOne
    @JoinColumn(name = "airplane_id")
    private Airplane airplane;
}
