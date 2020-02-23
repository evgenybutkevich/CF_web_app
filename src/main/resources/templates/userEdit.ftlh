<#import "parts/main.ftlh" as m>

<@m.main "User ${user.id}">

<h1>User ${user.id} page! <a href="/users/view/${user.id}">VIEW</a></h1>

<form class="p-3" method="post" action="/users/edit/${user.id}">
    <input name="_csrf" value="${_csrf.token}" type="hidden"/>

    <div class="form-group row">
        <label class="col-form-label col-2 col-xl-2">Login: </label>

        <div class="col-10 col-sm-6 col-xl-4">
            <input class="form-control ${(usernameError??)?string('is-invalid', '')}" name="username" type="text"
                   value="<#if user??>${user.username}</#if>"
                   placeholder="enter login (30 characters max)"/>

            <#if usernameError??>
                <div class="invalid-feedback">${usernameError}</div>
            </#if>
        </div>
    </div>

    <div class="form-group row">
        <label class="col-form-label col-2 col-xl-2">Email: </label>

        <div class="col-10 col-sm-6 col-xl-4">
            <input class="form-control ${(emailError??)?string('is-invalid', '')}" name="email" type="email"
                   value="<#if user??>${user.email}</#if>" placeholder="example@example.com"/>

            <#if emailError??>
                <div class="invalid-feedback">${emailError}</div>
            </#if>
        </div>
    </div>

    <div class="form-group row">
        <label class="col-form-label col-2 col-xl-2">Registration date: </label>

        <label class="col-form-label col-10 col-sm-6 col-xl-4">${user.stringRegistrationDate}</label>
    </div>

    <div class="form-group row">
        <label class="col-form-label col-2 col-xl-2">First name: </label>

        <div class="col-10 col-sm-6 col-xl-4">
            <input class="form-control ${(firstNameError??)?string('is-invalid', '')}" name="firstName" type="text"
                   value="<#if user??>${user.firstName}</#if>" placeholder="enter first name (30 characters max)"/>

            <#if firstNameError??>
                <div class="invalid-feedback">${firstNameError}</div>
            </#if>
        </div>
    </div>

    <div class="form-group row">
        <label class="col-form-label col-2 col-xl-2">Last name: </label>

        <div class="col-10 col-sm-6 col-xl-4">
            <input class="form-control ${(lastNameError??)?string('is-invalid', '')}" name="lastName" type="text"
                   value="<#if user??>${user.lastName}</#if>" placeholder="enter last name (50 characters max)"/>

            <#if lastNameError??>
                <div class="invalid-feedback">${lastNameError}</div>
            </#if>
        </div>
    </div>

    <div class="form-group row">
        <label class="col-form-label col-4 col-xl-2">Sex: </label>

        <div class="input-group col-10 col-sm-6 col-xl-4">
            <select class="custom-select" name="sex">
                <option value="male">male</option>
                <option value="female">female</option>
            </select>
        </div>
    </div>

    <div class="form-group row">
        <label class="col-form-label col-2 col-xl-2">Date of Birth: </label>

        <div class="col-10 col-sm-6 col-xl-4">
            <input class="form-control" name="birthday" id="birthday"/>
            <script>
                    $('#birthday').datepicker({
                        uiLibrary: 'bootstrap4',
                        format: 'dd.mm.yyyy'
                    });
            </script>
        </div>
    </div>

    <div class="form-group row">
        <label class="col-form-label col-2 col-xl-2">Avatar: </label>

        <div class="col-10 col-sm-6 col-xl-4">
            <div class="custom-file">
                <input class="custom-file-input" name="avatar" type="file" id="file">
                <label class="custom-file-label" for="file">Choose file</label>
            </div>
        </div>
    </div>

    <div class="form-group row">
        <label class="col-form-label col-2 col-xl-2">Roles: </label>

        <label class="col-form-label col-10 col-sm-6 col-xl-4">

            <#list roles as role>
                <div class="form-check">
                    <input class="form-check-input" name="${role}" type="checkbox" id="id_${role}" ${user.roles?seq_contains(role)?string('checked', '')}>
                    <label class="form-check-label" for="id_${role}">${role}</label>
                </div>
            </#list>
        </label>
    </div>

    <div class="form-group row">
        <label class="col-form-label col-4 col-xl-2">Active: </label>

        <div class="input-group col-10 col-sm-6 col-xl-4">
            <select class="custom-select" name="active">
                <option value=1>active</option>
                <option value=0>inactive</option>
            </select>
        </div>
    </div>

    <button class="btn btn-primary" type="submit">Submit</button>
</form>

</@m.main>