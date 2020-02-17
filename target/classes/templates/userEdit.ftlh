<#import "parts/main.ftlh" as m>

<@m.main "Editor">

<form method="post" action="/users">
    <input name="_csrf" value="${_csrf.token}" type="hidden"/>
    <div>
        <input name="userId" type="hidden" value="${user.id}"/></label>
    </div>
    <div>
        <input name="username" type="text" value="${user.username}"/></label>
    </div>
    <#list roles as role>
        <div>
            <label><input name="${role}" ${user.roles?seq_contains(role)?string("checked", "")} type="checkbox" >${role}</label>
        </div>
    </#list>
    <div>
        <button type="submit">Submit</button>
    </div>
</form>

</@m.main>