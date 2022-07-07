package com.itransition.entity;

import com.itransition.entity.template.AbsEntity;
import com.itransition.enums.PermissionEnum;
import com.itransition.enums.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "roles")
@Where(clause = "deleted=false")
@SQLDelete(sql = "update roles set deleted=true where id=?")
public class Role extends AbsEntity {

    @Column(name = "name", nullable = false,unique = true)
    private String name;

    @Column(name = "description", columnDefinition = "text")
    private String description;

    @Enumerated(EnumType.STRING)
    @ElementCollection()
    private Set<PermissionEnum> permissionEnums;

    @Enumerated(EnumType.STRING)
    private RoleEnum type;
}
