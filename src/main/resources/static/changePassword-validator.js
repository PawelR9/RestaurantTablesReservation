 function validate() {
    var password = document.getElementById("password");
    var password2 = document.getElementById("password2");
    var infoResult = "";
    var result = true;

    var passwordRegex = /^.{5,}$/;

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