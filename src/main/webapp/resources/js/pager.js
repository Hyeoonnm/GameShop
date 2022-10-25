function make_row(item) {
    const tr = $("<tr>");

    tr.attr("data-id", item.id);

    const td_id = $("<td>");
    // update에 변경 버튼 누를 시 값을 받아오기 위해 사용
    td_id.addClass("id");
    // ==
    td_id.text(item.id);
    tr.append(td_id);

    const td_name = $("<td>")
    // update
    td_name.addClass("name");
    // ==
    td_name.text(item.name);
    tr.append(td_name);

    const td_nameEng = $("<td>")
    // update
    td_nameEng.addClass("name_eng");
    // ==
    td_nameEng.text(item.nameEng);
    tr.append(td_nameEng);

    const td_url = $("<td>")
    // update
    td_url.addClass("url");
    // ==
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
}

// 모달 닫기 펑션
function close_modal() {
    $(".modal").addClass("empty_list");
}


$(function () {
    // cancel 버튼 클릭시
    $(".cancel").click(e => {
        close_modal();
    });

    // add버튼 클릭시 이벤트
    $("#add").click(e => {
        close_modal();
        $("#add_modal").removeClass("empty_list");
    });

    // add submit 버튼 클릭시 이벤트
    $("#add_modal .submit").click(e => {
        close_modal();

        const item = {
            name: $("#add_modal input[name='name']").val(),
            nameEng: $("#add_modal input[name='nameEng']").val(),
            url: $("#add_modal input[name='url']").val(),
        };
        console.log(item);

        $.ajax("/api/publisher", {
            method: "POST",
            contentType: "application/json",
            dataType: "json",
            data: JSON.stringify(item),
            success: result => {
                console.log(result);
                if (result.id) {
                    // input 값 초기화
                    $("#add_modal input").val("");

                    $("#empty_list").addClass("empty_list");
                    make_row(result);
                    close_modal();
                }
            }
        });
    });


    // json 삭제
    $("tbody").on("click", ".delete", function (e) {

        const button = $(e.target);
        const tr = button.closest("tr");

        console.log(`삭제 ${tr.data("id")}`);

        const item = {
            id: tr.data("id")
        };

        $.ajax("/api/publisher", {
            method: "DELETE",
            contentType: "application/json",
            dataType: "json",
            data: JSON.stringify(item),
            success: result => {
                console.log(result);

                tr.remove();

                const list = $("#list > tr");

                if (list.length == 1) {
                    $("#empty_list").removeClass("empty_list");
                }
            }
        });
    });

    // json update 클릭시
    $("tbody").on("click", ".update", function (e) {
        close_modal();

        const button = $(e.target);
        const tr = button.closest("tr");

        console.log(`변경 ${tr.data("id")}`);

        $("#update_modal").removeClass("empty_list");

        $("#update_modal input[name='id']").val(tr.data("id"));

        const name = tr.find(".name").text();
        $("#update_modal input[name='name']").val(name);

        const nameEng = tr.find(".name_eng").text();
        $("#update_modal input[name='nameEng']").val(nameEng);

        const url = tr.find(".url").text();
        $("#update_modal input[name='url']").val(url);

    });


// update submit 클릭시
    $("#update_modal .submit").click(e => {
        const item = {
            id: $("#update_modal input[name = id]").val(),
            name: $("#update_modal input[name = name]").val(),
            nameEng: $("#update_modal input[name = nameEng]").val(),
            url: $("#update_modal input[name = url]").val()
        };


        console.log(item);

        $.ajax("/api/publisher", {
            method: "PUT",
            contentType: "application/json",
            dataType: "json",
            data: JSON.stringify(item),
            success: result => {
                console.log(result);

                $(`tr[data-id='${result.id}'] td.name`).text(result.name);
                $(`tr[data-id='${result.id}'] td.name_eng`).text(result.nameEng);
                $(`tr[data-id='${result.id}'] td.url`).text(result.url);

                close_modal();


            }
        });
    });

// 리스트 호출 ajax
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

            // if(result.length >= 1 ) {
            //     $("#list").html("");

            if (result.length > 0)
                $("#empty_list").addClass("empty_list");
            else
                $("#empty_list").removeClass("empty_list");

            result.forEach(item => {
                make_row(item);
            });
            // }
            // else {
            //     return
            // }
            console.log(result);

        },
        // error :

    });

});