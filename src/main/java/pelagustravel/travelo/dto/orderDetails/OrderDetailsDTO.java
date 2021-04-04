package pelagustravel.travelo.dto.orderDetails;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pelagustravel.travelo.dto.ProductDTO;
import pelagustravel.travelo.dto.CountryDTO;
import pelagustravel.travelo.dto.OrderDTO;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailsDTO {
    private ProductDTO product;
    private OrderDTO order;
    private long price;
    private long quantity;
    private CountryDTO fromCountry;
    private CountryDTO toCountry;
}
