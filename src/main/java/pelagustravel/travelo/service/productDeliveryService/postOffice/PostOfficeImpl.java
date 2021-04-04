package pelagustravel.travelo.service.productDeliveryService.postOffice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pelagustravel.travelo.model.productDeliveryService.PostOffice;
import pelagustravel.travelo.repository.productDeliveryRepitory.PostOfficeRepository;

import java.util.Optional;

@Service
@Transactional
public class PostOfficeImpl implements PostOfficeService{
    @Autowired
    private PostOfficeRepository postOfficeRepository;

    @Override
    public void save(PostOffice postOffice) {
        postOfficeRepository.save(postOffice);
    }

    @Override
    public PostOffice findByPostOfficeName(String name) {
        return postOfficeRepository.findByPostOfficeName(name);
    }

    @Override
    public Optional<PostOffice> findById(long id) {
        return postOfficeRepository.findById(id);
    }
}
