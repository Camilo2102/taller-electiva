package com.example.tallerelectiva.controller.internal;

import com.example.tallerelectiva.exeptions.HttpException;
import com.example.tallerelectiva.models.AuditModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

/**
 * This interface represents a generic CRUD controller.
 * @param <T> The type of entity handled by the controller.
 */
public interface ICrudController<T extends AuditModel> {

    /**
     * Retrieve all entities.
     * @return A ResponseEntity with the list of entities if successful, or an error message if an exception occurs.
     * @throws Exception If an error occurs while retrieving the entities.
     */
    public ResponseEntity<?> getAll() throws HttpException;

    /**
     * Retrieve an entity by its ID.
     * @param id The ID of the entity to retrieve.
     * @return A ResponseEntity with the retrieved entity if successful, or an error message if the entity does not exist or an exception occurs.
     * @throws Exception If an error occurs while retrieving the entity.
     */
    public ResponseEntity<?> getByID(String id) throws HttpException;

    /**
     * Create a new entity.
     * @param t The entity object to create.
     * @return A ResponseEntity with the created entity if successful, or an error message if an exception occurs.
     * @throws Exception If an error occurs while creating the entity.
     */
    public ResponseEntity<?> create(T t) throws HttpException;

    /**
     * Update an existing entity.
     * @param t The entity object to update.
     * @return A ResponseEntity with the updated entity if successful, or an error message if the entity does not exist or an exception occurs.
     * @throws Exception If an error occurs while updating the entity.
     */
    @PutMapping("/{id}")
    ResponseEntity<?> update(@PathVariable String id, T t) throws HttpException;

    /**
     * Delete an entity by its ID.
     * @param id The ID of the entity to delete.
     * @return A ResponseEntity with a success message if the entity is deleted successfully, or an error message if the entity does not exist or an exception occurs.
     * @throws Exception If an error occurs while deleting the entity.
     */
    public ResponseEntity<?> delete(String id) throws HttpException;

}