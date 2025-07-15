<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Prolongements en attente</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            padding: 10px;
            border: 1px solid #ccc;
        }
        .actions a {
            margin-right: 10px;
            text-decoration: none;
            padding: 5px 10px;
            border-radius: 5px;
            color: white;
        }
        .valider {
            background-color: #4CAF50;
        }
        .refuser {
            background-color: #f44336;
        }
    </style>
</head>
<body>

<h2>Liste des prolongements en attente</h2>

<c:if test="${not empty success}">
    <div style="padding: 10px; background-color: #d4edda; color: #155724; border: 1px solid #c3e6cb; border-radius: 5px; margin-bottom: 15px;">
        ${success}
    </div>
</c:if>

<c:if test="${not empty error}">
    <div style="padding: 10px; background-color: #f8d7da; color: #721c24; border: 1px solid #f5c6cb; border-radius: 5px; margin-bottom: 15px;">
        ${error}
    </div>
</c:if>


<table>
    <thead>
        <tr>
            <th>ID</th>
            <th>Date fin prévue</th>
            <th>ID Prêt</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="prolongement" items="${prolongements}">
            <tr>
                <td>${prolongement.idProlongement}</td>
                <td>${prolongement.dateFin}</td>
                <td>${prolongement.pret.idPret}</td>
                <td class="actions">
                    <a class="valider" href="${pageContext.request.contextPath}/prolongement/valider?id=${prolongement.idProlongement}">Valider</a>
                    <a class="refuser" href="${pageContext.request.contextPath}/prolongement/refuser?id=${prolongement.idProlongement}">Refuser</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

</body>
</html>
