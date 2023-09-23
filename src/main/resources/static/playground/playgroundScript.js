let playerCards_header = document.getElementById("playerCards_header")
let username_label = document.getElementById("username_label")

username_label.textContent = sessionStorage.getItem('username')

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