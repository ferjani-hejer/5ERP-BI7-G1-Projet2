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
import tn.esprit.spring.kaddem.repositories.DepartementRepository;
import tn.esprit.spring.kaddem.services.DepartementServiceImpl;
import tn.esprit.spring.kaddem.services.EtudiantServiceImpl;

import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Slf4j
public class DepartementServiceImplTest {
    @Autowired
    DepartementServiceImpl departementService;
    @Test
    public void testRetrieveAllDepartements(){
        Departement dept = new Departement();
        dept.setIdDepart(1);
        dept.setNomDepart("Sameher");

        Departement newDept = departementService.addDepartement(dept); // Save Database

        List<Departement> departements = departementService.retrieveAllDepartements(); // Get all Departments

        assertNotNull(departements);
        assertEquals(1, departements.size());

        departementService.deleteDepartement(newDept.getIdDepart());
    }

    @Test
    public void testAddDepartement() {
        Departement dept = new Departement();
        dept.setIdDepart(1);
        dept.setNomDepart("Ferjani");

        log.info("test");
        Departement departement = departementService.addDepartement(dept);
        assertNotNull(departement);
        departementService.deleteDepartement(departement.getIdDepart());
    }

    @Test
    public void testUpdateDepartement() {
        Departement dept = new Departement();
        dept.setIdDepart(1);
        dept.setNomDepart("Informatique");

        Departement departement = departementService.addDepartement(dept);

        // Modify some properties
        departement.setNomDepart("UpdatedName");  // Corrected property name


        Departement updatedDepartement = departementService.updateDepartement(departement);
        assertNotNull(updatedDepartement);
        assertEquals("UpdatedName", updatedDepartement.getNomDepart());  // Corrected property name
        departementService.deleteDepartement(updatedDepartement.getIdDepart());
    }


}
