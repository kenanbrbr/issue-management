package com.kberber.issuemanagement.service;

import com.kberber.issuemanagement.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    User save(User user);

    User getById(long id);

    Page<User> getAllPageable(Pageable pageable);

    User getByUserName(String username);
}
