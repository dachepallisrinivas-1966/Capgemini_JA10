<jsp:include page="/header" />
	<section style="min-height:400px">
		<h2>Greet Page</h2>
		<form>
			<label>Enter your Name:
				<input type="text" name="uname" required />
			</label>
			<button type="submit">Greet</button>
		</form>
		
		${greetMessage }
	</section>
<jsp:include page="/footer" />