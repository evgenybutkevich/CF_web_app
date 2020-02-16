<#macro login path button>

<form method="post" action="${path}">
    <input name="_csrf" value="${_csrf.token}" type="hidden"/>

    <div class="form-group row mt-4">
        <label class="col-sm-2 col-form-label">Username: </label>
        <div class="col-sm-3">
            <input name="username" class="form-control" type="text" placeholder="username..."/>
        </div>
    </div>

    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Password: </label>
        <div class="col-sm-3">
            <input name="password" class="form-control" type="password" placeholder="password..."/>
        </div>
    </div>

    <button class="btn btn-primary" type="submit">${button}</button>
</form>

</#macro>

<#macro logout>

<form method="post" action="/logout">
    <input name="_csrf" value="${_csrf.token}" type="hidden"/>

    <button class="btn btn-primary" type="submit">Logout</button>
</form>

</#macro>