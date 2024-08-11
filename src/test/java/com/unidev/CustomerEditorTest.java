package com.unidev;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.unidev.entities.Customer;
import com.unidev.repositories.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

public class CustomerEditorTest {

    @Mock
    private CustomerRepository repository;

    @InjectMocks
    private CustomerEditor customerEditor;

    @Mock
    private Customer customer;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        customerEditor = new CustomerEditor(repository);
    }

    @Test
    public void testSave() {
        // Arrange
        when(customer.getId()).thenReturn(1L);
        customerEditor.editCustomer(customer);

        // Act
        customerEditor.save();

        // Assert
        verify(repository, times(1)).save(customer);
    }

    @Test
    public void testDelete() {
        // Arrange
        when(customer.getId()).thenReturn(1L);
        customerEditor.editCustomer(customer);

        // Act
        customerEditor.delete();

        // Assert
        verify(repository, times(1)).delete(customer);
    }

    @Test
    public void testEditCustomerWhenCustomerIsNull() {
        // Act
        customerEditor.editCustomer(null);

        // Assert
        assertFalse(customerEditor.isVisible());
    }

    @Test
    public void testEditCustomerWhenCustomerIsNotNull() {
        // Arrange
        when(customer.getId()).thenReturn(1L);
        when(repository.findById(1L)).thenReturn(Optional.of(customer));

        // Act
        customerEditor.editCustomer(customer);

        // Assert
        assertTrue(customerEditor.isVisible());
        verify(repository, times(1)).findById(1L);
    }

    @Test
    public void testEditCustomerWhenCustomerIsNew() {
        // Arrange
        when(customer.getId()).thenReturn(null);

        // Act
        customerEditor.editCustomer(customer);

        // Assert
        assertTrue(customerEditor.isVisible());
    }
}
