package pelagustravel.travelo.repository.productDeliveryRepitory;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import pelagustravel.travelo.model.productDeliveryService.PostOffice;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PostOfficeRepositoryTest {

    @Autowired
    private PostOfficeRepository postOfficeRepository;

    @Test
    void findByPostOfficeName() {
        PostOffice postOffice=new PostOffice();
        postOffice.setPostOfficeName("TT");
        postOfficeRepository.save(postOffice);
        PostOffice testPostOffice=postOfficeRepository.findByPostOfficeName("TT");
        assertThat(testPostOffice).isEqualTo(postOffice);
    }

    @AfterEach
    void tearDown() {
        postOfficeRepository.deleteAll();
    }
}