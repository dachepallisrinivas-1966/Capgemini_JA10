<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<jsp:include page="/header" />
<section style="min-height: 400px">
	<h2>Task List</h2>
	<form>
		<div>
			<label>Task : <input type="text" name="task" required />
			</label>
			<button type="submit" formAction="addTask">Add Task</button>
			<button type="submit" formAction="deleteTask">Delete Task</button>
			<button type="submit" formAction="clearTasks" formNovalidate>Clear</button>
		</div>
	</form>
	<hr />
	<h3>Tasks</h3>
	<ol>
		<c:forEach var="t" items="${tasks}">
			<li>${t }</li>
		</c:forEach>
	</ol>
</section>
<jsp:include page="/footer" />