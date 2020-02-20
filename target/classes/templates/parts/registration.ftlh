<div class="form-group row">
    <label class="col-form-label col-2 col-xl-2">Email: </label>

    <div class="col-10 col-sm-6 col-xl-4">
        <input class="form-control" name="email" type="email" placeholder="example@example.com"/>

        <div class="text-center text-danger">${email?ifExists}</div>

    </div>
</div>

<div class="form-group row">
    <label class="col-form-label col-2 col-xl-2">First name: </label>

    <div class="col-10 col-sm-6 col-xl-4">
        <input class="form-control" name="first_name" type="text" placeholder="First name"/>
    </div>
</div>

<div class="form-group row">
    <label class="col-form-label col-2 col-xl-2">Last name: </label>

    <div class="col-10 col-sm-6 col-xl-4">
        <input class="form-control" name="last_name" type="text" placeholder="Last name"/>
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

<p>Already have an account? Click <a href="/login">here</a> to sign in!</p>