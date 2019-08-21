
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<link rel="stylesheet" href="/Mock_Kiranico/css/HHNotes.css">

<div class = "melody_main">
	<div class="info_header">
		<img src="/Mock_Kiranico/imgs/website/guide.png">
		<p>Melodies</p>
	</div>
	<div class = "melody_table">
		<table style="width: 1000px">
			<thead>
				<tr>
					<td style="width: 100px; text-align: center;">Notes</td>
					<td style="width: 200px; text-align: center;">Melody Name</td>
					<td style="width: 150px; text-align: center;">Duration</td>
					<td style="width: 150px; text-align: center;">Extension</td>
					<td style="width: 200px; text-align: center;">Effect 1</td>
					<td style="width: 200px; text-align: center;">Effect 2</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${melodies}" var="melody" varStatus="loop">
					<tr>
						<td style="width: 100px; text-align: center;">
							<c:forEach var="i" begin="0" end="${fn:length(melody.notes) - 1}" step="1">
								<c:set var="note" scope="request" value="${fn:substring(melody.notes, i, i + 1)}"/>
    							<c:choose>
    								<c:when test = "${fn:endsWith(weapon_notes, note)}">
    									<img height="15px" src="/Mock_Kiranico/imgs/hh_notes/mhw-note-${note}${note}.png">
    								</c:when>
    								<c:otherwise>
    									<img height="15px" src="/Mock_Kiranico/imgs/hh_notes/mhw-note-${note}.png">
    								</c:otherwise>
    							</c:choose> 
							</c:forEach>
						</td>
						<td class = "info_col" style="width: 200px; text-align: center;">${melody.base_name_en }	</td>
						<td class = "info_col" style="width: 150px; text-align: center;">${melody.duration }	</td>
						<td class = "info_col" style="width: 150px; text-align: center;">${melody.extension }	</td>
						<td class = "info_col" style="width: 200px; text-align: center;">${melody.effect1 }	</td>
						<td class = "info_col" style="width: 200px; text-align: center;">${melody.effect2 }	</td>
						
					</tr>
				</c:forEach>
			</tbody>	
		</table>	
	</div>
	
</div>

