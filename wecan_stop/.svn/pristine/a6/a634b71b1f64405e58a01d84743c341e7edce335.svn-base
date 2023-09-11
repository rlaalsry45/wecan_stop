function check_survey() {
    var sanity = false;

    if ($(":radio[name^='answer']:checked").length > 0 || $(":checkbox[name^='answer']:checked").length > 0) {
        sanity = true;
    } else {
        $("[id^='text']").each(function () {
            if ($(this).val().length > 0) {
                sanity = true;
                return false;
            }
        });
    }

    if (sanity) {
        document.forms.survey_default.submit();
        return true;
    } else {
        alert("You must select one or more items or enter an answer!");
        return false;
    }
}
