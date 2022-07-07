package com.itransition.entity;

import com.itransition.entity.template.AbsEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * @author Bekjon Bakhromov
 * @since  21.06.2022-1:30 PM
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "likes_item")
@Where(clause = "deleted=false")
@SQLDelete(sql = "update likes_item set deleted=true where id=?")
public class Like extends AbsEntity {

    @ManyToOne(optional = false)
    private User user;

    @ManyToOne(optional = false)
    private Item item;


}
