<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<link rel="stylesheet" href="/Mock_Kiranico/css/WeaponFinder.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MHW Weapon Finder</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
</head>

<body background="/Mock_Kiranico/imgs/website/mhw_wiki_guide_background-min.jpg"
	style="background-attachment: fixed;">

<div class="topnav">
  <a href="/Mock_Kiranico/index">Home</a>
  <a href="/Mock_Kiranico/Weapons">Weapons</a>
  <a href="/Mock_Kiranico/Armors">Armors</a>
  <a href="/Mock_Kiranico/Monsters">Monsters</a>
  <a class="active" href="/Mock_Kiranico/WeaponFinder">Finder</a>
</div>

<img style="margin-left:50px; margin-top: 20px; margin-bottom: 20px;" src="/Mock_Kiranico/imgs/website/logo.png" width="250">

<div class = "main">
<form:errors path="query.*"/>
<form action="/Mock_Kiranico/WeaponFinder/results" method="post">
	<table class = "query_table">
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
					<option value="dc"> -- </option>
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
			</td>
		</tr>
		<tr>
			<td>Affinity:</td>
			<td>
				<input type="text" value="--" name="affinity" style="width: 40px;"/>
			</td>
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
			</td>
		</tr>
	</table>
	<input type="submit" value="Find" />
</form>

</div>

<script type="text/javascript">
$('select[name=weapon_type]').change(function(){
    var weapon_type = this.value;
    if ($('.query_table .additional_info_row').length){
		$('.query_table .additional_info_row').remove();
	}
    var row_to_add;
    switch (weapon_type){
    case "charge-blade": 			
    	row_to_add = $('#cb_phial_type').html();
    	break;
    case "switch-axe":
    	row_to_add = $('#sa_phial_type').html();
    	break;
    case "gunlance":
    	row_to_add = $('#shelling_type').html();
    	break;
    case "hunting-horn":
    	break;
    case "insect-glaive":
    	row_to_add = $('#kinsect_bonus').html();
    	break;
    case "bow":
    	break;
    case "light-bowgun":
    	break;
    case "heavy-bowgun":
    	break;
    }
    $('.query_table tbody').append(row_to_add);
    
});
</script>

<script id="cb_phial_type" type="text/plain">
<tr class = "additional_info_row" id = "cb_phial_type_row">
	<td> Phial Type </td>
	<td>
		<select name="additional_info">
			<option value = "impact"> Impact </option>
			<option value = "power element"> Power Element </option>
		</select>
	</td>
</tr>
</script>

<script id="sa_phial_type" type="text/plain">
<tr class = "additional_info_row" id = "sa_phial_type_row">
	<td> Phial Type </td>
	<td>
		<select name="additional_info">
			<option value = "power"> Power </option>
			<option value = "power element"> Power Element </option>
			<option value = "exhaust"> Exhaust </option>
			<option value = "paralysis"> Paralysis </option>
			<option value = "poison"> Poison </option>
			<option value = "dragon"> Dragon </option>
		</select>
	</td>
</tr>
</script>

<script id="shelling_type" type="text/plain">
<tr class = "additional_info_row" id = "shelling_type">
	<td> Shelling Type </td>
	<td>
		<select name="additional_info">
			<option value = "normal_1"> Normal 1 </option>
			<option value = "normal_2"> Normal 2  </option>
			<option value = "normal_3"> Normal 3  </option>
			<option value = "normal_4"> Normal 4  </option>
			<option value = "long_1"> Long 1 </option>
			<option value = "long_2"> Long 2  </option>
			<option value = "long_3"> Long 3  </option>
			<option value = "long_4"> Long 4  </option>
			<option value = "wide_1"> Wide 1 </option>
			<option value = "wide_2"> Wide 2  </option>
			<option value = "wide_3"> Wide 3  </option>
			<option value = "wide_4"> Wide 4  </option>
		</select>
	</td>
</tr>
</script>

<script id="kinsect_bonus" type="text/plain">
<tr class = "additional_info_row" id = "kinsect_bonus">
	<td> Kinsect Bonus </td>
	<td>
		<select name="additional_info">
			<option value = "sever"> Sever </option>
			<option value = "speed"> Speed </option>
			<option value = "element"> Element </option>
			<option value = "health"> Health </option>
			<option value = "stamina"> Stamina </option>
			<option value = "blunt"> Blunt </option>
		</select>
	</td>
</tr>
</script>

</body>
</html>