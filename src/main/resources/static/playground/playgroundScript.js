let playerCards_header = document.getElementById("playerCards_header")
let username_label = document.getElementById("username_label")
let onlinePlayer_list = document.getElementById('onlinePlayers_list')
let messageInput = document.getElementById('messageInput')
let chat_list = document.getElementById('chat_list')

username_label.textContent = sessionStorage.getItem('username')


const stompClient = new StompJs.Client({
    brokerURL: 'ws://localhost:8080/blackJack'
});
stompClient.onConnect = (frame) =>{
    console.log(`connected: ${frame}`)


    stompClient.subscribe('/output/connections',newConnectionObject=>{

        console.log("got list")
        alert("got list")
        // let obj = JSON.parse(newConnectionObject.body)
        // console.log("Got new connection list: "+obj.body)
        //
        // let newUserItem = document.createElement('li')
        // newUserItem.textContent = `${obj.username}[${obj.role}]`
        // onlinePlayer_list.appendChild(newUserItem)
    },{
        simpSessionAttributes:JSON.stringify({
            username:sessionStorage.getItem('username'),
            role:sessionStorage.getItem('role')
        })
    })


    stompClient.subscribe("/output/chat", newMessage=>{
        let obj = JSON.parse(newMessage.body)

        let senderName = obj.sender
        let role = obj.senderRole
        let content = obj.content

        let newLi = document.createElement('li')
        newLi.textContent = `${senderName}[${role}]: ${content}`

        chat_list.appendChild(newLi)



    },{
        simpSessionAttributes:JSON.stringify({
            username:sessionStorage.getItem('username'),
            role:sessionStorage.getItem('role')
        })
    })




    // stompClient.publish({
    //     destination:'/input/newConnection',
    //     body: JSON.stringify([{
    //         username:sessionStorage.getItem('username'),
    //         role:sessionStorage.getItem('role')
    //     }])
    // })
}
window.onbeforeunload = ()=>{
    stompClient.unsubscribe(0)
    stompClient.deactivate()
}

stompClient.activate()


function sendMessage(){
    stompClient.publish({
        destination:"/input/chat",
        body: JSON.stringify({
            sender:sessionStorage.getItem('username'),
            content:messageInput.value,
            senderRole:sessionStorage.getItem('role')
        })
    })
}


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