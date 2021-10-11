
         async function submitFetch()  {

           
            let employeeId = document.getElementById("employee id").value;
            let eventType = document.getElementById("event type").value;
            let eventDescription = document.getElementById("event description").value;
            let eventCost = document.getElementById("event cost").value;
            let  eventDate = document.getElementById("event date").value;
            let eventTime = document.getElementById("event time").value;
            let  eventLocation= document.getElementById("event location").value;
            let  workJustification= document.getElementById("justification").value;
            let  gradingFormat= document.getElementById("grading format").value;
            let urgentRequest= document.getElementById("urgent").value;




//               
            let request = {

                       employee_id : {  emp_id: employeeId},
                        "event_type": eventType,
                        "event_description": eventDescription,
                        "event_cost": eventCost,
                        "event_date": eventDate,
                        "event_time": eventTime,
                        "event_location": eventLocation,
                        "work_justification": workJustification,
                        "grading_format": gradingFormat,
                         "is_urgent": urgentRequest
            };

                const options = {
                        method: 'POST',
                        body: JSON.stringify(request),
                        headers: {

                            'Content-Type': 'DylanProject1/requests'
                        }


                }

                fetch('http://localhost:8080/DylanProject1/requests',options)   //problem here maybe

                .then(res => res.json())
                .then(res => console.log(res))
                .catch(err => console.error(err)); //problem here maybe
                
                window.location.href = ('home.html')

           }






           

            async function getRequestsFetch() {
            //******************************check url here*************************
            let url = 'http://localhost:8080/DylanProject1/requests';

            let res = await fetch(url)
            let data = await res.json()

            .them(data => {

                console.log(data);
                populateData(data);

            })
            .catch(err => console.log(err));

            }

            //function populateData(data) {
                // DOM Manipulation to create a table of books.
            //}
            


















    //         function submitRequest() {
    //             let employee_id = document.getElementById("employee id").value;
    //             let eventType = document.getElementById("event type").value;
    //             let eventDescription = document.getElementById("event description").value;
    //             let eventCost = document.getElementById("event cost").value;
    //             let  eventDate = document.getElementById("event date").value;
    //             let eventTime = document.getElementById("event time").value;
    //             let  eventLocation= document.getElementById("event location").value;
    //             let  workJustification= document.getElementById("justification").value;
    //             let  gradingFormat= document.getElementById("grading format").value;
    //              let urgentRequest= document.getElementById("urgent").value;
    // //need is_urgent*********************
    //             let request = {
    //                 // employee : {  id: employee_id,},
    //                 //         event_type: eventType,
    //                 //         event_description: eventDescription,
    //                 //         event_cost: eventCost,
    //                 //         event_date: eventDate,
    //                 //         event_time: eventTime,
    //                 //         event_location: eventLocation,
    //                 //         event_justification: workJustification,
    //                 //         grading_format: gradingFormat,
    //                 //         is_urgent: urgentRequest
    
    
    
    //                 " employee" : {  id: employee_id,},
    //                 "type": eventType,
    //                 "description": eventDescription,
    //                 "cost": eventCost,
    //                 "date": eventDate,
    //                 "time": eventTime,
    //                 "location": eventLocation,
    //                 "justification": workJustification,
    //                 "grading": gradingFormat,
    //                  "urgent": urgentRequest
    //             }
    
    //             console.log(request);
    
    //             let xhttp = new XMLHttpRequest();
    
    //             xhttp.onreadystatechange = function () {
    //             if(this.readyState == 4 && this.status == 200) {
    
    //             let r = this.responseText;
    //             console.log(r);
    //             }
    
    //             }
    //             //******************************check url here*************************
    //             xhttp.open('POST' , '', true);    //problem here maybe
    
    //             xhttp.setRequestHeader('Content-Type', 'application/json');
    
    //             xhttp.send(JSON.stringify(request)); //problem here maybe
    
    
    //             addEventListener("load", function (){
    
    //                 var form = document.getElementById(requestInfo);
                    
    //                 form.addEventListener("submit", function(event){event.preventDefault})
                    
    //                 })
    
    //             }