console.log("hello world!");

var username = document.querySelector(".username");
var password = document.querySelector(".password");

var submit = document.querySelector("#submit-btn");

var gradeDiv = document.querySelector("#grade");

var studentDetailSubmit = document.querySelector("#submit-student-btn");

var successMessage = document.querySelector(".login-success");
var errorMessage = document.querySelector(".login-failed");

var canvas = document.querySelector("#canvas")

// db username and password
let dbUsername = "shaad";
let dbPassword = "shaad";

const studentDetails = [];

submit.addEventListener("click", function (e) {
  e.preventDefault();
  if (username.value == dbUsername && password.value == dbPassword) {
    // e.preventDefault();
    successMessage.style.display = "block";
    console.log("Login Success!");
  } else {
    errorMessage.style.display = "block";
    // e.preventDefault();
    console.log("Login Failed!");
  }
});

studentDetailSubmit.addEventListener("click", function (e) {
  e.preventDefault();

  var regNo = document.querySelector(".regno");
  var grade = document.querySelector(".grade");

  studentDetails.push({
    regNo: regNo.value,
    grade: grade.value,
  });

  console.log(studentDetails);

  countGrade();
});

function countGrade() {
  var sCount = 0;
  var aCount = 0;
  var bCount = 0;
  var cCount = 0;

  studentDetails.forEach(function (student) {
    if (student.grade == "S") {
      sCount++;
    } else if (student.grade == "A") {
      aCount++;
    } else if (student.grade == "B") {
      bCount++;
    } else if (student.grade == "C") {
      cCount++;
    }
  });

  gradeDiv.innerHTML = `S: ${sCount} A: ${aCount} B: ${bCount} C: ${cCount}`;
}

var ctx = canvas.getContext("2d");
ctx.strokeStyle = "red";
ctx.moveTo(0, 0);
ctx.lineTo(1000, 500);
ctx.stroke();

ctx.beginPath();
ctx.strokeStyle = "blue";
ctx.arc(500, 200, 80, 0, 2 * Math.PI);
ctx.stroke();

ctx.fillStyle = "green";
ctx.fillRect(300, 500, 400, 400);

ctx.font="30px Arial";
ctx.fillStyle = "black";
ctx.fillText("Hello World",400,200);