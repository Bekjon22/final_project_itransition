package com.itransition.entity;

import com.itransition.entity.template.AbsEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.Set;

/**
 * @author Bekjon Bakhromov
 * @since  21.06.2022-11:27 AM
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "tags")
@Where(clause = "deleted=false")
@SQLDelete(sql = "update tags set deleted=true where id=?")
public class Tag extends AbsEntity {

    private String value;

    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    private Item item;



}
