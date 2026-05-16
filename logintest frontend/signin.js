const form = document.getElementById("loginForm");

form.addEventListener("submit", async function(event) {

    event.preventDefault();

    const email = document.getElementById("email").value;
    const senha = document.getElementById("password").value;

    try {

        const response = await fetch("http://localhost:8080/usuario/login", {
            method: "POST",

            headers: {
                "Content-Type": "application/json"
            },

            body: JSON.stringify({
                email: email,
                senha: senha
            })
        });
        const data = await response.text();

        if(data === "Login correto") {
            window.location.href = "loginconcluido.html";
        } else {
            alert(data);
        }
    } catch(error) {
        console.log(error);
        alert("Erro ao conectar com o servidor");
    }
});