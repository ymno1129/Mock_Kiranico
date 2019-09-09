<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="/Mock_Kiranico/css/allArmorsets.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MHW Armorsets</title>
</head>
<body background="/Mock_Kiranico/imgs/website/mhw_wiki_guide_background-min.jpg"
	style="background-attachment: fixed;">

<div class="topnav">
  <a href="/Mock_Kiranico/index">Home</a>
  <a href="/Mock_Kiranico/Weapons">Weapons</a>
  <a class="active" href="/Mock_Kiranico/Armors">Armors</a>
  <a href="/Mock_Kiranico/Monsters">Monsters</a>
  <a class="finder" href="/Mock_Kiranico/WeaponFinder">Finder</a>
</div>

<img style="margin-left:50px; margin-top: 20px; margin-bottom: 20px;" src="/Mock_Kiranico/imgs/website/logo.png" width="250">

<div class="main_panel">
<table>
	<thead>
		<tr class = "armorset_attr">
			<td style="width: 127px; text-align: center">Name</td>
			<td style="width: 127px; text-align: center">Appearance</td>
			<td style="width: 127px; text-align: center"><img src = "/Mock_Kiranico/imgs/general/defense.png" height="15"></td>
			<td style="width: 127px; text-align: center"><img src = "/Mock_Kiranico/imgs/general/fire.png" height="15"></td>
			<td style="width: 127px; text-align: center"><img src = "/Mock_Kiranico/imgs/general/water.png" height="15"></td>
			<td style="width: 127px; text-align: center"><img src = "/Mock_Kiranico/imgs/general/thunder.png" height="15"></td>
			<td style="width: 127px; text-align: center"><img src = "/Mock_Kiranico/imgs/general/ice.png" height="15"></td>
			<td style="width: 127px; text-align: center"><img src = "/Mock_Kiranico/imgs/general/dragon.png" height="15"></td>
			<td style="width: 150px; text-align: center"><img src = "/Mock_Kiranico/imgs/general/slots.png" height="15"></td>
			<td style="width: 250px; text-align: center">Skills</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${armorsets}" var="armorset">
			<tr class = "armorset_attr">
				<td><a class="link" href="/Mock_Kiranico/Armorset/${armorset.name}">${armorset.name}</a></td>
				<td class="set_img"><img src = "/Mock_Kiranico/imgs/armorsets/${armorset.img_path}" height="100"></td>
				<td>${armorset.defense}</td>
				<td>${armorset.fire_res}</td>
				<td>${armorset.water_res}</td>
				<td>${armorset.thunder_res}</td>
				<td>${armorset.ice_res}</td>
				<td>${armorset.dragon_res}</td>
				<td>
					<p>
					<img src="/Mock_Kiranico/imgs/general/gem_level_1.png" height="20"> x ${armorset.num_level1_slots}<br>
					<img src="/Mock_Kiranico/imgs/general/gem_level_2.png" height="20"> x ${armorset.num_level2_slots}<br>
					<img src="/Mock_Kiranico/imgs/general/gem_level_3.png" height="20"> x ${armorset.num_level3_slots}<br>
					</p>
				</td>
				<td style="text-align: left; padding-left: 10px">
				
					<c:forEach items="${armorset.skill_map}" var="entry">
						${entry.key} x ${entry.value}<br>
					</c:forEach> 
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</div>

</body>
</html>