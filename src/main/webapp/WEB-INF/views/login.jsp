<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Connexion</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: #f5f5f5;
            margin: 0;
            font-family: sans-serif;
        }

        .login {
            background: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
            width: 28vw;
        }

        .login fieldset {
            margin-bottom: 20px;
            display: flex;
            flex-direction: column;
            padding: 10px;
            border: none;
        }

        .login input,
        .login select {
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            margin-top: 10px;
            margin-bottom: 10px;
        }

        .login button {
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            margin-top: 10px;
            margin-bottom: 10px;
            background-color: #007bff;
            color: #fff;
            cursor: pointer;
        }

        .login button:hover {
            background-color: #0056b3;
        }

        .error {
            color: red;
            margin-top: 10px;
        }
    </style>
</head>
<body>
    <div class="login">
        <form action="login" method="POST">
            <fieldset>
                <h1>Connexion</h1>

                <label for="nom">Numéro adhérant :</label>
                <input type="text" name="numeroAdherant" id="nom" placeholder="Ex: 1">

                <label for="mdp">Mot de passe :</label>
                <input type="password" name="motDePasse" id="mdp" placeholder="************************">

                <button type="submit">Se connecter</button>

                <c:if test="${not empty error}">
                    <div class="error">
                        <c:out value="${error}" />
                    </div>
                </c:if>
            </fieldset>
        </form>
    </div>
</body>
</html>
