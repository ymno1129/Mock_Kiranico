<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<link rel="stylesheet" href="/Mock_Kiranico/css/WeaponFinder.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MHW Weapon Finder</title>

<script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="https://code.jquery.com/ui/1.11.1/jquery-ui.min.js"></script>
<link rel="stylesheet" href="https://code.jquery.com/ui/1.11.1/themes/smoothness/jquery-ui.css" />

<!-- <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>-->
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

<!-- <form:errors path="query.*"/> -->
<form action="/Mock_Kiranico/WeaponFinder/finder_results" method="post">
<div class = "finder_panel">
	<div class="info_header">
		<img src="/Mock_Kiranico/imgs/website/guide.png">
		<p>Weapon Finder</p>
	</div>
	<table class = "query_table">
		<tr>
			<td>Weapon:</td>
			<td>
				<select name="weapon_type" id="weapon_sel">
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
				<select name="element" id="element_sel">
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
				<input type="text" value="--" name="affinity" style="width: 40px;" id="affinity_sel"/>
			</td>
		</tr>
		<tr>
			<td>Number of Slots:</td>
			<td>
				<select name="num_slots" id="num_slots_sel">
					<option value=0> 0 </option>
					<option value=1> 1 </option>
					<option value=2> 2 </option>
					<option value=3> 3 </option>
				</select>
			</td>
		</tr>
		<tr id="bowgun_req">
			<td>Bowgun Requirements:</td>
			<td>
				<ul id="bowgun_req_list" style="list-style: none;">
				</ul>
				<button id="add_req_button" type="button"> ADD </button>
			</td>
		</tr>
	</table>
	<!-- <button id="submit_button" type="button">Find</button>-->
	<button id="form_submit">Find</button>
</div>
</form>

<!-- 
	Scripts or Scripts related stuff below 
-->

