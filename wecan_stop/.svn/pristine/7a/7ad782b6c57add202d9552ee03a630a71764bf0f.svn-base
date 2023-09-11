function LoadEditor(id) {
    var imported = document.createElement('script');
    imported.src = '/var/ckeditor/ckeditor.js';
    document.head.appendChild(imported);

    $.getScript(imported.src, function () {
        CKEDITOR.replace(id, {
            skin          : 'office2013',
            height        : '500px',
            fullPage      : true,
            allowedContent: true,
            toolbar       : [
                {name: 'tools', items: ['Maximize']},
                {
                    name  : 'document',
                    groups: ['mode', 'document', 'doctools'],
                    items : ['Source', '-', 'Preview', 'Print', '-', 'Templates']
                },
                {
                    name  : 'clipboard',
                    groups: ['clipboard', 'undo'],
                    items : ['Cut', 'Copy', 'Paste', 'PasteText', 'PasteFromWord', '-', 'Undo', 'Redo']
                },
                {
                    name  : 'editing',
                    groups: ['find', 'selection', 'spellchecker'],
                    items : ['Find', 'Replace', '-', 'SelectAll', '-', 'Scayt']
                },
                '/',
                {
                    name  : 'basicstyles',
                    groups: ['basicstyles', 'cleanup'],
                    items : ['Bold', 'Italic', 'Underline', 'Strike', 'Subscript', 'Superscript', '-', 'RemoveFormat']
                },
                {
                    name  : 'paragraph',
                    groups: ['list', 'indent', 'blocks', 'align', 'bidi'],
                    items : ['NumberedList', 'BulletedList', '-', 'Outdent', 'Indent', '-', 'Blockquote', '-', 'JustifyLeft', 'JustifyCenter', 'JustifyRight',
                             'JustifyBlock', '-', 'BidiLtr', 'BidiRtl']
                },
                {
                    name : 'links',
                    items: ['Link', 'Unlink', 'Anchor']
                },
                '/',
                {
                    name : 'insert',
                    items: ['Image', 'Table', 'HorizontalRule', 'Smiley', 'SpecialChar', 'PageBreak']
                },
                {name: 'styles', items: ['Styles', 'Format', 'Font', 'FontSize']},
                {name: 'colors', items: ['TextColor', 'BGColor']}
            ],

            filebrowserBrowseUrl: '/var/filemanager/index.jsp',
            enterMode           : CKEDITOR.ENTER_BR,
            language            : 'ko'
        });
    });
}
