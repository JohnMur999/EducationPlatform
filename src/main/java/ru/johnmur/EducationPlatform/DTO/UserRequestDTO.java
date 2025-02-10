package ru.johnmur.EducationPlatform.DTO;

public class UserRequestDTO {
    private long id;
    private String username;
    private String password;
    private String email;
    private String phone;

    public UserRequestDTO() {}

    public UserRequestDTO(long id, String username, String email, String password, String phone) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void setId(long id) {
        this.id = id;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

}
