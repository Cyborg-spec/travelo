package pelagustravel.travelo.model.ticketSellingService;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pelagustravel.travelo.model.productDeliveryService.OrderDetails;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "country")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Country {
    @Id
    @Column(name = "country_id")
    private long countryId;
    @Column(name = "country_name")
    private String countryName;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "toCountry")
    private Set<Flight> toCountries;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "fromCountry")
    private Set<Flight>fromCountry;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "toCountry")
    private Set<OrderDetails>toCountryOrderDetails;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "fromCountry")
    private Set<OrderDetails>fromCountryOrderDetails;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return countryId == country.countryId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryId);
    }
}
