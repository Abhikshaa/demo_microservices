package com.Consume.CONTROLLER;
import com.Consume.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {
@Autowired
     private final RestTemplate restTemplate;

     public UserController(RestTemplate restTemplate) {
          this.restTemplate = restTemplate;
     }
//
//     @GetMapping("/users/{id}")
//     public UserDTO getUserById(@PathVariable long id) {
//          String url = "http://localhost:8080/api/user/" + id;
//          ResponseEntity<UserDTO> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, UserDTO.class, HttpStatus.OK);
//          return responseEntity.getBody();
//     }

     @PostMapping("/users")
     public UserDTO createUser(@RequestBody UserDTO userDTO) {
          String url = "http://localhost:8080/api/user";
          ResponseEntity<UserDTO> responseEntity = restTemplate.postForEntity(url, userDTO, UserDTO.class);
          return responseEntity.getBody();
     }

@PutMapping("/users/{id}")
public UserDTO updateUser(@PathVariable long id, @RequestBody UserDTO updatedUserDTO) {
     String url = "http://localhost:8080/api/user/" + id;
     HttpEntity<UserDTO> requestEntity = new HttpEntity<>(updatedUserDTO);
     ResponseEntity<UserDTO> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, UserDTO.class);
     return responseEntity.getBody();
}

     @DeleteMapping("/users/{id}")
     public void deleteUser(@PathVariable long id) {
          String url = "http://localhost:8080/api/user/" + id;
          restTemplate.delete(url);
     }
@GetMapping("/users/{id}")
     public UserDTO getById(@PathVariable("id") long id){
          String url="http://localhost:8080/api/user/" +id;

          ResponseEntity<UserDTO> exchange = restTemplate.exchange(url, HttpMethod.GET, null, UserDTO.class);
     return exchange.getBody();
     }


}

