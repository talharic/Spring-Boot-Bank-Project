package com.talharic.bankproject.service.entityservice;

import com.talharic.bankproject.entity.BaseAdditionalFields;
import com.talharic.bankproject.entity.BaseEntity;
import com.talharic.bankproject.enums.ErrorMessage;
import com.talharic.bankproject.exception.ItemNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public abstract class BaseEntityService<E extends BaseEntity, R extends JpaRepository<E, Long>> {

    private final R repository;

    public List<E> findAll(){
        return repository.findAll();
    }

    public Optional<E> findById(Long id){
        return repository.findById(id);
    }

    public E save(E entity){

        setAdditionalFields(entity);

        entity = repository.save(entity);
        
        return entity;
    }

    private void setAdditionalFields(E entity) {

        BaseAdditionalFields baseAdditionalFields = entity.getBaseAdditionalFields();

        Long currentCustomerId = getCurrentCustomerId();

        if(baseAdditionalFields == null){
            baseAdditionalFields = new BaseAdditionalFields();
            entity.setBaseAdditionalFields(baseAdditionalFields);
        }

        if(entity.getId() == null){
            baseAdditionalFields.setCreateDate(new Date());
            baseAdditionalFields.setCreateBy(currentCustomerId);
        }
    }

    public void delete(E entity){
        repository.delete(entity);
    }

    public E getByIdWithControl(Long id) {

        Optional<E> entityOptional = findById(id);

        E entity;
        if (entityOptional.isPresent()){
            entity = entityOptional.get();
        } else {
            throw new ItemNotFoundException(ErrorMessage.ITEM_NOT_FOUND);
        }

        return entity;
    }

    public boolean existsById(Long id){
        return repository.existsById(id);
    }

    public R getRepository() {
        return repository;
    }

    // TODO: control after jwt
    private Long getCurrentCustomerId() {

        Long currentCustomer = null;
        return currentCustomer;
    }
}
