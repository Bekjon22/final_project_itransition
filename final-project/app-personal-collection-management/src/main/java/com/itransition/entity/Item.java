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

import javax.persistence.*;
import java.util.Set;

/**
 * @author Bekjon Bakhromov
 * @since  21.06.2022-11:22 AM
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "items")
@Where(clause = "deleted=false")
@SQLDelete(sql = "update items set deleted=true where id=?")
public class Item extends AbsEntity {

    private String name;


    @OneToMany(mappedBy = "item",cascade = CascadeType.ALL)
    private Set<Tag> tags;


    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    private Collection collection;

    @OneToMany(mappedBy = "item",cascade = CascadeType.ALL)
    private Set<Comment> comments;

}
