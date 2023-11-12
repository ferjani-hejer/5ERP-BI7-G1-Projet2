package tn.esprit.spring.kaddem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tn.esprit.spring.kaddem.entities.Departement;
import tn.esprit.spring.kaddem.entities.Etudiant;
import tn.esprit.spring.kaddem.entities.Universite;
import tn.esprit.spring.kaddem.services.DepartementServiceImpl;
import tn.esprit.spring.kaddem.services.EtudiantServiceImpl;
import tn.esprit.spring.kaddem.services.UniversiteServiceImpl;

import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Slf4j
public class UniversiteServiceImplTest {
    @Autowired
    private UniversiteServiceImpl universiteService;

    @Test
    public void testretrieveAllUniversites() {

        Universite univ = new Universite();
        univ.setIdUniv(1);
        univ.setNomUniv("ESPRIT");

        Universite newUniv1 = universiteService.addUniversite(univ);
        List<Universite> universites = universiteService.retrieveAllUniversites();
        assertNotNull(universites);
        assertEquals(1, universites.size());
        universiteService.deleteUniversite(newUniv1.getIdUniv());

    }

    @Test
    public void testAddUniversite() {
        Universite univ = new Universite();
        univ.setIdUniv(1);
        univ.setNomUniv("ESPRIT");
        log.info("test");
        Universite universite = universiteService.addUniversite(univ);
        assertNotNull(universite);
        universiteService.deleteUniversite(universite.getIdUniv());
    }

    @Test
    public void testUpdateUniversite() {
        Universite univ = new Universite();
        univ.setIdUniv(1);
        univ.setNomUniv("ESPRIT");
        Universite universite = universiteService.addUniversite(univ);
        // Modify some properties
        universite.setNomUniv("Updated Name");  // Corrected property name

        Universite updatedUniversite =universiteService.updateUniversite(universite);
        assertNotNull(updatedUniversite);
        assertEquals("Updated Name", updatedUniversite.getNomUniv());  // Corrected property name

        universiteService.deleteUniversite(updatedUniversite.getIdUniv());
    }

}
