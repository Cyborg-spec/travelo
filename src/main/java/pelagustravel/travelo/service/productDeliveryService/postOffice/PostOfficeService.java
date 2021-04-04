package pelagustravel.travelo.service.productDeliveryService.postOffice;

import pelagustravel.travelo.model.productDeliveryService.PostOffice;

import java.util.Optional;

public interface PostOfficeService {
    void save(PostOffice postOffice);
    PostOffice findByPostOfficeName(String name);
    Optional<PostOffice>findById(long id);
}
