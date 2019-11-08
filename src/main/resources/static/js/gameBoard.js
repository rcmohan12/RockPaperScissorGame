function showPlayerModeMessage() {
	updateMessage("message", "You are Player 1. Select Rock, Paper or Scissor to start the game");
	updateElementDisplay("player1Options", "block");
	updateElementDisplay("computerModePlayButton", "none");
	updateSelectionButton("player_Mode", "computer_Mode");
}

function showComputerModeMessage() {
	updateMessage("message", "Click the play button to start the game");
	updateElementDisplay("player1Options", "none");
	updateElementDisplay("computerModePlayButton", "block");
	updateSelectionButton("computer_Mode", "player_Mode");
}

const newGame = gameVals => {
	
	const options = {
			method : 'POST',
			body : JSON.stringify(gameVals),
			headers : new Headers({
				'Content-Type' : 'application/json'
			})
	}
	
	fetch("http://localhost:8080/play", options)
	.then(res => {
		if(res.ok) {
			return res.json();
		} else {
			throw new Error("No Results");
		}
	})
	.then(res => updateBoard(res))
	.catch((error) => {
		  console.log(error);
		  updateMessage("messageContainer", "Something went wrong. Please try again");
	});
}

function updateBoard(res) {
	
	refreshObject("p2obj", res.playerTwoObj);
	
	if(res.gameMode == "computer") {
		refreshObject("p1obj", res.playerOneObj);
	}
	
	updateMessage("resultContainer", res.result);
	changeFontColour(res.result);
	
}


function getComputerModeResult(event) {
	var gameVals = {
			"playerOneObj" : "",
			"playerTwoObj" : "",
			"result" : "",
			"gameMode" : "computer"
	}
	newGame(gameVals);
}

function getPlayerModeResult(event) {
	var playerObject;
	playerObject = event.target.id.toUpperCase();
	refreshObject("p1obj", playerObject);
	
	const gameVals = {
			"playerOneObj" : playerObject,
			"playerTwoObj" : "",
			"result" : "",
			"gameMode" : "player"
	}
	
	newGame(gameVals);
	
}

