package org.sid.ebankingbackend.dtos;

import lombok.Data;

import java.util.List;

@Data
public class BankAccountByCustomerDTO {
    private Long id;
    private String name;
    private int currentPage;
    private int totalPages;
    private int pageSize;
    private int totalAccounts;
    private int currentPageAccounts;
    private List<BankAccountDTO> bankAccounts;
}
