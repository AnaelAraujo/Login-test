const signupForm = document.getElementById("signupForm");

signupForm.addEventListener("submit", async function(event) {

    event.preventDefault();

    const nome = document.getElementById("name").value;
    const email = document.getElementById("email").value;
    const senha = document.getElementById("password").value;

    try {

        const response = await fetch("http://localhost:8080/usuario/cadastro", {

            method: "POST",

            headers: {
                "Content-Type": "application/json"
            },

            body: JSON.stringify({
                nome: nome,
                email: email,
                senha: senha
            })
        });

        const data = await response.json();

        console.log(data);

        window.location.href = "signin.html";

    } catch(error) {

        console.log(error);

        alert("Erro ao cadastrar usuário");

    }

});