<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${name}</title>
</head>
<body>
	<p><a href="/Mock_Kiranico/index">HOME</a>&nbsp; &nbsp;&nbsp;<a href="/Mock_Kiranico/Weapon/${weapon_type}">BACK TO ALL WEAPONS</a></p>
	
	<img src="/Mock_Kiranico/imgs/weapons/great-sword/buster_sword.png">
	<h1>${name}</h1>
	<table style="height: 29px;" width="675">
		<tbody>
			<tr>
				<td style="width: 127px; text-align: center;">${attack}</td>
				<td style="width: 150px; text-align: center;">${element}</td>
				<td style="width: 128px; text-align: center;">${affinity}</td>
				<td style="width: 128px; text-align: center;">${slots}</td>
				<td style="width: 129px; text-align: center;">TODO</td>
				<td style="width: 129px; text-align: center;">${rarity}</td>
			</tr>
			<tr>
				<td style="width: 127px; text-align: center;"><strong>Attack</strong></td>
				<td style="width: 150px; text-align: center;"><strong>Element</strong></td>
				<td style="width: 128px; text-align: center;"><strong>Affinity</strong></td>
				<td style="width: 128px; text-align: center;"><strong>Slots</strong></td>
				<td style="width: 129px; text-align: center;"><strong>Sharpness</strong></td>
				<td style="width: 166px; text-align: center;"><strong>Rare</strong></td>
			</tr>
		</tbody>
	</table>	
	<hr/>
	<h2>Hierarchy</h2>
	<table style="height: 55px;" width="675">
		<tbody>
			<tr>
				<td style="width: 328px;">&nbsp;
					<c:forEach items="${family}" var="member" varStatus="loop">
    					<tr>
    						<td><a href="/Mock_Kiranico/Weapon/${weapon_type}/${member.name}">${member.name}</a></td>
    						<td>
    							<c:choose>
	    							<c:when test = "${name == member.name}"> &lt--- </c:when>
    								<c:otherwise></c:otherwise>
    							</c:choose>
    						</td>
    					</tr>
  					</c:forEach>
				</td>
			</tr>
		</tbody>
	</table>
	<hr/>
	<h2>Materials</h2>
	<table style="height: 55px;" width="675">
		<tbody>
			<tr>
				<td style="width: 328px;">&nbsp;
					<c:forEach items="${materials}" var="material">
    					<tr>
    						<td><a href="/Mock_Kiranico/Material/${material.key}">${material.key } </a></td>
    						<td>${material.value }
    					</tr>
  					</c:forEach>
				</td>
			</tr>
		</tbody>
	</table>
	<hr/>
	<c:choose>
	    <c:when test = "${weapon_type == 'hunting-horn'}"> 
	    	<c:set var="melodies" scope="request" value="${melodies}"/>
	    	<jsp:include page="/WEB-INF/weapon_specific_pages/HHNotes.jsp"/>
	    </c:when>
	    <c:when test = "${weapon_type == 'light-bowgun' or weapon_type == 'heavy-bowgun'}"> 
	    	<c:set var="melodies" scope="request" value="${ammos}"/>
	    	<jsp:include page="/WEB-INF/weapon_specific_pages/BowgunAmmos.jsp"/>
	    </c:when>
		<c:otherwise></c:otherwise>
	</c:choose>
</body>
</html>