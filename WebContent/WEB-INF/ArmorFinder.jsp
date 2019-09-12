<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="https://code.jquery.com/ui/1.11.1/jquery-ui.min.js"></script>
<link rel="stylesheet" href="/Mock_Kiranico/css/ArmorFinder.css">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MHW Armor Finder</title>
</head>
<body background="/Mock_Kiranico/imgs/website/mhw_wiki_guide_background-min.jpg"
	style="background-attachment: fixed;">

<div class="topnav">
  <a href="/Mock_Kiranico/index">Home</a>
  <a href="/Mock_Kiranico/Weapons">Weapons</a>
  <a href="/Mock_Kiranico/Armors">Armors</a>
  <a href="/Mock_Kiranico/Monsters">Monsters</a>
  <a class="active" href="/Mock_Kiranico/ArmorFinder">Finder</a>
</div>

<img style="margin-left:50px; margin-top: 20px; margin-bottom: 20px;" src="/Mock_Kiranico/imgs/website/logo.png" width="250">
</body>

<div class="main_panel">
	<div class="finder_panel">
		<div class="info_header">
			<img src="/Mock_Kiranico/imgs/website/guide.png">
			<p>Armor Finder</p>
		</div>
		<table class="finder_table">
			<thead>
				<tr>
      				<td>Slots</td>
      				<td>Skills</td>
				</tr>
    		</thead>
    		<tbody>
    			<tr>
	      			<td>
        				<img src="/Mock_Kiranico/imgs/general/gem_level_1.png" height="20px" style="display: inline-block; vertical-align: text-bottom">
        				<select id="slot_1" style="display: inline-block; vertical-align: text-bottom">
	  						<option value="--">--</option>
  							<option value="1">1</option>
  							<option value="2">2</option>
  							<option value="3">3</option>
						</select>
      				</td>
      				<td>
        				<select id="skill_1">
          					<option value="--">--</option>
        				</select>
        				
      				</td>
    			</tr>
    			<tr>
	      			<td>
        				<img src="/Mock_Kiranico/imgs/general/gem_level_2.png" height="20px" style="display: inline-block; vertical-align: text-bottom">
        				<select id="slot_2" style="display: inline-block; vertical-align: text-bottom">
	  						<option value="--">--</option>
  							<option value="1">1</option>
  							<option value="2">2</option>
  							<option value="3">3</option>
						</select>
      				</td>
      				<td>
        				<select id="skill_2">
          					<option value="--">--</option>
        				</select>
      				</td>
    			</tr>
    			<tr>
	      			<td>
        				<img src="/Mock_Kiranico/imgs/general/gem_level_3.png" height="20px" style="display: inline-block; vertical-align: text-bottom">
        				<select id="slot_3">
	  						<option value="--">--</option>
  							<option value="1">1</option>
  							<option value="2">2</option>
  							<option value="3">3</option>
						</select>
      				</td>
    			</tr>
    			<tr>
    				<td>
						<button type="button" id="submit_query">Find</button>
    				</td>
    			</tr>
    		</tbody>
    		
		</table>
	</div>
	
	<div class="armors_panel">
		<div class="info_header">
			<img src="/Mock_Kiranico/imgs/website/guide.png">
			<p>Armor Finder</p>
		</div>
		<table class="armor_table">
			<thead>
				<tr>
					<td style="width: 50px; text-align: center"></td>
					<td style="width: 200px; text-align: center">Name</td>
					<td style="width: 250px; text-align: center">Skills</td>
					<td style="width: 250px; text-align: center"><img src="/Mock_Kiranico/imgs/general/slots.png" height="15px"></td>
					<td style="width: 50px; text-align: center"><img src="/Mock_Kiranico/imgs/general/defense.png" height="15px"></td>
					<td style="width: 50px; text-align: center"><img src="/Mock_Kiranico/imgs/general/fire.png" height="15px"></td>
					<td style="width: 50px; text-align: center"><img src="/Mock_Kiranico/imgs/general/water.png" height="15px"></td>
					<td style="width: 50px; text-align: center"><img src="/Mock_Kiranico/imgs/general/ice.png" height="15px"></td>
					<td style="width: 50px; text-align: center"><img src="/Mock_Kiranico/imgs/general/thunder.png" height="15px"></td>
					<td style="width: 50px; text-align: center"><img src="/Mock_Kiranico/imgs/general/dragon.png" height="15px"></td>
					
				</tr>
			</thead>
			<tbody class="filtered_armors">
			</tbody>
		</table>
	</div>
