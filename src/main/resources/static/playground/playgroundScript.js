playerCards_header = document.getElementById("playerCards_header")
takeCard_btn = document.getElementById("takeCard_btn")
finishGame_btn = document.getElementById("finishGame_btn")
startGame_btn = document.getElementById("startGame_btn")

function startGame(){
    fetch("http://localhost:8080/blackJack/playground/start",{
        method:"GET"
    })
        .then(r => r.json())
        .then(r => {
            playerCards_header.textContent = r
            changeGameState()
        })
}

function takeCard(){
    fetch("http://localhost:8080/blackJack/playground/takeCard",{
        method:"GET"
    })
        .then(r => r.json())
        .then(r => playerCards_header.textContent = r)
}

function finishGame(){
    fetch("http://localhost:8080/blackJack/playground/finishGame",{
        method:"GET"
    })
        .then(r => r.json())
        .then(r => {
            alert(JSON.stringify(r))
            changeGameState()
            playerCards_header.textContent = "no cards, start the game"
        })
}

function changeGameState(){
    takeCard_btn.disabled = !takeCard_btn.disabled;
    finishGame_btn.disabled = !finishGame_btn.disabled;
    startGame_btn.disabled = !startGame_btn.disabled;
}