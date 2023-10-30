 function validate() {
    var login = document.getElementById("login");
    var firstName = document.getElementById("firstName");
    var lastName = document.getElementById("lastName");
    var phoneNumber = document.getElementById("phoneNumber");
    var infoResult = "";
    var result = true;

    var loginRegex = /^[A-Za-z0-9_]+$/;
    var firstNameRegex = /^[A-ZĄĆĘŁŃÓŚŹŻ][a-ząćęłńóśźż]+$/;
    var lastNameRegex = /^[A-ZĄĆĘŁŃÓŚŹŻ][a-ząćęłńóśźż]+([ -][A-ZĄĆĘŁŃÓŚŹŻ][a-ząćęłńóśźż]+)?$/;
    var phoneNumberRegex = /^[\+]?[(]?[0-9]{3}[)]?[-\s\.]?[0-9]{3}[-\s\.]?[0-9]{3,6}$/;

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


    if(!phoneNumberRegex.test(phoneNumber.value)) {
                infoResult = infoResult + "Zły numer telefonu <br>"
                phoneNumber.style.background = "#fcc2c2";
                result = false;
            } else {
                phoneNumber.style.background = "#d9ead3";
            }

    var info = document.getElementById("info");
    info.innerHTML = infoResult;
    return result;
 }