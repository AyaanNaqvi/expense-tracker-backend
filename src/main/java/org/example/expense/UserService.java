package org.example.expense;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UserService {
public UserRep userRepository;
public UserService(UserRep userRepository) {
    this.userRepository = userRepository;
}

public User addUser( User user) {
	return userRepository.findByEmail(user.getEmail()).orElseGet(()->userRepository.save(user));
}

public void Deleteuser(User user) {
	userRepository.delete(user);
}
	public List<User> getUser(){
		return userRepository.findAll();
	}
	public  void deleteUser( long groupId) {
		userRepository.deleteById(groupId);

	}


}
