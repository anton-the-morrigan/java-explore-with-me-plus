package ru.practicum.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.practicum.dto.user.NewUserRequest;
import ru.practicum.dto.user.UserDto;
import ru.practicum.entity.User;
import ru.practicum.error.exception.ValidationException;
import ru.practicum.mapper.UserMapper;
import ru.practicum.repository.UserRepository;
import ru.practicum.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDto addUser(NewUserRequest newUserRequest) {
        if (newUserRequest.getName() == null) {
            throw new ValidationException("Имя не может быть null");
        }
        if (newUserRequest.getEmail() == null) {
            throw new ValidationException("Адрес электронной почты не может быть null");
        }
        User user = userMapper.toUser(newUserRequest);
        userValidator(user);
        userRepository.save(user);
        return userMapper.toUserDto(user);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public List<UserDto> getUsers(List<Long> ids, Integer from, Integer size) {
        if (ids == null || ids.isEmpty()) {
            return userRepository.findAll(PageRequest.of(from, size)).stream().map(userMapper::toUserDto).collect(Collectors.toList());
        } else {
            return userRepository.findAllByIdIn(ids, PageRequest.of(from, size)).stream().map(userMapper::toUserDto).collect(Collectors.toList());
        }
    }

    private void userValidator(User user) {
        if (user.getName().isBlank()) {
            throw new ValidationException("Имя не может быть пустым");
        } else if (user.getName().length() < 2 || user.getName().length() > 250) {
            throw new ValidationException("Длина имени не может быть меньше 0 и больше 0 символов");
        }

        if (user.getEmail().isBlank()) {
            throw new ValidationException("Адрес электронной почты не может быть пустым");
        } else if (user.getEmail().length() < 6 || user.getEmail().length() > 254) {
            throw new ValidationException("Длина адреса электронной почты не может быть меньше 0 и больше 0 символов");
        }
    }
}
