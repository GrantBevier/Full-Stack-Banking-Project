window.onload = function()
{
	getAllUsers();
	getAllPendingApplications();
	
	let acceptApplicationButton = document.getElementById("acceptApplicationButton");
	acceptApplicationButton.addEventListener('click',acceptUserApplication);
	let rejectApplicationButton = document.getElementById("rejectApplicationButton");
	rejectApplicationButton.addEventListener('click',rejectUserApplication);
}


function getAllUsers()
{
	let xhr = new XMLHttpRequest();
	const url = "getAllUsers";
	
	xhr.onreadystatechange = function()
	{	
		switch(xhr.readyState)
		{	
			case 0:
				console.log("nothing, not initalized yet!");
				break;
			case 1: 
				console.log("connection established");
				break;
			case 2:
				console.log("request sent");
				break;
			case 3:
				console.log("awaiting request");
				break;
			case 4: 
				console.log("FINISHED!!!!")
				if(xhr.status == 418)
				{
					console.log(xhr.responseText);
					let userList = JSON.parse(xhr.responseText);
					console.log(userList);
					userList.forEach(
						element => {
							addRow(element);
						}
					)
					let arrayOfButtons = document.getElementsByClassName("btn btn-primary");
					for(let i = 0; i < arrayOfButtons.length; i++)
					{
						arrayOfButtons[i].addEventListener('click',updateButton);
						console.log(arrayOfButtons[i]);
					}
				}
		}
	}
	xhr.open("GET",url);
		xhr.send();
}

function getAllPendingApplications()
{	
	let xhr = new XMLHttpRequest();
	const url = "getAllPendingApplications";
	
	xhr.onreadystatechange = function()
	{	
		switch(xhr.readyState)
		{	
			case 0:
				console.log("nothing, not initalized yet!");
				break;
			case 1: 
				console.log("connection established");
				break;
			case 2:
				console.log("request sent");
				break;
			case 3:
				console.log("awaiting request");
				break;
			case 4: 
				console.log("FINISHED!!!!")
				if(xhr.status == 200)
				{
					console.log(xhr.responseText);
					let userList = JSON.parse(xhr.responseText);
					console.log(userList);
					userList.forEach(
						element => {
							addRow(element);
						}
					)
					let arrayOfButtons = document.getElementsByClassName("btn btn-primary");
					for(let i = 0; i < arrayOfButtons.length; i++)
					{
						arrayOfButtons[i].addEventListener('click',updateButton);
						console.log(arrayOfButtons[i]);
					}
				}
		}
	}
	xhr.open("GET",url);
		xhr.send();
}

function acceptUserApplication(event)
{
	let xhr = new XMLHttpRequest();
	const url = "acceptUserApplication";
	
	let id = document.getElementById(event.srcElement.id + "acceptApplicationID").innerHTML;
	//let acceptApplicationID = document.getElementById("acceptApplicationID").innerHTML;
	//let id = document.getElementById("acceptApplicationID").innerText;
	
	xhr.onreadystatechange = function()
	{	
		switch(xhr.readyState)
		{
			case 0:
				console.log("nothing, not initalized yet!");
				break;
			case 1: 
				console.log("connection established");
				break;
			case 2:
				console.log("request sent");
				break;
			case 3:
				console.log("awaiting request");
				break;
			case 4: 
				console.log("FINISHED!!!!")
				if(xhr.status == 200)
				{
					//resetUserTable();
					getAllUsers();
				}
		}
	}
	
	xhr.open("POST",url);
	
	let user = {};
	//user.acceptApplicationID = acceptApplicationID;
	user.id = id;
	xhr.send(
		JSON.stringify(user)
	);
}

function rejectUserApplication(event)
{
	let xhr = new XMLHttpRequest();
	const url = "rejectUserApplication";
	
	let id = document.getElementById(event.srcElement.id + "rejectApplicationID").innerHTML;
	
	xhr.onreadystatechange = function()
	{	
		switch(xhr.readyState)
		{
			case 0:
				console.log("nothing, not initalized yet!");
				break;
			case 1: 
				console.log("connection established");
				break;
			case 2:
				console.log("request sent");
				break;
			case 3:
				console.log("awaiting request");
				break;
			case 4: 
				console.log("FINISHED!!!!")
				if(xhr.status == 200)
				{
					//resetUserTable();
					getAllUsers();
				}
		}
	}
	
	xhr.open("POST",url);
	
	let user = {};
	user.id = id;
	xhr.send(
		JSON.stringify(user)
	);
}

function addRow(user)
{
	let table = document.getElementById("user-table")
	
	let tableRow = document.createElement("tr");
	let iDCol = document.createElement("td");
	let firstNameCol = document.createElement("td");
	let lastNameCol = document.createElement("td");
	let phoneNumberCol = document.createElement("td");
	let emailAddressCol = document.createElement("td");
	let checkingAccountBalanceCol = document.createElement("td");
	let savingsAccountBalanceCol = document.createElement("td");
	
	tableRow.appendChild(iDCol);
	tableRow.appendChild(firstNameCol);
	tableRow.appendChild(lastNameCol);
	tableRow.appendChild(phoneNumberCol);
	tableRow.appendChild(emailAddressCol);
	tableRow.appendChild(checkingAccountBalanceCol);
	tableRow.appendChild(savingsAccountBalanceCol);
	
	table.appendChild(tableRow);
	
	iDCol.innerHTML = user.id;
	
	firstNameCol.innerHTML = user.firstName;
	//firstNameCol.setAttribute("id",user.id + "firstName");
	
	lastNameCol.innerHTML = user.lastName;
	//lastNameCol.setAttribute("id",user.id + "lastName");
	
	emailAddressCol.innerHTML = user.emailAddress;
	
	phoneNumberCol.innerHTML = user.phoneNumber;
	
	checkingAccountBalanceCol.innerHTML = user.checkingAccountBalance;
	
	savingsAccountBalanceCol.innerHTML = user.savingsAccountBalance;
};
	
function resetUserTable()
{
	let table = document.getElementById("user-table")
	
	while (table.rows.length > 1)
	{
  	table.deleteRow(1);
	}
}

function resetApplicationTable()
{
	let table = document.getElementById("pending-applications-table")
	
	while (table.rows.length > 1)
	{
  	table.deleteRow(1);
	}
}
	
	