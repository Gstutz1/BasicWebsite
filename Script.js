$(init);

function init() {
    $("#edit").click(function () {
        window.location = "FigureEdit.html";
    });

    $("#figure-form").submit(function (e) {
        e.preventDefault();
        window.location = "FigureView.html";
    })
}
