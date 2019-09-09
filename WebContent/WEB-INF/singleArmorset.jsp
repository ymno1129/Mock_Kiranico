<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="/Mock_Kiranico/css/singleArmorset.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MHW ${armorset.name}</title>
</head>

<body background="/Mock_Kiranico/imgs/website/mhw_wiki_guide_background-min.jpg"
	style="background-attachment: fixed;">
	
<div class="topnav">
  <a href="/Mock_Kiranico/index">Home</a>
  <a href="/Mock_Kiranico/Weapons">Weapons</a>
  <a  class="active" href="/Mock_Kiranico/Armors">Armors</a>
  <a href="/Mock_Kiranico/Monsters">Monsters</a>
  <a class="back_button" href="/Mock_Kiranico/Armors">Back to All</a>
</div>

<img style="margin-left:50px; margin-top: 20px; margin-bottom: 20px;" src="/Mock_Kiranico/imgs/website/logo.png" width="250">

<div class="main_panel">
	<div class = "armorset_info_panel">
		<table class = "armorset_info_table" style="border:2px solid #88dd8b;">
			<tr>
				<th style="text-align: center; width 240" colspan="6"><h2>${armorset_name}</h2></th>
			</tr>
			<tr>
				<td colspan="6" style="padding-bottom: 20px"><img src = "/Mock_Kiranico/imgs/armorsets/${set_img_path}"></td>
			</tr>
			<tr class="odd_row">
				<td class="left_col" style="text-align: center; width 60px"><img height="20" src = "/Mock_Kiranico/imgs/general/defense.png"></td>
				<td colspan="5" style="text-align: center; width 180px">100</td>
			</tr>
			<tr class = "even_row">
				<td class = "left_col" style="text-align: center; width 60px">Resis</td>
				<td class = "left_col" style="text-align: center; width 36px"><img height = "20" src = "/Mock_Kiranico/imgs/general/fire.png"></td>
				<td class = "left_col" style="text-align: center; width 36px"><img height = "20" src = "/Mock_Kiranico/imgs/general/water.png"></td>
				<td class = "left_col" style="text-align: center; width 36px"><img height = "20" src = "/Mock_Kiranico/imgs/general/thunder.png"></td>
				<td class = "left_col" style="text-align: center; width 36px"><img height = "20" src = "/Mock_Kiranico/imgs/general/ice.png"></td>
				<td class = "left_col" style="text-align: center; width 36px"><img height = "20" src = "/Mock_Kiranico/imgs/general/dragon.png"></td>
			</tr>
			<tr class = "odd_row">
				<td class = "left_col" style="text-align: center; width 60px"></td>
				<td class = "res_col" style="text-align: center; width 36px">${fire_res}</td>
				<td class = "res_col" style="text-align: center; width 36px">${water_res}</td>
				<td class = "res_col" style="text-align: center; width 36px">${thunder_res}</td>
				<td class = "res_col" style="text-align: center; width 36px">${ice_res}</td>
				<td class = "res_col" style="text-align: center; width 36px">${dragon_res}</td>
			</tr>
			<tr class = "even_row">
				<td class = "left_col" style="text-align: center; width 60px"><img height = "25" src = "/Mock_Kiranico/imgs/general/slots.png"></td>
				<td colspan="5" style="text-align: center; width 180px">
					<p>
					<img height="20" src="/Mock_Kiranico/imgs/general/gem_level_1.png"> x ${num_lvl1_slots} &nbsp 
					<img height="20" src="/Mock_Kiranico/imgs/general/gem_level_2.png"> x ${num_lvl2_slots} &nbsp
					<img height="20" src="/Mock_Kiranico/imgs/general/gem_level_3.png"> x ${num_lvl3_slots}
					<p>
				</td>
			</tr>
			<tr class = "odd_row">
				<td class = "left_col" style="text-align: center; width 60px">Skills</td>
				<td colspan="5" style="text-align: left; width 180px; padding-top: 15px; padding-bottom: 15px; padding-left: 15px">
					<c:forEach items="${skill_map}" var="entry">
						${entry.key} x ${entry.value}<br>
					</c:forEach> 
				</td>
			</tr>
		</table>
	</div>
	<div class="detailed_info_panel">
		<div class="armor_piece_panel">
			<div class="info_header">
				<img src="/Mock_Kiranico/imgs/website/guide.png">
				<p>${armorset_name}'s armor pieces</p>
			</div>
			<table class="armor_piece_table">
				<thead>
					<tr>
						<td width="50px"></td>
						<td width="200px" style="text-align: center">Name</td>
						<td width="500px" style="text-align: center">Skills</td>
						<td width="200px" style="text-align: center">Slots</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${pieces}" var="piece">
	    				<c:set var="piece_obj" scope="request" value="${piece.value}"/>
						<tr class="piece_row">
							<td width="50px"><img src="/Mock_Kiranico/imgs/general/${piece.key}.png" height="25px"></td>
							<td width="200px">${piece_obj.name}</td>
							<td width="500px">
								<c:if test="${not empty piece_obj.skill1_name}">
									${piece_obj.skill1_name} x ${piece_obj.skill1_pts} &nbsp&nbsp
								</c:if>
								<c:if test="${not empty piece_obj.skill2_name}">
									${piece_obj.skill2_name} x ${piece_obj.skill2_pts}
								</c:if>
							</td>
							<td width="200px">
								<img src="/Mock_Kiranico/imgs/general/gem_level_1.png"> x ${piece_obj.num_level1_slots}&nbsp
								<img src="/Mock_Kiranico/imgs/general/gem_level_2.png"> x ${piece_obj.num_level2_slots}&nbsp
								<img src="/Mock_Kiranico/imgs/general/gem_level_3.png"> x ${piece_obj.num_level3_slots}
							</td>
						</tr>
					</c:forEach>
					<!-- 
					<tr class="piece_row">
						<td width="50px"><img src="/Mock_Kiranico/imgs/general/head.png" height="25px"></td>
						<td width="150px">head_name</td>
						<td width="500px">head_skill</td>
						<td width="150px">
							<img src="/Mock_Kiranico/imgs/general/gem_level_1.png"> x &nbsp
							<img src="/Mock_Kiranico/imgs/general/gem_level_2.png"> x &nbsp
							<img src="/Mock_Kiranico/imgs/general/gem_level_3.png"> x 
						</td>
					</tr>
					<tr class="piece_row">
						<td width="50px"><img src="/Mock_Kiranico/imgs/general/waist.png" height="25px"></td>
						<td width="150px">chest_name</td>
						<td width="500px">chest_skill</td>
					</tr>
					<tr class="piece_row">
						<td width="50px"><img src="/Mock_Kiranico/imgs/general/arm.png" height="25px"></td>
						<td width="150px">arm_name</td>
						<td width="500px">arm_skill</td>
					</tr>
					<tr class="piece_row">
						<td width="50px"><img src="/Mock_Kiranico/imgs/general/waist.png" height="25px"></td>
						<td width="150px">waist_name</td>
						<td width="500px">waist_skill</td>
					</tr>
					<tr class="piece_row">
						<td width="50px"><img src="/Mock_Kiranico/imgs/general/leg.png" height="25px"></td>
						<td width="150px">leg_name</td>
						<td width="500px">leg_skill</td>
					</tr>
					 -->
				</tbody>
			</table>
		</div>
	</div>
</div>

</body>
</html>