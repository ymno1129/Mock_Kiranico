<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MHW Weapon Finder</title>
</head>
<body>

<form:errors path="query.*"/>
<form action="/Mock_Kiranico/WeaponFinder/results" method="post">
	<table>
		<tr>
			<td>Weapon:</td>
			<td>
				<select name="weapon_type">
					<option value="great-sword"> Great Sword </option>
					<option value="long-sword"> Long Sword </option>
					<option value="sword-and-shield"> Sword&Shield </option>
					<option value="dual-blades"> Dual Blade </option>
					<option value="hammer"> Hammer </option>
					<option value="hunting-horn"> Hunting Horn </option>
					<option value="lance"> Lance </option>
					<option value="gunlance"> Gunlance </option>
					<option value="switch-axe"> Switch Axe </option>
					<option value="charge-blade"> Charge Blade </option>
					<option value="insect-glaive"> Insect Glaive </option>
					<option value="bow"> Bow </option>
					<option value="light-bowgun"> Light Bowgun </option>
					<option value="heavy-bowgun"> Heavy Bowgun </option>
				</select>
			</td>
		</tr>
		<tr>
			<td>Element:</td>
			<td>
				<select name="element">
					<option value="fire"> Fire </option>
					<option value="water"> Water </option>
					<option value="ice"> Ice </option>
					<option value="thunder"> Thunder </option>
					<option value="dragon"> Dragon </option>
					<option value="poison"> Poison </option>
					<option value="sleep"> Sleep </option>
					<option value="paralyze"> Paralyze </option>
					<option value="blast"> Blast </option>
				</select>
		</tr>
		<tr>
			<td>Number of Slots:</td>
			<td>
				<select name="num_slots">
					<option value=0> 0 </option>
					<option value=1> 1 </option>
					<option value=2> 2 </option>
					<option value=3> 3 </option>
				</select>
		</tr>
		</table>
		<input type="submit" value="Find" />
</form>


</body>
</html>