package com.towerbuilder.proposalsubmitter.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public abstract class BasicDTO {
    private Long id;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private Long version;
}
