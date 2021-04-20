<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<jsp:include page="/header" />
	<section style="min-height:400px">
		<h2>Employee Page</h2>
		
		<form:form method="post" modelAttribute="emp">
			<div> 
				<form:label path="empId">Employee Id:</form:label>
				<form:input path="empId" type="number" />
			</div>
			
			<div> 
				<form:label path="empName">Employee Name:</form:label>
				<form:input path="empName" type="text" />
			</div>
			
			<div> 
				<form:label path="dateOfJoin">Date of Join:</form:label>
				<form:input path="dateOfJoin" type="date" />
			</div>
			
			<div>
				<form:label path="designation">Designation:</form:label>
				<form:select path="designation">
					<form:options items="${designations}" />
				</form:select>
			</div>
			
			<div> 
				<form:label path="basic">Basic Salary:</form:label>
				<form:input path="basic" type="number" />
			</div>
			
			<div>
				<button type="submit">Submit</button>
			</div>
		
		</form:form>
		
		
	</section>
<jsp:include page="/footer" />