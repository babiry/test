var list = paramlist;
var count=0;

var req = new XMLHttpRequest();

$('#btnsend').on('click', function(){
      $('#result').text('通信中...');
      // Ajax通信を開始
      $.ajax({
        url: 'csvwirte',
        type: 'GET',
        dataType: 'json',
        // 1フォーム要素の内容をハッシュ形式に変換
        data: $('form').serializeArray(),
        timeout: 5000,
      })
      .done(function(data) {
          // 1通信成功時の処理を記述
          var req;
          $('#result').text(data[0].value + data[0].count);
      })
      .fail(function() {
          // 1通信失敗時の処理を記述
      });
});
$(document).ready(function(){
    writePronlem(count);
      $("input[type=text]").keypress(function(ev) {
        if ((ev.which && ev.which === 13) ||
            (ev.keyCode && ev.keyCode === 13)) {

            // 回答を確認
            if (this.value != list[count].value) {
                // 間違っていたら間違いを強調させたい
                $('#ngMessage').text("不正解");
                $('#function1').text(this.value);
                this.value = "";
                return false;
            }
            // カウント更新
            count++;
            if (count > questionNumber) {
                //　カウント値が問題数を超えたら結果をCSVに書き込んで終了の文言
                return true;
            }
            // 合っていたらテキストの値をクリアして次の問題へ
            this.value = "";
            cleanStr();
            // 超えないなら次の問題
            writePronlem(count);
            return false;
        } else {
          return true;
        }
      });
    });

function cleanStr() {
    $('#ngMessage').text("");
    $('#function1').text("");
}
function writePronlem(num) {
    var no = num+1;
    $('#title').text("問題" +no );
    $('#counter').text(no　+"/"+ questionNumber + "問目");
    $('#problem').text(list[num].param);
    //   問題は後で消す!!
    //$('#function1').text(list[num].value);
}
