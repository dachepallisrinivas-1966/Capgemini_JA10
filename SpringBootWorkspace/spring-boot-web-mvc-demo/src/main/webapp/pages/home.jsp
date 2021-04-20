<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<jsp:include page="/header" />
<section style="min-height:400px">
	<h2>Home Page</h2>
	<table border="1" width="50%">
		<thead>
			<tr>
				<td>Name</td>
				<td>Age</td>
				<td>Location</td>
				<td>Technologies</td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${name }</td>
				<td>${age }</td>
				<td>${location }</td>
				<td>
					<ul>
						<c:forEach var="t" items="${technologies}">
							<li>${t }</li>
						</c:forEach>
					</ul>
				</td>
			</tr>
		</tbody>
	</table>
</section>
<jsp:include page="/footer" />