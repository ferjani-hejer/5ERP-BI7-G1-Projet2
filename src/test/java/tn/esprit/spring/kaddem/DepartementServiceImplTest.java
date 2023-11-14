package tn.esprit.spring.kaddem;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.spring.kaddem.entities.Departement;
import tn.esprit.spring.kaddem.repositories.DepartementRepository;
import tn.esprit.spring.kaddem.services.DepartementServiceImpl;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
@Slf4j
class DepartementServiceImplTest {

    @InjectMocks
    DepartementServiceImpl departementService;

    @Mock
    DepartementRepository departementRepository;

    @Test
    void testAddDepartement() {
        // Create a Departement instance and set its properties
        Departement addedDepartement = new Departement();
        addedDepartement.setNomDepart("NomDepartement");

        // Mock the behavior of your repository to return the addedDepartement when save is called
        Mockito.when(departementRepository.save(Mockito.any(Departement.class))).thenReturn(addedDepartement);

        // Call the service method you want to test
        Departement savedDepartement = departementService.addDepartement(addedDepartement);

        // Assertions
        assertNotNull(savedDepartement);
        // Add more specific assertions based on the behavior you expect
    }

    @Test
    void testRetrieveDepartement() {
        // Create a Departement instance and set its properties
        Departement addedDepartement = new Departement();
        addedDepartement.setIdDepart(1);
        addedDepartement.setNomDepart("NomDepartement");

        // Mock the behavior of your repository to return a Departement when findById is called
        Mockito.when(departementRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(addedDepartement));

        // Call the service method you want to test
        Departement retrievedDepartement = departementService.retrieveDepartement(1);

        // Assertions
        assertNotNull(retrievedDepartement);
        // Add more specific assertions based on the behavior you expect
    }

    // ... Add more test methods as needed for other operations (update, delete, etc.)
}
