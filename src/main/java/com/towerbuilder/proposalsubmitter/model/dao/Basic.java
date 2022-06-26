package com.towerbuilder.proposalsubmitter.model.dao;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@MappedSuperclass
@SuperBuilder
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Basic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreationTimestamp
    private LocalDateTime createDate;
    @UpdateTimestamp
    private LocalDateTime updateDate;
    @Version
    private Long version;

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        Basic basic = (Basic) obj;
        return getId().equals(basic.getId())
                && getCreateDate().equals(basic.getCreateDate())
                && getUpdateDate().equals(basic.getUpdateDate())
                && getVersion().equals(basic.getVersion());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCreateDate(), getUpdateDate(), getVersion());
    }
}
