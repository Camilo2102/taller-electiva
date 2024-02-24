package com.example.tallerelectiva.services.internal;

import com.example.tallerelectiva.exeptions.HttpException;
import com.example.tallerelectiva.models.AuditModel;
import com.example.tallerelectiva.repositories.AuditRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public class CrudService<T extends AuditModel> implements ICrudService<T>{

    private final AuditRepository<T> repository;

    public CrudService(AuditRepository<T> repository) {
        this.repository = repository;
    }

    @Override
    public List<T> getAll() {
        return (List<T>) this.repository.findAll();
    }

    @Override
    public long count() {
        return this.repository.count();
    }

    @Override
    public T getOne(String id) throws HttpException {
        return findElement(id);
    }

    @Override
    public T save(T element) throws HttpException {
        return this.repository.save(element);
    }

    @Override
    public T update(String id, T element) throws HttpException {
        this.findElement(id);

        element.setId(id);

        this.repository.save(element);

        return element;
    }

    @Override
    public T delete(String id) throws HttpException {
        T foundElement = this.findElement(id);

        this.repository.deleteById(id);

        return foundElement;
    }

    @Override
    public List<T> saveAll(List<T> elements) throws HttpException {
        return this.repository.saveAll(elements);
    }

    private T findElement(String id) throws HttpException{
        if( id == null) throw new HttpException("No id provided", HttpStatus.BAD_REQUEST);
        Optional<T> foundElement = this.repository.findById(id);

        if(foundElement.isEmpty()){
            throw new HttpException("Not found", HttpStatus.NOT_FOUND);
        }

        return foundElement.get();
    }

}
