window.onload = function()
{
	//resetUserTable();
	getAllUsers();
	
	//let updatePhoneAndEmailButton = document.getElementById("updatePhoneAndEmailButton");
	//updatePhoneAndEmailButton.addEventListener('click',updateUserPhoneAndEmail);
	let updatePhoneNumberButton = document.getElementById("updatePhoneNumberButton");
	updatePhoneNumberButton.addEventListener('click',updateUserPhoneNumber);
	let updateEmailAddressButton = document.getElementById("updateEmailAddressButton");
	updateEmailAddressButton.addEventListener('click',updateUserEmailAddress);
	let makeCheckingDepositButton = document.getElementById("makeCheckingDepositButton");
	makeCheckingDepositButton.addEventListener('click',makeCheckingDeposit);
	let makeSavingsDepositButton = document.getElementById("makeSavingsDepositButton");
	makeSavingsDepositButton.addEventListener('click',makeSavingsDeposit);
	let makeCheckingWithdrawalButton = document.getElementById("makeCheckingWithdrawalButton");
	makeCheckingWithdrawalButton.addEventListener('click',makeCheckingWithdrawal);
	let makeSavingsWithdrawalButton = document.getElementById("makeSavingsWithdrawalButton");
	makeSavingsWithdrawalButton.addEventListener('click',makeSavingsWithdrawal);
}

//function updateUserPhoneAndEmail(event)
//{
	//let xhr = new XMLHttpRequest();
	//const url = "updateUserPhoneAndEmail";
	
	//let phoneNumber = document.getElementById(event.srcElement.id + "phoneNumber").innerHTML;
	//let emailAddress = document.getElementById(event.srcElement.id + "emailAddress").innerHTML;
	
	//xhr.onreadystatechange = function()
	//{	
		//switch(xhr.readyState)
		//{
			//case 0:
				//console.log("nothing, not initalized yet!");
				//break;
			//case 1: 
				//console.log("connection established");
				//break;
			//case 2:
				//console.log("request sent");
				//break;
			//case 3:
				//console.log("awaiting request");
				//break;
			//case 4: 
				//console.log("FINISHED!!!!")
				//if(xhr.status == 200)
				//{
					////resetUserTable();
					//getAllUsers();
				//}
		//}
	//}
	
	//xhr.open("POST",url);
	
	//let user = {};
	//user.phoneNumber = phoneNumber;
	//user.emailAddress = emailAddress;
	//xhr.send(
		//JSON.stringify(user)
	//);
//}

function updateUserPhoneNumber(event)
{
	let xhr = new XMLHttpRequest();
	const url = "updateUserPhoneNumber";
	
	let phoneNumber = document.getElementById(event.srcElement.id + "phoneNumber").innerHTML;
	
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
	user.phoneNumber = phoneNumber;
	xhr.send(
		JSON.stringify(user)
	);
}

function updateUserEmailAddress(event)
{
	let xhr = new XMLHttpRequest();
	const url = "updateUserEmailAddress";
	
	let emailAddress = document.getElementById(event.srcElement.id + "emailAddress").innerHTML;
	
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
	user.emailAddress = emailAddress;
	xhr.send(
		JSON.stringify(user)
	);
}

function checkingAccountDeposit(event)
{
	let xhr = new XMLHttpRequest();
	const url = "checkingAccountDeposit";
	
	let id = 1;
	let checkingDepositAmount = document.getElementById(event.srcElement.id + "checkingDepositAmount").innerHTML;
	
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

	xhr.open("POST","url");
	
	let user = {};
	user.id = id;
	user.checkingDepositAmount = checkingDepositAmount;
	xhr.send(
		JSON.stringify(user)
	);
}

function savingsAccountDeposit(event)
{
	let xhr = new XMLHttpRequest();
	const url = "savingsAccountDeposit";
	
	let id = 1;
	let savingsDepositAmount = document.getElementById(event.srcElement.id + "savingsDepositAmount").innerHTML;
	
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
	user.savingsDepositAmount = savingsDepositAmount;
	xhr.send(
		JSON.stringify(user)
	);
}

function checkingAccountWithdrawal(event)
{
	let xhr = new XMLHttpRequest();
	const url = "checkingAccountWithdrawal";
	
	let id = 1;
	let checkingWithdrawalAmount = document.getElementById(event.srcElement.id + "checkingWithdrawalAmount").innerHTML;
	
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
				//if(xhr.status == 999)
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
	user.checkingWithdrawalAmount = checkingWithdrawalAmount;
	xhr.send(
		JSON.stringify(user)
	);
}

function savingsAccountWithdrawal(event)
{
	let xhr = new XMLHttpRequest();
	const url = "savingsAccountWithdrawal";
	
	let id = 1;
	let savingsWithdrawalAmount = document.getElementById(event.srcElement.id + "savingsWithdrawalAmount").innerHTML;
	
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
	user.savingsWithdrawalAmount = savingsWithdrawalAmount;
	xhr.send(
		JSON.stringify(user)
	);
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
					//userList.
				}
		}
	}
	xhr.open("GET",url);
	xhr.send();
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
	//let deleteCol = document.createElement("td");
	
	tableRow.appendChild(iDCol);
	tableRow.appendChild(firstNameCol);
	tableRow.appendChild(lastNameCol);
	tableRow.appendChild(phoneNumberCol);
	tableRow.appendChild(emailAddressCol);
	tableRow.appendChild(checkingAccountBalanceCol);
	tableRow.appendChild(savingsAccountBalanceCol);
	//tableRow.appendChild(deleteCol);
	
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
	
	//deleteCol.innerHTML = `<button id = "${user.id}" type="submit" class="btn btn-primary">Update Button</button>`;
};
	
function resetUserTable()
{
	let table = document.getElementById("user-table")
	
	while (table.rows.length > 1)
	{
  	table.deleteRow(1);
	}
}
	
	