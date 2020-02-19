<#macro login path buttonName>

<form class="p-3" method="post" action="${path}">
    <input name="_csrf" value="${_csrf.token}" type="hidden"/>

    <div class="form-group row">
        <label class="col-form-label col-2 col-xl-2">Login: </label>

        <div class="col-10 col-sm-6 col-xl-4">
            <input class="form-control" name="username" type="text" placeholder="Login"/>
        </div>
    </div>

    <div class="form-group row">
        <label class="col-form-label col-2 col-xl-2">Password: </label>

        <div class="col-10 col-sm-6 col-xl-4">
            <input class="form-control" name="password" type="password" placeholder="Password"/>
        </div>
    </div>

    <#if path == "/registration">
        <#include "registration.ftlh">
    <#else>
        <p>Click <a href="/registration">here</a> to sign up!</p>
    </#if>

    <button class="btn btn-primary" type="submit">${buttonName}</button>
</form>

</#macro>