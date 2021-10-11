
//function alertFunction() {alert ("Invalid credentials. Please try again.")}


async function login() {

    let url = "http://localhost:8080/DylanProject1/login";

    let user = {
        username: document.getElementById('username').value,
        password: document.getElementById('password').value
    }



    
    if( username == document.getElementById("username").value && password == document.getElementById("password").value) {


//************************************implement another if to check for title and send to appropriate homepage**********************************


    let res = await fetch(url, {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify(user)
    });

    let resJson = await res.json()
    .then(res => {
        console.log(res);
    })
    .catch(error => {
        console.log(error);

        //console.log(getCookie());
    })
} else {document.getElementById("badlogin").innerHTML = "Invalid login. Please try again";
() => {setTimeout(function() { window.location.href = ('index.html')}, 2800);}
  //alert("inavlid login. Please enter a valid username and Id");


}







// else{() => {setTimeout(function() { window.location.href = ('index.html')}, 4000);}}



}





















   



// Hey Nick I was just wondering how are you accessing you cookies in the front end? I see that a cookie gets created for me in the browser when I log in but to access the values in it is it as easy as cookie.valueName in javascript?


//     else {var dialog = $(login).dialog('open');
//             document.inner
//         <p>Invalid Credentials. Try again</p>


//     setTimeout(function() { dialog.dialog('close'); }, 3000);}






    
    // window.location= "http://localhost:8080/DylanProject1/static/index.html"
    // alert("Invalid credentials. Please try again.");


                //alertFunction();

                                //}




// var attempt = 3; // Variable to count number of attempts.
// // Below function Executes on click of login button.
// async function secureLogin(){
//     let user = {
//         username: document.getElementById('username').value,
//         password: document.getElementById('password').value
//     }

//     console.log(user);


// if ( username == document.getElementById("username").value && password == document.getElementById("password").value){
// alert ("Login successfully");
// //window.location = "example.html"; // Redirecting to other page.

// let res = await fetch(url, {
//     method: "POST",
//     headers: {"Content-Type": "application/json"},
//     body: JSON.stringify(user)
// });

// let resJson = await res.json()
// .then(res => {
//     console.log(res);
// })
// .catch(error => {
//     console.log(error);
// })

// return false;



// }else{
// attempt --;// Decrementing by one.
// alert("You have left "+attempt+" attempt;");
// window.location = "http://localhost:8080/DylanProject1/static/index.html"
// // Disabling fields after 3 attempts.
// if( attempt == 0){
// document.getElementById("username").ariaDisabled = true;
// document.getElementById("password").ariaDisabled = true;
// document.getElementById("submit").ariaDisabled = true;

// return false;
// }
// }
// }