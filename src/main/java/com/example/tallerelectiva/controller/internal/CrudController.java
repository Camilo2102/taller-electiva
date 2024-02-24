package com.example.tallerelectiva.controller.internal;

import com.example.tallerelectiva.exeptions.HttpException;
import com.example.tallerelectiva.models.AuditModel;
import com.example.tallerelectiva.responses.ResponseHandler;
import com.example.tallerelectiva.services.internal.CrudService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class CrudController<T extends AuditModel> implements ICrudController<T> {
    private final CrudService<T> service;

    protected CrudController(CrudService<T> service) {
        this.service = service;
    }

    /**
     * Retrieve all entities.
     *
     * @return A ResponseEntity with the list of entities if successful, or an error message if an exception occurs.
     * @throws Exception If an error occurs while retrieving the entities.
     */
    @Override
    @GetMapping
    public ResponseEntity<?> getAll() {
        List<T> dataFound = service.getAll();
        return ResponseHandler.generateResponse("Data found", HttpStatus.OK, dataFound);
    }

    /**
     * Retrieve an entity by its ID.
     *
     * @param id The ID of the entity to retrieve.
     * @return A ResponseEntity with the retrieved entity if successful, or an error message if the entity does not exist or an exception occurs.
     * @throws Exception If an error occurs while retrieving the entity.
     */
    @Override
    @GetMapping("/{id}")
    public ResponseEntity<?> getByID(@PathVariable String id) throws HttpException {
        T data = service.getOne(id);
        return ResponseHandler.generateResponse("Data found", HttpStatus.OK, data);
    }

    /**
     * Create a new entity.
     *
     * @param t The entity object to create.
     * @return A ResponseEntity with the created entity if successful, or an error message if an exception occurs.
     * @throws Exception If an error occurs while creating the entity.
     */
    @Override
    @PostMapping
    public ResponseEntity<?> create(@RequestBody T t) throws HttpException {
        T dataCreated = service.save(t);
        return ResponseHandler.generateResponse("Data created", HttpStatus.ACCEPTED, dataCreated);
    }

    /**
     * Update an existing entity.
     *
     * @param t The entity object to update.
     * @return A ResponseEntity with the updated entity if successful, or an error message if the entity does not exist or an exception occurs.
     * @throws Exception If an error occurs while updating the entity.
     */
    @Override
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, T t) throws HttpException {
        T dataUpdated = service.update(id, t);
        return ResponseHandler.generateResponse("Data updated", HttpStatus.ACCEPTED, dataUpdated);
    }

    /**
     * Delete an entity by its ID.
     *
     * @param id The ID of the entity to delete.
     * @return A ResponseEntity with a success message if the entity is deleted successfully, or an error message if the entity does not exist or an exception occurs.
     * @throws Exception If an error occurs while deleting the entity.
     */
    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) throws HttpException {
        T dataDeleted = service.delete(id);
        return ResponseHandler.generateResponse("Data deleted", HttpStatus.ACCEPTED, dataDeleted);
    }
}
