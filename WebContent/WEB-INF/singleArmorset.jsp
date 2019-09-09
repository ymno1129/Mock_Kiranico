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
				<td colspan="6"><img src = "/Mock_Kiranico/imgs/armorsets/${set_img_path}"></td>
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
				<td colspan="5" style="text-align: center; width 180px">
					<c:forEach items="${skill_map}" var="entry">
						${entry.key} x ${entry.value}<br>
					</c:forEach> 
				</td>
			</tr>
		</table>
	</div>
</div>

</body>
</html>