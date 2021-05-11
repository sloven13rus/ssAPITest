package Models;

import lombok.Data;

@Data
public class UserModel {
    public int id;
    public String email;
    public String first_name;
    public String last_name;
    public String avatar;

    /**
     * Метод возвращает полное имя пользователя
     * @return полное имя пользователя
     */
    public String getFullName() {
        return String.format("%s %s", first_name, last_name);
    }
}
