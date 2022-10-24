$(function () {
    $("tbody").on("click", ".delete", function (e) {

        const button = $(e.target);
        const tr = button.closest("tr");

        console.log(`삭제 ${tr.data("id")}`);
    });


    $("tbody").on("click", ".update", function (e) {

        const button = $(e.target);
        const tr = button.closest("tr");

        console.log(`변경 ${tr.data("id")}`);
    });
    $.ajax("/api/publisher", {
        method: "GET",
        contentType: "application/json",
        dataType: "json",
        success: result => {

            //STRING < - > OBJECT
            // O ---> S
            // 문자열 = JSON.stringify(O)

            // S ---> O
            /*const list =  JSON.parse(result);*/

            result.forEach(item => {
                const tr = $("<tr>");

                tr.attr("data-id", item.id);

                const td_id = $("<td>");
                td_id.text(item.id);
                tr.append(td_id);

                const td_name = $("<td>")
                td_name.text(item.name);
                tr.append(td_name);

                const td_nameEng = $("<td>")
                td_nameEng.text(item.nameEng);
                tr.append(td_nameEng);

                const td_url = $("<td>")
                td_url.text(item.url);
                tr.append(td_url);

                const td_manager = $("<td>")

                const button_update = $("<button>")
                button_update.text("변경");
                button_update.addClass("update");
                td_manager.append(button_update);

                const button_delete = $("<button>")
                button_delete.text("삭제");
                button_delete.addClass("delete");
                td_manager.append(button_delete);

                tr.append(td_manager);

                $("#list").append(tr);
            });

            console.log(result);
        },
        // error :
    });
});