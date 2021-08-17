import createView from "../createView";

export default function Register(props) {
    return `<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Register</title>
</head>
<body>
<h1>Register</h1>

<form id="login-form">
<label for="email">Email</label>
    <input  id="email" name="email" type="text"/>
    <label for="username">Username</label>
    <input  id="username" name="username" type="text"/>
    <label for="password">Password</label>
    <input id="password" name="password" type="password"/>
    <input id="register-btn" type="submit" value="Log In"/>
</form>
</body>
</html>`;

    const routes = {
        // ...additional routes

        '/login': {
            returnView: Register,
            state: {},
            uri: '/register',
            title: "Register",
            viewEvent : RegisterEvent
        }
    }

    function RegisterEvent(){
        document.querySelector("#register-btn").addEventListener("click", function () {
            let obj = {
                username: document.querySelector("#username").value,
                password: document.querySelector("#password").value,
                email: document.querySelector("#email").value,
                grant_type: 'password'
            }

       let request = { method: "POST",
            headers: {"Content-Type": "application/json"},
        body: **YOUR USER OBJECT**
    };

    fetch("http://localhost:8080/api/users", request)
        .then((response) => {
            console.log(response.status)
            createView("/");
        });
    }
}


