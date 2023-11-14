package tn.esprit.spring.kaddem;



import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.spring.kaddem.entities.Equipe;
import tn.esprit.spring.kaddem.entities.Niveau;
import tn.esprit.spring.kaddem.repositories.EquipeRepository;
import tn.esprit.spring.kaddem.services.EquipeServiceImpl;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
@Slf4j
class EquipeServiceImplTest {

    @InjectMocks
    EquipeServiceImpl equipeService;

    @Mock
    EquipeRepository equipeRepository;

    @Test
    void testAddEquipe() {
        // Create an Equipe instance and set its properties
        Equipe addedEquipe = new Equipe();
        addedEquipe.setNomEquipe("NomEquipe");
        addedEquipe.setNiveau(Niveau.SENIOR);

        // Mock the behavior of your repository to return the addedEquipe when save is called
        Mockito.when(equipeRepository.save(Mockito.any(Equipe.class))).thenReturn(addedEquipe);

        // Call the service method you want to test
        Equipe savedEquipe = equipeService.addEquipe(addedEquipe);

        // Assertions
        assertNotNull(savedEquipe);
        // Add more specific assertions based on the behavior you expect
    }

    @Test
    void testRetrieveEquipe() {
        // Create an Equipe instance and set its properties
        Equipe addedEquipe = new Equipe();
        addedEquipe.setIdEquipe(1);
        addedEquipe.setNomEquipe("NomEquipe");
        addedEquipe.setNiveau(Niveau.SENIOR);

        // Mock the behavior of your repository to return an Equipe when findById is called
        Mockito.when(equipeRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(addedEquipe));

        // Call the service method you want to test
        Equipe retrievedEquipe = equipeService.retrieveEquipe(1);

        // Assertions
        assertNotNull(retrievedEquipe);
        // Add more specific assertions based on the behavior you expect
    }

    // ... Add more test methods as needed for other operations (update, delete, etc.)
}