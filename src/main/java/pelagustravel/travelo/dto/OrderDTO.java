package pelagustravel.travelo.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Objects;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private long id;
    private PostOfficeDTO postOffice;
    private LocalDate orderDate;
    private boolean isDelivered;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDTO orderDTO = (OrderDTO) o;
        return id == orderDTO.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
