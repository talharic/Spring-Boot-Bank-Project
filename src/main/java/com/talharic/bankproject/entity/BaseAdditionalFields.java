package com.talharic.bankproject.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Date;

@Embeddable
@Getter
@Setter
public class BaseAdditionalFields {

    @Column(name = "CREATE_DATE", nullable = false, updatable = false)
    @CreatedDate
    private Date createDate;

    @Column(name = "UPDATE_DATE", nullable = false)
    @LastModifiedDate
    private Date updateDate;

    @Column(name = "CREATED_BY")
    @CreatedBy
    private Long createBy;

    @Column(name = "UPDATED_BY")
    @LastModifiedBy
    private Long updatedBy;
}