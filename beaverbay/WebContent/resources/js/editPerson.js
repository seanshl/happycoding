function onLoad() {
    $("#changePassword").change(function() {
        if (this.checked) {
            $("#password-div").removeClass('hidden');
            $("#confirmPassword-div").removeClass('hidden');
        } else {
            $("#password-div").addClass('hidden');
            $("#confirmPassword-div").addClass('hidden');
        }
    });
    
    //check valid input on runtime
    $("#userName").blur(checkUserName);
    
    $("#lastName").blur(function() {
        checkField("lastName");
    });
    $("#firstName").blur(function() {
        checkField("firstName");
    });
    $("#password").blur(function() {
        checkField("password");
        checkPasswordsMatch();
    });
    $("#confirmPassword").blur(function() {
        checkPasswordsMatch();    
    })
    
    $("#registerForm").submit(canSubmit);   
}

function canSubmit() {
    var validated = true;
    
    var userName = $("#userName").val();
    var firstName = $("#firstName").val();
    var lastName = $("#lastName").val();
    var password = $("#password").val();
    var confirmPassword = $("#confirmPassword").val();
    
    //when edit a person
    var editUserName = $("#editUserName").val();
    
    //check if the userName error message which appearred before is still there. 
    if ($("#userName-error-msg").text().trim() != "") {
        validated = false;
    }       
    
    //when it's editing the user, only check the editUserName field.
    if (!(editUserName == null || editUserName == undefined || editUserName.trim() == "")) {
        if (isValid(editUserName, "editUserName") == false) {
            validated = false;
        }
    } else {
        if (isValid(userName, "userName") == false) {
            validated = false;
        }
    }
    
    //Here must use & not && because isValid also add feedback to the input fields.
    if(!(isValid(firstName, "firstName") == true
            & isValid(lastName, "lastName") == true & isValid(confirmPassword, "confirmPassword") == true
            & isValid(password, "password") == true)) {   
        validated = false;
    }
    
    if(password != confirmPassword) {
        addFeedback("password", false);
        addFeedback("confirmPassword", false, "Passwords must match");
        alert("Passwords must match");
        validated = false;
    }
    
    return validated;
}

function isValid(value, fieldName) {
    clearFeedback(fieldName);
    if (value == undefined || value == null || value.trim() == "") {
        addFeedback(fieldName, false, "This field is required");
        return false;
    } else {
        if (fieldName == "password" && value.length <= 3) {
            addFeedback(fieldName, false, "The length of password is too short");
            return false;
        }
        return true;
    }
}

function checkPasswordsMatch() {
    var password = $("#password").val();
    var confirmPassword = $("#confirmPassword").val();
    
    clearFeedback("confirmPassword");
    if (password != confirmPassword) {
        addFeedback("confirmPassword", false, "Passwords must match");
    } else if (password != undefined && password != null && password.trim() != ""){
        addFeedback("confirmPassword", true);
    }
}

/**
 * This method is used to dynamically give feedback to user if the userName is 
 * already existed.
 */
function checkUserName() {
    debugger
    var userName = $("#userName").val();
    //check if userName is undefined
    if (userName == undefined || userName == "" || userName == null) {
        return;
    }

    clearFeedback("userName");
    if (userName.indexOf(" ") != -1) {
        addFeedback("userName", false, "Please make sure your email doesn't contain blank");
    }  
    
    var url;
    var param;
    
    //when the dom "editPersonId" is existed, we already have a personId for the being-edited person
    if ($("#editPersonId").attr("data-person-id")) {
        url = "/beaverbay/checkEditUserName"
        var personId = $("#editPersonId").attr("data-person-id");
        
        param = {userName: userName,
                personId: personId};
    } else {
        url = "/beaverbay/checkUserName/";
        param = {userName: userName};
    }
    
    $.get(url, param, function(response) {
        if (response.responseType == 'Success') {
            addFeedback("userName", true);
        } else {
            addFeedback("userName", false, "Email already existed, please change the email");
        }
    });
}

/**
 * This method is used to check fields, since these two 
 * only need to check valid value without going to the server.
 * @param field
 */
function checkField(fieldName) {
    var value = $("#" + fieldName).val();
    clearFeedback(fieldName);
    
    if (value == undefined || value == "" || value == null) {
        return;
    } else {
        if (fieldName == 'password' && value.length <= 3) {
            addFeedback(fieldName, false, "The length of password is too short");
        } else {
            addFeedback(fieldName, true);
        }
    }
}

function clearFeedback(fieldName) {
    var divId = fieldName + "-div";
    var glyphiconId = fieldName + "-glyphicon";
    var errorId = fieldName + "-error";
    
    $("#" + divId).removeClass().addClass("form-group");
    $("#" + glyphiconId).remove();
    $("#" + errorId).empty();    
}

function addFeedback(fieldName, success, errorMsg) {
    var divId = fieldName + "-div";
    var glyphiconId = fieldName + "-glyphicon";
    var errorId = fieldName + "-error";
    
    if (success == true) {
        $("#" + divId).addClass("has-success has-feedback");
        var glyphicon = $("<span></span>")
        .addClass("glyphicon glyphicon-ok form-control-feedback")
        .attr("id", glyphiconId);
        $("#" + divId).append(glyphicon);
    } else if (success == false) {
        $("#" + divId).addClass("has-error has-feedback");
        var glyphicon = $("<span></span>")
                .addClass("glyphicon glyphicon-remove form-control-feedback")
                .attr("id", glyphiconId);      
        $("#" + divId).append(glyphicon);     
        var message = $("<p></p>").addClass("text-danger").attr("id", fieldName + "-error-msg").text(errorMsg);
        $("#" + errorId).append(message);
    }
}


$(document).ready(onLoad);