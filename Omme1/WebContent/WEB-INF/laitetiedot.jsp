<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Laitteen Tiedot</title>
</head>
<body>
	<table border="1">
		<td><a href="laite.jsp">Laitteen Tiedot</a></td>
		<td><a href="./KaikkiLaitteet">Kaikki laitteet</a></td>
	</table>
	<br />
	<form action="./LaitteenServlet" method="post">
		<table>
			<tr>
				<td>Laitteen ID:</td>
				<td><input type="text" name="id" value="${laite.laitteenID}" /></td>
			</tr>
			<tr>
				<td>Nimi:</td>
				<td><input type="text" name="nimi" value="${laite.nimi}" /></td>
			</tr>
			<tr>
				<td>Kuvaus</td>
				<td><input type="text" name="nimi" value="${laite.kuvaus}" /></td>
			</tr>

			<tr>
				<td>Hinta</td>
				<td><input type="text" name="hinta" value="${laite.hinta}" /></td>
			</tr>

			<tr>
				<td>Ostopäivämäärä</td>
				<td><input type="text" name="ostopäivämäärä"
					value="${laite.ostopäivämäärä}" /></td>
			</tr>

			<tr>
				<td>Takuun voinassaoloajan</td>
				<td><input type="text" name="takuu" value="${laite.takuu}" /></td>
			</tr>
			<tr>

				<td colspan="2"><input type="text" name="operation"
					value="Lisätä" /> <input type="text" name="operation"
					value="Muuttaa" /> <input type="text" name="operation"
					value="Poistaa" /> <input type="text" name="operation"
					value="hakea" /></td>

			</tr>

		</table>
	</form>
</body>
</html>