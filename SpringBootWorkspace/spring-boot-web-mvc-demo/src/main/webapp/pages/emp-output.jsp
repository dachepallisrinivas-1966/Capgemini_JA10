<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<jsp:include page="/header" />
	<section style="min-height:400px">
		<h2>Employee Details</h2>
		<table border="1" width="50%" align="center">
			<thead>
				<tr>
					<th>Employee Id</th>
					<th>Employee Name</th>
					<th>Date of Join</th>
					<th>Designation</th>
					<th>Basic Salary</th>
					<th>HRA</th>
					<th>TA</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${emp.empId }</td>
					<td>${emp.empName }</td>
					<td>${emp.dateOfJoin }</td>
					<td>${emp.designation }</td>
					<td>${emp.basic }</td>
					<td>${emp.hra }</td>
					<td>${emp.ta }</td>
				</tr>
			</tbody>
		</table>
	</section>
<jsp:include page="/footer" />