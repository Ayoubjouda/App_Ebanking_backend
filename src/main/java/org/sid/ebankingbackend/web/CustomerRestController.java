package org.sid.ebankingbackend.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sid.ebankingbackend.dtos.AccountOperationDTO;
import org.sid.ebankingbackend.dtos.BankAccountByCustomerDTO;
import org.sid.ebankingbackend.dtos.CustomerDTO;
import org.sid.ebankingbackend.entities.AccountOperation;
import org.sid.ebankingbackend.entities.Customer;
import org.sid.ebankingbackend.exception.CustomerNotFoundException;
import org.sid.ebankingbackend.services.BankAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
public class CustomerRestController {
    private BankAccountService bankAccountService;
    @GetMapping("/customers")
        public List<CustomerDTO> customers(){
            return bankAccountService.listCustomers();

        }
    @GetMapping("/customers/search")
    public List<CustomerDTO> searchCustomers(@RequestParam(name="keyword",defaultValue = "") String keyword){
        return bankAccountService.searchCustomers(keyword);

    }
        @GetMapping("/customers/{id}")
        public CustomerDTO getCustomer( @PathVariable(name="id") Long customerId) throws CustomerNotFoundException {
return bankAccountService.getCustomer(customerId);
        }
        @PostMapping("/customers")
        public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO){
        return  bankAccountService.saveCustomer(customerDTO);
        }
        @PutMapping("/customers/{customerId}")
    public CustomerDTO updateCustomer(@PathVariable Long customerId, @RequestBody CustomerDTO customerDTO){
        customerDTO.setId(customerId);
       return bankAccountService.updateCustomer(customerDTO);
        }
        @DeleteMapping("/customers/{id}")
        public void deleteCustomer(@PathVariable Long id){
        bankAccountService.deleteCustomer(id);
        }
    @GetMapping("/customer-accounts/{customerId}")
    public BankAccountByCustomerDTO getBankAccountsByCustomer(
            @PathVariable Long customerId,
            @RequestParam(name="page",defaultValue = "0") int page,
            @RequestParam(name="size",defaultValue = "5") int size) throws CustomerNotFoundException {
        return bankAccountService.BANK_ACCOUNT_BY_CUSTOMER(customerId, page, size);
    }

}
