package Testing;

import org.junit.jupiter.api.Test;

import org.assertj.core.api.SoftAssertions;

class UserProfile {


    private String name;
    private String email;
    private String number;

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNumber(String number) {
        this.number = number;
    }


    public String getName() {
        try {
            name.charAt(0);
            return name;
        } catch (NullPointerException e) {
            return "Пустое имя";
        }

    }

    public String getEmail() {
        try {
            email.charAt(0);
            return email;
        } catch (NullPointerException e) {
            return "Пустая почта";
        }

    }

    public String getNumber() {
        try {
            number.charAt(0);
            Integer.parseInt(number);
            return number;
        } catch (NullPointerException e) {
            return "Номер пустой";
        } catch (NumberFormatException e) {
            return "Некорректный номер";
        }
    }

    @Test
    public void chekdata () {
    UserProfile user = new UserProfile();

    user.setName("someName");
    user.setEmail("some@mail.ru");
    user.setNumber("123456789");

    System.out.println("Имя: " + user.getName());
    System.out.println("Почта: " + user.getEmail());
    System.out.println("Номер: " + user.getNumber());


    SoftAssertions softAssert = new SoftAssertions();

    softAssert.assertThat(user.getName()).isEqualTo("someName");
    softAssert.assertThat(user.getEmail()).isEqualTo("some@mail.ru");
    softAssert.assertThat(user.getNumber()).isEqualTo("123456789");

    softAssert.assertAll();
    }
}


