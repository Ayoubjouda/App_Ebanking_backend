package org.sid.ebankingbackend.mappers;

import org.sid.ebankingbackend.dtos.*;
import org.sid.ebankingbackend.entities.AccountOperation;
import org.sid.ebankingbackend.entities.CurrentAccount;
import org.sid.ebankingbackend.entities.Customer;
import org.sid.ebankingbackend.entities.SavingAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class BankAccountMapperImpl {
    public CustomerDTO fromCustomer(Customer customer){
        CustomerDTO customerDTO=new CustomerDTO();
        BeanUtils.copyProperties(customer,customerDTO);
       // customerDTO.setId(customer.getId());
        //customerDTO.setName(customer.getName());
        //customerDTO.setEmail(customer.getEmail());
        return customerDTO;
    }
    public Customer fromCustomerDTO(CustomerDTO customerDTO){
        Customer customer=new Customer();
        BeanUtils.copyProperties(customerDTO,customer);
        return customer;
    }
    public SavingBankAccountDTO fromsavingBankAccount(SavingAccount savingAccount){
SavingBankAccountDTO savingBankAccountDTO=new SavingBankAccountDTO();
BeanUtils.copyProperties(savingAccount,savingBankAccountDTO);
savingBankAccountDTO.setType(savingAccount.getClass().getSimpleName());
return savingBankAccountDTO;

    }
    public SavingAccount fromsavingBankAccountDTO(SavingBankAccountDTO savingBankAccountDTO){
SavingAccount savingAccount=new SavingAccount();
BeanUtils.copyProperties(savingBankAccountDTO,savingAccount);
return savingAccount;
    }
    public CurrentBankAccountDTO fromcurrentBankAccount(CurrentAccount currentAccount){
CurrentBankAccountDTO currentBankAccountDTO=new CurrentBankAccountDTO();
BeanUtils.copyProperties(currentAccount,currentBankAccountDTO);
        currentBankAccountDTO.setType(currentAccount.getClass().getSimpleName());

return currentBankAccountDTO;
    }
    public CurrentAccount fromcurrentAccountDTO(CurrentBankAccountDTO currentBankAccountDTO){
CurrentAccount currentAccount=new CurrentAccount();
BeanUtils.copyProperties(currentBankAccountDTO,currentAccount);
return currentAccount;
    }
    public AccountOperationDTO fromAccountOperation(AccountOperation accountOperation){
        AccountOperationDTO accountOperationDTO=new AccountOperationDTO();
        BeanUtils.copyProperties(accountOperation,accountOperationDTO);
        return accountOperationDTO;
    }
    public BankAccountByCustomerDTO fromBankAccountByCustomer(Customer customer){
        BankAccountByCustomerDTO bankAccountByCustomerDTO = new BankAccountByCustomerDTO();
        BeanUtils.copyProperties(customer, bankAccountByCustomerDTO);
        return bankAccountByCustomerDTO;
    }

}
