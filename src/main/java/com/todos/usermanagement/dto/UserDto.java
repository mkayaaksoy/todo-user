package com.todos.usermanagement.dto;

import com.todos.usermanagement.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String userName;
    @NotNull
    private String email;
    @NotNull
    private String password;

    public User toEntity(){
        return new User(null, this.firstName, this.lastName, this.userName, this.email, this.password);
    }

}
