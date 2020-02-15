<#macro login path>

<form method="post" action="${path}">
    <input name="_csrf" value="${_csrf.token}" type="hidden"/>
    <div>
        <label>Username: <input name="username" type="text" placeholder="username..."/></label>
    </div>
    <div>
        <label>Password: <input name="password" type="password" placeholder="password..."/></label>
    </div>
    <div>
        <button type="submit">Submit</button>
    </div>
</form>

</#macro>

<#macro logout>

<form method="post" action="/logout">
    <input name="_csrf" value="${_csrf.token}" type="hidden"/>
    <div>
        <button type="submit">Logout</button>
    </div>
</form>

</#macro>