console.log("hello world!")

var username = document.querySelector(".username");
var password = document.querySelector(".password");

var submit = document.querySelector("#submit-btn");

var successMessage = document.querySelector(".login-success");
var errorMessage = document.querySelector(".login-failed");

// db username and password
let dbUsername = "shaad";
let dbPassword = "shaad";

submit.addEventListener("click", function(e) {
    e.preventDefault();
    if (username.value == dbUsername && password.value == dbPassword) {
        // e.preventDefault();
        successMessage.style.display = "block";
        console.log("Login Success!")
    }
    else {
        errorMessage.style.display = "block";
        // e.preventDefault();
        console.log("Login Failed!")
    }
})