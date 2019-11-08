function updateMessage(node, message) {
	document.getElementById(node).innerHTML = message;
}

function updateElementDisplay(node, displayProperty) {
	document.getElementById(node).style.display = displayProperty;
}

function refreshObject(node, objectType) {
	document.getElementById(node).src = "/images/"+objectType+".png";
}

function updateSelectionButton(node1, node2) {
	document.getElementById(node1).style.backgroundColor = "#44753e"; 
	document.getElementById(node1).style.boxShadow = "5px 6px #cedecc";
	
	document.getElementById(node2).style.backgroundColor = "#68b55f"; 
	document.getElementById(node2).style.boxShadow = "none";
}

function changeFontColour(result) {
	if("Player 1 wins" == result) {
		document.getElementById("player1Title").style.color = "green";
		document.getElementById("player2Title").style.color = "red";
	} else if ("Player 2 wins" == result) {
		document.getElementById("player1Title").style.color = "red";
		document.getElementById("player2Title").style.color = "green";
 	} else {
 		document.getElementById("player1Title").style.color = "green";
 		document.getElementById("player2Title").style.color = "green";
 	}
	
}