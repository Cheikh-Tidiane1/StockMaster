package com.tid.StockMaster.dto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ChangerMdpUserDto {
    private Integer id;
    private String motDePasse;
    private String ConfirmeMotDePasse;
}
