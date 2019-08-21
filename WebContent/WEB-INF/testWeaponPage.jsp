<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="/Mock_Kiranico/css/testWeaponPage.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MHW ${weapon_type}</title>
</head>
<body background="/Mock_Kiranico/imgs/website/mhw_wiki_guide_background-min.jpg"
	style="background-attachment: fixed;">

<div class="topnav">
  <a href="/Mock_Kiranico/index">Home</a>
  <a class="active" href="/Mock_Kiranico/Weapons">Weapons</a>
  <a href="/Mock_Kiranico/Armors">Armors</a>
  <a href="/Mock_Kiranico/Monsters">Monsters</a>
</div>

<img style="margin-left:50px; margin-top: 20px; margin-bottom: 20px;" src="/Mock_Kiranico/imgs/website/logo.png" width="250">

<div class="main_panel">
<table>
	<!-- 
	<col/>
	<col span="6" class = "weapon_attr_header" /> -->
	<tr class = "weapon_attr">
		<td id = "header_img">&nbsp;</td>
		<td style="text-align: center">Name</td>
		<td style="width: 127px; text-align: center"><a class = "sorting" href="/Mock_Kiranico/Weapon/${weapon_type}/sort_by/attack">Attack</a></td>
		<td style="width: 127px; text-align: center">Sharpness</td>
		<td style="width: 127px; text-align: center"><a class = "sorting" href="/Mock_Kiranico/Weapon/${weapon_type}/sort_by/affinity">Affinity</a></td>
		<td style="width: 127px; text-align: center"><a class = "sorting" href="/Mock_Kiranico/Weapon/${weapon_type}/sort_by/element">Element</a></td>
		<td style="width: 127px; text-align: center"><a class = "sorting" href="/Mock_Kiranico/Weapon/${weapon_type}/sort_by/element_atk">Element Attack</a></td>
		<td style="width: 127px; text-align: center">Slots</td>	
		<td style="width: 127px; text-align: center"><a class = "sorting" href="/Mock_Kiranico/Weapon/${weapon_type}/sort_by/rarity">Rarity</a></td>	
	</tr>
  	<c:forEach items="${weapons}" var="weapon">
    	<tr class = "weapon_attr">
    		<td id = "cell_img"><img src = "/Mock_Kiranico/imgs/weapons/${weapon_type}/${weapon.image_path}" height="100"></td>   
    		<td style = "text-align: center"><a class = "link" href="/Mock_Kiranico/Weapon/${weapon_type}/${weapon.name}">${weapon.name}</a></td>		
    		<td style="width: 127px; text-align: center"><c:out value="${weapon.attack}"/></td>
    		<td style="width: 127px; text-align: center">
    			<c:if test = "${weapon_type != 'light-bowgun' && weapon_type != 'heavy-bowgun' && weapon_type != 'bow' }">
    				<img width = "100" src = "/Mock_Kiranico/imgs/sharpness_imgs/${weapon.sharpness_img}">	
    			</c:if>
    			<c:if test = "${weapon_type == 'light-bowgun' || weapon_type == 'heavy-bowgun' || weapon_type == 'bow' }">
    				---
    			</c:if>
    		</td>
    		<td style="width: 127px; text-align: center"><c:out value="${weapon.affinity}"/></td>
      		<td style="width: 127px; text-align: center">
      			<c:choose>
      				<c:when test = "${weapon_type == 'light-bowgun' || weapon_type == 'heavy-bowgun' || weapon_type == 'bow'}"> --- </c:when>
	    			<c:when test = "${weapon.element_hidden}"> [${weapon.element1}] </c:when>
    				<c:otherwise><img height = "20" src = "/Mock_Kiranico/imgs/general/${weapon.element1}.png"></c:otherwise>
    			</c:choose>
      		</td>
      		<td style="width: 127px; text-align: center">
      			<c:if test = "${weapon_type == 'light-bowgun' || weapon_type == 'heavy-bowgun' || weapon_type == 'bow'}"> --- </c:if>
      			<c:if test = "${weapon_type != 'light-bowgun' && weapon_type != 'heavy-bowgun' && weapon_type != 'bow' }"> ${weapon.element1_atk} </c:if>		
      		</td>
      		<td style="width: 127px; text-align: center">
				<c:if test = "${weapon.slot_1 != 0}"><img src = "/Mock_Kiranico/imgs/general/gem_level_${weapon.slot_1}.png"></c:if>
				<c:if test = "${weapon.slot_2 != 0}"><img src = "/Mock_Kiranico/imgs/general/gem_level_${weapon.slot_2}.png"></c:if>
				<c:if test = "${weapon.slot_3 != 0}"><img src = "/Mock_Kiranico/imgs/general/gem_level_${weapon.slot_3}.png"></c:if>
			</td>
      		<td style="width: 127px; text-align: center"><c:out value="${weapon.rarity}"/></td>
    	</tr>
  	</c:forEach>
</table>
</div>


</body>
</html>