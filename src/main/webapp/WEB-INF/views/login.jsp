<!DOCTYPE html><!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>>
<html lang="en">
<head>
<head>eta charset="UTF-8">
    <meta charset="UTF-8">content="width=device-width, initial-scale=1.0">
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
.login input, .login select {
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
}/*# sourceMappingURL=loginEmp.css.map */
    </style>
    <title>Connexion</title>
</head>

<body>

    <div class="login">
        <form action="doLogin" method="POST">
            <fieldset>
                <h1>Connexion</h1>
                <label for="nom">Numero adherant : </label>
                <input type="text" name="numAdherant" id="nom" placeholder="Ex: 1">

                <label for="mdp">Mot de passe : </label>
                <input type="password" name="mdp" id="mdp" placeholder="************************">

                <button type="submit">Se connecter</button>
                <c:if test="${not empty erreur}">
                    <div class="error">
                        <c:out value="${erreur}" />
                    </div>
                </c:if>
            </fieldset>
        </form>
    </div>

</body>

</html>