</div>

<script>
$(document).ready(function(){
	function addSkillsToSelect(skills){
		$.each(skills, function(idx, skill){
			var option_str = `<option value="\${skill}">\${skill}</option>`
			$('#skill_1').append(option_str);
			$('#skill_2').append(option_str);
		});
	};
	
	$.ajax({
		type: "GET",
		url: "${pageContext.request.contextPath}/ArmorFinder/getAllSkills",
		success: function(data){
			addSkillsToSelect(data);
		},
		error: function(){
			alert("error");
		}
	});
});

$(function(){
	
	function displaySelectedArmors(armors){
		$.each(armors, function(idx, armor) {
            var name = armor.name;
            var slots = "TODO";
            var defense = armor.defense_augment_max;
            var fire_res = armor.defense_fire;
            var water_res = armor.defense_water;
            var ice_res = armor.defense_ice;
            var thunder_res = armor.defense_thunder;
            var dragon_res = armor.defense_dragon;
            
            var skill_str = "";
            if (armor.skill1_name) {
            	skill_str += `\${armor.skill1_name} x \${armor.skill1_pts}`;
            }
            if (armor.skill2_name) {
            	skill_str += `<br>\${armor.skill2_name} x \${armor.skill2_pts}`;
            }
            
            var slot_str = 
            `
            	<img src="/Mock_Kiranico/imgs/general/gem_level_1.png"> x \${armor.num_level1_slots} &nbsp
            	<img src="/Mock_Kiranico/imgs/general/gem_level_2.png"> x \${armor.num_level2_slots} &nbsp
            	<img src="/Mock_Kiranico/imgs/general/gem_level_3.png"> x \${armor.num_level3_slots}
    		`;
    		
    		var type_img_path = `/Mock_Kiranico/imgs/general/\${armor.type}.png`
    		
            var armor_row = 
    			`<tr>
            		<td><img src="\${type_img_path}" height="20px"></td>
    				<td>\${name}</td>
    				<td id="skill_cell">\${skill_str}</td>
    				<td>\${slot_str}</td>
    				<td>\${defense}</td>
    				<td>\${fire_res}</td>
    				<td>\${water_res}</td>
    				<td>\${ice_res}</td>
    				<td>\${thunder_res}</td>
    				<td>\${dragon_res}</td>
    			</tr>`;
    		
    		$('.filtered_armors').append(armor_row);
       });
		
	};
	
	$('#submit_query').click(function(){
		var sl1 = $('#slot_1').val();
		var sl2 = $('#slot_2').val();
		var sl3 = $('#slot_3').val();
		var sk1 = $('#skill_1').val();
		var sk2 = $('#skill_2').val();
		var query = {
			"slot_1": sl1,
			"slot_2": sl2,
			"slot_3": sl3,
			"skill_1": sk1,
			"skill_2": sk2
		}
		
		$.ajax({
			type: "POST",
			url: "${pageContext.request.contextPath}/ArmorFinder/results",
	        contentType: "application/json; charset=utf-8",
			data: JSON.stringify(query),
			datatype: 'json',
			success: function(data){
				$('.filtered_armors tr').remove();
				if (data.length == 0) {
					alert("No result found!");
				}else{
					displaySelectedArmors(data);
				}
			},
			error: function(){
				alert("error");
			}
		});
	});
});
</script>

</html>