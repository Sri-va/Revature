
fetch('http://localhost:8080/RestExample02/webapi/mycontroller/json/1')
.then((response)=>response.json())
.then(data => document.getElementById('d').innerHTML=data.firstname)
.catch(err => console.log("Request failed",err));