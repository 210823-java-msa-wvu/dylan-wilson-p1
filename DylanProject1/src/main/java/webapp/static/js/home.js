


function newRequest() {

window.location.href = ('requests.html')


}


function view() {window.location.href = ('viewrequests.html')}





function logout() {



    window.location.href = ('index.html')

  

}
//**********change getData to apply to my pages**************************


document.getElementById('getData').addEventListener("click", viewAll)

let baseUrl = 'http://localhost:8080/DylanProject1/requests/';

function viewAll() {
    console.log('Button clicked');

    let empId = document.getElementById('emp_id').value;

    let url = baseUrl + empId;
    console.log(url);

    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = recieveData;

    xhttp.open('GET' , url, true);

    xhttp.send();

    function recieveData() {

        let dataSection = document.getElementById('data');
        dataSection.innerHTML = '';

        if (xhttp.readyState == 4 && xhttp.status == 200) {

            let r = xhttp.responseText;
           // console.log(r);

            r = JSON.parse(r);
            console.log(r);
            let dataSection = document.getElementById('data');
            //populateData(r);

        }
    }

    }

    function populateData(res) {

        let dataSection = document.getElementById('data');

        let nameTag = document.createElement('h3');

        nameTag.innerHTML = capitalize(res.name);

        dataSection.appendChild(nameTag);


        let requestsArray = res.requests;
        console.log(requestsArray);

        let requests = document.createElement('ul');
        dataSection.innerHTML += 'Requests<br>';
        dataSection.appendChild(requests);


for (let request of requestsArray) { // for-of -> iterate over the elements inside the array
        let req = document.createElement('li');
        req.innerHTML = capitalize(request.request);
        requests.appendChild(req);
    }


    }



    function capitalize(str) {
        if (str) {
            return str.charAt(0).toUpperCase() + str.slice(1);
        } else {
            return '';
        }
    }