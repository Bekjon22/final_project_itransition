package com.itransition.entity;

import com.itransition.entity.template.AbsEntity;
import com.itransition.enums.FieldType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author Bekjon Bakhromov
 * @since  21.06.2022-11:33 AM
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "custom_fields")
@Where(clause = "deleted=false")
@SQLDelete(sql = "update custom_fields set deleted=true where id=?")
@OnDelete(action = OnDeleteAction.CASCADE)
public class CustomField extends AbsEntity {

    private String name;

    @Enumerated(EnumType.STRING)
    private FieldType fieldType;


}
