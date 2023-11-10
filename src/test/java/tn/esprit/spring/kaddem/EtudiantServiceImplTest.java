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
import tn.esprit.spring.kaddem.services.DepartementServiceImpl;
import tn.esprit.spring.kaddem.services.EtudiantServiceImpl;

import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Slf4j
public class EtudiantServiceImplTest {

    @Autowired
    private EtudiantServiceImpl etudiantService;

    @Autowired
    private DepartementServiceImpl departementService;

    @Test
    public void testRetrieveAllEtudiants() {
        Etudiant etd = new Etudiant();
        etd.setIdEtudiant(1);
        etd.setNomE("Ferjani");
        etd.setPrenomE("Hejer");
        Etudiant newEtd1 = etudiantService.addEtudiant(etd);

        Etudiant etd2 = new Etudiant();
        etd2.setIdEtudiant(2);
        etd2.setNomE("Ferjani");
        etd2.setPrenomE("Hejer 2");
        Etudiant newEtd2 = etudiantService.addEtudiant(etd2);

        List<Etudiant> etudiants = etudiantService.retrieveAllEtudiants();

        assertNotNull(etudiants);
        assertEquals(2, etudiants.size());

        etudiantService.removeEtudiant(newEtd1.getIdEtudiant());
        etudiantService.removeEtudiant(newEtd2.getIdEtudiant());
    }
    @Test
    public void testAddEtudiant() {
        Etudiant etd = new Etudiant();
        etd.setIdEtudiant(1);
        etd.setNomE("Ferjani");
        etd.setPrenomE("Hejer");
        log.info("test");
        Etudiant etudiant = etudiantService.addEtudiant(etd);
        assertNotNull(etudiant);
        etudiantService.removeEtudiant(etudiant.getIdEtudiant());
    }

    
}
