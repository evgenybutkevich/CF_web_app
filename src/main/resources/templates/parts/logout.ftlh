<form method="post" action="/logout">
    <input name="_csrf" value="${_csrf.token}" type="hidden"/>

    <button class="btn btn-primary" type="submit">Logout</button>
</form>