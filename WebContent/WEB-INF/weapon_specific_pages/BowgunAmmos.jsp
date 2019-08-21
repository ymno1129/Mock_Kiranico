<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<link rel="stylesheet" href="/Mock_Kiranico/css/Ammos.css">

<div class="info_header">
	<img src="/Mock_Kiranico/imgs/website/guide.png">
	<p>Ammos</p>
</div>

<div class = "ammo_table">
	<table style="width: 600px">
	<thead>
		<tr>
			<td style="width: 150px; text-align: center;">Ammo</td>
			<td style="width: 75px; text-align: center;">Capacity</td>
			<td style="width: 150px; text-align: center;">Recoil</td>
			<td style="width: 150px; text-align: center;">Reload</td>
			<td style="width: 75px; text-align: center;">Rapid</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${ammos}" var="ammo" varStatus="loop">
    		<tr>
    			<td class = "ammo_col" style="width: 150px; text-align: left; padding-left: 30px;">
					<img src="/Mock_Kiranico/imgs/ammos/${ammo.ammo_category}_ammo.png" height = "20px">
					${ammo.ammo_type} 	
				</td>	
    			<td class = "info_col" style="width: 75px; text-align: center;">${ammo.capacity} </td>
    			<td class = "info_col" style="width: 150px; text-align: center;">${ammo.recoil_level} </td>
    			<td class = "info_col" style="width: 150px; text-align: center;">${ammo.reload} </td>
    			<td class = "info_col" style="width: 75px; text-align: center;">
    				<c:choose>
		  					<c:when test = "${ammo.rapidable}"> YES </c:when>
    					<c:otherwise></c:otherwise>
    				</c:choose>
    			</td>
    		</tr>
  		</c:forEach>
	</tbody>
</table>
</div>

