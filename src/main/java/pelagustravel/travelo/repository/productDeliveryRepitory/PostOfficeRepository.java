package pelagustravel.travelo.repository.productDeliveryRepitory;

import org.springframework.data.jpa.repository.JpaRepository;
import pelagustravel.travelo.model.productDeliveryService.PostOffice;

public interface PostOfficeRepository extends JpaRepository<PostOffice,Long> {
    PostOffice findByPostOfficeName(String name);
}
