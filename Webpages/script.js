
let subjects = document.getElementsByClassName("subject");

for (let i = 0; i < subjects.length; i++) {
    subjects[i].addEventListener("change", function () {
        let total = 0;
        for (let j = 0; j < subjects.length; j++) {
            if (subjects[j].checked) {
                total += parseInt(subjects[j].value);
            }
        }
        document.getElementById("total").innerText = "$" + total;
    });
}

document.getElementById("regForm").addEventListener("submit", function (e) {
    e.preventDefault();

    let name = document.getElementById("name").value.trim();
    let resultBox = document.getElementById("result");

    resultBox.innerHTML = "";
    resultBox.style.display = "block";
    if (name === "") {
        resultBox.style.background = "#ffe6e6";
        resultBox.style.border = "2px solid red";
        resultBox.style.color = "red";
        resultBox.innerHTML = "Please enter your name!";
        return;
    }


    let selectedSubjects = [];
    let totalAmount = 0;

    for (let i = 0; i < subjects.length; i++) {
        if (subjects[i].checked) {
            selectedSubjects.push(subjects[i].parentElement.innerText.trim());
            totalAmount += parseInt(subjects[i].value);
        }
    }

    if (selectedSubjects.length === 0) {
        resultBox.style.background = "#ffe6e6";
        resultBox.style.border = "2px solid red";
        resultBox.style.color = "red";
        resultBox.innerHTML = "Please select at least one subject!";
        return;
    }
    resultBox.style.background = "#e8ffe8";
    resultBox.style.border = "2px solid green";
    resultBox.style.color = "green";

    let msg = "<b>Registration Successful!</b><br><br>";
    msg += "<b>Name:</b> " + name + "<br><br>";
    msg += "<b>Selected Subjects:</b><br>";

    for (let j = 0; j < selectedSubjects.length; j++) {
        msg += j+1 + "." + " " + selectedSubjects[j] + "<br>";
    }

    msg += "<br><b>Total Fee:</b> $" + totalAmount;

    resultBox.innerHTML = msg;
});
