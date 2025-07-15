<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Prêts en prolongement en attente</title>
</head>
<body>
    <h2>Liste des prêts avec prolongement en attente</h2>
4
    <c:choose>
        <c:when test="${not empty prets}">
            <table border="1">
                <thead>
                    <tr>
                        <th>ID Prêt</th>
                        <th>Adhérant</th>
                        <th>Date de début</th>
                        <th>Exemplaire</th>
                        <th>Livre</th>
                        <th>Type de prêt</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="pret" items="${prets}">
                        <tr>
                            <td>${pret.getIdPret()}</td>
                            <%-- <t0d>${pret.getAdherant().getNomAdherant()} ${pret.getAdherant().getPrenomAdherant()}</td> --%>
                            <td>${pret.getDateDebut()}</td>
                            <%-- <td>${pret.getExemplaire().getIdExemplaire()}</td> --%>
                            <%-- <td>${pret.getExemplaire().getLivre().getTitre()}</td> --%>
                            <%-- <td>${pret.getTypePret().getType()}</td> --%>
                            <td>
                                <a href="${pageContext.request.contextPath}/prolongement/valider?id=${pret.idPret}">Valider</a> 
                                <a href="${pageContext.request.contextPath}/prolongement/refuser?id=${pret.idPret}">Refuser</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:when>
        <c:otherwise>
            <p>Aucun prêt avec prolongement en attente trouvé.</p>
        </c:otherwise>
    </c:choose>

    <br>
    <a href="${pageContext.request.contextPath}/dashboard">← Retour</a>
</body>
</html>
