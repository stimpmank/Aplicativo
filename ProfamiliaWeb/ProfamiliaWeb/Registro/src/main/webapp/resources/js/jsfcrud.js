function handleSubmit(args, dialog) {
    var jqDialog = jQuery('#' + dialog);
    if (args.validationFailed) {
        jqDialog.effect('shake', {times: 3}, 100);
    } else {
        PF(dialog).hide();
    }
}

function disableEnterSubmit() {
    $('form').off('keypress.disableAutoSubmitOnEnter').on('keypress.disableAutoSubmitOnEnter', function (event) {
        if (event.which === $.ui.keyCode.ENTER && $(target).is(':input:not(textarea,:button,:submit,:reset)')) {
            event.preventDefault();
        }
    });
}
