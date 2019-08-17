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
				<td style="text-align: center; width 135px"><img width = "100" src="/Mock_Kiranico/imgs/sharpness_imgs/${sharpness_img_path}"></td>
			</tr>
			<tr class = "odd_row">
				<td class = "left_col" style="text-align: center; width 65px"><img height = "20" src = "/Mock_Kiranico/imgs/general/affinity.png"></td>
				<td style="text-align: center; width 135px">${affinity}</td>
			</tr>
			<tr class = "even_row">
				<td class = "left_col" style="text-align: center; width 65px"><img height = "20" src = "/Mock_Kiranico/imgs/general/element.png"></td>
				<td style="text-align: center; width 135px">
					<p><img height = "20" src = "/Mock_Kiranico/imgs/general/${element_img_path}">${element_attack}</p>
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
		</table>
	</div>

	<div class = "weapon_hierarchy_panel">
		<div class = "info_header">
			<img src = "/Mock_Kiranico/imgs/website/guide.png">
			<p>${weapon_name}'s crafting and upgrades</p>
		</div>
			
		<table class = "weapon_hierarchy_table">
			<thead>
				<tr>
					<td style = "text-align: center" width="150px">&nbsp;</td>
					<td style = "text-align: center" width="70"><img height = "20" src = "/Mock_Kiranico/imgs/general/attack.png"></td>
					
					<td style = "text-align: center" width="170"><img height = "20" src = "/Mock_Kiranico/imgs/general/whetstone.png"></td>
					<td style = "text-align: center" width="70"><img height = "20" src = "/Mock_Kiranico/imgs/general/affinity.png"></td>
					<td style = "text-align: center" width="110"><img height = "20" src = "/Mock_Kiranico/imgs/general/element.png"></td>
					<td style = "text-align: center" width="70"><img height = "20" src = "/Mock_Kiranico/imgs/general/slots.png"></td>
				</tr>
			</thead>
			<tbody>
				<tr class = "basic_info_row">
					<td rowspan = "2">FUCK</td>
					<td>1000</td>
					<td>1000</td>
					<td>1000</td>
					<td>1000</td>
					<td>1000</td>
				</tr>
				<tr class = "material_row">
					<td colspan="5"> LONG ASS STUFF </td>
				</tr>
				<tr class = "basic_info_row">
					<td rowspan = "2">SHIT</td>
					<td>1000</td>
					<td>1000</td>
					<td>1000</td>
					<td>1000</td>
					<td>1000</td>
				</tr>
				<tr class = "material_row">
					<td colspan="5"> LONG ASS STUFF </td>
				</tr>
			</tbody>
		</table>
	</div>
</div>


</body>
</html>