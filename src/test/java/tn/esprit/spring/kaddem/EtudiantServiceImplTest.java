package tn.esprit.spring.kaddem;
import static org.junit.Assert.*;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.spring.kaddem.entities.Etudiant;
import tn.esprit.spring.kaddem.repositories.ContratRepository;
import tn.esprit.spring.kaddem.repositories.EquipeRepository;
import tn.esprit.spring.kaddem.repositories.EtudiantRepository;
import tn.esprit.spring.kaddem.services.EtudiantServiceImpl;
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class EtudiantServiceImplTest {

    @Autowired
    private EtudiantServiceImpl etudiantService;
    @Test
    public void testAddEtudiant() {
        Etudiant etd = new Etudiant();
        log.info("test");
        Etudiant etudiant = etudiantService.addEtudiant(etd);
        //assertNotNull(etudiant.getIdEtudiant());
        Assertions.assertNotNull(etudiant);
        etudiantService.removeEtudiant(etd.getIdEtudiant());
    }
}
