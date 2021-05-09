var req = new XMLHttpRequest();
$('.submit').on('click', function(){
    var sentenceForm = {
        id: $(this).parent().children('#_id').val(),
        word: $(this).parent().children('#_word').val(),
        answer: $(this).parent().children('#_answer').val()
    };

    var button = $(this);
    $(this).val('通信中').button('refresh');
    // Ajax通信を開始
    $.ajax({
        url: 'http://localhost:8080/update_sentence',
        type: 'POST',
        contentType: 'application/json',
        data : JSON.stringify(sentenceForm),
        dataType: "json",
        timeout: 5000
    })
    .done(function(data) {
        // 1通信成功時の処理を記述
        if(data){
            button.val("成功").button('refresh');
        } else {
        	button.val("未更新").button('refresh');
        }
        
    })
    .fail(function(data) {
        // 1通信失敗時の処理を記述
        $(this).val("失敗").button('refresh');
    });
});
