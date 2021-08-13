function updatePage() {
	
	var name=document.getElementById("name").value;
	var pass=document.getElementById("password").value;
	let emp={name:name, password:pass};

	const request = new Request('http://localhost:8080/RestExample02/webapi/mycontroller/forms', {
		method: 'POST',
		headers: [['Content-Type', 'application/json']],
		body: JSON.stringify(emp)
	});
	
	fetch(request)
	.then(function(response){
			if(response.status===200){
				 fetch('http://localhost:8080/RestExample02/webapi/mycontroller/test/hello')
					.then(res => res.json())
					.catch(e=> console.log('Error',e));
				//window.location.href = 'http://localhost:8080/RestExample02/'	
			};	
	})
	.catch(err=> console.log('Error',err))	
}
