package com.unidev;

import com.unidev.entities.Customer;
import com.unidev.repositories.CustomerRepository;
import com.vaadin.flow.data.provider.Query;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MainViewTest {

    @Mock
    private CustomerRepository repo;

    @Mock
    private CustomerEditor editor;

    @InjectMocks
    private MainView mainView;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mainView = new MainView(repo, editor);
    }

    @Test
    void testConstructor() {
        assertNotNull(mainView.grid, "Grid should not be null");
        assertNotNull(mainView.filter, "Filter should not be null");
    }

    @Test
    void testListCustomersWithFilter() {
        // Given
        String filterText = "Smith";
        when(repo.findByLastNameStartsWithIgnoreCase(filterText)).thenReturn(List.of(new Customer(1L, "John", "Smith")));

        // When
        mainView.listCustomers(filterText);

        // Then
        verify(repo).findByLastNameStartsWithIgnoreCase(filterText);
        assertEquals(1, mainView.grid.getDataProvider().size(new Query<>()));
    }

    @Test
    void testListCustomersWithoutFilter() {
        // Given
        when(repo.findAll()).thenReturn(List.of(new Customer(1L, "John", "Smith")));

        // When
        mainView.listCustomers(null);

        // Then
        verify(repo).findAll();
        assertEquals(1, mainView.grid.getDataProvider().size(new Query<>()));
    }

    @Test
    void testFilterChangeListener() {
        // Given
        String filterText = "Doe";
        when(repo.findByLastNameStartsWithIgnoreCase(filterText)).thenReturn(List.of(new Customer(2L, "Jane", "Doe")));

        // When
        mainView.filter.setValue(filterText);

        // Then
        verify(repo).findByLastNameStartsWithIgnoreCase(filterText);
        assertEquals(1, mainView.grid.getDataProvider().size(new Query<>()));
    }
}
