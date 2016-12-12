package common.entities;

/**
 * Модель данных пользователя
 */
public class Users {
    private Integer userId;
    private String name;
    private String lname;
    private String password;
    private String email;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Проверка идентичности введенных паролей
     *
     * @param password       - пароль пользователя
     * @param repeatPassword - повтор пароля для проверки
     */
    public void setWithRepeatPassword(String password, String repeatPassword) {
        if (!password.equals("") && password.equals(repeatPassword)) {
            this.setPassword(password);
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public boolean isEmpty() {
        if (email.equals("") || password.equals("") || name.equals("")) {
            return true;
        }
        return false;
    }
}
