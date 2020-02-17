<#import "parts/main.ftlh" as m>

<@m.main "Create campaing">

<h1>Welcome to create campaing page!</h1>

<form method="post">
    <input name="_csrf" value="${_csrf.token}" type="hidden"/>

<!--name-->
    <div class="form-group row">
        <label class="col-sm-2 col-form-label m-0">Campaing name: </label>
        <div class="col-sm-5">
            <input name="name" class="form-control" type="text" placeholder="enter campaing name"/>
        </div>
    </div>

<!--topic-->
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Topic: </label>

        <div class="input-group col-sm-5">
            <select class="custom-select" name="topic">
                <option value="Communication">Communication</option>
                <option value="Electronics">Electronics</option>
                <option value="Education">Education</option>
            </select>
        </div>
    </div>

<!--description-->
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Description: </label>

        <div class="col-sm-5">
            <textarea name="description" class="form-control" rows="3"></textarea>
        </div>
    </div>

<!--amountTotal-->
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Amount: </label>
        <div class="col-sm-5">
            <input name="amountTotal" class="form-control" type="text" placeholder="$$$"/>
        </div>
    </div>

<!--logo-->
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Logo: </label>

        <div class="col-sm-5">
            <input name="logo" class="form-control-file" type="file">
        </div>
    </div>

    <button class="btn btn-primary" type="submit">Create</button>
</form>

</@m.main>