 function validate() {
    var firstName = document.getElementById("firstName");
    var lastName = document.getElementById("lastName");
    var email = document.getElementById("email");
    var phone = document.getElementById("phoneNumber");
    var infoResult = "";
    var result = true;

    var firstNameRegex = /^[A-ZĄĆĘŁŃÓŚŹŻ][a-ząćęłńóśźż]+$/;
    var lastNameRegex = /^[A-ZĄĆĘŁŃÓŚŹŻ][a-ząćęłńóśźż]+([ -][A-ZĄĆĘŁŃÓŚŹŻ][a-ząćęłńóśźż]+)?$/;
    var emailRegex = /^[\w\.-]+@[\w\.-]+\.[A-Za-z0-9]{2,3}$/;
    var phoneNumberRegex = /^[\+]?[(]?[0-9]{3}[)]?[-\s\.]?[0-9]{3}[-\s\.]?[0-9]{3,6}$/;

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

    if(!phoneNumberRegex.test(phoneNumber.value)) {
            infoResult = infoResult + "Zły numer telefonu <br>"
            phone.style.background = "#fcc2c2";
            result = false;
        } else {
            phone.style.background = "#d9ead3";
        }

    var info = document.getElementById("info");
    info.innerHTML = infoResult;
    return result;
 }