 function validate() {
    var login = document.getElementById("login");
    var firstName = document.getElementById("firstName");
    var lastName = document.getElementById("lastName");
    var email = document.getElementById("email");
    var phone = document.getElementById("phone");
    var password = document.getElementById("password");
    var password2 = document.getElementById("password2");
    var infoResult = "";
    var result = true;

    var loginRegex = /^[A-Za-z0-9_]+$/;
    var firstNameRegex = /^[A-ZĄĆĘŁŃÓŚŹŻ][a-ząćęłńóśźż]+$/;
    var lastNameRegex = /^[A-ZĄĆĘŁŃÓŚŹŻ][a-ząćęłńóśźż]+([ -][A-ZĄĆĘŁŃÓŚŹŻ][a-ząćęłńóśźż]+)?$/;
    var emailRegex = /^[\w\.-]+@[\w\.-]+\.[A-Za-z0-9]{2,3}$/;
    var phoneRegex = /^[\+]?[(]?[0-9]{3}[)]?[-\s\.]?[0-9]{3}[-\s\.]?[0-9]{3,6}$/;
    var passwordRegex = /^.{5,}$/;

    if(!loginRegex.test(login.value)) {
            infoResult = infoResult + "Zły login <br>";
            login.style.background = "#fcc2c2";
            result = false;
        } else {
            login.style.background = "#d9ead3";
        }

    if(!firstNameRegex.test(firstName.value)) {
            infoResult = infoResult + "Złe imię <br>";
            firstName.style.background = "#fcc2c2";
            result = false;
        } else {
            firstName.style.background = "#d9ead3";
        }

    if(!lastNameRegex.test(lastName.value)) {
            infoResult = infoResult + "Złe nazwisko <br>";
            lastName.style.background = "#fcc2c2";
            result = false;
        } else {
            lastName.style.background = "#d9ead3";
        }

    if(!emailRegex.test(email.value)) {
            infoResult = infoResult + "Zły email <br>";
            email.style.background = "#fcc2c2";
            result = false;
        } else {
            email.style.background = "#d9ead3";
        }

    if(!phoneRegex.test(phone.value)) {
            infoResult = infoResult + "Zły numer telefonu <br>"
            phone.style.background = "#fcc2c2";
            result = false;
        } else {
            phone.style.background = "#d9ead3";
        }

    if(password.value !== password2.value) {
        infoResult = infoResult + "Hasła się nie zgadzają <br>";
        password.style.background = "#fcc2c2";
        password2.style.background = "#fcc2c2";
        result = false;
    } else if(!passwordRegex.test(password2.value)) {
        infoResult = infoResult + "Złe hasło2 <br>";
        password2.style.background = "#fcc2c2";
        result = false;
    } else {
        password.style.background = "#d9ead3";
        password2.style.background = "#d9ead3";
    }
    var info = document.getElementById("info");
    info.innerHTML = infoResult;
    return result;
 }