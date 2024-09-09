package restService.service;

import restService.dto.UserDTO;

import java.util.List;

public interface UserService {
    void addUser(UserDTO userDTO);

    UserDTO getUserById(int id);

    List<UserDTO> getAllUsers();

    void updateUser(UserDTO userDTO);

    void deleteUser(int id);
}
