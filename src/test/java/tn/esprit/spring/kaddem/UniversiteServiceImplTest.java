/*package tn.esprit.spring.kaddem;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.Hibernate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tn.esprit.spring.kaddem.entities.Departement;
import tn.esprit.spring.kaddem.entities.Etudiant;
import tn.esprit.spring.kaddem.entities.Universite;
import tn.esprit.spring.kaddem.services.DepartementServiceImpl;
import tn.esprit.spring.kaddem.services.EtudiantServiceImpl;
import tn.esprit.spring.kaddem.services.UniversiteServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Slf4j
public class UniversiteServiceImplTest {
    @Autowired
    private UniversiteServiceImpl universiteService;
    @Autowired
    private DepartementServiceImpl departementService;

    @Test
    public void testretrieveAllUniversites() {
        /*
        Universite univ = new Universite();
        univ.setIdUniv(1);
        univ.setNomUniv("ESPRIT");

        Universite newUniv1 = universiteService.addUniversite(univ);
        List<Universite> universites = universiteService.retrieveAllUniversites();
        assertNotNull(universites);
        assertEquals(1, universites.size());
        universiteService.deleteUniversite(newUniv1.getIdUniv());*/
/*
        List<Universite> universites = new ArrayList<>();
        Mockito.when(universiteService.retrieveAllUniversites()).thenReturn(universites);

        // Now you can call the method you want to test
        List<Universite> result = universiteService.retrieveAllUniversites();

        // Add assertions to verify the results
        assertEquals(universites.size(), result.size());
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
/*
    @Test
    public void testRetrieveUniversite() {
        Universite univ = new Universite();
        univ.setIdUniv(1);
        univ.setNomUniv("ESPRIT");
        Universite universite = universiteService.addUniversite(univ);

        Universite retrievedUniversite = universiteService.retrieveUniversite(universite.getIdUniv());
        assertNotNull(retrievedUniversite);
        assertEquals("ESPRIT", retrievedUniversite.getNomUniv());

        universiteService.deleteUniversite(retrievedUniversite.getIdUniv());
    }
/*
@Test
public void testAssignUniversityToDepartement() {
    Universite univ = new Universite();
    univ.setIdUniv(1);
    univ.setNomUniv("ESPRIT");
    Universite universite = universiteService.addUniversite(univ);

    Departement departement = new Departement();
    departement.setIdDepart(1);
    departement.setNomDepart("IT Department");
    Departement newDepartement = departementService.addDepartement(departement);

    universiteService.assignUniversiteToDepartement(universite.getIdUniv(), newDepartement.getIdDepart());

    Departement retrievedDepartement = departementService.retrieveDepartement(newDepartement.getIdDepart());
    assertNotNull(retrievedDepartement.);
    assertEquals(univ.getIdUniv(), retrievedDepartement.getUniversite().getIdUniversite());
    universiteService.deleteUniversite(univ.getIdUniv());
}
*/
    /*
    @Test
    public void testAssignUniversiteToDepartement() {
        // Create an Universite
        Universite univ = new Universite();
        univ.setIdUniv(1);
        univ.setNomUniv("ESPRIT");
        Universite universite = universiteService.addUniversite(univ);

        // Create a Departement
        Departement depart = new Departement();
        depart.setIdDepart(1);
        depart.setNomDepart("IT Department");
        Departement departement = departementService.addDepartement(depart);

        // Call the method to be tested
        universiteService.assignUniversiteToDepartement(universite.getIdUniv(), departement.getIdDepart());

        // Initialize the lazy-loaded collection
        Hibernate.initialize(universite.getDepartements());

        // Assertions
        assertNotNull(universite);
        Set<Departement> departements = universite.getDepartements();
        assertNotNull(departements);
        assertEquals(1, departements.size());
        assertTrue(departements.contains(departement));

        // Clean up
        universiteService.deleteUniversite(universite.getIdUniv());
        departementService.deleteDepartement(departement.getIdDepart());
    }*/




