package com.example.ProjectX.Controller;

import com.example.ProjectX.entity.UserEntity;
import com.example.ProjectX.exceptions.UserAlreadyExistException;
import com.example.ProjectX.exceptions.UserNotExistException;
import com.example.ProjectX.exceptions.UsernameAlreadyExistException;
import com.example.ProjectX.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController
{
	@Autowired
	private UserService userService;

	@GetMapping("")
	public ResponseEntity getUsers(){
		return ResponseEntity.ok(userService.getUsers());
	}

	@GetMapping("/user")
	public ResponseEntity getUser(@RequestParam Integer id) {
		try {
			return ResponseEntity.ok(userService.getUser(id));
		}
		catch (UserNotExistException e){
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		catch (Exception e){
			return ResponseEntity.badRequest().body("Error");
		}
	}

	@PostMapping("/adduser")
	public ResponseEntity addUser(@RequestBody UserEntity user){
		try {
			userService.addUser(user);
			return ResponseEntity.ok("User successfully added");
		}
		catch (UserAlreadyExistException e){
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		catch (Exception e) {
			return ResponseEntity.badRequest().body("Error");
		}
	}

	@PutMapping("/user/{id}")
	public ResponseEntity updateUser(@PathVariable("id") Integer id, @RequestBody UserEntity user){
		try{
			userService.updateUser(id, user);
			return ResponseEntity.ok("User successfully updated");
		}
		catch (UsernameAlreadyExistException | UserNotExistException e){
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		catch (Exception e){
			return ResponseEntity.badRequest().body("Error");
		}
	}

	@DeleteMapping("/user/{id}")
	public ResponseEntity deleteUser(@PathVariable("id") Integer id){
		try{
			userService.deleteUser(id);
			return ResponseEntity.ok("User successfully deleted");
		}
		catch (UserNotExistException e){
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		catch (Exception e){
			return ResponseEntity.badRequest().body("Error");
		}
	}

}
