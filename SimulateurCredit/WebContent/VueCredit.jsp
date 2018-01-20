<%@page import="web.CreditModel" %>
<% CreditModel model=(CreditModel)request.getAttribute("model"); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Simulateur Crédit</title>
<link rel="stylesheet" type="text/css"href="<%=request.getContextPath()%>/css/style.css"/>
</head>
<body>
<div>
<form action="Controller.php" method="post">
<table>
<tr>
<td>Montant :</td><td><input type="text" name="montant" value="<%=model.getMontant()%>"/></td><td>DH</td>
</tr>
<tr>
<td>Durée :</td><td><input type="text" name="duree" value="<%=model.getDuree()%>"/></td><td>Mois</td>
</tr>
<tr>
<td>Taux :</td><td><input type="text" name="taux" value="<%=model.getTaux()%>"/></td><td>%</td>
</tr>
<tr>
<td><input type="submit" value="Calculer"/></td>
</tr>
</table>
</form>
</div>
<div>
<table>
<tr><td>Mensualité :</td><td><%=model.getMensualite()%></td><td>DH</td></tr>
</table>
</div>
</body>
</html>