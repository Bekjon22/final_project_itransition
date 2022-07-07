package com.itransition.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.itransition.entity.template.AbsEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * @author Bekjon Bakhromov
 * @since  21.06.2022-11:31 AM
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "comments")
@Where(clause = "deleted=false")
@SQLDelete(sql = "update comments set deleted=true where id=?")
public class Comment extends AbsEntity {

    private String text;


    @ManyToOne(optional = false)
    private Item item;

}
