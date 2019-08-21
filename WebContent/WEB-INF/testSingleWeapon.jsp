<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="/Mock_Kiranico/css/testSingleWeapon.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${weapon_name}</title>
</head>
<body background="/Mock_Kiranico/imgs/website/mhw_wiki_guide_background-min.jpg"
	style="background-attachment: fixed;">

<div class="topnav">
  <a href="/Mock_Kiranico/index">Home</a>
  <a class="active" href="/Mock_Kiranico/Weapons">Weapons</a>
  <a href="/Mock_Kiranico/Armors">Armors</a>
  <a href="/Mock_Kiranico/Monsters">Monsters</a>
  <a class="back_button" href="/Mock_Kiranico/Weapon/${weapon_type}">Back to All</a>
</div>

<img style="margin-left:50px; margin-top: 20px; margin-bottom: 20px;" src="/Mock_Kiranico/imgs/website/logo.png" width="250">

<div class="main_panel">
	<div class = "weapon_info_panel">
		<table class = "weapon_info_table" style="border:2px solid #88dd8b;">
			<tr>
				<th style="text-align: center; width 200px" colspan="2"><h2>${weapon_name}</h2></th>
			</tr>
			<tr>
				<td colspan="2"><img src = "/Mock_Kiranico/imgs/weapons/${weapon_type}/${weapon_img_path}"></td>
			</tr>
			<tr class = "odd_row">
				<td class = "left_col" style="text-align: center; width 65px"><img height = "20" src = "/Mock_Kiranico/imgs/general/attack.png"></td>
				<td style="text-align: center; width 135px">${attack }</td>
			</tr>
			<tr class = "even_row">
				<td class = "left_col" style="text-align: center; width 65px"><img height = "20" src = "/Mock_Kiranico/imgs/general/whetstone.png"></td>
				<td style="text-align: center; width 135px">
					<c:if test = "${weapon_type == 'light-bowgun' || weapon_type == 'heavy-bowgun' || weapon_type == 'bow'}"> --- </c:if>
      				<c:if test = "${weapon_type != 'light-bowgun' && weapon_type != 'heavy-bowgun' && weapon_type != 'bow' }"> 
      					<img width = "100" src="/Mock_Kiranico/imgs/sharpness_imgs/${sharpness_img_path}">
      				</c:if>
				</td>
			</tr>
			<tr class = "odd_row">
				<td class = "left_col" style="text-align: center; width 65px"><img height = "20" src = "/Mock_Kiranico/imgs/general/affinity.png"></td>
				<td style="text-align: center; width 135px">${affinity}</td>
			</tr>
			<tr class = "even_row">
				<td class = "left_col" style="text-align: center; width 65px"><img height = "25" src = "/Mock_Kiranico/imgs/general/element.png"></td>
				<td style="text-align: center; width 135px">
					<c:if test = "${weapon_type == 'light-bowgun' || weapon_type == 'heavy-bowgun' || weapon_type == 'bow'}"> --- </c:if>
      				<c:if test = "${weapon_type != 'light-bowgun' && weapon_type != 'heavy-bowgun' && weapon_type != 'bow' }"> 
      					<p><img height = "20" src = "/Mock_Kiranico/imgs/general/${element_img_path}">${element_attack}</p>
      				</c:if>
				</td>
			</tr>
			<tr class = "odd_row">
				<td class = "left_col" style="text-align: center; width 65px"><img height = "20" src = "/Mock_Kiranico/imgs/general/slots.png"></td>
				<td style="text-align: center; width 135px">
					<c:if test = "${slot_1 != 0}"><img height = "20" src = "/Mock_Kiranico/imgs/general/gem_level_${slot_1}.png"></c:if>
					<c:if test = "${slot_2 != 0}"><img height = "20" src = "/Mock_Kiranico/imgs/general/gem_level_${slot_2}.png"></c:if>
					<c:if test = "${slot_3 != 0}"><img height = "20" src = "/Mock_Kiranico/imgs/general/gem_level_${slot_3}.png"></c:if>
				</td>
			</tr>
			<tr class = "even_row">
				<c:choose>
					<c:when test="${weapon_type == 'gunlance'}">
						<td class = "left_col" style="text-align: center; width 65px">
							<img height = "25" src = "/Mock_Kiranico/imgs/general/info.png">
						</td>
						<td style="width: 150px; text-align: center;">${shelling_info}</td>
					</c:when>
					<c:when test="${weapon_type == 'insect-glaive'}">
						<td class = "left_col" style="text-align: center; width 65px">
							<img height = "25" src = "/Mock_Kiranico/imgs/general/info.png">
						</td>
						<td style="width: 150px; text-align: center;">${kinsect_bonus}</td>
					</c:when>
					<c:when test="${weapon_type == 'charge-blade'}">
						<td class = "left_col" style="text-align: center; width 65px">
							<img height = "25" src = "/Mock_Kiranico/imgs/general/info.png">
						</td>
						<td style="width: 150px; text-align: center;">${phial_info}</td>
					</c:when>
					<c:when test="${weapon_type == 'switch-axe'}">
						<td class = "left_col" style="text-align: center; width 65px">
							<img height = "25" src = "/Mock_Kiranico/imgs/general/info.png">
						</td>
						<td style="width: 150px; text-align: center;">${phial_info}</td>
					</c:when>
				</c:choose>
			</tr>
			
		</table>
	</div>

	<div class="detailed_info_panel">
		<div class="weapon_hierarchy_panel">
			<div class="info_header">
				<img src="/Mock_Kiranico/imgs/website/guide.png">
				<p>${weapon_name}'scraftingand upgrades</p>
			</div>
			<table class="weapon_hierarchy_table">
				<thead>
					<tr>
						<td style="text-align: center" width="150px">&nbsp;</td>
						<td style="text-align: center" width="70"><img height="20"
							src="/Mock_Kiranico/imgs/general/attack.png"></td>
						<td style="text-align: center" width="170"><img height="20"
							src="/Mock_Kiranico/imgs/general/whetstone.png"></td>
						<td style="text-align: center" width="70"><img height="20"
							src="/Mock_Kiranico/imgs/general/affinity.png"></td>
						<td style="text-align: center" width="110"><img height="20"
							src="/Mock_Kiranico/imgs/general/element.png"></td>
						<td style="text-align: center" width="70"><img height="20"
							src="/Mock_Kiranico/imgs/general/slots.png"></td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${family}" var="member">
						<tr class="basic_info_row">
							<td rowspan="2" style="text-align: center" height="60"
								width="200"><img
								style="display: inline-block; vertical-align: middle;"
								height="40"
								src="/Mock_Kiranico/imgs/weapons/${weapon_type}/${member.image_path}">
								<a style="display: inline-block; color: #2c962f; vertical-align: middle"
								href="/Mock_Kiranico/Weapon/${weapon_type}/${member.name}">${member.name}</a>
							</td>
							<td style="text-align: center" height="30">${member.attack }</td>
							<td style="text-align: center" height="30">
								<c:if test = "${weapon_type == 'light-bowgun' || weapon_type == 'heavy-bowgun' || weapon_type == 'bow'}"> --- </c:if>
      							<c:if test = "${weapon_type != 'light-bowgun' && weapon_type != 'heavy-bowgun' && weapon_type != 'bow' }">
      								<img width="140" src="/Mock_Kiranico/imgs/sharpness_imgs/${member.sharpness_img}">
      							</c:if> 
							</td>
							<td style="text-align: center" height="30">${member.affinity }</td>
							<td style="text-align: center" height="30">
								<c:if test = "${weapon_type == 'light-bowgun' || weapon_type == 'heavy-bowgun' || weapon_type == 'bow'}"> --- </c:if>
								<c:if test="${not empty member.element_img}">
									<p style="margin-top: 0px; margin-bottom: 0px;">
										<img height="10" src="/Mock_Kiranico/imgs/general/${member.element_img}">${member.element1_atk}
									</p>
								</c:if> 
								<c:if test="${empty member.element_img}">
									<p style="margin-top: 0px; margin-bottom: 0px;">${member.element1_atk}</p>
								</c:if>
							</td>
							<td style="text-align: center" height="30"><c:if
									test="${member.slot_1 != 0}">
									<img height="20"
										src="/Mock_Kiranico/imgs/general/gem_level_${member.slot_1}.png">
								</c:if> <c:if test="${member.slot_2 != 0}">
									<img height="20"
										src="/Mock_Kiranico/imgs/general/gem_level_${member.slot_2}.png">
								</c:if> <c:if test="${member.slot_3 != 0}">
									<img height="20"
										src="/Mock_Kiranico/imgs/general/gem_level_${member.slot_3}.png">
								</c:if></td>
						</tr>
						<tr class="material_row">
	   						<td colspan="5">
								<p style="color: #d3d3d3">
									<c:forEach var="entry" items="${member.materials}">
										<a style="color: #2c962f; font-size: 15px;"
											href="/Mock_Kiranico/Material/${entry.key}">${entry.key}</a> * ${entry.value};
									</c:forEach>
								</p>
							</td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
		</div>

		<div class = "additional_panel">
			<c:choose>
	    		<c:when test = "${weapon_type == 'hunting-horn'}"> 
	    			<c:set var="melodies" scope="request" value="${melodies}"/>
	    			<c:set var="weapon_notes" scope="request" value = "${weapon_notes}"/>
	    			<jsp:include page="/WEB-INF/weapon_specific_pages/HHNotes.jsp"/>
	    		</c:when>
	    		<c:when test = "${weapon_type == 'light-bowgun' or weapon_type == 'heavy-bowgun'}"> 
			    	<c:set var="ammos" scope="request" value="${ammos}"/>
	    			<jsp:include page="/WEB-INF/weapon_specific_pages/BowgunAmmos.jsp"/>
	    		</c:when>
				<c:otherwise></c:otherwise>
			</c:choose>
			
		</div>

	</div>

</div>


</body>
</html>