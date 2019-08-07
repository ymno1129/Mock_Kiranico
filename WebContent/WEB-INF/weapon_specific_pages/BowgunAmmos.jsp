<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<h2>Ammos</h2>

<table style="height: 55px;" width="599px">
	<tbody>
		<tr>
			<td style="width: 206px; text-align: center;">Ammo</td>
			<td style="width: 96px; text-align: center;">Capacity</td>
			<td style="width: 85px; text-align: center;">Recoil</td>
			<td style="width: 131px; text-align: center;">Reload</td>
			<td style="width: 57px; text-align: center;">Rapid</td>
		</tr>
		<tr>
			<td style="width: 328px;">&nbsp;
				<c:forEach items="${ammos}" var="ammo" varStatus="loop">
    				<tr>
    					<td style="width: 206px; text-align: center;">${ammo.ammo_type} </td>
    					<td style="width: 96px; text-align: center;">${ammo.capacity} </td>
    					<td style="width: 85px; text-align: center;">${ammo.recoil} </td>
    					<td style="width: 131px; text-align: center;">${ammo.reload} </td>
    					<td>
    						<c:choose>
		    					<c:when test = "${ammo.rapidable}"> YES </c:when>
    							<c:otherwise></c:otherwise>
    						</c:choose>
    					</td>
    				</tr>
  				</c:forEach>
			</td>
		</tr>
	</tbody>
</table>
