    <div class="form-group row">
        <label class="col-form-label col-2 col-xl-2">Confirm password: </label>

        <div class="col-10 col-sm-6 col-xl-4">
            <input class="form-control ${(password2Error??)?string('is-invalid', '')}" name="password2" type="password"
                placeholder="confirm password"/>

            <#if password2Error??>
                <div class="invalid-feedback">${password2Error}</div>
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

        <div class="col-8 col-sm-8 col-xl-6">
            <input name="avatar" class="form-control-file" type="file">
        </div>
    </div>

    <p>Already have an account? Click <a href="/login">here</a> to sign in!</p>