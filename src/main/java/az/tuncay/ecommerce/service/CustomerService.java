package az.tuncay.ecommerce.service;

import az.tuncay.ecommerce.dto.CustomerRequestDto;
import az.tuncay.ecommerce.dto.CustomerResponseDto;
import az.tuncay.ecommerce.entity.Customer;
import az.tuncay.ecommerce.exception.ResourceNotFoundException;
import az.tuncay.ecommerce.mapper.CustomerMapper;
import az.tuncay.ecommerce.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    private Customer getCustomerEntityById(Long id){
        return customerRepository.
                findById(id).orElseThrow(() -> new ResourceNotFoundException("not found"));
    }

    public CustomerResponseDto createCustomer(CustomerRequestDto dto){

        Customer customer = customerMapper.toEntity(dto);

        Customer saveCustomer = customerRepository.save(customer);

        return customerMapper.toResponse(saveCustomer);
    }

    public CustomerResponseDto getCustomerById(Long id){
        Customer customer = getCustomerEntityById(id);

        return customerMapper.toResponse(customer);
    }

    public List<CustomerResponseDto> getAllCustomers(){
        return customerRepository.
                findAll().
                stream().
                map(customerMapper::toResponse).
                toList();
    }

    public CustomerResponseDto updateCustomer(Long id, CustomerRequestDto dto){

        Customer customer = getCustomerEntityById(id);

        customer.setEmail(dto.getEmail());
        customer.setFullName(dto.getFullName());

        Customer saveCustomer = customerRepository.save(customer);

        return customerMapper.toResponse(saveCustomer);
    }

    public void deleteCustomer(Long id){

        Customer customer = getCustomerEntityById(id);

        customerRepository.delete(customer);
    }

}
