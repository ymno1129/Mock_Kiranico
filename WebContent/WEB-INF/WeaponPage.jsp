<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MHW ${weapon_type}</title>
</head>
<body>
	<h5><a href="/Mock_Kiranico/index">HOME</a></h5>
	<table>
		<tr>
			<td>Name</td>
			<td style="width: 127px; text-align: center"><a href="/Mock_Kiranico/Weapon/${weapon_type}/sort_by/attack">Attack</a></td>
			<td style="width: 127px; text-align: center"><a href="/Mock_Kiranico/Weapon/${weapon_type}/sort_by/element">Element</a></td>
			<td style="width: 127px; text-align: center"><a href="/Mock_Kiranico/Weapon/${weapon_type}/sort_by/element_atk">Element Attack</a></td>
			<td style="width: 127px; text-align: center"><a href="/Mock_Kiranico/Weapon/${weapon_type}/sort_by/rarity">Rarity</a></td>
		</tr>
  		<c:forEach items="${weapons}" var="weapon">
    		<tr>
    			<td><a href="/Mock_Kiranico/Weapon/${weapon_type}/${weapon.name}">${weapon.name}</a></td>
      			<!--<td><c:out value="${weapon.name}" /></td>  -->
      			<td style="width: 127px; text-align: center"><c:out value="${weapon.attack}"/></td>
      			<td style="width: 127px; text-align: center">
      				<c:choose>
	    				<c:when test = "${weapon.element_hidden}"> [${weapon.element1}] </c:when>
    					<c:otherwise>${weapon.element1}</c:otherwise>
    				</c:choose>
      				<!--<c:out value="${weapon.element_hidden} == false" />-->
      			</td>
      			<td style="width: 127px; text-align: center"><c:out value="${weapon.element1_atk}"/></td>
      			<td style="width: 127px; text-align: center"><c:out value="${weapon.rarity}"/></td>
    		</tr>
  		</c:forEach>
	</table>
</body>
</html>