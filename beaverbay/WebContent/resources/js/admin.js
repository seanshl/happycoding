(function() {
    $(document).ready(function() {
        $('#personTable').DataTable({
            responsive : true
        });        
    });

    $('body').on('hidden.bs.modal', '.modal', function() {
        $(this).removeData('bs.modal');
    });
    
    $("#inactiveCheckbox").change(function() {
        if (this.checked) {
           window.location = '/pepsi/admin?includeInactive=true';
           $("#inactiveCheckbox").attr("checked", true);
        } else {
            window.location = '/pepsi/admin';
            $("#inactiveCheckbox").attr("checked", false);
        }
    });
}) ();