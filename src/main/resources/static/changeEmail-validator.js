 function validate() {
    var email = document.getElementById("newEmail");
    var repeatedEmail = document.getElementById("confirmEmail");
    var password = document.getElementById("password");
    var infoResult = "";
    var result = true;

    var emailRegex = /^[\w\.-]+@[\w\.-]+\.[A-Za-z0-9]{2,3}$/;
    var passwordRegex = /^.{5,}$/;


    if(!emailRegex.test(email.value)) {
            infoResult = infoResult + "Zły email <br>";
            email.style.background = "#fcc2c2";
            result = false;
        } else {
            email.style.background = "#d9ead3";
        }


    if(email.value !== repeatedEmail.value) {
        infoResult = infoResult + "Emaile się nie zgadzają <br>";
        email.style.background = "#fcc2c2";
        repeatedEmail.style.background = "#fcc2c2";
        result = false;

    } else {
        email.style.background = "#d9ead3";
        repeatedEmail.style.background = "#d9ead3";
    }
    var info = document.getElementById("info");
    info.innerHTML = infoResult;
    return result;
 }