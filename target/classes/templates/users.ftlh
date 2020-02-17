<#import "parts/main.ftlh" as m>

<@m.main "Users">

<h1>Welcome to users page!</h1>

<div>Users list</div>

<table>
    <thead>
        <tr>
            <th>id</th>
            <th>username</th>
            <th>role</th>
        </tr>
    </thead>

    <tbody>
        <#list users as user>
            <tr>
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td><#list user.roles as role>${role}<#sep>, </#list></b>
                <td><a href="/users/${user.id}">edit</a></td>
            </tr>
        </#list>
    </tbody>
</table>

</@m.main>