<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <title>Chat - authentification</title>
</head>
<body>
<h1>Accueil du chat</h1>
<p>Bienvenue <br />
Veuillez vous identifier pour poursuivre !</p>
<form method="post" action="/tempace/api/login">
    <p>
        <label>Votre login:</label>
        <input type="text" placeholder="toto" name="login"/>
    </p>
    <p>
        <label>Votre mot de passe:</label>
        <input type="password" name="password"/>
    </p>
    <p>
        <input type="submit" value="valider" name="submitAuth"/>
    </p>
</form>
</body>
</html>

