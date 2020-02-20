<#import "parts/main.ftlh" as m>

<@m.main "Create campaign">

<h1>Create page!</h1>

<form class="p-3" method="post">
    <input name="_csrf" value="${_csrf.token}" type="hidden"/>

    <div class="form-group row">
        <label class="col-form-label col-4 col-xl-2">Campaign name: </label>

        <div class="col-8 col-sm-8 col-xl-6">
            <input class="form-control" name="campaignName" type="text" placeholder="Campaign name"/>
        </div>
    </div>

    <div class="form-group row">
        <label class="col-form-label col-4 col-xl-2">Topic: </label>

        <div class="input-group col-8 col-sm-8 col-xl-6">
            <select class="custom-select" name="topic">
                <#list topics as topics>
                <option value="${topics.topicName}">${topics.topicName}</option>
            </#list>
            </select>
        </div>
    </div>

    <div class="form-group row">
        <label class="col-form-label col-4 col-xl-2">Description: </label>

        <div class="col-8 col-sm-8 col-xl-6">
            <textarea class="form-control" name="description" rows="3" placeholder="Description"></textarea>
        </div>
    </div>

    <div class="form-group row">
        <label class="col-form-label col-4 col-xl-2">Amount (USD): </label>

        <div class="col-8 col-sm-8 col-xl-6">
            <input class="form-control" name="amountTotal" type="text" placeholder="Amount (USD)"/>
        </div>
    </div>

    <div class="form-group row">
        <label class="col-form-label col-4 col-xl-2">Date of expiry: </label>

        <div class="col-8 col-sm-8 col-xl-6">
            <input class="form-control" name="expiry_date" id="expiry_date"/>
            <script>
                $('#expiry_date').datepicker({
                    uiLibrary: 'bootstrap4',
                    format: 'dd.mm.yyyy'
                });
            </script>
        </div>
    </div>

    <div class="form-group row">
        <label class="col-form-label col-4 col-xl-2">Logo: </label>

        <div class="col-8 col-sm-8 col-xl-6">
            <input class="form-control-file" name="logo" type="file">
        </div>
    </div>

    <button class="btn btn-primary" type="submit">Create</button>
</form>

</@m.main>