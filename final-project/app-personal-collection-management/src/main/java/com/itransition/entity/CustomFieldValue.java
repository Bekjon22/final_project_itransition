package com.itransition.entity;

import com.itransition.entity.template.AbsEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * @author Bekjon Bakhromov
 * @since  23.06.2022-9:58 AM
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "custom_fields_value")
@Where(clause = "deleted=false")
@SQLDelete(sql = "update custom_fields_value set deleted=true where id=?")
public class CustomFieldValue extends AbsEntity {

    @Column(length = 524288)
    private String value;

    @ManyToOne(optional = false)
    private Item item;

    @ManyToOne(optional = false)
    private CustomField customField;

}
