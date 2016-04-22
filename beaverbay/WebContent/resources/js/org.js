$(function () {  
    $(".region").each(function(key, value) {
        var regionId = $(value).attr("data-region-id");
        
        $(value).click(function (event) {
            $.get("/pepsi/getlocations/" + regionId, function(response) {
                var locations = response.data.locations;
                $(locations).each(function() {
                    var locLi = $('<li></li>').addClass("list-group-item").html($(this)[0].groupName);
                    $("#locationList").append(locLi);
                });
            });
            
            //clear out the location dropdown
            $("#locationList").remove();
            //add an ul element to holde the li from locations
            var locUl = $('<ul></ul>').addClass("dropdown-menu").attr("id", "locationList").attr("role", "menu");
            $("#locationDropdown").append(locUl);
            
        });
    });
});