package com.itransition.entity;

import com.itransition.entity.template.AbsEntity;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "attachment_content")
@Where(clause = "deleted=false")
@SQLDelete(sql = "update attachment_content set deleted=true where id=?")
public class AttachmentContent extends AbsEntity {

    @Column(name = "bytes", nullable = false)
    private byte[] bytes;

    @OneToOne(optional = false)
    @JoinColumn(name = "attachment_id")
    private Attachment attachment;
}
