package com.itransition.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.itransition.entity.template.AbsEntity;
import com.itransition.enums.Topic;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Bekjon Bakhromov
 * @since  21.06.2022-11:12 AM
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "collections")
@Where(clause = "deleted=false")
@SQLDelete(sql = "update collections set deleted=true where id=?")
public class Collection extends AbsEntity {

    private String name;

    private String description;

    @Enumerated(EnumType.STRING)
    private Topic topic;

    @ManyToOne(fetch = FetchType.LAZY)
    private Attachment image;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    private User user;

    @JsonIgnore
    @OneToMany(mappedBy = "collection",cascade = CascadeType.ALL)
    private Set<Item> items;

}
