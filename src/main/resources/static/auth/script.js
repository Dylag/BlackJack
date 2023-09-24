


let login_nameInput = document.getElementById("login_nameInput")
let login_passwordInput = document.getElementById("login_passwordInput")


let reg_nameInput = document.getElementById("reg_nameInput")
let reg_passwordInput = document.getElementById("reg_passwordInput")


function login(){
    login_nameInput.value = login_nameInput.value.trim()
    login_passwordInput.value = login_passwordInput.value.trim()

    if(login_nameInput.value.indexOf(' ')!==-1){
        alert('no space in username')
        return
    }


    fetch("http://localhost:8080/blackJack/auth/login",{
        method: "POST",
        body: JSON.stringify({
            username:login_nameInput.value,
            password: login_passwordInput.value
        }),
        headers: {
            "Content-type":"application/json"
        }
    })
        .then(response => response.json())
        .then(json =>{
            if(json.content === 'ok') {
                sessionStorage.setItem("username", login_nameInput.value)
                sessionStorage.setItem('role','player')
                window.location.href = "../playground/playground.html"
            }
            else
                alert(json.content)
        })
}

function registration(){

    reg_nameInput.value = reg_nameInput.value.trim()
    reg_passwordInput.value = reg_passwordInput.value.trim()

    if(reg_nameInput.value.indexOf(' ')!==-1){
        alert('no space in username')
        return
    }


    fetch("http://localhost:8080/blackJack/auth/registration", {
        method: "POST",
        body: JSON.stringify({
            username: reg_nameInput.value,
            password: reg_passwordInput.value
        }),
        headers: {
            "Content-type": "application/json"
        }
    })
        .then( response => response.json())
        .then(json => {
            if(json.content==='ok') {
                sessionStorage.setItem("username", reg_nameInput.value)
                sessionStorage.setItem('role','player')
                window.location.href = "../playground/playground.html"
            }
            else
                alert(json.content)
        })

}

function login_debug(){
    window.location.href = "../playground/playground.html"
}

function registration_debug(){
    window.location.href = "../playground/playground.html"
}