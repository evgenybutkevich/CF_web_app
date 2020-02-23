<#import "parts/main.ftlh" as m>

<@m.main "Users">

<h1>Users page!</h1>

<form class="p-3">
    <table class="table">
        <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Login</th>
                <th scope="col">Registration date</th>
                <th scope="col">First name</th>
                <th scope="col">Last name</th>
                <th scope="col">Role</th>
                <th scope="col">Status</th>
                <th scope="col"></th>
            </tr>
        </thead>

        <tbody>
            <#list usersAll as user>
                <tr>
                    <th scope="row">${user.id}</th>
                    <td><b>${user.username}</b></td>
                    <td>${user.stringRegistrationDate}</td>
                    <td>${user.firstName}</td>
                    <td>${user.lastName}</td>
                    <td><#list user.roles as role>${role}<#sep>, </#list></b>
                    <td>${user.active?string('active', 'inactive')}</td>
                    <td>
                        <a href="/users/view/${user.id}"><b>VIEW</b></a>,
                        <a href="/users/edit/${user.id}"><b>EDIT</b></a>
                    </td>
                </tr>
            </#list>
        </tbody>
</table>

</@m.main>