<script type="text/javascript">
$('select[name=weapon_type]').change(function(){
    if ($('.query_table .additional_info_row').length){
		$('.query_table .additional_info_row').remove();
	}
    $('#bowgun_req').hide();
    $('.query_table #element_sel').val("dc");
	$('.query_table #element_sel').prop("disabled", false);
	$('.query_table #affinity_sel').val("--");
	$('.query_table #num_slots_sel').val("0");
    var row_to_add;

    var weapon_type = this.value;
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
    	if ($('.query_table #element_sel').length){
    		$('.query_table #element_sel').prop("disabled", true);
        	//$('.query_table #element_sel').remove();
    	}
    	$('#bowgun_req').show();
    	break;
    case "heavy-bowgun":
    	if ($('.query_table #element_sel').length){
    		$('.query_table #element_sel').prop("disabled", true);
        	//$('.query_table #element_sel').remove();
    	}
    	$('#bowgun_req').show();
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

<script>
$(function(){
	$('#bowgun_req').hide();
	$('#dialog_form').dialog({
		autoOpen: false, 
  		height: 300,
    	width: 350,
    	modal: true,
    	buttons: {
	      "Add Requirement": addRequirement,
	      Cancel: function() {
	        $("#dialog_form").dialog( "close" );
	      }
	    },
	    close: 	
	    	function(){
	    		$('#dialog_form #target_ammo').val("normal_1");
	    		$('#dialog_form #target_capacity').val("--");
	    		$('#dialog_form #target_recoil').val("--");
	    		$('#dialog_form #target_reload').val("--");
	    	}
	});
	
	$('#add_req_button').click(function(){
		$('#dialog_form').dialog("open");
	});
	
	$('#bowgun_req_list').on("click", ".del", function(){
		$(this).closest("li").remove();
	});
	
	$('#submit_button').click(function(){
		query = {
			"weapon_type": $('select[name=weapon_type] option:selected').val(),	
			"element": $('select[name=element] option:selected').val(),
			"affinity": $('input[name=affinity]').val(),
			"num_slots": $('select[name=num_slots] option:selected').val()
		};

		if ($('.query_table .additional_info_row').length){
			query["additional"] = $('select[name=additional_info]').val();
		}
		
		var len = $('#bowgun_req ul li').length
		if (len > 0 && $('#bowgun_req').is(":visible")){
			var reqs = [];
			$('#bowgun_req_list li').each(function(idx){
				reqs.push($(this).text());
			});
			query["bowgun_reqs"] = reqs.join("&");
		}
		
		$.ajax({
	        type: "POST",
	        url: "${pageContext.request.contextPath}/WeaponFinder/results",
	        contentType: "application/json; charset=utf-8",
	        data: JSON.stringify(query),
	        dataType: 'json',
	        success: function(response){
	        	alert("ok");
	        },
	        error: function(result) {
	            alert('error');
	            
	        }
	    });
	});
	
	function addRequirement(){
		var ammo = $('#target_ammo').val();
		var cap = $('#target_capacity').val();
		var rec = $('#target_recoil option:selected').text();
		var rel = $('#target_reload').val();
		
		//var to_add = "<li name=\"ammo_req\">" + "Ammo: " + ammo + 
		//";  Clip: " + cap + ";  Recoil: " + rec + ";  Reload: " + rel + 
		//"  <input type=\"image\" class=\"del\" src=\"/Mock_Kiranico/imgs/website/delete_green_no_bg.png\" width=\"20\">";
		
		var to_add = "<li>" + "<input name=\"ammo_req\" type=\"text\" value=" + "\"Ammo: " + ammo + 
		";  Clip: " + cap + ";  Recoil: " + rec + ";  Reload: " + rel + "\"readonly=\"readonly\" size=\"80\">" +
		"  <input type=\"image\" class=\"del\" src=\"/Mock_Kiranico/imgs/website/delete_green_no_bg.png\" width=\"20\">" +
		"</li>";
		
		$('#bowgun_req_list').append(to_add);
		//$(to_add).insertBefore($('#add_req_button'));
		$('#dialog_form').dialog("close");
	}
});
</script>

<div id="dialog_form" title="Add Ammo Requirement" style="display:none;">
  <table>
    <tr>
      <td> Ammo Type </td>
      <td>
        <select id = "target_ammo">
          <option value="normal_1">Normal 1</option>
          <option value="normal_2">Normal 2</option>
          <option value="normal_3">Normal 3</option>
          <option value="pierce_1">Pierce 1</option>
          <option value="pierce_2">Pierce 2</option>
          <option value="pierce_3">Pierce 3</option>
          <option value="spread_1">Spread 1</option>
          <option value="spread_2">Spread 2</option>
          <option value="spread_3">Spread 3</option>
          <option value="sticky_1">Sticky 1</option>
          <option value="sticky_2">Sticky 2</option>
          <option value="sticky_3">Sticky 3</option>
          <option value="cluster_1">Cluster 1</option>
          <option value="cluster_2">Cluster 2</option>
          <option value="cluster_3">Cluster 3</option>
          <option value="poison_1">Poison 1</option>
          <option value="poison_2">Poison 2</option>
          <option value="paralysis_1">Paralysis 1</option>
          <option value="paralysis_2">Paralysis 2</option>
          <option value="sleep_1">Sleep 1</option>
          <option value="sleep_2">Sleep 2</option>
          <option value="flame">Flame</option>
          <option value="water">Water</option>
          <option value="thunder">Thunder</option>
          <option value="ice">Ice</option>
          <option value="dragon">Dragon</option>
          <option value="slicing">Slicing</option>
        </select>
      </td>
    </tr>
    <tr>
        <td> Capacity </td>
        <td>
            <input id="target_capacity" type="text" value="--" name="capacity" style="width: 40px;"/>
        </td>
    </tr>
    <tr>
    	<td> Recoil </td>
    	<td>
    		<select id="target_recoil">
    			<option value="--">--</option>
    			<option value="-1">Auto</option>
    			<option value="1">Low</option>
    			<option value="2">Average</option>
    			<option value="3">High</option>
    			<option value="4">Very High</option>
    		</select>
    	</td>
    </tr>
    <tr>
    	<td> Reload </td>
    	<td>
    		<select id="target_reload">
    			<option value="--">--</option>
    			<option value="fast">Fast</option>
    			<option value="normal">Normal</option>
    			<option value="slow">Slow</option>
    			<option value="very slow">Very Slow</option>
    		</select>
    	</td>
    </tr>
  </table>
</div>

</body>
</html>