
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<h2>Horn Melodies</h2>
<table style="height: 55px;" width="675">
	<tbody>
		<tr>
			<td style="width: 130px; text-align: center;">Notes </td>
			<td style="width: 130px; text-align: center;">Melody Name </td>
			<td style="width: 130px; text-align: center;">Duration </td>
			<td style="width: 130px; text-align: center;">Extension </td>
			<td style="width: 180px; text-align: center;">Effect 1 </td>
			<td style="width: 180px; text-align: center;">Effect 2 </td>
		</tr>
		<tr>
			<td style="width: 328px;">&nbsp;
				<c:forEach items="${melodies}" var="melody" varStatus="loop">
    				<tr>
    					<td style="width: 130px; text-align: center;">${melody.notes } </td>
    					<td style="width: 130px; text-align: center;">${melody.base_name_en } </td>
    					<td style="width: 130px; text-align: center;">${melody.duration } </td>
    					<td style="width: 130px; text-align: center;">${melody.extension } </td>
    					<td style="width: 180px; text-align: center;">${melody.effect1 } </td>
    					<td style="width: 180px; text-align: center;">${melody.effect2 } </td>
    				</tr>
  				</c:forEach>
			</td>
		</tr>
	</tbody>
</table>
