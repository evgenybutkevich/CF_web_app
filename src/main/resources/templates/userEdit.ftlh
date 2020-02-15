<#import "parts/main.ftlh" as m>
<#import "parts/navbar.ftlh" as n>
<#import "parts/login.ftlh" as l>

<@m.main "Editor">
<@n.navbar/>

<div class="container mt-5">
    <@l.logout/>

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
</div>

</@m.main>