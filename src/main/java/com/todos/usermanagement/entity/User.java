package com.todos.usermanagement.entity;


import com.todos.usermanagement.dto.UserDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
@Schema(name = "User Api model documentation", description = "Model")
public class User {

    @Schema(name = "Unique id field of user object")
    private @Id @GeneratedValue Long id;

    @Schema(name = "firstName field of user object")
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Schema(name = "lastName field of user object")
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Schema(name = "userName field of user object")
    @Column(name = "user_name", unique = true, nullable = false)
    private String userName;

    @Schema(name = "emailAddress field of user object")
    @Column(name = "email", unique = true, length = 45, nullable = false)
    private String email;

    @Schema(name = "password field of user object")
    @Column(name = "password")
    private String password;

    public UserDto toDto(){
        return new UserDto(this.firstName, this.lastName, this.userName, this.email, this.password);
    }

}
