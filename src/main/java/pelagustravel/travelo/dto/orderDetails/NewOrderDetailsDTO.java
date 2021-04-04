package pelagustravel.travelo.dto.orderDetails;


import lombok.Data;

@Data
public class NewOrderDetailsDTO {
    private String postOfficeName;
    private long productWeight;
    private long quantity;
    private String fromCountry;
    private String toCountry;
}
