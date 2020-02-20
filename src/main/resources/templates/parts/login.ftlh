<#macro login path buttonName>

<form class="p-3" method="post" action="${path}">
    <input name="_csrf" value="${_csrf.token}" type="hidden"/>

    <div class="form-group row">
        <label class="col-form-label col-2 col-xl-2">Login: </label>

        <div class="col-10 col-sm-6 col-xl-4">
            <input class="form-control ${(usernameError??)?string('is-invalid', '')}" name="username" type="text" value="<#if user??>${user.username}</#if>" placeholder="Login"/>

            <#if path == "/registration">
                <#if usernameError??>
                    <div class="invalid-feedback">
                        ${usernameError}
                    </div>
                </#if>
            </#if>
        </div>
    </div>

    <div class="form-group row">
        <label class="col-form-label col-2 col-xl-2">Password: </label>

        <div class="col-10 col-sm-6 col-xl-4">
            <input class="form-control ${(passwordError??)?string('is-invalid', '')}" name="password" type="password" placeholder="Password"/>

            <#if path == "/registration">
                <#if passwordError??>
                    <div class="invalid-feedback">
                        ${passwordError}
                    </div>
                </#if>
            </#if>

            <div class="text-center text-success">${active?ifExists}</div>
            <div class="text-center text-danger">${inactive?ifExists}</div>
        </div>
    </div>

    <#if path == "/registration">
        <#include "registration.ftlh">
    <#else>
        <p>Don't have an account? Click <a href="/registration">here</a> to sign up!</p>
    </#if>

    <button class="btn btn-primary" type="submit">${buttonName}</button>
</form>

</#macro>