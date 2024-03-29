package com.qf.response;

import com.qf.domain.User;
import lombok.Data;

import java.util.List;
@Data
public class UserResponse {
    private List<User> list;

    private Integer page;
    private Long total;
}
