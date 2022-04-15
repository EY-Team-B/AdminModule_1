
package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dao.UserRepository;
import model.Users;

@RestController
public class MyController {
	@Autowired
    private UserRepository repo;

	@GetMapping("Users")                   //getall
	public List<Users> getAllUsers(){
		
		return repo.findAll();
	}

	@GetMapping("/Users/{email}")               //getbyemail
	public Users users(@PathVariable("email") String email)   
	{  
	return repo.findById(email).get();  
	}  
	
	@PostMapping("add")                    //add
	public String addUser(@RequestBody Users users) {
		repo.save(users);
		return users.getEmail()+" Added Successfully!!!";
	}
	
	@PutMapping("update/{email}") // update
	public String update(@RequestBody Users users, @PathVariable("email") String email) {
		repo.findById(email).map(emp -> 
		{
			users.setName(users.getName());
			return repo.save(users);
		});
		return email + " updated successfully";
	}
	
	@DeleteMapping("/deleteUser/{email}")    //delete
	public String deleteUser(@PathVariable("email") String email)   
	{  
	repo.deleteById(email);  
	return "User " + email +" has been deleted successfully";
	}  

}